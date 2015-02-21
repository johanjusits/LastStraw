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
public class Activity_Cards_Boosting extends Activity implements AdapterView.OnItemClickListener{

    TextView title;
    AllCardsAdapter cursorAdapter;
    Cursor cursor, cursor2;
    private ListView allBoostingCards;
    DBHandler db;
    int playerKeys;

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
        cursor2 = db.getPlayerInfo();
        if (cursor2 != null && cursor2.moveToFirst()){
            playerKeys = cursor2.getInt(cursor2.getColumnIndex("keys"));
        }
        allBoostingCards = (ListView) findViewById(R.id.allCards);
        cursorAdapter = new AllCardsAdapter(this, cursor);
        allBoostingCards.setAdapter(cursorAdapter);
        allBoostingCards.setOnItemClickListener(this);
        allBoostingCards.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                //CHECK IF CARD ALREADY IS UNLOCKED
                int unlockCheck = cursor.getInt(cursor.getColumnIndex("unlocked"));
                int cardCostCheck = cursor.getInt(cursor.getColumnIndex("keycost"));
                if (unlockCheck == 1){
                    unlockError("Card is already unlocked.", Activity_Cards_Boosting.this);
                } else if (cardCostCheck == 0) {
                    unlockError("This card is not unlockable.", Activity_Cards_Boosting.this);
                } else {
                    unlockCard(Activity_Cards_Boosting.this);
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        displayCard(Activity_Cards_Boosting.this);
    }

    private void unlockCard(final Context context){
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confirmdialog_unlock_card);
        final int cardId = cursor.getInt(cursor.getColumnIndex("_id"));
        final int cardType = cursor.getInt(cursor.getColumnIndex("type"));
        final int cardCost = cursor.getInt(cursor.getColumnIndex("cost"));
        final int cardKeyCost = cursor.getInt(cursor.getColumnIndex("keycost"));
        final String cardName = cursor.getString(cursor.getColumnIndex("name"));
        final String cardImage = cursor.getString(cursor.getColumnIndex("image"));
        final String cardDesc = cursor.getString(cursor.getColumnIndex("desc"));
        TextView tvMsg = (TextView) dialog.findViewById(R.id.tvMsg);
        tvMsg.setText("Unlock this card for " + cardKeyCost + " key(s)?");
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));

        /* YES CLICKED */
        Button buttonDialogYes = (Button) dialog.findViewById(R.id.bConfirmOk);
        buttonDialogYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(playerKeys >= cardKeyCost){
                    try {
                        db.open();
                    } catch (java.sql.SQLException e) {
                        e.printStackTrace();
                    }
                    int keysRemaining = playerKeys - cardKeyCost;
                    db.updatePlayerKeys(keysRemaining);
                    db.unlockCard(cardId, 1);
                    db.addOwnedCard(cardName, cardImage, cardType, cardCost, cardDesc);
                    db.close();
                    unlockSuccess("Card unlocked!", Activity_Cards_Boosting.this);
                    setBoostingCardsList();
                } else {
                    unlockError("You need more keys.", Activity_Cards_Boosting.this);
                }
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

    private void unlockError(String message, Context context) {
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

    private void unlockSuccess(String message, Context context) {
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

    private void displayCard(final Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confirmdialog_display_card);
        String density = DeviceDensity.getDensityName(this);
        String size = DeviceDensity.getSizeName(this);
        if (density.equals("xxhdpi")){
            dialog.getWindow().setLayout(1000,900);
        } else if (density.equals("hdpi")) {
            dialog.getWindow().setLayout(500, 450);
        }
        if (size.equals("xlarge")) {
            dialog.getWindow().setLayout(600, 500);
        }
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
