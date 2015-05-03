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

    String title[] = {"Job Fair", "One Another Small Group Series", "West Cobb Food Truck Fridays","May Night of Worship"};
    String event_date[] = {"April 29 2015","April 29 2015","May 1 2015","May 6 2015"};
    String event_details[] = {"On Wed April 29th we are partnering with Goodwill of North GA to host a hiring event inside the gymnasium of our Trinity Life Center from 10-1pm. This job fair will have several employers in and around Cobb and Paulding County looking to fill some positions.\n" +
            "Goodwill of North Georgia provides job training and employment services to people who are having trouble finding work, want to change careers, or start their own business. With the agency’s support, Goodwill participants overcome employment hurdles caused by physical, emotional and developmental disabilities, limited job skills, poverty and other challenges.\n" +
            "They also sell donated clothing, books, furniture and household goods in stores across North Georgia and all the proceeds help to fund their mission of putting people to work. Goodwill projects to put over 15,000 to people to work this year alone, and you can be next! Trinity Chapel is so exited to help Goodwill fulfill their mission of putting people to work.\n" +
            "We are looking to host several hiring events at the Trinity Life Center and the first one will be held on April 29th. Please mark your calendars and plan to arrive early. For more information about Goodwill of North GA visit: http://goodwillng.org\n","Join us every Wednesday through April 29th for our small group video series, “One Another.”\n" +
            "This six week video series led by Bishop Bolin is designed to show us the importance of the “one another” commands of Bible and how to live them out with fellow believers.\n" +
            "New groups are forming every week and the series is designed for you to be able to jump in with us at any time. We hope to see you THIS Wednesday at Trinity Chapel!\n" +
            "For information on how to host a group at your home, email sreason@trinitychapel.org.\n","West Cobb Food Truck Fridays will be held at Trinity Chapel every week, April 10th through August 21st from 5pm – 8:30pm. \n" +
            "We have a great line up of the best food trucks from around Atlanta planned to be here each week, so bring your friends, family or community group and come experience what everyone is talking about!\n","We are having a special night of worship on May 6th at 7pm — to come together corporately and celebrate the end of our \"One Another\" small group series! Come be refreshed through your praise to HIM!"};
    String tc_events_icons[] = {"jobfair","R.drawable.oneanother","R.drawable.foodtrucktriday","R.drawable.nightofworship"};
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
                args.putInt("icon",position);

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
