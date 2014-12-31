package johan.laststraw;

/**
 * Created by Johan on 2014-12-31.
 */
public class UpdateExp {

    public static boolean getXpReward(int playerLevel, int worldId){
        if (worldId == 1 && playerLevel > 2){
            return true;
        }
        if (worldId == 2 && playerLevel > 4){
            return true;
        }
        return false;
    }

    public static int getExpPenalty(int playerLevel, int worldId){
        int xpPenalty;
        if (worldId == 1){
            if (playerLevel > 2 && playerLevel < 5){
                xpPenalty = 1;
                return xpPenalty;
            }
            if (playerLevel > 4){
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
