package entity;

public class Lightning {

	protected int allowedTime;
	protected int timeElapsed;
	protected int tilesUncovered;
	
	protected int ID;
	protected BullPen pen;
	
	public Lightning(int ID, int allowedTime, BullPen pen){
		this.ID = ID;
		this.allowedTime = allowedTime;
		this.pen = pen;
	}
}
