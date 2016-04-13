package entity;

public class Release {

	protected int allowedTime;
	protected int timeElapsed;
	protected int setsCollected;
	
	protected int ID;
	protected BullPen pen;
	
	public Release(int ID, int allowedTime, BullPen pen){
		this.ID = ID;
		this.allowedTime = allowedTime;
		this.pen = pen;
	}
}
