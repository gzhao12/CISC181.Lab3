package pokerExceptions;

import pokerBase.Hand;

public class HandException extends Exception {
	private Hand h;
	
	public HandException(Hand h) {
		super();
		this.h = h;
		System.out.println("You do not have 5 cards in your hand.");
	}
	
	public Hand getH() {
		return h;
	}
}
