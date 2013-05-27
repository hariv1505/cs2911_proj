import java.util.ArrayList;



public class Portion {
    
	private  Integer[][] block;
	
	 public Portion()
	   {
	      block = new Integer[3][3];
	      for (int i = 0; i < 3; i++) {
	    	  for (int j = 0; j < 3; j++) {
	    		  block[i][j] = 0;
	    	  }
	      }
	      
	   }

	 public boolean checkDiffNums(){
		boolean ans = true;
		ArrayList<Integer> checked = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (block[i][j] != 0) {
					if (checked.contains(block[i][j])) {
						ans = false;
						break;
					}
					else {
						checked.add(block[i][j]);
					}
				}
			}
		}
			
		return ans;  
	 }
	
	 public Integer getNum(int row,int col){
		 return block[row][col];  
	 }
	 
	 public void setNum(int row,int col,Integer Num){
		 block[row][col]=Num;
		 
	 }
	 
	 public boolean Isexist(Integer Num){

		 boolean doesExist = false;
		 for (int i = 0; i < 3; i++) {
			 for (int j = 0; j < 3; j++) {
				 if (block[i][j] == 0) {
					 doesExist = true;
					 break;
				 }
			 }
		 }
		 return doesExist;
		 
	 }

	public Integer[][] getPortion() {
		return block;
	}
	 
}
