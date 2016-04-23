package builderControllers;

import views.BuildStart;
import views.Builder;

public class CreateNewLevelController {
	BuildStart parent;
	
	public CreateNewLevelController (BuildStart buildStart) {
		parent = buildStart;
	}
	
	public void process() {
		
		parent.setVisible(false);
		parent.dispose();
		
		Builder newBuilderWindow = new Builder("Puzzle Level", 6, 6);
		 
		 //frame.dispose();													//closes current window
		// newBuilderWindow.openBuildWindow();
		newBuilderWindow.setVisible(true);
	}
}
