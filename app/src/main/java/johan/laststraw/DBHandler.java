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
    public static final String KEY_WORLDID = "worldid";
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
    public static final String KEY_LVLCLEARED = "lvlcleared";
    public static final String KEY_LVLHIGHSCORE = "lvlhighscore";
    public static final String KEY_WORLDCLEARED = "worldcleared";
    public static final String KEY_WORLDHIGHSCORE = "worldhighscore";

    private static final String DATABASE_NAME = "appDB";
    private static final String SelectedCards = "selectedCards";
    private static final String AllCards = "allCards";
    private static final String PlayerInfo = "playerInfo";
    private static final String OwnedCards = "allOwnedCards";
    private static final String LevelsInfo = "levelsInfo";
    private static final String WorldsInfo = "worldsInfo";
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
            db.execSQL("CREATE TABLE " + SelectedCards + " (" +
                            KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            KEY_NAME + " TEXT NOT NULL, " +
                            KEY_IMAGE + " TEXT NOT NULL, " +
                            KEY_TYPE + " INTEGER NOT NULL, " +
                            KEY_COST + " INTEGER NOT NULL, " +
                            KEY_DESC + " TEXT NOT NULL);"
            );

            db.execSQL("CREATE TABLE " + AllCards + " (" +
                            KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            KEY_NAME + " TEXT NOT NULL, " +
                            KEY_IMAGE + " TEXT NOT NULL, " +
                            KEY_TYPE + " INTEGER NOT NULL, " +
                            KEY_DESC + " TEXT NOT NULL, " +
                            KEY_REQUIRESLVL + " INT NOT NULL, " +
                            KEY_COST + " INT NOT NULL, " +
                            KEY_ISUNLOCKED + " INT NOT NULL);"
            );

            db.execSQL("CREATE TABLE " + PlayerInfo + " (" +
                            KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            KEY_NAME + " TEXT NOT NULL, " +
                            KEY_GENDER + " TEXT NOT NULL, " +
                            KEY_LEVEL + " INTEGER NOT NULL, " +
                            KEY_EXP + " INTEGER NOT NULL, " +
                            KEY_LVLSBEATEN + " INTEGER NOT NULL, " +
                            KEY_UNLOCKEDSLOTS + " INTEGER NOT NULL);"
            );

            db.execSQL("CREATE TABLE " + OwnedCards + " (" +
                            KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            KEY_NAME + " TEXT NOT NULL, " +
                            KEY_IMAGE + " TEXT NOT NULL, " +
                            KEY_TYPE + " INTEGER NOT NULL, " +
                            KEY_COST + " INTEGER NOT NULL, " +
                            KEY_DESC + " TEXT NOT NULL);"
            );

            db.execSQL("CREATE TABLE " + LevelsInfo + " (" +
                            KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            KEY_WORLDID + " INTEGER NOT NULL, " +
                            KEY_NAME + " TEXT NOT NULL, " +
                            KEY_LVLCLEARED + " INTEGER NOT NULL, " +
                            KEY_LVLHIGHSCORE + " INTEGER NOT NULL);"
            );

            db.execSQL("CREATE TABLE " + WorldsInfo + " (" +
                            KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            KEY_NAME + " TEXT NOT NULL, " +
                            KEY_WORLDCLEARED + " INTEGER NOT NULL, " +
                            KEY_WORLDHIGHSCORE + " INTEGER NOT NULL);"
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
            db.insert(AllCards, null, ac1);

            ContentValues ac2 = new ContentValues();
            ac2.put(KEY_NAME, "Reinforce II");
            ac2.put(KEY_IMAGE, "card_obj_plus_2");
            ac2.put(KEY_TYPE, 1);
            ac2.put(KEY_DESC, "Brings back two objects.");
            ac2.put(KEY_REQUIRESLVL, 2);
            ac2.put(KEY_COST, 0);
            ac2.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac2);

            ContentValues ac3 = new ContentValues();
            ac3.put(KEY_NAME, "Reinforce III");
            ac3.put(KEY_IMAGE, "card_obj_plus_3");
            ac3.put(KEY_TYPE, 1);
            ac3.put(KEY_DESC, "Brings back three objects.");
            ac3.put(KEY_REQUIRESLVL, 3);
            ac3.put(KEY_COST, 1);
            ac3.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac3);

            ContentValues ac4 = new ContentValues();
            ac4.put(KEY_NAME, "Slow Down");
            ac4.put(KEY_IMAGE, "card_slowdown");
            ac4.put(KEY_TYPE, 2);
            ac4.put(KEY_DESC, "Reduces opponent's moves by 1 next turn.");
            ac4.put(KEY_REQUIRESLVL, 5);
            ac4.put(KEY_COST, 1);
            ac4.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac4);

            ContentValues ac5 = new ContentValues();
            ac5.put(KEY_NAME, "Speed Up");
            ac5.put(KEY_IMAGE, "card_speed_up");
            ac5.put(KEY_TYPE, 3);
            ac5.put(KEY_DESC, "You gain 1 more move on next turn.");
            ac5.put(KEY_COST, 1);
            ac5.put(KEY_REQUIRESLVL, 6);
            ac5.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac5);

            ContentValues ac6 = new ContentValues();
            ac6.put(KEY_NAME, "Steal");
            ac6.put(KEY_IMAGE, "card_steal_3");
            ac6.put(KEY_TYPE, 2);
            ac6.put(KEY_DESC, "Steals 3 points from the opponent.");
            ac6.put(KEY_COST, 1);
            ac6.put(KEY_REQUIRESLVL, 8);
            ac6.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac6);

            ContentValues ac7 = new ContentValues();
            ac7.put(KEY_NAME, "Concentrate");
            ac7.put(KEY_IMAGE, "card_concentrate");
            ac7.put(KEY_TYPE, 3);
            ac7.put(KEY_DESC, "Doubles points gained next turn.");
            ac7.put(KEY_COST, 1);
            ac7.put(KEY_REQUIRESLVL, 10);
            ac7.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac7);

            ContentValues ac8 = new ContentValues();
            ac8.put(KEY_NAME, "Steal II");
            ac8.put(KEY_IMAGE, "card_steal_5");
            ac8.put(KEY_TYPE, 2);
            ac8.put(KEY_DESC, "Steals 5 points from the opponent.");
            ac8.put(KEY_COST, 2);
            ac8.put(KEY_REQUIRESLVL, 12);
            ac8.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac8);

            ContentValues ac9 = new ContentValues();
            ac9.put(KEY_NAME, "Steal III");
            ac9.put(KEY_IMAGE, "card_steal_10");
            ac9.put(KEY_TYPE, 2);
            ac9.put(KEY_DESC, "Steals 10 points from the opponent.");
            ac9.put(KEY_COST, 3);
            ac9.put(KEY_REQUIRESLVL, 15);
            ac9.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac9);

            /* ADDS CARDS TO OWNED CARDS */
            ContentValues oc1 = new ContentValues();
            oc1.put(KEY_NAME, "Reinforce");
            oc1.put(KEY_IMAGE, "card_obj_plus_1");
            oc1.put(KEY_TYPE, 1);
            oc1.put(KEY_COST, 0);
            oc1.put(KEY_DESC, "Brings back one object.");
            db.insert(OwnedCards, null, oc1);

            /* INITIAL PLAYER VALUES */
            ContentValues playerInfo = new ContentValues();
            playerInfo.put(KEY_NAME, "New Player");
            playerInfo.put(KEY_GENDER, "Male");
            playerInfo.put(KEY_LEVEL, 1);
            playerInfo.put(KEY_LVLSBEATEN, 0);
            playerInfo.put(KEY_EXP, 0);
            playerInfo.put(KEY_UNLOCKEDSLOTS, 1);
            db.insert(PlayerInfo, null, playerInfo);

            /* LEVELS INFO */
            ContentValues li = new ContentValues();
            li.put(KEY_NAME, "W001LVL001");
            li.put(KEY_WORLDID, 1);
            li.put(KEY_LVLCLEARED, 0);
            li.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li);

            /* WORLDS INFO */
            ContentValues worldInfo = new ContentValues();
            worldInfo.put(KEY_NAME, "Fields");
            worldInfo.put(KEY_WORLDCLEARED, 0);
            worldInfo.put(KEY_WORLDHIGHSCORE, 0);
            db.insert(WorldsInfo, null, worldInfo);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + SelectedCards);
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
    public long addCardToHand(String name, String image, int type, int cost, String desc ) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, name);
        cv.put(KEY_IMAGE, image);
        cv.put(KEY_TYPE, type);
        cv.put(KEY_COST, cost);
        cv.put(KEY_DESC, desc);
        return appDB.insert(SelectedCards, null, cv);
    }

    /* Method for updating player exp */
    public long updatePlayerLevel(int level) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_LEVEL, level);
        return appDB.update(PlayerInfo, cv, "_id "+"="+1, null);
    }

    /* Method for updating player exp */
    public long updatePlayerExp(int exp) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_EXP, exp);
        return appDB.update(PlayerInfo, cv, "_id "+"="+1, null);
    }

    /* Method for updating player gender */
    public long updatePlayerGender(String gender) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_GENDER, gender);
        return appDB.update(PlayerInfo, cv, "_id "+"="+1, null);
    }

    /* Method for updating player name */
    public long updatePlayerName(String name) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, name);
        return appDB.update(PlayerInfo, cv, "_id "+"="+1, null);
    }

    /* Method for deleting an item */
    public void deleteRowSelectedCards(String item_id) {
        appDB.delete(SelectedCards, KEY_ROWID + "=?", new String[] { item_id });
    }

    /* Method for deleting all rows in selectedCards */
    public void deleteAllSelectedCards(){
        appDB.delete(SelectedCards, null, null);
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
        return appDB.update(AllCards, cv, "_id "+"="+CardId, null);
    }

    /* ADD CARD TO OWNED CARDS METHOD */
    public long addOwnedCard(String cardName, String cardImg, int cardType, int cardCost, String cardDesc) {
        ContentValues oc1 = new ContentValues();
        oc1.put(KEY_NAME, cardName);
        oc1.put(KEY_IMAGE, cardImg);
        oc1.put(KEY_TYPE, cardType);
        oc1.put(KEY_COST, cardCost);
        oc1.put(KEY_DESC, cardDesc);
        return appDB.insert(OwnedCards, null, oc1);
    }

    /* UPDATE LVL INFO */

    public Cursor getLvlInfo(int lvlid){
        String selectQuery = "SELECT  * FROM levelsInfo WHERE " + "_id=" + lvlid;
        SQLiteDatabase db = ourHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    public Cursor getFieldsLvlsInfo(int worldId){
        String selectQuery = "SELECT  * FROM levelsInfo WHERE " + "worldid=" + worldId;
        SQLiteDatabase db = ourHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    public long updateLvlInfo(int lvlId, int cleared, int highScore){
        ContentValues up = new ContentValues();
        up.put(KEY_LVLCLEARED, cleared);
        up.put(KEY_LVLHIGHSCORE, highScore);
        return appDB.update(LevelsInfo, up, "_id "+"="+lvlId, null);

    }

    /* ENABLE ALL CARDS (TESTING PURPOSES ONLY) */
    public void enableAllCards() {
        addOwnedCard("Reinforce II", "card_obj_plus_2", 1, 0, "Brings back two objects.");
        addOwnedCard("Reinforce III", "card_obj_plus_3", 1, 1, "Brings back three objects.");
        addOwnedCard("Slow Down", "card_slowdown", 2, 1, "Reduces opponent's moves by 1 next turn.");
        addOwnedCard("Speed Up", "card_speed_up", 3, 1, "You gain 1 more move on next turn.");
        addOwnedCard("Steal", "card_steal_3", 2, 1, "Steals 3 points from the opponent.");
        addOwnedCard("Concentrate", "card_concentrate", 3, 1, "Doubles points gained next turn.");
        addOwnedCard("Steal II", "card_steal_5", 2, 2, "Steals 5 points from the opponent.");
        addOwnedCard("Steal III", "card_steal_10", 2, 3, "Steals 10 points from the opponent.");
        unlockCard(2,1);
        unlockCard(3,1);
        unlockCard(4,1);
        unlockCard(5,1);
        unlockCard(6,1);
        unlockCard(7,1);
        unlockCard(8,1);
        unlockCard(9,1);
    }
}
