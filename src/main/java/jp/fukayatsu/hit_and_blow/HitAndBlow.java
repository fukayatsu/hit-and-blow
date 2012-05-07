package main.java.jp.fukayatsu.hit_and_blow;

import java.util.List;

import main.java.jp.fukayatsu.hit_and_blow.entity.Result;

/**
 * 
 * @author fukaya_atsuo
 * 
 */
public interface HitAndBlow {

	/**
	 * 推測値と実際の答えを比較し、結果を返します。
	 * 
	 * @param guess
	 * @return
	 */
	public Result compareWithAnswer(List<Integer> guess);

}
