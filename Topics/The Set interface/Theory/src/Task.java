// You can experiment here, it won’t be checked

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Task {
    public static void main(String[] args) {
        Set<String> nameSet = new TreeSet<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));
        for (String s : nameSet) {
            System.out.println(s);
        }
    }
}
