package ru.javabegin.training.springwebflow.objects;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

public class PhonePayment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8898539361871963505L;
	@Digits(fraction = 0, message="{must.be.integer}", integer = 10)
	@Size(min = 9, max = 10, message = "{phone.size.error}")
	private String phone;
	@Digits(fraction = 0, integer = 10, message="{must.be.integer}")
	@Size(min = 3, max = 9, message = "{payment.size.error}")
	private String balance;
	@Digits(fraction = 0, integer = 10, message="{must.be.integer}")
	@Size(min = 1,message = "{credit.size.error}")
	private String creditId;
	
	
	public PhonePayment() {
	}
	
	public PhonePayment(String phone, String balance, String creditId) {
		super();
		this.phone = phone;
		this.balance = balance;
		this.creditId = creditId;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getCreditId() {
		return creditId;
	}
	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}
	
	
}
