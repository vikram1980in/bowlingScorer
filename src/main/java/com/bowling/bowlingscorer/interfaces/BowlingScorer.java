/**
 * 
 */
package com.bowling.bowlingscorer.interfaces;

import com.bowling.bowlingscorer.exception.BowlingException;

/**
 * @author BSINGH004
 *
 */
public interface BowlingScorer {
	final int MAXIMUM_FRAMES = 10;
	final int PERFECT_SCORE=300;
	void roll(int pins) throws BowlingException;
	int getScore();
	String getPlayerName();
	boolean isFinished();
}
