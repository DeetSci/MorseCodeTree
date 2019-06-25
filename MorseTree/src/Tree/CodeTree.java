package Tree;

import java.util.Scanner;

public class CodeTree extends BinaryTree<String>
{
	static BinaryTree<String> morseTree = new BinaryTree<String>();
	
	//creates binary tree with morse code values
	public static void createMorseCodeTree()
	{
		@SuppressWarnings("unused")
		BSTNode<String> treeRoot = new BSTNode<String>("");
		//sets each morse code character with only dots
		morseTree.insert(" ", Relative.ROOT);
		morseTree.insert("E", Relative.LEFT);
		morseTree.insert("I", Relative.LEFT);
		morseTree.insert("S", Relative.LEFT);
		morseTree.insert("H", Relative.LEFT);
		//moves up one level to S
		morseTree.move(Relative.PARENT);
		//moves right to add dash for V
		morseTree.insert("V", Relative.RIGHT);
		//moves up two levels to I
		morseTree.move(Relative.PARENT);
		morseTree.move(Relative.PARENT);
		//moves  right for U
		morseTree.insert("U", Relative.RIGHT);
		//moves left for F
		morseTree.insert("F", Relative.LEFT);
		//moves up three levels to E
		morseTree.move(Relative.PARENT);
		morseTree.move(Relative.PARENT);
		morseTree.move(Relative.PARENT);
		//moves right for A
		morseTree.insert("A", Relative.RIGHT);
		//moves left for R
		morseTree.insert("R", Relative.LEFT);
		//moves left for L
		morseTree.insert("L", Relative.LEFT);
		//moves up two levels to A
		morseTree.move(Relative.PARENT);
		morseTree.move(Relative.PARENT);
		//moves right for W
		morseTree.insert("W", Relative.RIGHT);
		//moves left for P
		morseTree.insert("P", Relative.LEFT);
		//moves up one level for W
		morseTree.move(Relative.PARENT);
		//move right for J
		morseTree.insert("J", Relative.RIGHT);
		//returns to root
		morseTree.move(Relative.ROOT);
		//moves right for T
		morseTree.insert("T", Relative.RIGHT);
		//moves left for N
		morseTree.insert("N", Relative.LEFT);
		//moves left for D
		morseTree.insert("D", Relative.LEFT);
		//moves left for B
		morseTree.insert("B", Relative.LEFT);
		//moves up one level for D
		morseTree.move(Relative.PARENT);
		//moves right for X
		morseTree.insert("X", Relative.RIGHT);
		//moves up two levels for N
		morseTree.move(Relative.PARENT);
		morseTree.move(Relative.PARENT);
		//moves right for K
		morseTree.insert("K", Relative.RIGHT);
		//moves left for C
		morseTree.insert("C", Relative.LEFT);
		//moves up one level to K
		morseTree.move(Relative.PARENT);
		//moves right for Y
		morseTree.insert("Y", Relative.RIGHT);
		//moves up three levels to T
		morseTree.move(Relative.PARENT);
		morseTree.move(Relative.PARENT);
		morseTree.move(Relative.PARENT);
		//moves right for M
		morseTree.insert("M", Relative.RIGHT);
		//moves left for G
		morseTree.insert("G", Relative.LEFT);
		//moves left for Z
		morseTree.insert("Z", Relative.LEFT);
		//moves up one level to G
		morseTree.move(Relative.PARENT);
		//moves right for Q
		morseTree.insert("Q", Relative.RIGHT);
		//moves up two levels to M
		morseTree.move(Relative.PARENT);
		morseTree.move(Relative.PARENT);
		//moves right for O
		morseTree.insert("O", Relative.RIGHT);
		//returns to root
		morseTree.move(Relative.ROOT);
	}
	
	//method to decode from English to morse code
	public static String decode(String morseText)
	{
		if(morseText.length() == 0)
		{
			String holder = morseTree.retrieve();
			morseTree.move(Relative.ROOT);
			return holder;
		}
		
		char currChar = morseText.charAt(0);
		
		//filters out incorrect inputs, throws exception
		if (currChar != '.' && currChar != '-' && currChar != ' ' && currChar != '#')
		{
			System.out.println("Not a dot or dash.");
			start();
		}
		//dots move search to left subtrees
		if (currChar == '.')
		{
			morseTree.move(Relative.LEFT);
			return decode(morseText.substring(1));
		}
		//dashes move search to right subtrees
		else if (currChar == '-')
		{
			morseTree.move(Relative.RIGHT);
			return decode(morseText.substring(1));
		}
		//spaces end search for current morse code character
		else if (currChar == ' ')
		{
			String holder = morseTree.retrieve();
			morseTree.move(Relative.ROOT);
			return holder + decode(morseText.substring(1));
		}
		//ends search 
		else if (currChar == '#')
		{
			String holder = morseTree.retrieve();
			morseTree.move(Relative.ROOT);
			return holder + decode(morseText.substring(1));
		}
		morseTree.move(Relative.ROOT);
		return " ";
	}
	
	//prompts user for choice, and string to decode
	public static void start()
	{
		boolean run = true;
		Scanner sc = new Scanner(System.in);
	    char choice;
	    String englishOutput, morseInput;
	    
	    createMorseCodeTree();
	      
	    while(run)
	    {
	    		System.out.println();
	    		System.out.println("Decode Morse code = d");
	    		System.out.println("Quit = q");
	    		System.out.println("Choice: ");
	    		choice = sc.next().charAt(0);
	          
	    		if(choice != 'd' && choice != 'q')
	    		{
	    			System.out.println("Not a valid choice.");
	    			continue;
	    		}
	    		else if(choice == 'd')
	    		{
	    			sc.nextLine();
	    			System.out.print("Morse code to be translated: ");
	    			morseInput = sc.nextLine();
	    			englishOutput = decode(morseInput);
	    			System.out.println("'" + morseInput + "'" + " translates to " + "'" + englishOutput + "'");
	    		}
	    		else if(choice == 'q')
	    		{
	    			run = false;
	    			System.out.println("Closing.");
	    			break;
	    		}
	    }
	    sc.close();
	}
}