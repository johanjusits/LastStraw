package johan.laststraw;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

/**
 * Created by Johan on 2014-12-29.
 */
public class SoundEffects {
    static SoundPool sp = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);

    static int soundIds[] = new int[6];


    public static void setupSounds(Context context){
        soundIds[0] = sp.load(context, R.raw.object_wheat_clear, 1);
        soundIds[1] = sp.load(context, R.raw.object_skeleton_clear, 1);
        soundIds[2] = sp.load(context, R.raw.object_snowman_clear, 1);
        soundIds[3] = sp.load(context, R.raw.object_mushroom_clear, 1);
        soundIds[4] = sp.load(context, R.raw.object_box_clear, 1);
        soundIds[5] = sp.load(context, R.raw.object_barrel_clear, 1);
    }

    public static void playSound(int id){
        sp.play(soundIds[id], 1, 1, 1, 0, 1);
    }

}
