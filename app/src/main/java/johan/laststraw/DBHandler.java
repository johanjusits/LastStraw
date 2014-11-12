package johan.laststraw;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

/**
 * Created by Johan on 2014-10-02.
 */
public class DBHandler {

    public static final String KEY_ROWID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_TYPE = "type";
    public static final String KEY_DESC = "desc";
    public static final String KEY_GENDER = "gender";
    public static final String KEY_LEVEL = "level";
    public static final String KEY_EXP = "exp";
    public static final String KEY_UNLOCKEDSLOTS = "slots";
    public static final String KEY_ISUNLOCKED = "unlocked";
    public static final String KEY_REQUIRESLVL = "reqlvl";
    public static final String KEY_LVLSBEATEN = "lvlsbeaten";
    public static final String KEY_COST = "cost";

    private static final String DATABASE_NAME = "appDB";
    private static final String DATABASE_TABLE = "selectedCards";
    private static final String DATABASE_TABLE_2 = "allCards";
    private static final String DATABASE_TABLE_3 = "playerInfo";
    private static final String DATABASE_TABLE_4 = "allOwnedCards";
    private static final int DATABASE_VERSION = 1;

    private DbHelper ourHelper;
    private final Context context;
    private SQLiteDatabase appDB;

    private static class DbHelper extends SQLiteOpenHelper {

        /* CARD TYPES:
        1 = FIELD
        2 = AILMENT
        3 = BOOSTING
         */

        public DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
                            KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            KEY_NAME + " TEXT NOT NULL, " +
                            KEY_IMAGE + " TEXT NOT NULL, " +
                            KEY_TYPE + " INTEGER NOT NULL, " +
                            KEY_DESC + " TEXT NOT NULL);"
            );

            db.execSQL("CREATE TABLE " + DATABASE_TABLE_2 + " (" +
                            KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            KEY_NAME + " TEXT NOT NULL, " +
                            KEY_IMAGE + " TEXT NOT NULL, " +
                            KEY_TYPE + " INTEGER NOT NULL, " +
                            KEY_DESC + " TEXT NOT NULL, " +
                            KEY_REQUIRESLVL + " INT NOT NULL, " +
                            KEY_COST + " INT NOT NULL, " +
                            KEY_ISUNLOCKED + " INT NOT NULL);"
            );

            db.execSQL("CREATE TABLE " + DATABASE_TABLE_3 + " (" +
                            KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            KEY_NAME + " TEXT NOT NULL, " +
                            KEY_GENDER + " TEXT NOT NULL, " +
                            KEY_LEVEL + " INTEGER NOT NULL, " +
                            KEY_EXP + " INTEGER NOT NULL, " +
                            KEY_LVLSBEATEN + " INTEGER NOT NULL, " +
                            KEY_UNLOCKEDSLOTS + " INTEGER NOT NULL);"
            );

            db.execSQL("CREATE TABLE " + DATABASE_TABLE_4 + " (" +
                            KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            KEY_NAME + " TEXT NOT NULL, " +
                            KEY_IMAGE + " TEXT NOT NULL, " +
                            KEY_TYPE + " INTEGER NOT NULL, " +
                            KEY_COST + " INTEGER NOT NULL, " +
                            KEY_DESC + " TEXT NOT NULL);"
            );

            /* ADDS CARDS TO ALL CARDS */
            ContentValues ac1 = new ContentValues();
            ac1.put(KEY_NAME, "Reinforce");
            ac1.put(KEY_IMAGE, "card_obj_plus_1");
            ac1.put(KEY_TYPE, 1);
            ac1.put(KEY_DESC, "Brings back one object.");
            ac1.put(KEY_REQUIRESLVL, 1);
            ac1.put(KEY_COST, 0);
            ac1.put(KEY_ISUNLOCKED, 1);
            db.insert(DATABASE_TABLE_2, null, ac1);

            ContentValues ac2 = new ContentValues();
            ac2.put(KEY_NAME, "Reinforce II");
            ac2.put(KEY_IMAGE, "card_obj_plus_2");
            ac2.put(KEY_TYPE, 1);
            ac2.put(KEY_DESC, "Brings back two objects.");
            ac2.put(KEY_REQUIRESLVL, 2);
            ac2.put(KEY_COST, 0);
            ac2.put(KEY_ISUNLOCKED, 0);
            db.insert(DATABASE_TABLE_2, null, ac2);

            ContentValues ac3 = new ContentValues();
            ac3.put(KEY_NAME, "Reinforce III");
            ac3.put(KEY_IMAGE, "card_obj_plus_3");
            ac3.put(KEY_TYPE, 1);
            ac3.put(KEY_DESC, "Brings back three objects.");
            ac3.put(KEY_REQUIRESLVL, 3);
            ac3.put(KEY_COST, 1);
            ac3.put(KEY_ISUNLOCKED, 0);
            db.insert(DATABASE_TABLE_2, null, ac3);

            ContentValues ac4 = new ContentValues();
            ac4.put(KEY_NAME, "Slow Down");
            ac4.put(KEY_IMAGE, "card_slowdown");
            ac4.put(KEY_TYPE, 2);
            ac4.put(KEY_DESC, "Reduces opponent's moves by 1 next turn.");
            ac4.put(KEY_REQUIRESLVL, 5);
            ac4.put(KEY_COST, 1);
            ac4.put(KEY_ISUNLOCKED, 0);
            db.insert(DATABASE_TABLE_2, null, ac4);

            ContentValues ac5 = new ContentValues();
            ac5.put(KEY_NAME, "Speed Up");
            ac5.put(KEY_IMAGE, "card_speed_up");
            ac5.put(KEY_TYPE, 3);
            ac5.put(KEY_DESC, "You gain 1 more move on next turn.");
            ac5.put(KEY_COST, 1);
            ac5.put(KEY_REQUIRESLVL, 6);
            ac5.put(KEY_ISUNLOCKED, 0);
            db.insert(DATABASE_TABLE_2, null, ac5);

            /* ADDS CARDS TO OWNED CARDS */
            ContentValues oc1 = new ContentValues();
            oc1.put(KEY_NAME, "Reinforce");
            oc1.put(KEY_IMAGE, "card_obj_plus_1");
            oc1.put(KEY_TYPE, 1);
            oc1.put(KEY_COST, 0);
            oc1.put(KEY_DESC, "Brings back one object.");
            db.insert(DATABASE_TABLE_4, null, oc1);

            /* INITIAL PLAYER VALUES */
            ContentValues playerInfo = new ContentValues();
            playerInfo.put(KEY_NAME, "New Player");
            playerInfo.put(KEY_GENDER, "Male");
            playerInfo.put(KEY_LEVEL, 1);
            playerInfo.put(KEY_LVLSBEATEN, 0);
            playerInfo.put(KEY_EXP, 0);
            playerInfo.put(KEY_UNLOCKEDSLOTS, 1);
            db.insert(DATABASE_TABLE_3, null, playerInfo);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }

    public DBHandler(Context c) {
        context = c;
    }

    /* Method for opening the database, gaining access to it's content */
    public DBHandler open() throws SQLException {
        ourHelper = new DbHelper(context);
        appDB = ourHelper.getWritableDatabase();
        return this;
    }

    /* Method for closing the database */
    public void close() {
        ourHelper.close();
    }

    /* Method for adding a card to current hand */
    public long addCardToHand(String name, String image, int type, String desc ) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, name);
        cv.put(KEY_IMAGE, image);
        cv.put(KEY_TYPE, type);
        cv.put(KEY_DESC, desc);
        return appDB.insert(DATABASE_TABLE, null, cv);
    }

    /* Method for updating player exp */
    public long updatePlayerLevel(int level) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_LEVEL, level);
        return appDB.update(DATABASE_TABLE_3, cv, "_id "+"="+1, null);
    }

    /* Method for updating player exp */
    public long updatePlayerExp(int exp) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_EXP, exp);
        return appDB.update(DATABASE_TABLE_3, cv, "_id "+"="+1, null);
    }

    /* Method for updating player gender */
    public long updatePlayerGender(String gender) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_GENDER, gender);
        return appDB.update(DATABASE_TABLE_3, cv, "_id "+"="+1, null);
    }

    /* Method for updating player name */
    public long updatePlayerName(String name) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, name);
        return appDB.update(DATABASE_TABLE_3, cv, "_id "+"="+1, null);
    }

    /* Method for deleting an item */
    public void deleteRowSelectedCards(String item_id) {
        appDB.delete(DATABASE_TABLE, KEY_ROWID + "=?", new String[] { item_id });
    }

    /* Method for deleting all rows in selectedCards */
    public void deleteAllSelectedCards(){
        appDB.delete(DATABASE_TABLE, null, null);
    }

    /* ALL OWNED FIELD CARDS */
    public Cursor getAllOwnedFieldCards() {
        String selectQuery = "SELECT  * FROM allOwnedCards WHERE " + "type=" + 1;
        SQLiteDatabase db = ourHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    /* ALL FIELD CARDS */
    public Cursor getAllFieldCards() {
        String selectQuery = "SELECT  * FROM allCards WHERE " + "type=" + 1;
        SQLiteDatabase db = ourHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    /* ALL OWNED AILMENT CARDS */
    public Cursor getAllOwnedAilmentCards() {
        String selectQuery = "SELECT  * FROM allOwnedCards WHERE " + "type=" + 2;
        SQLiteDatabase db = ourHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    /* ALL AILMENT CARDS */
    public Cursor getAllAilmentCards() {
        String selectQuery = "SELECT  * FROM allCards WHERE " + "type=" + 2;
        SQLiteDatabase db = ourHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    /* ALL OWNED BOOSTING CARDS */
    public Cursor getAllOwnedBoostingCards() {
        String selectQuery = "SELECT  * FROM allOwnedCards WHERE " + "type=" + 3;
        SQLiteDatabase db = ourHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    /* ALL BOOSTING CARDS */
    public Cursor getAllBoostingCards() {
        String selectQuery = "SELECT  * FROM allCards WHERE " + "type=" + 3;
        SQLiteDatabase db = ourHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    /* Method for fetching all data in selectedCards */
    public Cursor getAllSelectedCards() {
        String selectQuery = "SELECT  * FROM selectedCards";
        SQLiteDatabase db = ourHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    /* Method for fetching player info */
    public Cursor getPlayerInfo() {
        String selectQuery = "SELECT  * FROM playerInfo";
        SQLiteDatabase db = ourHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    /* UNLOCKING CARDS METHODS */
    public long unlockCard(int CardId, int number) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_ISUNLOCKED, number);
        return appDB.update(DATABASE_TABLE_2, cv, "_id "+"="+CardId, null);
    }

    /* ADD CARD TO OWNED CARDS METHOD */
    public long addOwnedCard(String cardName, String cardImg, int cardType, int cardCost, String cardDesc) {
        ContentValues oc1 = new ContentValues();
        oc1.put(KEY_NAME, cardName);
        oc1.put(KEY_IMAGE, cardImg);
        oc1.put(KEY_TYPE, cardType);
        oc1.put(KEY_COST, cardCost);
        oc1.put(KEY_DESC, cardDesc);
        return appDB.insert(DATABASE_TABLE_4, null, oc1);
    }
}
