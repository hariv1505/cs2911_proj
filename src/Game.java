
import java.util.Calendar;

public class Game { 

	 static int d = 0;// counter
	 static int J = 0;


	 private Board completeBoard;
	 private Board copiedBoard;
	 
	 private Calendar startTime;
	 private Calendar endTime;
	 
	 private int difficulty;
	 private boolean hints;
	 
	 public Game() {
	
		 this.difficulty = 0;
		 this.generate();
		 this.startTimer();
		 hints = false;
		 
	 }
	 
	public void generate() {
	  completeBoard = new Board();
	  boolean isFilled = false;
	  
		while (!isFilled) { 
		  
		  for (int i = 0; i < 3; i++){ //per portion row
			  for (int row = 0; row < 3; row++) { //per int row
				  for (int j = 0; j < 3; j++) { //per portion col
					  for (int col = 0; col < 3; col++) { //per int col
						  java.util.Random ran = new java.util.Random();
						  if (completeBoard.getBoard(i,j).getNum(row, col) == 0) {
							  d++;
							  int number = this.pass();
							  completeBoard.getBoard(i,j).setNum(row, col, number);
							  boolean hasDiffRows = completeBoard.hasDiffRow(i*3 + row);
							  boolean hasDiffCols = completeBoard.hasDiffCol(j*3 + col);
							  boolean completePortion = completeBoard.getBoard(i,j).checkDiffNums();
							  
							  if (!hasDiffRows || !hasDiffCols || !completePortion) {
									 completeBoard.getBoard(i,j).setNum(row, col, 0);
							  }
							  
							  else {
								  isFilled = true;
								  for (int ci = 0; ci < 3; ci++) {
									  for (int cj = 0; cj < 3; cj++) {
										  if (completeBoard.getBoard(ci,cj).Isexist(0)) {
											  isFilled = false;
											  break;
										  }
									  }
								  }
							  }
						  }
						// random variable
						  if (d == 200 && !isFilled) { 
						 	    
							  	J++; 
							    for (int a = 0; a < 3; a++) { 
								    int A1 = ran.nextInt(9); 
								    int B1 = ran.nextInt(9);
								    completeBoard.getBoard(A1/3,B1/3).setNum(A1%3, B1%3, 0);
							    }
							    d = 0;
					      }
					  }
				  }
			  }   
		  } 
	  }	  
	 
	  copiedBoard = completeBoard.clone(); 
	  java.util.Random ran = new java.util.Random();
	  int count = 11*this.difficulty + 18;
	  while (count != 0){
		 int R = ran.nextInt(9); 
		 int C = ran.nextInt(9);
		 if(copiedBoard.getBoard(R/3,C/3).getNum(R%3, C%3) !=0){
			 
			 copiedBoard.getBoard(R/3,C/3).setNum(R%3, C%3, 0);
			 count--;
		 }
	  }
	  
	  printBoard(copiedBoard);
	} 
  
 	public void printBoard(Board theBoard) {
 		System.out.println(" soduku "); 
 		for (int i = 0; i < 9; i++) { 
 			for (int j = 0; j < 9; j++) { 
 				if(theBoard.getBoard(i/3,j/3).getNum(i%3, j%3) !=0) {
 					System.out.print(theBoard.getBoard(i/3,j/3).getNum(i%3, j%3)); 
 				}
 				  
 				else {
 					System.out.print(" "); 
 				}
 				  
 				System.out.print(" ");
 			} 
 			  
 			System.out.println(); 
 		}
	}

	private int pass() { 
		java.util.Random ran = new java.util.Random(); 
		int t = ran.nextInt(9) + 1; 
		return t; 
	} 

	public boolean putIntoBoard(int i, int j, int val) {
		boolean isPut = false;
		i--;
		j--;
		
		if(copiedBoard.getBoard(i/3,j/3).getNum(i%3, j%3) == 0){
        	if (val==completeBoard.getBoard(i/3,j/3).getNum(i%3, j%3)) {
        		copiedBoard.getBoard(i/3,j/3).setNum(i%3, j%3, val);
        		isPut = true;
        	}
    		printBoard(copiedBoard);
        }
        
        else {
        	System.out.println("cant input in this cell");
        	isPut = false;
        	return isPut;
        }
		
		if (isPut) {
			System.out.println("right input");
		}
		
		else {
			System.out.println("wrong input");
		}
		
		return isPut;
	} 
	 
	public void startTimer() {
		startTime = Calendar.getInstance();
	}
	
	public void endTimer() {
		endTime = Calendar.getInstance(); 
	}
	
	public int timeTaken() {
		assert (endTime.after(startTime));
		return endTime.compareTo(startTime);
	}
	
	public String getExplanation(Clue c) {
		return c.getExplanation();
	}
	
	public int getDifficulty() {
		return this.difficulty;
	}
	
	public void setDifficulty(int difficulty) {
		assert (difficulty > -1 && difficulty < 5);
		this.difficulty = difficulty;
	}
	
	public Board getCurrentBoard() {
		return copiedBoard;
	}
	
	public void toggleHint() {
		hints = !hints;
	}
} 
  
