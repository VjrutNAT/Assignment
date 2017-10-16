package taro.rikkeisoft.com.assignment.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.util.ArrayList;

import taro.rikkeisoft.com.assignment.model.Note;
import taro.rikkeisoft.com.assignment.utils.Utils;

/**
 * Created by VjrutNAT on 10/17/2017.
 */

public class OptionNote  {

    private static OptionNote instrance;
    public static long lastNoteId = 0;
    private SQLiteDatabase db;

    public static OptionNote getInstrance(Context context){
        if (instrance == null){
            instrance = new OptionNote(context);
        }
        return instrance;
    }

    public OptionNote (Context context){
        this.db = new SQLiteDataBaseNote(context).getWritableDatabase();
    }

    public ArrayList<Note> getAll(){
        ArrayList<Note> notes = new ArrayList<>();
        Cursor cursor = this.db.query(true, SQLiteDataBaseNote.TABLE_NOTE, new String[0], null, null, null, null, "CREATE_TIME DESC", null);
        if (cursor != null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                Note n = getNoteFromCursor(cursor);
                if (n != null){
                    notes.add(n);
                    if (n.getId() > lastNoteId){
                        lastNoteId  = n.getId();
                    }
                }cursor.moveToNext();
            }cursor.moveToNext();
        }return notes;
    }

    public void addNote(Note note){
        ContentValues contentValues =  new ContentValues();
        contentValues.put(Note.ID, Long.valueOf(note.getId()));
        contentValues.put(Note.TITLE, note.getTitle());
        contentValues.put(Note.CONTENT, note.getContent());
        contentValues.put(Note.CREATE_ALARM, Utils.fullDateFormat.format(note.getCreateAlarm()));
        if (note.getAlarm() != null){
            contentValues.put(Note.ALARM, Utils.fullDateFormat.format(note.getAlarm()));
        }else{
            contentValues.putNull(Note.ALARM);
        }
        contentValues.put(Note.COLOR, note.getColor().replace("#","0x"));

    }

    public Note getNoteFromCursor(Cursor cursor){
        String id =  cursor.getString(cursor.getColumnIndex(Note.ID));
        String title = cursor.getString(cursor.getColumnIndex(Note.TITLE));
        String content = cursor.getString(cursor.getColumnIndex(Note.CONTENT));
        String create = cursor.getString(cursor.getColumnIndex(Note.CREATE_ALARM));
        String alarm = cursor.getString(cursor.getColumnIndex(Note.ALARM));

        try {
            return new Note(title, content, alarm != null ? Utils.fullDateFormat.parse(alarm) : null, Utils.fullDateFormat.parse(create), cursor.getString(cursor.getColumnIndex(Note.COLOR)).replace("0x","#"),
                   Long.parseLong(id), cursor.getString(cursor.getColumnIndex(Note.PICTURE)));
        } catch (ParseException e) {
            e.printStackTrace();
        }return null;
    }
}
