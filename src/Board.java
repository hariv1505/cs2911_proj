
import java.util.*;

public class Board {
	
	public Board() {
		board = new Portion[NUM_ROWS][NUM_COLS];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = new Portion();
			}
		}
	}
	
	public ArrayList<Integer> getRow(int i) {

		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		FindIndex row = findLine(i);
		
		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 3; k++) {
				ans.add((board[row.por][j].getPortion())[row.line][k]);
			}
		}
		
		return ans;
	}
	
	public ArrayList<Integer> getCol(int i) {
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		FindIndex col = findLine(i);
		
		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 3; k++) {
				ans.add((board[j][col.por].getPortion())[k][col.line]);
			}
		}
		
		return ans;
	}
	
	
	public boolean isComplete() {
		boolean diffCols = true;
		boolean diffRows = true;
		
		for (int i = 1; i <= 9; i++) {
			diffRows = hasDiffRow(i);
			if (diffRows == false) return diffRows;
		}
		
		for (int j = 1; j <= 9; j++) {
			diffCols = hasDiffCol(j);
			if (diffCols == false) return diffCols;
		}
		
		return diffCols && diffRows;
	}
	
	public boolean hasDiffRow(int i) {
		ArrayList<Integer> toCheck = this.getRow(i);
		boolean ans = true;
		ArrayList<Integer> checked = new ArrayList<Integer>();
		for (int j = 0; j < toCheck.size(); j++) {
			if (checked.contains(toCheck.get(j)) && toCheck.get(j) != 0) {
				ans = false;
				break;
			}
			
			else if (toCheck.get(j) != 0)
				checked.add(toCheck.get(j));
		}
		
		return ans;
	}
	
	public boolean hasDiffCol(int i) {
		ArrayList<Integer> toCheck = this.getCol(i);
		boolean ans = true;
		ArrayList<Integer> checked = new ArrayList<Integer>();
		for (int j = 0; j < toCheck.size(); j++) {
			if (checked.contains(toCheck.get(j)) && toCheck.get(j) != 0) {
				ans = false;
				break;
			}
			
			else if (toCheck.get(j) != 0)
				checked.add(toCheck.get(j));
		}
		
		return ans;
	}
	
	private FindIndex findLine(int i) {
		int portion;
		
		if (i < 3) {
			portion = 0;
		}
		
		else if (i >= 3 && i < 6) {
			portion = 1;
		}
		
		else if (i >= 6 && i < 9){
			portion = 2;
		}
		
		else return null;
		
		int  lineInPort = i % 3;
		
		FindIndex ans = new FindIndex(portion, lineInPort);
		
		return ans;
	}
	
	public Portion[][] getBoard() {
		return board;
	}
	
	public Board clone() {
		Board newBoard = new Board();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				newBoard.getBoard()[i/3][j/3].setNum(i%3, j%3, board[i/3][j/3].getNum(i%3, j%3));
			}
		}
		return newBoard;
	}
	
	private Portion[][] board;
	private int NUM_ROWS = 3;
	private int NUM_COLS = 3;
	
	private class FindIndex {
		private FindIndex(int por, int line) {
			this.por = por;
			this.line = line;
		}
		
		private int por;
		private int line;
	}

}
