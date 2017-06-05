package cmu.edu.hw2rajatdem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/**
 * Created by Rajat Mathur on 6/03/17.
 */
public class SQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_Event = "events";
    public static final String DATABASE_NAME = "Event";
    public static final int DATABASE_VERSION = 1;
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_name = "name";
    public static final String COLUMN_dateTime = "dateTime";
    public static final String COLUMN_location = "location";
    private static final String DATABASE_CREATE = "CREATE TABLE " +TABLE_Event+
            "(_id integer primary key autoincrement," +
            "name TEXT, dateTime TEXT, location TEXT);";
    /**
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public SQLiteHelper(Context context, String name,
                        SQLiteDatabase.CursorFactory factory,
                        int version) {
        super(context, DATABASE_NAME, null,
                DATABASE_VERSION);
    }

    public SQLiteHelper (Context context) {
        super(context, DATABASE_NAME, null,
                DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
        Log.w(SQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data"
        );
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Event);
        onCreate(db);
    }
}