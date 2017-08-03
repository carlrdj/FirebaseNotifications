package com.rdj.carl.instagramfirebase;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

/**
 * Created by SEVEN on 8/3/2017.
 */

public class FirebaseInstanceIdService extends com.google.firebase.iid.FirebaseInstanceIdService {

    private static final String TAG = "InstanceIdService";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.w(TAG, "TokenRefresh: " + token);
    }
}
