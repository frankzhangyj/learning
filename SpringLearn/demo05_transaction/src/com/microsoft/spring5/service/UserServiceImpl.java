package com.microsoft.spring5.service;

import com.microsoft.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

@Service
// propagation代表传播类型常用三个
// isolation代表隔离级别共四个 默认级别为REPEATABLE_READ
// timeout代表事务进行的时间(秒)限制 默认为-1
// readOnly只读默认为false(可以增删改查) 如果为true只能查
// rollbackFor代表如果出现定义的异常进行回滚
// noRollbackFor代表设置那些异常不回滚
//@Transactional(propagation = REQUIRED, isolation = Isolation.REPEATABLE_READ, timeout = -1, readOnly = false, rollbackFor = Exception.class, noRollbackFor = Exception.class)
public class UserServiceImpl {
    @Autowired
    public UserDao userDao;

    /**
     * 编程式事务 比较冗余
     */
    public void accountMoney() {
        try {
            //第一步 开启事务

            // 第二步 进行转账业务
            userDao.addMoney();
            // 可能出现异常
            // i = i / 0
            userDao.reduceMoney();
            // 第三步 如果没有异常提交事务
        } catch (Exception e) {
            // 第四步 如果有异常回滚事务
            throw new RuntimeException(e);
        }
    }

    /**
     * 声明式事务 其底层原理是AOP
     */
    @Transactional // 开启注解事务 标记在类上就是全部方法都开启事务
    public void accountMoneyByAnno() {
        userDao.addMoney();
        int i = 1 / 0;
        userDao.reduceMoney();
    }

    public void accountMoneyByXml() {
        userDao.addMoney();
        userDao.reduceMoney();
    }
}
