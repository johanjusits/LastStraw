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
            case 25:
                return 13;
            case 26:
                return 13;
            case 27:
                return 14;
            case 28:
                return 14;
            case 29:
                return 15;
            case 30:
                return 15;
            case 31:
                return 16;
            case 32:
                return 16;
            case 33:
                return 17;
            case 34:
                return 17;
            case 35:
                return 18;
            case 36:
                return 18;
            case 37:
                return 19;
            case 38:
                return 19;
            case 39:
                return 20;
            case 40:
                return 20;
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
                return 25;
        }
        return 0;
    }

    public static String getPortraitImgName(int worldId, int levelId){
        switch (worldId){
            case 1:
                switch (levelId){
                    case 1:
                        return "portrait_w01";
                    case 2:
                        return "portrait_w01";
                    case 3:
                        return "portrait_w01";
                    case 4:
                        return "portrait_miniboss";
                    case 5:
                        return "portrait_w01";
                    case 6:
                        return "portrait_w01";
                    case 7:
                        return "portrait_w01";
                    case 8:
                        return "portrait_boss";
                }
            case 2:
                switch (levelId){
                    case 9:
                        return "portrait_w02";
                    case 10:
                        return "portrait_w02";
                    case 11:
                        return "portrait_w02";
                    case 12:
                        return "portrait_miniboss";
                    case 13:
                        return "portrait_w02";
                    case 14:
                        return "portrait_w02";
                    case 15:
                        return "portrait_w02";
                    case 16:
                        return "portrait_boss";
                }
            case 3:
                switch (levelId){
                    case 17:
                        return "portrait_w03";
                    case 18:
                        return "portrait_w03";
                    case 19:
                        return "portrait_w03";
                    case 20:
                        return "portrait_miniboss";
                    case 21:
                        return "portrait_w03";
                    case 22:
                        return "portrait_w03";
                    case 23:
                        return "portrait_w03";
                    case 24:
                        return "portrait_boss";
                }
            case 4:
                switch (levelId){
                    case 25:
                        return "portrait_w04";
                    case 26:
                        return "portrait_w04";
                    case 27:
                        return "portrait_w04";
                    case 28:
                        return "portrait_miniboss";
                    case 29:
                        return "portrait_w04";
                    case 30:
                        return "portrait_w04";
                    case 31:
                        return "portrait_w04";
                    case 32:
                        return "portrait_boss";
                }
            case 5:
                switch (levelId){
                    case 33:
                        return "portrait_w05";
                    case 34:
                        return "portrait_w05";
                    case 35:
                        return "portrait_w05";
                    case 36:
                        return "portrait_miniboss";
                    case 37:
                        return "portrait_w05";
                    case 38:
                        return "portrait_w05";
                    case 39:
                        return "portrait_w05";
                    case 40:
                        return "portrait_boss";
                }
            case 6:
                switch (levelId){
                    case 41:
                        return "portrait_w06";
                    case 42:
                        return "portrait_w06";
                    case 43:
                        return "portrait_w06";
                    case 44:
                        return "portrait_miniboss";
                    case 45:
                        return "portrait_w06";
                    case 46:
                        return "portrait_w06";
                    case 47:
                        return "portrait_w06";
                    case 48:
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
                        return "Farmhand";
                    case 2:
                        return "Farmhand Zack";
                    case 3:
                        return "Farmhand Jack";
                    case 4:
                        return "Farmboss Arvid";
                    case 5:
                        return "Farmhand Bo";
                    case 6:
                        return "Farmhand Nick";
                    case 7:
                        return "Farmhand Seth";
                    case 8:
                        return "Farmlord Bengt";
                }
            case 2:
                switch (levelId){
                    case 9:
                        return "Farmhand";
                    case 10:
                        return "Farmhand";
                    case 11:
                        return "Farmhand";
                    case 12:
                        return "Farmboss Valdemar";
                    case 13:
                        return "Farmhand";
                    case 14:
                        return "Farmhand";
                    case 15:
                        return "Farmhand";
                    case 16:
                        return "Farmlord Hjalmar";
                }
            case 3:
                switch (levelId){
                    case 17:
                        return "Farmhand";
                    case 18:
                        return "Farmhand";
                    case 19:
                        return "Farmhand";
                    case 20:
                        return "Farmboss Gustaf";
                    case 21:
                        return "Farmhand";
                    case 22:
                        return "Farmhand";
                    case 23:
                        return "Farmhand";
                    case 24:
                        return "Farmlord Kenneth";
                }
            case 4:
                switch (levelId){
                    case 25:
                        return "Farmhand";
                    case 26:
                        return "Farmhand";
                    case 27:
                        return "Farmhand";
                    case 28:
                        return "Farmboss Sture";
                    case 29:
                        return "Farmhand";
                    case 30:
                        return "Farmhand";
                    case 31:
                        return "Farmhand";
                    case 32:
                        return "Farmlord Olof";
                }
            case 5:
                switch (levelId){
                    case 33:
                        return "Farmhand";
                    case 34:
                        return "Farmhand";
                    case 35:
                        return "Farmhand";
                    case 36:
                        return "Farmboss Karl";
                    case 37:
                        return "Farmhand";
                    case 38:
                        return "Farmhand";
                    case 39:
                        return "Farmhand";
                    case 40:
                        return "Farmlord Reinhard";
                }
            case 6:
                switch (levelId){
                    case 41:
                        return "Farmhand";
                    case 42:
                        return "Farmhand";
                    case 43:
                        return "Farmhand";
                    case 44:
                        return "Farmboss Dan";
                    case 45:
                        return "Farmhand";
                    case 46:
                        return "Farmhand";
                    case 47:
                        return "Farmhand";
                    case 48:
                        return "Farmlord Johan";
                }
        }
        return null;
    }

}
