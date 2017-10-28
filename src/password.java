import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class password {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int i = Integer.parseInt(kb.nextLine());
        ArrayList<Double> probabilities = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            probabilities.add(Double.parseDouble(kb.nextLine().split(" ")[1]));
        }
        Collections.sort(probabilities);
        Collections.reverse(probabilities);
        double probability = 0;
        for (int j = 0; j < probabilities.size(); j++) {
            probability += ((j+1)*(probabilities.get(j)));
        }
        System.out.println(probability);
    }
}


