//Michael Usry
//Java 1
//Term 1406

package michaelusry.com.tcmobile;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;


public class JSON {

    private static final String TAG = "JSON";
    // declare variables
	public static String jsonResult = "";
//	static String url = "https://vimeo.com/api/v2/tcbroadcast/videos.json";

    static String url;

	public static String showJSON(String ur) {
        Log.i(TAG,"showJSON");
        Log.i(TAG,"url: " + url);
        url = ur;


		try {
			// call the JSONParser
			getData data = new getData();

			// create string from data to hold JSON
			jsonResult = data.execute(url).get();
			Log.i(TAG,"jsonResult: " + jsonResult);


		}
        catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
//		Log.i(TAG,"result: " + result);
//
//		return result;

            return jsonResult;  //read jsondata
	}

	public static String getResponse(URL url) {
        Log.i(TAG,"starting data retrieval");
		// initialize the response variable
		String response = " ";
		try {
			// open a URL connection
			URLConnection connection = url.openConnection();

			// create a new buffer input stream
			BufferedInputStream bin = new BufferedInputStream(
					connection.getInputStream());

			// set the number of bytes to get at one time
			byte[] contextByte = new byte[1024];
			// set the bytes read to 0
			int bytesRead = 0;
			// create a new string buffer
			StringBuffer responseBuffer = new StringBuffer();

			// while the bytes read is not = -1 get the data and add it to the
			// response buffer
			while ((bytesRead = bin.read(contextByte)) != -1) {
				response = new String(contextByte, 0, bytesRead);
				responseBuffer.append(response);
			}
			// set the response variable to the responseBuffer string value
			response = responseBuffer.toString();
			// Log.i(TAG,"Response:" + response);
		} catch (IOException e) {
			// set response in case there is an error
			response = "There was an error";
			e.printStackTrace();
		}
		return response;
	}

	static class getData extends AsyncTask<String, Void, String> {

		protected String doInBackground(String... params) {

			// initialize the responseString variable
            Log.i(TAG,"getData:..... ");
            Log.i(TAG,"url: " + url);

            String responseString = "";

			try {


				// set the URL to the queryString
				URL urlSearch = new URL(url);
				responseString = getResponse(urlSearch);

				// set urlSearch = array

			} catch (MalformedURLException e) {
				// set the responseString in case of error
				responseString = "There was an error";
				e.printStackTrace();
			}

			return responseString;

		}

		@Override
		protected void onPostExecute(String result) {

			super.onPostExecute(result);
		}

	}

}
