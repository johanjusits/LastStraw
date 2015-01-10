package johan.laststraw;

/**
 * Created by Johan on 2015-01-07.
 */
public class GameInfo {

    public static String getInfestMsg(int worldId){
        switch (worldId){
            case 1:
                return "Spiders infests the wheat";
            case 2:
                return "Spiders infests the skeleton";
            case 3:
                return "Spiders infests the snowman";
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
        }
        return null;
    }
}
