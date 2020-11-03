package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException {
	
	private final double necessaryAmount;
	
	public NotEnoughBatteryException(double necessaryAmount) {
		super();
		this.necessaryAmount = necessaryAmount;
	}
	
    @Override
    public String toString() {
        return this.necessaryAmount + " of battery is needed to move";
    }

    @Override
    public String getMessage() {
        return this.toString();
    }

}
