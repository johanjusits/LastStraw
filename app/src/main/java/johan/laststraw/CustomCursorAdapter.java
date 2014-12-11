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
public class CustomCursorAdapter extends CursorAdapter {

    ViewHolder viewHolder;
    private LayoutInflater mInflater;

    public CustomCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        viewHolder = (ViewHolder) view.getTag();

        viewHolder.nameHolder.setText(cursor.getString(cursor.getColumnIndex("name")));

        String imagePath = cursor.getString(cursor.getColumnIndex("image"));

        if (imagePath.equals("card_obj_plus_1")){
            Picasso.with(context).load(R.drawable.card_obj_plus_1).placeholder(R.drawable.card_placeholder).into(viewHolder.imageHolder);
        }
        if (imagePath.equals("card_obj_plus_2")){
            Picasso.with(context).load(R.drawable.card_obj_plus_2).placeholder(R.drawable.card_placeholder).into(viewHolder.imageHolder);
        }
        if (imagePath.equals("card_obj_plus_3")){
            Picasso.with(context).load(R.drawable.card_obj_plus_3).placeholder(R.drawable.card_placeholder).into(viewHolder.imageHolder);
        }
        if (imagePath.equals("card_slowdown")){
            Picasso.with(context).load(R.drawable.card_slowdown).placeholder(R.drawable.card_placeholder).into(viewHolder.imageHolder);
        }
        if (imagePath.equals("card_speed_up")){
            Picasso.with(context).load(R.drawable.card_speed_up).placeholder(R.drawable.card_placeholder).into(viewHolder.imageHolder);
        }
        if (imagePath.equals("card_steal_3")){
            Picasso.with(context).load(R.drawable.card_steal_3).placeholder(R.drawable.card_placeholder).into(viewHolder.imageHolder);
        }
        if (imagePath.equals("card_concentrate")){
            Picasso.with(context).load(R.drawable.card_concentrate).placeholder(R.drawable.card_placeholder).into(viewHolder.imageHolder);
        }
        if (imagePath.equals("card_steal_5")){
            Picasso.with(context).load(R.drawable.card_steal_5).placeholder(R.drawable.card_placeholder).into(viewHolder.imageHolder);
        }
        if (imagePath.equals("card_steal_7")){
            Picasso.with(context).load(R.drawable.card_steal_7).placeholder(R.drawable.card_placeholder).into(viewHolder.imageHolder);
        }
        if (imagePath.equals("card_infest")){
            Picasso.with(context).load(R.drawable.card_infest).placeholder(R.drawable.card_placeholder).into(viewHolder.imageHolder);
        }
        if (imagePath.equals("card_speed_up_2")){
            Picasso.with(context).load(R.drawable.card_speed_up_2).placeholder(R.drawable.card_placeholder).into(viewHolder.imageHolder);
        }
        if (imagePath.equals("card_corruption")){
            Picasso.with(context).load(R.drawable.card_corruption).placeholder(R.drawable.card_placeholder).into(viewHolder.imageHolder);
        }
        if (imagePath.equals("card_mimic")){
            Picasso.with(context).load(R.drawable.card_mimic).placeholder(R.drawable.card_placeholder).into(viewHolder.imageHolder);
        }
        if (imagePath.equals("card_restore")){
            Picasso.with(context).load(R.drawable.card_restore).placeholder(R.drawable.card_placeholder).into(viewHolder.imageHolder);
        }
        if (imagePath.equals("card_curse")){
            Picasso.with(context).load(R.drawable.card_curse).placeholder(R.drawable.card_placeholder).into(viewHolder.imageHolder);
        }
        if (imagePath.equals("card_agony")){
            Picasso.with(context).load(R.drawable.card_agony).placeholder(R.drawable.card_placeholder).into(viewHolder.imageHolder);
        }
        if (imagePath.equals("card_malediction")){
            Picasso.with(context).load(R.drawable.card_malediction).placeholder(R.drawable.card_placeholder).into(viewHolder.imageHolder);
        }
        if (imagePath.equals("card_demonic_prayer")){
            Picasso.with(context).load(R.drawable.card_demonic_prayer).placeholder(R.drawable.card_placeholder).into(viewHolder.imageHolder);
        }
        if (imagePath.equals("card_death_sentence")){
            Picasso.with(context).load(R.drawable.card_death_sentence).placeholder(R.drawable.card_placeholder).into(viewHolder.imageHolder);
        }
        if (imagePath.equals("card_cure")){
            Picasso.with(context).load(R.drawable.card_cure).placeholder(R.drawable.card_placeholder).into(viewHolder.imageHolder);
        }
        if (imagePath.equals("card_rewind")){
            Picasso.with(context).load(R.drawable.card_rewind).placeholder(R.drawable.card_placeholder).into(viewHolder.imageHolder);
        }
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        viewHolder = new ViewHolder();

        View view = mInflater.inflate(R.layout.card_list_row, parent, false);
        viewHolder.nameHolder = (TextView) view.findViewById(R.id.txtTitle);
        viewHolder.imageHolder = (ImageView) view.findViewById(R.id.imgThumbnail);

        view.setTag(viewHolder);

        return view;
    }

    public class ViewHolder {
        public TextView nameHolder;
        public ImageView imageHolder;
    }

}