package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import entity.Level;

public class SaveController implements ActionListener{
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
