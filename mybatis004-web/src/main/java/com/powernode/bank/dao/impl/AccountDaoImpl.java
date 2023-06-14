package com.powernode.bank.dao.impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.utils.SqlsessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectByActno(String actno) {
        SqlSession sqlSession = SqlsessionUtil.openSession();
        Account account = (Account) sqlSession.selectOne("account.selectByActno", actno);

        return account;
    }

    @Override
    public int updateByActno(Account act) {
        SqlSession sqlSession = SqlsessionUtil.openSession();
        int updatenum = sqlSession.update("account.pdateByActno", act);

        return updatenum;
    }
}
