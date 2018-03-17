package com.example.alanj.slideshow;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

//https://www.androidtutorialpoint.com/basics/android-image-slider-tutorial/
public class MainActivity extends AppCompatActivity {
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] test= {R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
    private ArrayList<Integer> XMENArray = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        for(int i=0;i<test.length;i++)
            XMENArray.add(test[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SlideShowAdapter(MainActivity.this,XMENArray));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == test.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
    }
}
