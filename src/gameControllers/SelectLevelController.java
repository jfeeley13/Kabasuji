package gameControllers;

import views.SplashScreen;

public class SelectLevelController {
	int levelID;
	SplashScreen parentView;
	
	/**
	 * 
	 * @param levelID level that the user has selected to play
	 * @param parentView view that the user is currently in.
	 */
	public SelectLevelController(int levelID, SplashScreen parentView){
		this.levelID = levelID;
		this.parentView = parentView;
		entry();
	}
	/**
	 * Entry method
	 */
	public void entry(){
		
	}
}
