package johan.laststraw;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Johan on 2014-09-27.
 */
public class Activity_WorldSelection extends Activity implements View.OnClickListener {

    ImageButton toolShedWorldButton;
    Intent worldSelected;
    DBHandler db;
    Cursor cursor;
    TextView world001High;
    int w001lv001score, w001lv002score, w001lv003score, w001lv004score, w001lv005score, w001lv006score, w001lv007score, w001lv008score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worldselection);

        toolShedWorldButton = (ImageButton) findViewById(R.id.imgBtnWorld001);
        toolShedWorldButton.setOnClickListener(this);

        world001High = (TextView) findViewById(R.id.world001High);

        db = new DBHandler(this);

        getWorldHighScores(1);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBtnWorld001:
                worldSelected = new Intent(Activity_WorldSelection.this, Activity_Fields_LevelSelection.class);
                worldSelected.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(worldSelected);
                finish();
                overridePendingTransition(0, 0);
                break;
        }
    }

    private void getWorldHighScores(int worldId){
        int highScores[] = new int[8];
        int i = 0;
        int totalScore = 0;

        try {
            db.open();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        cursor = db.getFieldsLvlsInfo(worldId);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    highScores[i] = cursor.getInt(cursor.getColumnIndex("lvlhighscore"));
                    totalScore = totalScore + highScores[i];
                    i++;
                } while (cursor.moveToNext());
            }
        }
        db.close();
        w001lv001score = highScores[0];
        w001lv002score = highScores[1];
        w001lv003score = highScores[2];
        w001lv004score = highScores[3];
        w001lv005score = highScores[4];
        w001lv006score = highScores[5];
        w001lv007score = highScores[6];
        w001lv008score = highScores[7];

        world001High.setText(String.valueOf(totalScore));
    }

    @Override
    public void onBackPressed() {
        this.finish();
        overridePendingTransition(0, 0);
    }
}



