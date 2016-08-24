package my.edu.tarc.fragment.Database;

import android.provider.BaseColumns;

/**
 * Created by Eric Yam on 8/20/2016.
 */
public class UserColumn {
    public	UserColumn(){}
    public	static	abstract class User implements BaseColumns {
        public	static	final	String	TABLE_NAME 	="BIHUA";
        public	static	final	String	COLUMN_ID	="id";
        //public	static	final	String	COLUMN_IMAGE	="image";
        public	static	final	String	COLUMN_ZHUCI	="zhuci";
        public	static	final	String	COLUMN_DETAIL	="detail";
        public	static	final	String	COLUMN_PINBI	="pinbi";
    }
}
