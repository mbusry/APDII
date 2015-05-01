package michaelusry.com.tcmobile.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by michael on 4/30/15.
 */
public class FlickrDetailsFragment extends Fragment {

    private static final String TAG = "FlickrDetailsFragment" ;

    TextView tv;
    Context m_context;
    View rv;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();
        String title = bundle.getString("details");
        Log.i(TAG,"title: " + title);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);

//        m_context = getActivity().getBaseContext();
//
//        rv = inflater.inflate(R.layout.fragment_flickr_detail, container, false);



    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
