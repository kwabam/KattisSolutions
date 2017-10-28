import java.util.Scanner;

public class fizzbuzz {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int x = kb.nextInt(), y = kb.nextInt(), n = kb.nextInt();
        for (int i = 1; i <= n; i++) {
            if(i%x== 0)
                System.out.print("Fizz");
            if(i%y == 0 )
                    System.out.print("Buzz");
            if(i%x != 0 && i%y != 0){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
