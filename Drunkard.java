import java.util.ArrayDeque;
import java.util.Scanner;

class Drunkard {
    public static void getCards(ArrayDeque<Integer> turn) {
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            turn.addLast(scan.nextInt());
        }
    }

    public static void main(String args[]) {
        ArrayDeque<Integer> firstD  = new ArrayDeque<Integer>();
        ArrayDeque<Integer> secondD = new ArrayDeque<Integer>();
        int firstC;
        int secondC;

        getCards(firstD);
        getCards(secondD);

        for (int i = 1; i <= 106; i++) {
            firstC = firstD.pollFirst();
            secondC = secondD.pollFirst();

            if (((firstC > secondC) && (secondC != 0 && firstC != 9)) || (firstC == 0 && secondC == 9)) {
                firstD.addLast(firstC);
                firstD.addLast(secondC);

                if (secondD.peekFirst() == null) {
                    System.out.println("First " + i);
                    return ;
                }
            }

            else if (((secondC > firstC) && (firstC != 0 && secondC != 9)) || (secondC == 0 && firstC == 9)) {
                secondD.addLast(firstC);
                secondD.addLast(secondC);

                if (firstD.peekFirst() == null) {
                    System.out.println("Second " + i);
                    return ;
                }
            }
        }
        System.out.println("Botva");
    }
}
