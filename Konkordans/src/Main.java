import java.io.*;
import java.util.ArrayList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void construct() {
		//tell the position of the word
		try {
			File index = File.createTempFile("/var/tmp/index", "tmp");
			File pos = File.createTempFile("/var/tmp/pos", "tmp");
			File tokens = new File("/var/tmp/ut");
			
			BufferedWriter indexWriter = new BufferedWriter(new FileWriter(index));
			OutputStream posWriter = new FileOutputStream("/var/tmp/pos");
			FileReader fr = new FileReader(tokens);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			String word = null;
			int i = 0;
			while ((line = br.readLine()) != null) {
				String[] stringArray = line.split(" ");
				if (stringArray[0] != word) {
					word = stringArray[0];
					indexWriter.append(word + " " + i);
				}
				posWriter.write(stringArray[1].getBytes("ISO-8859-1"));
				i++;
			}
			indexWriter.close();
			posWriter.close();
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param 
	 */
	public void searchFile() {	
		try {
			RandomAccessFile file = new RandomAccessFile("/info/adk15/labb1/korpus", "r");
			file.seek(0);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

