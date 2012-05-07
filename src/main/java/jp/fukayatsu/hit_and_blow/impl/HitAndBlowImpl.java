package main.java.jp.fukayatsu.hit_and_blow.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import main.java.jp.fukayatsu.hit_and_blow.HitAndBlow;
import main.java.jp.fukayatsu.hit_and_blow.entity.Result;

/**
 * 
 * @author fukaya_atsuo
 * 
 */
public class HitAndBlowImpl implements HitAndBlow {

	private int answerDigit; // 答えの桁数
	private List<Integer> answer; // 答え
	private int tryCount; // 試行回数

	/**
	 * コンストラクタ
	 * 
	 * @param answerDigit
	 */
	public HitAndBlowImpl(int answerDigit) {
		this.answerDigit = answerDigit;
		this.answer = generateAnswer(answerDigit);
		this.tryCount = 0;
	}

	@Override
	public Result compareWithAnswer(List<Integer> guess) {
		int hit = 0; // 正しい位置にあった数
		int blow = 0; // 数値は正しいが、位置が違った数

		for (int i = 0; i < answer.size(); i++) {
			int answerNum = answer.get(i);
			int guessNum = guess.get(i);

			if (answerNum == guessNum) {
				++hit;
			} else if (answer.contains(guessNum)) {
				++blow;
			}
		}
		return new Result(answerDigit, hit, blow, ++tryCount);
	}

	/**
	 * 任意の桁数の答えをランダムに生成します
	 * 
	 * @param size
	 *            答えの桁数(1~10)
	 * @return 答え
	 */
	private List<Integer> generateAnswer(int size) {
		assert (1 <= size && size <= 10);

		Integer[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		List<Integer> numbers = Arrays.asList(nums);
		Collections.shuffle(numbers);

		return numbers.subList(0, size);
	}
}