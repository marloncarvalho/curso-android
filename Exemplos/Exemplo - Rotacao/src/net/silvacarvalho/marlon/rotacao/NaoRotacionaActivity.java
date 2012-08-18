package net.silvacarvalho.marlon.rotacao;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class NaoRotacionaActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nao_rotaciona);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_nao_rotaciona, menu);
        return true;
    }
}
