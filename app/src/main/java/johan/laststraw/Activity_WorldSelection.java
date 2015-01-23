package johan.laststraw;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Johan on 2014-09-27.
 */
public class Activity_WorldSelection extends Activity implements View.OnClickListener {

    ImageButton bFields, bDungeon, bMountains, bWreckage;
    Intent worldSelected;
    DBHandler db;
    Cursor cursor;
    TextView world001High, world002High, world003High, world004High, world005High, world006High;
    int w001lv001score, w001lv002score, w001lv003score, w001lv004score, w001lv005score, w001lv006score, w001lv007score, w001lv008score;
    int totalScore;
    ImageView w1star1, w1star2, w1star3, w2star1, w2star2, w2star3, w3star1, w3star2, w3star3,
            w4star1, w4star2, w4star3, w5star1, w5star2, w5star3, w6star1, w6star2, w6star3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worldselection);

        bFields = (ImageButton) findViewById(R.id.imgBtnWorld001);
        bDungeon = (ImageButton) findViewById(R.id.imgBtnWorld002);
        bMountains = (ImageButton) findViewById(R.id.imgBtnWorld003);
        bWreckage = (ImageButton) findViewById(R.id.imgBtnWorld004);
        bFields.setOnClickListener(this);
        bDungeon.setOnClickListener(this);
        bMountains.setOnClickListener(this);
        bWreckage.setOnClickListener(this);

        bDungeon.setClickable(false);
        bMountains.setClickable(false);
        bWreckage.setClickable(false);

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
        //Check World 1 if is cleared
        getLevelInfo(8);
        //Check World 2 if is cleared
        getLevelInfo(16);
        //Check World 3 if is cleared
        getLevelInfo(24);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBtnWorld001:
                worldSelected = new Intent(Activity_WorldSelection.this, Activity_Fields_LevelSelection.class);
                worldSelected.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(worldSelected);
                finish();
                overridePendingTransition(0, 0);
                break;
            case R.id.imgBtnWorld002:
                worldSelected = new Intent(Activity_WorldSelection.this, Activity_Dungeon_LevelSelection.class);
                worldSelected.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(worldSelected);
                finish();
                overridePendingTransition(0, 0);
                break;
            case R.id.imgBtnWorld003:
                worldSelected = new Intent(Activity_WorldSelection.this, Activity_Mountains_LevelSelection.class);
                worldSelected.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(worldSelected);
                finish();
                overridePendingTransition(0, 0);
                break;
            case R.id.imgBtnWorld004:
                worldSelected = new Intent(Activity_WorldSelection.this, Activity_Wreckage_LevelSelection.class);
                worldSelected.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(worldSelected);
                finish();
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

        if (worldId == 1){
            world001High.setText(String.valueOf(totalScore));
            setW1Stars();
        }
        if (worldId == 2){
            world002High.setText(String.valueOf(totalScore));
            setW2Stars();
        }
        if (worldId == 3){
            world003High.setText(String.valueOf(totalScore));
            setW3Stars();
        }
        if (worldId == 4){
            world004High.setText(String.valueOf(totalScore));
            setW4Stars();
        }
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
        if (worldId == 1 && worldCleared == 1){
            bDungeon.setImageResource(R.drawable.world_dungeon);
            bDungeon.setBackgroundResource(R.drawable.lvlselection_button);
            bDungeon.setClickable(true);
        }
        if (worldId == 2 && worldCleared == 1){
            bMountains.setImageResource(R.drawable.world_mountains);
            bMountains.setBackgroundResource(R.drawable.lvlselection_button);
            bMountains.setClickable(true);
        }
        if (worldId == 3 && worldCleared == 1){
            bWreckage.setImageResource(R.drawable.world_wreckage);
            bWreckage.setBackgroundResource(R.drawable.lvlselection_button);
            bWreckage.setClickable(true);
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
        }
    }
}



