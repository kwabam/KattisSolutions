import java.util.Scanner;

public class flowshop {

    static int[][] workshop;
    static int[][] timings;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        workshop = new int[kb.nextInt()][kb.nextInt()];
        timings = new int[workshop.length][workshop[0].length];

        int[]time = new int[workshop.length];

        //read in values
        for (int i = 0; i < workshop.length; i++) {
            for (int j = 0; j < workshop[i].length; j++) {
                workshop[i][j] = kb.nextInt();
            }
        }

        int sum = 0;

        for (int i = 0; i < workshop[0].length; i++) {
            sum+= workshop[0][i];
            timings[0][i] = sum;
        }

        for (int i = 1; i < workshop.length; i++) {
            for (int j = 0; j < workshop[i].length; j++) {
                if(j == 0){
                    timings[i][j] = workshop[i][j] + timings[i-1][j];
                }
                else {
                    if (timings[i][j - 1] < timings[i - 1][j]) {
                        timings[i][j] += (timings[i - 1][j] - timings[i][j - 1]);
                    }
                    timings[i][j] += (workshop[i][j] + timings[i][j-1]);
                }
            }
        }

        for (int i = 0; i < workshop.length; i++) {
            System.out.print(timings[i][workshop[i].length-1] + " ");
        }
    }
}
