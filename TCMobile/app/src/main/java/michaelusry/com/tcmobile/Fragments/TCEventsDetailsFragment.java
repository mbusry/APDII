package michaelusry.com.tcmobile.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import michaelusry.com.tcmobile.R;

/**
 * Created by michael on 4/27/15.
 */
public class TCEventsDetailsFragment extends Fragment {

    private static final String TAG = "TCEventsDetailsFragment";
    Context m_context;
    View rv;
    TextView titletv,datetv,detailstv;
    ImageView iconiv;
    String title,date,details;
    int icon;
    Bitmap iconbitmap;
    String tc_events_icons[] = {"jobfair","oneanother","foodtrucktriday","nightofworship"};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        title = bundle.getString("title");
        date = bundle.getString("date");
        details = bundle.getString("details");
        icon = bundle.getInt("icon");

        Log.i(TAG, "onActivityCreated:title: " + title);
        Log.i(TAG, "onActivityCreated:date: " + date);
        Log.i(TAG, "onActivityCreated:details: " + details);
        Log.i(TAG, "onActivityCreated:icon: " + icon);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(TAG,"onActivityCreated");
        super.onActivityCreated(savedInstanceState);



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.i(TAG, "onCreateView");

        //declare content
        m_context = getActivity().getBaseContext();

        rv = inflater.inflate(R.layout.fragment_tcevents_detail, container, false);


        titletv = (TextView) rv.findViewById(R.id.tce_title_textView);
        datetv = (TextView) rv.findViewById(R.id.tce_date_textView);
        detailstv = (TextView) rv.findViewById(R.id.tce_details_textView);
        iconiv = (ImageView) rv.findViewById(R.id.tce_imageView);
        Uri file = Uri.parse("android.resource://" + m_context.getPackageName()
                + "/raw/" + tc_events_icons+icon);
        Log.i(TAG,"file: " + file);


        if (icon == 0){
            iconbitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.jobfair);

        } else if (icon == 1){
            iconbitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.oneanother);

        } else if (icon == 2){
            iconbitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.foodtruckfriday);

        } else if (icon == 3){
            iconbitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.nightofworship);

        }


        titletv.setText(title);
        datetv.setText(date);
        detailstv.setText(details);
        iconiv.setImageBitmap(iconbitmap);


        return rv;
    }
}
