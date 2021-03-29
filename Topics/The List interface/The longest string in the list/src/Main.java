import java.util.*;

public class Main {

    static void changeList(List<String> list) {
        String max = list.get(0);
        for (String s : list) {
            max = max.length() > s.length() ? max : s;
        }

        for (int i = 0; i < list.size(); i++) {
            list.set(i, max);
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> lst = Arrays.asList(s.split(" "));
        changeList(lst);
        lst.forEach(e -> System.out.print(e + " "));
    }
}