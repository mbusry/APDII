package michaelusry.com.tcmobile.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import michaelusry.com.tcmobile.R;


/**
 * Created by michael on 4/21/15.
 */
public class FacebookFragment extends Fragment {

    private static final String TAG = "FacebookFragment";
    View rv;
    String url = "https://vimeo.com/api/v2/tcbroadcast/videos.json";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG,"onCreateView");

        rv = inflater.inflate(R.layout.fragment_facebook, container, false);

        return rv;
    }

}
