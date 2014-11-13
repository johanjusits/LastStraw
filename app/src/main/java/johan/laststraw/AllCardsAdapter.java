package johan.laststraw;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Johan on 2014-09-20.
 */
public class AllCardsAdapter extends CursorAdapter {

    LockedHolder viewLocked;
    UnlockedHolder viewUnlocked;
    private LayoutInflater mInflater;
    public static final int LOCKED = 0;
    public static final int UNLOCKED = 1;

    public AllCardsAdapter(Context context, Cursor cursor) {
        super(context, cursor);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        final int type;

        int viewType = this.getItemViewType(cursor);

        if (viewType == 1){
            type = UNLOCKED;
        } else {
            type = LOCKED;
        }

        if (type == LOCKED){
            viewLocked = (LockedHolder) view.getTag();
            viewLocked.nameHolder.setText(cursor.getString(cursor.getColumnIndex("name")));
            viewLocked.awardedAtHolder.setText("Awarded at level:");
            viewLocked.reqLvlHolder.setText(cursor.getString(cursor.getColumnIndex("reqlvl")));

            String imagePath = cursor.getString(cursor.getColumnIndex("image"));

            if (imagePath.equals("card_obj_plus_1")){
                Picasso.with(context).load(R.drawable.card_obj_plus_1).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_obj_plus_2")){
                Picasso.with(context).load(R.drawable.card_obj_plus_2).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_obj_plus_3")){
                Picasso.with(context).load(R.drawable.card_obj_plus_3).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_slowdown")){
                Picasso.with(context).load(R.drawable.card_slowdown).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_speed_up")){
                Picasso.with(context).load(R.drawable.card_speed_up).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }

        } else {
            viewUnlocked = (UnlockedHolder) view.getTag();
            viewUnlocked.nameHolder.setText(cursor.getString(cursor.getColumnIndex("name")));
            viewUnlocked.costHolder.setText(cursor.getString(cursor.getColumnIndex("cost")));

            String imagePath = cursor.getString(cursor.getColumnIndex("image"));

            if (imagePath.equals("card_obj_plus_1")){
                Picasso.with(context).load(R.drawable.card_obj_plus_1).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_obj_plus_2")){
                Picasso.with(context).load(R.drawable.card_obj_plus_2).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_obj_plus_3")){
                Picasso.with(context).load(R.drawable.card_obj_plus_3).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_slowdown")){
                Picasso.with(context).load(R.drawable.card_slowdown).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_speed_up")){
                Picasso.with(context).load(R.drawable.card_speed_up).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }

        }

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        viewLocked = new LockedHolder();
        viewUnlocked = new UnlockedHolder();
        final int type;

        int viewType = this.getItemViewType(cursor);

        if (viewType == 1){
            type = UNLOCKED;
        } else {
            type = LOCKED;
        }

        if (type == LOCKED){
            View lockedView;
            lockedView = mInflater.inflate(R.layout.card_list_row_disabled, parent, false);
            viewLocked.nameHolder = (TextView) lockedView.findViewById(R.id.txtTitle);
            viewLocked.imageHolder = (ImageView) lockedView.findViewById(R.id.imgThumbnail);
            viewLocked.reqLvlHolder = (TextView) lockedView.findViewById(R.id.tvLevelNr);
            viewLocked.awardedAtHolder = (TextView) lockedView.findViewById(R.id.tvAwardedAt);
            lockedView.setTag(viewLocked);

            return lockedView;
        } else {
            View unlockedView;
            unlockedView = mInflater.inflate(R.layout.card_list_row, parent, false);
            viewUnlocked.nameHolder = (TextView) unlockedView.findViewById(R.id.txtTitle);
            viewUnlocked.costHolder = (TextView) unlockedView.findViewById(R.id.tvCost);
            viewUnlocked.imageHolder = (ImageView) unlockedView.findViewById(R.id.imgThumbnail);
            unlockedView.setTag(viewUnlocked);

            return unlockedView;
        }

    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    private int getItemViewType(Cursor cursor) {
        return cursor.getInt(cursor.getColumnIndex("unlocked")) % 2;
    }

    @Override
    public int getItemViewType(int position) {
        Cursor cursor = (Cursor) getItem(position);
        return getItemViewType(cursor);
    }

    public class LockedHolder {
        public TextView nameHolder;
        public ImageView imageHolder;
        public TextView awardedAtHolder;
        public TextView reqLvlHolder;
    }

    public class UnlockedHolder {
        public TextView nameHolder;
        public TextView costHolder;
        public ImageView imageHolder;
    }

}