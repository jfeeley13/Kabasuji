package gameControllers;

public class ExitToMainController<K> {
	//TODO: in which screens is the user able to exit to main? While playing the level, in the level selection screen, where else?
	//make it a generic class?
	K levelView;
	
	/**
	 * 
	 * @param levelView Boundary object representing the screen from which the user wants to exit to the main menu.
	 */
	public ExitToMainController(K levelView){
		this.levelView = levelView;
	}
	
	public void entry(){
		
	}
}
