import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime time = LocalDateTime.parse(scanner.next());
        LocalDateTime newYear = LocalDateTime.of(time.getYear(), 01, 01, 0, 0, 0);
        System.out.println(Math.abs(Duration.between(newYear, time).toHours()));
    }
}