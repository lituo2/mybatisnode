package com.powernode.bank.service.impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.dao.impl.AccountDaoImpl;
import com.powernode.bank.exceptions.FailureException;
import com.powernode.bank.exceptions.MoneyNotEnoughException;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    @Override
    public void transfer(String fromactno, String toactno, double money) throws MoneyNotEnoughException, FailureException {
        Account fromAct = accountDao.selectByActno(fromactno);
        if (fromAct.getBalance() < money) {
            throw new MoneyNotEnoughException("对不起，您的余额不足");
        }

        Account toAct = accountDao.selectByActno(toactno);
        fromAct.setBalance(fromAct.getBalance() - money);
        fromAct.setBalance(toAct.getBalance() + money);
        int count = accountDao.updateByActno(fromAct);
        count += accountDao.updateByActno(toAct);
        if (count != 2) {
            throw new FailureException("转账失败");
        }
    }
}
