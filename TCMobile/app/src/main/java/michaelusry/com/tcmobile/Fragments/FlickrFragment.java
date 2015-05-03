package michaelusry.com.tcmobile.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import michaelusry.com.tcmobile.FlickrAdapter;
import michaelusry.com.tcmobile.FlickrXmlPullParser;
import michaelusry.com.tcmobile.R;

/**
 * Created by michael on 4/21/15.
 */
public class FlickrFragment extends Fragment {

    private static final String TAG = "FlickrFragment";
    String photoset1 = "https://api.flickr.com/services/rest/?method=flickr.photosets.getPhotos&api_key=8c6a93d37f1908ab5d71fa605cd7872e&photoset_id=";
    String data;
    View rv;
    ListView lv;
    String titleArray[] = {"Example 1", "Example 2", "Example 3"};
    String detailsArray[] = {"details 1", "details 2", "details 3"};
    Context m_context;
    ArrayAdapter mAdapter;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.i(TAG, "onCreateView");

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");

        //declare content
        m_context = getActivity().getBaseContext();

        rv = inflater.inflate(R.layout.fragment_flickr, container, false);

        lv = (ListView) rv.findViewById(R.id.flickr_listView);

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < titleArray.length; ++i){
            list.add(titleArray[i]);
        }
        /*
        //            mAdapter = new SitesAdapter(MainActivity.this, -1, SitesXmlPullParser.getStackSitesFromFile(MainActivity.this));
//            sitesList.setAdapter(mAdapter);
//            Log.i("StackSites", "adapter size = "+ mAdapter.getCount());

         */

//        final ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, list);
                mAdapter = new FlickrAdapter(m_context,R.layout.row_site, FlickrXmlPullParser.getFlickerXMLfromFile(m_context));

        lv.setAdapter(mAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG,"onItemClick: " + position);
                Fragment sFrag = null;
                sFrag = new FlickrDetailsFragment();
                Bundle args = new Bundle();
                args.putString("details",detailsArray[position]);
                sFrag.setArguments(args);

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, sFrag)
                        .addToBackStack(null)
                        .commit();



            }
        });

        return rv;
    }

}



