package main.java.com.example.springcustomer;

import lombok.*;

import java.util.*;
import javax.persistence.*;
import javax.validation.*;

import java.util.*;
import java.io.Serializable;

@Entity
@Table(name="Customer")
@Data
@RequiredArgsConstructor
public class Customer implements Serializable{

    @Id @GeneratedValue private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String username;
    private String password;
    private int totalOrders;

    Customer(String firstName, String lastName, String password, int totalOrders, List<BillingInfo> billingInfos, List<CreditCard> creditCards) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.totalOrders = totalOrders;
        if(billingInfos != null) {
            this.billingInfos = billingInfos;
        }
        if(creditCards != null) {
            this.creditCards = creditCards;
        }
    }

    void addBillingInfo(BillingInfo billingInfo) {
        billingInfos.add(billingInfo);
    }


    void addCreditCard(CreditCard creditCard) {
        creditCards.add(creditCard);
    }


    void addCreditCard(StarbucksCard starbucksCard) {
        starbucksCards.add(starbucksCard);
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }
    
}
