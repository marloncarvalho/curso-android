package net.silvacarvalho.marlon.email;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText para;
	private EditText assunto;
	private EditText texto;
	private Button enviar;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		para = (EditText) findViewById(R.id.para);
		assunto = (EditText) findViewById(R.id.assunto);
		texto = (EditText) findViewById(R.id.texto);
		enviar = (Button) findViewById(R.id.buttonEnviar);

		enviar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				final Intent emailIntent = new Intent();
				emailIntent.setAction(Intent.ACTION_SEND);
				emailIntent.setType("text/plain");

				emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { para.getText().toString() });
				emailIntent.putExtra(Intent.EXTRA_SUBJECT, assunto.getText().toString());
				emailIntent.putExtra(Intent.EXTRA_TEXT, texto.getText().toString());

				startActivity(emailIntent);
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
