package ru.javabegin.training.springwebflow.objects;

import java.io.Serializable;

public class otp implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1062216593012198872L;
	private int code;
	
	public otp(){
		
	}
	
	public otp(int code) {
		super();
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
}
