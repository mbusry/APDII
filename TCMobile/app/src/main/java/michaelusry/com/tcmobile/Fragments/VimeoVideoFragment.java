package michaelusry.com.tcmobile.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.widget.VideoView;

import michaelusry.com.tcmobile.R;

/**
 * Created by michael on 4/25/15.
 */
public class VimeoVideoFragment extends Activity {

    VideoView vv;
    String VideoURL;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        vv = (VideoView) findViewById(R.id.vimeo_VideoView);


       /*
        try {
            // Start the MediaController
            MediaController mediacontroller = new MediaController();
            // Get the URL from String VideoURL
            Uri video = Uri.parse(VideoURL);
            vv.setMediaController(mediacontroller);
            vv.setVideoURI(video);

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        vv.requestFocus();
        vv.start();
*/
    }

}
