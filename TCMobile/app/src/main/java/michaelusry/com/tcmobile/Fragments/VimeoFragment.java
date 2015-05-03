package michaelusry.com.tcmobile.Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
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
    JSONArray loadedJSonArray;
    String dataString;
    private ArrayList<String> vids;
    ArrayList<String> passInfo;
    JSONObject arrayElement;

    String title;



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

    /*
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

                title = null;
                url = null;


                try {
                    JSONObject json_data = loadedJSonArray.getJSONObject(i);
                    title = json_data.getString("title");
                    url = json_data.getString("url");

                    Log.i(TAG, "title("+i+"): " + title);
                    Log.i(TAG, "url("+i+"): " + url);



                } catch (JSONException e) {
                    e.printStackTrace();
                }
                vids.add(title);


                Log.i(TAG, "items.toString()" + vids.toString());
            }



            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, vids);
            lv.setAdapter(adapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Log.i(TAG,"onItemClick: " + position);

                    Log.i(TAG,"onItemClick:title: " +title);
                    Log.i(TAG,"onItemClick:url: " +url);


                    //get info to bundle


                    Fragment sFrag = null;
                    sFrag = new VimeoVideoFragment();
                    Bundle args = new Bundle();
                    args.putString("url",url);
                    args.putString("title", title);
                    sFrag.setArguments(args);

                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, sFrag)
                            .addToBackStack(null)
                            .commit();



                }
            });

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


    }
    */

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

            String fn, ln, dob;
            vids = new ArrayList<String>();
            for (int i = 0; i < loadedJSonArray.length(); i++) {
                String url = null;
                String title = null;


                try {
                    JSONObject json_data = loadedJSonArray.getJSONObject(i);
                    title = json_data.getString("title");
                    url = json_data.getString("url");

                    Log.i(TAG, "title: " + title);
                    Log.i(TAG, "url: " + url);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                vids.add(title);
            }


            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, vids);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Log.i(TAG, "onItemClick: " + position);
//                    Log.i(TAG,"onItemClick: arrayList: " + arrayList);

                    try {
                        Log.i(TAG, "loadedJSonArray.getString(position): " + loadedJSonArray.getString(position));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    try {
                        arrayElement = loadedJSonArray.getJSONObject(position);
                    } catch (JSONException e) {
                        Log.i(TAG, "Problem getting the object at position: \n");
                        e.printStackTrace();
                    }
                    try {
                        Log.i(TAG, "title: " + arrayElement.getString("title"));
                        Log.i(TAG, "url: " + arrayElement.getString("url"));

                        String url = arrayElement.getString("url");
                        String title = arrayElement.getString("title");


                        Fragment sFrag = null;
                        sFrag = new VimeoVideoFragment();
                        Bundle args = new Bundle();
                        args.putString("url",url);
                        args.putString("title", title);
                        sFrag.setArguments(args);

                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction()
                                .replace(R.id.container, sFrag)
                                .addToBackStack(null)
                                .commit();


                    } catch (JSONException e) {
                        Log.i(TAG, "Problem getting the arrayElements: \n");

                        e.printStackTrace();
                    }

                }
            });
        }
    }


    }
