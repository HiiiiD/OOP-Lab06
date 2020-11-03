package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends IllegalStateException {
	
	private final int userID;
	
	public WrongAccountHolderException(int userID) {
		super();
		this.userID = userID;
	}
	
	@Override
	public String getMessage() {
		return this.userID + " is not authorized";
	}
}
