package gameControllers;

import views.SplashScreen;
import entity.GameMode;

public class CustomLevelsController {
	GameMode customLevels;
	SplashScreen parentView;
	
	/**
	 * @param customLevels List of custom levels
	 * @param parentView view that the user is currently in.
	 */
	public CustomLevelsController(SplashScreen parentView,GameMode customLevels){
		this.parentView = parentView;
		this.customLevels = customLevels;
		
	}
	
	/**
	 * Entry method
	 */
	public void entry(){
		
	}
}
