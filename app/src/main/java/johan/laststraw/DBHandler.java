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
            ac5.put(KEY_REQUIRESLVL, 4);
            ac5.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac5);

            ContentValues ac6 = new ContentValues();
            ac6.put(KEY_NAME, "Steal");
            ac6.put(KEY_IMAGE, "card_steal_3");
            ac6.put(KEY_TYPE, 1);
            ac6.put(KEY_DESC, "Steals 1-3 points from the opponent.");
            ac6.put(KEY_COST, 1);
            ac6.put(KEY_REQUIRESLVL, 0);
            ac6.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac6);

            ContentValues ac7 = new ContentValues();
            ac7.put(KEY_NAME, "Concentrate");
            ac7.put(KEY_IMAGE, "card_concentrate");
            ac7.put(KEY_TYPE, 3);
            ac7.put(KEY_DESC, "Doubles all points gained next turn.");
            ac7.put(KEY_COST, 1);
            ac7.put(KEY_REQUIRESLVL, 6);
            ac7.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac7);

            ContentValues ac8 = new ContentValues();
            ac8.put(KEY_NAME, "Steal II");
            ac8.put(KEY_IMAGE, "card_steal_5");
            ac8.put(KEY_TYPE, 1);
            ac8.put(KEY_DESC, "Steals 3-5 points from the opponent.");
            ac8.put(KEY_COST, 2);
            ac8.put(KEY_REQUIRESLVL, 9);
            ac8.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac8);

            ContentValues ac9 = new ContentValues();
            ac9.put(KEY_NAME, "Steal III");
            ac9.put(KEY_IMAGE, "card_steal_7");
            ac9.put(KEY_TYPE, 1);
            ac9.put(KEY_DESC, "Steals 5-7 points from the opponent.");
            ac9.put(KEY_COST, 3);
            ac9.put(KEY_REQUIRESLVL, 13);
            ac9.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac9);

            ContentValues ac010 = new ContentValues();
            ac010.put(KEY_NAME, "Infest");
            ac010.put(KEY_IMAGE, "card_infest");
            ac010.put(KEY_TYPE, 1);
            ac010.put(KEY_DESC, "Infests the next object with spiders, making it more difficult to clear.");
            ac010.put(KEY_COST, 1);
            ac010.put(KEY_REQUIRESLVL, 10);
            ac010.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac010);

            ContentValues ac011 = new ContentValues();
            ac011.put(KEY_NAME, "Speed Up II");
            ac011.put(KEY_IMAGE, "card_speed_up_2");
            ac011.put(KEY_TYPE, 3);
            ac011.put(KEY_DESC, "Gain 2 additional moves on next turn.");
            ac011.put(KEY_COST, 2);
            ac011.put(KEY_REQUIRESLVL, 12);
            ac011.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac011);

            ContentValues ac012 = new ContentValues();
            ac012.put(KEY_NAME, "Corruption");
            ac012.put(KEY_IMAGE, "card_corruption");
            ac012.put(KEY_TYPE, 2);
            ac012.put(KEY_DESC, "All moves cost one more next turn.");
            ac012.put(KEY_COST, 2);
            ac012.put(KEY_REQUIRESLVL, 7);
            ac012.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac012);

            ContentValues ac013 = new ContentValues();
            ac013.put(KEY_NAME, "Mimic");
            ac013.put(KEY_IMAGE, "card_mimic");
            ac013.put(KEY_TYPE, 3);
            ac013.put(KEY_DESC, "Copies the effect of the opponents last played card.");
            ac013.put(KEY_COST, 2);
            ac013.put(KEY_REQUIRESLVL, 16);
            ac013.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac013);

            ContentValues ac014 = new ContentValues();
            ac014.put(KEY_NAME, "Restore");
            ac014.put(KEY_IMAGE, "card_restore");
            ac014.put(KEY_TYPE, 1);
            ac014.put(KEY_DESC, "Brings back half of the cleared objects.");
            ac014.put(KEY_COST, 2);
            ac014.put(KEY_REQUIRESLVL, 17);
            ac014.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac014);

            ContentValues ac015 = new ContentValues();
            ac015.put(KEY_NAME, "Curse");
            ac015.put(KEY_IMAGE, "card_curse");
            ac015.put(KEY_TYPE, 2);
            ac015.put(KEY_DESC, "Reduces score by half after three turns.");
            ac015.put(KEY_COST, 2);
            ac015.put(KEY_REQUIRESLVL, 0);
            ac015.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac015);

            ContentValues ac016 = new ContentValues();
            ac016.put(KEY_NAME, "Agony");
            ac016.put(KEY_IMAGE, "card_agony");
            ac016.put(KEY_TYPE, 2);
            ac016.put(KEY_DESC, "Reduces score by 3 at the start of the turn. Lasts three turns.");
            ac016.put(KEY_COST, 2);
            ac016.put(KEY_REQUIRESLVL, 8);
            ac016.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac016);

            ContentValues ac017 = new ContentValues();
            ac017.put(KEY_NAME, "Malediction");
            ac017.put(KEY_IMAGE, "card_malediction");
            ac017.put(KEY_TYPE, 2);
            ac017.put(KEY_DESC, "Reduces score by 3/4 after four turns.");
            ac017.put(KEY_COST, 3);
            ac017.put(KEY_REQUIRESLVL, 18);
            ac017.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac017);

            ContentValues ac018 = new ContentValues();
            ac018.put(KEY_NAME, "Demonic Prayer");
            ac018.put(KEY_IMAGE, "card_demonic_prayer");
            ac018.put(KEY_TYPE, 2);
            ac018.put(KEY_DESC, "10% chance to reset opponent's score. Ignores Protect.");
            ac018.put(KEY_COST, 0);
            ac018.put(KEY_REQUIRESLVL, 0);
            ac018.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac018);

            ContentValues ac019 = new ContentValues();
            ac019.put(KEY_NAME, "Death Sentence");
            ac019.put(KEY_IMAGE, "card_death_sentence");
            ac019.put(KEY_TYPE, 2);
            ac019.put(KEY_DESC, "50% chance to reset opponent's score after 3 turns.");
            ac019.put(KEY_COST, 2);
            ac019.put(KEY_REQUIRESLVL, 14);
            ac019.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac019);

            ContentValues ac020 = new ContentValues();
            ac020.put(KEY_NAME, "Cure");
            ac020.put(KEY_IMAGE, "card_cure");
            ac020.put(KEY_TYPE, 3);
            ac020.put(KEY_DESC, "Removes all ailments from yourself.");
            ac020.put(KEY_COST, 1);
            ac020.put(KEY_REQUIRESLVL, 0);
            ac020.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac020);

            ContentValues ac021 = new ContentValues();
            ac021.put(KEY_NAME, "Rewind");
            ac021.put(KEY_IMAGE, "card_rewind");
            ac021.put(KEY_TYPE, 3);
            ac021.put(KEY_DESC, "Gain another turn at the end of current turn.");
            ac021.put(KEY_COST, 0);
            ac021.put(KEY_REQUIRESLVL, 19);
            ac021.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac021);

            ContentValues ac022 = new ContentValues();
            ac022.put(KEY_NAME, "Protect");
            ac022.put(KEY_IMAGE, "card_protect");
            ac022.put(KEY_TYPE, 3);
            ac022.put(KEY_DESC, "Gain a temporary shield that protects against ailments. Lasts 2 turns.");
            ac022.put(KEY_COST, 1);
            ac022.put(KEY_REQUIRESLVL, 11);
            ac022.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac022);

            ContentValues ac023 = new ContentValues();
            ac023.put(KEY_NAME, "Hoard");
            ac023.put(KEY_IMAGE, "card_hoard");
            ac023.put(KEY_TYPE, 3);
            ac023.put(KEY_DESC, "Keep the next card you play. Lasts until a card is played.");
            ac023.put(KEY_COST, 1);
            ac023.put(KEY_REQUIRESLVL, 20);
            ac023.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac023);

            ContentValues ac024 = new ContentValues();
            ac024.put(KEY_NAME, "Dispel");
            ac024.put(KEY_IMAGE, "card_dispel");
            ac024.put(KEY_TYPE, 2);
            ac024.put(KEY_DESC, "Removes all positive buffs from the opponent.");
            ac024.put(KEY_COST, 1);
            ac024.put(KEY_REQUIRESLVL, 15);
            ac024.put(KEY_ISUNLOCKED, 0);
            db.insert(AllCards, null, ac024);

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

            /* WORLD 1 LEVEL INFO */
            ContentValues li = new ContentValues();
            li.put(KEY_NAME, "W001LVL001");
            li.put(KEY_WORLDID, 1);
            li.put(KEY_LVLCLEARED, 0);
            li.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li);

            ContentValues li002 = new ContentValues();
            li002.put(KEY_NAME, "W001LVL002");
            li002.put(KEY_WORLDID, 1);
            li002.put(KEY_LVLCLEARED, 0);
            li002.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li002);

            ContentValues li003 = new ContentValues();
            li003.put(KEY_NAME, "W001LVL003");
            li003.put(KEY_WORLDID, 1);
            li003.put(KEY_LVLCLEARED, 0);
            li003.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li003);

            ContentValues li004 = new ContentValues();
            li004.put(KEY_NAME, "W001LVL004");
            li004.put(KEY_WORLDID, 1);
            li004.put(KEY_LVLCLEARED, 0);
            li004.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li004);

            ContentValues li005 = new ContentValues();
            li005.put(KEY_NAME, "W001LVL005");
            li005.put(KEY_WORLDID, 1);
            li005.put(KEY_LVLCLEARED, 0);
            li005.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li005);

            ContentValues li006 = new ContentValues();
            li006.put(KEY_NAME, "W001LVL006");
            li006.put(KEY_WORLDID, 1);
            li006.put(KEY_LVLCLEARED, 0);
            li006.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li006);

            ContentValues li007 = new ContentValues();
            li007.put(KEY_NAME, "W001LVL007");
            li007.put(KEY_WORLDID, 1);
            li007.put(KEY_LVLCLEARED, 0);
            li007.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li007);

            ContentValues li008 = new ContentValues();
            li008.put(KEY_NAME, "W001LVL008");
            li008.put(KEY_WORLDID, 1);
            li008.put(KEY_LVLCLEARED, 0);
            li008.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li008);

            /* WORLD 2 LEVEL INFO */
            ContentValues li009 = new ContentValues();
            li009.put(KEY_NAME, "W002LVL001");
            li009.put(KEY_WORLDID, 2);
            li009.put(KEY_LVLCLEARED, 0);
            li009.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li009);

            ContentValues li010 = new ContentValues();
            li010.put(KEY_NAME, "W002LVL002");
            li010.put(KEY_WORLDID, 2);
            li010.put(KEY_LVLCLEARED, 0);
            li010.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li010);

            ContentValues li011 = new ContentValues();
            li011.put(KEY_NAME, "W002LVL003");
            li011.put(KEY_WORLDID, 2);
            li011.put(KEY_LVLCLEARED, 0);
            li011.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li011);

            ContentValues li013 = new ContentValues();
            li013.put(KEY_NAME, "W002LVL004");
            li013.put(KEY_WORLDID, 2);
            li013.put(KEY_LVLCLEARED, 0);
            li013.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li013);

            ContentValues li014 = new ContentValues();
            li014.put(KEY_NAME, "W002LVL005");
            li014.put(KEY_WORLDID, 2);
            li014.put(KEY_LVLCLEARED, 0);
            li014.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li014);

            ContentValues li015 = new ContentValues();
            li015.put(KEY_NAME, "W002LVL006");
            li015.put(KEY_WORLDID, 2);
            li015.put(KEY_LVLCLEARED, 0);
            li015.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li015);

            ContentValues li016 = new ContentValues();
            li016.put(KEY_NAME, "W002LVL007");
            li016.put(KEY_WORLDID, 2);
            li016.put(KEY_LVLCLEARED, 0);
            li016.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li016);

            ContentValues li017 = new ContentValues();
            li017.put(KEY_NAME, "W002LVL008");
            li017.put(KEY_WORLDID, 2);
            li017.put(KEY_LVLCLEARED, 0);
            li017.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li017);

            /* WORLD 3 LEVEL INFO */
            ContentValues li018 = new ContentValues();
            li018.put(KEY_NAME, "W003LVL001");
            li018.put(KEY_WORLDID, 3);
            li018.put(KEY_LVLCLEARED, 0);
            li018.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li018);

            ContentValues li019 = new ContentValues();
            li019.put(KEY_NAME, "W003LVL002");
            li019.put(KEY_WORLDID, 3);
            li019.put(KEY_LVLCLEARED, 0);
            li019.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li019);

            ContentValues li020 = new ContentValues();
            li020.put(KEY_NAME, "W003LVL003");
            li020.put(KEY_WORLDID, 3);
            li020.put(KEY_LVLCLEARED, 0);
            li020.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li020);

            ContentValues li021 = new ContentValues();
            li021.put(KEY_NAME, "W003LVL004");
            li021.put(KEY_WORLDID, 3);
            li021.put(KEY_LVLCLEARED, 0);
            li021.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li021);

            ContentValues li022 = new ContentValues();
            li022.put(KEY_NAME, "W003LVL005");
            li022.put(KEY_WORLDID, 3);
            li022.put(KEY_LVLCLEARED, 0);
            li022.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li022);

            ContentValues li023 = new ContentValues();
            li023.put(KEY_NAME, "W003LVL006");
            li023.put(KEY_WORLDID, 3);
            li023.put(KEY_LVLCLEARED, 0);
            li023.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li023);

            ContentValues li024 = new ContentValues();
            li024.put(KEY_NAME, "W003LVL007");
            li024.put(KEY_WORLDID, 3);
            li024.put(KEY_LVLCLEARED, 0);
            li024.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li024);

            ContentValues li025 = new ContentValues();
            li025.put(KEY_NAME, "W003LVL008");
            li025.put(KEY_WORLDID, 3);
            li025.put(KEY_LVLCLEARED, 0);
            li025.put(KEY_LVLHIGHSCORE, 0);
            db.insert(LevelsInfo, null, li025);

            /* WORLDS INFO */
            ContentValues worldInfo = new ContentValues();
            worldInfo.put(KEY_NAME, "Fields");
            worldInfo.put(KEY_WORLDCLEARED, 0);
            worldInfo.put(KEY_WORLDHIGHSCORE, 0);
            db.insert(WorldsInfo, null, worldInfo);

            ContentValues worldInfo2 = new ContentValues();
            worldInfo2.put(KEY_NAME, "Dungeon");
            worldInfo2.put(KEY_WORLDCLEARED, 0);
            worldInfo2.put(KEY_WORLDHIGHSCORE, 0);
            db.insert(WorldsInfo, null, worldInfo2);

            ContentValues worldInfo3 = new ContentValues();
            worldInfo3.put(KEY_NAME, "Mountains");
            worldInfo3.put(KEY_WORLDCLEARED, 0);
            worldInfo3.put(KEY_WORLDHIGHSCORE, 0);
            db.insert(WorldsInfo, null, worldInfo3);

            ContentValues worldInfo4 = new ContentValues();
            worldInfo4.put(KEY_NAME, "Wreckage");
            worldInfo4.put(KEY_WORLDCLEARED, 0);
            worldInfo4.put(KEY_WORLDHIGHSCORE, 0);
            db.insert(WorldsInfo, null, worldInfo4);

            ContentValues worldInfo5 = new ContentValues();
            worldInfo5.put(KEY_NAME, "Woods");
            worldInfo5.put(KEY_WORLDCLEARED, 0);
            worldInfo5.put(KEY_WORLDHIGHSCORE, 0);
            db.insert(WorldsInfo, null, worldInfo5);

            ContentValues worldInfo6 = new ContentValues();
            worldInfo6.put(KEY_NAME, "Trainyard");
            worldInfo6.put(KEY_WORLDCLEARED, 0);
            worldInfo6.put(KEY_WORLDHIGHSCORE, 0);
            db.insert(WorldsInfo, null, worldInfo6);

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

    /* Method for updating player slots */
    public long updatePlayerSlots(int slots) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_UNLOCKEDSLOTS, slots);
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
        String selectQuery = "SELECT  * FROM allOwnedCards WHERE " + "type=" + 1 + " " + "ORDER BY name ASC";
        SQLiteDatabase db = ourHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    /* ALL FIELD CARDS */
    public Cursor getAllFieldCards() {
        String selectQuery = "SELECT  * FROM allCards WHERE " + "type=" + 1 + " " + "ORDER BY name ASC";
        SQLiteDatabase db = ourHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    /* ALL OWNED AILMENT CARDS */
    public Cursor getAllOwnedAilmentCards() {
        String selectQuery = "SELECT  * FROM allOwnedCards WHERE " + "type=" + 2 + " " + "ORDER BY name ASC";
        SQLiteDatabase db = ourHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    /* ALL AILMENT CARDS */
    public Cursor getAllAilmentCards() {
        String selectQuery = "SELECT  * FROM allCards WHERE " + "type=" + 2 + " " + "ORDER BY name ASC";
        SQLiteDatabase db = ourHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    /* ALL OWNED BOOSTING CARDS */
    public Cursor getAllOwnedBoostingCards() {
        String selectQuery = "SELECT  * FROM allOwnedCards WHERE " + "type=" + 3 + " " + "ORDER BY name ASC";
        SQLiteDatabase db = ourHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    /* ALL BOOSTING CARDS */
    public Cursor getAllBoostingCards() {
        String selectQuery = "SELECT  * FROM allCards WHERE " + "type=" + 3 + " " + "ORDER BY name ASC";
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

    public Cursor getWorldInfo(int worldId){
        String selectQuery = "SELECT  * FROM levelsInfo WHERE " + "_id=" + worldId;
        SQLiteDatabase db = ourHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

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

    /* UPDATE LVL INFO */
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
        addOwnedCard("Steal", "card_steal_3", 1, 1, "Steals 1-3 points from the opponent.");
        addOwnedCard("Concentrate", "card_concentrate", 3, 1, "Doubles points gained next turn.");
        addOwnedCard("Steal II", "card_steal_5", 1, 2, "Steals 3-5 points from the opponent.");
        addOwnedCard("Steal III", "card_steal_7", 1, 3, "Steals 5-7 points from the opponent.");
        addOwnedCard("Infest", "card_infest", 1, 1, "Infests the next object with spiders, making it more difficult to clear.");
        addOwnedCard("Speed Up II", "card_speed_up_2", 3, 2, "Gain 2 additional moves on next turn.");
        addOwnedCard("Corruption", "card_corruption", 2, 2, "All moves cost one more next turn.");
        addOwnedCard("Mimic", "card_mimic", 3, 2, "Copies the effect of the opponents last played card.");
        addOwnedCard("Restore", "card_restore", 1, 2, "Brings back half of the cleared objects.");
        addOwnedCard("Curse", "card_curse", 2, 2, "Reduces score by half after three turns.");
        addOwnedCard("Agony", "card_agony", 2, 2, "Reduces score by 3 at the start of the turn. Lasts three turns.");
        addOwnedCard("Malediction", "card_malediction", 2, 3, "Reduces score by 3/4 after three four.");
        addOwnedCard("Demonic Prayer", "card_demonic_prayer", 2, 0, "10% chance to reset opponent's score. Ignores Protect.");
        addOwnedCard("Death Sentence", "card_death_sentence", 2, 2, "50% chance to reset opponent's score after 3 turns.");
        addOwnedCard("Cure", "card_cure", 3, 1, "Removes all ailments from yourself.");
        addOwnedCard("Rewind", "card_rewind", 3, 0, "Gain another turn at the end of current turn.");
        addOwnedCard("Protect", "card_protect", 3, 1, "Gain a temporary shield that protects against ailments. Lasts 2 turns.");
        addOwnedCard("Hoard", "card_hoard", 3, 1, "Keep the next card you play. Lasts until a card is played.");
        addOwnedCard("Dispel", "card_dispel", 2, 1, "Removes all positive buffs from the opponent.");
        unlockCard(2,1);
        unlockCard(3,1);
        unlockCard(4,1);
        unlockCard(5,1);
        unlockCard(6,1);
        unlockCard(7,1);
        unlockCard(8,1);
        unlockCard(9,1);
        unlockCard(10,1);
        unlockCard(11,1);
        unlockCard(12,1);
        unlockCard(13,1);
        unlockCard(14,1);
        unlockCard(15,1);
        unlockCard(16,1);
        unlockCard(17,1);
        unlockCard(18,1);
        unlockCard(19,1);
        unlockCard(20,1);
        unlockCard(21,1);
        unlockCard(22,1);
        unlockCard(23,1);
        unlockCard(24,1);
    }
    public void reset(){
        appDB = ourHelper.getWritableDatabase();
        appDB.execSQL ("drop table "+SelectedCards);
        appDB.execSQL ("drop table "+AllCards);
        appDB.execSQL ("drop table "+PlayerInfo);
        appDB.execSQL ("drop table "+OwnedCards);
        appDB.execSQL ("drop table "+LevelsInfo);
        appDB.execSQL ("drop table "+WorldsInfo);
        this.ourHelper.onCreate (this.appDB);
    }
}
