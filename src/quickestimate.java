import java.util.Scanner;

public class quickestimate {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int cases= Integer.parseInt(kb.nextLine());
        for (int i = 0; i < cases; i++) {
            System.out.println(kb.nextLine().length());
        }
    }

}
