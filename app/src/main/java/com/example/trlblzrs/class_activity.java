package com.example.trlblzrs;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class class_activity extends AppCompatActivity {
    TabLayout tab;
    ViewPager2 viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);

        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);

        ViewPagerClassAdapter adapter = new ViewPagerClassAdapter(getSupportFragmentManager(),getLifecycle());
        viewPager.setAdapter(adapter);
        new TabLayoutMediator(tab,viewPager,(tab, position) -> {
            String[] titles = new String[]{"Overview","People","Chat"};
            tab.setText(titles[position]);
            viewPager.setCurrentItem(position);
        }).attach();
        viewPager.setCurrentItem(0);

    }
}