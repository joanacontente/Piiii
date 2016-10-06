package com.example.android.insult;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Static class responsible for animate buttons.
 */
public class Animations {

    /**
     * Give a bouncing animation to a given button.
     * <p>Uses the AnimationUtils to load and set an interpolator to the animation </p>
     * <p>Uses the BounceInterpolator class for calculate the elapsed fraction of the animation</p>
     * @param context   Application context.
     * @param button    Button to be animated.
     * @param amplitude Amplitude of the animation.
     * @param frequency Frequency of the animation.
     */
    public static void bounce(Context context, ImageView button, float amplitude, float frequency) {
        Animation myAnim = AnimationUtils.loadAnimation(context, R.anim.animation);

        // Use animation.xml interpolator with amplitude 0.2 and frequency 20
        BounceInterpolator interpolator = new BounceInterpolator(amplitude, frequency);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
    }

}
