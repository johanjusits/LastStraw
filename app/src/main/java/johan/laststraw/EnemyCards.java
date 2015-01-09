package johan.laststraw;

/**
 * Created by Johan on 2015-01-07.
 */
public class EnemyCards {

    public static int getEnemyTotalCards(int levelId){
        switch (levelId){
            //WORLD 001
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 3;
            case 5:
                return 3;
            case 6:
                return 4;
            case 7:
                return 5;
            case 8:
                return 3;
            //WORLD 002
            case 9:
                return 4;
            case 10:
                return 3;
            case 11:
                return 6;
        }
        return 0;
    }

    public static String getEnemyCardIconName(int levelId, int cardNr){
        switch (levelId){
            // WORLD 1 LEVEL 1
            case 1:
                switch (cardNr){
                    case 0:
                        return "card_icon_field";
                }
            // WORLD 1 LEVEL 2
            case 2:
                switch (cardNr){
                    case 0:
                        return "card_icon_field";
                    case 1:
                        return "card_icon_field";
                }
            // WORLD 1 LEVEL 3
            case 3:
                switch (cardNr){
                    case 0:
                        return "card_icon_field";
                    case 1:
                        return "card_icon_field";
                    case 2:
                        return "card_icon_ailment";
                }
            // WORLD 1 LEVEL 4
            case 4:
                switch (cardNr){
                    case 0:
                        return "card_icon_boosting";
                    case 1:
                        return "card_icon_field";
                    case 2:
                        return "card_icon_ailment";
                }
            // WORLD 1 LEVEL 5
            case 5:
                switch (cardNr){
                    case 0:
                        return "card_icon_field";
                    case 1:
                        return "card_icon_field";
                    case 2:
                        return "card_icon_ailment";
                }
            // WORLD 1 LEVEL 6
            case 6:
                switch (cardNr){
                    case 0:
                        return "card_icon_boosting";
                    case 1:
                        return "card_icon_ailment";
                    case 2:
                        return "card_icon_ailment";
                    case 3:
                        return "card_icon_field";
                }
            // WORLD 1 LEVEL 7
            case 7:
                switch (cardNr){
                    case 0:
                        return "card_icon_boosting";
                    case 1:
                        return "card_icon_ailment";
                    case 2:
                        return "card_icon_field";
                    case 3:
                        return "card_icon_field";
                    case 4:
                        return "card_icon_field";
                }
            // WORLD 1 LEVEL 8
            case 8:
                switch (cardNr){
                    case 0:
                        return "card_icon_boosting";
                    case 1:
                        return "card_icon_boosting";
                    case 2:
                        return "card_icon_field";
                }
            // WORLD 2 LEVEL 1
            case 9:
                switch (cardNr){
                    case 0:
                        return "card_icon_ailment";
                    case 1:
                        return "card_icon_ailment";
                    case 2:
                        return "card_icon_ailment";
                    case 3:
                        return "card_icon_boosting";
                }
            // WORLD 2 LEVEL 2
            case 10:
                switch (cardNr){
                    case 0:
                        return "card_icon_ailment";
                    case 1:
                        return "card_icon_ailment";
                    case 2:
                        return "card_icon_field";
                }
            // WORLD 2 LEVEL 3
            case 11:
                switch (cardNr){
                    case 0:
                        return "card_icon_field";
                    case 1:
                        return "card_icon_boosting";
                    case 2:
                        return "card_icon_ailment";
                    case 3:
                        return "card_icon_field";
                    case 4:
                        return "card_icon_field";
                    case 5:
                        return "card_icon_ailment";
                }
        }
        return "";
    }

    public static String getEnemyCardTypeName(int levelId, int cardNr, String screenSize){
        switch (levelId){
            // WORLD 1 LEVEL 1
            case 1:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return "card_type_field_tablet";
                        } else {
                            return "card_type_field";
                        }
                }
            // WORLD 1 LEVEL 2
            case 2:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return "card_type_field_tablet";
                        } else {
                            return "card_type_field";
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return "card_type_field_tablet";
                        } else {
                            return "card_type_field";
                        }
                }
            // WORLD 1 LEVEL 3
            case 3:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return "card_type_field_tablet";
                        } else {
                            return "card_type_field";
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return "card_type_field_tablet";
                        } else {
                            return "card_type_field";
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return "card_type_ailment_tablet";
                        } else {
                            return "card_type_ailment";
                        }
                }
            // WORLD 1 LEVEL 4
            case 4:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return "card_type_boosting_tablet";
                        } else {
                            return "card_type_boosting";
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return "card_type_field_tablet";
                        } else {
                            return "card_type_field";
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return "card_type_ailment_tablet";
                        } else {
                            return "card_type_ailment";
                        }
                }
            // WORLD 1 LEVEL 5
            case 5:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return "card_type_field_tablet";
                        } else {
                            return "card_type_field";
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return "card_type_field_tablet";
                        } else {
                            return "card_type_field";
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return "card_type_ailment_tablet";
                        } else {
                            return "card_type_ailment";
                        }
                }
            // WORLD 1 LEVEL 6
            case 6:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return "card_type_boosting_tablet";
                        } else {
                            return "card_type_boosting";
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return "card_type_ailment_tablet";
                        } else {
                            return "card_type_ailment";
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return "card_type_ailment_tablet";
                        } else {
                            return "card_type_ailment";
                        }
                    case 3:
                        if (screenSize.equals("xlarge")){
                            return "card_type_field_tablet";
                        } else {
                            return "card_type_field";
                        }
                }
            // WORLD 1 LEVEL 7
            case 7:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return "card_type_boosting_tablet";
                        } else {
                            return "card_type_boosting";
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return "card_type_ailment_tablet";
                        } else {
                            return "card_type_ailment";
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return "card_type_field_tablet";
                        } else {
                            return "card_type_field";
                        }
                    case 3:
                        if (screenSize.equals("xlarge")){
                            return "card_type_field_tablet";
                        } else {
                            return "card_type_field";
                        }
                    case 4:
                        if (screenSize.equals("xlarge")){
                            return "card_type_field_tablet";
                        } else {
                            return "card_type_field";
                        }
                }
            // WORLD 1 LEVEL 8
            case 8:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return "card_type_boosting_tablet";
                        } else {
                            return "card_type_boosting";
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return "card_type_boosting_tablet";
                        } else {
                            return "card_type_boosting";
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return "card_type_field_tablet";
                        } else {
                            return "card_type_field";
                        }
                }
            // WORLD 2 LEVEL 1
            case 9:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return "card_type_ailment_tablet";
                        } else {
                            return "card_type_ailment";
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return "card_type_ailment_tablet";
                        } else {
                            return "card_type_ailment";
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return "card_type_ailment_tablet";
                        } else {
                            return "card_type_ailment";
                        }
                    case 3:
                        if (screenSize.equals("xlarge")){
                            return "card_type_boosting_tablet";
                        } else {
                            return "card_type_boosting";
                        }
                }
            // WORLD 2 LEVEL 2
            case 10:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return "card_type_ailment_tablet";
                        } else {
                            return "card_type_ailment";
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return "card_type_ailment_tablet";
                        } else {
                            return "card_type_ailment";
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return "card_type_field_tablet";
                        } else {
                            return "card_type_field";
                        }
                }
            // WORLD 2 LEVEL 3
            case 11:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return "card_type_field_tablet";
                        } else {
                            return "card_type_field";
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return "card_type_boosting_tablet";
                        } else {
                            return "card_type_boosting";
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return "card_type_ailment_tablet";
                        } else {
                            return "card_type_ailment";
                        }
                    case 3:
                        if (screenSize.equals("xlarge")){
                            return "card_type_field_tablet";
                        } else {
                            return "card_type_field";
                        }
                    case 4:
                        if (screenSize.equals("xlarge")){
                            return "card_type_field_tablet";
                        } else {
                            return "card_type_field";
                        }
                    case 5:
                        if (screenSize.equals("xlarge")){
                            return "card_type_ailment_tablet";
                        } else {
                            return "card_type_ailment";
                        }
                }
        }
        return "";
    }

    public static boolean getCardPresent(int levelId, int cardNr){
        switch (levelId){
            // WORLD 1 LEVEL 1
            case 1:
                switch (cardNr){
                    case 0:
                        return true;
                    case 1:
                        return false;
                    case 2:
                        return false;
                    case 3:
                        return false;
                    case 4:
                        return false;
                    case 5:
                        return false;
                }
            // WORLD 1 LEVEL 2
            case 2:
                switch (cardNr){
                    case 0:
                        return true;
                    case 1:
                        return true;
                    case 2:
                        return false;
                    case 3:
                        return false;
                    case 4:
                        return false;
                    case 5:
                        return false;
                }
            // WORLD 1 LEVEL 3
            case 3:
                switch (cardNr){
                    case 0:
                        return true;
                    case 1:
                        return true;
                    case 2:
                        return true;
                    case 3:
                        return false;
                    case 4:
                        return false;
                    case 5:
                        return false;
                }
            // WORLD 1 LEVEL 4
            case 4:
                switch (cardNr){
                    case 0:
                        return true;
                    case 1:
                        return true;
                    case 2:
                        return true;
                    case 3:
                        return false;
                    case 4:
                        return false;
                    case 5:
                        return false;
                }
            // WORLD 1 LEVEL 5
            case 5:
                switch (cardNr){
                    case 0:
                        return true;
                    case 1:
                        return true;
                    case 2:
                        return true;
                    case 3:
                        return false;
                    case 4:
                        return false;
                    case 5:
                        return false;
                }
            // WORLD 1 LEVEL 6
            case 6:
                switch (cardNr){
                    case 0:
                        return true;
                    case 1:
                        return true;
                    case 2:
                        return true;
                    case 3:
                        return true;
                    case 4:
                        return false;
                    case 5:
                        return false;
                }
            // WORLD 1 LEVEL 7
            case 7:
                switch (cardNr){
                    case 0:
                        return true;
                    case 1:
                        return true;
                    case 2:
                        return true;
                    case 3:
                        return true;
                    case 4:
                        return true;
                    case 5:
                        return false;
                }
            // WORLD 1 LEVEL 8
            case 8:
                switch (cardNr){
                    case 0:
                        return true;
                    case 1:
                        return true;
                    case 2:
                        return true;
                    case 3:
                        return false;
                    case 4:
                        return false;
                    case 5:
                        return false;
                }
            // WORLD 2 LEVEL 1
            case 9:
                switch (cardNr){
                    case 0:
                        return true;
                    case 1:
                        return true;
                    case 2:
                        return true;
                    case 3:
                        return true;
                    case 4:
                        return false;
                    case 5:
                        return false;
                }
            // WORLD 2 LEVEL 2
            case 10:
                switch (cardNr){
                    case 0:
                        return true;
                    case 1:
                        return true;
                    case 2:
                        return true;
                    case 3:
                        return false;
                    case 4:
                        return false;
                    case 5:
                        return false;
                }
            // WORLD 2 LEVEL 2
            case 11:
                switch (cardNr){
                    case 0:
                        return true;
                    case 1:
                        return true;
                    case 2:
                        return true;
                    case 3:
                        return true;
                    case 4:
                        return true;
                    case 5:
                        return true;
                }
        }
        return false;
    }

    public static String getEnemyCardImgName(int levelId, int cardNr){
        switch (levelId){
            // WORLD 1 LEVEL 1
            case 1:
                switch (cardNr){
                    case 0:
                        return "card_obj_plus_1";
                }
            // WORLD 1 LEVEL 2
            case 2:
                switch (cardNr){
                    case 0:
                        return "card_obj_plus_1";
                    case 1:
                        return "card_obj_plus_2";
                }
            // WORLD 1 LEVEL 3
            case 3:
                switch (cardNr){
                    case 0:
                        return "card_obj_plus_1";
                    case 1:
                        return "card_obj_plus_2";
                    case 2:
                        return "card_slowdown";
                }
            // WORLD 1 LEVEL 4
            case 4:
                switch (cardNr){
                    case 0:
                        return "card_speed_up";
                    case 1:
                        return "card_obj_plus_3";
                    case 2:
                        return "card_slowdown";
                }
            // WORLD 1 LEVEL 5
            case 5:
                switch (cardNr){
                    case 0:
                        return "card_obj_plus_2";
                    case 1:
                        return "card_obj_plus_2";
                    case 2:
                        return "card_slowdown";
                }
            // WORLD 1 LEVEL 6
            case 6:
                switch (cardNr){
                    case 0:
                        return "card_speed_up";
                    case 1:
                        return "card_slowdown";
                    case 2:
                        return "card_slowdown";
                    case 3:
                        return "card_obj_plus_3";
                }
            // WORLD 1 LEVEL 7
            case 7:
                switch (cardNr){
                    case 0:
                        return "card_speed_up";
                    case 1:
                        return "card_slowdown";
                    case 2:
                        return "card_obj_plus_2";
                    case 3:
                        return "card_obj_plus_3";
                    case 4:
                        return "card_obj_plus_2";
                }
            // WORLD 1 LEVEL 8
            case 8:
                switch (cardNr){
                    case 0:
                        return "card_speed_up";
                    case 1:
                        return "card_concentrate";
                    case 2:
                        return "card_steal_3";
                }
            // WORLD 2 LEVEL 1
            case 9:
                switch (cardNr){
                    case 0:
                        return "card_slowdown";
                    case 1:
                        return "card_corruption";
                    case 2:
                        return "card_agony";
                    case 3:
                        return "card_speed_up";
                }
            // WORLD 2 LEVEL 2
            case 10:
                switch (cardNr){
                    case 0:
                        return "card_corruption";
                    case 1:
                        return "card_curse";
                    case 2:
                        return "card_obj_plus_2";
                }
            // WORLD 2 LEVEL 3
            case 11:
                switch (cardNr){
                    case 0:
                        return "card_steal_3";
                    case 1:
                        return "card_speed_up";
                    case 2:
                        return "card_agony";
                    case 3:
                        return "card_obj_plus_3";
                    case 4:
                        return "card_obj_plus_3";
                    case 5:
                        return "card_corruption";
                }
        }
        return "";
    }

    public static String getEnemyCardName(int levelId, int cardNr){
        switch (levelId){
            // WORLD 1 LEVEL 1
            case 1:
                switch (cardNr){
                    case 0:
                        return "Reinforce";
                    case 1:
                        return "";
                    case 2:
                        return "";
                    case 3:
                        return "";
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
            // WORLD 1 LEVEL 2
            case 2:
                switch (cardNr){
                    case 0:
                        return "Reinforce";
                    case 1:
                        return "Reinforce II";
                    case 2:
                        return "";
                    case 3:
                        return "";
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
            // WORLD 1 LEVEL 3
            case 3:
                switch (cardNr){
                    case 0:
                        return "Reinforce";
                    case 1:
                        return "Reinforce II";
                    case 2:
                        return "Slow Down";
                    case 3:
                        return "";
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
            // WORLD 1 LEVEL 4
            case 4:
                switch (cardNr){
                    case 0:
                        return "Speed Up";
                    case 1:
                        return "Reinforce III";
                    case 2:
                        return "Slow Down";
                    case 3:
                        return "";
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
            // WORLD 1 LEVEL 5
            case 5:
                switch (cardNr){
                    case 0:
                        return "Reinforce II";
                    case 1:
                        return "Reinforce II";
                    case 2:
                        return "Slow Down";
                    case 3:
                        return "";
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
            // WORLD 1 LEVEL 6
            case 6:
                switch (cardNr){
                    case 0:
                        return "Speed Up";
                    case 1:
                        return "Slow Down";
                    case 2:
                        return "Slow Down";
                    case 3:
                        return "Reinforce III";
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
            // WORLD 1 LEVEL 7
            case 7:
                switch (cardNr){
                    case 0:
                        return "Speed Up";
                    case 1:
                        return "Slow Down";
                    case 2:
                        return "Reinforce II";
                    case 3:
                        return "Reinforce III";
                    case 4:
                        return "Reinforce II";
                    case 5:
                        return "";
                }
            // WORLD 1 LEVEL 8
            case 8:
                switch (cardNr){
                    case 0:
                        return "Speed Up";
                    case 1:
                        return "Concentrate";
                    case 2:
                        return "Steal";
                    case 3:
                        return "";
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
            // WORLD 2 LEVEL 1
            case 9:
                switch (cardNr){
                    case 0:
                        return "Slow Down";
                    case 1:
                        return "Corruption";
                    case 2:
                        return "Agony";
                    case 3:
                        return "Speed Up";
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
            // WORLD 2 LEVEL 2
            case 10:
                switch (cardNr){
                    case 0:
                        return "Corruption";
                    case 1:
                        return "Curse";
                    case 2:
                        return "Reinforce II";
                    case 3:
                        return "";
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
                // WORLD 2 LEVEL 3
            case 11:
                switch (cardNr){
                    case 0:
                        return "Steal";
                    case 1:
                        return "Speed Up";
                    case 2:
                        return "Agony";
                    case 3:
                        return "Reinforce III";
                    case 4:
                        return "Reinforce III";
                    case 5:
                        return "Corruption";
                }
        }
        return "";
    }

    public static int getEnemyCardCost(int levelId, int cardNr){
        switch (levelId){
            // WORLD 1 LEVEL 1
            case 1:
                switch (cardNr){
                    case 0:
                        return 0;
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
                }
            // WORLD 1 LEVEL 2
            case 2:
                switch (cardNr){
                    case 0:
                        return 0;
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
                }
            // WORLD 1 LEVEL 3
            case 3:
                switch (cardNr){
                    case 0:
                        return 0;
                    case 1:
                        return 0;
                    case 2:
                        return 1;
                    case 3:
                        return 0;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
            // WORLD 1 LEVEL 4
            case 4:
                switch (cardNr){
                    case 0:
                        return 1;
                    case 1:
                        return 1;
                    case 2:
                        return 1;
                    case 3:
                        return 0;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
            // WORLD 1 LEVEL 5
            case 5:
                switch (cardNr){
                    case 0:
                        return 0;
                    case 1:
                        return 0;
                    case 2:
                        return 1;
                    case 3:
                        return 0;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
            // WORLD 1 LEVEL 6
            case 6:
                switch (cardNr){
                    case 0:
                        return 1;
                    case 1:
                        return 1;
                    case 2:
                        return 1;
                    case 3:
                        return 1;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
            // WORLD 1 LEVEL 7
            case 7:
                switch (cardNr){
                    case 0:
                        return 1;
                    case 1:
                        return 1;
                    case 2:
                        return 0;
                    case 3:
                        return 1;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
            // WORLD 1 LEVEL 8
            case 8:
                switch (cardNr){
                    case 0:
                        return 1;
                    case 1:
                        return 1;
                    case 2:
                        return 1;
                    case 3:
                        return 0;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
            // WORLD 2 LEVEL 1
            case 9:
                switch (cardNr){
                    case 0:
                        return 1;
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 3:
                        return 1;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
            // WORLD 2 LEVEL 2
            case 10:
                switch (cardNr){
                    case 0:
                        return 1;
                    case 1:
                        return 2;
                    case 2:
                        return 0;
                    case 3:
                        return 0;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
            // WORLD 2 LEVEL 3
            case 11:
                switch (cardNr){
                    case 0:
                        return 1;
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 3:
                        return 1;
                    case 4:
                        return 1;
                    case 5:
                        return 1;
                }
        }
        return 0;
    }

}
