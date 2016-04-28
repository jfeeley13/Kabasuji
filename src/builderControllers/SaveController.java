package builderControllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import entity.Level;

public class SaveController {
	Level level;

	public SaveController(Level level) {
		super();
		this.level = level;
	}
	
	public void save(){
		File f = new File("%appdata%/level");
		try {
			FileOutputStream fo= new FileOutputStream(f);
			byte[] levelData = level.toString().getBytes();
			fo.write(levelData, 0, levelData.length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
