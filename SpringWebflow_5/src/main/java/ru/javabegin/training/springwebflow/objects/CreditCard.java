package ru.javabegin.training.springwebflow.objects;

import java.io.Serializable;

public class CreditCard implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6821055976605769914L;
	
	private final int id;
	private final long card;
	private final int cardSecret;
	private long balance;
	private final int cardHolder;
	public CreditCard(int id, long card, long balance, int cardHolder) {
		super();
		this.id = id;
		this.card = card;
		this.cardSecret = (int) (card%10000);
		this.balance = balance;
		this.cardHolder = cardHolder;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public long getCard() {
		return card;
	}
	public int getCardSecret() {
		return cardSecret;
	}
	public int getCardHolder() {
		return cardHolder;
	}
	
	
}
