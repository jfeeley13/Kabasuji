package gameControllers;
import entity.Kabasuji;
import views.SplashScreen;
public class PlayController {
	Kabasuji model;
	SplashScreen parentView;
	
	/**
	 * PlayController constructor
	 * @param model Entity model.
	 * @param parentView view that the user is currently in.
	 */
	public PlayController(SplashScreen parentView, Kabasuji model){
		this.parentView = parentView;
		this.model = model;
		entry();
	}
	/**
	 * Entry Method 
	 */
	public void entry(){
		
	}
}
