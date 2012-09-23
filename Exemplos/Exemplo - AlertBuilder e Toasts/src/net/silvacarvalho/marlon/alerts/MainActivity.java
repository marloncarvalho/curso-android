package net.silvacarvalho.marlon.alerts;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button buttonToast;
	private Button buttonAlert;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		buttonToast = (Button) findViewById(R.id.button1);
		buttonAlert = (Button) findViewById(R.id.button2);

		buttonToast.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_LONG).show();
			}

		});

		buttonAlert.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new Builder(MainActivity.this);
				builder.setCancelable(true)
					.setMessage("Mensagem")
					.setNegativeButton("Negativo", null)
					.setTitle("Titulo")
					.setPositiveButton("Positivo", null)
					.create()
					.show();
			}

		});
	}

}
