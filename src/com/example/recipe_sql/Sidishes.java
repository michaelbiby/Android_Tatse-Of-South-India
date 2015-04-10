package com.example.recipe_sql;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Sidishes extends Activity {

	Button chettinad;
	Button korma;
	Button tikka;
	Button molee;
	ImageView Image1;
	Intent in;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.sidishes);
		chettinad = (Button) findViewById(R.id.chettinad);
		korma = (Button) findViewById(R.id.korma);
		tikka = (Button) findViewById(R.id.tikka);
		molee = (Button) findViewById(R.id.molee);
		ImageView ImageView = (ImageView) findViewById(R.id.image1);
		chettinad.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				in = new Intent(getApplicationContext(), Side.class);
				in.putExtra("name", "Chettinad Chicken Curry");
				startActivity(in);

			}
		});

		korma.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				in = new Intent(getBaseContext(), Side.class);
				in.putExtra("name", "Hyderabadi Mutton Korma");
				startActivity(in);
			}
		});

		tikka.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				in = new Intent(getBaseContext(), Side.class);
				in.putExtra("name", "Chennaiyan Chicken Tikka");
				startActivity(in);
			}
		});

		molee.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				in = new Intent(getBaseContext(), Side.class);
				in.putExtra("name", "Special Kerala Fish Molee");
				startActivity(in);
			}
		});
	}

}
