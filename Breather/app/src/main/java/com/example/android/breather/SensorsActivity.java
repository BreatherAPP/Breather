package com.example.android.breather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

public class SensorsActivity extends Activity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_results:
                    Intent resultsIntent = new Intent(SensorsActivity.this, MainActivity.class);
                    startActivity(resultsIntent);
                    break;
                case R.id.navigation_sensors:
                    break;
                case R.id.navigation_contacts:
                    Intent contactsIntent = new Intent(SensorsActivity.this, ContactsActivity.class);
                    startActivity(contactsIntent);
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sensors);

//        Add link to the mq9 sensor
        TextView mq9_link = (TextView) findViewById(R.id.mq9_link);
        mq9_link.setMovementMethod(LinkMovementMethod.getInstance());

//        Add link to the temperature and humidity sensor
        TextView temp_link = (TextView) findViewById(R.id.temp_link);
        temp_link.setMovementMethod(LinkMovementMethod.getInstance());

//        Add link to the multi sensor
        TextView multi_link = (TextView) findViewById(R.id.multi_link);
        multi_link.setMovementMethod(LinkMovementMethod.getInstance());


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}