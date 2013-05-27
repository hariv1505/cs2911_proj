
import java.util.ArrayList;


public class Portion {
    
	private  Integer[][] block;
	private  ArrayList<Integer> NumberAdded;
	
	 public Portion()
	   {
	      block = new Integer[3][3];
	      NumberAdded =  new ArrayList<Integer>();
	   }
	 
	 
	 
	 

	 public boolean hasDiffRows(){
		 boolean bool = true; 
		 for (int i = 0; i <= 2; i++) { 

				if(block[i][0]==block[i][1] || block[i][0]==block[i][2] || block[i][1]==block[i][2])bool=false;
			 
		 } 
	  return bool;  
	 }
	
	 
	 
	 
	 
	 public boolean hasDiffcols(){
		 boolean bool = true; 
		 for (int i = 0; i <= 2; i++) { 

				if(block[0][i]==block[1][i] || block[0][i]==block[2][i] || block[1][i]==block[2][i])bool=false;
			 
		 } 
	  return bool;  
	 }
	 
	 
	 
	 
	 public boolean checkDiffNums(){
		 boolean bool = false; 
		

				if(hasDiffRows() && hasDiffcols() )bool=true;
			 
		 
	  return bool;  
	 }
	
	 
	 
	 
	 
	 
	 public Integer getNum(int row,int col){
			 	 
	  return block[row][col];  
	 }
	 
	 
	 
	 
	 
	 public void setNum(int row,int col,Integer Num){
		 block[row][col]=Num;
		 NumberAdded.add(Num);
		 
	 }
	 
	 
	 public boolean Isexist(Integer Num){
		boolean bool;
		 bool=NumberAdded.contains(Num);
		 
		 return bool;
	 }





	public Integer[][] getPortion() {
		// TODO Auto-generated method stub
		return block;
	}
	 
	 
}
