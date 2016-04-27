package builderControllers;

import views.Builder;


public class LevelBuilderController  {
	Builder parent;

	public LevelBuilderController (Builder builder) {
		parent = builder;
	}
	
	public void process(String level, int row, int col) {
		
		parent.setVisible(false);
		parent.dispose();
		
		Builder newBuilderWindow = new Builder(level, row, col);
		 
		 //frame.dispose();													//closes current window
		// newBuilderWindow.openBuildWindow();
		newBuilderWindow.setVisible(true);
	}
}
