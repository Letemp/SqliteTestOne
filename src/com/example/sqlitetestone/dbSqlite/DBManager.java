package com.example.sqlitetestone.dbSqlite;

import java.util.List;

import com.example.sqlitetestone.entity.userlogin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


//�޽�entity��DBSQLiteHelper
/**
 * @author ASUS
 *
 */
public class DBManager {
	
	
	private DBSQLiteHelper dbHelper;
	private SQLiteDatabase db;
	
	public DBManager(Context context) {
		dbHelper =new DBSQLiteHelper(context,"sqlTest.db",1);
		//��ΪgetWritableDatabase�ڲ�������mContext.openOrCreateDatabase(mName,0,mFactory)
		//��ΪҪȷ��context�Ѿ���ʼ�������ǿ��԰�ʵ����DBSQLiteHelper�Ĳ������Activity��onCreate��
		db=dbHelper.getWritableDatabase();
	}
	public boolean add(List<userlogin> userloginList){
		db.beginTransaction();//��������
		try {
			for(userlogin ul:userloginList){
				//db.execSQL("insert into userlogin(username,password,loginNum,loginDatetime) values(?,?,?,?)",new Object[]{ul.getUsername(),ul.getPassword(),ul.getloginNum(),ul.getloginDateTime()});
				db.execSQL("insert into userlogin(username,password,loginNum,loginDatetime) values(?,?,?,?)",new Object[]{null,ul.getPassword(),ul.getLoginNum(),ul.getLoginDateTime()});
			}
			
			db.setTransactionSuccessful();//��������ɹ����
			return true;
		} catch (android.database.SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return false;
		}finally{
			db.endTransaction();//��������
		}		
	}
	//close database
	public void closeDB(){
		db.close();
	}

}
