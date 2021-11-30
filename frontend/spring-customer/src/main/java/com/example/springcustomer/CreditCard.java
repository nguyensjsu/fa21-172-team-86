package main.java.com.example.springcustomer;

import lombok.*;

import java.util.*;
import javax.persistence.*;
import javax.validation.*;


@Embeddable
@Getter
@Setter
@RequiredArgsConstructor
class CreditCard {
    private String cardnum ;
    private String cardexpmon ;
    private String cardexpyear ;
    private String cardcvv ;

    public CreditCard(String cardnum, String cardexpmon , String cardexpyear, String cvv) {
        this.cardnum = cardnum;
        this.cardexpmon = cardexpmon;
        this.cardexpyear = cardexpyear;
        cardcvv = cvv;
        
    }

}