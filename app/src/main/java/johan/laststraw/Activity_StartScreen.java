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
                String message = "Delete all data?";
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
    }

    private void awardNewCard() {
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 2 && sharedPrefLvl == 1){
                addCard("Reinforce II", "card_obj_plus_2", 1, 0, "Brings back two objects.", 2);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 3 && sharedPrefLvl == 2){
                addCard("Reinforce III", "card_obj_plus_3", 1, 1, "Brings back three objects.", 3);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 5 && sharedPrefLvl == 4){
                addCard("Slow Down", "card_slowdown", 2, 1, "Reduces opponent's moves by 1 next turn.", 4);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 6 && sharedPrefLvl == 5){
                addCard("Speed Up", "card_speed_up", 3, 1, "You gain 1 more move on next turn.", 5);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 8 && sharedPrefLvl == 7){
                addCard("Steal", "card_steal_3", 1, 1, "Steals 1-3 points from the opponent.", 6);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 10 && sharedPrefLvl == 9){
                addCard("Concentrate", "card_concentrate", 3, 1, "Doubles points gained next turn.", 7);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 12 && sharedPrefLvl == 11){
                addCard("Steal II", "card_steal_5", 1, 2, "Steals 3-5 points from the opponent.", 8);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 15 && sharedPrefLvl == 14){
                addCard("Steal III", "card_steal_7", 1, 3, "Steals 5-7 points from the opponent.", 9);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 16 && sharedPrefLvl == 15){
                addCard("Infest", "card_infest", 2, 1, "Infests the next object with spiders, making it more difficult to clear.", 10);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 18 && sharedPrefLvl == 17){
                addCard("Speed Up II", "card_speed_up_2", 3, 2, "Gain 2 additional moves on next turn.", 11);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 20 && sharedPrefLvl == 19){
                addCard("Corruption", "card_corruption", 2, 1, "All moves cost one more next turn.", 12);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 22 && sharedPrefLvl == 21){
                addCard("Mimic", "card_mimic", 3, 2, "Copies the effect of the opponents last played card.", 13);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 24 && sharedPrefLvl == 23){
                addCard("Trap", "card_trap", 1, 1, "Traps the next object, making whoever clears it lose 3 points instead of gaining 2.", 14);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 26 && sharedPrefLvl == 25){
                addCard("Curse", "card_curse", 2, 2, "Reduces score by half after three turns.", 15);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 28 && sharedPrefLvl == 27){
                addCard("Agony", "card_agony", 2, 2, "Reduces score by 3 after each turn, last 3 turns.", 16);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 30 && sharedPrefLvl == 29){
                addCard("Malediction", "card_malediction", 2, 3, "Reduces score by 3/4 after three turns.", 17);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 32 && sharedPrefLvl == 31){
                addCard("Demonic Prayer", "card_demonic_prayer", 2, 2, "10% chance to reset opponent's score.", 18);
            }
        }
        if (dbLvl > sharedPrefLvl){
            if (dbLvl == 32 && sharedPrefLvl == 31){
                addCard("Death Sentence", "card_death_sentence", 2, 2, "50% chance to reset opponent's score after 3 turns.", 19);
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
                editor.putInt("CurrentLevel", 0);
                editor.apply();
                sharedPrefLvl = preferences.getInt("CurrentLevel", 0);
                tvsplvl.setText(String.valueOf(sharedPrefLvl));
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
}
