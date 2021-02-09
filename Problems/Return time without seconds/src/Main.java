import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalTime localTime = LocalTime.parse(scanner.next());
        System.out.println(localTime.withSecond(0));
    }
}