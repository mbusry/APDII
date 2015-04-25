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
 *
 *  Consumer Key (API Key)          nUycVv2dyU6qYLVohfN2Al01h
    Consumer Secret (API Secret)    VqGOASBDwhfXPgAxVTEhWaHBztn1esSzuv9ZHVqlsl39ZZZaS3
    Client Application ID           8230528
 */
public class TwitterFragment extends Fragment {

    private static final String TAG = "FacebookFragment";
    View rv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG,"onCreateView");

        rv = inflater.inflate(R.layout.fragment_twitter, container, false);




        return rv;
    }



}
