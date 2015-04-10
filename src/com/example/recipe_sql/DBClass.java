package com.example.recipe_sql;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBClass extends SQLiteOpenHelper {

	private static String DB_PATH = "";
	private static final String DATABASE_NAME = "recipeDataBase";
	private static final int DATABASE_VERSION = 1;
	static final String TABLE_NAME = "RecipeDataTable";
	public Context context;
	static SQLiteDatabase sqliteDataBase;

	public DBClass(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		if (android.os.Build.VERSION.SDK_INT >= 17) {
			DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
		} else {
			DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
		}
		this.context = context;
	}

	public void createDataBase() throws IOException {
		boolean databaseExist = checkDataBase();

		if (databaseExist) {
			// Do Nothing.
		} else {
			this.getWritableDatabase();
			copyDataBase();
		}
	}

	public boolean checkDataBase() {
		File databaseFile = new File(DB_PATH + DATABASE_NAME);
		return databaseFile.exists();
	}

	private void copyDataBase() throws IOException {
		InputStream myInput = context.getAssets().open(DATABASE_NAME);
		String outFileName = DB_PATH + DATABASE_NAME;
		OutputStream myOutput = new FileOutputStream(outFileName);
		byte[] buffer = new byte[1024];
		int length;
		while ((length = myInput.read(buffer)) > 0) {
			myOutput.write(buffer, 0, length);
		}
		myOutput.flush();
		myOutput.close();
		myInput.close();
	}

	public void openDataBase() throws SQLException {
		String myPath = DB_PATH + DATABASE_NAME;
		sqliteDataBase = SQLiteDatabase.openDatabase(myPath, null,
				SQLiteDatabase.OPEN_READWRITE);
	}

	@Override
	public synchronized void close() {
		if (sqliteDataBase != null)
			sqliteDataBase.close();
		super.close();
	}

	List<String> rec = new ArrayList<String>();

	public Cursor getRecipe(String name) {
		System.out.println("Entered getrecipe" + name);
		String query = "select Item_Name,Ingredients,description  From "
				+ TABLE_NAME + " where Item_name= ?";
		Cursor cursor = sqliteDataBase.rawQuery(query, new String[] { name });
		System.out.println("after cursor" + name);
		System.out.println("cursor count" + cursor.getCount());

		return cursor;
	}

	// public void getRecipe() {
	// System.out.println("Entered getrecipe");
	// String query =
	// "select Item_name, Ingredients,description  From "+TABLE_NAME;
	// Cursor cursor = sqliteDataBase.rawQuery(query, null);
	// cursor.moveToFirst();
	// while (cursor.isAfterLast() == false) {
	//
	// System.out.println("value from db: " + cursor.getString(0));
	// System.out.println("value from db: " + cursor.getString(1));
	// //System.out.println("value from db: " + cursor.getString(2));
	// cursor.moveToNext();
	// if(cursor.isAfterLast() == true){
	// System.out.println("inside if ....");
	// break;
	// }
	//
	// }
	//
	//
	// }

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
