package com.alienlabz.actionbar.tabswipe;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.alienlabz.actionbar.R;

public class TabSwipeActivity extends FragmentActivity {
	private ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab_swipe);

		Fragment fragmentTab1 = new Tab1();
		Fragment fragmentTab2 = new Tab2();

		PagerAdapter mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
		mPagerAdapter.addFragment(fragmentTab1);
		mPagerAdapter.addFragment(fragmentTab2);

		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mPagerAdapter);
		mViewPager.setOffscreenPageLimit(2);
		mViewPager.setCurrentItem(0);
		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				getActionBar().setSelectedNavigationItem(position);
			}

		});

		ActionBar ab = getActionBar();
		ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		Tab tab1 = ab.newTab().setText("Tab One")
				.setTabListener(new TabListener<Tab1>(this, "tabone", Tab1.class, mViewPager));
		Tab tab2 = ab.newTab().setText("Tab Two")
				.setTabListener(new TabListener<Tab2>(this, "tabtwo", Tab2.class, mViewPager));

		ab.addTab(tab1);
		ab.addTab(tab2);
	}

	public class PagerAdapter extends FragmentPagerAdapter {

		private final ArrayList<Fragment> mFragments = new ArrayList<Fragment>();

		public PagerAdapter(FragmentManager manager) {
			super(manager);
		}

		public void addFragment(Fragment fragment) {
			mFragments.add(fragment);
			notifyDataSetChanged();
		}

		@Override
		public int getCount() {
			return mFragments.size();
		}

		@Override
		public Fragment getItem(int position) {
			return mFragments.get(position);
		}
	}
}
