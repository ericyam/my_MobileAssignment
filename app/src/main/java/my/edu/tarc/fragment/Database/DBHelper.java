package my.edu.tarc.fragment.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Eric Yam on 8/20/2016.
 */
public class DBHelper extends SQLiteOpenHelper{

    private static final String DATABASE = "my_db";
    private static final	String SQL_CREATE_ENTRIES =
            "CREATE TABLE	" + UserColumn.User.TABLE_NAME	+ "("	+
                    UserColumn.User.COLUMN_ID	+ " TEXT,"	+
                    //UserColumn.User.COLUMN_IMAGE	+ " IMAGE,"+
                    UserColumn.User.COLUMN_ZHUCI	+ " TEXT,"	+
                    UserColumn.User.COLUMN_DETAIL	+ " TEXT," +
                    UserColumn.User.COLUMN_PINBI  + " TEXT)"	;

    public DBHelper(Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void delete(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("drop table IF EXISTS " + UserColumn.User.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

}
