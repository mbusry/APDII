package michaelusry.com.tcmobile.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by michael on 4/27/15.
 */
public class TCEventsDetailsFragment extends Fragment {

    private static final String TAG = "TCEventsDetailsFragment";

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();
        String title = bundle.getString("title");
        String date = bundle.getString("date");
        String details = bundle.getString("details");

        Log.i(TAG, "title: " + title);
        Log.i(TAG, "date: " + date);
        Log.i(TAG, "details: " + details);


    }


}
