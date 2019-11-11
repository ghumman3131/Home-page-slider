package com.app.institutehome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;

    String logo_url = "https://upload.wikimedia.org/wikipedia/en/thumb/7/77/Guru_Nanak_Dev_University_logo.jpg/220px-Guru_Nanak_Dev_University_logo.jpg";


    // images url array for slider images

    private String [] images = {"https://images.static-collegedunia.com/public/college_data/images/campusimage/1410847670gndu4.jpg",
            "https://www.hindustantimes.com/rf/image_size_960x540/HT/p2/2018/06/02/Pictures/_683dc2aa-6642-11e8-a998-12ee0acfa260.jpg",
            "http://online.gndu.ac.in/assets/images/logo/photo-gallery-18s.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView logo_image = findViewById(R.id.institute_logo);

        Glide.with(this).load(logo_url).into(logo_image);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this , images);

        viewPager.setAdapter(viewPagerAdapter);


        TabLayout tabLayout = findViewById(R.id.tab_strip);

        tabLayout.setupWithViewPager(viewPager);


        // scheduling slider timer

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);
    }


    // class for auto sliding images

    private class SliderTimer extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() < images.length - 1) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }


}
