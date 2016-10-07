package com.example.android.insult;

/**
 * Interpolator class which defines the animation bounciness.
 */
class BounceInterpolator implements android.view.animation.Interpolator {

    private double mAmplitude;
    private double mFrequency;

    /**
     * Constructor method for creating a bounce interpolator.
     * @param amplitude Bounce amplitude.
     * @param frequency Frequency amplitude.
     */
    public BounceInterpolator(double amplitude, double frequency) {
        mAmplitude = amplitude;
        mFrequency = frequency;
    }

    /**
     * Calculate the elapsed fraction of an animation to a value that
     * represents the interpolated fraction.
     * @param time  Duration of the animation.
     * @return      Interpolation value.
     */
    public float getInterpolation(float time) {
        return (float) (-1 * Math.pow(Math.E, -time / mAmplitude) *
                Math.cos(mFrequency * time) + 1);
    }

}