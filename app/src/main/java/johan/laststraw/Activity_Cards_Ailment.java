package johan.laststraw;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Johan on 2014-10-14.
 */
public class Activity_Cards_Ailment extends Activity implements AdapterView.OnItemClickListener{

    TextView title;
    AllCardsAdapter cursorAdapter;
    Cursor cursor;
    private ListView allAilmentCards;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards_list);

        title = (TextView) findViewById(R.id.tvAllCardsTitle);
        title.setText("Ailment Cards Index");

        db = new DBHandler(this);

        try {
            db.open();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        db.unlockCard001(1, 1);
        db.unlockCard001(2, 0);
        db.unlockCard001(3, 0);
        setAilmentCardsList();
        db.close();
    }

    private void setAilmentCardsList() {
        cursor = db.getAllAilmentCards();
        allAilmentCards = (ListView) findViewById(R.id.allCards);
        cursorAdapter = new AllCardsAdapter(this, cursor);
        allAilmentCards.setAdapter(cursorAdapter);
        allAilmentCards.setOnItemClickListener(this);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
