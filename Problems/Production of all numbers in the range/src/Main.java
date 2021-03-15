import java.util.function.*;


class Operator {

    public static LongBinaryOperator binaryOperator = (x, y) -> {
        if (x == y) {
            return x;
        } else {
            long n = 1;
            for (long i = x; i <= y; i++) {
                n *= i;
            }
            return n;
        }
    };
}