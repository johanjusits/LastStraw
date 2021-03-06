package johan.laststraw;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Johan on 2014-10-13.
 */
public class Activity_Cards extends Activity implements View.OnClickListener {

    ImageButton bField, bAilment, bBoosting;
    TextView newCard;
    Intent changeActivity;
    Boolean isThereANewCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        bField = (ImageButton) findViewById(R.id.bField);
        bAilment = (ImageButton) findViewById(R.id.bAilment);
        bBoosting = (ImageButton) findViewById(R.id.bBoosting);
        newCard = (TextView) findViewById(R.id.tvNewCardTxt);

        bField.setOnClickListener(this);
        bAilment.setOnClickListener(this);
        bBoosting.setOnClickListener(this);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        isThereANewCard = preferences.getBoolean("NewCard", false);

    }

    @Override
    public void onBackPressed() {
        if (isThereANewCard == true){
            isThereANewCard = false;
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("NewCard", false);
            editor.apply();
            newCard.setVisibility(View.INVISIBLE);
        }
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bBoosting:
                changeActivity = new Intent(Activity_Cards.this, Activity_Cards_Boosting.class);
                changeActivity.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(changeActivity);
                break;
            case R.id.bField:
                changeActivity = new Intent(Activity_Cards.this, Activity_Cards_Field.class);
                changeActivity.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(changeActivity);
                break;
            case R.id.bAilment:
                changeActivity = new Intent(Activity_Cards.this, Activity_Cards_Ailment.class);
                changeActivity.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(changeActivity);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isThereANewCard == true){
            newCard.setVisibility(View.VISIBLE);
        }
    }
}
