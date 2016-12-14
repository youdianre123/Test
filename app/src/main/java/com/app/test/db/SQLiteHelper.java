package com.app.test.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "halloword.db"; //数据库名
	private static final int DATABASE_VERSION = 2;
	
	private static final String TABLE_NEW_WORD = "new_word";//生词表
	
	public static final String CREATE_TABLE_NEW_WORD = "CREATE TABLE " + TABLE_NEW_WORD + 
					"(" +
					 //"pro_id INTEGER AUTO_INCREMENT,"+ //not work
					 "id varchar(32) PRIMARY KEY,"+ //fixed by  bone-lee
					 "name varchar(50) DEFAULT NULL,"+
					 "spech varchar(50) DEFAULT NULL,"+
					 "content varchar(1000) DEFAULT NULL,"+
					 "list_index integer(3) DEFAULT NULL,"+
					 "type integer(2) DEFAULT NULL,"+
					 "create_time timestamp,"+
					 "update_time timestamp"+
					 //"PRIMARY KEY (`pro_id`)"+
					") ";
	
	
	public SQLiteHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 用于创建数据库,没有则创建,有则返回(不会进行升级操作)
	 */
	public SQLiteHelper(Context context) {
		this(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_NEW_WORD);
	}
	
	/**
	 * 升级数据库使用.需要指定的新的版本号
	 */
	public SQLiteHelper(Context context,int version) {
		this(context, DATABASE_NAME, null, version);
	}

	/**
	 * 升级数据库
	 */
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	
	}

	public void recreateNewWordTable(SQLiteDatabase db) {
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_NEW_WORD);
		db.execSQL(CREATE_TABLE_NEW_WORD);
	}
}
