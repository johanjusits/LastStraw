package johan.laststraw;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by Johan on 2014-09-27.
 */
public class Activity_WorldSelection extends Activity implements View.OnClickListener {

    ImageButton bFields, bDungeon, bMountains, bWreckage, bWoods, bTrain;
    Intent worldSelected;
    DBHandler db;
    Cursor cursor;
    TextView world001High, world002High, world003High, world004High, world005High, world006High;
    int w001lv001score, w001lv002score, w001lv003score, w001lv004score, w001lv005score, w001lv006score, w001lv007score, w001lv008score;
    int totalScore, accountScore;
    ImageView w1star1, w1star2, w1star3, w2star1, w2star2, w2star3, w3star1, w3star2, w3star3,
            w4star1, w4star2, w4star3, w5star1, w5star2, w5star3, w6star1, w6star2, w6star3;
    boolean w1gold = false;
    boolean w2gold = false;
    boolean w3gold = false;
    boolean w4gold = false;
    boolean w5gold = false;
    boolean w6gold = false;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worldselection);

        // Create the interstitial.
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-1205040448652074/2063651142");

        // Create ad request.
        AdRequest adRequest = new AdRequest.Builder().build();

        // Begin loading your interstitial.
        interstitialAd.loadAd(adRequest);

        bFields = (ImageButton) findViewById(R.id.imgBtnWorld001);
        bDungeon = (ImageButton) findViewById(R.id.imgBtnWorld002);
        bMountains = (ImageButton) findViewById(R.id.imgBtnWorld003);
        bWreckage = (ImageButton) findViewById(R.id.imgBtnWorld004);
        bWoods = (ImageButton) findViewById(R.id.imgBtnWorld005);
        bTrain = (ImageButton) findViewById(R.id.imgBtnWorld006);

        bFields.setOnClickListener(this);
        bDungeon.setOnClickListener(this);
        bMountains.setOnClickListener(this);
        bWreckage.setOnClickListener(this);
        bWoods.setOnClickListener(this);
        bTrain.setOnClickListener(this);

        bDungeon.setClickable(false);
        bMountains.setClickable(false);
        bWreckage.setClickable(false);
        bWoods.setClickable(false);
        bTrain.setClickable(false);

        w1star1 = (ImageView) findViewById(R.id.ivW1Star1);
        w1star2 = (ImageView) findViewById(R.id.ivW1Star2);
        w1star3 = (ImageView) findViewById(R.id.ivW1Star3);
        w2star1 = (ImageView) findViewById(R.id.ivW2Star1);
        w2star2 = (ImageView) findViewById(R.id.ivW2Star2);
        w2star3 = (ImageView) findViewById(R.id.ivW2Star3);
        w3star1 = (ImageView) findViewById(R.id.ivW3Star1);
        w3star2 = (ImageView) findViewById(R.id.ivW3Star2);
        w3star3 = (ImageView) findViewById(R.id.ivW3Star3);
        w4star1 = (ImageView) findViewById(R.id.ivW4Star1);
        w4star2 = (ImageView) findViewById(R.id.ivW4Star2);
        w4star3 = (ImageView) findViewById(R.id.ivW4Star3);
        w5star1 = (ImageView) findViewById(R.id.ivW5Star1);
        w5star2 = (ImageView) findViewById(R.id.ivW5Star2);
        w5star3 = (ImageView) findViewById(R.id.ivW5Star3);
        w6star1 = (ImageView) findViewById(R.id.ivW6Star1);
        w6star2 = (ImageView) findViewById(R.id.ivW6Star2);
        w6star3 = (ImageView) findViewById(R.id.ivW6Star3);

        world001High = (TextView) findViewById(R.id.world001High);
        world002High = (TextView) findViewById(R.id.world002High);
        world003High = (TextView) findViewById(R.id.world003High);
        world004High = (TextView) findViewById(R.id.world004High);
        world005High = (TextView) findViewById(R.id.world005High);
        world006High = (TextView) findViewById(R.id.world006High);

        db = new DBHandler(this);

        getWorldHighScores(1);
        getWorldHighScores(2);
        getWorldHighScores(3);
        getWorldHighScores(4);
        getWorldHighScores(5);
        getWorldHighScores(6);
        //Check World 1 if is cleared
        getLevelInfo(8);
        //Check World 2 if is cleared
        getLevelInfo(16);
        //Check World 3 if is cleared
        getLevelInfo(24);
        //Check World 4 if is cleared
        getLevelInfo(32);
        //Check World 5 if is cleared
        getLevelInfo(40);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBtnWorld001:
                worldSelected = new Intent(Activity_WorldSelection.this, Activity_Fields_LevelSelection.class);
                worldSelected.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(worldSelected);
                overridePendingTransition(0, 0);
                break;
            case R.id.imgBtnWorld002:
                worldSelected = new Intent(Activity_WorldSelection.this, Activity_Dungeon_LevelSelection.class);
                worldSelected.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(worldSelected);
                overridePendingTransition(0, 0);
                break;
            case R.id.imgBtnWorld003:
                worldSelected = new Intent(Activity_WorldSelection.this, Activity_Mountains_LevelSelection.class);
                worldSelected.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(worldSelected);
                overridePendingTransition(0, 0);
                break;
            case R.id.imgBtnWorld004:
                worldSelected = new Intent(Activity_WorldSelection.this, Activity_Wreckage_LevelSelection.class);
                worldSelected.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(worldSelected);
                overridePendingTransition(0, 0);
                break;
            case R.id.imgBtnWorld005:
                worldSelected = new Intent(Activity_WorldSelection.this, Activity_Woods_LevelSelection.class);
                worldSelected.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(worldSelected);
                overridePendingTransition(0, 0);
                break;
            case R.id.imgBtnWorld006:
                worldSelected = new Intent(Activity_WorldSelection.this, Activity_Trainyard_LevelSelection.class);
                worldSelected.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(worldSelected);
                overridePendingTransition(0, 0);
                break;
        }
    }

    private void getWorldHighScores(int worldId){
        int highScores[] = new int[8];
        int i = 0;
        totalScore = 0;

        try {
            db.open();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        cursor = db.getFieldsLvlsInfo(worldId);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    highScores[i] = cursor.getInt(cursor.getColumnIndex("lvlhighscore"));
                    totalScore = totalScore + highScores[i];
                    i++;
                } while (cursor.moveToNext());
            }
        }
        db.close();
        w001lv001score = highScores[0];
        w001lv002score = highScores[1];
        w001lv003score = highScores[2];
        w001lv004score = highScores[3];
        w001lv005score = highScores[4];
        w001lv006score = highScores[5];
        w001lv007score = highScores[6];
        w001lv008score = highScores[7];

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();

        if (worldId == 1){
            editor.putInt("W1Total", totalScore);
            world001High.setText(String.valueOf(totalScore));
            setW1Stars();
        }
        if (worldId == 2){
            editor.putInt("W2Total", totalScore);
            world002High.setText(String.valueOf(totalScore));
            setW2Stars();
        }
        if (worldId == 3){
            editor.putInt("W3Total", totalScore);
            world003High.setText(String.valueOf(totalScore));
            setW3Stars();
        }
        if (worldId == 4){
            editor.putInt("W4Total", totalScore);
            world004High.setText(String.valueOf(totalScore));
            setW4Stars();
        }
        if (worldId == 5){
            editor.putInt("W5Total", totalScore);
            world005High.setText(String.valueOf(totalScore));
            setW5Stars();
        }
        if (worldId == 6){
            editor.putInt("W6Total", totalScore);
            world006High.setText(String.valueOf(totalScore));
            setW6Stars();
        }

        accountScore = Integer.parseInt(world001High.getText().toString()) +
                Integer.parseInt(world002High.getText().toString()) +
                Integer.parseInt(world003High.getText().toString()) +
                Integer.parseInt(world004High.getText().toString()) +
                Integer.parseInt(world005High.getText().toString()) +
                Integer.parseInt(world006High.getText().toString());
        editor.putInt("AccountScore", accountScore);
        editor.apply();
    }

    @Override
    public void onBackPressed() {
        this.finish();
        overridePendingTransition(0, 0);
    }

    private void getLevelInfo(int id){
        int worldCleared = 0;
        int worldId = 0;
        try {
            db.open();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        cursor = db.getLvlInfo(id);
        if (cursor != null && cursor.moveToFirst()) {
            worldCleared = cursor.getInt(cursor.getColumnIndex("lvlcleared"));
            worldId = cursor.getInt(cursor.getColumnIndex("worldid"));
        }
        unlockWorlds(worldId, worldCleared);
        db.close();
    }

    private void unlockWorlds(int worldId, int worldCleared){
        if (w1gold){
            bFields.setBackgroundResource(R.drawable.world_gold);
        } else {
            bFields.setBackgroundResource(R.drawable.lvlselection_button);
        }
        if (worldId == 1 && worldCleared == 1){
            bDungeon.setImageResource(R.drawable.portrait_w02);
            if (w2gold){
                bDungeon.setBackgroundResource(R.drawable.world_gold);
            } else {
                bDungeon.setBackgroundResource(R.drawable.lvlselection_button);
            }
            bDungeon.setClickable(true);
        }
        if (worldId == 2 && worldCleared == 1){
            bMountains.setImageResource(R.drawable.portrait_w03);
            if (w3gold){
                bMountains.setBackgroundResource(R.drawable.world_gold);
            } else {
                bMountains.setBackgroundResource(R.drawable.lvlselection_button);
            }
            bMountains.setClickable(true);
        }
        if (worldId == 3 && worldCleared == 1){
            bWreckage.setImageResource(R.drawable.portrait_w04);
            if (w4gold){
                bWreckage.setBackgroundResource(R.drawable.world_gold);
            } else {
                bWreckage.setBackgroundResource(R.drawable.lvlselection_button);
            }
            bWreckage.setClickable(true);
        }
        if (worldId == 4 && worldCleared == 1){
            bWoods.setImageResource(R.drawable.portrait_w05);
            if (w5gold){
                bWoods.setBackgroundResource(R.drawable.world_gold);
            } else {
                bWoods.setBackgroundResource(R.drawable.lvlselection_button);
            }
            bWoods.setClickable(true);
        }
        if (worldId == 5 && worldCleared == 1){
            bTrain.setImageResource(R.drawable.portrait_w06);
            if (w6gold){
                bTrain.setBackgroundResource(R.drawable.world_gold);
            } else {
                bTrain.setBackgroundResource(R.drawable.lvlselection_button);
            }
            bTrain.setClickable(true);
        }
    }

    private void setW1Stars(){
        if (totalScore >= 120 && totalScore < 160){
            w1star1.setImageResource(R.drawable.star_full);
        }
        if (totalScore >= 160 && totalScore < 200){
            w1star1.setImageResource(R.drawable.star_full);
            w1star2.setImageResource(R.drawable.star_full);
        }
        if (totalScore >= 200){
            w1star1.setImageResource(R.drawable.star_full);
            w1star2.setImageResource(R.drawable.star_full);
            w1star3.setImageResource(R.drawable.star_full);
            w1gold = true;
        }
    }

    private void setW2Stars(){
        if (totalScore >= 120 && totalScore < 160){
            w2star1.setImageResource(R.drawable.star_full);
        }
        if (totalScore >= 160 && totalScore < 200){
            w2star1.setImageResource(R.drawable.star_full);
            w2star2.setImageResource(R.drawable.star_full);
        }
        if (totalScore >= 200){
            w2star1.setImageResource(R.drawable.star_full);
            w2star2.setImageResource(R.drawable.star_full);
            w2star3.setImageResource(R.drawable.star_full);
            w2gold = true;
        }
    }

    private void setW3Stars(){
        if (totalScore >= 120 && totalScore < 160){
            w3star1.setImageResource(R.drawable.star_full);
        }
        if (totalScore >= 160 && totalScore < 200){
            w3star1.setImageResource(R.drawable.star_full);
            w3star2.setImageResource(R.drawable.star_full);
        }
        if (totalScore >= 200){
            w3star1.setImageResource(R.drawable.star_full);
            w3star2.setImageResource(R.drawable.star_full);
            w3star3.setImageResource(R.drawable.star_full);
            w3gold = true;
        }
    }

    private void setW4Stars(){
        if (totalScore >= 120 && totalScore < 160){
            w4star1.setImageResource(R.drawable.star_full);
        }
        if (totalScore >= 160 && totalScore < 200){
            w4star1.setImageResource(R.drawable.star_full);
            w4star2.setImageResource(R.drawable.star_full);
        }
        if (totalScore >= 200){
            w4star1.setImageResource(R.drawable.star_full);
            w4star2.setImageResource(R.drawable.star_full);
            w4star3.setImageResource(R.drawable.star_full);
            w4gold = true;
        }
    }

    private void setW5Stars(){
        if (totalScore >= 120 && totalScore < 160){
            w5star1.setImageResource(R.drawable.star_full);
        }
        if (totalScore >= 160 && totalScore < 200){
            w5star1.setImageResource(R.drawable.star_full);
            w5star2.setImageResource(R.drawable.star_full);
        }
        if (totalScore >= 200){
            w5star1.setImageResource(R.drawable.star_full);
            w5star2.setImageResource(R.drawable.star_full);
            w5star3.setImageResource(R.drawable.star_full);
            w5gold = true;
        }
    }

    private void setW6Stars(){
        if (totalScore >= 120 && totalScore < 160){
            w6star1.setImageResource(R.drawable.star_full);
        }
        if (totalScore >= 160 && totalScore < 200){
            w6star1.setImageResource(R.drawable.star_full);
            w6star2.setImageResource(R.drawable.star_full);
        }
        if (totalScore >= 200){
            w6star1.setImageResource(R.drawable.star_full);
            w6star2.setImageResource(R.drawable.star_full);
            w6star3.setImageResource(R.drawable.star_full);
            w6gold = true;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        displayAd();
    }

    public void displayAd() {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        }
    }
}



