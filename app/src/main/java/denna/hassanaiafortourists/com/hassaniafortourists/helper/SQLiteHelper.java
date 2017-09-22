package denna.hassanaiafortourists.com.hassaniafortourists.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import denna.hassanaiafortourists.com.hassaniafortourists.models.HassaniaToEnglish;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;


/**
 * Created by Denna on 9/21/2017.
 */

public class SQLiteHelper extends SQLiteOpenHelper{


    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "HassaniForTourists.db";
    public static final String TABLE_NAME = "hassania";
    public static final String COLUMN_ID_WD = "id_WD";
    public static final String COLUMN_WD_HASSANIA = "wd_hassania";
    public static final String COLUMN_WD_ENGLISH = "wd_english";
public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
    ;
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( " + COLUMN_ID_WD + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_WD_HASSANIA + " VARCHAR, " + COLUMN_WD_ENGLISH + " VARCHAR);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    //CRUD operations
    private SQLiteDatabase database;

    public void insertRecord(HassaniaToEnglish HtoE) {
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_WD_HASSANIA, HtoE.getWdHassania());
        contentValues.put(COLUMN_WD_ENGLISH, HtoE.getWdEnglish());
        database.insert(TABLE_NAME, null, contentValues);
        Log.e("msg", "ligne ajouter");
        database.close();

    }
   /* Method 2:

    public void insertRecordAlternate(ContactModel contact) {
        database = this.getReadableDatabase();
        database.execSQL("INSERT INTO " + TABLE_NAME + "(" + COLUMN_FIRST_NAME + "," + COLUMN_LAST_NAME + ") VALUES('" + contact.getFirstName() + "','" + contact.getLastName() + "')");
        database.close();
    }*/

   //UPDATE RECORD
   public void updateRecord(HassaniaToEnglish HtoE) {
       database = this.getReadableDatabase();
       ContentValues contentValues = new ContentValues();
       contentValues.put(COLUMN_WD_HASSANIA, HtoE.getWdHassania());
       contentValues.put(COLUMN_WD_ENGLISH, HtoE.getWdEnglish());
       database.update(TABLE_NAME, contentValues, COLUMN_WD_HASSANIA + " = ?", new String[]{HtoE.getIdWord()});
       database.close();
   }
   /* Method 2:

    public void updateRecordAlternate(ContactModel contact) {
        database = this.getReadableDatabase();
        database.execSQL("update " + TABLE_NAME + " set " + COLUMN_FIRST_NAME + " = '" + contact.getFirstName() + "', " + COLUMN_LAST_NAME + " = '" + contact.getLastName() + "' where " + COLUMN_ID + " = '" + contact.getID() + "'");
        database.close();
    }*/

   //delate record
   public void deleteRecord(HassaniaToEnglish HtoE) {
       database = this.getReadableDatabase();
       database.delete(TABLE_NAME, COLUMN_ID_WD + " = ?", new String[]{HtoE.getIdWord()});
       database.close();
   }
   /*Method 2:

    public void deleteRecordAlternate(ContactModel contact) {
    database = this.getReadableDatabase();
    database.execSQL("delete from " + TABLE_NAME + " where " + COLUMN_ID + " = '" + contact.getID() + "'");
    database.close();
    }*/
   public List<HassaniaToEnglish> getAllRecords() {
       database = this.getReadableDatabase();
       Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);
       ArrayList<HassaniaToEnglish> contacts = new ArrayList<HassaniaToEnglish>();
       HassaniaToEnglish hassaniaToEnglish;
       if (cursor.getCount() > 0) {
           for (int i = 0; i < cursor.getCount(); i++) {
               cursor.moveToNext();
               hassaniaToEnglish = new HassaniaToEnglish();
               hassaniaToEnglish.setIdWord(cursor.getString(0));
               hassaniaToEnglish.setWdHassania(cursor.getString(1));
               hassaniaToEnglish.setWdEnglish(cursor.getString(2));
               Log.e("msg", "ligne ajouter a la liste");
               contacts.add(hassaniaToEnglish);
           }
       }
       cursor.close();
       Log.e("msg", "liste complete");
       database.close();
       return contacts;
   }
   /* Method 2:

    Now we are fetching records using rawQuery() method that is quite similar to query() method.

    public ArrayList<ContactModel> getAllRecordsAlternate() {
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<ContactModel> contacts = new ArrayList<ContactModel>();
        ContactModel contactModel;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                contactModel = new ContactModel();
                contactModel.setID(cursor.getString(0));
                contactModel.setFirstName(cursor.getString(1));
                contactModel.setLastName(cursor.getString(2));
                contacts.add(contactModel);
            }
        }
        cursor.close();
        database.close();
        return contacts;
        ....................................
          database = this.getReadableDatabase();
       Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
       ArrayList<HassaniaToEnglish> words = new ArrayList<>();
       HassaniaToEnglish contactModel;
       if (cursor.getCount() > 0) {
           for (int i = 0; i < cursor.getCount(); i++) {
               cursor.moveToNext();
               contactModel = new HassaniaToEnglish();
               contactModel.setIdWord(cursor.getString(0));
               contactModel.setWdHassania(cursor.getString(1));
               contactModel.setWdEnglish(cursor.getString(2));
               words.add(contactModel);
           }
       }
       cursor.close();
       database.close();
       return words;
    }*/

}

