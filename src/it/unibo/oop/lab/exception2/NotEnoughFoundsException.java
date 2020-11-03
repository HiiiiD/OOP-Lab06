package it.unibo.oop.lab.exception2;

public class NotEnoughFoundsException extends IllegalStateException {

	private final double necessaryFounds;
	
	public NotEnoughFoundsException(double necessaryFounds) {
		super();
		this.necessaryFounds = necessaryFounds;
	}
	
	@Override
	public String getMessage() {
		return this.necessaryFounds + " $ are needed to perform the operation";
	}
}
