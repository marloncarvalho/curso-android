package com.alienlabz.actionbar.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.alienlabz.actionbar.R;

public class ViewPagerActivity extends FragmentActivity {

	private MyAdapter mAdapter;
	private ViewPager mPager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_pager);
		mAdapter = new MyAdapter(getSupportFragmentManager());

		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);
	}

	public static class MyAdapter extends FragmentPagerAdapter {
		
		public MyAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
	    public CharSequence getPageTitle(int position) {
	        return "Page #" + ( position + 1 );
	    }
		
		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				return new ViewPagerDetailFragment();
			case 1:
				return new ViewPagerDetail2Fragment();
			case 2:
				return new ViewPagerDetailFragment();

			default:
				return null;
			}
		}
	}

}
