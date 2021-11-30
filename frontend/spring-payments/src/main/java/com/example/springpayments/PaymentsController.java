package com.example.springpayments;

import com.example.springcybersource.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Controller
@RequestMapping("/")
public class PaymentsController {

    @Autowired
    private PaymentsRepository repository;

    private CyberSourceAPI api = new CyberSourceAPI() ;

    @Value("${cybersource.apihost}") private String apiHost ;
    @Value("${cybersource.merchantkeyid}") private String merchantKeyId ;
    @Value("${cybersource.merchantsecretkey}") private String merchantSecretKey ;
    @Value("${cybersource.merchantid}") private String merchantId ;

    //Create a class that returns messages
    @Getter
    @Setter
    class Message {
        private String msg;
        public Message(String message) { msg = message ; }
    }

    //Create a class that stores error messages for Invalid Credit card informations
    class ErrorMessages {
        private List<Message> errors = new ArrayList<>();
        public void add(String msg) { errors.add( new Message(msg) ) ; }
        public List<Message> getErrors() { return errors ; }
        public void print() {
            for ( Message m : errors ) {
                System.out.println( m.msg ) ;
            }
        }
    }

    @GetMapping
    public String getAction( @ModelAttribute("command") PaymentsCommand command,
                             Model model) {

        return "creditcards" ;

    }

    //Create a hashmap of all states
    private static final Map<String, String> states = new HashMap<>();
    /*
    https://stackoverflow.com/questions/2420389/static-initialization-blocks
    https://www.baeldung.com/java-initialize-hashmap
     */
    static {
        states.put("AL", "Alabama");
        states.put("AK", "Alaska");
        states.put("AZ", "Arizona");
        states.put("AR", "Arkansas");
        states.put("CA", "California");
        states.put("CO", "Colorado");
        states.put("CT", "Connecticut");
        states.put("DE", "Delaware");
        states.put("FL", "Florida");
        states.put("GA", "Georgia");
        states.put("HI", "Hawaii");
        states.put("ID", "Idaho");
        states.put("IL", "Illinois");
        states.put("IN", "Indiana");
        states.put("IA", "Iowa");
        states.put("KS", "Kansas");
        states.put("KY", "Kentucky");
        states.put("LA", "Louisiana");
        states.put("ME", "Maine");
        states.put("MD", "Maryland");
        states.put("MA", "Massachusetts");
        states.put("MI", "Michigan");
        states.put("MS", "Mississippi");
        states.put("MO" ,"Missouri");
        states.put("MT", "Montana");
        states.put("NE", "Nebraska");
        states.put("NV", "Nevada");
        states.put("NH", "New Hampshire");
        states.put("NJ", "New Jersey");
        states.put("NM", "New Mexico");
        states.put("NY", "New York");
        states.put("NC", "North Carolina");
        states.put("ND", "North Dakota");
        states.put("OH", "Ohio");
        states.put("OK", "Oklahoma");
        states.put("OR", "Oregon");
        states.put("PA", "Pennsylvania");
        states.put("RI", "Rhode Island");
        states.put("SC", "South Carolina");
        states.put("SD", "South Dakota");
        states.put("TN", "Tennesee");
        states.put("TX", "Texas");
        states.put("UT", "Utah");
        states.put("VT", "Vermont");
        states.put("VA", "Virginia");
        states.put("WA", "Washington");
        states.put("WV", "West Virginia");
        states.put("WI", "Wisconsin");
        states.put("WY", "Wyoming");
    }


    //Create a hashmap of all months
    private static final Map<String, String> months = new HashMap<>();
    static {
        months.put("January", "01");
        months.put("February", "02");
        months.put("March", "03");
        months.put("April", "04");
        months.put("May", "05");
        months.put("June", "06");
        months.put("July", "07");
        months.put("August", "08");
        months.put("September", "09");
        months.put("October", "10");
        months.put("November", "11");
        months.put("December", "12");
    }

    @PostMapping
    public String postAction(@Valid @ModelAttribute("command") PaymentsCommand command,  
                            @RequestParam(value="action", required=true) String action,
                            Errors errors, Model model, HttpServletRequest request) {
    
        log.info( "Action: " + action ) ;
        log.info( "Command: " + command ) ;

        //Create an instance of ErrorMessages to store inside hashmap and print if there's any errors
        ErrorMessages msg = new ErrorMessages();

        //Form Validations
        boolean hasError = false;
        if (command.getFirstName().equals(""))  { hasError = true ; msg.add("First Name is required") ; }
        if (command.getLastName().equals(""))   { hasError = true ; msg.add("Last Name is required") ; }
        if (command.getAddress().equals(""))    { hasError = true ; msg.add("Address is required") ; }
        if (command.getCity().equals(""))       { hasError = true ; msg.add("City is required") ; }
        if (command.getState().equals(""))      { hasError = true ; msg.add("State is required") ; }
        if (command.getZipCode().equals(""))    { hasError = true ; msg.add("Zip Code is required") ; }
        if (command.getPhone().equals(""))      { hasError = true ; msg.add("Phone Number is required") ; }
        if (command.getCardNum().equals(""))    { hasError = true ; msg.add("Credit Card Number is required") ; }
        if (command.getExpMonth().equals(""))   { hasError = true ; msg.add("Credit Card Expiration Month is required") ; }
        if (command.getExpYear().equals(""))    { hasError = true;  msg.add("Credit Card Expiration Year is required") ; }
        if (command.getCvv().equals(""))        { hasError = true ; msg.add("Credit Card CVV Number is required") ; }
        if (command.getEmail().equals(""))      { hasError = true ; msg.add("Email Address is required") ; }

        if(!command.getZipCode().matches("\\d{5}"))                             { hasError = true ; msg.add("Invalid Zip Code") ; }
        if(!command.getPhone().matches("[(]\\d{3}[)] \\d{3}[-]\\d{4}"))         { hasError = true ; msg.add("Invalid Phone Number") ; }
        if(!command.getCardNum().matches("\\d{4}[-]\\d{4}[-]\\d{4}[-]\\d{4}"))  { hasError = true ; msg.add("Invalid Credit Card Number") ; }
        if(!command.getExpYear().matches("\\d{4}"))                             { hasError = true ; msg.add("Invalid Expiration Year") ; }
        if(!command.getCvv().matches("\\d{3}"))                                 { hasError = true ; msg.add("Invalid CVV number") ; }

        //Month validation
        if(months.get(command.getExpMonth()) == null)       { hasError = true ; msg.add("Invalid Month") ; }

        //State validation
        if(states.get(command.getState()) == null)          { hasError = true ; msg.add("Invalid State") ; }

        if (hasError) {
            msg.print();
            //Write code here to display error message to thymeleaf
            model.addAttribute("errors", msg.getErrors() ) ;
            return "creditcards" ;
        }

        CyberSourceAPI.setHost( apiHost ) ;
        CyberSourceAPI.setKey( merchantKeyId ) ;
        CyberSourceAPI.setSecret( merchantSecretKey ) ;
        CyberSourceAPI.setMerchant( merchantId ) ;

        CyberSourceAPI.debugConfig() ;

        int min = 1234567 ;
        int max = 9999999 ;
        int random = (int) Math.floor(Math.random() * (max-min+1) * min) ;
        String order_num = String.valueOf(random) ;
        AuthRequest auth = new AuthRequest() ;
        auth.reference = order_num ;
        auth.billToFirstName = command.getFirstName() ;
        auth.billToLastName = command.getLastName() ;
        auth.billToAddress = command.getAddress() ;
        auth.billToCity = command.getCity() ;
        auth.billToState = command.getState() ;
        auth.billToZipCode = command.getZipCode() ;
        auth.billToPhone = command.getPhone() ;
        auth.billToEmail = command.getEmail() ;
        auth.transactionAmount = "30.00" ;
        auth.transactionCurrency = "USD" ;
        auth.cardNumber = command.getCardNum() ;
        auth.cardExpMonth = months.get(command.getExpMonth()) ;
        auth.cardExpYear = command.getExpYear() ;
        auth.cardCVV = command.getCvv() ;
        auth.cardType = CyberSourceAPI.getCardType(auth.cardNumber) ;

        if ( auth.cardType.equals("ERROR") ) {
            System.out.println("Credit Card Type Unsupported") ;
            model.addAttribute("message", "Credit Card Type Unsupported" ) ;
            return "creditcards" ;
        }
        boolean authValid = false ;
        System.out.println("\n\nAuth Request: " + auth.toJson() ) ;
        AuthResponse authResponse = api.authorize(auth) ;
        System.out.println("\n\nAuth Response: " + authResponse.toJson() ) ;
        authValid = true ;
        if ( !authResponse.status.equals("AUTHORIZED") ) {
            System.out.println( authResponse.message ) ;
            model.addAttribute( "message", authResponse.message ) ;
            return "creditcards" ;
        }

        boolean captureValid = false ;
        CaptureRequest capture = new CaptureRequest() ;
        CaptureResponse captureResponse = new CaptureResponse() ;
        if ( authValid ) {
            capture.reference = order_num ;
            capture.paymentId = authResponse.id ;
            capture.transactionAmount = "30.00" ;
            capture.transactionCurrency = "USD" ;
            System.out.println("\n\nCapture Request: " + capture.toJson() ) ;
            captureResponse = api.capture(capture) ;
            System.out.println("\n\nCapture Response: " + captureResponse.toJson() ) ;
            captureValid = true ;
            if ( !captureResponse.status.equals("PENDING") ) {
                System.out.println( captureResponse.message ) ;
                model.addAttribute("message" , captureResponse.message ) ;
                return "creditcards" ;
            }

        }

        /* Render View */
        if ( authValid && captureValid ) {
            command.setOrderNum(order_num) ;
            command.setTransactionAmnt("30.00") ;
            command.setTransactionCurrency("USD") ;
            command.setAuthId( authResponse.id ) ;
            command.setAuthStatus( authResponse.status ) ;
            command.setCaptureId( captureResponse.id ) ;
            command.setCaptureStatus( captureResponse.status ) ;

            repository.save( command ) ;

            System.out.println("Thank you for your payment! Your Order Number is: " + order_num) ;
            model.addAttribute("message", "Thank you for your payment! Your Order Number is: " + order_num) ;
        }

        return "creditcards";
    }

}