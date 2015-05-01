package michaelusry.com.tcmobile.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import michaelusry.com.tcmobile.JSON;
import michaelusry.com.tcmobile.R;

/**
 * Created by michael on 4/21/15.
 */
public class VimeoFragment extends Fragment {

    private static final String TAG = "VimeoFragment";
    private String url = "https://vimeo.com/api/v2/tcbroadcast/videos.json";
    View rv;
    ListView lv = null;
    private JSONArray loadedJSonArray;
    String dataString;
    private ArrayList<String> vids;
//    private SitesAdapter mAdapter;



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.i(TAG,"onCreateView");
        Log.i(TAG,"url: " + url);
        lv = (ListView) getView().findViewById(R.id.vimeo_listView);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.i(TAG,"onItemClick: " + position);
//                String url = mAdapter.getItem(position).getLink();
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);

            }
        });


        // display the JSON.showJSON in a list.
        dataString = JSON.showJSON(url);
        Log.i(TAG,"dataString: " + dataString);

        // parse JSON

        updateView();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG,"onCreateView");
        Log.i(TAG,"url: " + url);

        rv = inflater.inflate(R.layout.fragment_vimeo, container, false);

        return rv;
    }

    public void updateView() {
        Log.i(TAG, "updateView started");

               try {
            loadedJSonArray = new JSONArray(dataString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (loadedJSonArray.length() > 0) {
            Log.i(TAG, "loadedJsonArray != null");
            Log.i(TAG, "loadedJsonArray.length: " + loadedJSonArray.length());
            Log.i(TAG, "loadedJsonArray.toString: " + loadedJSonArray.toString());

            vids = new ArrayList<String>();
            for (int i = 0; i < loadedJSonArray.length(); i++) {

                String title = null;


                try {
                    JSONObject json_data = loadedJSonArray.getJSONObject(i);
                    title = json_data.getString("title");

                    Log.i(TAG, "title("+i+"): " + title);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                vids.add(title);


                Log.i(TAG, "items.toString()" + vids.toString());
            }


            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, vids);
            lv.setAdapter(adapter);
        }

        /*
        public static Bitmap getBitmapFromURL(String src) {
            try {
                URL url = new URL(src);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                return myBitmap;
            } catch (IOException e) {
                // Log exception
                return null;
            }
        }
        */


    }


}
