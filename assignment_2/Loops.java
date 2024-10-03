package assignment_2;
import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        //for loop 
        // for (int i = 0; i <= 100; i++)
        // {
        //     System.out.println(i);
        // }
        // for (int i = 99; i >= 0; i--)
        // {
        //     System.out.println(i);
        // }


        //do while loop
        // Scanner sc = new Scanner(System.in);
        // int number = 0;

        // do{
        //     System.out.println("enter a number: ");
        //     number = sc.nextInt();
        //     System.out.print("number: ");
        //     System.out.println(number);
        // }
        // while(number >= 0);
        // System.out.println("THE END");

        //Break and continue
        //print everything skipping 3
        int j = 0;
        while (true)
        {
            if (j == 3)
            {
                j++;
                continue;
            }
            System.out.println(j);
            j++;
            if(j > 5)
            {
                break;
            }

        }
    }
}
