/**
 * 
 */
package com.bowling.bowlingscorer.impl;

/**
 * @author BSINGH004
 *
 */
public class Frame {

	private int frameRollCounter=0;
	private final int MAX_ROLL = 2;
	private int[] frameRoll = new int[MAX_ROLL];
	private boolean strike = false;
	
	public void receiveRoll(int pin){
		if(frameRollCounter==0 && pin==10)
		{
			strike=true;
			frameRoll[frameRollCounter] = pin;
			frameRoll[frameRollCounter+1] = pin;
		}else{
			frameRoll[frameRollCounter] = pin;
			frameRollCounter++;
		}
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}


	

	/**
	 * @return the frameCounter
	 */
	public int getframeRollCounter() {
		return frameRollCounter;
	}


	/**
	 * @param frameCounter the frameCounter to set
	 */
	public void setframeRollCounter(int frameRollCounter) {
		this.frameRollCounter = frameRollCounter;
	}


	/**
	 * @return the frameRoll
	 */
	public int[] getFrameRoll() {
		return frameRoll;
	}


	/**
	 * @param frameRoll the frameRoll to set
	 */
	public void setFrameRoll(int[] frameRoll) {
		this.frameRoll = frameRoll;
	}


	/**
	 * @return the strike
	 */
	public boolean isStrike() {
		return strike;
	}


	/**
	 * @param strike the strike to set
	 */
	public void setStrike(boolean strike) {
		this.strike = strike;
	}

}
