/**
 * 
 */
package com.bowling.bowlingscorer.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.bowling.bowlingscorer.exception.BowlingException;
import com.bowling.bowlingscorer.interfaces.BowlingScorer;

/**
 * @author BSINGH004
 *
 */
public class BowlingScorerImpl implements BowlingScorer {

	private final List<Frame> frameList = new ArrayList<>(MAXIMUM_FRAMES);
	private int frameCounter = 0;
	private int strikeCounter;

	private String playerName;

	public BowlingScorerImpl() {
		this(new Date().toString());
	}

	public BowlingScorerImpl(String playerName) {
		super();
		this.playerName = playerName;
		for (int i = 0; i < MAXIMUM_FRAMES; i++) {
			Frame frame = new Frame();
			frameList.add(frame);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bowling.bowlingscorer.interfaces.BowlingScorer#roll(int)
	 */
	@Override
	public void roll(int pin) throws BowlingException {
		if(pin>10){
			throw new BowlingException("Only Superhero can knock down more than 10 pins in one roll!!!");
		}
		Frame frame = getFrame();
		frame.receiveRoll(pin);
	}

	private Frame getFrame() {
		/*
		 * if(frameCounter==0){ return frameList.get(frameCounter); }else
		 */
		if (frameList.get(frameCounter).frameRollCounter > 1 || frameList.get(frameCounter).isStrike()
				|| frameList.get(frameCounter).isSpare()) {
			return frameList.get(++frameCounter);
		} else {
			return frameList.get(frameCounter);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bowling.bowlingscorer.interfaces.BowlingScorer#getScore()
	 */
	@Override
	public int getScore() {
		int score = 0;
		if (strikeCounter == MAXIMUM_FRAMES) {
			return PERFECT_SCORE;
		}
		/*
		 * for (ListIterator<Frame> iterator = frameList.listIterator();
		 * iterator.hasNext();) { Frame frame = (Frame) iterator.next();
		 * if(frame.isStrike()){ frame. } }
		 */
		for (int i = 0; i < frameList.size(); i++) {
			Frame frame = frameList.get(i);
			if (frame.isStrike()) {
				score += (frameList.get(i + 1).getFrameRoll()[0]) + (frameList.get(i + 1).getFrameRoll()[1]);
			} else if (frame.isSpare() && isLastFrame(i)) {
				score += 10 + (frameList.get(i + 1).getFrameRoll()[0]);
			} else if (frame.isSpare()) {
				score += (frameList.get(i).getFrameRoll()[0]) + (frameList.get(i).getFrameRoll()[1])
						+ (frameList.get(i + 1).getFrameRoll()[0]);
			} else {
				score += (frameList.get(i).getFrameRoll()[0]) + (frameList.get(i).getFrameRoll()[1]);
			}
		}
		return score;
	}

	@Override
	public boolean isFinished() {
		return (frameCounter + 1 == MAXIMUM_FRAMES) ? true : false;
	}

	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * @param playerName
	 *            the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * @return the strikeCounter
	 */
	public int getStrikeCounter() {
		return strikeCounter;
	}

	/**
	 * @param strikeCounter
	 *            the strikeCounter to set
	 */
	public void setStrikeCounter(int strikeCounter) {
		this.strikeCounter = strikeCounter;
	}

	private boolean isLastFrame(int i) {
		return i == MAXIMUM_FRAMES - 1 ? true : false;
	}

	private class Frame {

		private int frameRollCounter = 0;
		private final int MAX_ROLL = 2;
		private int[] frameRoll = new int[MAX_ROLL];
		private boolean strike = false;
		private boolean spare = false;

		public void receiveRoll(int pin) throws BowlingException {
			if (frameRollCounter == 0 && pin == 10) {
				strike = true;
				frameRoll[frameRollCounter] = pin;
				frameRoll[frameRollCounter + 1] = 0;
				setStrikeCounter(getStrikeCounter() + 1);
				frameRollCounter = frameRollCounter + 2;
			} else if (frameRollCounter == 1 && !strike) {
				if (frameRoll[0] + pin > 10) {
					throw new BowlingException("Frame cannot be greater than 10");
				}
				frameRoll[1] = pin;
				frameRollCounter++;
				if (frameRoll[0] + frameRoll[1] == 10) {
					spare = true;
					if (isLastFrame(frameCounter)) {
						Frame frame = new Frame();
						frameList.add(frame);
					}
				}
			} else {
				frameRoll[frameRollCounter] = pin;
				frameRollCounter++;
			}

		}

		/**
		 * @return the frameRoll
		 */
		private int[] getFrameRoll() {
			return frameRoll;
		}

		/**
		 * @return the strike
		 */
		private boolean isStrike() {
			return strike;
		}

		/**
		 * @return the spare
		 */
		private boolean isSpare() {
			return spare;
		}

	}

}
