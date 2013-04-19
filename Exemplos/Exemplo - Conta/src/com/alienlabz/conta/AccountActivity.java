package com.alienlabz.conta;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AccountActivity extends AccountAuthenticatorActivity {
	private EditText username;
	private EditText password;
	private Button button;

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_account);

		username = (EditText) findViewById(R.id.user);
		password = (EditText) findViewById(R.id.password);
		button = (Button) findViewById(R.id.buttonLogin);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Account account = new Account(username.getText().toString(), getString(R.string.account_type));
				AccountManager accountManager = AccountManager.get(AccountActivity.this);
				boolean created = accountManager.addAccountExplicitly(account, password.getText().toString(), null);

				if (created) {
					Bundle result = new Bundle();
					result.putString(AccountManager.KEY_ACCOUNT_NAME, username.getText().toString());
					result.putString(AccountManager.KEY_ACCOUNT_TYPE, getString(R.string.account_type));
					setAccountAuthenticatorResult(result);
					finish();
				}
			}

		});
	}

}
