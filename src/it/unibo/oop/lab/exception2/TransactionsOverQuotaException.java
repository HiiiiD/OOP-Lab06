package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends IllegalStateException {

	private final int maxNumOfTransactions;
	
	public TransactionsOverQuotaException(int maxNumOfTransactions) {
		super();
		this.maxNumOfTransactions = maxNumOfTransactions;
	}
	
	@Override
	public String getMessage() {
		return "You reached the max number of transactions that is " + this.maxNumOfTransactions;
	}
}
