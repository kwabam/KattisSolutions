import java.util.*;

/**
 * Created by kw169 on 10/27/2017.
 */
public class shuffling {
    static int[] deck;
    static int[] original;
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int numCards = kb.nextInt();
        String shuffleType = kb.nextLine().trim();
       deck = new int[numCards];
        original = new int[numCards];
        for (int i = 0; i < numCards; i++) {
            deck[i] = i;
            original[i] = i;
        }
        int shuffles = 0;
        do{
            if(shuffleType.equals("in"))
                inShuffle();
            else
                outShuffle();
            shuffles++;
        }while(notInOrder(deck));
        System.out.println(shuffles);
    }

    private static void outShuffle()
    {
        int oneCounter = 0,twoCounter = 0;
        if(deck.length % 2 == 0) {
            int[] one = Arrays.copyOfRange(deck, 0, (deck.length / 2));
            int[] two = Arrays.copyOfRange(deck, deck.length / 2, deck.length);

            for (int i = 0; i < deck.length; i++) {
                if(i%2 == 0) {
                    deck[i] = one[oneCounter];
                    oneCounter++;
                }
                else {
                    deck[i] = two[twoCounter];
                    twoCounter++;
                }
            }
        }
        else{
            int[] one = Arrays.copyOfRange(deck, 0, (deck.length / 2) + 1);
            int[] two = Arrays.copyOfRange(deck, (deck.length /2) + 1, deck.length);

            for (int i = 0; i < deck.length; i++) {
                if(i%2 == 0) {
                    deck[i] = one[oneCounter];
                    oneCounter++;
                }
                else {
                    deck[i] = two[twoCounter];
                    twoCounter++;
                }
            }
        }
    }

    private static void inShuffle()
    {
        int oneCounter = 0,twoCounter = 0;
        if(deck.length % 2 == 0) {
            int[] one = Arrays.copyOfRange(deck, 0, (deck.length / 2));
            int[] two = Arrays.copyOfRange(deck, deck.length / 2, deck.length);

            for (int i = 0; i < deck.length; i++) {
                if(i%2 == 0) {
                    deck[i] = two[twoCounter];
                    twoCounter++;
                }
                else {
                    deck[i] = one[oneCounter];
                    oneCounter++;
                }
            }
        }
        else{
            int[] one = Arrays.copyOfRange(deck, 0, (deck.length / 2));
            int[] two = Arrays.copyOfRange(deck, (deck.length /2), deck.length);

            for (int i = 0; i < deck.length; i++) {
                if(i%2 == 0) {
                    deck[i] = two[twoCounter];
                    twoCounter++;
                }
                else {
                    deck[i] = one[oneCounter];
                    oneCounter++;
                }
            }
        }
    }

    private static boolean notInOrder(int[] deck){
        for (int i = 0; i < deck.length - 1; i++) {
            if(deck[i] > deck[i+1]){
                return true;
            }
        }
        return false;
    }
}
