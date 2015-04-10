package com.example.recipe_sql;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class FirstScreen extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.firstscreen);

		Thread background = new Thread() {
			public void run() {
				try {
					sleep(3000);
					Intent i = new Intent(getBaseContext(), MainActivity.class);
					startActivity(i);
					finish();
				} catch (Exception e) {
				}
			}

		};
		background.start();

	}

	@Override
	protected void onDestroy() {

		super.onDestroy();

	}
}
