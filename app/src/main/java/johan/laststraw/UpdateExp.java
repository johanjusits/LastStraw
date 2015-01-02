package johan.laststraw;

/**
 * Created by Johan on 2014-12-31.
 */
public class UpdateExp {

    public static boolean getXpReward(int worldId, int playerLevel){
        if (worldId == 1){
            if (playerLevel >= 3){
                return true;
            } else {
                return false;
            }
        }
        if (worldId == 2){
            if (playerLevel >= 5){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static int getExpPenalty(int worldId, int playerLevel){
        int xpPenalty;
        if (worldId == 1){
            if (playerLevel > 2 && playerLevel < 5){
                xpPenalty = 1;
                return xpPenalty;
            }
            if (playerLevel >= 5){
                xpPenalty = 2;
                return xpPenalty;
            }
        }
        if (worldId == 2){
            if (playerLevel > 4 && playerLevel < 7){
                xpPenalty = 1;
                return xpPenalty;
            }
            if (playerLevel > 6){
                xpPenalty = 2;
                return xpPenalty;
            }
        }
        return 1;
    }

    public static int getGainedXp(int finalPlayerScore, int xpPenalty){
        return finalPlayerScore / xpPenalty;
    }

}
