package assignment_2;
import java.util.Scanner;


public class BuyStuff 
{
    public static void main(String[] args)
    {
        System.out.println("How much you got in your wallet?");
        Scanner sc = new Scanner(System.in);

        int cash = sc.nextInt();

        if (cash < 10)
        {
            System.out.println("Cannot buy shit");
            System.out.println("Get the hell outta here");
        }
        else if (cash > 10 && cash < 40)
        {
            System.out.println("can get one item");
        }
        else
        {
            System.out.println("Can get everything");
        }
    }
} 
