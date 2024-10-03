package assignment_2;
import java.util.Scanner;

public class GuessNum {

    public static void main(String[] args) {
        int myNumber = (int)(Math.random()*100);
        // System.out.println(myNumber);

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Guess the number: ");
            int guessedNum = sc.nextInt();
            if (guessedNum == -1){
                System.out.println("Give Up");
                break;
            }
            else if (guessedNum == myNumber){
                System.out.println("You got it!");
                break;
            }
            else if (guessedNum < myNumber){
                System.out.println("Guess higher!");
            }
            else {
                System.out.println("Guess lower");
            }
        }
    }
}
