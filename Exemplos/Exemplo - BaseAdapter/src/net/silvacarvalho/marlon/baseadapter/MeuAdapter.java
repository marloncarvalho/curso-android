package net.silvacarvalho.marlon.baseadapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MeuAdapter extends BaseAdapter {
	private List<String> lista = new ArrayList<String>();
	private Context context;

	public MeuAdapter(Context context) {
		this.context = context;
		lista.add("Teste 1");
		lista.add("Teste 2");
		lista.add("Teste 3");
		lista.add("Teste 4");
		lista.add("Teste 5");
		lista.add("Teste 6");
		lista.add("Teste 7");
	}

	@Override
	public int getCount() {
		return lista.size();
	}

	@Override
	public Object getItem(int position) {
		return lista.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, null);
		}
		
		TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
		textView.setText(lista.get(position));
		
		return convertView;
	}
}
