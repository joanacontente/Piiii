package com.example.android.insult;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void randomInsult(View view) {
        display("Vai passear");
    }

    public void randomPraise(View view) {
        display("Que bonito!");
    }

    private void display(String message) {
        TextView quantityTextView = (TextView) findViewById(R.id.message);
        quantityTextView.setText(message);
    }

}
