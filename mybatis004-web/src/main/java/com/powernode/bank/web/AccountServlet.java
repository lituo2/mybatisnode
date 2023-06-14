package com.powernode.bank.web;

import com.powernode.bank.exceptions.FailureException;
import com.powernode.bank.exceptions.MoneyNotEnoughException;
import com.powernode.bank.service.AccountService;
import com.powernode.bank.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fromActno = req.getParameter("fromActno");
        String toActno = req.getParameter("toActno");
        double money = Double.parseDouble(req.getParameter("money"));
        try {
            accountService.transfer(fromActno, toActno, money);
            resp.sendRedirect(req.getContextPath() + "/success.html");
        } catch (MoneyNotEnoughException e) {
            resp.sendRedirect(req.getContextPath() + "/error.html");
        } catch (FailureException e) {
            resp.sendRedirect(req.getContextPath() + "/error2.html");
        }


    }
}
