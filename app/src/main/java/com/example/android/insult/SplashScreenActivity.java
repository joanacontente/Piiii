package com.example.android.insult;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Welcome screen activity.
 * <p>Show the app logo and displays a progress bar</p>
 */
public class SplashScreenActivity extends AppCompatActivity {

    @Override
    /**
     * @see AppCompatActivity#onCreate(Bundle)
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_view);

        // Splash screen animation
        Animations.bounce(this, (ImageView) findViewById(R.id.startApp), 0.2f, 20f);

        // Create a delay before showing the main view
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);

    }
}
