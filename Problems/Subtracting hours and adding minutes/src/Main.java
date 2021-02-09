import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime time = LocalDateTime.parse(scanner.next());
        int hours = scanner.nextInt();
        int minute = scanner.nextInt();
        System.out.println(time.minusHours(hours).plusMinutes(minute));
    }
}