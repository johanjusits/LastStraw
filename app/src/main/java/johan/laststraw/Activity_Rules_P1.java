package johan.laststraw;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Johan on 2014-11-11.
 */
public class Activity_Rules_P1 extends Activity implements View.OnClickListener {

    Button bNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_p1);

        bNext = (Button) findViewById(R.id.bNext);
        bNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(0, 0);
    }
}

