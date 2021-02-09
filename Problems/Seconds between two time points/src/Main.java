import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalTime localTime1 = LocalTime.parse(scanner.next());
        LocalTime localTime2 = LocalTime.parse(scanner.next());
        System.out.println(Math.abs(localTime1.toSecondOfDay() - localTime2.toSecondOfDay()));
    }
}