package johan.laststraw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Johan on 2014-09-27.
 */
public class Activity_WorldSelection extends Activity implements View.OnClickListener {

    ImageButton toolShedWorldButton;
    Intent worldSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worldselection);

        toolShedWorldButton = (ImageButton) findViewById(R.id.imgBtnWorld001);
        toolShedWorldButton.setOnClickListener(this);

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

    @Override
    public void onBackPressed() {
        this.finish();
        overridePendingTransition(0, 0);
    }
}



