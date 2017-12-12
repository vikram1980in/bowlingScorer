/**
 * 
 */
package com.bowling.bowlingscorer;

import org.junit.Test;

import com.bowling.bowlingscorer.exception.BowlingException;
import com.bowling.bowlingscorer.impl.BowlingScorerImpl;
import com.bowling.bowlingscorer.interfaces.BowlingScorer;

import junit.framework.Assert;

/**
 * @author BSINGH004
 *
 */
public class BowlingScorerTest {

	@Test
	public void testPerfectScore() throws Exception{
		BowlingScorer bowlingScorer = new BowlingScorerImpl("Bikram");
		
		for(int i=0;i<10;i++){
			bowlingScorer.roll(10);
		}
		Assert.assertEquals(300, bowlingScorer.getScore());
	}

	@Test
	public void testAllSpares() throws Exception{
		BowlingScorer bowlingScorer = new BowlingScorerImpl("Bikram");
		
		for(int i=0;i<10;i++){
			bowlingScorer.roll(1);
			bowlingScorer.roll(9);
		}
		bowlingScorer.roll(1);
		Assert.assertEquals(111, bowlingScorer.getScore());
	}
	
	@Test(expected=BowlingException.class)
	public void testIsPinsGreaterThan10PerRoll() throws Exception{
		BowlingScorer bowlingScorer = new BowlingScorerImpl("Bikram");
		
		bowlingScorer.roll(14);
		
	}
	
	@Test(expected=BowlingException.class)
	public void testIsPinsGreaterThan10PerFrame() throws Exception{
		BowlingScorer bowlingScorer = new BowlingScorerImpl("Bikram");
		
		bowlingScorer.roll(7);
		bowlingScorer.roll(15);
		
	}
}
