package mx.com.alex.crazycards.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Rick on 17/06/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GameVerbs.db";
    private static final Integer VER_1 = 1;
    private static final Integer VER_2 = 2;
    private static final Integer DATABASE_VERSION = VER_2;
    private Context context;

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE Verb (" +
                "    idVerb integer NOT NULL  PRIMARY KEY," +
                "    verbEnglish varchar (100) NOT NULL ," +
                "    verbSpanish varchar (100) NOT NULL , " +
                "    urlImgTrue varchar(250) NOT NULL" +
                ");");


        db.execSQL("CREATE TABLE ImagesVerbs (" +
                "    idVerb integer NOT NULL  PRIMARY KEY," +
                "    ima1 varchar (100) NOT NULL ," +
                "    verbSpanish varchar (100) NOT NULL , " +
                "    urlImgTrue varchar(250) NOT NULL" +
                ");");



        //db.execSQL("INSERT INTO Verb (idVerb,verbEnglish, verbSpanish,urlImgTrue) VALUES (1,'Broke Down','Descomponer', 'http://1.bp.blogspot.com/-Q3rbiEUs_sc/UpIiW_GqneI/AAAAAAAAFuM/oulyN5lEbjU/s1600/car+broken+down.jpg');");

        boolean createSuccessful = false;

       ContentValues values = new ContentValues();
        values.put("verbEnglish","Broke Down");
        values.put("verbSpanish","Descomponer");
        values.put("urlImgTrue","http://1.bp.blogspot.com/-Q3rbiEUs_sc/UpIiW_GqneI/AAAAAAAAFuM/oulyN5lEbjU/s1600/car+broken+down.jpg");
        long code = db.insert("Verb",null,values );
        Log.v("Insert", String.valueOf(code));

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != DATABASE_VERSION){
            db.execSQL("DROP TABLE IF EXISTS Verb");
        }
    }


    public ArrayList<Cursor> getData(String Query){
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[] { "mesage" };
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2= new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);


        try{
            String maxQuery = Query ;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);


            //add value to cursor2
            Cursor2.addRow(new Object[] { "Success" });

            alc.set(1,Cursor2);
            if (null != c && c.getCount() > 0) {


                alc.set(0,c);
                c.moveToFirst();

                return alc ;
            }
            return alc;
        } catch(SQLException sqlEx){
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+sqlEx.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        } catch(Exception ex){

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+ex.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        }


    }
}