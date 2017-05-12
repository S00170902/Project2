package com.example.myfirstapp;

/*
Written with the aid of a tutorial https://developer.android.com/training/basics/firstapp/starting-activity.html
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static com.example.myfirstapp.MainActivity.EXTRA_MESSAGE;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(message);

    }

    /*
    * Called when the user taps the OK button
     */
    public void scanProduct (View view) {
        Intent scanIntent = new Intent(this, ScanActivity.class);
        startActivity(scanIntent);
    }

}
