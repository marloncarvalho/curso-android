package com.alienlabz.actionbar;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class NarrowActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_narrow);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_narrow, menu);
        return true;
    }
}
