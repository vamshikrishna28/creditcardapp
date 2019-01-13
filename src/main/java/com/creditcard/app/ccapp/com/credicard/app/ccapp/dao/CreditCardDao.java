package com.creditcard.app.ccapp.com.credicard.app.ccapp.dao;

import com.creditcard.app.ccapp.com.credicard.app.ccapp.entity.CreditCardEntity;
import com.creditcard.app.ccapp.com.credicard.app.ccapp.vo.CreditCardInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CreditCardDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void persist(CreditCardInfo creditCardInfo){
        getSession().persist(creditCardInfo);
    }

    public List<CreditCardInfo> getCreditCard(CreditCardInfo creditCardInfo){
        return getSession().createQuery("").getResultList();
    }

    public void delete(CreditCardInfo creditCardInfo){
        getSession().remove(creditCardInfo);
    }

    public void update(CreditCardInfo creditCardInfo){
        getSession().merge(creditCardInfo);
    }

    public void find(CreditCardInfo creditCardInfo){
        getSession().find(CreditCardEntity.class,creditCardInfo);
    }

}
