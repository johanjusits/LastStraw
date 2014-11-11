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
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import static android.graphics.Color.TRANSPARENT;

/**
 * Created by Johan on 2014-10-11.
 */
public class Activity_Profile extends Activity implements View.OnClickListener {

    DBHandler db;
    Button bSelectGender, bSave, bBack;
    TextView tvGender, tvLevelNumber, tvName;
    ImageView ivImg;
    EditText etName;
    Cursor cursor;
    ProgressBar expBar;
    String playerGender = "";
    int level, exp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvLevelNumber = (TextView) findViewById(R.id.tvLevelNumber);
        tvGender = (TextView) findViewById(R.id.tvGender);
        ivImg = (ImageView) findViewById(R.id.ivImg);
        etName = (EditText) findViewById(R.id.etName);
        expBar = (ProgressBar) findViewById(R.id.expBar);
        Drawable draw = getResources().getDrawable(R.drawable.customprogressbar);
        expBar.setProgressDrawable(draw);
        bSelectGender = (Button) findViewById(R.id.bSelectGender);
        bSave = (Button) findViewById(R.id.bSave);
        bBack = (Button) findViewById(R.id.bBack);

        bBack.setOnClickListener(this);
        bSave.setOnClickListener(this);
        bSelectGender.setOnClickListener(this);

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
            tvGender.setText(cursor.getString(cursor.getColumnIndex("gender")));
            level = cursor.getInt(cursor.getColumnIndex("level"));
            tvLevelNumber.setText(String.valueOf(level));
            expBar.setProgress(cursor.getInt(cursor.getColumnIndex("exp")));

            playerGender = cursor.getString(cursor.getColumnIndex("gender"));
            if (playerGender.equals("Male")){
                ivImg.setImageResource(R.drawable.male_face);
            } else {
                ivImg.setImageResource(R.drawable.female_face);
            }
        }
        db.close();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bBack:
                finish();
                overridePendingTransition(0, 0);
                break;
            case R.id.bSelectGender:
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
                tvGender.setText(cursor.getString(cursor.getColumnIndex("gender")));
                playerGender = cursor.getString(cursor.getColumnIndex("gender"));
                if (playerGender.equals("Male")){
                    ivImg.setImageResource(R.drawable.male_face);
                } else {
                    ivImg.setImageResource(R.drawable.female_face);
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
    public void onBackPressed() {
        finish();
        overridePendingTransition(0, 0);
    }
}
