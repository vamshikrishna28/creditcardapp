package com.creditcard.app.ccapp.service;

import com.creditcard.app.ccapp.com.credicard.app.ccapp.dao.CreditCardDao;
import com.creditcard.app.ccapp.com.credicard.app.ccapp.entity.CreditCardEntity;
import com.creditcard.app.ccapp.com.credicard.app.ccapp.service.CreditCardService;
import com.creditcard.app.ccapp.com.credicard.app.ccapp.vo.CreditCardInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration()
public class CreditCardServiceTest {

    @Before
    public void setup(){
        List<CreditCardEntity> list = new ArrayList<>();
        list.add(getCreditCardEntity());
        Mockito.when(creditCardDao.getAllCreditCard()).thenReturn(list);
        Mockito.when(creditCardDao.find(any(CreditCardEntity.class))).thenReturn(list);
    }

    @InjectMocks
    private CreditCardService creditCardService;

    @Mock
    private CreditCardDao creditCardDao;

    @Test
    public void testGetAllCreditCards(){
        List l = creditCardService.getAllCreditCards();
        Assert.assertTrue(l.size() >0 );
    }

    @Test
    public void testGetAllCreditCardsWithNoCardsInDb(){
        Mockito.when(creditCardDao.getAllCreditCard()).thenReturn(new ArrayList<>());
        List l = creditCardService.getAllCreditCards();
        Assert.assertFalse(l.size() >0 );
    }

    @Test
    public void testFindCreditCards(){
        List l = creditCardService.searchCreditCard(getCreditCardInfo());
        Assert.assertTrue(l.size() >0 );
    }

    @Test
    public void testSaveCreditCard(){
        CreditCardInfo creditCardInfo = getCreditCardInfoForSaveOperation();
        Mockito.when(creditCardDao.persist(any(CreditCardEntity.class))).thenReturn(getCreditCardEntity());
        CreditCardInfo savedCreditCard = creditCardService.saveCreditCard(creditCardInfo);
        Assert.assertFalse(savedCreditCard.getCardSubType().isEmpty());
        Assert.assertFalse(savedCreditCard.getCardType().isEmpty());
    }

    @Test
    public void testUpdateCreditCard(){
        CreditCardInfo creditCardInfo = getCreditCardInfo();
        creditCardService.updateCreditCard(creditCardInfo);
        Mockito.verify(creditCardDao,times(1)).update(any(CreditCardEntity.class));
    }

    @Test
    public void testDeleteCreditCard(){
        CreditCardInfo creditCardInfo = getCreditCardInfo();
        creditCardService.deleteCreditCard(creditCardInfo);
        Mockito.verify(creditCardDao,times(1)).delete(any(CreditCardEntity.class));
    }

    private CreditCardEntity getCreditCardEntity(){
        CreditCardEntity creditCardEntity = new CreditCardEntity();
        creditCardEntity.setCardSubType("VISA");
        creditCardEntity.setCardType("DEBIT");
        creditCardEntity.setCardNumber("123456789");
        creditCardEntity.setCardHolderName("testcard");
        creditCardEntity.setNickname("test");
        creditCardEntity.setId(12345l);
        return  creditCardEntity;
    }

    private CreditCardInfo getCreditCardInfo(){
        CreditCardInfo creditCardInfo = new CreditCardInfo();
        creditCardInfo.setCardHolderName("testcard");
        creditCardInfo.setCardSubType("VISA");
        creditCardInfo.setCardType("DEBIT");
        creditCardInfo.setCreditCardNumber("123456789");
        creditCardInfo.setCardHolderName("testcard");
        creditCardInfo.setNickname("test");
        return creditCardInfo;
    }

    private CreditCardInfo getCreditCardInfoForSaveOperation(){
        CreditCardInfo creditCardInfo = new CreditCardInfo();
        creditCardInfo.setCardHolderName("testcard");
        creditCardInfo.setCreditCardNumber("512189239222222");
        creditCardInfo.setCardHolderName("testcard");
        creditCardInfo.setNickname("test");
        return creditCardInfo;
    }
}
