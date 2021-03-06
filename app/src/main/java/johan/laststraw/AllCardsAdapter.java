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
            viewLocked.awardedAtHolder.setText("Keys Cost:");
            if (cursor.getString(cursor.getColumnIndex("keycost")).equals("0")){
                viewLocked.reqLvlHolder.setText("??");
            } else {
                viewLocked.reqLvlHolder.setText(cursor.getString(cursor.getColumnIndex("keycost")));
            }

            String imagePath = cursor.getString(cursor.getColumnIndex("image"));

            if (imagePath.equals("card_obj_plus_3")){
                Picasso.with(context).load(R.drawable.card_obj_plus_3).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_slowdown")){
                Picasso.with(context).load(R.drawable.card_slowdown).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_speed_up")){
                Picasso.with(context).load(R.drawable.card_speed_up).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_leech")){
                Picasso.with(context).load(R.drawable.card_leech).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_concentrate")){
                Picasso.with(context).load(R.drawable.card_concentrate).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_leech_2")){
                Picasso.with(context).load(R.drawable.card_leech_2).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_leech_3")){
                Picasso.with(context).load(R.drawable.card_leech_3).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_infest")){
                Picasso.with(context).load(R.drawable.card_infest).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_speed_up_2")){
                Picasso.with(context).load(R.drawable.card_speed_up_2).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_corruption")){
                Picasso.with(context).load(R.drawable.card_corruption).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_mimic")){
                Picasso.with(context).load(R.drawable.card_mimic).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_restore")){
                Picasso.with(context).load(R.drawable.card_restore).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_curse")){
                Picasso.with(context).load(R.drawable.card_curse).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_agony")){
                Picasso.with(context).load(R.drawable.card_agony).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_malediction")){
                Picasso.with(context).load(R.drawable.card_malediction).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_demonic_prayer")){
                Picasso.with(context).load(R.drawable.card_demonic_prayer).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_death_sentence")){
                Picasso.with(context).load(R.drawable.card_death_sentence).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_cure")){
                Picasso.with(context).load(R.drawable.card_cure).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_rewind")){
                Picasso.with(context).load(R.drawable.card_rewind).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_protect")){
                Picasso.with(context).load(R.drawable.card_protect).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_hoard")){
                Picasso.with(context).load(R.drawable.card_hoard).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_dispel")){
                Picasso.with(context).load(R.drawable.card_dispel).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_obj_plus_5")){
                Picasso.with(context).load(R.drawable.card_obj_plus_5).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_blind")){
                Picasso.with(context).load(R.drawable.card_blind).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_charge")){
                Picasso.with(context).load(R.drawable.card_charge).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_salvage")){
                Picasso.with(context).load(R.drawable.card_salvage).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_silence")){
                Picasso.with(context).load(R.drawable.card_silence).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_take_aim")){
                Picasso.with(context).load(R.drawable.card_take_aim).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_confuse")){
                Picasso.with(context).load(R.drawable.card_confuse).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }
            if (imagePath.equals("card_precision")){
                Picasso.with(context).load(R.drawable.card_precision).placeholder(R.drawable.card_placeholder).into(viewLocked.imageHolder);
            }

        } else {
            viewUnlocked = (UnlockedHolder) view.getTag();
            viewUnlocked.nameHolder.setText(cursor.getString(cursor.getColumnIndex("name")));

            String imagePath = cursor.getString(cursor.getColumnIndex("image"));

            if (imagePath.equals("card_obj_plus_3")){
                Picasso.with(context).load(R.drawable.card_obj_plus_3).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_slowdown")){
                Picasso.with(context).load(R.drawable.card_slowdown).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_speed_up")){
                Picasso.with(context).load(R.drawable.card_speed_up).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_leech")){
                Picasso.with(context).load(R.drawable.card_leech).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_concentrate")){
                Picasso.with(context).load(R.drawable.card_concentrate).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_leech_2")){
                Picasso.with(context).load(R.drawable.card_leech_2).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_leech_3")){
                Picasso.with(context).load(R.drawable.card_leech_3).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_infest")){
                Picasso.with(context).load(R.drawable.card_infest).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_speed_up_2")){
                Picasso.with(context).load(R.drawable.card_speed_up_2).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_corruption")){
                Picasso.with(context).load(R.drawable.card_corruption).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_mimic")){
                Picasso.with(context).load(R.drawable.card_mimic).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_restore")){
                Picasso.with(context).load(R.drawable.card_restore).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_curse")){
                Picasso.with(context).load(R.drawable.card_curse).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_agony")){
                Picasso.with(context).load(R.drawable.card_agony).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_malediction")){
                Picasso.with(context).load(R.drawable.card_malediction).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_demonic_prayer")){
                Picasso.with(context).load(R.drawable.card_demonic_prayer).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_death_sentence")){
                Picasso.with(context).load(R.drawable.card_death_sentence).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_cure")){
                Picasso.with(context).load(R.drawable.card_cure).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_rewind")){
                Picasso.with(context).load(R.drawable.card_rewind).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_protect")){
                Picasso.with(context).load(R.drawable.card_protect).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_hoard")){
                Picasso.with(context).load(R.drawable.card_hoard).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_dispel")){
                Picasso.with(context).load(R.drawable.card_dispel).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_obj_plus_5")){
                Picasso.with(context).load(R.drawable.card_obj_plus_5).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_blind")){
                Picasso.with(context).load(R.drawable.card_blind).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_charge")){
                Picasso.with(context).load(R.drawable.card_charge).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_salvage")){
                Picasso.with(context).load(R.drawable.card_salvage).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_silence")){
                Picasso.with(context).load(R.drawable.card_silence).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_take_aim")){
                Picasso.with(context).load(R.drawable.card_take_aim).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_confuse")){
                Picasso.with(context).load(R.drawable.card_confuse).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
            }
            if (imagePath.equals("card_precision")){
                Picasso.with(context).load(R.drawable.card_precision).placeholder(R.drawable.card_placeholder).into(viewUnlocked.imageHolder);
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
        public ImageView imageHolder;
    }

}