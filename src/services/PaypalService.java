package services;


public class PaypalService implements OnlinePaymentService {
	
	private static final double FEE = 0.02;
	private static final double INTEREST_RATE = 0.01;
	
	public PaypalService() {
	}
	
	public double paymentFee(double amount) {
		return amount * FEE;
	}
	
	public double interest(double amount, int months) {
		return (amount * INTEREST_RATE * months);
	}
}
