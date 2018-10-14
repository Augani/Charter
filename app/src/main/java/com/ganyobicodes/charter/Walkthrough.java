package com.ganyobicodes.charter;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ganyobicodes.charter.Utils.SlideAdapter;

public class Walkthrough extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;
    SlideAdapter slideAdapter;
    TextView [] theDots;
    Button prev,next;
    int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_walkthrough);

        viewPager = findViewById(R.id.viewPager);
        dotsLayout = findViewById(R.id.dotsLayout);
        slideAdapter = new SlideAdapter(this);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        viewPager.setAdapter(slideAdapter);
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPage == theDots.length - 1){
                    startActivity(new Intent(Walkthrough.this,Home.class));
                    finish();
                }
                viewPager.setCurrentItem(currentPage + 1);
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(currentPage - 1);
            }
        });
    }

    public void addDots(int pos){

        theDots = new TextView[4];
        dotsLayout.removeAllViews();

        for (int i  = 0; i < theDots.length; i++){
            theDots[i] = new TextView(this);
            theDots[i].setText(Html.fromHtml("&#8226;"));
            theDots[i].setTextSize(35);
            theDots[i].setTextColor(getResources().getColor(R.color.primaryDarkColor));
            dotsLayout.addView(theDots[i]);

        }
        if (theDots.length > 0){
            theDots[pos].setTextColor(getResources().getColor(R.color.primaryTextColor));

        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDots(i);
            currentPage = i;
            if (currentPage == 0){
                prev.setEnabled(false);
                next.setEnabled(true);
                prev.setVisibility(View.INVISIBLE);
                next.setText(R.string.cont);
            }else if(i == theDots.length - 1){

                prev.setEnabled(true);
                next.setEnabled(true);
                prev.setVisibility(View.VISIBLE);
                next.setText(R.string.start);
                prev.setText(R.string.goback);

            }else{
                prev.setEnabled(true);
                next.setEnabled(true);
                prev.setVisibility(View.VISIBLE);
                next.setText(R.string.cont);
                prev.setText(R.string.goback);

            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
