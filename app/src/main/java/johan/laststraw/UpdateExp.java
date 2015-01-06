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
        if (worldId == 3){
            if (playerLevel >= 8){
                return true;
            } else {
                return false;
            }
        }
        if (worldId == 4){
            if (playerLevel >= 10){
                return true;
            } else {
                return false;
            }
        }
        if (worldId == 5){
            if (playerLevel >= 12){
                return true;
            } else {
                return false;
            }
        }
        if (worldId == 6){
            if (playerLevel >= 16){
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
            if (playerLevel > 4){
                xpPenalty = 2;
                return xpPenalty;
            }
            if (playerLevel > 6){
                xpPenalty = 3;
                return xpPenalty;
            }
            if (playerLevel > 8){
                xpPenalty = 4;
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
            if (playerLevel > 9){
                xpPenalty = 3;
                return xpPenalty;
            }
            if (playerLevel > 11){
                xpPenalty = 4;
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
            if (playerLevel > 11){
                xpPenalty = 3;
                return xpPenalty;
            }
            if (playerLevel > 13){
                xpPenalty = 4;
                return xpPenalty;
            }
        }
        if (worldId == 4){
            if (playerLevel > 9 && playerLevel < 12){
                xpPenalty = 1;
                return xpPenalty;
            }
            if (playerLevel > 11){
                xpPenalty = 2;
                return xpPenalty;
            }
            if (playerLevel > 13){
                xpPenalty = 3;
                return xpPenalty;
            }
            if (playerLevel > 15){
                xpPenalty = 4;
                return xpPenalty;
            }
        }
        if (worldId == 5){
            if (playerLevel > 11 && playerLevel < 14){
                xpPenalty = 1;
                return xpPenalty;
            }
            if (playerLevel > 13){
                xpPenalty = 2;
                return xpPenalty;
            }
            if (playerLevel > 15){
                xpPenalty = 3;
                return xpPenalty;
            }
            if (playerLevel > 17){
                xpPenalty = 4;
                return xpPenalty;
            }
        }
        if (worldId == 6){
            if (playerLevel > 15 && playerLevel < 18){
                xpPenalty = 1;
                return xpPenalty;
            }
            if (playerLevel > 17){
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
