import java.util.ArrayList;
import java.util.Scanner;

public class cups {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = Integer.parseInt(kb.nextLine());
        ArrayList<cup> cupList = new ArrayList<>();
//        ArrayList<Integer> radius = new ArrayList<>();
//        ArrayList<String> color = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = kb.nextLine();
            int r;
            String c;
            try{
                r = Integer.parseInt(input.split(" ")[0])/2;
                c = (input.split(" ")[1]);
            }catch (NumberFormatException e){
                c = input.split(" ")[0];
                r = Integer.parseInt(input.split(" ")[1]);
            }
            cupList.add(new cup(r,c));
        }
        while(cupList.size() > 0){
            int index = 0;
            int lowestR = cupList.get(0).getRadius();

            for (int i = 1; i < cupList.size(); i++) {
            if(cupList.get(i).getRadius() < lowestR){
                lowestR = cupList.get(i).getRadius();
                index = i;
            }
            }
            System.out.println(cupList.get(index).getColor());
            cupList.remove(index);
        }

    }
}
class cup {
    int radius;
    String color;
    public cup(int r, String c){
        radius = r;
        color = c;
    }
    public int getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }
}