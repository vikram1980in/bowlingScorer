/**
 * 
 */
package com.bowling.bowlingscorer;

import java.util.Scanner;

import com.bowling.bowlingscorer.impl.BowlingScorerImpl;
import com.bowling.bowlingscorer.interfaces.BowlingScorer;

/**
 * @author BSINGH004
 *
 */
public class BowlingScorerMain {

	/*public static void main(String[] args) {
		BowlingScorer bowlingScorer = new BowlingScorerImpl("Bikram");
		try {
			for(int i=0; i<10; i++){
				bowlingScorer.roll(10);
			}
			System.out.println("Initial Score : "+bowlingScorer.getPlayerName() +" = "+ +bowlingScorer.getScore());
			System.out.println("Game Finished : "+bowlingScorer.isFinished());
			bowlingScorer.roll(5);
			bowlingScorer.roll(4);
			bowlingScorer.roll(7);
			bowlingScorer.roll(3);
			bowlingScorer.roll(1);
			bowlingScorer.roll(7);
			bowlingScorer.roll(5);
			bowlingScorer.roll(4);
			bowlingScorer.roll(7);
			bowlingScorer.roll(3);
			bowlingScorer.roll(1);
			bowlingScorer.roll(7);
			bowlingScorer.roll(5);
			bowlingScorer.roll(4);
			bowlingScorer.roll(7);
			bowlingScorer.roll(3);
			bowlingScorer.roll(1);
			bowlingScorer.roll(7);
			bowlingScorer.roll(1);
			bowlingScorer.roll(7);
			System.out.println("Game Finished : "+bowlingScorer.isFinished());
			System.out.println("Final Score : "+bowlingScorer.getPlayerName() +" = "+ +bowlingScorer.getScore());
			
		} catch (Exception e) {
			System.out.println("Exception Occured : "+e);
		}
		
	}*/
	
	public static void main(String[] args) {
		try {
			/*for(int i=0; i<10; i++){
				bowlingScorer.roll(10);
				
			}*/
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter your name : ");
			int exit = 0;
			BowlingScorer bowlingScorer = new BowlingScorerImpl(scan.nextLine());
			do{
				
				System.out.println("Roll = 1\nScore = 2\nExit = 3");
				System.out.print("Enter Value : ");
				
				switch(scan.nextInt()){
				case 1:
					System.out.print("Enter Number of Pins :");
					bowlingScorer.roll(scan.nextInt());
					break;
					
				case 2:
					System.out.println("Score is : "+bowlingScorer.getScore());
					break;
					
				case 3:
					System.out.print(bowlingScorer.getPlayerName() +" Score is : "+bowlingScorer.getScore());
					exit=3;
					break;
				}				
			}while(exit==0);
			/*System.out.println("Initial Score : "+bowlingScorer.getPlayerName() +" = "+ +bowlingScorer.getScore());
			System.out.println("Game Finished : "+bowlingScorer.isFinished());
			
			System.out.println("Game Finished : "+bowlingScorer.isFinished());
			System.out.println("Final Score : "+bowlingScorer.getPlayerName() +" = "+ +bowlingScorer.getScore());*/
			
		} catch (Exception e) {
			System.out.println("Exception Occured : "+e);
		}
		
	}
	
	
}
