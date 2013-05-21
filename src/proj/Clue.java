package proj;


public class Clue {
	
	private int portion;
	private int index;
	private int num;
	private String explanation;
	
	public Clue(int portion, int index, int num, String explanation) {
		this.setPortion(portion);
		this.setIndex(index);
		this.setNum(num);
		this.explanation = explanation;
	}
	
	public String getExplanation() {
		return explanation;
	}

	public int getPortion() {
		return portion;
	}

	public void setPortion(int portion) {
		this.portion = portion;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
