package com.example.shoesapp.layout;

import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shoesapp.R;
import com.example.shoesapp.adapter.OnBoardingAdapter;

import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OnBoarding extends AppCompatActivity {

    ViewPager mSLideViewPager;
    LinearLayout mDotLayout;
    Button nextbtn;

    TextView[] dots;
    OnBoardingAdapter onBoardingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboard);

        nextbtn = findViewById(R.id.nextCard);

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getitem(0) < 2) {
                    if(getitem(0) ==0) {
                        nextbtn.setText("Next");
                    }
                    mSLideViewPager.setCurrentItem(getitem(1),true);
                }

                else {
                    Intent i = new Intent(OnBoarding.this,Login.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        mSLideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);
        onBoardingAdapter = new OnBoardingAdapter(this);
        mSLideViewPager.setAdapter(onBoardingAdapter);
        setUpindicator(0);
        mSLideViewPager.addOnPageChangeListener(viewListener);

    }

    public void setUpindicator(int position){
        dots = new TextView[3];
        mDotLayout.removeAllViews();
        for (int i = 0 ; i < dots.length ; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                dots[i].setTextColor(getResources().getColor(R.color.inactive,getApplicationContext().getTheme()));
            }
            mDotLayout.addView(dots[i]);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            dots[position].setTextColor(getResources().getColor(R.color.active, getApplicationContext().getTheme()));
        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setUpindicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };
    private int getitem(int i){
        return mSLideViewPager.getCurrentItem() + i;
    }

}