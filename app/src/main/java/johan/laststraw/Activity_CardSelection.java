package johan.laststraw;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import static android.graphics.Color.TRANSPARENT;

/**
 * Created by Johan on 2014-10-04.
 */
public class Activity_CardSelection extends Activity implements AdapterView.OnItemClickListener, View.OnClickListener {

    CustomCursorAdapter cursorAdapter;
    TabHost th;
    DBHandler db;
    TextView tvCardsInHNr, tvSlots;
    Button bStart, bViewHand;
    Intent startGame;
    Cursor cursor1, cursor2, cursor3, handCursor, playerCursor;
    int currentTab, cardsInHand, cardsAllowed;
    private ListView fieldCardsList, ailmentCardsList, boostingCardsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardselection);

        tvCardsInHNr = (TextView) findViewById(R.id.tvCardsInHNr);
        tvSlots = (TextView) findViewById(R.id.tvSlots);

        bStart = (Button) findViewById(R.id.bStartGame);
        bViewHand = (Button) findViewById(R.id.bViewCards);
        bStart.setOnClickListener(this);
        bViewHand.setOnClickListener(this);

        th = (TabHost) findViewById(R.id.tabhost);

        th.setup();
        TabHost.TabSpec specs = th.newTabSpec("tag1");
        specs.setContent(R.id.tab1);
        specs.setIndicator("FIELD");
        th.addTab(specs);

        specs = th.newTabSpec("tag2");
        specs.setContent(R.id.tab2);
        specs.setIndicator("AILMENT");
        th.addTab(specs);

        specs = th.newTabSpec("tag3");
        specs.setContent(R.id.tab3);
        specs.setIndicator("BOOSTING");
        th.addTab(specs);

        /* Creates a connection to the database, opens it, fetches
        all data, sets the ListView, sets the adapter to the fieldCursor,
        adds listeners and closes the database connection */
        db = new DBHandler(this);

        try {
            db.open();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        getPlayerInfo();
        setHandCursor();
        setFieldCardsList();
        setAilmentCardsList();
        setBoostingCardsList();
        db.close();

    }

    private void getPlayerInfo() {
        playerCursor = db.getPlayerInfo();
        if (playerCursor != null && playerCursor.moveToFirst()) {
            //cardsAllowed = playerCursor.getInt(playerCursor.getColumnIndex("slots"));
            cardsAllowed = 6;
            tvSlots.setText(String.valueOf(cardsAllowed));
        }
    }

    private void setHandCursor() {
        handCursor = db.getAllSelectedCards();
        cardsInHand = handCursor.getCount();
        String cards = String.valueOf(cardsInHand);
        tvCardsInHNr.setText(cards);
    }

    private void setFieldCardsList() {
        cursor1 = db.getAllOwnedFieldCards();
        fieldCardsList = (ListView) findViewById(R.id.fieldList);
        cursorAdapter = new CustomCursorAdapter(this, cursor1);
        fieldCardsList.setAdapter(cursorAdapter);
        fieldCardsList.setOnItemClickListener(this);
    }

    private void setAilmentCardsList() {
        cursor2 = db.getAllOwnedAilmentCards();
        ailmentCardsList = (ListView) findViewById(R.id.ailmentList);
        cursorAdapter = new CustomCursorAdapter(this, cursor2);
        ailmentCardsList.setAdapter(cursorAdapter);
        ailmentCardsList.setOnItemClickListener(this);
    }

    private void setBoostingCardsList() {
        cursor3 = db.getAllOwnedBoostingCards();
        boostingCardsList = (ListView) findViewById(R.id.boostingList);
        cursorAdapter = new CustomCursorAdapter(this, cursor3);
        boostingCardsList.setAdapter(cursorAdapter);
        boostingCardsList.setOnItemClickListener(this);
    }

    /* THIS METHOD CHECKS WHICH TAB IS SELECTED SO THAT THE RIGHT CURSOR IS BEING USED
     * TO ADD A CARD TO THE HAND */
    private void addCardToHand() {
        db = new DBHandler(this);
        try {
            db.open();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        currentTab = th.getCurrentTab();
        if (currentTab == 0) {
            db.addCardToHand(cursor1.getString(cursor1.getColumnIndex("name")), cursor1.getString(cursor1.getColumnIndex("image")),
                    cursor1.getInt(cursor1.getColumnIndex("type")),  cursor1.getInt(cursor1.getColumnIndex("cost")), cursor1.getString(cursor1.getColumnIndex("desc")));
            setHandCursor();
            db.close();
        }
        if (currentTab == 1) {
            db.addCardToHand(cursor2.getString(cursor2.getColumnIndex("name")), cursor2.getString(cursor2.getColumnIndex("image")),
                    cursor2.getInt(cursor2.getColumnIndex("type")), cursor2.getInt(cursor2.getColumnIndex("cost")), cursor2.getString(cursor2.getColumnIndex("desc")));
            setHandCursor();
            db.close();
        }
        if (currentTab == 2) {
            db.addCardToHand(cursor3.getString(cursor3.getColumnIndex("name")), cursor3.getString(cursor3.getColumnIndex("image")),
                    cursor3.getInt(cursor3.getColumnIndex("type")), cursor3.getInt(cursor3.getColumnIndex("cost")), cursor3.getString(cursor3.getColumnIndex("desc")));
            setHandCursor();
            db.close();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        currentTab = th.getCurrentTab();
        if (cardsInHand < cardsAllowed) {
            String message = "Use this card?";
            confirmSelectCard(message, Activity_CardSelection.this);
        } else {
            String message = "Can't add more cards.";
            confirmError(message, Activity_CardSelection.this);
        }
    }

    private void confirmSelectCard(String message, final Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confirmdialog_selectcard);
        dialog.getWindow().setLayout(550, 450);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));
        currentTab = th.getCurrentTab();

        if (currentTab == 0) {
            String cardName = cursor1.getString(cursor1.getColumnIndex("name"));
            String desc = cursor1.getString(cursor1.getColumnIndex("desc"));
            String image = cursor1.getString(cursor1.getColumnIndex("image"));
            TextView tvText = (TextView) dialog.findViewById(R.id.tvError);
            TextView tvName = (TextView) dialog.findViewById(R.id.tvName);
            TextView tvDesc = (TextView) dialog.findViewById(R.id.tvDesc);
            ImageView ivCard = (ImageView) dialog.findViewById(R.id.ivCard);
            tvName.setText(cardName);
            tvText.setText(message);
            tvDesc.setText(desc);
            ivCard.setImageResource(getResources().getIdentifier(image, "drawable", getPackageName()));
        }

        if (currentTab == 1) {
            String cardName = cursor2.getString(cursor2.getColumnIndex("name"));
            String desc = cursor2.getString(cursor2.getColumnIndex("desc"));
            String image = cursor2.getString(cursor2.getColumnIndex("image"));
            TextView tvText = (TextView) dialog.findViewById(R.id.tvError);
            TextView tvName = (TextView) dialog.findViewById(R.id.tvName);
            TextView tvDesc = (TextView) dialog.findViewById(R.id.tvDesc);
            ImageView ivCard = (ImageView) dialog.findViewById(R.id.ivCard);
            tvName.setText(cardName);
            tvText.setText(message);
            tvDesc.setText(desc);
            ivCard.setImageResource(getResources().getIdentifier(image, "drawable", getPackageName()));

        }

        if (currentTab == 2) {
            String cardName = cursor3.getString(cursor3.getColumnIndex("name"));
            String desc = cursor3.getString(cursor3.getColumnIndex("desc"));
            String image = cursor3.getString(cursor3.getColumnIndex("image"));
            TextView tvText = (TextView) dialog.findViewById(R.id.tvError);
            TextView tvName = (TextView) dialog.findViewById(R.id.tvName);
            TextView tvDesc = (TextView) dialog.findViewById(R.id.tvDesc);
            ImageView ivCard = (ImageView) dialog.findViewById(R.id.ivCard);
            tvName.setText(cardName);
            tvText.setText(message);
            tvDesc.setText(desc);
            ivCard.setImageResource(getResources().getIdentifier(image, "drawable", getPackageName()));

        }


        /* YES CLICKED */
        Button buttonDialogYes = (Button) dialog.findViewById(R.id.bConfirmOk);
        buttonDialogYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String message = "Card added to hand";
                confirmSuccess(message, Activity_CardSelection.this);
                addCardToHand();
                dialog.dismiss();
            }
        });

        /* NO CLICKED */
        Button buttonDialogNo = (Button) dialog.findViewById(R.id.bConfirmCancel);
        buttonDialogNo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void confirmError(String message, Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confirmdialog_error);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));

        TextView tvText = (TextView) dialog.findViewById(R.id.tvError);
        ImageView ivError = (ImageView) dialog.findViewById(R.id.ivError);
        tvText.setText(message);
        ivError.setImageResource(R.drawable.action_error);

        /* YES CLICKED */
        Button buttonDialogYes = (Button) dialog.findViewById(R.id.bConfirmOk);
        buttonDialogYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void confirmSuccess(String message, Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confirmdialog_success);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));

        TextView tvText = (TextView) dialog.findViewById(R.id.tvSuccess);
        ImageView ivSuccess = (ImageView) dialog.findViewById(R.id.ivSuccess);
        tvText.setText(message);
        ivSuccess.setImageResource(R.drawable.action_success);

        /* YES CLICKED */
        Button buttonDialogYes = (Button) dialog.findViewById(R.id.bConfirmOk);
        buttonDialogYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bStartGame:
                startGame = new Intent(Activity_CardSelection.this, Activity_World001_Lv001.class);
                startGame.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(startGame);
                finish();
                break;
            case R.id.bViewCards:
                startGame = new Intent(Activity_CardSelection.this, Activity_ViewHand.class);
                startGame.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(startGame);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setHandCursor();
    }
}
