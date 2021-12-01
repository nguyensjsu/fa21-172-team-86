package com.example.springcustomer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import lombok.Data;
import lombok.RequiredArgsConstructor;


/*

Email - Username

*/

@Entity
@Table(name="Customer")
@Data
@RequiredArgsConstructor
public class Customer {

    @Id @GeneratedValue private int id;
    @Column(nullable=false) private String firstName;
    @Column(nullable=false) private String lastName;
    @Column(nullable=false) private String email;
    @Column(nullable=false) private String password;
    @Column(nullable=false) private int quantity;

    /*
    Don't think we need these.

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
    

    Don't need these as lombok already provides. Less boilerplate code

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
    */
}
