package com.app.institutehome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;

    String logo_url = "https://upload.wikimedia.org/wikipedia/en/thumb/7/77/Guru_Nanak_Dev_University_logo.jpg/220px-Guru_Nanak_Dev_University_logo.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView logo_image = findViewById(R.id.institute_logo);

        Glide.with(this).load(logo_url).into(logo_image);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_strip);

        tabLayout.setupWithViewPager(viewPager);
    }
}
