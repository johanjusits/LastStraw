package johan.laststraw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Johan on 2014-10-13.
 */
public class Activity_Cards extends Activity implements View.OnClickListener {

    Button bField, bAilment, bBoosting, bBack;
    Intent changeActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        bField = (Button) findViewById(R.id.bField);
        bAilment = (Button) findViewById(R.id.bAilment);
        bBoosting = (Button) findViewById(R.id.bBoosting);
        bBack = (Button) findViewById(R.id.bBackToStart);

        bField.setOnClickListener(this);
        bAilment.setOnClickListener(this);
        bBoosting.setOnClickListener(this);
        bBack.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bBackToStart:
                finish();
                overridePendingTransition(0, 0);
                break;
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
}
