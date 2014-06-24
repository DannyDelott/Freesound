import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.eclipsesource.json.JsonObject;

public class OutputLog {

	private File filePath;

	// //////////////
	// CONSTRUCTOR //
	// //////////////

	public OutputLog(String path) throws IOException {
		filePath = new File(path);
		PrintWriter clear = new PrintWriter(filePath);
		clear.close();

	}

	// /////////////////
	// PUBLIC METHODS //
	// /////////////////

	public void writeJsonObjectToFile(JsonObject j) throws IOException {

		FileWriter fw = new FileWriter(filePath, true);
		BufferedWriter writer = new BufferedWriter(fw);

		try {
			fw.append(j.toString() + "\n");

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			writer.close();
		}

	}

}
