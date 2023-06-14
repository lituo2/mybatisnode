package com.powernode.bank.service;

import com.powernode.bank.exceptions.FailureException;
import com.powernode.bank.exceptions.MoneyNotEnoughException;

public interface AccountService {

    void transfer(String fromactno, String toactno, double money) throws MoneyNotEnoughException, FailureException;

}
