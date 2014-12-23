package johan.laststraw;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
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

    Button profileButton, playButton, cardStoreButton, rulesButton, newCardMsg;
    ImageButton resetButton;
    Intent play, profile, cards, rules;
    DBHandler db;
    Cursor cursor;
    TextView tvdblvl, tvsplvl;
    int dbLvl, sharedPrefLvl;
    int lvlcleared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startscreen);

        profileButton = (Button) findViewById(R.id.Btn_Profile);
        playButton = (Button) findViewById(R.id.Btn_Play);
        cardStoreButton = (Button) findViewById(R.id.Btn_Cards);
        rulesButton = (Button) findViewById(R.id.Btn_Rules);
        newCardMsg = (Button) findViewById(R.id.newCardMsg);
        resetButton = (ImageButton) findViewById(R.id.Btn_Reset);

        tvdblvl = (TextView) findViewById(R.id.tvDbLvl);
        tvsplvl = (TextView) findViewById(R.id.tvSharedPrefLvl);

        profileButton.setOnClickListener(this);
        playButton.setOnClickListener(this);
        cardStoreButton.setOnClickListener(this);
        rulesButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);

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
                rules = new Intent(Activity_StartScreen.this, Activity_Rules_P1.class);
                rules.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(rules);
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

            tvdblvl.setText(String.valueOf(dbLvl));
            tvsplvl.setText(String.valueOf(sharedPrefLvl));
        }
        if (sharedPrefLvl < dbLvl){
            awardNewCard();
        }
        db.close();

        //CHECKS IF MINI BOSS 1 HAS BEEN BEATEN
        checkMiniBoss1();
        //CHECKS IF BOSS 1 HAS BEEN BEATEN
        checkBoss1();
    }

    private void awardNewCard() {
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 2 && sharedPrefLvl == 1){
                addCard("Reinforce II", "card_obj_plus_2", 1, 0, "Brings back two objects.", 2);
                confirmSuccess("You have unlocked the Reinforce II card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 3 && sharedPrefLvl == 2){
                addCard("Reinforce III", "card_obj_plus_3", 1, 1, "Brings back three objects.", 3);
                confirmSuccess("You have unlocked the Reinforce III card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 4 && sharedPrefLvl == 3){
                addCard("Speed Up", "card_speed_up", 3, 1, "You gain 1 more move on next turn.", 5);
                confirmSuccess("You have unlocked the Speed Up card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 5 && sharedPrefLvl == 4){
                addCard("Slow Down", "card_slowdown", 2, 1, "Reduces opponent's moves by 1 next turn.", 4);
                confirmSuccess("You have unlocked the Slow Down card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 6 && sharedPrefLvl == 5){
                addCard("Concentrate", "card_concentrate", 3, 1, "Doubles all points gained next turn.", 7);
                confirmSuccess("You have unlocked the Concentrate card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 7 && sharedPrefLvl == 6){
                addCard("Corruption", "card_corruption", 2, 2, "All moves cost one more next turn.", 12);
                confirmSuccess("You have unlocked the Corruption card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 8 && sharedPrefLvl == 7){
                addCard("Agony", "card_agony", 2, 2, "Reduces score by 3 at the start of the turn. Lasts three turns.", 16);
                confirmSuccess("You have unlocked the Agony card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 9 && sharedPrefLvl == 8){
                addCard("Steal II", "card_steal_5", 1, 2, "Steals 3-5 points from the opponent.", 8);
                confirmSuccess("You have unlocked the Steal II card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 10 && sharedPrefLvl == 9){
                addCard("Infest", "card_infest", 1, 2, "Infests the next object with spiders, making it more difficult to clear.", 10);
                confirmSuccess("You have unlocked the Infest card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 11 && sharedPrefLvl == 10){
                addCard("Protect", "card_protect", 3, 1, "Gain a temporary shield that protects against ailments. Lasts 2 turns.", 22);
                confirmSuccess("You have unlocked the Protect card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 12 && sharedPrefLvl == 11){
                addCard("Speed Up II", "card_speed_up_2", 3, 2, "Gain 2 additional moves on next turn.", 11);
                confirmSuccess("You have unlocked the Speed Up II card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 13 && sharedPrefLvl == 12){
                addCard("Steal III", "card_steal_7", 1, 3, "Steals 5-7 points from the opponent.", 9);
                confirmSuccess("You have unlocked the Steal III card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 14 && sharedPrefLvl == 13){
                addCard("Death Sentence", "card_death_sentence", 2, 2, "50% chance to reset opponent's score after 3 turns.", 19);
                confirmSuccess("You have unlocked the Death Sentence card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 15 && sharedPrefLvl == 14){
                addCard("Dispel", "card_dispel", 2, 1, "Removes all positive buffs from the opponent.", 24);
                confirmSuccess("You have unlocked the Dispel card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 16 && sharedPrefLvl == 15){
                addCard("Mimic", "card_mimic", 3, 2, "Copies the effect of the opponents last played card.", 13);
                confirmSuccess("You have unlocked the Mimic card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 17 && sharedPrefLvl == 16){
                addCard("Restore", "card_restore", 1, 2, "Brings back half of the cleared objects.", 14);
                confirmSuccess("You have unlocked the Restore card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 18 && sharedPrefLvl == 17){
                addCard("Malediction", "card_malediction", 2, 3, "Reduces score by 3/4 after four turns.", 17);
                confirmSuccess("You have unlocked the Malediction card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 19 && sharedPrefLvl == 18){
                addCard("Rewind", "card_rewind", 3, 0, "Gain another turn at the end of current turn.", 21);
                confirmSuccess("You have unlocked the Rewind card!", Activity_StartScreen.this);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 20 && sharedPrefLvl == 19){
                addCard("Hoard", "card_hoard", 3, 1, "Keep the next card you play. Lasts until a card is played.", 23);
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

    private void confirmReset(String message, final Context context) {
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
                tvsplvl.setText(String.valueOf(sharedPrefLvl));
                tvdblvl.setText("1");
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
            confirmSuccess("New have unlocked a new card slot!", Activity_StartScreen.this);
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
            addCard("Steal", "card_steal_3", 1, 1, "Steals 1-3 points from the opponent.", 6);
            confirmSuccess("You have unlocked the Steal card!", Activity_StartScreen.this);
            db.close();
        }
    }
}
