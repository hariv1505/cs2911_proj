
import java.util.Calendar;
import java.util.Scanner;

public class Game { 

	 private static int[][] AB = new int[9][9];
	 private static int[][] copy = new int[9][9];
	 static int c = 0;// counter
	 static int d = 0;// counter
	 static int J = 0;


	 private Board thisGame;
	 
	 private Calendar startTime;
	 private Calendar endTime;
	 
	 private int difficulty;
	 
	 public Game() {
	
		 this.startTimer();
	 }
	 public static void main(String[] args) {
		Game a=new Game();
		a.generate();
		boolean finish= true;
		Scanner console = new Scanner(System.in);
		int count=18;
	   while(finish) {
		       
	        System.out.println("Enter a cell and a number");
            int row=console.nextInt();               
            int col=console.nextInt();
            int value=console.nextInt();
            if(copy[row-1][col-1]==0){
              
        	  if (value==AB[row-1][col-1]) {
            	count--;
            	copy[row-1][col-1]=AB[row-1][col-1];
            	print();
            	System.out.println("right input!!!");
              }
              
              else {
            	  System.out.println("wrong number");
              }
            }
            
            else {
            	System.out.println("cant input in this cell");
            }
        	if(count==0){
        		finish=false;
        		System.out.println("All done,well done!!!");
        	}
	    }
		
	 }
	 
	 public static void print() {
		 for (int i = 0; i <= 8; i++) { 
			for (int j = 0; j <= 8; j++) { 
				if(copy[i][j]!=0){
					System.out.print(copy[i][j]); 
					System.out.print(" ");
				}
				else{
					System.out.print(" "); 
					System.out.print(" "); 
				}
			} 
			System.out.println(); 
		 } 
	 }
	
	public void generate() {
	  while (c == 0) { 
		  int b1 = 0; 
		  int b2 = 0; 
		  int b3 = 0; 
		  for (int x = 0; x <= 8; x++){ 
			  for (int y = 0; y <= 8; y++){
	
		    java.util.Random ran = new java.util.Random(); 
		    int A = x; 
		    int B = y; 
	   // if exist
		    if (AB[A][B] == 0) { 
			    d++; 
	    // pass random number
			    this.pass(A, B); 
	    // check
			
			    b1 = this.row(A, B, 0); 
			    b2 = this.line(A, B, 0); 
			    b3 = this.block(A, B, 0);    
			    if (b1 == 1 || b2 == 2 || b3 == 3)AB[A][B] = 0; 
	    // counter c=1�� 
  			    c = 1; 
 			    for (int i = 0; i <= 8; i++) { 
 			 	    for (int j = 0; j <= 8; j++) { 
					    if (AB[i][j] == 0) { 
	       // if filled,stop
						    c = 0; 
					    } 
			 	    } 
			    } 
		    }   // random variable
		    if (d == 200) { 
		 	    J++; 
			    for (int i = 0; i < 3; i++) { 
				    int A1 = ran.nextInt(9); 
				    int B1 = ran.nextInt(9); 
				    AB[A1][B1] = 0; 
				    d = 0; 
			    }
		    }  
		  } 
		 }	  
	  }  
	 
	 
	  for (int i = 0; i <= 8; i++) { 
		  for (int j = 0; j <= 8; j++) { 
			
			copy[i][j]=AB[i][j];
			  
		  } 

	   } 
	
	  java.util.Random ran = new java.util.Random();
	  int count = 18;
	  while (count!=0){
		  int R = ran.nextInt(9); 
		  int C = ran.nextInt(9);
		 if(copy[R][C]!=0){
			 copy[R][C]=0; 
			 count--;
		 }
		
	  }
	  // print soduku 
	  System.out.println(" soduku "); 
	  for (int i = 0; i <= 8; i++) { 
		  for (int j = 0; j <= 8; j++) { 
			  if(copy[i][j]!=0){
			   System.out.print(copy[i][j]); 
			   System.out.print(" ");
			  }else{
				  System.out.print(" "); 
				   System.out.print(" "); 
				  }
			  } 
		   System.out.println(); 
		   } 
		  
		} 
  
	 	public void pass(int a, int b) { 
			java.util.Random ran = new java.util.Random(); 
			int t = ran.nextInt(9) + 1; 
			AB[a][b] = t; 
		 } 

		 public int row(int a, int b, int bool) { 
			 bool = 0; 
			 for (int i = 0; i <= 8; i++) { 
				 if (i != b) { 
					 if (AB[a][b] == AB[a][i]) { 
						 bool = 1; 
						 break; 
					 } 
				 } 
			 } 
		  return bool; 
		 } 


		 public int line(int a, int b, int bool) { 
			 bool = 0; 
			 for (int i = 0; i <= 8; i++) { 
				 if (i != a) { 
					 if (AB[a][b] == AB[i][b]) { 
						 bool = 2; 
						 break; 
					 } 
				 } 
			 } 
			 return bool; 
		 }

		 
	 public int block(int a, int b, int bool) { 
	  bool = 0; 
	  // first row
	  if (a == 0 || a == 1 || a == 2) { 

	   // first line 
		  if (b == 0 || b == 1 || b == 2) { 
			  for (int i = 0; i <= 2; i++) { 
				  for (int j = 0; j <= 2; j++) { 
					  if (i != a && j != b) { 
						  if (AB[a][b] == AB[i][j]) { 
							  bool = 3; 
							  break; 
						  } 
					  } 
				  } 
			  } 
		  } 
		  else if (b == 3 || b == 4 || b == 5) { 
			  for (int i = 0; i <= 2; i++) { 
				  for (int j = 3; j <= 5; j++) { 
					  if (i != a && j != b) { 
						  if (AB[a][b] == AB[i][j]) { 
							  bool = 3; 
							  break; 
						  } 
					  } 
				  } 
			  }   
		  } else if (b == 6 || b == 7 || b == 8) { 
			  for (int i = 0; i <= 2; i++) { 
				  for (int j = 6; j <= 8; j++) { 
					  if (i != a && j != b) { 
						  if (AB[a][b] == AB[i][j]) { 
							  bool = 3; 
							  break; 
						  } 
					  } 
				  } 
			  }   
		  } 
	  } else if (a == 3 || a == 4 || a == 5) { 
		  if (b == 0 || b == 1 || b == 2) { 
			  for (int i = 3; i <= 5; i++) { 
				  for (int j = 0; j <= 2; j++) { 
					  if (i != a && j != b) { 
						  if (AB[a][b] == AB[i][j]) { 
							  bool = 3; 
							  break; 
						  } 
					  } 
				  } 
			  } 
	   } else if (b == 3 || b == 4 || b == 5) { 
		   for (int i = 3; i <= 5; i++) { 
			   for (int j = 3; j <= 5; j++) { 
				   if (i != a && j != b) { 
					   if (AB[a][b] == AB[i][j]) { 
						   bool = 3; 
						   break; 
					   } 
				   } 
			   } 
		   }   
	   } else if (b == 6 || b == 7 || b == 8) { 
		   for (int i = 3; i <= 5; i++) { 
			   for (int j = 6; j <= 8; j++) { 
				   if (i != a && j != b) { 
					   if (AB[a][b] == AB[i][j]) { 
						   bool = 3; 
						   break; 
					   } 
				   } 
			   } 
		   }   
	   } 
	  } else if (a == 6 || a == 7 || a == 8) { 
		  if (b == 0 || b == 1 || b == 2) { 
			  for (int i = 6; i <= 8; i++) { 
				  for (int j = 0; j <= 2; j++) { 
					  if (i != a && j != b) { 
						  if (AB[a][b] == AB[i][j]) { 
							  bool = 1; 
							  break; 
						  } 
					  } 
				  } 
			  } 
		  } else if (b == 3 || b == 4 || b == 5) { 
			  for (int i = 6; i <= 8; i++) { 
				  for (int j = 3; j <= 5; j++) { 
					  if (i != a && j != b) { 
						  if (AB[a][b] == AB[i][j]) { 
							  bool = 1; 
							  break; 
						  } 
					  } 
				  } 
			  }   
		  } else if (b == 6 || b == 7 || b == 8) { 
			  for (int i = 6; i <= 8; i++) { 
				  for (int j = 6; j <= 8; j++) { 
					  if (i != a && j != b) { 
						  if (AB[a][b] == AB[i][j]) { 
							  bool = 1; 
							  break; 
						  } 
					  } 
				  } 
			  } 
		  } 
	  } 
	  return bool; 
	}
	 
	 public void putIntoBoard() {
		thisGame = null;
		
		
		for(int i=0;i<=3;i++){
			for(int j=0;j<=3;j++){
				thisGame.getBoard()[0][0].getPortion()[i][j]=AB[i][j];
			}
		}
		
		for(int i=0;i<=3;i++){
			for(int j=0;j<=3;j++){
				thisGame.getBoard()[1][0].getPortion()[i][j]=AB[i+3][j];
			}
		}
		
		for(int i=0;i<=3;i++){
			for(int j=0;j<=3;j++){
				thisGame.getBoard()[2][0].getPortion()[i][j]=AB[i+6][j];
			}
		}
			
		for(int i=0;i<=3;i++){
			for(int j=0;j<=3;j++){
				thisGame.getBoard()[0][1].getPortion()[i][j]=AB[i][j+3];
			}
		}
		for(int i=0;i<=3;i++){
			for(int j=0;j<=3;j++){
				thisGame.getBoard()[1][1].getPortion()[i][j]=AB[i+3][j+3];
			}
		}
		for(int i=0;i<=3;i++){
			for(int j=0;j<=3;j++){
				thisGame.getBoard()[2][1].getPortion()[i][j]=AB[i+6][j+3];
			}
		}
		for(int i=0;i<=3;i++){
			for(int j=0;j<=3;j++){
				thisGame.getBoard()[0][2].getPortion()[i][j]=AB[i][j+6];
			}
		}
		for(int i=0;i<=3;i++){
			for(int j=0;j<=3;j++){
				thisGame.getBoard()[1][2].getPortion()[i][j]=AB[i+3][j+6];
			}
		}
		for(int i=0;i<=3;i++){
			for(int j=0;j<=3;j++){
				thisGame.getBoard()[2][2].getPortion()[i][j]=AB[i+6][j+6];
			}
		}
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
	
	public String getDifficulty() {
		if (difficulty == 1) {
			return "Easy";
		}
		
		else if (difficulty == 2) {
			return "Medium";
		}
		
		else if (difficulty == 3) {
			return "Hard";
		}
		
		else return null;
	}
	
	public void setDifficulty(int difficulty) {
		assert (difficulty > 0 && difficulty < 4);
		this.difficulty = difficulty;
	}
	  
	
	
	
	

	
	
	 
} 
  
