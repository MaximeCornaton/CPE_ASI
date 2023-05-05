package com.sp.exception;

public class TechnicalException extends RuntimeException{

	private static final long serialVersionUID = 5811798799880565640L;
	
	public TechnicalException(String msg) {
		
		super(msg);
	}
	public TechnicalException() {
		super();
	}
	

}

