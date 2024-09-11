//Mainクラス(Main.java):入力を受け取り、計算クラスを呼び出して結果を表示する。
package org.example;

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 数字と演算子の入力を受け取る
    BigDecimal x = InputHandler.getDecimalInput(scanner, "1番目の数字を入力してください: ");
    String operator = InputHandler.getOperatorInput(scanner);
    BigDecimal y = InputHandler.getDecimalInput(scanner, "2番目の数字を入力してください: ", operator);

    // 計算結果の取得
    BigDecimal result = Calculator.calculate(x, y, operator);

    // 結果を小数点第8位まで整形し、不要なゼロを除去して表示
    String formattedResult = formatResult(result);

    // 結果を表示
    System.out.println("計算結果: " + x.stripTrailingZeros().toPlainString() + " " + operator + " " + y.stripTrailingZeros().toPlainString() + " = " + formattedResult);

    scanner.close();
  }

  // 結果を小数点第8位まで整形し、必要ならゼロを省略して表示
  private static String formatResult(BigDecimal result) {
    // 小数点第8位までに丸める
    BigDecimal scaledResult = result.setScale(8, RoundingMode.HALF_UP);

    // ストリップして不要なゼロを取り除き、文字列として返す
    return scaledResult.stripTrailingZeros().toPlainString();
  }
}
