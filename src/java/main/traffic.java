import java.util.Scanner;

public class traffic {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int pos1 = kb.nextInt(), pos2 = kb.nextInt();
        int posDIff = pos2 - pos1;
        int numChanges1 = kb.nextInt();
        int[] speedChange1 = new int[numChanges1];
        for (int i = 0; i < numChanges1; i++) {
            speedChange1[i] = kb.nextInt();
        }

        int numChanges2 = kb.nextInt();
        int[] speedChange2 = new int[numChanges2];
        for (int i = 0; i < numChanges2; i++) {
            speedChange2[i] = kb.nextInt();
        }
        int speed1 = 0, speed2 = 0;

        int time = 0;
        int i1 = 0;
        int i2 = 0;

        while(i1 < speedChange1.length || i2 < speedChange2.length){
            if(i1 < speedChange1.length)
            {
                if (speedChange1[i1] == time) {
                    if (speed1 == 0) {
                        speed1++;
                    } else {
                        speed1--;
                    }
                    i1++;
                }
            }
            if(i2 < speedChange2.length)
            {
                if (speedChange2[i2] == time) {
                    if (speed2 == 0) {
                        speed2++;
                    } else {
                        speed2--;
                    }
                    i2++;
                }
            }

            posDIff += speed2-speed1;

            if(Math.abs(posDIff) <= 4){
                time++;
                System.out.println("bumper tap at time " + time);
                return;
            }
            time++;
        }

        int change = speed2-speed1;

        if(posDIff < 0){
            posDIff *= -1;
            change *= -1;
        }
        if(change<0){
            time+=posDIff - 4;
            System.out.println("bumper tap at time " + time);
        }
        else{
            System.out.println("safe and sound");
        }
    }
}

