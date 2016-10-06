package com.example.android.insult;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * The Piiiiii application is a simple application that simply displays complements and/or insults
 * giving the possibility of listening the complement/insult.
 *
 * <p><b>DISCLAIM: </b>Nós não nos responsabilizamos pelo mau use desta app, OK? Ah ah ah.</p>
 */
public class MainActivity extends AppCompatActivity {

    private Display display;
    private TextView txtViewMessage;
    private SentenceSelector sentenceSelector;
    private TextToSpeech textToSpeech;            // Convert text to an audio format
    private ImageButton btnAudio;
    private String stringToSpeech;

    @Override
    /**
     * Initialize the class variables.
     * @see AppCompatActivity#onCreate(Bundle)
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize class variable
        txtViewMessage = (TextView) findViewById(R.id.message);
        btnAudio = (ImageButton) findViewById(R.id.audioButton);
        display = new Display();
        sentenceSelector = new SentenceSelector(getResources());

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(new Locale("pt"));
                }
            }
        });

        btnAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = stringToSpeech;
                textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

    }

    @Override
    /**
     * Stops and shutdown the textToSpeech if it is running.
     * @see AppCompatActivity#onPause()
     */
    public void onPause(){
        if(textToSpeech != null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }

        super.onPause();
    }

    /**
     * Show and animate the insult button.
     * @param view
     */
    public void randomInsult(View view) {
        Animations.bounce(this, (ImageButton) findViewById(R.id.insults), 0.2f, 20f);
        stringToSpeech = sentenceSelector.getRandomInsult();
        display.message(txtViewMessage, stringToSpeech);
    }

    /**
     * Show and animate the compliment button.
     * @param view
     */
    public void randomCompliment(View view) {
        Animations.bounce(this, (ImageButton) findViewById(R.id.compliments), 0.2f, 20f);
        stringToSpeech = sentenceSelector.getRandomCompliment();
        display.message(txtViewMessage, stringToSpeech);
    }

    /**
     * Display the disclaim message.
     * @param view
     */
    public void showDisclaimMessage(View view){
        String disclaimer = getResources().getString(R.string.disclaimer);
        stringToSpeech = disclaimer;
        display.message(txtViewMessage, disclaimer);
    }

}
