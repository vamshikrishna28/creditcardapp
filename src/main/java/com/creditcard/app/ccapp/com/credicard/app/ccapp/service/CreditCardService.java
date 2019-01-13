package com.creditcard.app.ccapp.com.credicard.app.ccapp.service;

import com.creditcard.app.ccapp.com.credicard.app.ccapp.dao.CreditCardDao;
import com.creditcard.app.ccapp.com.credicard.app.ccapp.vo.CreditCardInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreditCardService {

    @Autowired
    CreditCardDao creditCardDao;

    public void saveCreditCard(CreditCardInfo creditCardInfo){
        creditCardDao.persist(creditCardInfo);
    }

    public List<CreditCardInfo> searchCreditCard(CreditCardInfo creditCardInfo){
        return creditCardDao.getCreditCard(creditCardInfo);
    }

    public void updateCreditCard(CreditCardInfo creditCardInfo){
        creditCardDao.update(creditCardInfo);
    }

    public void deleteCreditCard(CreditCardInfo creditCardInfo){
        creditCardDao.delete(creditCardInfo);
    }

    public boolean isCreditCardExists(CreditCardInfo creditCardInfo){
        return false;
    }

}
