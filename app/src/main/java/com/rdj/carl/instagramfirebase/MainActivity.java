package com.rdj.carl.instagramfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String KEY_DESCOUNT = "key_descount";
    private TextView tvDescountMessage;
    private Button bSuscribeAndroid;
    private Button bSuscribeFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDescountMessage = (TextView) findViewById(R.id.tvDescountMessage);
        bSuscribeAndroid = (Button) findViewById(R.id.bSuscribeAndroid);
        bSuscribeFirebase = (Button) findViewById(R.id.bSuscribeFirebase);
        tvDescountMessage.setVisibility(View.GONE);
        /*************************************/
        String token = FirebaseInstanceId.getInstance().getToken();
        /*************************************/
        Log.w(TAG, "Token: " + token);

        if (getIntent().getExtras() != null){
            String descount = getIntent().getExtras().getString(KEY_DESCOUNT);
            tvDescountMessage.append(descount);
            tvDescountMessage.setVisibility(View.VISIBLE);
        }

    }

    public void suscribeAndroid(View view){
        FirebaseMessaging.getInstance().subscribeToTopic("Android");
        Toast.makeText(this, "Te suscribiste a Android :D", Toast.LENGTH_SHORT).show();
    }

    public void suscribeFirebase(View view){
        FirebaseMessaging.getInstance().subscribeToTopic("Firebase");
        Toast.makeText(this, "Te suscribiste a Firebase :D", Toast.LENGTH_SHORT).show();

    }
}
