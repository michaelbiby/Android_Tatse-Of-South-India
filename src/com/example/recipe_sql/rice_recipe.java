package com.example.recipe_sql;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class rice_recipe extends Activity {

	Button malabar;
	Button thalassery;
	Button hyderabad;
	Button kozhi;
	ImageView ImageView1;
	Intent i;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.rice_recipe);
		thalassery = (Button) findViewById(R.id.thalassery);
		malabar = (Button) findViewById(R.id.malabar);
		hyderabad = (Button) findViewById(R.id.hyderabad);
		kozhi = (Button) findViewById(R.id.kozhi);
		ImageView ImageView = (ImageView)findViewById(R.id.image1);
		thalassery.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				i = new Intent(getApplicationContext(), detail.class);
				i.putExtra("name", "Thalassery Biriyani");
				startActivity(i);

			}
		});

		malabar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				i = new Intent(getBaseContext(), detail.class);
				i.putExtra("name", "Malabari Biriyani");
				startActivity(i);
			}
		});

		hyderabad.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				i = new Intent(getBaseContext(), detail.class);
				i.putExtra("name", "Hyderabadi Biriyani");
				startActivity(i);
			}
		});

		kozhi.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				i = new Intent(getBaseContext(), detail.class);
				i.putExtra("name", "Kozhikodan Biriyani");
				startActivity(i);
			}
		});
	}
}
