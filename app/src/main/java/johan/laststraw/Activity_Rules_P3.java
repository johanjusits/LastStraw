package johan.laststraw;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Johan on 2014-11-17.
 */
public class Activity_Rules_P3 extends Activity implements View.OnClickListener{

    Button bPrev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_p3);

        bPrev = (Button) findViewById(R.id.bPrev);
        bPrev.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bPrev:
                finish();
                overridePendingTransition(0, 0);
                break;
        }
    }
}
