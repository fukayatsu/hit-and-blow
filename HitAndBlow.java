import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class HitAndBlow {
  // 何桁の数当てをするか
  static final int DIGIT = 4;
  static final boolean DEGUB = true;

  /**
   * main関数
   *
   * @param args
   */
  public static void main(String[] args) {
    List<Integer> answer = generateAnser(DIGIT);

    // デバッグメッセージ: 答え
    if(DEGUB){
      System.out.println("DEBUG:" + answer.toString());
    }

    int count = 0;
    while (true) {
      System.out.println("\ninput " + DIGIT + " digit number (count:"
          + count + ")");

      Scanner scanner = new Scanner(System.in);
      try {
        String input = scanner.next();
        List<Integer> numbers = toList(input);
        if (checkAnswer(answer, numbers)) {
          System.out.println("Collect!");
          break;
        }
        // カウンタをインクリメント
        ++count;

      } catch (InputMismatchException e) {
        System.out.println("error: " + e.getMessage());
      }
    }
  }

  /**
   * 指定された桁数の答えを生成します
   *
   * @param size
   * @return
   */
  private static List<Integer> generateAnser(int size) {
    assert (0 <= size && size <= 9);
    Integer[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    List<Integer> numbers = Arrays.asList(nums);
    Collections.shuffle(numbers);
    return numbers.subList(0, size);
  }

  /**
   * 入力値をリストに変換します。 内部でバリデーションも行います。
   *
   * @param input
   * @return List<Ingetger>
   */
  private static List<Integer> toList(String input) {
    if (input.length() != DIGIT) {
      throw new InputMismatchException("入力桁数が不正です");
    }

    List<Integer> numbers = new ArrayList<Integer>();
    for (int i = 0; i < DIGIT; i++) {
      int num = Integer.valueOf(input.charAt(i)) - Integer.valueOf('0');
      if (0 <= num && num <= 9) {
        numbers.add(num);
      } else {
        throw new InputMismatchException("不正な文字が含まれています。");
      }
    }

    Set<Integer> numberSet = new HashSet<Integer>();
    numberSet.addAll(numbers);
    if (numberSet.size() != DIGIT) {
      throw new InputMismatchException("数字に重複があります");
    }

    List<Integer> numberList = new ArrayList<Integer>();
    numberList.addAll(numbers);
    return numberList;
  }

  /**
   * 答え合わせしつつ、hitとblowを計算します
   *
   * @param answer
   * @param input
   * @return
   */
  private static boolean checkAnswer(List<Integer> answer, List<Integer> input) {
    int hit = 0; // 正しい位置にあった数
    int blow = 0; // 数値は正しいが、位置が違った数

    for (int i = 0; i < answer.size(); i++) {
      int answerNum = answer.get(i);
      int inputNum = input.get(i);

      if (answerNum == inputNum) {
        ++hit;
      } else if (answer.contains(inputNum)) {
        ++blow;
      }
    }

    System.out.println("[hit: " + hit + ", blow:" + blow + "]");

    return hit == answer.size();
  }
}

