package michaelusry.com.tcmobile.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import michaelusry.com.tcmobile.JSON;
import michaelusry.com.tcmobile.R;

/**
 * Created by michael on 4/21/15.
 */
public class VimeoFragment extends Fragment {

    private static final String TAG = "FacebookFragment";
    private String url = "https://vimeo.com/api/v2/tcbroadcast/videos.json";
    View rv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG,"onCreateView");
        //			result.setText(JSON.showJSON(selectedMag));

        Log.i(TAG,"JSON: " + JSON.showJSON(url));
        // display the JSON.showJSON in a list.

        // parse JSON

        //display to layout

        rv = inflater.inflate(R.layout.fragment_vimeo, container, false);

        return rv;
    }

}
