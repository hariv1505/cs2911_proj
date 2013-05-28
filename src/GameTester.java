import java.util.Scanner;

public class GameTester {
	public static void main(String[] args) {
		Game aGame = new Game();
		Scanner console = new Scanner(System.in);
		int count=11*aGame.getDifficulty() + 18;
		
		while(!(count==0)) {
		       
	        System.out.println("Enter a cell and a number");
            int row=console.nextInt();               
            int col=console.nextInt();
            int value=console.nextInt();
            boolean cellFilled = aGame.putIntoBoard(row,col,value);
            if (cellFilled) {
            	count--;
            }
            
        	if(count==0) {
        		System.out.println("All done,well done!!!");
        	}
	    }
	}
}
