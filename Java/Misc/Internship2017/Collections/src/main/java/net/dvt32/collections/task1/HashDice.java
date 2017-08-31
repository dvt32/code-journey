package net.dvt32.collections.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This program rolls two M-sided dice N times.
 * 
 * The results from these rolls (the roll combination + the roll number, starting from 0),
 * are stored in an internal Map, in order to form a a statistic, in the form:
 * (combination) -> (list of roll numbers, where the result was that combination)
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class HashDice {
	private Map< List<Integer>, List<Integer> > diceRolls;
	private int M;
	private int N;
	
	/**
	 * Constructor, which initializes all class fields.
	 * 
	 * @param M the number of sides each of the two dice has
	 * @param N the number of times to roll the dice
	 */
	public HashDice(int M, int N) {
		diceRolls = new HashMap< List<Integer>, List<Integer> >();
		this.M = M;
		this.N = N;
	}
	
	/**
	 * This method rolls the dice N times & stores the combination + the roll number in the map.
	 * The roll itself is done via a random number generator, which generates the combination.
	 * Note that the roll numbers range from 0 to N (non-inclusive).
	 */
	public void rollDice() {
		for (int i = 0; i < N; ++i) {
			int firstDiceNumber = ThreadLocalRandom.current().nextInt(1, M+1);
			int secondDiceNumber = ThreadLocalRandom.current().nextInt(1, M+1);
			List<Integer> rollCombination = new ArrayList<Integer>(2);
			rollCombination.add(firstDiceNumber);
			rollCombination.add(secondDiceNumber);
		
			List<Integer> rollIndices = diceRolls.get(rollCombination);
			if ( rollIndices == null ) {
				rollIndices = new ArrayList<Integer>();
				rollIndices.add(i);
				diceRolls.put(rollCombination, rollIndices);
			}
			else {
				rollIndices.add(i);
			}
		}
	}
	
	/**
	 * This method prints all combinations + their roll number.
	 * The method is used for JUnit testing.
	 */
	public void printStats() {
		for ( List<Integer> rollCombination : diceRolls.keySet() ) {
			System.out.println(
				rollCombination + " -> " + diceRolls.get(rollCombination)
			);
		}
	}
}