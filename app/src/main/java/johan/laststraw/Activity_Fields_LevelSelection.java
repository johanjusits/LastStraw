package johan.laststraw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Johan on 2014-09-27.
 */
public class Activity_Fields_LevelSelection extends Activity implements View.OnClickListener {

    Button bLv001;
    Intent startGame, pickCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fieldslvlselection);

        bLv001 = (Button) findViewById(R.id.bWorld001Lvl001);
        bLv001.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bWorld001Lvl001:
                pickCards = new Intent(Activity_Fields_LevelSelection.this, Activity_CardSelection.class);
                pickCards.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(pickCards);
                finish();
                overridePendingTransition(0, 0);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(0, 0);
    }
}

