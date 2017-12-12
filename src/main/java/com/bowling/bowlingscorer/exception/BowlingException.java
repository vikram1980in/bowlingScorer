/**
 * 
 */
package com.bowling.bowlingscorer.exception;

/**
 * @author BSINGH004
 *
 */
public class BowlingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8026717543079475347L;

	public BowlingException() {
		super();
	}
	
	public BowlingException(String message){
		super(message);
	}
}
