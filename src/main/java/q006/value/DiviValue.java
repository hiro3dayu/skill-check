package q006.value;

import java.math.BigDecimal;
import java.util.Stack;

public class DiviValue implements IValue{
    @Override
    public void execute(Stack<BigDecimal> values) {
        // スタックから2つの値を抜き出し、割り算した結果をスタックに積む。小数点以下2桁を四捨五入
        BigDecimal right = values.pop();
        BigDecimal left = values.pop();
        values.push(left.divide(right,2,BigDecimal.ROUND_HALF_UP));
    }
}
