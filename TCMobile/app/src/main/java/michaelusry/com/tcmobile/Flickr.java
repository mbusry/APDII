package michaelusry.com.tcmobile;


/*
 * Data object that holds XML data from Flickr feed.
 */
public class Flickr {
    /*
    static final String KEY_FEED = "feed";
    static final String KEY_ICON = "icon";
    static final String KEY_ENTRY = "entry";
    static final String KEY_TITLE = "title";
    static final String KEY_ID = "id"; // need to get the last 11 digits later

     */

//    private String entry;
	private String title;
    private String id;
	
//    public String getEntry() {
//        return entry;
//    }
//    public void setEntry(String entry) {
//        this.entry = entry;
//    }


    public String getTitle() {
		return title;
	}
	public void setTitle(String title) {this.title = title;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

    @Override
	public String toString() {
		return "Flickr [title=" + title + ", id="
				+ id + "]";
	}
}
