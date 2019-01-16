package com.creditcard.app.ccapp.com.credicard.app.ccapp.service;

import com.creditcard.app.ccapp.com.credicard.app.ccapp.CreditCardServiceEnum;
import com.creditcard.app.ccapp.com.credicard.app.ccapp.dao.CreditCardDao;
import com.creditcard.app.ccapp.com.credicard.app.ccapp.entity.CreditCardEntity;
import com.creditcard.app.ccapp.com.credicard.app.ccapp.vo.CreditCardInfo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreditCardService {

    @Autowired
    CreditCardDao creditCardDao;

    public CreditCardInfo saveCreditCard(CreditCardInfo creditCardInfo){
        ModelMapper modelMapper = new ModelMapper();
        CreditCardEntity creditCardEntity = modelMapper.map(creditCardInfo, CreditCardEntity.class);
        determineCardInformation(creditCardEntity);
        creditCardDao.persist(creditCardEntity);
        return modelMapper.map(creditCardEntity,CreditCardInfo.class);
    }

    private void determineCardInformation(CreditCardEntity creditCardEntity) {
        String creditCardNumber = creditCardEntity.getCardNumber();
        long nineDigitsCardNumber = Long.parseLong(creditCardNumber.substring(0,9));
        if(creditCardNumber.startsWith("455561")){
            creditCardEntity.setCardType("VISA");
            creditCardEntity.setCardSubType("DEBIT");
        }else if(creditCardNumber.startsWith("387765")){
            creditCardEntity.setCardType("AMEX");
            creditCardEntity.setCardSubType("CREDIT");
        }else if(creditCardNumber.startsWith("454545")){
            creditCardEntity.setCardType("VISA");
            creditCardEntity.setCardSubType("CREDIT");
        }else if(creditCardNumber.startsWith("546626")){
            creditCardEntity.setCardType("MC");
            creditCardEntity.setCardSubType("CREDIT");
        }else if(444433333 <= nineDigitsCardNumber && nineDigitsCardNumber  <= 444532332){
            creditCardEntity.setCardType("VISA");
            creditCardEntity.setCardSubType("PREMIUM CREDIT");
        }else if(512176622 <= nineDigitsCardNumber && nineDigitsCardNumber  <= 512189239){
            creditCardEntity.setCardType("MC");
            creditCardEntity.setCardSubType("GOLD CREDIT");
        }else if(546626193 <= nineDigitsCardNumber && nineDigitsCardNumber  <= 546691237){
            creditCardEntity.setCardType("MC");
            creditCardEntity.setCardSubType("BUSINESS");
        }else{
            creditCardEntity.setCardSubType("UNKNOWN");
            creditCardEntity.setCardType("UNKNOWN");
        }
    }

    public List<CreditCardInfo> getAllCreditCards(){
        ModelMapper modelMapper = new ModelMapper();
        List<CreditCardEntity> list = creditCardDao.getAllCreditCard();
        List<CreditCardInfo> returnList = new ArrayList<>();
        for(CreditCardEntity entity :list ){
            returnList.add(modelMapper.map(entity,CreditCardInfo.class));
        }
        return returnList;
    }

    public List<CreditCardInfo> searchCreditCard(CreditCardInfo creditCardInfo){
        ModelMapper modelMapper = new ModelMapper();
        CreditCardEntity creditCardEntity = modelMapper.map(creditCardInfo, CreditCardEntity.class);
        List<CreditCardEntity> list = creditCardDao.find(creditCardEntity);
        List<CreditCardInfo> returnList = new ArrayList<>();
        for(CreditCardEntity entity :list ){
            returnList.add(modelMapper.map(entity,CreditCardInfo.class));
        }
        return returnList;
    }

    public void updateCreditCard(CreditCardInfo creditCardInfo){
        ModelMapper modelMapper = new ModelMapper();
        CreditCardEntity creditCardEntity = modelMapper.map(creditCardInfo, CreditCardEntity.class);
        creditCardDao.update(creditCardEntity);
    }

    public void deleteCreditCard(CreditCardInfo creditCardInfo){
        ModelMapper modelMapper = new ModelMapper();
        CreditCardEntity creditCardEntity = modelMapper.map(creditCardInfo, CreditCardEntity.class);
        creditCardDao.delete(creditCardEntity);
    }

    public boolean isCreditCardExists(CreditCardInfo creditCardInfo){
        ModelMapper modelMapper = new ModelMapper();
        CreditCardEntity creditCardEntity = modelMapper.map(creditCardInfo, CreditCardEntity.class);
        return creditCardDao.find(creditCardEntity).size() >0;
    }

}
