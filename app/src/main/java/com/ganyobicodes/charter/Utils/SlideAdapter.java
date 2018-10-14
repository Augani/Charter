package com.ganyobicodes.charter.Utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ganyobicodes.charter.R;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context) {
        this.context = context;
    }

    public int [] slideImages = {
            R.drawable.ic_directions_bus_black_24dp,
            R.drawable.ic_airline_seat_recline_normal_black_24dp,
            R.drawable.ic_phone_android_black_24dp,
            R.drawable.ic_trending_down_black_24dp

    };

    public int [] slideDesc = {
            R.string.getRides,
            R.string.bookSeat,
            R.string.mobilepay,
            R.string.discount

    };

    @Override
    public int getCount() {
        return slideImages.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView imageView = view.findViewById(R.id.theimage);
        TextView desc = view.findViewById(R.id.desc);

        imageView.setImageResource(slideImages[position]);
        desc.setText(slideDesc[position]);

        container.addView(view);


        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
