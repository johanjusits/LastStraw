package johan.laststraw;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import static android.graphics.Color.TRANSPARENT;

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
        displayCard(Activity_Cards_Ailment.this);
    }

    private void displayCard(final Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confirmdialog_display_card);
        dialog.getWindow().setLayout(500, 450);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));

        String cardName = cursor.getString(cursor.getColumnIndex("name"));
        String desc = cursor.getString(cursor.getColumnIndex("desc"));
        String image = cursor.getString(cursor.getColumnIndex("image"));
        TextView tvName = (TextView) dialog.findViewById(R.id.tvName);
        TextView tvDesc = (TextView) dialog.findViewById(R.id.tvDesc);
        ImageView ivCard = (ImageView) dialog.findViewById(R.id.ivCard);
        tvName.setText(cardName);
        tvDesc.setText(desc);
        ivCard.setImageResource(getResources().getIdentifier(image, "drawable", getPackageName()));

        /* YES CLICKED */
        Button buttonDialogYes = (Button) dialog.findViewById(R.id.bConfirmOk);
        buttonDialogYes.setClickable(false);
        buttonDialogYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
