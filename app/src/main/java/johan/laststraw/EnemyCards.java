package johan.laststraw;

/**
 * Created by Johan on 2015-01-07.
 */
public class EnemyCards {

    static String cardIconField = "card_icon_field";
    static String cardIconAilment = "card_icon_ailment";
    static String cardIconBoosting = "card_icon_boosting";
    static String cardTypeField = "card_type_field";
    static String cardTypeAilment = "card_type_ailment";
    static String cardTypeBoosting = "card_type_boosting";
    static String cardTypeFieldTablet = "card_type_field_tablet";
    static String cardTypeAilmentTablet = "card_type_ailment_tablet";
    static String cardTypeBoostingTablet = "card_type_boosting_tablet";

    static String Reinforce1ImgPath = "card_obj_plus_1";
    static String Reinforce2ImgPath = "card_obj_plus_2";
    static String Reinforce3ImgPath = "card_obj_plus_3";
    static String SpeedUpImgPath = "card_speed_up";
    static String SlowDownImgPath = "card_slowdown";
    static String Steal1ImgPath = "card_steal_3";
    static String ConcentrateImgPath = "card_concentrate";
    static String CorruptionImgPath = "card_corruption";
    static String AgonyImgPath = "card_agony";
    static String CurseImgPath = "card_curse";
    static String Steal2ImgPath = "card_steal_5";
    static String MimicImgPath = "card_mimic";

    static String Reinforce1CardName = "Reinforce";
    static String Reinforce2CardName = "Reinforce II";
    static String Reinforce3CardName = "Reinforce III";
    static String SpeedUpCardName = "Speed Up";
    static String SlowDownCardName = "Slow Down";
    static String Steal1CardName = "Steal";
    static String ConcentrateCardName = "Concentrate";
    static String CorruptionCardName = "Corruption";
    static String AgonyCardName = "Agony";
    static String CurseCardName = "Curse";
    static String Steal2CardName = "Steal II";
    static String MimicCardName = "Mimic";

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
            case 12:
                return 4;
            case 13:
                return 4;
            case 14:
                return 3;
            case 15:
                return 4;
            case 16:
                return 6;
            //WORLD 003
            case 17:
                return 4;
        }
        return 0;
    }

    public static String getEnemyCardIconName(int levelId, int cardNr){
        switch (levelId){
            // WORLD 1 LEVEL 1
            case 1:
                switch (cardNr){
                    case 0:
                        return cardIconField;
                }
            // WORLD 1 LEVEL 2
            case 2:
                switch (cardNr){
                    case 0:
                        return cardIconField;
                    case 1:
                        return cardIconField;
                }
            // WORLD 1 LEVEL 3
            case 3:
                switch (cardNr){
                    case 0:
                        return cardIconField;
                    case 1:
                        return cardIconField;
                    case 2:
                        return cardIconAilment;
                }
            // WORLD 1 LEVEL 4
            case 4:
                switch (cardNr){
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconField;
                    case 2:
                        return cardIconAilment;
                }
            // WORLD 1 LEVEL 5
            case 5:
                switch (cardNr){
                    case 0:
                        return cardIconField;
                    case 1:
                        return cardIconField;
                    case 2:
                        return cardIconAilment;
                }
            // WORLD 1 LEVEL 6
            case 6:
                switch (cardNr){
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconAilment;
                    case 2:
                        return cardIconAilment;
                    case 3:
                        return cardIconField;
                }
            // WORLD 1 LEVEL 7
            case 7:
                switch (cardNr){
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconAilment;
                    case 2:
                        return cardIconField;
                    case 3:
                        return cardIconField;
                    case 4:
                        return cardIconField;
                }
            // WORLD 1 LEVEL 8
            case 8:
                switch (cardNr){
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconBoosting;
                    case 2:
                        return cardIconField;
                }
            // WORLD 2 LEVEL 1
            case 9:
                switch (cardNr){
                    case 0:
                        return cardIconAilment;
                    case 1:
                        return cardIconAilment;
                    case 2:
                        return cardIconAilment;
                    case 3:
                        return cardIconBoosting;
                }
            // WORLD 2 LEVEL 2
            case 10:
                switch (cardNr){
                    case 0:
                        return cardIconAilment;
                    case 1:
                        return cardIconAilment;
                    case 2:
                        return cardIconField;
                }
            // WORLD 2 LEVEL 3
            case 11:
                switch (cardNr){
                    case 0:
                        return cardIconField;
                    case 1:
                        return cardIconBoosting;
                    case 2:
                        return cardIconAilment;
                    case 3:
                        return cardIconField;
                    case 4:
                        return cardIconField;
                    case 5:
                        return cardIconAilment;
                }
            // WORLD 2 LEVEL 4
            case 12:
                switch (cardNr){
                    case 0:
                        return cardIconAilment;
                    case 1:
                        return cardIconAilment;
                    case 2:
                        return cardIconAilment;
                    case 3:
                        return cardIconAilment;
                }
            // WORLD 2 LEVEL 5
            case 13:
                switch (cardNr){
                    case 0:
                        return cardIconAilment;
                    case 1:
                        return cardIconAilment;
                    case 2:
                        return cardIconBoosting;
                    case 3:
                        return cardIconField;
                }
            // WORLD 2 LEVEL 6
            case 14:
                switch (cardNr){
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconAilment;
                    case 2:
                        return cardIconField;
                }
            // WORLD 2 LEVEL 7
            case 15:
                switch (cardNr){
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconAilment;
                    case 2:
                        return cardIconField;
                    case 3:
                        return cardIconBoosting;
                }
            // WORLD 2 LEVEL 8
            case 16:
                switch (cardNr){
                    case 0:
                        return cardIconField;
                    case 1:
                        return cardIconField;
                    case 2:
                        return cardIconAilment;
                    case 3:
                        return cardIconBoosting;
                    case 4:
                        return cardIconAilment;
                    case 5:
                        return cardIconAilment;
                }
            // WORLD 3 LEVEL 1
            case 17:
                switch (cardNr){
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconBoosting;
                    case 2:
                        return cardIconField;
                    case 3:
                        return cardIconField;
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
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                }
            // WORLD 1 LEVEL 2
            case 2:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                }
            // WORLD 1 LEVEL 3
            case 3:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                }
            // WORLD 1 LEVEL 4
            case 4:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return cardTypeBoostingTablet;
                        } else {
                            return cardTypeBoosting;
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                }
            // WORLD 1 LEVEL 5
            case 5:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                }
            // WORLD 1 LEVEL 6
            case 6:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return cardTypeBoostingTablet;
                        } else {
                            return cardTypeBoosting;
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                    case 3:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                }
            // WORLD 1 LEVEL 7
            case 7:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return cardTypeBoostingTablet;
                        } else {
                            return cardTypeBoosting;
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                    case 3:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                    case 4:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                }
            // WORLD 1 LEVEL 8
            case 8:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return cardTypeBoostingTablet;
                        } else {
                            return cardTypeBoosting;
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return cardTypeBoostingTablet;
                        } else {
                            return cardTypeBoosting;
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                }
            // WORLD 2 LEVEL 1
            case 9:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                    case 3:
                        if (screenSize.equals("xlarge")){
                            return cardTypeBoostingTablet;
                        } else {
                            return cardTypeBoosting;
                        }
                }
            // WORLD 2 LEVEL 2
            case 10:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                }
            // WORLD 2 LEVEL 3
            case 11:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return cardTypeBoostingTablet;
                        } else {
                            return cardTypeBoosting;
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                    case 3:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                    case 4:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                    case 5:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                }
            // WORLD 2 LEVEL 4
            case 12:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                    case 3:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                }
            // WORLD 2 LEVEL 5
            case 13:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return cardTypeBoostingTablet;
                        } else {
                            return cardTypeBoosting;
                        }
                    case 3:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                }
            // WORLD 2 LEVEL 6
            case 14:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return cardTypeBoostingTablet;
                        } else {
                            return cardTypeBoosting;
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                }
            // WORLD 2 LEVEL 7
            case 15:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return cardTypeBoostingTablet;
                        } else {
                            return cardTypeBoosting;
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                    case 3:
                        if (screenSize.equals("xlarge")){
                            return cardTypeBoostingTablet;
                        } else {
                            return cardTypeBoosting;
                        }
                }
            // WORLD 2 LEVEL 8
            case 16:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                    case 3:
                        if (screenSize.equals("xlarge")){
                            return cardTypeBoostingTablet;
                        } else {
                            return cardTypeBoosting;
                        }
                    case 4:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                    case 5:
                        if (screenSize.equals("xlarge")){
                            return cardTypeAilmentTablet;
                        } else {
                            return cardTypeAilment;
                        }
                }
            // WORLD 3 LEVEL 1
            case 17:
                switch (cardNr){
                    case 0:
                        if (screenSize.equals("xlarge")){
                            return cardTypeBoostingTablet;
                        } else {
                            return cardTypeBoosting;
                        }
                    case 1:
                        if (screenSize.equals("xlarge")){
                            return cardTypeBoostingTablet;
                        } else {
                            return cardTypeBoosting;
                        }
                    case 2:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
                        }
                    case 3:
                        if (screenSize.equals("xlarge")){
                            return cardTypeFieldTablet;
                        } else {
                            return cardTypeField;
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
            // WORLD 2 LEVEL 3
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
            // WORLD 2 LEVEL 4
            case 12:
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
            // WORLD 2 LEVEL 5
            case 13:
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
            // WORLD 2 LEVEL 6
            case 14:
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
            // WORLD 2 LEVEL 7
            case 15:
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
            // WORLD 2 LEVEL 8
            case 16:
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
            // WORLD 3 LEVEL 1
            case 17:
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
        }
        return false;
    }

    public static String getEnemyCardImgName(int levelId, int cardNr){
        switch (levelId){
            // WORLD 1 LEVEL 1
            case 1:
                switch (cardNr){
                    case 0:
                        return Reinforce1ImgPath;
                }
            // WORLD 1 LEVEL 2
            case 2:
                switch (cardNr){
                    case 0:
                        return Reinforce1ImgPath;
                    case 1:
                        return Reinforce2ImgPath;
                }
            // WORLD 1 LEVEL 3
            case 3:
                switch (cardNr){
                    case 0:
                        return Reinforce1ImgPath;
                    case 1:
                        return Reinforce2ImgPath;
                    case 2:
                        return SlowDownImgPath;
                }
            // WORLD 1 LEVEL 4
            case 4:
                switch (cardNr){
                    case 0:
                        return SpeedUpImgPath;
                    case 1:
                        return Reinforce3ImgPath;
                    case 2:
                        return SlowDownImgPath;
                }
            // WORLD 1 LEVEL 5
            case 5:
                switch (cardNr){
                    case 0:
                        return Reinforce2ImgPath;
                    case 1:
                        return Reinforce2ImgPath;
                    case 2:
                        return SlowDownImgPath;
                }
            // WORLD 1 LEVEL 6
            case 6:
                switch (cardNr){
                    case 0:
                        return SpeedUpImgPath;
                    case 1:
                        return SlowDownImgPath;
                    case 2:
                        return SlowDownImgPath;
                    case 3:
                        return Reinforce3ImgPath;
                }
            // WORLD 1 LEVEL 7
            case 7:
                switch (cardNr){
                    case 0:
                        return SpeedUpImgPath;
                    case 1:
                        return SlowDownImgPath;
                    case 2:
                        return Reinforce2ImgPath;
                    case 3:
                        return Reinforce3ImgPath;
                    case 4:
                        return Reinforce2ImgPath;
                }
            // WORLD 1 LEVEL 8
            case 8:
                switch (cardNr){
                    case 0:
                        return SpeedUpImgPath;
                    case 1:
                        return ConcentrateImgPath;
                    case 2:
                        return Steal1ImgPath;
                }
            // WORLD 2 LEVEL 1
            case 9:
                switch (cardNr){
                    case 0:
                        return SlowDownImgPath;
                    case 1:
                        return CorruptionImgPath;
                    case 2:
                        return AgonyImgPath;
                    case 3:
                        return SpeedUpImgPath;
                }
            // WORLD 2 LEVEL 2
            case 10:
                switch (cardNr){
                    case 0:
                        return CorruptionImgPath;
                    case 1:
                        return CurseImgPath;
                    case 2:
                        return Reinforce2ImgPath;
                }
            // WORLD 2 LEVEL 3
            case 11:
                switch (cardNr){
                    case 0:
                        return Steal1ImgPath;
                    case 1:
                        return SpeedUpImgPath;
                    case 2:
                        return AgonyImgPath;
                    case 3:
                        return Reinforce3ImgPath;
                    case 4:
                        return Reinforce3ImgPath;
                    case 5:
                        return CorruptionImgPath;
                }
            // WORLD 2 LEVEL 4
            case 12:
                switch (cardNr){
                    case 0:
                        return AgonyImgPath;
                    case 1:
                        return AgonyImgPath;
                    case 2:
                        return SlowDownImgPath;
                    case 3:
                        return SlowDownImgPath;
                }
            // WORLD 2 LEVEL 5
            case 13:
                switch (cardNr){
                    case 0:
                        return CorruptionImgPath;
                    case 1:
                        return CorruptionImgPath;
                    case 2:
                        return ConcentrateImgPath;
                    case 3:
                        return Reinforce2ImgPath;
                }
            // WORLD 2 LEVEL 6
            case 14:
                switch (cardNr){
                    case 0:
                        return SpeedUpImgPath;
                    case 1:
                        return CurseImgPath;
                    case 2:
                        return Steal2ImgPath;
                }
            // WORLD 2 LEVEL 7
            case 15:
                switch (cardNr){
                    case 0:
                        return ConcentrateImgPath;
                    case 1:
                        return AgonyImgPath;
                    case 2:
                        return Steal1ImgPath;
                    case 3:
                        return MimicImgPath;
                }
            // WORLD 2 LEVEL 8
            case 16:
                switch (cardNr){
                    case 0:
                        return Reinforce3ImgPath;
                    case 1:
                        return Reinforce3ImgPath;
                    case 2:
                        return AgonyImgPath;
                    case 3:
                        return MimicImgPath;
                    case 4:
                        return CurseImgPath;
                    case 5:
                        return CorruptionImgPath;
                }
            // WORLD 3 LEVEL 1
            case 17:
                switch (cardNr){
                    case 0:
                        return ConcentrateImgPath;
                    case 1:
                        return SpeedUpImgPath;
                    case 2:
                        return Steal2ImgPath;
                    case 3:
                        return Steal2ImgPath;
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
                        return Reinforce1CardName;
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
                        return Reinforce1CardName;
                    case 1:
                        return Reinforce2CardName;
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
                        return Reinforce1CardName;
                    case 1:
                        return Reinforce2CardName;
                    case 2:
                        return SlowDownCardName;
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
                        return SpeedUpCardName;
                    case 1:
                        return Reinforce3CardName;
                    case 2:
                        return SlowDownCardName;
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
                        return Reinforce2CardName;
                    case 1:
                        return Reinforce2CardName;
                    case 2:
                        return SlowDownCardName;
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
                        return SpeedUpCardName;
                    case 1:
                        return SlowDownCardName;
                    case 2:
                        return SlowDownCardName;
                    case 3:
                        return Reinforce3CardName;
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
            // WORLD 1 LEVEL 7
            case 7:
                switch (cardNr){
                    case 0:
                        return SpeedUpCardName;
                    case 1:
                        return SlowDownCardName;
                    case 2:
                        return Reinforce2CardName;
                    case 3:
                        return Reinforce3CardName;
                    case 4:
                        return Reinforce2CardName;
                    case 5:
                        return "";
                }
            // WORLD 1 LEVEL 8
            case 8:
                switch (cardNr){
                    case 0:
                        return SpeedUpCardName;
                    case 1:
                        return ConcentrateCardName;
                    case 2:
                        return Steal1ImgPath;
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
                        return SlowDownCardName;
                    case 1:
                        return CorruptionCardName;
                    case 2:
                        return AgonyCardName;
                    case 3:
                        return SpeedUpCardName;
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
            // WORLD 2 LEVEL 2
            case 10:
                switch (cardNr){
                    case 0:
                        return CorruptionCardName;
                    case 1:
                        return CurseCardName;
                    case 2:
                        return Reinforce2CardName;
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
                        return Steal1CardName;
                    case 1:
                        return SpeedUpCardName;
                    case 2:
                        return AgonyCardName;
                    case 3:
                        return Reinforce3CardName;
                    case 4:
                        return Reinforce3CardName;
                    case 5:
                        return CorruptionCardName;
                }
            // WORLD 2 LEVEL 4
            case 12:
                switch (cardNr){
                    case 0:
                        return AgonyCardName;
                    case 1:
                        return AgonyCardName;
                    case 2:
                        return SlowDownCardName;
                    case 3:
                        return SlowDownCardName;
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
            // WORLD 2 LEVEL 5
            case 13:
                switch (cardNr){
                    case 0:
                        return CorruptionCardName;
                    case 1:
                        return CorruptionCardName;
                    case 2:
                        return ConcentrateCardName;
                    case 3:
                        return Reinforce2CardName;
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
            // WORLD 2 LEVEL 6
            case 14:
                switch (cardNr){
                    case 0:
                        return SpeedUpCardName;
                    case 1:
                        return CurseCardName;
                    case 2:
                        return Steal2CardName;
                    case 3:
                        return "";
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
            // WORLD 2 LEVEL 7
            case 15:
                switch (cardNr){
                    case 0:
                        return ConcentrateCardName;
                    case 1:
                        return AgonyCardName;
                    case 2:
                        return Steal1CardName;
                    case 3:
                        return MimicCardName;
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
            // WORLD 2 LEVEL 8
            case 16:
                switch (cardNr){
                    case 0:
                        return Reinforce3CardName;
                    case 1:
                        return Reinforce3CardName;
                    case 2:
                        return AgonyCardName;
                    case 3:
                        return MimicCardName;
                    case 4:
                        return CurseCardName;
                    case 5:
                        return CorruptionCardName;
                }
            // WORLD 3 LEVEL 1
            case 17:
                switch (cardNr){
                    case 0:
                        return ConcentrateCardName;
                    case 1:
                        return SpeedUpCardName;
                    case 2:
                        return Steal2CardName;
                    case 3:
                        return Steal2CardName;
                    case 4:
                        return "";
                    case 5:
                        return "";
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
            // WORLD 2 LEVEL 4
            case 12:
                switch (cardNr){
                    case 0:
                        return 2;
                    case 1:
                        return 2;
                    case 2:
                        return 1;
                    case 3:
                        return 1;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
            // WORLD 2 LEVEL 5
            case 13:
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
            // WORLD 2 LEVEL 6
            case 14:
                switch (cardNr){
                    case 0:
                        return 1;
                    case 1:
                        return 2;
                    case 2:
                        return 2;
                    case 3:
                        return 0;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
            // WORLD 2 LEVEL 7
            case 15:
                switch (cardNr){
                    case 0:
                        return 1;
                    case 1:
                        return 2;
                    case 2:
                        return 1;
                    case 3:
                        return 2;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
            // WORLD 2 LEVEL 8
            case 16:
                switch (cardNr){
                    case 0:
                        return 1;
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 3:
                        return 2;
                    case 4:
                        return 2;
                    case 5:
                        return 2;
                }
            // WORLD 3 LEVEL 1
            case 17:
                switch (cardNr){
                    case 0:
                        return 1;
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 3:
                        return 2;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
        }
        return 0;
    }

}
