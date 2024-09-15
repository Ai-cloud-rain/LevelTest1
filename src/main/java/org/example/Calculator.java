//Calculatorクラス(Calculator.java):計算のロジックを行う。
// 四則演算を担当し、必要に応じて最大限を計算する。
package org.example;

import java.math.BigDecimal;

public class Calculator {
  // 四則演算を行うメソッド（BigDecimalを使って計算）
  public BigDecimal calculate(BigDecimal x, BigDecimal y, String operator) {
    switch (operator) {
      case "+":
        return x.add(y);
      case "-":
        return x.subtract(y);
      case "*":
        return x.multiply(y);
      case "/":
        // ゼロ除算のチェックはInputHandlerで行われているのでそのまま割る
        return x.divide(y, 8, BigDecimal.ROUND_HALF_UP); // 割り算の場合は8桁までの精度で計算
      default:
        throw new IllegalArgumentException("無効な演算子です: " + operator);
    }
  }
}
