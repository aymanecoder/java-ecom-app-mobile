package com.ex.ecommerceapplication.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ex.ecommerceapplication.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    int imageArray[] = {
            R.drawable.onboardscreen1,
            R.drawable.onboardscreen2,
            R.drawable.onboardscreen3
    };

    int headingArray[] = {
            R.string.first_slide,
            R.string.second_slide,
            R.string.third_slide
    };

    int descriptionArray[] = {
            1,
            2,
            3
    };

    @Override
    public int getCount() {
        return headingArray.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull @androidx.annotation.NonNull View view, @NonNull @androidx.annotation.NonNull Object o) {
        return view == (ConstraintLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup Container, int Position){

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.sliding_layout,Container,false);

        ImageView imageView = view.findViewById(R.id.slider_img);
        ImageView heading = view.findViewById(R.id.heading);
        ImageView description = view.findViewById(R.id.description);

        imageView.setImageResource(imageArray[Position]);
        heading.setTextAlignment(headingArray[Position]);
        description.setTextAlignment(descriptionArray[Position]);

        Container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup Container, int Position, @NonNull Object o){
                    Container.removeView((androidx.constraintlayout.widget.ConstraintLayout)o);
    }
}
