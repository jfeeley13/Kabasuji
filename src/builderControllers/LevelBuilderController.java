package builderControllers;

import views.Builder;


public class LevelBuilderController  {
	Builder parent;

	public LevelBuilderController (Builder builder) {
		parent = builder;
	}
	
	public void process(String level, int row, int col, String name, int moveCounter) {
		
		parent.setVisible(false);
		parent.dispose();
		System.out.println(level+ row+ col+ name+ moveCounter);
		Builder newBuilderWindow = new Builder(level, row, col, name, moveCounter);
		 
		 //frame.dispose();													//closes current window
		// newBuilderWindow.openBuildWindow();
		newBuilderWindow.setVisible(true);
	}
}
