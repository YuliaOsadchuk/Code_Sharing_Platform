import java.util.function.*;

class FunctionUtils {


    public static Supplier<Integer> getInfiniteRange() {

        return new Supplier<Integer>() {
            int i = 0;

            @Override
            public Integer get() {
                return i++;
            }
        };
    }
}