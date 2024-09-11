package org.example;

import java.math.BigDecimal;

public class Calculator {
  // 四則演算を行うメソッド（BigDecimalを使って計算）
  public static BigDecimal calculate(BigDecimal x, BigDecimal y, String operator) {
    switch (operator) {
      case "+":
        return x.add(y);
      case "-":
        return x.subtract(y);
      case "*":
        return x.multiply(y);
      case "/":
        // ゼロ除算のチェックは既にInputHandlerで行われているのでそのまま割る
        return x.divide(y, 10, BigDecimal.ROUND_HALF_UP); // 割り算の場合は10桁までの精度で計算
      default:
        throw new IllegalArgumentException("無効な演算子です: " + operator);
    }
  }
}
