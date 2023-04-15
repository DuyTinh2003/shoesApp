package com.example.shoesapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.shoesapp.R;

public class OnBoardingAdapter extends PagerAdapter {

    Context context;

    int images[] = {
            R.drawable.spring_prev_ui1,
            R.drawable.spring_prev_ui2,
            R.drawable.spring_prev_ui3,
    };

    int headings[] = {
            R.string.heading_onBoarding1,
            R.string.heading_onBoarding2,
            R.string.heading_onBoarding3,
    };

    int description[] = {
            R.string.title_onBoarding1,
            R.string.title_onBoarding2,
            R.string.title_onBoarding3,
    };

    public OnBoardingAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout, container, false);
        ImageView slidetitleimage = (ImageView) view.findViewById(R.id.image_slide);
        TextView slideHeading = (TextView) view.findViewById(R.id.heading_slide);
        TextView slideDesciption = (TextView) view.findViewById(R.id.title_slide);

        slidetitleimage.setImageResource(images[position]);
        slideHeading.setText(headings[position]);
        slideDesciption.setText(description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}