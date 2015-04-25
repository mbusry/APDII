package michaelusry.com.tcmobile.Fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

import michaelusry.com.tcmobile.R;

/**
 * Created by michael on 4/21/15.
 *
 *  Consumer Key (API Key)          nUycVv2dyU6qYLVohfN2Al01h
    Consumer Secret (API Secret)    VqGOASBDwhfXPgAxVTEhWaHBztn1esSzuv9ZHVqlsl39ZZZaS3
    Client Application ID           8230528
 */
public class TwitterFragment extends ListFragment {

    private static final String TAG = "FacebookFragment";
    private String url = "https://api.twitter.com/1.1/statuses/user_timeline.json?user_id=234578596&screen_name=tc_live";
    View rv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    final UserTimeline searchTimeline = new UserTimeline.Builder()
    .screenName("tc_live")
    .build();
    final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter(getActivity(),
    searchTimeline);
    setListAdapter(adapter);

        Log.i(TAG,"searchTimeline: " + searchTimeline);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG,"onCreateView");

        rv = inflater.inflate(R.layout.fragment_twitter_timeline, container, false);

        return rv;
    }



}
