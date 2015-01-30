package johan.laststraw;

import java.util.Random;

/**
 * Created by Johan on 2015-01-07.
 */
public class GameInfo {

    //For Rewind card
    public static String getObjName(int worldId){
        switch (worldId){
            case 1:
                return "wheat";
            case 2:
                return "skeletons";
            case 3:
                return "snowmen";
            case 4:
                return "chests";
            case 5:
                return "fungi";
        }
        return "";
    }

    public static int genRand(int max, int min) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static int getRandomCardOrNotNr(){
        return genRand(85, 65);
    }

    public static String getInfestMsg(int worldId){
        switch (worldId){
            case 1:
                return "Spiders infests the wheat";
            case 2:
                return "Spiders infests the skeleton";
            case 3:
                return "Spiders infests the snowman";
            case 4:
                return "Spiders infests the chest";
            case 5:
                return "Spiders infests the fungus";
        }
        return "";
    }

    public static String getInfestErrorMsg(int worldId){
        switch (worldId){
            case 1:
                return "Wheat is already infested";
            case 2:
                return "Skeleton is already infested";
            case 3:
                return "Snowman is already infested";
            case 4:
                return "Chest is already infested";
            case 5:
                return "Fungus is already infested";
        }
        return "";
    }

    public static String getTextColor(int worldId){
        switch (worldId){
            case 1:
                return "textBlack";
            case 2:
                return "textWhite";
            case 3:
                return "textBlack";
            case 4:
                return "textWhite";
            case 5:
                return "textWhite";
        }
        return "";
    }

    public static int getClearSound(int worldId){
        switch (worldId){
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
        }
        return 0;
    }

    public static String getWorldBackground(int worldId){
        switch (worldId) {
            case 1:
                return "activity_world001";
            case 2:
                return "activity_world002";
            case 3:
                return "activity_world003";
            case 4:
                return "activity_world004";
            case 5:
                return "activity_world005";
        }
        return null;
    }

    public static String getObjectImgName(int worldId){
        switch (worldId) {
            case 1:
                return "object_wheat";
            case 2:
                return "object_skeleton";
            case 3:
                return "object_snowman";
            case 4:
                return "object_chest";
            case 5:
                return "object_fungus";
        }
        return null;
    }

    public static String getObjectBrokenImgName(int worldId){
        switch (worldId) {
            case 1:
                return "object_wheatbroken";
            case 2:
                return "object_skeleton_broken";
            case 3:
                return "object_snowman_broken";
            case 4:
                return "object_chest_opened";
            case 5:
                return "object_fungus_broken";
        }
        return null;
    }

    public static String getObjectWebbedImgName(int worldId){
        switch (worldId) {
            case 1:
                return "object_wheat_webbed";
            case 2:
                return "object_skeleton_webbed";
            case 3:
                return "object_snowman_webbed";
            case 4:
                return "object_chest_webbed";
            case 5:
                return "object_fungus_webbed";
        }
        return null;
    }
}
