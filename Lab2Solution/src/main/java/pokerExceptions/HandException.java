package pokerExceptions;

import pokerBase.Hand;

@SuppressWarnings("serial")
public class HandException extends Exception {
	private Hand h;
	
	public HandException(Hand h) {
		super();
		this.h = h;
	}
	
	public Hand getH() {
		return h;
	}
}
