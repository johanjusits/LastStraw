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

/**
 * Created by Johan on 2014-09-27.
 */
public class Activity_Fields_LevelSelection extends Activity implements View.OnClickListener {

    ImageButton bLv001, bLv002, bLv003, bLv004, bLv005, bLv006, bLv007, bLv008;
    Intent pickCards;
    TextView lv1score, lv2score, lv3score, lv4score, lv5score, lv6score, lv7score, lv8score;
    DBHandler db;
    ImageView lv1star1, lv1star2, lv1star3, lv2star1, lv2star2, lv2star3, lv3star1, lv3star2, lv3star3,
            lv4star1, lv4star2, lv4star3, lv5star1, lv5star2, lv5star3, lv6star1, lv6star2, lv6star3,
            lv7star1, lv7star2, lv7star3, lv8star1, lv8star2, lv8star3;
    Cursor cursor;
    int lv001Cleared, lv002Cleared, lv003Cleared, lv004Cleared, lv005Cleared, lv006Cleared,
        lv007Cleared, lv008Cleared;
    int lv001Score, lv002Score, lv003Score, lv004Score, lv005Score, lv006Score,
            lv007Score, lv008Score;
    boolean lv1gold = false;
    boolean lv2gold = false;
    boolean lv3gold = false;
    boolean lv4gold = false;
    boolean lv5gold = false;
    boolean lv6gold = false;
    boolean lv7gold = false;
    boolean lv8gold = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fieldslvlselection);

        lv1score = (TextView) findViewById(R.id.tvLv1Score);
        lv2score = (TextView) findViewById(R.id.tvLv2Score);
        lv3score = (TextView) findViewById(R.id.tvLv3Score);
        lv4score = (TextView) findViewById(R.id.tvLv4Score);
        lv5score = (TextView) findViewById(R.id.tvLv5Score);
        lv6score = (TextView) findViewById(R.id.tvLv6Score);
        lv7score = (TextView) findViewById(R.id.tvLv7Score);
        lv8score = (TextView) findViewById(R.id.tvLv8Score);

        lv1star1 = (ImageView) findViewById(R.id.ivLv1Star1);
        lv1star2 = (ImageView) findViewById(R.id.ivLv1Star2);
        lv1star3 = (ImageView) findViewById(R.id.ivLv1Star3);
        lv2star1 = (ImageView) findViewById(R.id.ivLv2Star1);
        lv2star2 = (ImageView) findViewById(R.id.ivLv2Star2);
        lv2star3 = (ImageView) findViewById(R.id.ivLv2Star3);
        lv3star1 = (ImageView) findViewById(R.id.ivLv3Star1);
        lv3star2 = (ImageView) findViewById(R.id.ivLv3Star2);
        lv3star3 = (ImageView) findViewById(R.id.ivLv3Star3);
        lv4star1 = (ImageView) findViewById(R.id.ivLv4Star1);
        lv4star2 = (ImageView) findViewById(R.id.ivLv4Star2);
        lv4star3 = (ImageView) findViewById(R.id.ivLv4Star3);
        lv5star1 = (ImageView) findViewById(R.id.ivLv5Star1);
        lv5star2 = (ImageView) findViewById(R.id.ivLv5Star2);
        lv5star3 = (ImageView) findViewById(R.id.ivLv5Star3);
        lv6star1 = (ImageView) findViewById(R.id.ivLv6Star1);
        lv6star2 = (ImageView) findViewById(R.id.ivLv6Star2);
        lv6star3 = (ImageView) findViewById(R.id.ivLv6Star3);
        lv7star1 = (ImageView) findViewById(R.id.ivLv7Star1);
        lv7star2 = (ImageView) findViewById(R.id.ivLv7Star2);
        lv7star3 = (ImageView) findViewById(R.id.ivLv7Star3);
        lv8star1 = (ImageView) findViewById(R.id.ivLv8Star1);
        lv8star2 = (ImageView) findViewById(R.id.ivLv8Star2);
        lv8star3 = (ImageView) findViewById(R.id.ivLv8Star3);

        bLv001 = (ImageButton) findViewById(R.id.bWorld001Lvl001);
        bLv002 = (ImageButton) findViewById(R.id.bWorld001Lvl002);
        bLv003 = (ImageButton) findViewById(R.id.bWorld001Lvl003);
        bLv004 = (ImageButton) findViewById(R.id.bWorld001Lvl004);
        bLv005 = (ImageButton) findViewById(R.id.bWorld001Lvl005);
        bLv006 = (ImageButton) findViewById(R.id.bWorld001Lvl006);
        bLv007 = (ImageButton) findViewById(R.id.bWorld001Lvl007);
        bLv008 = (ImageButton) findViewById(R.id.bWorld001Lvl008);
        bLv001.setOnClickListener(this);
        bLv002.setOnClickListener(this);
        bLv003.setOnClickListener(this);
        bLv004.setOnClickListener(this);
        bLv005.setOnClickListener(this);
        bLv006.setOnClickListener(this);
        bLv007.setOnClickListener(this);
        bLv008.setOnClickListener(this);
        bLv002.setClickable(false);
        bLv003.setClickable(false);
        bLv004.setClickable(false);
        bLv005.setClickable(false);
        bLv006.setClickable(false);
        bLv007.setClickable(false);
        bLv008.setClickable(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bWorld001Lvl001:
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("LevelToLoad", ".Activity_PlayGame");
                editor.putString("LevelName", "Fields - Level 1");
                editor.putInt("LoadedLevelId", 1);
                editor.apply();
                pickCards = new Intent(Activity_Fields_LevelSelection.this, Activity_CardSelection.class);
                pickCards.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(pickCards);
                finish();
                overridePendingTransition(0, 0);
                break;
            case R.id.bWorld001Lvl002:
                preferences = PreferenceManager.getDefaultSharedPreferences(this);
                editor = preferences.edit();
                editor.putString("LevelToLoad", ".Activity_PlayGame");
                editor.putString("LevelName", "Fields - Level 2");
                editor.putInt("LoadedLevelId", 2);
                editor.apply();
                pickCards = new Intent(Activity_Fields_LevelSelection.this, Activity_CardSelection.class);
                pickCards.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(pickCards);
                finish();
                overridePendingTransition(0, 0);
                break;
            case R.id.bWorld001Lvl003:
                preferences = PreferenceManager.getDefaultSharedPreferences(this);
                editor = preferences.edit();
                editor.putString("LevelToLoad", ".Activity_PlayGame");
                editor.putString("LevelName", "Fields - Level 3");
                editor.putInt("LoadedLevelId", 3);
                editor.apply();
                pickCards = new Intent(Activity_Fields_LevelSelection.this, Activity_CardSelection.class);
                pickCards.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(pickCards);
                finish();
                overridePendingTransition(0, 0);
                break;
            case R.id.bWorld001Lvl004:
                preferences = PreferenceManager.getDefaultSharedPreferences(this);
                editor = preferences.edit();
                editor.putString("LevelToLoad", ".Activity_PlayGame");
                editor.putString("LevelName", "Fields - Level 4");
                editor.putInt("LoadedLevelId", 4);
                editor.apply();
                pickCards = new Intent(Activity_Fields_LevelSelection.this, Activity_CardSelection.class);
                pickCards.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(pickCards);
                finish();
                overridePendingTransition(0, 0);
                break;
            case R.id.bWorld001Lvl005:
                preferences = PreferenceManager.getDefaultSharedPreferences(this);
                editor = preferences.edit();
                editor.putString("LevelToLoad", ".Activity_PlayGame");
                editor.putString("LevelName", "Fields - Level 5");
                editor.putInt("LoadedLevelId", 5);
                editor.apply();
                pickCards = new Intent(Activity_Fields_LevelSelection.this, Activity_CardSelection.class);
                pickCards.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(pickCards);
                finish();
                overridePendingTransition(0, 0);
                break;
            case R.id.bWorld001Lvl006:
                preferences = PreferenceManager.getDefaultSharedPreferences(this);
                editor = preferences.edit();
                editor.putString("LevelToLoad", ".Activity_PlayGame");
                editor.putString("LevelName", "Fields - Level 6");
                editor.putInt("LoadedLevelId", 6);
                editor.apply();
                pickCards = new Intent(Activity_Fields_LevelSelection.this, Activity_CardSelection.class);
                pickCards.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(pickCards);
                finish();
                overridePendingTransition(0, 0);
                break;
            case R.id.bWorld001Lvl007:
                preferences = PreferenceManager.getDefaultSharedPreferences(this);
                editor = preferences.edit();
                editor.putString("LevelToLoad", ".Activity_PlayGame");
                editor.putString("LevelName", "Fields - Level 7");
                editor.putInt("LoadedLevelId", 7);
                editor.apply();
                pickCards = new Intent(Activity_Fields_LevelSelection.this, Activity_CardSelection.class);
                pickCards.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(pickCards);
                finish();
                overridePendingTransition(0, 0);
                break;
            case R.id.bWorld001Lvl008:
                preferences = PreferenceManager.getDefaultSharedPreferences(this);
                editor = preferences.edit();
                editor.putString("LevelToLoad", ".Activity_PlayGame");
                editor.putString("LevelName", "Fields - Level 8");
                editor.putInt("LoadedLevelId", 8);
                editor.apply();
                pickCards = new Intent(Activity_Fields_LevelSelection.this, Activity_CardSelection.class);
                pickCards.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(pickCards);
                finish();
                overridePendingTransition(0, 0);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        db = new DBHandler(this);

        try {
            db.open();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        updateLvlAccess();
        unlockLevels();
        db.close();
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(0, 0);
    }

    private void updateLvlAccess(){
        int clearChecks[] = new int[8];
        int highScores[] = new int[8];
        int i = 0;

        try {
            db.open();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        cursor = db.getFieldsLvlsInfo(1);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    clearChecks[i] = cursor.getInt(cursor.getColumnIndex("lvlcleared"));
                    highScores[i] = cursor.getInt(cursor.getColumnIndex("lvlhighscore"));
                    i++;
                } while (cursor.moveToNext());
            }
        }
        db.close();
        lv001Cleared = clearChecks[0];
        lv002Cleared = clearChecks[1];
        lv003Cleared = clearChecks[2];
        lv004Cleared = clearChecks[3];
        lv005Cleared = clearChecks[4];
        lv006Cleared = clearChecks[5];
        lv007Cleared = clearChecks[6];
        lv008Cleared = clearChecks[7];
        lv001Score = highScores[0];
        lv002Score = highScores[1];
        lv003Score = highScores[2];
        lv004Score = highScores[3];
        lv005Score = highScores[4];
        lv006Score = highScores[5];
        lv007Score = highScores[6];
        lv008Score = highScores[7];

        lv1score.setText(String.valueOf(lv001Score));
        setLv1Stars();
        lv2score.setText(String.valueOf(lv002Score));
        setLv2Stars();
        lv3score.setText(String.valueOf(lv003Score));
        setLv3Stars();
        lv4score.setText(String.valueOf(lv004Score));
        setLv4Stars();
        lv5score.setText(String.valueOf(lv005Score));
        setLv5Stars();
        lv6score.setText(String.valueOf(lv006Score));
        setLv6Stars();
        lv7score.setText(String.valueOf(lv007Score));
        setLv7Stars();
        lv8score.setText(String.valueOf(lv008Score));
        setLv8Stars();
    }

    private void unlockLevels(){
        if (lv1gold){
            bLv001.setBackgroundResource(R.drawable.world_gold);
        } else {
            bLv001.setBackgroundResource(R.drawable.lvlselection_button);
        }
        if (lv001Cleared == 1){
            bLv002.setImageResource(R.drawable.icon_fields);
            if (lv2gold){
                bLv002.setBackgroundResource(R.drawable.world_gold);
            } else {
                bLv002.setBackgroundResource(R.drawable.lvlselection_button);
            }
            bLv002.setClickable(true);
        }
        if (lv002Cleared == 1){
            bLv003.setImageResource(R.drawable.icon_fields);
            if (lv3gold){
                bLv003.setBackgroundResource(R.drawable.world_gold);
            } else {
                bLv003.setBackgroundResource(R.drawable.lvlselection_button);
            }
            bLv003.setClickable(true);
        }
        if (lv003Cleared == 1){
            bLv004.setImageResource(R.drawable.icon_miniboss);
            if (lv4gold){
                bLv004.setBackgroundResource(R.drawable.world_gold);
            } else {
                bLv004.setBackgroundResource(R.drawable.lvlselection_button);
            }
            bLv004.setClickable(true);
        }
        if (lv004Cleared == 1){
            bLv005.setImageResource(R.drawable.icon_fields);
            if (lv5gold){
                bLv005.setBackgroundResource(R.drawable.world_gold);
            } else {
                bLv005.setBackgroundResource(R.drawable.lvlselection_button);
            }
            bLv005.setClickable(true);
        }
        if (lv005Cleared == 1){
            bLv006.setImageResource(R.drawable.icon_fields);
            if (lv6gold){
                bLv006.setBackgroundResource(R.drawable.world_gold);
            } else {
                bLv006.setBackgroundResource(R.drawable.lvlselection_button);
            }
            bLv006.setClickable(true);
        }
        if (lv006Cleared == 1){
            bLv007.setImageResource(R.drawable.icon_fields);
            if (lv7gold){
                bLv007.setBackgroundResource(R.drawable.world_gold);
            } else {
                bLv007.setBackgroundResource(R.drawable.lvlselection_button);
            }
            bLv007.setClickable(true);
        }
        if (lv007Cleared == 1){
            bLv008.setImageResource(R.drawable.icon_boss);
            if (lv8gold){
                bLv008.setBackgroundResource(R.drawable.world_gold);
            } else {
                bLv008.setBackgroundResource(R.drawable.lvlselection_button);
            }
            bLv008.setClickable(true);
        }
    }

    private void setLv1Stars(){
        if (lv001Score >= 15 && lv001Score < 21){
            lv1star1.setImageResource(R.drawable.star_full);
        }
        if (lv001Score >= 20 && lv001Score < 25){
            lv1star1.setImageResource(R.drawable.star_full);
            lv1star2.setImageResource(R.drawable.star_full);
        }
        if (lv001Score > 24){
            lv1star1.setImageResource(R.drawable.star_full);
            lv1star2.setImageResource(R.drawable.star_full);
            lv1star3.setImageResource(R.drawable.star_full);
            lv1gold = true;
        }
    }

    private void setLv2Stars(){
        if (lv002Score >= 15 && lv002Score < 21){
            lv2star1.setImageResource(R.drawable.star_full);
        }
        if (lv002Score >= 20 && lv002Score < 25){
            lv2star1.setImageResource(R.drawable.star_full);
            lv2star2.setImageResource(R.drawable.star_full);
        }
        if (lv002Score > 24){
            lv2star1.setImageResource(R.drawable.star_full);
            lv2star2.setImageResource(R.drawable.star_full);
            lv2star3.setImageResource(R.drawable.star_full);
            lv2gold = true;
        }
    }

    private void setLv3Stars(){
        if (lv003Score >= 15 && lv003Score < 21){
            lv3star1.setImageResource(R.drawable.star_full);
        }
        if (lv003Score >= 20 && lv003Score < 25){
            lv3star1.setImageResource(R.drawable.star_full);
            lv3star2.setImageResource(R.drawable.star_full);
        }
        if (lv003Score > 24){
            lv3star1.setImageResource(R.drawable.star_full);
            lv3star2.setImageResource(R.drawable.star_full);
            lv3star3.setImageResource(R.drawable.star_full);
            lv3gold = true;
        }
    }

    private void setLv4Stars(){
        if (lv004Score >= 15 && lv004Score < 21){
            lv4star1.setImageResource(R.drawable.star_full);
        }
        if (lv004Score >= 20 && lv004Score < 25){
            lv4star1.setImageResource(R.drawable.star_full);
            lv4star2.setImageResource(R.drawable.star_full);
        }
        if (lv004Score > 24){
            lv4star1.setImageResource(R.drawable.star_full);
            lv4star2.setImageResource(R.drawable.star_full);
            lv4star3.setImageResource(R.drawable.star_full);
            lv4gold = true;
        }
    }

    private void setLv5Stars(){
        if (lv005Score >= 15 && lv005Score < 21){
            lv5star1.setImageResource(R.drawable.star_full);
        }
        if (lv005Score >= 20 && lv005Score < 25){
            lv5star1.setImageResource(R.drawable.star_full);
            lv5star2.setImageResource(R.drawable.star_full);
        }
        if (lv005Score > 24){
            lv5star1.setImageResource(R.drawable.star_full);
            lv5star2.setImageResource(R.drawable.star_full);
            lv5star3.setImageResource(R.drawable.star_full);
            lv5gold = true;
        }
    }

    private void setLv6Stars(){
        if (lv006Score >= 15 && lv006Score < 21){
            lv6star1.setImageResource(R.drawable.star_full);
        }
        if (lv006Score >= 20 && lv006Score < 25){
            lv6star1.setImageResource(R.drawable.star_full);
            lv6star2.setImageResource(R.drawable.star_full);
        }
        if (lv006Score > 24){
            lv6star1.setImageResource(R.drawable.star_full);
            lv6star2.setImageResource(R.drawable.star_full);
            lv6star3.setImageResource(R.drawable.star_full);
            lv6gold = true;
        }
    }

    private void setLv7Stars(){
        if (lv007Score >= 15 && lv007Score < 21){
            lv7star1.setImageResource(R.drawable.star_full);
        }
        if (lv007Score >= 20 && lv007Score < 25){
            lv7star1.setImageResource(R.drawable.star_full);
            lv7star2.setImageResource(R.drawable.star_full);
        }
        if (lv007Score > 24){
            lv7star1.setImageResource(R.drawable.star_full);
            lv7star2.setImageResource(R.drawable.star_full);
            lv7star3.setImageResource(R.drawable.star_full);
            lv7gold = true;
        }
    }

    private void setLv8Stars(){
        if (lv008Score >= 15 && lv008Score < 21){
            lv8star1.setImageResource(R.drawable.star_full);
        }
        if (lv008Score >= 20 && lv008Score < 25){
            lv8star1.setImageResource(R.drawable.star_full);
            lv8star2.setImageResource(R.drawable.star_full);
        }
        if (lv008Score > 24){
            lv8star1.setImageResource(R.drawable.star_full);
            lv8star2.setImageResource(R.drawable.star_full);
            lv8star3.setImageResource(R.drawable.star_full);
            lv8gold = true;
        }
    }
}

