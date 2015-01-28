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

    //WORLD 4 LEVEL 5
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
}
