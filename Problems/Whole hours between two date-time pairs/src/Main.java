import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime time1 = LocalDateTime.parse(scanner.next());
        LocalDateTime time2 = LocalDateTime.parse(scanner.next());
        System.out.println(Math.abs(Duration.between(time1, time2).toHours()));
    }
}