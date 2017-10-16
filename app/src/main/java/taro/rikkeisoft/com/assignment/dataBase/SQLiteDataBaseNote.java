package taro.rikkeisoft.com.assignment.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by VjrutNAT on 10/16/2017.
 */

public class SQLiteDataBaseNote extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "NoteDB";
    public static final int VERSION = 1;
    public static final String TABLE_NOTE = "Note";

    public static final String CREATE_TABLE_NOTE = "CREATE TABLE Note (ID INTERGER PRIMARY KEY AUTO INCREMENT, TITLE TEXT, CONNTENT TEXT, CREATE_TIME DATETIME, ALARM_TIME DATETIME, COLOR TEXT, PICTURE TEXT);";

    public SQLiteDataBaseNote(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_NOTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE Note IF EXITS");
        sqLiteDatabase.execSQL(CREATE_TABLE_NOTE);
    }
}
