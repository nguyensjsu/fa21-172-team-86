package com.example.springmain.springcybersource;


/*
What authorizing does is that it checks to see
if there's enough funds in the credit card and
reserves it before capturing (taking the money).
 */
public class AuthRequest extends Payload {

    public String reference ;
    public String billToFirstName ;
    public String billToLastName ;
    public String billToAddress ;
    public String billToZipCode ;
    public String billToCity ;
    public String billToState ;
    public String billToPhone ;
    public String billToEmail ;
    public String transactionAmount ;
    public String transactionCurrency ;
    public String cardNumber ;
    public String cardCVV ;
    public String cardExpMonth ;
    public String cardExpYear ;
    public String cardType ;

}


