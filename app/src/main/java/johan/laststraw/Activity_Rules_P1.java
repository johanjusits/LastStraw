package johan.laststraw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Johan on 2014-11-11.
 */
public class Activity_Rules_P1 extends Activity implements View.OnClickListener {

    Button bNext;
    Intent changePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_p1);

        bNext = (Button) findViewById(R.id.bNext);
        bNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bNext:
                changePage = new Intent(Activity_Rules_P1.this, Activity_Rules_P2.class);
                changePage.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(changePage);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(0, 0);
    }
}

