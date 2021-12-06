package com.example.springpayments;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Index;

@Entity
@Table(indexes=@Index(name="PAYMENTS", columnList="id"))
@Data
@RequiredArgsConstructor
class PaymentsCommand {

    private @GeneratedValue @Id Long id;
    
    transient private String action;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phone;
    private String cardNum;
    private String expMonth;
    private String expYear;
    private String cvv;
    private String email;
    private String notes;

    private String orderNum;
    private String transactionAmnt;
    private String transactionCurrency;
    private String authId;
    private String authStatus;
    private String captureId;
    private String captureStatus;

    public String firstname() { return firstname; }
    public String lastname() { return lastname; }
    public String address() { return address; }
    public String city() { return city; }
    public String state() { return state; }
    public String zipCode() { return zip; }
    public String phone() { return phone; }
    public String cardNum() { return cardnum; }
    public String expMonth() { return cardexpmon; }
    public String expYear() { return cardexpyear; }
    public String cvv() { return cardcvv; }
    public String email() { return email; }
    public String notes()  { return notes; }
}
