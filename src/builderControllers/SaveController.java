package builderControllers;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

import entity.Level;

public class SaveController{
	Level level;
	String fileName;

	public SaveController(Level level, String name) {
		super();
		this.level = level;
		this.fileName = name;
	}
	
	public void save(){
		File f = new File(fileName);
		try {
			if(!f.exists())
				f.createNewFile();
			FileWriter fw = new FileWriter(f);
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
