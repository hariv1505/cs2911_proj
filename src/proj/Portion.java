package proj;

import java.util.ArrayList;


public class Portion {
    
	private  Integer[][] block;
	//need to fix this
	private  ArrayList<Integer> NumberAdded;
	
	 public Portion()
	   {
	      block = new Integer[3][3];
	      NumberAdded =  new ArrayList<Integer>();
	   }
	 
	 
	 
	 

	 public boolean hasDiffRows(){
		 boolean bool = true; 
		 for (int i = 0; i <= 2; i++) { 

				boolean prop1 = (block[i][0].equals(block[i][1]));
				boolean prop2 = (block[i][0].equals(block[i][2]));
				boolean prop3 = (block[i][1].equals(block[i][2]));
				
				if (prop1 || prop2 || prop3) {
					bool=false;
					break;
				}
			 
		 } 
		 
		 return bool;  
	 }
	
	 
	 
	 
	 
	 public boolean hasDiffcols(){
		 boolean bool = true; 
		 for (int i = 0; i <= 2; i++) { 

			boolean prop1 = (block[0][i].equals(block[1][i]));
			boolean prop2 = (block[0][i].equals(block[2][i]));
			boolean prop3 = (block[1][i].equals(block[2][i]));
			
			if (prop1 || prop2 || prop3) {
				bool=false;
				break;
			}
		 } 
		 
		 return bool;  
	 }
	 
	 
	 
	 
	 public boolean checkDiffNums(){
		boolean bool = false; 

		if(hasDiffRows() && hasDiffcols()) bool=true;
			 
		return bool;  
	 }
	
	 
	 
	 
	 
	 
	 public Integer getNum(int row,int col){
			 	 
		return block[row][col];  
	 }
	 
	 
	 
	 
	 
	 public void setNum(int row,int col,Integer num){
		 NumberAdded.remove(block[row][col]);
		 block[row][col] = num;
		 NumberAdded.add(num);
	 }
	 
	 
	 public boolean Isexist(Integer num){
		boolean bool;
		bool=NumberAdded.contains(num);
		 
		return bool;
	 }
	 
	 
}
