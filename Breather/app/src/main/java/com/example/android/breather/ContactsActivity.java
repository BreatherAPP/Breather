package com.example.android.breather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

public class ContactsActivity extends Activity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_results:
                    Intent resultsIntent = new Intent(ContactsActivity.this, MainActivity.class);
                    startActivity(resultsIntent);
                    break;
                case R.id.navigation_sensors:
                    Intent sensorsIntent = new Intent(ContactsActivity.this, SensorsActivity.class);
                    startActivity(sensorsIntent);
                    break;
                case R.id.share:
                    Intent myIntent  = new Intent(Intent.ACTION_SEND);
                    myIntent.setType("text/plain");
                    String shareBody = "Here will be link on app";
//                    String shareSub = "i just did it";
                    myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
//                    myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                    startActivity(Intent.createChooser(myIntent, "Share using"));
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_contacts);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation2);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
