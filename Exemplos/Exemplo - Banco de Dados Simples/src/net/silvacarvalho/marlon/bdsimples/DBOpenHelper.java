package net.silvacarvalho.marlon.bdsimples;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {
	public static final String TABELA = "tabela";

	public DBOpenHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		final StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE tabela (");
		sql.append("_id INTEGER PRIMARY KEY AUTOINCREMENT,");
		sql.append("nome TEXT,");
		sql.append("email TEXT");
		sql.append(")");
		database.execSQL(sql.toString());
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
	}

}