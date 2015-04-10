package com.example.recipe_sql;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ClipData.Item;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class detail extends rice_recipe {


	private String name;
	TextView cat;
	TextView ing;
	TextView des;

	Cursor tb;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		 
		setContentView(R.layout.detail);
		name = getIntent().getExtras().getString("name");
		cat = (TextView) findViewById(R.id.category);
		ing = (TextView) findViewById(R.id.ingList);
		des = (TextView) findViewById(R.id.desList);

		DBClass data = new DBClass(this);
		try {
			data.createDataBase();
			data.openDataBase();
			String Item_name="";
			String Ingredients="";
			String description="";

			// tb=data.getRecipe(name);
			tb = data.getRecipe(name);
			tb.moveToFirst();
			while (tb.isAfterLast() == false) {

				Item_name = tb.getString(0);
				Ingredients = tb.getString(1);
				description = tb.getString(2);
				tb.moveToNext();
			}

			cat.setText(Item_name);
			ing.setText(Ingredients);
			des.setText(description);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) {
		 * 
		 * 
		 * // TODO Auto-generated method stub } });
		 */

	}
}
