package johan.laststraw;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import static android.graphics.Color.TRANSPARENT;


public class Activity_StartScreen extends Activity implements View.OnClickListener{

    Button playButton;
    ImageButton resetButton, profileButton, rulesButton, cardStoreButton, newCardMsg, bcredits;
    Intent play, profile, cards, tutorial, credits;
    DBHandler db;
    Cursor cursor;
    int dbLvl, sharedPrefLvl;
    int lvlcleared;
    String sizeName;
    String densityName;
    TextView tvAccountScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startscreen);

        profileButton = (ImageButton) findViewById(R.id.Btn_Profile);
        playButton = (Button) findViewById(R.id.Btn_Play);
        cardStoreButton = (ImageButton) findViewById(R.id.Btn_Cards);
        rulesButton = (ImageButton) findViewById(R.id.Btn_Rules);
        newCardMsg = (ImageButton) findViewById(R.id.newCardMsg);
        tvAccountScore = (TextView) findViewById(R.id.tvAccScore);
        resetButton = (ImageButton) findViewById(R.id.Btn_Reset);
        bcredits = (ImageButton) findViewById(R.id.Btn_Credits);

        profileButton.setOnClickListener(this);
        playButton.setOnClickListener(this);
        cardStoreButton.setOnClickListener(this);
        rulesButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);
        bcredits.setOnClickListener(this);

        getScreenSize();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Btn_Play:
                play = new Intent(Activity_StartScreen.this, Activity_WorldSelection.class);
                play.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(play);
                break;
            case R.id.Btn_Profile:
                profile = new Intent(Activity_StartScreen.this, Activity_Profile.class);
                profile.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(profile);
                break;
            case R.id.Btn_Cards:
                cards = new Intent(Activity_StartScreen.this, Activity_Cards.class);
                cards.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                newCardMsg.setVisibility(View.INVISIBLE);
                startActivity(cards);
                break;
            case R.id.Btn_Rules:
                String msg = "Launch Tutorial?";
                confirmTutorialLaunch(msg, Activity_StartScreen.this);
                break;
            case R.id.Btn_Credits:
                String msg2 = "Launch Credits?";
                confirmCreditsLaunch(msg2, Activity_StartScreen.this);
                break;
            case R.id.Btn_Reset:
                String message = "Reset all data? \nWARNING! \nThis is irreversible!";
                confirmReset(message, Activity_StartScreen.this);
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
        cursor = db.getPlayerInfo();
        if (cursor != null && cursor.moveToFirst()) {
            dbLvl = cursor.getInt(cursor.getColumnIndex("level"));
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            sharedPrefLvl = preferences.getInt("CurrentLevel", 0);
        }
        if (sharedPrefLvl < dbLvl){
            awardNewCard();
        }
        db.close();

        //CHECKS IF MINI BOSS 1 HAS BEEN BEATEN
        checkMiniBoss1();
        //CHECKS IF BOSS 1 HAS BEEN BEATEN
        checkBoss1();
        //CHECKS IF MINI BOSS 2 HAS BEEN BEATEN
        checkMiniBoss2();
        //CHECKS IF BOSS 2 HAS BEEN BEATEN
        checkBoss2();
        //CHECKS IF MINI BOSS 3 HAS BEEN BEATEN
        checkMiniBoss3();
        //CHECKS IF BOSS 3 HAS BEEN BEATEN
        checkBoss3();
        //CHECKS IF MINI BOSS 4 HAS BEEN BEATEN
        checkMiniBoss4();
        //CHECKS IF MINI BOSS 5 HAS BEEN BEATEN
        checkMiniBoss5();

        updateAccountScore();
    }

    private void awardNewCard() {
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 2 && sharedPrefLvl == 1){
                addCard("Reinforce III", "card_obj_plus_3", 1, 0, "Brings back three objects.", 1);
                confirmSuccess("You have unlocked the Reinforce III card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 4 && sharedPrefLvl == 3){
                addCard("Speed Up", "card_speed_up", 3, 0, "Gain 1 additional moves on next turn.", 3);
                confirmSuccess("You have unlocked the Speed Up card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 5 && sharedPrefLvl == 4){
                addCard("Slow Down", "card_slowdown", 2, 1, "Reduces opponent's moves by 1 next turn.", 2);
                confirmSuccess("You have unlocked the Slow Down card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 6 && sharedPrefLvl == 5){
                addCard("Concentrate", "card_concentrate", 3, 1, "Doubles all points gained next turn.", 5);
                confirmSuccess("You have unlocked the Concentrate card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 7 && sharedPrefLvl == 6){
                addCard("Corruption", "card_corruption", 2, 2, "All moves cost one more next turn.", 10);
                confirmSuccess("You have unlocked the Corruption card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 8 && sharedPrefLvl == 7){
                addCard("Agony", "card_agony", 2, 2, "Reduces score by 3 at the start of the turn. Lasts three turns.", 14);
                confirmSuccess("You have unlocked the Agony card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 9 && sharedPrefLvl == 8){
                addCard("Leech II", "card_leech_2", 1, 2, "Drains 3-5 points from the opponent.", 6);
                confirmSuccess("You have unlocked the Leech II card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 10 && sharedPrefLvl == 9){
                addCard("Infest", "card_infest", 1, 2, "Infests the next object with spiders, making it more difficult to clear.", 8);
                confirmSuccess("You have unlocked the Infest card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 11 && sharedPrefLvl == 10){
                addCard("Protect", "card_protect", 3, 1, "Gain a temporary shield that protects against ailments. Lasts 2 turns.", 20);
                confirmSuccess("You have unlocked the Protect card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 12 && sharedPrefLvl == 11){
                addCard("Speed Up II", "card_speed_up_2", 3, 2, "Gain 2 additional moves on next turn.", 9);
                confirmSuccess("You have unlocked the Speed Up II card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 13 && sharedPrefLvl == 12){
                addCard("Leech III", "card_leech_3", 1, 3, "Drains 5-7 points from the opponent.", 7);
                confirmSuccess("You have unlocked the Leech III card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 14 && sharedPrefLvl == 13){
                addCard("Death Sentence", "card_death_sentence", 2, 2, "50% chance to reset opponent's score after 3 turns.", 17);
                confirmSuccess("You have unlocked the Death Sentence card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 15 && sharedPrefLvl == 14){
                addCard("Dispel", "card_dispel", 2, 1, "Removes all positive buffs from the opponent.", 22);
                confirmSuccess("You have unlocked the Dispel card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 16 && sharedPrefLvl == 15){
                addCard("Mimic", "card_mimic", 3, 2, "Copies the effect of the opponents last played card.", 11);
                confirmSuccess("You have unlocked the Mimic card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 17 && sharedPrefLvl == 16){
                addCard("Restore", "card_restore", 1, 2, "Brings back half of the cleared objects.", 12);
                confirmSuccess("You have unlocked the Restore card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 18 && sharedPrefLvl == 17){
                addCard("Malediction", "card_malediction", 2, 3, "Reduces score by 3/4 after four turns.", 15);
                confirmSuccess("You have unlocked the Malediction card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 19 && sharedPrefLvl == 18){
                addCard("Rewind", "card_rewind", 3, 0, "Gain another turn at the end of current turn.", 19);
                confirmSuccess("You have unlocked the Rewind card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 20 && sharedPrefLvl == 19){
                addCard("Hoard", "card_hoard", 3, 1, "Keep the next card you play. Lasts until a card is played.", 21);
                confirmSuccess("You have unlocked the Hoard card!", Activity_StartScreen.this);
            }
        }

    }

    /* METHOD TO ADD A NEW CARD TO OWNED CARDS DB */
    private void addCard(String cardName, String cardImg, int cardType, int cardCost, String cardDesc, int unlockCardId){
        newCardMsg.setVisibility(View.VISIBLE);
        db.addOwnedCard(cardName, cardImg, cardType, cardCost, cardDesc);
        db.unlockCard(unlockCardId, 1);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("CurrentLevel", dbLvl);
        editor.putBoolean("NewCard", true);
        editor.apply();
    }

    private void confirmTutorialLaunch(String message, final Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confirmdialog_removeall);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));

        TextView tvText = (TextView) dialog.findViewById(R.id.tvError);
        tvText.setText(message);

        /* YES CLICKED */
        Button buttonDialogYes = (Button) dialog.findViewById(R.id.bConfirmOk);
        buttonDialogYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tutorial = new Intent(Activity_StartScreen.this, Activity_Tutorial.class);
                tutorial.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(tutorial);
                dialog.dismiss();
            }
        });

        /* NO CLICKED */
        Button buttonDialogNo = (Button) dialog.findViewById(R.id.bConfirmCancel);
        buttonDialogNo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void confirmCreditsLaunch(String message, final Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confirmdialog_removeall);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));

        TextView tvText = (TextView) dialog.findViewById(R.id.tvError);
        tvText.setText(message);

        /* YES CLICKED */
        Button buttonDialogYes = (Button) dialog.findViewById(R.id.bConfirmOk);
        buttonDialogYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                credits = new Intent(Activity_StartScreen.this, Activity_Credits.class);
                credits.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(credits);
                dialog.dismiss();
            }
        });

        /* NO CLICKED */
        Button buttonDialogNo = (Button) dialog.findViewById(R.id.bConfirmCancel);
        buttonDialogNo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void confirmReset(String message, final Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confirmdialog_removeall);
        if (sizeName.equals("xlarge")){
            dialog.getWindow().setLayout(600, 350);
        }
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));

        TextView tvText = (TextView) dialog.findViewById(R.id.tvError);
        tvText.setText(message);

        /* YES CLICKED */
        Button buttonDialogYes = (Button) dialog.findViewById(R.id.bConfirmOk);
        buttonDialogYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String message = "Data successfully reset";
                try {
                    db.open();
                } catch (java.sql.SQLException e) {
                    e.printStackTrace();
                }
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();
                sharedPrefLvl = preferences.getInt("CurrentLevel", 1);
                db.reset();
                db.close();
                confirmSuccess(message, Activity_StartScreen.this);
                dialog.dismiss();
            }
        });

        /* NO CLICKED */
        Button buttonDialogNo = (Button) dialog.findViewById(R.id.bConfirmCancel);
        buttonDialogNo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void confirmSuccess(String message, Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confirmdialog_success);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));

        TextView tvText = (TextView) dialog.findViewById(R.id.tvSuccess);
        ImageView ivSuccess = (ImageView) dialog.findViewById(R.id.ivSuccess);
        tvText.setText(message);
        ivSuccess.setImageResource(R.drawable.action_success);

        /* YES CLICKED */
        Button buttonDialogYes = (Button) dialog.findViewById(R.id.bConfirmOk);
        buttonDialogYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private int getLevelInfo(int id){
        try {
            db.open();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        cursor = db.getLvlInfo(id);
        if (cursor != null && cursor.moveToFirst()) {
            lvlcleared = cursor.getInt(cursor.getColumnIndex("lvlcleared"));
        }
        db.close();
        return lvlcleared;
    }

    private void checkMiniBoss1(){
        int checkMiniBoss1 = getLevelInfo(4);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean player2ndSlotAwarded = preferences.getBoolean("player2ndSlotAwarded", false);
        if (checkMiniBoss1 == 1 && !player2ndSlotAwarded){
            try {
                db.open();
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
            db.updatePlayerSlots(2);
            preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("player2ndSlotAwarded", true);
            editor.apply();
            confirmSuccess("You have unlocked a new card slot!", Activity_StartScreen.this);
            db.close();
        }
    }

    private void checkMiniBoss2(){
        int checkMiniBoss1 = getLevelInfo(12);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean player3rdSlotAwarded = preferences.getBoolean("player3rdSlotAwarded", false);
        if (checkMiniBoss1 == 1 && !player3rdSlotAwarded){
            try {
                db.open();
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
            db.updatePlayerSlots(3);
            preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("player3rdSlotAwarded", true);
            editor.apply();
            confirmSuccess("You have unlocked a new card slot!", Activity_StartScreen.this);
            db.close();
        }
    }

    private void checkMiniBoss3(){
        int checkMiniBoss1 = getLevelInfo(20);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean player4thSlotAwarded = preferences.getBoolean("player4thSlotAwarded", false);
        if (checkMiniBoss1 == 1 && !player4thSlotAwarded){
            try {
                db.open();
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
            db.updatePlayerSlots(4);
            preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("player4thSlotAwarded", true);
            editor.apply();
            confirmSuccess("You have unlocked a new card slot!", Activity_StartScreen.this);
            db.close();
        }
    }

    private void checkMiniBoss4(){
        int checkMiniBoss1 = getLevelInfo(28);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean player5thSlotAwarded = preferences.getBoolean("player5thSlotAwarded", false);
        if (checkMiniBoss1 == 1 && !player5thSlotAwarded){
            try {
                db.open();
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
            db.updatePlayerSlots(5);
            preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("player5thSlotAwarded", true);
            editor.apply();
            confirmSuccess("You have unlocked a new card slot!", Activity_StartScreen.this);
            db.close();
        }
    }

    private void checkMiniBoss5(){
        int checkMiniBoss1 = getLevelInfo(36);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean player6thSlotAwarded = preferences.getBoolean("player6thSlotAwarded", false);
        if (checkMiniBoss1 == 1 && !player6thSlotAwarded){
            try {
                db.open();
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
            db.updatePlayerSlots(6);
            preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("player6thSlotAwarded", true);
            editor.apply();
            confirmSuccess("You have unlocked the last card slot!", Activity_StartScreen.this);
            db.close();
        }
    }

    private void checkBoss1(){
        int checkBoss1 = getLevelInfo(8);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean stealCardAwarded = preferences.getBoolean("stealCardAwarded", false);
        if (checkBoss1 == 1 && !stealCardAwarded){
            try {
                db.open();
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
            preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("stealCardAwarded", true);
            editor.apply();
            addCard("Leech", "card_leech", 1, 1, "Drains 1-3 points from the opponent.", 4);
            confirmSuccess("You have unlocked the Leech card!", Activity_StartScreen.this);
            db.close();
        }
    }

    private void checkBoss2(){
        int checkBoss2 = getLevelInfo(16);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean curseCardAwarded = preferences.getBoolean("curseCardAwarded", false);
        if (checkBoss2 == 1 && !curseCardAwarded){
            try {
                db.open();
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
            preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("curseCardAwarded", true);
            editor.apply();
            addCard("Curse", "card_curse", 2, 2, "Reduces score by half after three turns.", 13);
            confirmSuccess("You have unlocked the Curse card!", Activity_StartScreen.this);
            db.close();
        }
    }

    private void checkBoss3(){
        int checkBoss2 = getLevelInfo(24);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean cureCardAwarded = preferences.getBoolean("cureCardAwarded", false);
        if (checkBoss2 == 1 && !cureCardAwarded){
            try {
                db.open();
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
            preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("cureCardAwarded", true);
            editor.apply();
            addCard("Cure", "card_cure", 3, 1, "Removes all ailments from yourself.", 18);
            confirmSuccess("You have unlocked the Cure card!", Activity_StartScreen.this);
            db.close();
        }
    }

    private void getScreenSize() {
        sizeName = DeviceDensity.getSizeName(this);
        densityName = DeviceDensity.getDensityName(this);
        System.out.println("Screen size:" + sizeName);
        System.out.println("Screen dpi:" + densityName);
    }

    private void updateAccountScore(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        int accountScore = preferences.getInt("AccountScore", 0);
        tvAccountScore.setText(String.valueOf(accountScore));
    }
}
