package net.silvacarvalho.marlon.rotacao;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.OrientationEventListener;
import android.widget.Toast;

public class RotacaoPorListenerActivity extends Activity {
	private OrientationEventListener oel;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rotacao_por_listener);

		oel = new OrientationEventListener(this) {

			@Override
			public void onOrientationChanged(int orientation) {
				Toast.makeText(RotacaoPorListenerActivity.this, "->" + orientation , Toast.LENGTH_SHORT).show();
			}

		};

	}

	@Override
	protected void onResume() {
		super.onResume();
		oel.enable();
	}

	@Override
	protected void onPause() {
		super.onPause();
		oel.disable();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_rotacao_por_listener, menu);
		return true;
	}
}
