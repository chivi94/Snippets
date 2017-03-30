import java.io.File;
import java.io.IOException;

public class CreateFileSnippet {
	
	/**
	 * Creates a new File object
	 * @param path File's path
	 * @return true if the file is successfully created, false in another case
	 */
	public boolean createFile(String path){
		File file = null;
		try {
			file =new File(path);
			return file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


}
