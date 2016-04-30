package builderControllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import entity.Level;

public class SaveController {
	Level level;
	String fileName;

	public SaveController(Level level, String name) {
		super();
		this.level = level;
		this.fileName = name;
	}
	
	public void save(){
		File f = new File("%appdata%/" + fileName);
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
