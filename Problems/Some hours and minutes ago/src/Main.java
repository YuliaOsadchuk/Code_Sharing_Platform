import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalTime localTime1 = LocalTime.parse(scanner.next());
        int hours = scanner.nextInt();
        int minute = scanner.nextInt();
        localTime1 = localTime1.minusHours(hours);
        System.out.println(localTime1.minusMinutes(minute));
    }
}