package com.creditcard.app.ccapp.com.credicard.app.ccapp.controller;

import com.creditcard.app.ccapp.com.credicard.app.ccapp.vo.CreditCardInfo;
import com.creditcard.app.ccapp.com.credicard.app.ccapp.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CreditCardController {

    @Autowired
    CreditCardService creditCardService;

    @GetMapping("/creditcard/search")
    public ResponseEntity<?> getCreditCard(@RequestBody CreditCardInfo creditCardInfo){
        List<CreditCardInfo> creditCardInfoList = creditCardService.searchCreditCard(creditCardInfo);
        if(creditCardInfoList.isEmpty())
            return new ResponseEntity<>("Sorry unable to find the Credit Card!!!!",HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(creditCardInfoList.get(0), HttpStatus.OK);
    }

    @GetMapping("/creditcard/")
    public ResponseEntity<?> getAllCreditCard(){
        List<CreditCardInfo> creditCardInfoList = creditCardService.getAllCreditCards();
        if(creditCardInfoList.isEmpty())
            return new ResponseEntity<>("Sorry unable to find the Credit Card!!!!",HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(creditCardInfoList, HttpStatus.OK);
    }

    @PostMapping("/creditcard/")
    public ResponseEntity<?> saveCreditCard(@RequestBody CreditCardInfo creditCardInfo){
        if(creditCardService.isCreditCardExists(creditCardInfo)){
            return new ResponseEntity<>("OOps looks like the Credit Card already exist",HttpStatus.CONFLICT);
        }else {
            creditCardService.saveCreditCard(creditCardInfo);
        }
        return new ResponseEntity<>("Successfully saved the credit card", HttpStatus.OK);
    }

    @PutMapping("/creditcard/")
    public ResponseEntity<?> updateCreditCard(@RequestBody CreditCardInfo creditCardInfo){
        List<CreditCardInfo> creditCardInfoList = creditCardService.searchCreditCard(creditCardInfo);
        if(creditCardInfoList.isEmpty())
            return new ResponseEntity<>("Sorry unable to find the Credit Card for update!!!!",HttpStatus.NOT_FOUND);
        creditCardService.updateCreditCard(creditCardInfo);
        return new ResponseEntity<>("Successfully updated the credit card", HttpStatus.OK);
    }

    @DeleteMapping("/creditcard/")
    public ResponseEntity deleteCreditCard(@RequestBody CreditCardInfo creditCardInfo){
        creditCardService.deleteCreditCard(creditCardInfo);
        return  new ResponseEntity("Successfully deleted the credit card", HttpStatus.NO_CONTENT);
    }
}
