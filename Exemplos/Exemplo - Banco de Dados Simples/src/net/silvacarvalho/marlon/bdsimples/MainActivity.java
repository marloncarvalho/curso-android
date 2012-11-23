package net.silvacarvalho.marlon.bdsimples;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {
	private static final int BANCODEDADOS_VERSION = 1;
	private static final String BANCODEDADOS_SQLITE = "bancodedados.sqlite";
	private Button button;
	private ListView listView;
	private DBOpenHelper helper;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		helper = new DBOpenHelper(this, BANCODEDADOS_SQLITE, null, BANCODEDADOS_VERSION);
		
		button = (Button) findViewById(R.id.button1);
		listView = (ListView) findViewById(R.id.listView);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				final ContentValues values = new ContentValues();
				values.put("nome", "Nome de Teste");
				values.put("email", "teste@teste.com.br");
				helper.getWritableDatabase().insert("tabela", null, values);

				atualizarListView();
			}

		});
	}

	private void atualizarListView() {
		final Cursor cursor = helper.getWritableDatabase().query(DBOpenHelper.TABELA, null, null, null, null, null,
				null);
		final String[] columns = new String[] { "nome", "email" };
		final int[] to = new int[] { R.id.nome, R.id.email };
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.listview_item, cursor, columns, to, 0);
		listView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
