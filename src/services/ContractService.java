package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, int months) {
		double result = contract.getTotalValue() / months;
		for(int i = 1; i <= months; i++) {
			Date date = addMonths(contract.getDate(), i);
			double updatedResult = result + onlinePaymentService.interest(result, i);
			double total = updatedResult + onlinePaymentService.paymentFee(updatedResult);
			contract.addInstallment(new Installment(date, total));
		}
	}
	
	private Date addMonths(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
}
