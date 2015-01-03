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
            if (playerLevel >= 6){
                return true;
            } else {
                return false;
            }
        }
        if (worldId == 2){
            if (playerLevel >= 8){
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
            if (playerLevel > 5 && playerLevel < 8){
                xpPenalty = 1;
                return xpPenalty;
            }
            if (playerLevel > 7){
                xpPenalty = 2;
                return xpPenalty;
            }
        }
        if (worldId == 3){
            if (playerLevel > 7 && playerLevel < 10){
                xpPenalty = 1;
                return xpPenalty;
            }
            if (playerLevel > 9){
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
