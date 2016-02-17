import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> stacks = new ArrayList<Integer>();
        stacks.add(1);
        stacks.add(2);
        stacks.add(5);

        ArrayList<Integer> check = new ArrayList<Integer>();
        check.add(2);
        check.add(1);
        check.add(2);
        check.add(5);

        System.out.println(stacks.containsAll(check));
    }
}
