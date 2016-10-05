package com.example.android.insult;

import android.widget.TextView;

/**
 * Class responsible for showing the output on the screen.
 */
public class Display {

    /**
     * Display a simple message on the screen.
     * @param quantityTextView  Target TextVIew for displaying the message.
     * @param message           Message to be shown.
     */
    public void message(TextView quantityTextView, String message) {
        quantityTextView.setText(message);
    }

}
