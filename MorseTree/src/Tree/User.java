package Tree;

import Tree.CodeTree;
import java.util.Scanner;

public class User
{
	public static void main(String[] args)
	{
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		
		while (run)
		{
			System.out.println("Would you like to run the program? y/n: ");
			char choice = sc.next().charAt(0);
			if (choice == 'y')
			{
				CodeTree.start();
				break;
			}
			else if (choice != 'y' && choice != 'n')
			{
				System.out.println("Not a valid choice.");
				continue;
			}
			else if (choice == 'n')
			{
				System.out.println("Closing.");
				System.exit(0);
				break;
			}
		}
		sc.close();
	}
}