package my.edu.tarc.fragment.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric Yam on 8/20/2016.
 */
public class UserDataSource {
    private SQLiteDatabase database;
    private DBHelper dbHelper;
    private String[] allColumn = {
            UserColumn.User.COLUMN_ZHUCI,
            UserColumn.User.COLUMN_DETAIL		};

    public	UserDataSource(Context context){
        dbHelper	=	new DBHelper(context);
    }

    public	void open()	throws SQLException {
        database	=	dbHelper.getWritableDatabase();
    }

    public	void close(){
        dbHelper.close();
    }

    public	void insertUser(BihuaData bihuadata){
        ContentValues values = new	ContentValues();
        values.put(UserColumn.User.COLUMN_ZHUCI,	bihuadata.getZhuci());
        values.put(UserColumn.User.COLUMN_DETAIL,	bihuadata.getDetail());
        database = dbHelper.getWritableDatabase();
        database.insert(UserColumn.User.TABLE_NAME,	null,	values);
        database.close();
    }

    public void delete(){
        dbHelper.delete(database);
    }

    public List<BihuaData> getAllUsers(){
        List<BihuaData> records = new ArrayList<BihuaData>();
        Cursor cursor = database.query(UserColumn.User.TABLE_NAME, allColumn ,null, null, null, null,null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            BihuaData bihuadata = new BihuaData();
            bihuadata.setZhuci(cursor.getString(0));
            bihuadata.setDetail(cursor.getString(1));
            records.add(bihuadata);
            cursor.moveToNext();
        }
        cursor.close();
        return	records;
    }
    }
