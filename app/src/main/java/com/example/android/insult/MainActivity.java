package com.example.android.insult;

import android.content.res.Resources;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String[] myString;
    private static final Random rGenerator = new Random();
    private TextToSpeech t1;
    private ImageButton b1;
    private String stringToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_view);
        didTapButton(R.id.startApp);
    }

    public void startApp(View view){
        setContentView(R.layout.activity_main);

        b1=(ImageButton) findViewById(R.id.audioButton);

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(new Locale("pt"));
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = stringToSpeech;
                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }

    public void randomInsult(View view) {
        didTapButton(R.id.insults);
        Resources res = getResources();
        myString = res.getStringArray(R.array.insults);
        stringToSpeech = myString[rGenerator.nextInt(myString.length)];
        display(stringToSpeech);
    }

    public void randomCompliment(View view) {
        didTapButton(R.id.compliments);
        Resources res = getResources();
        myString = res.getStringArray(R.array.compliments);
        stringToSpeech = myString[rGenerator.nextInt(myString.length)];
        display(stringToSpeech);
    }

    private void display(String message) {
        TextView quantityTextView = (TextView) findViewById(R.id.message);
        quantityTextView.setText(message);
    }

    public void disclaimMessage(View view){
        Resources res = getResources();
        String disclaimer = res.getString(R.string.disclaimer);
        stringToSpeech = disclaimer;
        display(disclaimer);
    }

    public void didTapButton(int id) {
        ImageButton button = (ImageButton)findViewById(id);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce.xml interpolator with amplitude 0.2
        // and frequency 20
        com.example.android.insult.BounceInterpolator interpolator = new com.example.android.insult.BounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
    }
}
