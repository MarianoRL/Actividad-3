package com.example.androidstudio.actividad3;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener{

    private static final String DEBUG_TAG = "Gestures";
    private GestureDetectorCompat mDetector;

    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(this,this);
        // Set the gesture detector as the double tap
        // listener.
        mDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        TextView textView = findViewById(R.id.hello_world);
        textView.setText("Coordenadas de Toque: " +
                String.valueOf(event.getX()) + "x" + String.valueOf(event.getY()));
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        changeBackgroundColor(Color.BLUE);
        TextView textView = findViewById(R.id.hello_world);
        textView.setTextColor(Color.GREEN);
        textView.setTextSize(20);
        textView.setText("OnDown");
        Log.d(DEBUG_TAG,"On Down: " + event.toString());
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        changeBackgroundColor(Color.YELLOW);
        TextView textView = findViewById(R.id.hello_world);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(20);
        textView.setText("OnFling");
        Log.d(DEBUG_TAG, "On Fling: " + event1.toString() + event2.toString());
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        changeBackgroundColor(Color.GREEN);
        TextView textView = findViewById(R.id.hello_world);
        textView.setTextColor(Color.BLUE);
        textView.setTextSize(20);
        textView.setText("OnLongPress");
        Log.d(DEBUG_TAG, "Long Press: " + event.toString());
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX,
                            float distanceY) {
        changeBackgroundColor(Color.RED);
        TextView textView = findViewById(R.id.hello_world);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(20);
        textView.setText("OnScroll");
        Log.d(DEBUG_TAG, "Scroll: " + event1.toString() + event2.toString());
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        changeBackgroundColor(Color.CYAN);
        TextView textView = findViewById(R.id.hello_world);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(20);
        textView.setText("OnShowPress");
        Log.d(DEBUG_TAG, "Show Press: " + event.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        changeBackgroundColor(Color.LTGRAY);
        TextView textView = findViewById(R.id.hello_world);
        textView.setTextColor(Color.CYAN);
        textView.setTextSize(20);
        textView.setText("OnSingleTapUp");
        Log.d(DEBUG_TAG, "Single Tap Up: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        changeBackgroundColor(Color.DKGRAY);
        TextView textView = findViewById(R.id.hello_world);
        textView.setTextColor(Color.GREEN);
        textView.setTextSize(20);
        textView.setText("OnDoubleTap");
        Log.d(DEBUG_TAG, "Double Tap: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        changeBackgroundColor(Color.BLACK);
        TextView textView = findViewById(R.id.hello_world);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(20);
        textView.setText("OnDoubleTapEvent");
        Log.d(DEBUG_TAG, "Double Tap Event: " + event.toString());
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        changeBackgroundColor(Color.MAGENTA);
        TextView textView = findViewById(R.id.hello_world);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(20);
        textView.setText("OnTapConfirmed");
        Log.d(DEBUG_TAG, "Single Tap: " + event.toString());
        return true;
    }

    public void changeBackgroundColor(int color) {
        RelativeLayout view  = findViewById(R.id.main_layout);
        Drawable background = view.getBackground();
        int colorFrom = Color.TRANSPARENT;
        if (background instanceof ColorDrawable)
            colorFrom = ((ColorDrawable) background).getColor();
        int colorTo = color;
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(250); // milliseconds
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                RelativeLayout view  = findViewById(R.id.main_layout);
                view.setBackgroundColor((int) animator.getAnimatedValue());
            }

        });
        colorAnimation.start();


//        view.setBackgroundColor(color);
    }
}