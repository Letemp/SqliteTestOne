package com.example.sqlitetestone.dbSqlite;

import java.util.List;

import com.example.sqlitetestone.entity.userlogin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


//嫁接entity和DBSQLiteHelper
/**
 * @author ASUS
 *
 */
public class DBManager {
	
	
	private DBSQLiteHelper dbHelper;
	private SQLiteDatabase db;
	
	public DBManager(Context context) {
		dbHelper =new DBSQLiteHelper(context,"sqlTest.db",1);
		//因为getWritableDatabase内部调用了mContext.openOrCreateDatabase(mName,0,mFactory)
		//因为要确保context已经初始化，我们可以把实例化DBSQLiteHelper的步骤放在Activity的onCreate里
		db=dbHelper.getWritableDatabase();
	}
	public boolean add(List<userlogin> userloginList){
		db.beginTransaction();//开启事务
		try {
			for(userlogin ul:userloginList){
				//db.execSQL("insert into userlogin(username,password,loginNum,loginDatetime) values(?,?,?,?)",new Object[]{ul.getUsername(),ul.getPassword(),ul.getloginNum(),ul.getloginDateTime()});
				db.execSQL("insert into userlogin(username,password,loginNum,loginDatetime) values(?,?,?,?)",new Object[]{null,ul.getPassword(),ul.getLoginNum(),ul.getLoginDateTime()});
			}
			
			db.setTransactionSuccessful();//设置事务成功完成
			return true;
		} catch (android.database.SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return false;
		}finally{
			db.endTransaction();//结束事务
		}		
	}
	//close database
	public void closeDB(){
		db.close();
	}

}
