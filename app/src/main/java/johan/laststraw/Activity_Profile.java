package johan.laststraw;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import static android.graphics.Color.TRANSPARENT;

/**
 * Created by Johan on 2014-10-11.
 */
public class Activity_Profile extends Activity implements View.OnClickListener {

    DBHandler db;
    TextView tvLevelNumber;
    ImageButton ivImg, bSave;
    EditText etName;
    Cursor cursor;
    ProgressBar expBar;
    String playerGender = "";
    String sizeName;
    String densityName;
    int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_profile);

        tvLevelNumber = (TextView) findViewById(R.id.tvLevelNumber);
        ivImg = (ImageButton) findViewById(R.id.ivImg);
        etName = (EditText) findViewById(R.id.etName);
        expBar = (ProgressBar) findViewById(R.id.expBar);
        Drawable draw = getResources().getDrawable(R.drawable.customprogressbar);
        expBar.setProgressDrawable(draw);
        bSave = (ImageButton) findViewById(R.id.bSave);

        bSave.setOnClickListener(this);
        ivImg.setOnClickListener(this);

        getScreenSize();

        db = new DBHandler(this);

        try {
            db.open();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        cursor = db.getPlayerInfo();

        if (cursor != null && cursor.moveToFirst()) {
            etName.setText(cursor.getString(cursor.getColumnIndex("name")));
            etName.setSelection(etName.getText().length());
            level = cursor.getInt(cursor.getColumnIndex("level"));
            tvLevelNumber.setText(String.valueOf(level));
            expBar.setProgress(cursor.getInt(cursor.getColumnIndex("exp")));

            playerGender = cursor.getString(cursor.getColumnIndex("gender"));
            if (playerGender.equals("Male")){
                ivImg.setImageResource(R.drawable.portrait_placeholder_boy);
            } else {
                ivImg.setImageResource(R.drawable.portrait_placeholder_girl);
            }
        }
        //db.enableAllCards();
        db.close();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivImg:
                confirmSelectGender(Activity_Profile.this);
                break;
            case R.id.bSave:
                try {
                    db.open();
                } catch (java.sql.SQLException e) {
                    e.printStackTrace();
                }
                cursor = db.getPlayerInfo();
                if (cursor != null && cursor.moveToFirst()) {
                    String newName = etName.getText().toString();
                    db.updatePlayerName(newName);
                }
                db.close();
                String message = "Info successfully updated";
                confirmSuccess(message, Activity_Profile.this);
                playerGender = cursor.getString(cursor.getColumnIndex("gender"));
                if (playerGender.equals("Male")){
                    ivImg.setImageResource(R.drawable.portrait_placeholder_boy);
                } else {
                    ivImg.setImageResource(R.drawable.portrait_placeholder_girl);
                }
                break;
        }
    }

    private void confirmSelectGender(final Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confirmdialog_gender);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));
        dialog.setCancelable(false);

        /* YES CLICKED */
        Button buttonDialogYes = (Button) dialog.findViewById(R.id.bMale);
        buttonDialogYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    db.open();
                } catch (java.sql.SQLException e) {
                    e.printStackTrace();
                }
                cursor = db.getPlayerInfo();
                if (cursor != null && cursor.moveToFirst()) {
                    db.updatePlayerGender("Male");
                }
                db.close();
                dialog.dismiss();
            }
        });

        /* NO CLICKED */
        Button buttonDialogNo = (Button) dialog.findViewById(R.id.bFemale);
        buttonDialogNo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    db.open();
                } catch (java.sql.SQLException e) {
                    e.printStackTrace();
                }
                cursor = db.getPlayerInfo();
                if (cursor != null && cursor.moveToFirst()) {
                    db.updatePlayerGender("Female");
                }
                db.close();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void confirmSuccess(String message, Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confirmdialog_success);
        if (sizeName.equals("xlarge")){
            dialog.getWindow().setLayout(700, 350);
        }
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
