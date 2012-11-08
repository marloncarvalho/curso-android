package com.alienlabz.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ListView listView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) findViewById(R.id.listView1);

		new AsyncTask<Void, Void, ArrayAdapter<String>>() {

			@Override
			protected ArrayAdapter<String> doInBackground(Void... params) {
				String strJson = HttpUtil
						.doGet("http://sandbox.buscape.com/service/findProductList/72577349624e6c685068513d/?keyword=keyword&format=json");

				ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
						android.R.layout.simple_list_item_1, android.R.id.text1);

				try {

					JSONObject json = new JSONObject(strJson);
					JSONArray array = json.getJSONArray("product");

					for (int index = 0, length = array.length(); index < length; index++) {
						JSONObject jsonObject = array.getJSONObject(index);
						JSONObject jsonProduct = jsonObject.getJSONObject("product");
						adapter.add(jsonProduct.getString("productname"));
					}

				} catch (JSONException e) {
					e.printStackTrace();
				}

				return adapter;
			}

			protected void onPostExecute(android.widget.ArrayAdapter<String> result) {
				listView.setAdapter(result);
			}

		}.execute();
	}
}
