package michaelusry.com.tcmobile.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import michaelusry.com.tcmobile.R;

/**
 * Created by michael on 4/25/15.
 */
public class VimeoVideoFragment extends Fragment {

    private static final String TAG = "VimeoVideoFragment";
//    VideoView vv;
    WebView vv;
    String VideoURL,titletv;
    View rv;
    TextView tv;
    Context m_context;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        VideoURL = bundle.getString("url");
        titletv = bundle.getString("title");


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        m_context = getActivity().getBaseContext();

        rv = inflater.inflate(R.layout.fragment_vimeo_video, container, false);

        /*
        webView = (WebView) findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("http://www.google.com");

         */

        vv = (WebView) rv.findViewById(R.id.vimeo_VideoView);
        vv.getSettings().setJavaScriptEnabled(true);
        vv.loadUrl(VideoURL);
//        vv.setVideoURI(vidUri);
//        vv.start();


        return rv;
    }
}
