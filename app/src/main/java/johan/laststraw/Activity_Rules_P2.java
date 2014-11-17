package johan.laststraw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Activity_Rules_P2 extends Activity implements View.OnClickListener {

    Button bNext, bPrev;
    Intent changePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_p2);

        bNext = (Button) findViewById(R.id.bNext);
        bPrev = (Button) findViewById(R.id.bPrev);
        bNext.setOnClickListener(this);
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
            case R.id.bNext:
                changePage = new Intent(Activity_Rules_P2.this, Activity_Rules_P3.class);
                changePage.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(changePage);
                break;
            case R.id.bPrev:
                finish();
                overridePendingTransition(0, 0);
                break;
        }
    }
}
