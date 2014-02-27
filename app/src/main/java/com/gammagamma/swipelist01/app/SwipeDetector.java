package com.gammagamma.swipelist01.app;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


public class SwipeDetector implements View.OnTouchListener {

    public static enum Action {
        LR, RL, TB, BT, None
    }

    private static final String TAG = "SwipeDetector";
    private static final int VERTICAL_MIN_DISTANCE = 80;
    private static final int HORIZONTAL_MIN_DISTANCE = 40;
    private float downX, downY, upX, upY;
    private Action mSwipeDetected = Action.None;

    public boolean swipeDetected() {
        return mSwipeDetected != Action.None;
    }

    public Action getAction() {
        return mSwipeDetected;
    }

    @Override
    public boolean onTouch( View v, MotionEvent e ) {

        switch ( e.getAction() ) {

            case MotionEvent.ACTION_DOWN:
                downX = e.getX();
                downY = e.getY();
                mSwipeDetected = Action.None;
                return false; // Allow bubbling

            case MotionEvent.ACTION_UP:

                upX = e.getX();
                upY = e.getY();

                float deltaX = ( downX - upX );
                float deltaY = ( downY - upY );

                if ( Math.abs(deltaX) > HORIZONTAL_MIN_DISTANCE ) {

                    // Left or right?

                    if ( deltaX < 0 ) {
                        Log.i( TAG, "Swipe left -> right" );
                        mSwipeDetected = Action.LR;
                        return false;
                    }

                    if ( deltaX > 0 ) {
                        Log.i( TAG, "Swipe right -> left" );
                        mSwipeDetected = Action.RL;
                        return false;
                    }

                }
                else if ( Math.abs(deltaY) > VERTICAL_MIN_DISTANCE ) {

                    // Top or down?

                    if ( deltaY < 0 ) {
                        Log.i( TAG, "Swipe top -> bottom" );
                        mSwipeDetected = Action.TB;
                        return false;
                    }

                    if ( deltaY > 0 ) {
                        Log.i( TAG, "Swipe bottom -> top" );
                        mSwipeDetected = Action.BT;
                        return false;
                    }

                }

                return false;

            }

            return false;

        }
    }
