package michaelusry.com.tcmobile.Fragments;

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

import michaelusry.com.tcmobile.R;

/**
 * Created by michael on 4/21/15.
 */
public class TCEventsFragment extends Fragment {

    private static final String TAG = "TCEventsFragments";
    View rv;

    String title[] = {"title 1", "title 2"};
    String event_date[] = {"date 1", "date 2"};
    String event_details[] = {"details 1", "details 2"};
    Context m_context;
    ListView lv;


    @Override
    public void onCreate(Bundle savedInstanceState) {
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
        for (int i = 0; i < title.length; ++i){
            list.add(title[i]);
        }

        final ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, list);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG,"onItemClick: " + position);
                Fragment sFrag = null;
                sFrag = new TCEventsDetailsFragment();
                Bundle args = new Bundle();
                args.putString("title",title[position]);
                args.putString("date",event_date[position]);
                args.putString("details",event_details[position]);

                sFrag.setArguments(args);

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, sFrag)
                        .commit();



            }
        });

        return rv;
    }

}
