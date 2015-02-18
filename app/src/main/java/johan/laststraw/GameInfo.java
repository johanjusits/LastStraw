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
                return "wheat";
            case 3:
                return "wheat";
            case 4:
                return "wheat";
            case 5:
                return "wheat";
            case 6:
                return "wheat";
        }
        return "";
    }

    public static int genRand(int max, int min) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static int getRandomCardOrNotNr(int worldId){
        switch (worldId){
            case 1:
                return genRand(80, 65);
            case 2:
                return genRand(75, 55);
            case 3:
                return genRand(70, 50);
            case 4:
                return genRand(65, 45);
            case 5:
                return genRand(60, 40);
            case 6:
                return genRand(55, 35);
        }
        return genRand(85, 65);
    }

    public static String getInfestMsg(int worldId){
        switch (worldId){
            case 1:
                return "Spiders infests the wheat";
            case 2:
                return "Spiders infests the wheat";
            case 3:
                return "Spiders infests the wheat";
            case 4:
                return "Spiders infests the wheat";
            case 5:
                return "Spiders infests the wheat";
            case 6:
                return "Spiders infests the wheat";
        }
        return "";
    }

    public static String getInfestErrorMsg(int worldId){
        switch (worldId){
            case 1:
                return "Wheat is already infested";
            case 2:
                return "Wheat is already infested";
            case 3:
                return "Wheat is already infested";
            case 4:
                return "Wheat is already infested";
            case 5:
                return "Wheat is already infested";
            case 6:
                return "Wheat is already infested";
        }
        return "";
    }

    public static String getTextColor(int worldId){
        switch (worldId){
            case 1:
                return "textBlack";
            case 2:
                return "textBlack";
            case 3:
                return "textBlack";
            case 4:
                return "textBlack";
            case 5:
                return "textBlack";
            case 6:
                return "textBlack";
        }
        return "";
    }

    public static int getClearSound(int worldId){
        switch (worldId){
            case 1:
                return 0;
            case 2:
                return 0;
            case 3:
                return 0;
            case 4:
                return 0;
            case 5:
                return 0;
            case 6:
                return 0;
        }
        return 0;
    }

    public static String getWorldBackground(int worldId){
        switch (worldId) {
            case 1:
                return "activity_world001";
            case 2:
                return "activity_world001";
            case 3:
                return "activity_world001";
            case 4:
                return "activity_world001";
            case 5:
                return "activity_world001";
            case 6:
                return "activity_world001";
        }
        return null;
    }

    public static String getObjectImgName(int worldId){
        switch (worldId) {
            case 1:
                return "object_wheat";
            case 2:
                return "object_wheat";
            case 3:
                return "object_wheat";
            case 4:
                return "object_wheat";
            case 5:
                return "object_wheat";
            case 6:
                return "object_wheat";
        }
        return null;
    }

    public static String getObjectBrokenImgName(int worldId){
        switch (worldId) {
            case 1:
                return "object_wheatbroken";
            case 2:
                return "object_wheatbroken";
            case 3:
                return "object_wheatbroken";
            case 4:
                return "object_wheatbroken";
            case 5:
                return "object_wheatbroken";
            case 6:
                return "object_wheatbroken";
        }
        return null;
    }

    public static String getObjectWebbedImgName(int worldId){
        switch (worldId) {
            case 1:
                return "object_wheat_webbed";
            case 2:
                return "object_wheat_webbed";
            case 3:
                return "object_wheat_webbed";
            case 4:
                return "object_wheat_webbed";
            case 5:
                return "object_wheat_webbed";
            case 6:
                return "object_wheat_webbed";
        }
        return null;
    }
}
