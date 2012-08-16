package net.silvacarvalho.marlon.conectividade;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ListView listView;
	private Button button;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (ListView) findViewById(R.id.listView);
		button = (Button) findViewById(R.id.button1);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new AsyncTask<Void, Void, String>() {

					@Override
					protected String doInBackground(Void... params) {
						return HttpUtil.doGet("http://api.twitter.com/1/statuses/public_timeline.json");
					}

					@Override
					protected void onPostExecute(String result) {
						try {
							final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
									android.R.layout.simple_list_item_1, android.R.id.text1);
							final JSONArray jsonArray = new JSONArray(result);

							for (int i = 0; i < jsonArray.length(); i++) {
								final JSONObject object = jsonArray.getJSONObject(i);
								adapter.add(object.getString("text"));

							}

							listView.setAdapter(adapter);
						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
				}.execute();

			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
