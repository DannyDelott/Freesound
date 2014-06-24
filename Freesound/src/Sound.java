import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.ParseException;

public class Sound {

	// ///////////////////
	// GLOBAL VARIABLES //
	// / /////////////////

	// the Freesound API key used to get the Freesound API Sound instance
	String apiKey;

	// the raw JSON object
	JsonObject json;

	// values found in the search results
	private int id;
	private String name;

	// values found in the Freesound API Sound Instance
	private String filetype;

	// Values used with OAuth2 authentication
	private String url;

	// error flags
	private boolean flagSound;

	// //////////////////////
	// FACTORY CONSTRUCTOR //
	// //////////////////////

	public static Sound newInstance(JsonObject o, String a) {
		Sound s = new Sound(o, a);
		if (s.getFlagSound()) {
			return null;
		}
		return s;

	}

	// //////////////
	// CONSTRUCTOR //
	// //////////////

	private Sound(JsonObject o, String a) {

		// resets error flag
		flagSound = false;

		// sets the raw JSON object
		json = o;

		// sets the api key
		apiKey = a;

		// gets the id
		id = json.get("id").asInt();

		// gets the name
		name = json.get("name").asString();

		// gets the Freesound API Sound instance
		json = getFreesoundAPISoundInstanceFromId();

		if (json != null) {
			// gets the file type
			filetype = json.get("type").asString();
			url = json.get("download").asString();
		}

	}

	// /////////////////
	// GLBOAL GETTERS //
	// /////////////////

	public boolean getFlagSound() {
		return flagSound;
	}

	public JsonObject getJsonObject() {
		return json;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public String getFileType() {
		return filetype;
	}

	// //////////////////
	// PRIVATE METHODS //
	// //////////////////
	private JsonObject getFreesoundAPISoundInstanceFromId() {

		// sets headers
		Header[] headers = { new BasicHeader("Content-type", "application/json") };

		// sets Freesound API Sound Instance url
		String tempUrl = "http://www.freesound.org/apiv2/sounds/" + id
				+ "/?token=" + apiKey;

		// executes GET request
		String output = Main.sendHttpGet(tempUrl, headers);

		if (output.contains("Request was throttled")) {
			flagSound = true;
			return null;
		}

		JsonObject j = null;
		try {
			j = JsonObject.readFrom(output);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
			return null;
		}

		return j;

	}

}
