import java.util.Scanner;

/**
 * Created by kw169 on 10/27/2017.
 */
public class Cudoviste {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int[][] data = new int[kb.nextInt()][kb.nextInt()];
        String[] rawData = new String[data.length];
        int[] crushedCards = new int[5];
        kb.nextLine();
        for (int y = 0; y < data.length; y++) {
            rawData[y] = kb.nextLine();
        }
        for (int y = 0; y < data.length; y++) {
            for (int x = 0; x < data[0].length; x++) {
                if(rawData[y].split("")[x].equals("."))
                data[y][x] = 0;
                if(rawData[y].split("")[x].equals("X"))
                    data[y][x] = 1;
                if(rawData[y].split("")[x].equals("#"))
                    data[y][x] = 2;
            }
        }

        for (int y = 0; y < data.length-1; y++) {
            for (int x = 0; x < data[0].length-1; x++) {
                switch(numCrushed(y,x,data)){
                    case 0:
                        crushedCards[0]++;
                        break;
                    case 1:
                        crushedCards[1]++;
                        break;
                    case 2:
                        crushedCards[2]++;
                        break;
                    case 3:
                        crushedCards[3]++;
                        break;
                    case 4:
                        crushedCards[4]++;
                        break;
                }
            }
        }
    for (int i : crushedCards)
        System.out.println(i);
    }

    private static int numCrushed(int y, int x, int[][] data) {
        if( data[y][x] == 2||data[y+1][x] == 2|| data[y+1][x+1] == 2 ||data[y][x+1] == 2 )
            return -1;

        int crushed = 0;
        if(data[y][x] == 1)
            crushed++;
        if(data[y][x+1] == 1)
            crushed++;
        if(data[y+1][x] == 1)
            crushed++;
        if(data[y+1][x+1] == 1)
            crushed++;
        return crushed;
    }

    private static void printArray(boolean[][] data){
        for (int y = 0; y < data.length; y++) {
            for (int x = 0; x < data[0].length; x++) {
                System.out.print(data[y][x]);
            }
            System.out.println();
        }
    }
}
