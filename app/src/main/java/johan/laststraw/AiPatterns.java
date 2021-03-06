package johan.laststraw;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Johan on 2015-01-07.
 */
public class AiPatterns {

    public static int randomizeEnemyCardSelect(int enemyStartingCards, ArrayList<Integer> pool) {
        int randomizedCard;

        switch (enemyStartingCards) {
            case 1:
                return 0;
            case 2:
                do {
                    randomizedCard = genRand(2);
                } while (pool.contains(randomizedCard));
                return randomizedCard;
            case 3:
                do {
                    randomizedCard = genRand(3);
                } while (pool.contains(randomizedCard));
                return randomizedCard;
            case 4:
                do {
                    randomizedCard = genRand(4);
                } while (pool.contains(randomizedCard));
                return randomizedCard;
            case 5:
                do {
                    randomizedCard = genRand(5);
                } while (pool.contains(randomizedCard));
                return randomizedCard;
            case 6:
                do {
                    randomizedCard = genRand(6);
                } while (pool.contains(randomizedCard));
                return randomizedCard;
        }

        return 0;
    }

    public static int genRand(int number) {
        return new Random().nextInt(number);
    }

    public static int getAiPatternNr(int levelId){
            switch (levelId){
                //WORLD 1
                case 1:
                    return 1;
                case 2:
                    return 1;
                case 3:
                    return 1;
                case 4:
                    return 1;
                case 5:
                    return 1;
                case 6:
                    return 1;
                case 7:
                    return 1;
                case 8:
                    return 1;
                //WORLD 2
                case 9:
                    return 5;
                case 10:
                    return 3;
                case 11:
                    return 4;
                case 12:
                    return 3;
                case 13:
                    return 4;
                case 14:
                    return 5;
                case 15:
                    return 3;
                case 16:
                    return 5;
                //WORLD 3
                case 17:
                    return 5;
                case 18:
                    return 4;
                case 19:
                    return 3;
                case 20:
                    return 3;
                case 21:
                    return 3;
                case 22:
                    return 4;
                case 23:
                    return 5;
                case 24:
                    return 4;
                //WORLD 4
                case 25:
                    return 4;
                case 26:
                    return 5;
                case 27:
                    return 5;
                case 28:
                    return 5;
                case 29:
                    return 5;
                case 30:
                    return 5;
                case 31:
                    return 5;
                case 32:
                    return 5;
                //WORLD 5
                case 33:
                    return 5;
                case 34:
                    return 5;
                case 35:
                    return 5;
                case 36:
                    return 5;
                case 37:
                    return 5;
                case 38:
                    return 5;
                case 39:
                    return 5;
                case 40:
                    return 5;
                //WORLD 6
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                    return 1;
            }
        return 1;
    }

    public static int initAiPatternCardOrNot(int levelId, int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        switch (levelId){
            //WORLD 1
            case 1:
                return genRand(100);
            case 2:
                return genRand(100);
            case 3:
                return genRand(100);
            case 4:
                return genRand(100);
            case 5:
                return genRand(100);
            case 6:
                return genRand(100);
            case 7:
                return genRand(100);
            case 8:
                return genRand(100);
            //WORLD 2
            case 9:
                return w002_l001_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter);
            case 10:
                return w002_l002_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 11:
                return w002_l003_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 12:
                return w002_l004_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 13:
                return w002_l005_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 14:
                return w002_l006_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 15:
                return w002_l007_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 16:
                return w002_l008_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            //WORLD 3
            case 17:
                return w003_l001_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 18:
                return w003_l002_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 19:
                return w003_l003_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 20:
                return w003_l004_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 21:
                return w003_l005_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 22:
                return w003_l006_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 23:
                return w003_l007_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 24:
                return w003_l008_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            //WORLD 4
            case 25:
                return w004_l001_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 26:
                return w004_l002_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 27:
                return w004_l003_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 28:
                return w004_l004_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 29:
                return w004_l005_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 30:
                return w004_l006_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 31:
                return w004_l007_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 32:
                return w004_l008_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            //WORLD 5
            case 33:
                return w005_l001_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 34:
                return w005_l002_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 35:
                return w005_l003_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 36:
                return w005_l004_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 37:
                return w005_l005_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 38:
                return w005_l006_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 39:
                return w005_l007_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            case 40:
                return w005_l008_AI_CardOrNot(aiPattern, enemyTurnCounter, enemyMoveCounter, objectsRemaining);
            //WORLD 6
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
                return w006_AI_CardOrNot(objectsRemaining);
        }
        return 0;
    }

    public static int initAiPatternPickCard(int levelId, int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards,
                                            ArrayList<Integer> pool, int objectsRemaining){
        switch (levelId){
            //WORLD 2
            case 9:
                return w002_l001_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 10:
                return w002_l002_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 11:
                return w002_l003_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 12:
                return w002_l004_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 13:
                return w002_l005_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 14:
                return w002_l006_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 15:
                return w002_l007_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 16:
                return w002_l008_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            //WORLD 3
            case 17:
                return w003_l001_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 18:
                return w003_l002_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 19:
                return w003_l003_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 20:
                return w003_l004_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 21:
                return w003_l005_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 22:
                return w003_l006_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 23:
                return w003_l007_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 24:
                return w003_l008_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            //WORLD 4
            case 25:
                return w004_l001_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 26:
                return w004_l002_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 27:
                return w004_l003_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 28:
                return w004_l004_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 29:
                return w004_l005_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 30:
                return w004_l006_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 31:
                return w004_l007_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 32:
                return w004_l008_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            //WORLD 5
            case 33:
                return w005_l001_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 34:
                return w005_l002_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 35:
                return w005_l003_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 36:
                return w005_l004_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 37:
                return w005_l005_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 38:
                return w005_l006_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 39:
                return w005_l007_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            case 40:
                return w005_l008_AI_PickCard(aiPattern, enemyTurnCounter, enemyMoveCounter, enemyStartingCards, pool, objectsRemaining);
            //WORLD 6
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
                return w006_AI_PickCard(pool, enemyStartingCards);
        }
        return 0;
    }

    //WORLD 2 LEVEL 1
    public static int w002_l001_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter){
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2) {
                return 99;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter > 2){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1) {
                return 99;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter > 1) {
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1 || enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter > 2){
                return genRand(100);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1) {
                return 99;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter > 1) {
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1 || enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter > 2){
                return genRand(100);
            }
        }
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2) {
                return 99;
            }
            if (enemyTurnCounter > 1){
                return genRand(100);
            }
        }
        return genRand(100);
    }

    public static int w002_l001_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 0;
            }
            if (enemyTurnCounter > 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter > 2){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
            if (enemyTurnCounter > 2){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter > 2){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
            if (enemyTurnCounter > 2){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 3;
            }
            if (enemyTurnCounter > 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 2 LEVEL 2
    public static int w002_l002_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            //Turn 1
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1) {
                return 0;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2) {
                return 99;
            }
            //Turn 2
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1 || enemyTurnCounter == 2 && enemyMoveCounter == 3) {
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2) {
                return 99;
            }
            //Turn 2+ and when there's one object left
            if (enemyTurnCounter > 2 && objectsRemaining == 1) {
                return 99;
            }
            return 0;
        }
        if (aiPattern == 2){
            //Turn 3
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            //Turn 4
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            //Turn 4+ and when there's one object left
            if (enemyTurnCounter > 4 && objectsRemaining == 1) {
                return 99;
            }
            return 0;
        }
        return genRand(100);
    }

    public static int w002_l002_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 1;
            }
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 2;
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 2;
            }
        }
        return 0;
    }

    //WORLD 2 LEVEL 3
    public static int w002_l003_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            //Turn 1
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1) {
                return 99;
            }
            //Turn 3
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1 || enemyTurnCounter == 3 && enemyMoveCounter == 2) {
                return 99;
            }
            //Turn 4
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            //Turn 4+
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining > 1){
                return genRand(100);
            }
            return 0;
        }
        if (aiPattern == 2){
            //Turn 1
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            //Turn 3
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 99;
            }
            //Turn 4
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1 || enemyTurnCounter == 4 && enemyMoveCounter == 2) {
                return 99;
            }
            //Turn 4+
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining > 1){
                return genRand(100);
            }
            return 0;
        }
        if (aiPattern == 3){
            //Turn 1
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            //Turn 3
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            //Turn3+
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining > 1){
                return genRand(100);
            }
            return 0;
        }
        return genRand(100);
    }

    public static int w002_l003_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 4;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter > 4){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 2;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter > 1){
                return 5;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 2;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter > 3){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 2 LEVEL 4
    public static int w002_l004_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            //Turn 1
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1) {
                return 99;
            }
            //Turn 2
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1) {
                return 99;
            }
            //Turn 3
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 99;
            }
            //Turn 4
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            return 0;
        }
        if (aiPattern == 2){
            //Turn 1
            if (enemyTurnCounter == 1 && enemyMoveCounter == 3){
                return 99;
            }
            //Turn 2
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            //Turn 2+
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining > 1){
                return genRand(100);
            }
            return 0;
        }
        return genRand(100);
    }

    public static int w002_l004_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 2;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 1;
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 3){
                return 2;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 3;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 2 LEVEL 5
    public static int w002_l005_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            //Turn 1
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2) {
                return 99;
            }
            //Turn 1+
            if (enemyTurnCounter > 1 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 1 && objectsRemaining > 1){
                return genRand(100);
            }
            return 0;
        }
        if (aiPattern == 2){
            //Turn 1
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            //Turn 2
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            //Turn 2+
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining > 1){
                return genRand(100);
            }
            return 0;
        }
        if (aiPattern == 3){
            //Turn 1
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1) {
                return 99;
            }
            //Turn 1+
            if (enemyTurnCounter > 1 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 1 && objectsRemaining > 1){
                return genRand(100);
            }
            return 0;
        }
        return genRand(100);
    }

    public static int w002_l005_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 0;
            }
            if (enemyTurnCounter > 1 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 0;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter > 1 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 2 LEVEL 6
    public static int w002_l006_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            //Turn 1
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1) {
                return 99;
            }
            //Turn 2
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1) {
                return 99;
            }
            //Turn 3
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1) {
                return 99;
            }
            //Turn 3+
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining > 1){
                return genRand(100);
            }
            return 0;
        }
        if (aiPattern == 2){
            //Turn 2
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            //Turn 3
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 99;
            }
            //Turn 3+
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining > 1){
                return genRand(100);
            }
            return 0;
        }
        if (aiPattern == 3){
            //Turn 1
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            //Turn 1+
            if (enemyTurnCounter > 1 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 1 && objectsRemaining > 1){
                return genRand(100);
            }
            return 0;
        }
        if (aiPattern == 4){
            //Turn 1
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            //Turn 1+
            if (enemyTurnCounter > 1 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 1 && objectsRemaining > 1){
                return genRand(100);
            }
            return 0;
        }
        return genRand(100);
    }

    public static int w002_l006_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 0;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 0;
            }
            if (enemyTurnCounter > 1 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter > 1 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 2 LEVEL 7
    public static int w002_l007_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            //Turn 2
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1) {
                return 99;
            }
            //Turn 3
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1) {
                return 99;
            }
            //Turn 4
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1) {
                return 99;
            }
            //Turn 4+
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining > 1){
                return genRand(100);
            }
            return 0;
        }
        if (aiPattern == 2){
            //Turn 2
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            //Turn 3
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 99;
            }
            //Turn 3+
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining > 1){
                return genRand(100);
            }
            return 0;
        }
        return genRand(100);
    }

    public static int w002_l007_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        if (aiPattern == 1){
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 3;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 2 LEVEL 8
    public static int w002_l008_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        //Curse on first then random
        if (aiPattern == 1){
            //Turn 1
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1) {
                return 99;
            }
            //Turn 1+
            if (enemyTurnCounter > 1 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 1 && objectsRemaining > 1){
                return genRand(100);
            }
            return 0;
        }
        //Curse on first then double reinforce III + corruption on turn 2, then random
        if (aiPattern == 2){
            //Turn 1
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            //Turn 2
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1 || enemyTurnCounter == 2 && enemyMoveCounter == 2 || enemyTurnCounter == 2 && enemyMoveCounter == 3){
                return 99;
            }
            //Turn 2+
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining > 1){
                return genRand(100);
            }
            return 0;
        }
        //Corruption on first, Curse on second, then random
        if (aiPattern == 3){
            //Turn 1
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1) {
                return 99;
            }
            //Turn 2
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1) {
                return 99;
            }
            //Turn 2+
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining > 1){
                return genRand(100);
            }
            return 0;
        }
        //Agony on first, Curse on second, then random
        if (aiPattern == 4){
            //Turn 1
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1) {
                return 99;
            }
            //Turn 2
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1) {
                return 99;
            }
            //Turn 2+
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining > 1){
                return genRand(100);
            }
            return 0;
        }
        return genRand(100);
    }

    public static int w002_l008_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter > 1 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 1;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 3){
                return 5;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 3 LEVEL 1
    public static int w003_l001_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        //Concentrate on first and Speed Up on first, then steal on second, then random
        if (aiPattern == 1){
            //Turn 1
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1) {
                return 99;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2) {
                return 99;
            }
            //Turn 2
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1) {
                return 99;
            }
            //Turn 2+
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining > 1){
                return genRand(100);
            }
            return 0;
        }
        //Concentrate on first then random
        if (aiPattern == 2){
            //Turn 1
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            //Turn 1+
            if (enemyTurnCounter > 1 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 1 && objectsRemaining > 1){
                return genRand(100);
            }
            return 0;
        }
        //Speed Up on first then Steal x2 on second
        if (aiPattern == 3){
            //Turn 1
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1) {
                return 99;
            }
            //Turn 2
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1) {
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2) {
                return 99;
            }
            //Turn 2+
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining > 1){
                return genRand(100);
            }
            return 0;
        }
        //Steal on second, then random
        if (aiPattern == 4){
            //Turn 1
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            //Turn 1+
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining > 1){
                return genRand(100);
            }
            return 0;
        }
        return genRand(100);
    }

    public static int w003_l001_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 1;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter > 1 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 3;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        if (aiPattern == 4){
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 3 LEVEL 2
    public static int w003_l002_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 3){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 3){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 1){
                return genRand(100);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 1 && objectsRemaining <= 7){
                return 99;
            }
        }
        return 0;
    }

    public static int w003_l002_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        //Infest on move 3 turn one and two, agony on turn 3
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 3){
                return 2;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 3){
                return 3;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter > 3){
                return 0;
            }
        }
        //Agony on first then random
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter > 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        //Agony on first then infest when obj remaining less than 7
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter > 1 && objectsRemaining <= 7){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 3 LEVEL 3
    public static int w003_l003_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 3){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining > 1){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2){
                return genRand(100);
            }
        }
        return 0;
    }

    public static int w003_l003_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        //Corruption on first, concentrate on 2nd, then random
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 3){
                return 4;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 2;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        //Concentrate on 1st, none on 2nd, then random
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 3 LEVEL 4
    public static int w003_l004_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2 ){
                return 99;
            }
            if (enemyTurnCounter > 1 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 1 && objectsRemaining > 1){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        return 0;
    }

    public static int w003_l004_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        // Speed up + concentrate on first then random
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 3;
            }
            if (enemyTurnCounter > 1 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Steal II on 2nd and 3rd turn, rest random
        if (aiPattern == 2){
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 3 LEVEL 5
    public static int w003_l005_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining > 1){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        return 0;
    }

    public static int w003_l005_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        // Mimic after 2 turns, agony on 3rd
        if (aiPattern == 1){
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Agony on first, mimic on 3rd
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 3 LEVEL 6
    public static int w003_l006_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 1 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 1){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2){
                return genRand(100);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        return 0;
    }

    public static int w003_l006_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        // Protect & Curse in turn 1, then random
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 1;
            }
            if (enemyTurnCounter > 1 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Protect 1st, Mimic on 2nd, then random
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Curse 1st, Protect on 2nd, Mimic on 3rd, then random
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 3 LEVEL 7
    public static int w003_l007_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 3){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2){
                return genRand(100);
            }
        }
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 3){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2){
                return genRand(100);
            }
        }
        return 0;
    }

    public static int w003_l007_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        // Speed U in turn 1, Infest in turn 2, then random
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 3){
                return 0;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Agony 1st, Speed Up on 2nd, Infest on 3rd, then random
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Slow Down 1st, Corruption on 2nd then random
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Infest 1st, Agony on 2nd then random
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 3){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 3;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 3 LEVEL 8
    public static int w003_l008_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 3){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2){
                return genRand(100);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1 || enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2){
                return genRand(100);
            }
        }
        return 0;
    }

    public static int w003_l008_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        // Speed Up in turn 1, Protect in turn 2, then random
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 3){
                return 5;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 2;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Concentrate & Protect on 1st, Mimic on 2nd, then random
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 2;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Protect 1st, Speed & Concentrate 2nd, then random
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 4;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 4 LEVEL 1
    public static int w004_l001_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2){
                return genRand(100);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        return 0;
    }

    public static int w004_l001_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        // Speed Up + Slow in turn 1, Charge in turn 2, then random
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Charge 1st & Slow in 1st, Reinforce V on 2nd, then random
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 1;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Speed 1st & Charge 1st, Slow 2nd, Reinforce V 3rd, then random
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 5;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 4 LEVEL 2
    public static int w004_l002_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 3){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 3){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4){
                return genRand(100);
            }
        }
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        return 0;
    }

    public static int w004_l002_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        // Protect on 1st, Blind on 2nd, Reinforce V on 3rd, Infest on 4th then random
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 3){
                return 5;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Infest on 1st, Concentrate on 2nd, Steal on 3rd, then random
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 3){
                return 5;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Blind 1st & Concentrate on 1st, Reinforce V on 3rd, Steal on 4th then random
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 1;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Protect 1st, Concentrate on 2nd, Blind on 3rd, then random
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 4 LEVEL 3
    public static int w004_l003_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2){
                return genRand(100);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4){
                return genRand(100);
            }
        }
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        return 0;
    }

    public static int w004_l003_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        // Charge on 1st, Blind on 2nd, Concentrate & Take Aim on 3rd, then random
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 0;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Concentrate & Take Aim on 1st, Reinforce V on 2nd, then random
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 1;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Blind 1st & Take Aim on 1st, Charge on 2nd, Reinforce V on 3rd, Concentrate on 4th, then random
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Charge 1st, Cure & Blind on 2nd, Take Aim and Reinforce V on 3rd, then random
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 4;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 5;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 4 LEVEL 4
    public static int w004_l004_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 2){
                return 99;
            }
            if (enemyTurnCounter > 4){
                return genRand(100);
            }
        }
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        return 0;
    }

    public static int w004_l004_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        // Speed Up 2 on 1st, Silence & Salvage on 2nd, Curse on 3rd, then random
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 3;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Speed Up 2 on 1st, Curse on 2nd, Dispel & Salvage on 3rd, then random
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 5;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Silence 1st & Charge on 1st, Salvage on 2nd, Speed Up on 3rd, Curse & Dispel on 4th
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 2;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 2){
                return 5;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Curse 1st, Speed Up 2 & Salvage on 2nd, Charge on 3rd, then random
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 4;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 4 LEVEL 5
    public static int w004_l005_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4){
                return genRand(100);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2){
                return genRand(100);
            }
        }
        return 0;
    }

    public static int w004_l005_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        // Speed Up 2 & Concentrate on 1st, Salvage on 2nd, Reinforce V & Take Aim on 3rd, then random
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 2;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 3;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Salvage & Take Aim on 1st, Speed Up 2 on 2nd, Reinforce V & Concentrate on 4th, then random
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 3;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 2){
                return 1;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Concentrate on 1st, Steal II on 2nd, Salvage & Speed Up II on 3rd, then random
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 5;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Speed Up on 1st, Steal II & Salvage on 2nd, then random
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 0;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 4 LEVEL 6
    public static int w004_l006_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 2 && enemyMoveCounter == 3){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4){
                return genRand(100);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        return 0;
    }

    public static int w004_l006_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        // Curse 1st & Infest on 1st, Blind 2nd, then random
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 1;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Infest on 2nd, Reinforce V on 3rd, Curse on 4th, then random
        if (aiPattern == 2){
            if (enemyTurnCounter == 2 && enemyMoveCounter == 3){
                return 1;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Blind on 1st, Curse on 2nd, Mimic on 3rd, then random
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Curse on 1st, Mimic & Cure on 2nd, Reinforce V on 3rd, then random
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 5;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 4 LEVEL 7
    public static int w004_l007_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 3){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 3){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 3){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter > 1 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 1){
                return genRand(100);
            }
        }
        return 0;
    }

    public static int w004_l007_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        // Charge & Infest on 1st, Agony 2nd, Charge 3rd, then random
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 3){
                return 5;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Silence & Infest on 1st, Charge on 2nd, Agony on 3rd, then random
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 3){
                return 5;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Charge & Silence 1st, Infest on 2nd, Dispel on 3rd, then random
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 2;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 3){
                return 5;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Charge & Agony on 1st, then random
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 0;
            }
            if (enemyTurnCounter > 1 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 4 LEVEL 8
    public static int w004_l008_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1 || enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 3){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1 || enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1 || enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4){
                return genRand(100);
            }
        }
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 1 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 1){
                return genRand(100);
            }
        }
        return 0;
    }

    public static int w004_l008_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        // Protect & Death Sentence on 1st, Hoard 2nd & Steal 2 on 2nd, Reinforce V 3rd, then random
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 2;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 4;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Protect & Death Sentence on 1st, Hoard & Reinforce V on 2nd, Steal 2 on 3rd, then random
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 3;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Steal 2 on 1st, Death Sentence & Hoard on 2nd, Reinforce V on 3rd, Steal 2 on 4th, then random
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 1;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Hoard & Death Sentence on 1st, Protect on 2nd, then random
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 2;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 5 LEVEL 1
    public static int w005_l001_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 3){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2){
                return genRand(100);
            }
        }
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 3){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        return 0;
    }

    public static int w005_l001_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        // Death Sentence  1st, Infest 2nd, Corruption 3rd, then random
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Confuse 1st, Agony 2nd, Death Sentence & Infest 3 on 3rd, then random
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 3){
                return 2;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Death Sentence 1st, Confuse 2nd & Cure on 2nd, then random
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 3;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Agony 1st, Corruption on 2nd, Infest 3rd, then random
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 3){
                return 2;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 5 LEVEL 2
    public static int w005_l002_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1 || enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4){
                return genRand(100);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4){
                return genRand(100);
            }
        }
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        return 0;
    }

    public static int w005_l002_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        // Take Aim & Blind 1st, Concentrate & Salvage 2nd, Restore 4th, then random
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 5;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 1;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Take Aim & Salvage 1st, Steal 3 2nd, Blind 3rd, Restore 4th, then random
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 1;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Take Aim & Concentrate 1st, Salvage 3 2nd, Blind 3rd, Restore 4th, then random
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 3;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Blind 1st, Concentrate on 2nd, Restore 3rd, then random
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 5 LEVEL 3
    public static int w005_l003_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1 || enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4){
                return genRand(100);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4){
                return genRand(100);
            }
        }
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        return 0;
    }

    public static int w005_l003_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        // Malediction 1st, Charge & Infest 2nd, Concentrate 4th, then random
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 2;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Charge 1st, Blind 2nd, Concentrate 3rd, Rewind 4th, then random
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Malediction 1st, Concentrate 2nd, Rewind 3rd, Blind 4th, then random
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Malediction 1st, Charge on 2nd, Rewind 3rd, then random
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 5 LEVEL 4
    public static int w005_l004_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1 || enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1 ){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1 || enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4){
                return genRand(100);
            }
        }
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1 || enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        return 0;
    }

    public static int w005_l004_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        // Confuse & Silence 1st, Curse 2nd, Agony 3rd, then random
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 5;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Curse 1st, Dispel & Slow 2nd, Confuse 3rd, then random
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 1;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Agony 1st, Silence & Confuse 2nd, Curse 3rd, Slow 4th, then random
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 2;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Curse 1st, Dispel & Confuse on 2nd, Silence 3rd, then random
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 2;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 5 LEVEL 5
    public static int w005_l005_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1 || enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1 ){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1 || enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2){
                return genRand(100);
            }
        }
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1 || enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        return 0;
    }

    public static int w005_l005_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        // Charge & Blind 1st, Death Sentence 2nd, Hoard 3rd, then random
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 3;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Death Sentence 1st, Hoard & Blind 2nd, Rewind 3rd, then random
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 3;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Silence 1st, Charge & Hoard 2nd, then random
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 2;
            }
            if (enemyTurnCounter > 2 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Death Sentence 1st, Hoard & Rewind on 2nd, Blind 3rd, then random
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 0;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 5 LEVEL 6
    public static int w005_l006_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1 ){
                return 99;
            }
            if (enemyTurnCounter == 5 && enemyMoveCounter == 1 ){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1 || enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1 || enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 2 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 2){
                return genRand(100);
            }
        }
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 3 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 3){
                return genRand(100);
            }
        }
        return 0;
    }

    public static int w005_l006_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        // Speed Up 2 & Concentrate 1st, Corruption 3rd, Reinforce V 4th, then random
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 1;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Concentrate 1st, Mimic 3rd, Reinforce V 4th, Demonic Prayer 5th, then random
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 5 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter > 5 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Speed Up 2 & Corruption 1st, Concentrate & Reinforce V 2nd, Demonic Prayer 3rd, then random
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 3;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 2;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Speed Up 2 1st, Mimic 2nd, Demonic Prayer 3rd, then random
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter > 3 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 5 LEVEL 7
    public static int w005_l007_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4){
                return genRand(100);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4){
                return genRand(100);
            }
        }
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4){
                return genRand(100);
            }
        }
        return 0;
    }

    public static int w005_l007_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        // Charge 1st, Dispel 2nd, Concentrate 3rd, Steal 3 4th, then random
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Charge 1st, Cure 2nd, Concentrate 3rd, Steal 3 4th, then random
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Concentrate 1st, Steal 3 2nd, Charge 3rd, Dispel 4th, then random
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Concentrate 1st, Charge 2nd, Cure & Dispel 3rd, Steal 3 4th, then random
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 5;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 5 LEVEL 8
    public static int w005_l008_AI_CardOrNot(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int objectsRemaining){
        //Go nuts with random
        if (aiPattern == 0){
            return genRand(100);
        }
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1 || enemyTurnCounter == 2 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4){
                return genRand(100);
            }
        }
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4){
                return genRand(100);
            }
        }
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1 || enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4){
                return genRand(100);
            }
        }
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1 || enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 99;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 99;
            }
            if (enemyTurnCounter > 4 && objectsRemaining == 1){
                return 99;
            }
            if (enemyTurnCounter > 4){
                return genRand(100);
            }
        }
        return 0;
    }

    public static int w005_l008_AI_PickCard(int aiPattern, int enemyTurnCounter, int enemyMoveCounter, int enemyStartingCards, ArrayList<Integer> pool, int objectsRemaining){
        // Malediction 1st, Speed Up & Concentrate 2nd, Restore 3rd, Confuse 4th, then random
        if (aiPattern == 1){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 1 && enemyMoveCounter == 2){
                return 0;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Malediction 1st, Confuse 2nd, Restore 3rd, Speed Up 4th, then random
        if (aiPattern == 2){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 0;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Malediction 1st, Restore 2nd, Concentrate & Speed Up 3rd, Agony 4th, then random
        if (aiPattern == 3){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 3;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 0;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        // Agony 1st, Malediction 2nd, Restore & Speed Up 3rd, Confuse 4th, then random
        if (aiPattern == 4){
            if (enemyTurnCounter == 1 && enemyMoveCounter == 1){
                return 4;
            }
            if (enemyTurnCounter == 2 && enemyMoveCounter == 1){
                return 5;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 1){
                return 2;
            }
            if (enemyTurnCounter == 3 && enemyMoveCounter == 2){
                return 0;
            }
            if (enemyTurnCounter == 4 && enemyMoveCounter == 1){
                return 1;
            }
            if (enemyTurnCounter > 4 && objectsRemaining >= 1){
                return randomizeEnemyCardSelect(enemyStartingCards, pool);
            }
        }
        return 0;
    }

    //WORLD 6 LEVEL 1-8
    public static int w006_AI_CardOrNot(int objectsRemaining){
        if (objectsRemaining == 1) {
            return 99;
        } else {
            return genRand(100);
        }
    }

    public static int w006_AI_PickCard(ArrayList<Integer> pool, int enemyStartingCards){
        return randomizeEnemyCardSelect(enemyStartingCards, pool);
    }

}
