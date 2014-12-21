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
    Intent startGame, pickCards;
    TextView lv1score, lv2score, lv3score, lv4score, lv5score, lv6score, lv7score, lv8score;
    DBHandler db;
    Cursor cursor;
    int lv001Cleared, lv002Cleared, lv003Cleared, lv004Cleared, lv005Cleared, lv006Cleared,
        lv007Cleared, lv008Cleared;
    int lv001Score, lv002Score, lv003Score, lv004Score, lv005Score, lv006Score,
            lv007Score, lv008Score;

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
                editor.putString("LevelToLoad", ".Activity_W001_L001");
                editor.putString("LevelName", "Fields - Level 1");
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
                editor.putString("LevelToLoad", ".Activity_W001_L002");
                editor.putString("LevelName", "Fields - Level 2");
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
                editor.putString("LevelToLoad", ".Activity_W001_L003");
                editor.putString("LevelName", "Fields - Level 3");
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
                editor.putString("LevelToLoad", ".Activity_W001_L004");
                editor.putString("LevelName", "Fields - Level 4");
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
                editor.putString("LevelToLoad", ".Activity_W001_L005");
                editor.putString("LevelName", "Fields - Level 5");
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
                editor.putString("LevelToLoad", ".Activity_W001_L006");
                editor.putString("LevelName", "Fields - Level 6");
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
        lv2score.setText(String.valueOf(lv002Score));
        lv3score.setText(String.valueOf(lv003Score));
        lv4score.setText(String.valueOf(lv004Score));
        lv5score.setText(String.valueOf(lv005Score));
        lv6score.setText(String.valueOf(lv006Score));
        lv7score.setText(String.valueOf(lv007Score));
        lv8score.setText(String.valueOf(lv008Score));
    }

    private void unlockLevels(){
        if (lv001Cleared == 1){
            bLv002.setImageResource(R.drawable.icon_fields);
            bLv002.setBackgroundResource(R.drawable.lvlselection_button);
            bLv002.setClickable(true);
        }
        if (lv002Cleared == 1){
            bLv003.setImageResource(R.drawable.icon_fields);
            bLv003.setBackgroundResource(R.drawable.lvlselection_button);
            bLv003.setClickable(true);
        }
        if (lv003Cleared == 1){
            bLv004.setImageResource(R.drawable.icon_miniboss);
            bLv004.setBackgroundResource(R.drawable.lvlselection_button);
            bLv004.setClickable(true);
        }
        if (lv004Cleared == 1){
            bLv005.setImageResource(R.drawable.icon_fields);
            bLv005.setBackgroundResource(R.drawable.lvlselection_button);
            bLv005.setClickable(true);
        }
        if (lv005Cleared == 1){
            bLv006.setImageResource(R.drawable.icon_fields);
            bLv006.setBackgroundResource(R.drawable.lvlselection_button);
            bLv006.setClickable(true);
        }
        if (lv006Cleared == 1){
            bLv007.setImageResource(R.drawable.icon_fields);
            bLv007.setBackgroundResource(R.drawable.lvlselection_button);
            bLv007.setClickable(true);
        }
    }
}

