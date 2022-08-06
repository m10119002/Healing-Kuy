package com.fightingspirit.healingkuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// 6 Juli 2022, 10119032, Ginanjar Tubagus Gumilar, IF1
public class TentangActivity extends AppCompatActivity {

    ViewPager viewPager;
    Button tombolVP;
    int[] layouts;
    Adapter_VP adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);

        viewPager = findViewById(R.id.Pager);
        tombolVP = findViewById(R.id.tombolSelanjutnya);

        layouts = new int[]{
                R.layout.open1,
                R.layout.open2,
                R.layout.open3
        };

        adapter = new Adapter_VP(this, layouts);
        viewPager.setAdapter(adapter);
        tombolVP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() + 1 < layouts.length) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                } else {
                    //kembali ke main activity
                    startActivity(new Intent(TentangActivity.this, MainActivity.class));
                    finish();
                }
            }
        });

        viewPager.addOnPageChangeListener(viewPagerChangeListener);
    }

    ViewPager.OnPageChangeListener viewPagerChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            if(i == layouts.length -1 ){
                tombolVP.setText("Mulai");
            }else {
                tombolVP.setText("Lanjut");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}