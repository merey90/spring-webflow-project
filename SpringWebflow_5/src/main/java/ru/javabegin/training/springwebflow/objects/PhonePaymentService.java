package ru.javabegin.training.springwebflow.objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class PhonePaymentService {
	private ArrayList<PhonePayment> phonePaymentsList = new ArrayList<PhonePayment>();
	private int otp;

	public PhonePaymentService() {
		phonePaymentsList.add(new PhonePayment("7085858845", "1549", "1"));
		phonePaymentsList.add(new PhonePayment("7015858855", "2013", "2"));
	}

	public ArrayList<CreditCard> getCreditCards() {
		ArrayList<CreditCard> creditsList = new ArrayList<CreditCard>();
		creditsList.add(new CreditCard(1, 1122334455667788L, 130760, 1));
		creditsList.add(new CreditCard(2, 1122334455664855L, 1200540, 1));
		return creditsList;
	}

	public int sendNewOtp() {
		Random agui = new Random(new Date().getTime());
		otp = agui.nextInt(8999) + 1000;
		return otp;
	}

	public String verifyOtp(otp otp, PhonePayment phonePayment) {
		if (this.otp != otp.getCode())
			return "wrong";
		else {
			boolean addNewPhonePayment = true;
			for (PhonePayment pp : phonePaymentsList) {
				if (pp.getPhone().equals(phonePayment.getPhone())) {
					pp.setBalance(Integer.toString(Integer.parseInt(pp.getBalance()) + Integer.parseInt(phonePayment.getBalance())));
					addNewPhonePayment = false;
				}
			}
			if (addNewPhonePayment) {
				phonePaymentsList.add(phonePayment);
			}
			return "accepted";
		}
	}

	public PhonePayment getPhoneInfo(String phone) {
		PhonePayment ars = null;
		for (PhonePayment pp : phonePaymentsList) {
			if (pp.getPhone().equals(phone)) {
				ars = pp;
			}
		}
		return ars;
	}
}
