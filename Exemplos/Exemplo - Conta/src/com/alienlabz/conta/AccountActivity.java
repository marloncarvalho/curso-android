package com.alienlabz.conta;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AccountActivity extends AccountAuthenticatorActivity {
	private EditText user;
	private EditText password;
	private Button button;
	private AccountManager accountManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account);

		user = (EditText) findViewById(R.id.user);
		password = (EditText) findViewById(R.id.password);
		button = (Button) findViewById(R.id.buttonLogin);
		accountManager = AccountManager.get(this);

		setButtonListener();
	}

	private void setButtonListener() {
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				createAccount();
			}

		});
	}

	private void createAccount() {
		Account account = new Account(user.getText().toString(), "com.alienlabz.account");
		AccountManager am = AccountManager.get(this);
		boolean accountCreated = am.addAccountExplicitly(account, password.getText().toString(), null);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			if (accountCreated) {
				AccountAuthenticatorResponse response = extras
						.getParcelable(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE);
				Bundle result = new Bundle();
				result.putString(AccountManager.KEY_ACCOUNT_NAME, user.getText().toString());
				result.putString(AccountManager.KEY_ACCOUNT_TYPE, "com.alienlabz.account");
				response.onResult(result);
			}
			finish();
		}
	}
}
