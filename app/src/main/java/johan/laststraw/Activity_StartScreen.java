package johan.laststraw;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Activity_StartScreen extends Activity implements View.OnClickListener{

    Button profileButton, playButton, cardStoreButton, rulesButton, newCardMsg;
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

        tvdblvl = (TextView) findViewById(R.id.tvDbLvl);
        tvsplvl = (TextView) findViewById(R.id.tvSharedPrefLvl);

        profileButton.setOnClickListener(this);
        playButton.setOnClickListener(this);
        cardStoreButton.setOnClickListener(this);
        rulesButton.setOnClickListener(this);

        db = new DBHandler(this);

        try {
            db.open();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        db.unlockCard(5,1);
        db.close();

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
        awardNewCard();
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
                addCard("Reinforce III", "card_obj_plus_3", 1, 1, "Brings back two objects.", 3);
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
}
