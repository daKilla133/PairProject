import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java.util.ArrayList;
public class BTFileReader {
	private Reader restruct;
	File file;
	ArrayList<String> data;
	public BTFileReader(String URL)
	{
		file = new File((new File("Res")).getAbsolutePath() + URL);
	}
	
	public String name() 
	{		return file.getName();	}

	public void load() 
	{
		try{
			restruct = new BufferedReader(new FileReader(file));
			String line;
			while((line = (((BufferedReader) restruct).readLine())) != null)
			{
				data.add(line);
			}
		}catch(IOException ex){	
			System.err.println(ex.getStackTrace());
		}
		finally{
			try {restruct.close();} catch (Exception ex) {}
		}
	}
}
