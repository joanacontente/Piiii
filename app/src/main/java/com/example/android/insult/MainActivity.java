package com.example.android.insult;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String[] myString;
    private static final Random rgenerator = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void randomInsult(View view) {
        Resources res = getResources();
        myString = res.getStringArray(R.array.insults);
        String q = myString[rgenerator.nextInt(myString.length)];
        display(q);
    }

    public void randomCompliment(View view) {
        Resources res = getResources();
        myString = res.getStringArray(R.array.praises);
        String q = myString[rgenerator.nextInt(myString.length)];
        display(q);
    }

    private void display(String message) {
        TextView quantityTextView = (TextView) findViewById(R.id.message);
        quantityTextView.setText(message);
    }

}
