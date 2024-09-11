//InputHandlerクラス(InputHandler.java): ユーザーからの入力を処理し、数字や演算の入力を検証する。
package org.example;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.math.BigDecimal;

public class InputHandler {
  // 数字入力用メソッド（小数点対応）
  public static BigDecimal getDecimalInput(Scanner scanner, String message) {
    while (true) {
      try {
        System.out.print(message);
        return scanner.nextBigDecimal();
      } catch (InputMismatchException e) {
        System.out.println("【エラー：無効な数字です。正しい数字を入力してください。】");
        scanner.next(); // 無効な入力を消費
      }
    }
  }

  // 演算子入力用メソッド
  public static String getOperatorInput(Scanner scanner) {
    while (true) {
      System.out.print("演算子を入力してください (+, -, *, /): ");
      String operator = scanner.next();
      if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
        return operator;
      } else {
        System.out.println("【エラー：無効な演算子です。正しい演算子を入力してください (+, -, *, /)。】");
      }
    }
  }

  // 数字入力用メソッド（ゼロ除算のチェックを含む）
  public static BigDecimal getDecimalInput(Scanner scanner, String message, String operator) {
    while (true) {
      try {
        System.out.print(message);
        BigDecimal num = scanner.nextBigDecimal();
        if (operator.equals("/") && num.compareTo(BigDecimal.ZERO) == 0) {
          System.out.println("【エラー: 0で割ることはできません。もう一度、2番目の数字を入力してください。】");
        } else {
          return num;
        }
      } catch (InputMismatchException e) {
        System.out.println("【エラー：無効な数字です。正しい数字を入力してください。】");
        scanner.next(); // 無効な入力を消費
      }
    }
  }
}
