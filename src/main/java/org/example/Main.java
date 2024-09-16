//Mainクラス(Main.java):入力を受け取り、計算クラスを呼び出して結果を表示する。
//Scanner の管理を InputHandler クラスに任せることで、Main クラスをシンプルにする。
package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
  public static void main(String[] args) {
    // InputHandlerを初期化（ScannerはInputHandler内で作成される）
    InputHandler inputHandler = new InputHandler();

    // 数字と演算子の入力を受け取る
    BigDecimal x = inputHandler.getDecimalInput("1番目の数字を入力してください: ");
    String operator = inputHandler.getOperatorInput();
    BigDecimal y = inputHandler.getDecimalInput("2番目の数字を入力してください: ", operator);

    // 計算結果の取得
    Calculator calculator = new Calculator();
    BigDecimal result = calculator.calculate(x, y, operator);

    // 結果を小数点第8位まで整形し、不要なゼロを除去して表示
    String formattedResult = formatResult(result);

    // 結果を表示
    System.out.println("計算結果: " + x.stripTrailingZeros().toPlainString() + " " + operator + " " + y.stripTrailingZeros().toPlainString() + " = " + formattedResult);

    // Scannerをクローズする
    inputHandler.close();
  }

  // 結果を小数点第8位まで整形し、必要ならゼロを省略して表示
  private static String formatResult(BigDecimal result) {
    // 小数点第8位までに丸める
    BigDecimal scaledResult = result.setScale(8, RoundingMode.HALF_UP);

    // ストリップして不要なゼロを取り除き、文字列として返す
    return scaledResult.stripTrailingZeros().toPlainString();
  }
}
