package com.example.android.insult;

import android.content.res.Resources;

import java.util.Random;

/**
 * Class responsible for select random sentences from the complements and insults resources.
 */
public class SentenceSelector {

    private static final Random rGenerator = new Random();
    private Resources res;

    /**
     * Constructor method.
     * <p>Need to have access to the resource folder to select sentences from the compliments
     * and insults array</p>
     * @param res Resource object.
     */
    public SentenceSelector(Resources res) {
        this.res = res;
    }

    /**
     * @return Compliment.
     */
    public String getRandomCompliment() {
        String[] setences = res.getStringArray(R.array.compliments);
        return setences[rGenerator.nextInt(setences.length)];
    }

    /**
     * @return Insult.
     */
    public String getRandomInsult() {
        String[] setences = res.getStringArray(R.array.insults);
        return setences[rGenerator.nextInt(setences.length)];
    }

}
