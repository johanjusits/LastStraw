package johan.laststraw;

/**
 * Created by Johan on 2015-01-07.
 */
public class EnemyInfo {
    public static int getEnemyLevel(int levelId){
        switch (levelId){
            case 1:
                return 1;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 2;
            case 5:
                return 3;
            case 6:
                return 3;
            case 7:
                return 4;
            case 8:
                return 4;
            case 9:
                return 5;
            case 10:
                return 5;
            case 11:
                return 6;
            case 12:
                return 6;
            case 13:
                return 7;
            case 14:
                return 7;
            case 15:
                return 8;
            case 16:
                return 8;
            case 17:
                return 9;
            case 18:
                return 9;
            case 19:
                return 10;
            case 20:
                return 10;
            case 21:
                return 11;
            case 22:
                return 11;
            case 23:
                return 12;
            case 24:
                return 12;
        }
        return 0;
    }
    public static String getPortraitImgName(int worldId, int levelId){
        switch (worldId){
            case 1:
                switch (levelId){
                    case 1:
                        return "portrait_fields";
                    case 2:
                        return "portrait_fields";
                    case 3:
                        return "portrait_fields";
                    case 4:
                        return "portrait_miniboss";
                    case 5:
                        return "portrait_fields";
                    case 6:
                        return "portrait_fields";
                    case 7:
                        return "portrait_fields";
                    case 8:
                        return "portrait_boss";
                }
            case 2:
                switch (levelId){
                    case 9:
                        return "portrait_dungeon";
                    case 10:
                        return "portrait_dungeon";
                    case 11:
                        return "portrait_dungeon";
                    case 12:
                        return "portrait_miniboss";
                    case 13:
                        return "portrait_dungeon";
                    case 14:
                        return "portrait_dungeon";
                    case 15:
                        return "portrait_dungeon";
                    case 16:
                        return "portrait_boss";
                }
            case 3:
                switch (levelId){
                    case 17:
                        return "portrait_mountains";
                    case 18:
                        return "portrait_mountains";
                    case 19:
                        return "portrait_mountains";
                    case 20:
                        return "portrait_miniboss";
                    case 21:
                        return "portrait_mountains";
                    case 22:
                        return "portrait_mountains";
                    case 23:
                        return "portrait_mountains";
                    case 24:
                        return "portrait_boss";
                }
        }
        return null;
    }

    public static String getEnemyName(int worldId, int levelId){
        switch (worldId) {
            case 1:
                switch (levelId){
                    case 1:
                        return "Farmhand Mack";
                    case 2:
                        return "Farmhand Zack";
                    case 3:
                        return "Farmhand Jack";
                    case 4:
                        return "Farmboss Leo";
                    case 5:
                        return "Farmhand Bo";
                    case 6:
                        return "Farmhand Nick";
                    case 7:
                        return "Farmhand Seth";
                    case 8:
                        return "Farmlord Dwayne";
                }
            case 2:
                switch (levelId){
                    case 9:
                        return "Eerie Ghost";
                    case 10:
                        return "Apparition";
                    case 11:
                        return "Phantom";
                    case 12:
                        return "Ghoul";
                    case 13:
                        return "Specter";
                    case 14:
                        return "Revenant";
                    case 15:
                        return "Spirit";
                    case 16:
                        return "Lost Soul";
                }
            case 3:
                switch (levelId){
                    case 17:
                        return "Lost Climber";
                    case 18:
                        return "Adventurer";
                    case 19:
                        return "Snow Wolf";
                    case 20:
                        return "Mad Hermit";
                    case 21:
                        return "Cougar";
                    case 22:
                        return "Wanderer";
                    case 23:
                        return "Giant Bear";
                    case 24:
                        return "Yeti";
                }
        }
        return null;
    }

}
