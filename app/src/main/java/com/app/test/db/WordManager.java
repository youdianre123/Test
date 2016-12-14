package com.app.test.db;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.test.entity.Word;

public class WordManager {
	private SQLiteHelper helper;
	private static final String TABLE_NEW_WORD = "tb_dict";//生词表

	public WordManager(Context context) {
		helper = new SQLiteHelper(context);
	}
	
	/**
	 * 为升级数据库而用
	 */
	public WordManager(Context ctx,int version){
		helper = new SQLiteHelper(ctx,version); 
	}
	
	public boolean delAllNewWordFromList(){
		
		SQLiteDatabase db = helper.getWritableDatabase();
		
		String deleteQuery = "DELETE FROM " + TABLE_NEW_WORD;
		
		db.beginTransaction();
		try {

			db.execSQL(deleteQuery);
			db.setTransactionSuccessful();
		}
		finally{
			db.endTransaction();
			db.close();
		}
		return true;
	}
	
	/**
	 * recreate new word table
	 * add by bone-lee
	 */
	public void recreateNewWordTable(){
		SQLiteDatabase db = helper.getWritableDatabase();
		helper.recreateNewWordTable(db);
	}

	public List<Word> getByIndex(String index){
		SQLiteDatabase db = helper.getReadableDatabase();
        String selectQuery = "select * from where list_index = ? " + TABLE_NEW_WORD;
        List<Word> wordList = new ArrayList<Word>();
        try{
            Cursor cursor = db.rawQuery(selectQuery, new String[]{index});
            while(cursor.moveToNext()){
                Word word = new Word();
                word.setName(cursor.getString(cursor.getColumnIndex("name")));
                word.setSpeech(cursor.getString(cursor.getColumnIndex("speech")));
                word.setContent(cursor.getString(cursor.getColumnIndex("content")));
                word.setListIndex(cursor.getInt(cursor.getColumnIndex("list_index")));
                word.setType(cursor.getInt(cursor.getColumnIndex("type")));
                wordList.add(word);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            db.close();
        }
        return wordList;
	}

    public void updateType(String name, String type){
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "update " + TABLE_NEW_WORD + " set type = " + type + " where name = ? ";

        try {
            db.beginTransaction();
            db.execSQL(sql, new String[]{name});
            db.setTransactionSuccessful();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            db.endTransaction();
            db.close();
        }
    }

	public List<Word> ListNewWordFromList(int start, int end){
		SQLiteDatabase db = helper.getWritableDatabase();
		String selectQuery = "SELECT * FROM " + TABLE_NEW_WORD + " LIMIT " + start + "," + end;
	
		List<Word> wordList = new ArrayList<Word>();
		try {
			Cursor c = db.rawQuery(selectQuery,null);
		
			while(c.moveToNext()){
			
				Word word = new Word();
//				word.setPro_id(c.getInt(c.getColumnIndex("_id")));
//				word.setPro_description(c.getString(c.getColumnIndex("pro_description")));
//				word.setPro_ans_a(c.getString(c.getColumnIndex("pro_ans_a")));
//				word.setPro_ans_b(c.getString(c.getColumnIndex("pro_ans_b")));
//				word.setPro_ans_c(c.getString(c.getColumnIndex("pro_ans_c")));
//				word.setPro_ans_d(c.getString(c.getColumnIndex("pro_ans_d")));
//				word.setPro_point(c.getInt(c.getColumnIndex("pro_point")));
//				word.setPro_time(c.getInt(c.getColumnIndex("pro_time")));
//				word.setPro_type(c.getInt(c.getColumnIndex("pro_type")));
				
				
				wordList.add(word);
			}
		}
		finally{
			db.close();
		}
		return wordList;
	}
	
	public Word GetNewWordFromListById(int pro_id){
		
		SQLiteDatabase db = helper.getWritableDatabase();
	
		String selectQuery = "SELECT * FROM " + TABLE_NEW_WORD + " WHERE _id = ? ";
	
		Word word = null;
		try {
			Cursor c = db.rawQuery(selectQuery,new String[]{
					Integer.toString(pro_id)
					});
		
			if(c.moveToFirst()){
			
				word = new Word();
				
//				word.setPro_id(c.getInt(c.getColumnIndex("_id")));
//				word.setPro_description(c.getString(c.getColumnIndex("pro_description")));
//				word.setPro_ans_a(c.getString(c.getColumnIndex("pro_ans_a")));
//				word.setPro_ans_b(c.getString(c.getColumnIndex("pro_ans_b")));
//				word.setPro_ans_c(c.getString(c.getColumnIndex("pro_ans_c")));
//				word.setPro_ans_d(c.getString(c.getColumnIndex("pro_ans_d")));
//				word.setPro_point(c.getInt(c.getColumnIndex("pro_point")));
//				word.setPro_time(c.getInt(c.getColumnIndex("pro_time")));
//				word.setPro_type(c.getInt(c.getColumnIndex("pro_type")));
			}
		}
		finally{
			db.close();
		}
		return word;
	}

}
