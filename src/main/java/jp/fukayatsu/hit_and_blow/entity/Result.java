package main.java.jp.fukayatsu.hit_and_blow.entity;

/**
 * 推測の結果を保持するクラス
 * 
 * @author fukaya_atsuo
 * 
 */
public class Result {

	private int hit; // hitの総数
	private int blow; // blowの総数
	private int digit; // 答えの桁数
	private int tryCount; // 試行回数

	public Result(int digit, int hit, int blow, int tryCount) {
		this.hit = hit;
		this.blow = blow;
		this.digit = digit;
		this.tryCount = tryCount;
	}

	/**
	 * 解答が正しいか否かを取得します。
	 * 
	 * @return 解答の正否
	 */
	public boolean isCorrect() {
		if (digit == hit) {
			assert (blow == 0);
			return true;
		}
		return false;
	}

	public int getDigit() {
		return digit;
	}

	public int getHit() {
		return hit;
	}

	public int getBlow() {
		return blow;
	}

	public int getTryCount() {
		return tryCount;

	}

	public String print() {
		return "[hit: " + hit + ", blow: " + blow + "] (try: " + tryCount + ")";
	}

	@Override
	public String toString() {
		return "Result [hit=" + hit + ", blow=" + blow + ", digit=" + digit
				+ ", tryCount=" + tryCount + ", isCorrect()=" + isCorrect()
				+ "]";
	}

}
