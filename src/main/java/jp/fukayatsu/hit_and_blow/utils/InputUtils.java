package main.java.jp.fukayatsu.hit_and_blow.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ユーザ入力に関するのユーティリティクラス
 * 
 * @author fukaya_atsuo
 * 
 */
public class InputUtils {
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * ユーザ入力によりdigit桁の数値のリストを生成します。<br>
	 * ユーザが正しく入力するまで、再帰的に呼び出されます。
	 * 
	 * @param digit
	 *            数値リストの桁数(1-9)
	 * @return 重複の無い数値のリスト(size:1~10) ひとつの数値は1<=n<=9
	 */
	public static List<Integer> inputGuess(int digit) {
		assert (1 <= digit && digit <= 10);

		System.out.print("input " + digit + " digit numbers > ");
		String input = scanner.next();

		Pattern pattern = Pattern.compile("[0-9]{" + digit + "}");
		Matcher matcher = pattern.matcher(input);

		if (matcher.matches() && noDuplicateChar(input)) {
			return stringToIntegers(input);
		}

		// 再帰
		return inputGuess(digit);
	}

	/**
	 * 数値が並んだ文字列をListに変換します
	 * 
	 * @param string
	 *            入力値
	 * @return 数値のリスト
	 */
	private static List<Integer> stringToIntegers(String string) {
		List<Integer> integers = new ArrayList<Integer>();
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			integers.add(Integer.parseInt(Character.toString(c)));
		}
		return integers;
	}

	/**
	 * 文字列に同じ文字が含まれていないことを確認します。<br>
	 * Setが重複した要素を含まないことを利用しています。
	 * 
	 * @param string
	 *            入力文字列
	 * @return 重複がなければtrue<br>
	 *         重複があればfalse
	 */
	private static boolean noDuplicateChar(String string) {
		Set<Character> chars = new HashSet<Character>();
		for (int i = 0; i < string.length(); i++) {
			chars.add(string.charAt(i));
		}

		return chars.size() == string.length();
	}
}
