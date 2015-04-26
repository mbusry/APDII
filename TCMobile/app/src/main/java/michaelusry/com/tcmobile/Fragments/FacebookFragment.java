package michaelusry.com.tcmobile.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;

import michaelusry.com.tcmobile.R;


/**
 * Created by michael on 4/21/15.
 */
public class FacebookFragment extends Fragment {

    private static final String TAG = "FacebookFragment";
    View view;
    String url = "https://graph.facebook.com/1416515531919842/posts";
    String token;

    private CallbackManager callbackManager;
    private LoginButton loginButton;

    public FacebookFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        Log.i(TAG,"onCreate");

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG,"onCreateView");

        view = inflater.inflate(R.layout.fragment_facebook, container, false);

/*
        loginButton = (LoginButton) view.findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_friends");
        // If using in a fragment
        loginButton.setFragment(this);
        // Other app specific specialization

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

*/
        return view;
    }

}
