package services;


public class PaypalService implements OnlinePaymentService {
	
	public PaypalService() {
	}
	
	public double paymentFee(double amount) {
		return amount * 0.02;
	}
	
	public double interest(double amount, int months) {
		return (amount * 0.01 * months);
	}
}
