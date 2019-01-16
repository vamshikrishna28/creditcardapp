package com.creditcard.app.ccapp.com.credicard.app.ccapp.dao;

import com.creditcard.app.ccapp.com.credicard.app.ccapp.entity.CreditCardEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CreditCardDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public CreditCardEntity persist(CreditCardEntity creditCardInfo){
        getSession().persist(creditCardInfo);
        return creditCardInfo;
    }

    public List<CreditCardEntity> getAllCreditCard(){
        return getSession().createQuery("select cc from CreditCardEntity cc",CreditCardEntity.class).getResultList();
    }

    public void delete(CreditCardEntity creditCardInfo){
        getSession().remove(creditCardInfo);
    }

    public void update(CreditCardEntity creditCardInfo){
        getSession().merge(creditCardInfo);
    }

    public List<CreditCardEntity> find(CreditCardEntity creditCardInfo){
        Query query = getSession().createQuery("select cc from CreditCardEntity cc where cc.cardNumber = :cardNumber");
        query.setParameter("cardNumber", creditCardInfo.getCardNumber());
        return query.getResultList();
    }

}
