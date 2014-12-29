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
 * Created by Johan on 2014-10-06.
 */
public class Activity_ViewHand extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {

    CustomCursorAdapter cursorAdapter;
    Button bBack, bEmptyHand;
    DBHandler db;
    Cursor cursor;
    int totalCardsInHand = 0;
    private ListView handList;
    String sizeName;
    String densityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = new DBHandler(this);

        setContentView(R.layout.activity_viewhand);

        bBack = (Button) findViewById(R.id.bGoBack);
        bEmptyHand = (Button) findViewById(R.id.bEmptyHand);
        bBack.setOnClickListener(this);
        bEmptyHand.setOnClickListener(this);

        getScreenSize();

        /* Creates a connection to the database, opens it, fetches
        all data, sets the ListView, sets the adapter to the fieldCursor,
        adds listeners and closes the database connection */
        setHandList();

    }

    private void setHandList() {
        try {
            db.open();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        cursor = db.getAllSelectedCards();
        handList = (ListView) findViewById(R.id.handList);
        cursorAdapter = new CustomCursorAdapter(this, cursor);
        handList.setAdapter(cursorAdapter);
        handList.setOnItemClickListener(this);
        totalCardsInHand = cursor.getCount();
        db.close();
    }

    private void updateHandList() {
        try {
            db.open();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        cursor = db.getAllSelectedCards();
        cursorAdapter.swapCursor(cursor);
        cursorAdapter.notifyDataSetChanged();
        totalCardsInHand = cursor.getCount();
        db.close();
    }

    private void deleteCard() {
        try {
            db.open();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        db.deleteRowSelectedCards(cursor.getString(cursor.getColumnIndex("_id")));
        db.close();
    }

    private void emptyHand() {
        try {
            db.open();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        db.deleteAllSelectedCards();
        db.close();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bGoBack:
                finish();
                overridePendingTransition(0, 0);
                break;
            case R.id.bEmptyHand:
                if (totalCardsInHand != 0) {
                    String message = "Remove all cards?";
                    confirmEmptyHand(message, Activity_ViewHand.this);
                    break;
                } else {
                    String message = "Your hand is empty";
                    confirmError(message, Activity_ViewHand.this);
                    break;
                }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String message = "Remove this card?";
        confirmRemoveCard(message, Activity_ViewHand.this);
    }

    private void confirmRemoveCard(String message, Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confirmdialog_removehandcard);
        if (sizeName.equals("xlarge")){
            dialog.getWindow().setLayout(650, 275);
        }
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));

        String cardName = cursor.getString(cursor.getColumnIndex("name"));

        TextView tvText = (TextView) dialog.findViewById(R.id.tvError);
        TextView tvName = (TextView) dialog.findViewById(R.id.tvRemoveCardName);
        tvName.setText(cardName);
        tvText.setText(message);

        /* YES CLICKED */
        Button buttonDialogYes = (Button) dialog.findViewById(R.id.bConfirmOk);
        buttonDialogYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String message = "Card removed";
                confirmSuccess(message, Activity_ViewHand.this);
                deleteCard();
                updateHandList();
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

    private void confirmEmptyHand(String message, Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confirmdialog_removeall);
        if (sizeName.equals("xlarge")){
            dialog.getWindow().setLayout(600, 225);
        }
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));

        TextView tvText = (TextView) dialog.findViewById(R.id.tvError);
        tvText.setText(message);

        /* YES CLICKED */
        Button buttonDialogYes = (Button) dialog.findViewById(R.id.bConfirmOk);
        buttonDialogYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String message = "All cards removed";
                confirmSuccess(message, Activity_ViewHand.this);
                emptyHand();
                updateHandList();
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

    private void getScreenSize() {
        sizeName = DeviceDensity.getSizeName(this);
        densityName = DeviceDensity.getDensityName(this);
        System.out.println("Screen size:" + sizeName);
        System.out.println("Screen dpi:" + densityName);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(0, 0);
    }
}
