package main.java.jp.fukayatsu.hit_and_blow;

import java.util.List;

import main.java.jp.fukayatsu.hit_and_blow.entity.Result;
import main.java.jp.fukayatsu.hit_and_blow.impl.HitAndBlowImpl;
import main.java.jp.fukayatsu.hit_and_blow.utils.InputUtils;

/**
 * 
 * @author fukaya_atsuo
 * 
 */
public class Main {
	private static final int DIGIT = 4;

	public static void main(String[] args) {

		HitAndBlow hitAndBlow = new HitAndBlowImpl(DIGIT);

		List<Integer> input;
		while ((input = InputUtils.inputGuess(DIGIT)) != null) {

			Result result = hitAndBlow.compareWithAnswer(input);
			System.out.println(result.print());

			if (result.isCorrect()) {
				System.out.println("Good job!");
				break;
			}
		}
	}

}
