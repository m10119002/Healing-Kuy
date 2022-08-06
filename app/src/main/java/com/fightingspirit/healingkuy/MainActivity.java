package com.fightingspirit.healingkuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    NavigationBarView bot_nav;
    private Fragment profilFragment;
    private Fragment lokasiFragment;
    private static final int NUM_PAGES = 2;
    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavigationBarView bot_nav = findViewById(R.id.bottom_navigation);
        profilFragment = new ProfilFragment();
        lokasiFragment = new ListWisataFragment();

        viewPager = findViewById(R.id.pager2_main);
        pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        bot_nav.setSelectedItemId(R.id.ic_profil);
                        break;
                    case 1:
                        bot_nav.setSelectedItemId(R.id.ic_lokasi);
                        break;
                }
            }
        });
        bot_nav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.ic_profil:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.ic_lokasi:
                    viewPager.setCurrentItem(1);
                    break;
            }
            return true;
        });

        bot_nav.setSelectedItemId(R.id.ic_lokasi);
    }

    // 10119002 - Firman Sahita - IF1
    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new ProfilFragment();
                case 1:
                    return new ListWisataFragment();
            }
            return new ListWisataFragment();
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }
}