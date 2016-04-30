package builderControllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
			FileWriter fw = new FileWriter(f);
			if(!f.exists())
				f.createNewFile();
			BufferedWriter bw  = new BufferedWriter(fw);
			bw.write(level.toString());
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
