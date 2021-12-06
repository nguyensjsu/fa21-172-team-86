package com.example.springmanga;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import com.example.springmanga.Models.*;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Index;
import javax.persistence.criteria.CriteriaBuilder.Case;

@Data
class MangaOrder {

	private String action;
    private String amount1;
    private String amount2;
    private String amount3;
    private String amount4;
    private String amount5;
    private String amount6;
    private String amount7;
    private String amount8;
    private String amount9;
    private String amount10;
    
    public Integer getAmount(String id) {
    	String amount = String.valueOf(1);

    	switch(id) {
    		case "1":
    			amount = this.amount1;
    			break;
    		case "2":
    			amount = this.amount2;
    			break;
    		case "3":
    			amount = this.amount3;
    			break;
    		case "4":
    			amount = this.amount4;
    			break;
    		case "5":
    			amount = this.amount5;
    			break;
    		case "6":
    			amount = this.amount6;
    			break;
    		case "7":
    			amount = this.amount7;
    			break;
    		case "8":
    			amount = this.amount8;
    			break;
    		case "9":
    			amount = this.amount9;
    			break;
    		case "10":
    			amount = this.amount10;
    			break;
    		default:
    			break;
    	}

    	return Integer.valueOf(amount);
    }
	/*
    public MangaOrder() {
    	this.amount1 = String.valueOf(1);
    	this.amount2 = String.valueOf(1);
    	this.amount3 = String.valueOf(1);
    	this.amount4 = String.valueOf(1);
    	this.amount5 = String.valueOf(1);
    	this.amount6 = String.valueOf(1);
    	this.amount7 = String.valueOf(1);
    	this.amount8 = String.valueOf(1);
    	this.amount9 = String.valueOf(1);
    	this.amount10 = String.valueOf(1);
    }
	*/

								
}