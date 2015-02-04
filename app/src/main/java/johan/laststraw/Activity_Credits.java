package johan.laststraw;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Johan on 2015-02-04.
 */
public class Activity_Credits extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(0, 0);
    }
}
