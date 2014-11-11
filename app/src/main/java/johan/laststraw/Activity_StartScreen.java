package johan.laststraw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Activity_StartScreen extends Activity implements View.OnClickListener{

    Button profileButton, playButton, cardStoreButton, rulesButton;
    Intent play, profile, cards, rules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startscreen);

        profileButton = (Button) findViewById(R.id.Btn_Profile);
        playButton = (Button) findViewById(R.id.Btn_Play);
        cardStoreButton = (Button) findViewById(R.id.Btn_Cards);
        rulesButton = (Button) findViewById(R.id.Btn_Rules);

        profileButton.setOnClickListener(this);
        playButton.setOnClickListener(this);
        cardStoreButton.setOnClickListener(this);
        rulesButton.setOnClickListener(this);

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
                startActivity(cards);
                break;
            case R.id.Btn_Rules:
                rules = new Intent(Activity_StartScreen.this, Activity_Rules_P1.class);
                rules.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(rules);
                break;
        }
    }
}
