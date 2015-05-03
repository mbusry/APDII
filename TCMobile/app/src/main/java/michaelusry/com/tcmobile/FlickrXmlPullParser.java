package michaelusry.com.tcmobile;

import android.content.Context;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FlickrXmlPullParser {
    /*
    private String entry;
	private String title;
	private String author;
	private String uri;
    private String id;

    static final String KEY_SITE = "site";
	static final String KEY_NAME = "name";
	static final String KEY_LINK = "link";
	static final String KEY_ABOUT = "about";
	static final String KEY_IMAGE_URL = "image";

     */

    static final String KEY_ENTRY = "entry";
    static final String KEY_TITLE = "title";
    static final String KEY_ID = "id"; // need to get the last 11 digits later

    private static final String TAG = "FlickrXmlPullParser";
    static String dataString;
    static String photosetURL = "https://api.flickr.com/services/feeds/photos_public.gne?id=57940508@N07&format=xml";
    String url1 = "https://www.flickr.com/photos/tcbroadcast/";
    String pictureID;
    String pictureURL = url1 + pictureID + "/";
    Context m_context;


    public static List<Flickr> getFlickerXMLfromFile(Context ctx) {


        // List of Picture Titles that we will return
        List<Flickr> flickrs;
        flickrs = new ArrayList<Flickr>();

        // temp holder for current StackSite while parsing
        Flickr curFlickr = null;
        // temp holder for current text value while parsing
        String curText = "";
//        dataString = JSON.showJSON(photosetURL);
//        Log.i(TAG,"dataString: " + dataString);


        try {
            // Get our factory and PullParser
            XmlPullParser xpp = null;
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            xpp = factory.newPullParser();

            // Open up InputStream and Reader of our file.


            FileInputStream fis = ctx.openFileInput("Flickr.xml");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            Log.i(TAG,"file reader input: " +reader);

//            InputStream reader = new BufferedInputStream(fis);


            // point the parser to our file.
            xpp.setInput(reader);

            // get initial eventType
            int eventType = xpp.getEventType();
            Log.i(TAG, "eventType: " + eventType);

            // Loop through pull events until we reach END_DOCUMENT
            while (eventType != XmlPullParser.END_DOCUMENT) {
                Log.i(TAG, "Beginning While loop");
                // Get the current tag
                String tagname = xpp.getName();
                Log.i(TAG, "tagname: " + tagname);
                // React to different event types appropriately
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase(KEY_ENTRY)) {
                            // If we are starting a new <site> block we need
                            //a new StackSite object to represent it
                            curFlickr = new Flickr();
                            Log.i(TAG, "*****start ENTRY ********");
                        }
                        break;

                    case XmlPullParser.TEXT:
                        //grab the current text so we can use it in END_TAG event

                        curText = xpp.getText();
                        Log.i(TAG, ".TEXT: curText: " + curText);
                        if (curText.isEmpty()) {
                            curText = "";

                        }
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase(KEY_ENTRY)) {
                            // if </feed> then we are done with current Site
                            // add it to the list.
                            flickrs.add(curFlickr);
                            Log.i(TAG, "curFlickr: " + curFlickr);
                        } else if (tagname.equalsIgnoreCase(KEY_TITLE)) {
                            // if </title> use setLink() on curSite
                            curFlickr.setTitle(curText);
                            Log.i(TAG, "IF:curFlickr.setTitle: " + curText);

                        } else if (tagname.equalsIgnoreCase(KEY_ID)) {
                            // if </id> use setLink() on curSite
                            curFlickr.setId(curText);
                            Log.i(TAG, "IF:curFlickr.setID: " + curText);

                        }
                        break;

                    default:
                        break;
                }
                //move on to next iteration
                eventType = xpp.next();
                Log.i(TAG, "**********xpp.next**********");
                Log.i(TAG, "eventType: " + eventType);
                Log.i(TAG, "curFlickr: " + curFlickr);

            }//end of top while statement
        } catch (Exception e) {
            e.printStackTrace();
        }

        // return the populated list.

        Log.i(TAG, "flickrs: " + flickrs);
        return flickrs;
    }

}
