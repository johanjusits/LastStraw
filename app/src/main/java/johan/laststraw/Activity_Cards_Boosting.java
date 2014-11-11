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
public class Activity_Cards_Boosting extends Activity implements AdapterView.OnItemClickListener{

    TextView title;
    AllCardsAdapter cursorAdapter;
    Cursor cursor;
    private ListView allBoostingCards;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards_list);

        title = (TextView) findViewById(R.id.tvAllCardsTitle);
        title.setText("Boosting Cards Index");

        db = new DBHandler(this);

        try {
            db.open();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        setBoostingCardsList();
        db.close();
    }

    private void setBoostingCardsList() {
        cursor = db.getAllBoostingCards();
        allBoostingCards = (ListView) findViewById(R.id.allCards);
        cursorAdapter = new AllCardsAdapter(this, cursor);
        allBoostingCards.setAdapter(cursorAdapter);
        allBoostingCards.setOnItemClickListener(this);
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
