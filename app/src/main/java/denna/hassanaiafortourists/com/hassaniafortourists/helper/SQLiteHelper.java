package denna.hassanaiafortourists.com.hassaniafortourists.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import denna.hassanaiafortourists.com.hassaniafortourists.models.Word;


/**
 * Created by Denna on 9/21/2017.
 */

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String
            DATABASE_NAME = "hassaniyaTest.db",
            TABLE_NAME = "hassania",
            COLUMN_ID_WD = "_id",
            COLUMN_WD_HASSANIA = "wdHassaniya",
            COLUMN_WD_ENGLISH = "wdEnglish";
    //CRUD operations
    private SQLiteDatabase database;


    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( " + COLUMN_ID_WD + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_WD_HASSANIA + " VARCHAR, " + COLUMN_WD_ENGLISH + " VARCHAR);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void insertRecord(Word HtoE) {
        boolean exists = false;

        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);



        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                String wdHassan = cursor.getString(1);

                // verifier si le mot existe
                if (HtoE.getWdHassania().equals(wdHassan)) {
                    // si le mot existe on le passe pour la function "updateRecord" pour le mettre a jour
                    updateRecord(HtoE);
                    exists = true;
                }
            }
        }

        // SI LE MOT N'EXISTE PAS AJOUTE LE
        if (!exists) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN_ID_WD, HtoE.get_id());
            contentValues.put(COLUMN_WD_HASSANIA, HtoE.getWdHassania());
            contentValues.put(COLUMN_WD_ENGLISH, HtoE.getWdEnglish());
            database.insert(TABLE_NAME, null, contentValues);
            Log.e("msg", "ligne ajouter");
        }
        database.close();

    }

   /* Method 2:

    public void insertRecordAlternate(ContactModel contact) {
        database = this.getReadableDatabase();
        database.execSQL("INSERT INTO " + TABLE_NAME + "(" + COLUMN_FIRST_NAME + "," + COLUMN_LAST_NAME + ") VALUES('" + contact.getFirstName() + "','" + contact.getLastName() + "')");
        database.close();
    }*/

    //UPDATE RECORD
    public void updateRecord(Word HtoE) {
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID_WD, HtoE.get_id());
        contentValues.put(COLUMN_WD_HASSANIA, HtoE.getWdHassania());
        contentValues.put(COLUMN_WD_ENGLISH, HtoE.getWdEnglish());
        database.update(TABLE_NAME, contentValues, COLUMN_ID_WD + " = ?", new String[]{HtoE.get_id()});
        database.close();
    }
   /* Method 2:

    public void updateRecordAlternate(ContactModel contact) {
        database = this.getReadableDatabase();
        database.execSQL("update " + TABLE_NAME + " set " + COLUMN_FIRST_NAME + " = '" + contact.getFirstName() + "', " + COLUMN_LAST_NAME + " = '" + contact.getLastName() + "' where " + COLUMN_ID + " = '" + contact.getID() + "'");
        database.close();
    }*/

    //delate record
    public void deleteRecord(Word HtoE) {
        database = this.getReadableDatabase();
        database.delete(TABLE_NAME, COLUMN_ID_WD + " = ?", new String[]{HtoE.get_id()});
        database.close();
    }

    /*Method 2:
 
     public void deleteRecordAlternate(ContactModel contact) {
     database = this.getReadableDatabase();
     database.execSQL("delete from " + TABLE_NAME + " where " + COLUMN_ID + " = '" + contact.getID() + "'");
     database.close();
     }*/
    public List<Word> getAllRecords() {
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<Word> words = new ArrayList<>();
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                Word word = new Word();
                word.set_id(cursor.getString(0));

                word.setWdHassania(cursor.getString(1));
                word.setWdEnglish(cursor.getString(2));
                Log.e("msg", "ligne ajouter a la liste");
                words.add(word);
            }
        }
        cursor.close();
        Log.e("msg", "liste complete");
        database.close();
        Log.e("id id:", words.get(0).getWdEnglish());
        return words;
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
       ArrayList<Word> words = new ArrayList<>();
       Word contactModel;
       if (cursor.getCount() > 0) {
           for (int i = 0; i < cursor.getCount(); i++) {
               cursor.moveToNext();
               contactModel = new Word();
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

