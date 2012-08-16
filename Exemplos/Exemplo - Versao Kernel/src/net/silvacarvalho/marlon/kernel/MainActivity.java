package net.silvacarvalho.marlon.kernel;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView tv = new TextView(this);
		tv.setText(System.getProperty("os.version"));
		setContentView(tv);
	}

}
