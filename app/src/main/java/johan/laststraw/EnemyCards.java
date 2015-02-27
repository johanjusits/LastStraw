package johan.laststraw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Johan on 2015-01-07.
 */
public class EnemyCards {

    public static int genRand(int number) {
        return new Random().nextInt(number);
    }

    // VARIABLES FOR RANDOMIZING ENEMY CARDS
    static int totalCards = 30;
    static boolean cardAdded = false;

    static int field = 1;
    static int ailment = 2;
    static int boosting = 3;

    static int card1Type;
    static int card2Type;
    static int card3Type;
    static int card4Type;
    static int card5Type;
    static int card6Type;

    static String card1Name;
    static String card2Name;
    static String card3Name;
    static String card4Name;
    static String card5Name;
    static String card6Name;

    // CARD ICONS & TYPES
    static String cardIconField = "card_icon_field";
    static String cardIconAilment = "card_icon_ailment";
    static String cardIconBoosting = "card_icon_boosting";
    static String cardTypeField = "card_type_field";
    static String cardTypeAilment = "card_type_ailment";
    static String cardTypeBoosting = "card_type_boosting";

    // CARD IMAGE NAMES
    static String Reinforce3ImgPath = "card_obj_plus_3";
    static String Reinforce5ImgPath = "card_obj_plus_5";
    static String SpeedUpImgPath = "card_speed_up";
    static String SpeedUp2ImgPath = "card_speed_up_2";
    static String SlowDownImgPath = "card_slowdown";
    static String Leech1ImgPath = "card_leech";
    static String ConcentrateImgPath = "card_concentrate";
    static String CorruptionImgPath = "card_corruption";
    static String AgonyImgPath = "card_agony";
    static String CurseImgPath = "card_curse";
    static String Leech2ImgPath = "card_leech_2";
    static String MimicImgPath = "card_mimic";
    static String CureImgPath = "card_cure";
    static String InfestImgPath = "card_infest";
    static String ProtectImgPath = "card_protect";
    static String SalvageImgPath = "card_salvage";
    static String SilenceImgPath = "card_silence";
    static String ChargeImgPath = "card_charge";
    static String DemonicPrayerImgPath = "card_demonic_prayer";
    static String TakeAimImgPath = "card_take_aim";
    static String BlindImgPath = "card_blind";
    static String DispelImgPath = "card_dispel";
    static String DeathSentenceImgPath = "card_death_sentence";
    static String MaledictionImgPath = "card_malediction";
    static String Leech3ImgPath = "card_leech_3";
    static String RewindImgPath = "card_rewind";
    static String HoardImgPath = "card_hoard";
    static String RestoreImgPath = "card_restore";
    static String ConfuseImgPath = "card_confuse";
    static String PrecisionImgPath = "card_precision";

    // CARD NAMES
    static String Reinforce3CardName = "Reinforce III";
    static String Reinforce5CardName = "Reinforce V";
    static String SpeedUpCardName = "Speed Up";
    static String SpeedUp2CardName = "Speed Up II";
    static String SlowDownCardName = "Slow Down";
    static String Leech1CardName = "Leech";
    static String ConcentrateCardName = "Concentrate";
    static String CorruptionCardName = "Corruption";
    static String AgonyCardName = "Agony";
    static String CurseCardName = "Curse";
    static String Leech2CardName = "Leech II";
    static String MimicCardName = "Mimic";
    static String CureCardName = "Cure";
    static String InfestCardName = "Infest";
    static String ProtectCardName = "Protect";
    static String SalvageCardName = "Salvage";
    static String SilenceCardName = "Silence";
    static String ChargeCardName = "Charge";
    static String DemonicPrayerCardName = "Demonic Prayer";
    static String TakeAimCardName = "Take Aim";
    static String BlindCardName = "Blind";
    static String DispelCardName = "Dispel";
    static String DeathSentenceCardName = "Death Sentence";
    static String MaledictionCardName = "Malediction";
    static String Leech3CardName = "Leech III";
    static String RewindCardName = "Rewind";
    static String HoardCardName = "Hoard";
    static String RestoreCardName = "Restore";
    static String ConfuseCardName = "Confuse";
    static String PrecisionCardName = "Precision";

    // CARD COSTS
    static int Reinforce3CardCost = 0;
    static int Reinforce5CardCost = 1;
    static int SpeedUpCardCost = 0;
    static int SpeedUp2CardCost = 1;
    static int SlowDownCardCost = 1;
    static int Leech1CardCost = 1;
    static int ConcentrateCardCost = 1;
    static int CorruptionCardCost = 1;
    static int AgonyCardCost = 2;
    static int CurseCardCost = 2;
    static int Leech2CardCost = 2;
    static int MimicCardCost = 1;
    static int CureCardCost = 1;
    static int InfestCardCost = 1;
    static int ProtectCardCost = 0;
    static int SalvageCardCost = 1;
    static int SilenceCardCost = 1;
    static int ChargeCardCost = 1;
    static int TakeAimCardCost = 0;
    static int BlindCardCost = 1;
    static int DispelCardCost = 1;
    static int RestoreCardCost = 1;
    static int DeathSentenceCardCost = 2;
    static int HoardCardCost = 1;
    static int ConfuseCardCost = 2;
    static int Leech3CardCost = 3;
    static int MaledictionCardCost = 3;
    static int RewindCardCost = 0;
    static int DemonicPrayerCardCost = 0;
    static int PrecisionCardCost = 1;

    public static String randomCard(int cardNr){
        int newCard = genRand(totalCards);
        System.out.println("cardNr: " + String.valueOf(cardNr) + " newCard Nr: " + String.valueOf(newCard));
        switch (newCard){
            case 0:
                switch (cardNr){
                    case 0:
                        card1Type = field;
                    case 1:
                        card2Type = field;
                    case 2:
                        card3Type = field;
                    case 3:
                        card4Type = field;
                    case 4:
                        card5Type = field;
                    case 5:
                        card6Type = field;
                }
                return Reinforce3CardName;
            case 1:
                switch (cardNr){
                    case 0:
                        card1Type = field;
                    case 1:
                        card2Type = field;
                    case 2:
                        card3Type = field;
                    case 3:
                        card4Type = field;
                    case 4:
                        card5Type = field;
                    case 5:
                        card6Type = field;
                }
                return Reinforce5CardName;
            case 2:
                switch (cardNr){
                    case 0:
                        card1Type = boosting;
                    case 1:
                        card2Type = boosting;
                    case 2:
                        card3Type = boosting;
                    case 3:
                        card4Type = boosting;
                    case 4:
                        card5Type = boosting;
                    case 5:
                        card6Type = boosting;
                }
                return SpeedUpCardName;
            case 3:
                switch (cardNr){
                    case 0:
                        card1Type = boosting;
                    case 1:
                        card2Type = boosting;
                    case 2:
                        card3Type = boosting;
                    case 3:
                        card4Type = boosting;
                    case 4:
                        card5Type = boosting;
                    case 5:
                        card6Type = boosting;
                }
                return SpeedUp2CardName;
            case 4:
                switch (cardNr){
                    case 0:
                        card1Type = ailment;
                    case 1:
                        card2Type = ailment;
                    case 2:
                        card3Type = ailment;
                    case 3:
                        card4Type = ailment;
                    case 4:
                        card5Type = ailment;
                    case 5:
                        card6Type = ailment;
                }
                return SlowDownCardName;
            case 5:
                switch (cardNr){
                    case 0:
                        card1Type = field;
                    case 1:
                        card2Type = field;
                    case 2:
                        card3Type = field;
                    case 3:
                        card4Type = field;
                    case 4:
                        card5Type = field;
                    case 5:
                        card6Type = field;
                }
                return Leech1CardName;
            case 6:
                switch (cardNr){
                    case 0:
                        card1Type = boosting;
                    case 1:
                        card2Type = boosting;
                    case 2:
                        card3Type = boosting;
                    case 3:
                        card4Type = boosting;
                    case 4:
                        card5Type = boosting;
                    case 5:
                        card6Type = boosting;
                }
                return ConcentrateCardName;
            case 7:
                switch (cardNr){
                    case 0:
                        card1Type = ailment;
                    case 1:
                        card2Type = ailment;
                    case 2:
                        card3Type = ailment;
                    case 3:
                        card4Type = ailment;
                    case 4:
                        card5Type = ailment;
                    case 5:
                        card6Type = ailment;
                }
                return CorruptionCardName;
            case 8:
                switch (cardNr){
                    case 0:
                        card1Type = ailment;
                    case 1:
                        card2Type = ailment;
                    case 2:
                        card3Type = ailment;
                    case 3:
                        card4Type = ailment;
                    case 4:
                        card5Type = ailment;
                    case 5:
                        card6Type = ailment;
                }
                return AgonyCardName;
            case 9:
                switch (cardNr){
                    case 0:
                        card1Type = ailment;
                    case 1:
                        card2Type = ailment;
                    case 2:
                        card3Type = ailment;
                    case 3:
                        card4Type = ailment;
                    case 4:
                        card5Type = ailment;
                    case 5:
                        card6Type = ailment;
                }
                return CurseCardName;
            case 10:
                switch (cardNr){
                    case 0:
                        card1Type = field;
                    case 1:
                        card2Type = field;
                    case 2:
                        card3Type = field;
                    case 3:
                        card4Type = field;
                    case 4:
                        card5Type = field;
                    case 5:
                        card6Type = field;
                }
                return Leech2CardName;
            case 11:
                switch (cardNr){
                    case 0:
                        card1Type = boosting;
                    case 1:
                        card2Type = boosting;
                    case 2:
                        card3Type = boosting;
                    case 3:
                        card4Type = boosting;
                    case 4:
                        card5Type = boosting;
                    case 5:
                        card6Type = boosting;
                }
                return MimicCardName;
            case 12:
                switch (cardNr){
                    case 0:
                        card1Type = boosting;
                    case 1:
                        card2Type = boosting;
                    case 2:
                        card3Type = boosting;
                    case 3:
                        card4Type = boosting;
                    case 4:
                        card5Type = boosting;
                    case 5:
                        card6Type = boosting;
                }
                return CureCardName;
            case 13:
                switch (cardNr){
                    case 0:
                        card1Type = field;
                    case 1:
                        card2Type = field;
                    case 2:
                        card3Type = field;
                    case 3:
                        card4Type = field;
                    case 4:
                        card5Type = field;
                    case 5:
                        card6Type = field;
                }
                return InfestCardName;
            case 14:
                switch (cardNr){
                    case 0:
                        card1Type = boosting;
                    case 1:
                        card2Type = boosting;
                    case 2:
                        card3Type = boosting;
                    case 3:
                        card4Type = boosting;
                    case 4:
                        card5Type = boosting;
                    case 5:
                        card6Type = boosting;
                }
                return ProtectCardName;
            case 15:
                switch (cardNr){
                    case 0:
                        card1Type = field;
                    case 1:
                        card2Type = field;
                    case 2:
                        card3Type = field;
                    case 3:
                        card4Type = field;
                    case 4:
                        card5Type = field;
                    case 5:
                        card6Type = field;
                }
                return SalvageCardName;
            case 16:
                switch (cardNr){
                    case 0:
                        card1Type = ailment;
                    case 1:
                        card2Type = ailment;
                    case 2:
                        card3Type = ailment;
                    case 3:
                        card4Type = ailment;
                    case 4:
                        card5Type = ailment;
                    case 5:
                        card6Type = ailment;
                }
                return SilenceCardName;
            case 17:
                switch (cardNr){
                    case 0:
                        card1Type = boosting;
                    case 1:
                        card2Type = boosting;
                    case 2:
                        card3Type = boosting;
                    case 3:
                        card4Type = boosting;
                    case 4:
                        card5Type = boosting;
                    case 5:
                        card6Type = boosting;
                }
                return ChargeCardName;
            case 18:
                switch (cardNr){
                    case 0:
                        card1Type = boosting;
                    case 1:
                        card2Type = boosting;
                    case 2:
                        card3Type = boosting;
                    case 3:
                        card4Type = boosting;
                    case 4:
                        card5Type = boosting;
                    case 5:
                        card6Type = boosting;
                }
                return TakeAimCardName;
            case 19:
                switch (cardNr){
                    case 0:
                        card1Type = ailment;
                    case 1:
                        card2Type = ailment;
                    case 2:
                        card3Type = ailment;
                    case 3:
                        card4Type = ailment;
                    case 4:
                        card5Type = ailment;
                    case 5:
                        card6Type = ailment;
                }
                return BlindCardName;
            case 20:
                switch (cardNr){
                    case 0:
                        card1Type = ailment;
                    case 1:
                        card2Type = ailment;
                    case 2:
                        card3Type = ailment;
                    case 3:
                        card4Type = ailment;
                    case 4:
                        card5Type = ailment;
                    case 5:
                        card6Type = ailment;
                }
                return DispelCardName;
            case 21:
                switch (cardNr){
                    case 0:
                        card1Type = field;
                    case 1:
                        card2Type = field;
                    case 2:
                        card3Type = field;
                    case 3:
                        card4Type = field;
                    case 4:
                        card5Type = field;
                    case 5:
                        card6Type = field;
                }
                return RestoreCardName;
            case 22:
                switch (cardNr){
                    case 0:
                        card1Type = ailment;
                    case 1:
                        card2Type = ailment;
                    case 2:
                        card3Type = ailment;
                    case 3:
                        card4Type = ailment;
                    case 4:
                        card5Type = ailment;
                    case 5:
                        card6Type = ailment;
                }
                return DeathSentenceCardName;
            case 23:
                switch (cardNr){
                    case 0:
                        card1Type = boosting;
                    case 1:
                        card2Type = boosting;
                    case 2:
                        card3Type = boosting;
                    case 3:
                        card4Type = boosting;
                    case 4:
                        card5Type = boosting;
                    case 5:
                        card6Type = boosting;
                }
                return HoardCardName;
            case 24:
                switch (cardNr){
                    case 0:
                        card1Type = ailment;
                    case 1:
                        card2Type = ailment;
                    case 2:
                        card3Type = ailment;
                    case 3:
                        card4Type = ailment;
                    case 4:
                        card5Type = ailment;
                    case 5:
                        card6Type = ailment;
                }
                return ConfuseCardName;
            case 25:
                switch (cardNr){
                    case 0:
                        card1Type = field;
                    case 1:
                        card2Type = field;
                    case 2:
                        card3Type = field;
                    case 3:
                        card4Type = field;
                    case 4:
                        card5Type = field;
                    case 5:
                        card6Type = field;
                }
                return Leech3CardName;
            case 26:
                switch (cardNr){
                    case 0:
                        card1Type = ailment;
                    case 1:
                        card2Type = ailment;
                    case 2:
                        card3Type = ailment;
                    case 3:
                        card4Type = ailment;
                    case 4:
                        card5Type = ailment;
                    case 5:
                        card6Type = ailment;
                }
                return MaledictionCardName;
            case 27:
                switch (cardNr){
                    case 0:
                        card1Type = boosting;
                    case 1:
                        card2Type = boosting;
                    case 2:
                        card3Type = boosting;
                    case 3:
                        card4Type = boosting;
                    case 4:
                        card5Type = boosting;
                    case 5:
                        card6Type = boosting;
                }
                return RewindCardName;
            case 28:
                switch (cardNr){
                    case 0:
                        card1Type = ailment;
                    case 1:
                        card2Type = ailment;
                    case 2:
                        card3Type = ailment;
                    case 3:
                        card4Type = ailment;
                    case 4:
                        card5Type = ailment;
                    case 5:
                        card6Type = ailment;
                }
                return DemonicPrayerCardName;
            case 29:
                switch (cardNr){
                    case 0:
                        card1Type = boosting;
                    case 1:
                        card2Type = boosting;
                    case 2:
                        card3Type = boosting;
                    case 3:
                        card4Type = boosting;
                    case 4:
                        card5Type = boosting;
                    case 5:
                        card6Type = boosting;
                }
                return PrecisionCardName;
        }
        System.out.println("Här");
        return "";
    }

    public static String setEnemyRandomCardIcon(int cardType){
        switch (cardType){
            case 1:
                return cardIconField;
            case 2:
                return cardIconAilment;
            case 3:
                return cardIconBoosting;
        }
        return "";
    }

    public static String setEnemyRandomCardType(int cardType){
        switch (cardType){
            case 1:
                return cardTypeField;
            case 2:
                return cardTypeAilment;
            case 3:
                return cardTypeBoosting;
        }
        return "";
    }

    public static String setEnemyRandomCardName(int cardNr, ArrayList<String> enemyCardsArray){
        do {
            String newCard = randomCard(cardNr);
            int occurrences = Collections.frequency(enemyCardsArray, newCard);
            if (occurrences < 2){
                cardAdded = true;
                switch (cardNr){
                    case 0:
                        card1Name = newCard;
                        //System.out.println("card1Name: " + card1Name);
                        break;
                    case 1:
                        card2Name = newCard;
                        //System.out.println("card2Name: " + card2Name);
                        break;
                    case 2:
                        card3Name = newCard;
                        //System.out.println("card3Name: " + card3Name);
                        break;
                    case 3:
                        card4Name = newCard;
                        //System.out.println("card4Name: " + card4Name);
                        break;
                    case 4:
                        card5Name = newCard;
                        //System.out.println("card5Name: " + card5Name);
                        break;
                    case 5:
                        card6Name = newCard;
                        //System.out.println("card6Name: " + card6Name);
                        break;
                }
                return newCard;
            }
        } while (!cardAdded);
        return "";
    }

    public static String setRandomCardImg(String cardName){
        if (cardName.equals(Reinforce3CardName)){
            return Reinforce3ImgPath;
        }
        if (cardName.equals(Reinforce5CardName)){
            return Reinforce5ImgPath;
        }
        if (cardName.equals(SpeedUpCardName)){
            return SpeedUpImgPath;
        }
        if (cardName.equals(SpeedUp2CardName)){
            return SpeedUp2ImgPath;
        }
        if (cardName.equals(SlowDownCardName)){
            return SlowDownImgPath;
        }
        if (cardName.equals(Leech1CardName)){
            return Leech1ImgPath;
        }
        if (cardName.equals(ConcentrateCardName)){
            return ConcentrateImgPath;
        }
        if (cardName.equals(CorruptionCardName)){
            return CorruptionImgPath;
        }
        if (cardName.equals(AgonyCardName)){
            return AgonyImgPath;
        }
        if (cardName.equals(CurseCardName)){
            return CurseImgPath;
        }
        if (cardName.equals(Leech2CardName)){
            return Leech2ImgPath;
        }
        if (cardName.equals(MimicCardName)){
            return MimicImgPath;
        }
        if (cardName.equals(CureCardName)){
            return CureImgPath;
        }
        if (cardName.equals(InfestCardName)){
            return InfestImgPath;
        }
        if (cardName.equals(ProtectCardName)){
            return ProtectImgPath;
        }
        if (cardName.equals(SalvageCardName)){
            return SalvageImgPath;
        }
        if (cardName.equals(SilenceCardName)){
            return SilenceImgPath;
        }
        if (cardName.equals(ChargeCardName)){
            return ChargeImgPath;
        }
        if (cardName.equals(TakeAimCardName)){
            return TakeAimImgPath;
        }
        if (cardName.equals(BlindCardName)){
            return BlindImgPath;
        }
        if (cardName.equals(DispelCardName)){
            return DispelImgPath;
        }
        if (cardName.equals(RestoreCardName)){
            return RestoreImgPath;
        }
        if (cardName.equals(DeathSentenceCardName)){
            return DeathSentenceImgPath;
        }
        if (cardName.equals(HoardCardName)){
            return HoardImgPath;
        }
        if (cardName.equals(ConfuseCardName)){
            return ConfuseImgPath;
        }
        if (cardName.equals(Leech3CardName)){
            return Leech3ImgPath;
        }
        if (cardName.equals(MaledictionCardName)){
            return MaledictionImgPath;
        }
        if (cardName.equals(RewindCardName)){
            return RewindImgPath;
        }
        if (cardName.equals(DemonicPrayerCardName)){
            return DemonicPrayerImgPath;
        }
        if (cardName.equals(PrecisionCardName)){
            return PrecisionImgPath;
        }
        return "";
    }

    public static int setRandomCardCost(String cardName){
        if (cardName.equals(Reinforce3CardName)){
            return Reinforce3CardCost;
        }
        if (cardName.equals(Reinforce5CardName)){
            return Reinforce5CardCost;
        }
        if (cardName.equals(SpeedUpCardName)){
            return SpeedUpCardCost;
        }
        if (cardName.equals(SpeedUp2CardName)){
            return SpeedUp2CardCost;
        }
        if (cardName.equals(SlowDownCardName)){
            return SlowDownCardCost;
        }
        if (cardName.equals(Leech1CardName)){
            return Leech1CardCost;
        }
        if (cardName.equals(ConcentrateCardName)){
            return ConcentrateCardCost;
        }
        if (cardName.equals(CorruptionCardName)){
            return CorruptionCardCost;
        }
        if (cardName.equals(AgonyCardName)){
            return AgonyCardCost;
        }
        if (cardName.equals(CurseCardName)){
            return CurseCardCost;
        }
        if (cardName.equals(Leech2CardName)){
            return Leech2CardCost;
        }
        if (cardName.equals(MimicCardName)){
            return MimicCardCost;
        }
        if (cardName.equals(CureCardName)){
            return CureCardCost;
        }
        if (cardName.equals(InfestCardName)){
            return InfestCardCost;
        }
        if (cardName.equals(ProtectCardName)){
            return ProtectCardCost;
        }
        if (cardName.equals(SalvageCardName)){
            return SalvageCardCost;
        }
        if (cardName.equals(SilenceCardName)){
            return SilenceCardCost;
        }
        if (cardName.equals(ChargeCardName)){
            return ChargeCardCost;
        }
        if (cardName.equals(TakeAimCardName)){
            return TakeAimCardCost;
        }
        if (cardName.equals(BlindCardName)){
            return BlindCardCost;
        }
        if (cardName.equals(DispelCardName)){
            return DispelCardCost;
        }
        if (cardName.equals(RestoreCardName)){
            return RestoreCardCost;
        }
        if (cardName.equals(DeathSentenceCardName)){
            return DeathSentenceCardCost;
        }
        if (cardName.equals(HoardCardName)){
            return HoardCardCost;
        }
        if (cardName.equals(ConfuseCardName)){
            return ConfuseCardCost;
        }
        if (cardName.equals(Leech3CardName)){
            return Leech3CardCost;
        }
        if (cardName.equals(MaledictionCardName)){
            return MaledictionCardCost;
        }
        if (cardName.equals(RewindCardName)){
            return RewindCardCost;
        }
        if (cardName.equals(DemonicPrayerCardName)){
            return DemonicPrayerCardCost;
        }
        if (cardName.equals(PrecisionCardName)){
            return PrecisionCardCost;
        }
        return 0;
    }

    public static int getEnemyTotalCards(int levelId) {
        switch (levelId) {
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
                return 4;
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
            case 18:
                return 4;
            case 19:
                return 6;
            case 20:
                return 6;
            case 21:
                return 3;
            case 22:
                return 5;
            case 23:
                return 6;
            case 24:
                return 6;
            //WORLD 004
            case 25:
                return 6;
            case 26:
                return 6;
            case 27:
                return 6;
            case 28:
                return 6;
            case 29:
                return 6;
            case 30:
                return 6;
            case 31:
                return 6;
            case 32:
                return 6;
            //WORLD 005
            case 33:
                return 6;
            case 34:
                return 6;
            case 35:
                return 6;
            case 36:
                return 6;
            case 37:
                return 6;
            case 38:
                return 6;
            case 39:
                return 6;
            case 40:
                return 6;
            //WORLD 006
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
                return 6;
        }
        return 0;
    }

    public static String getEnemyCardIconName(int levelId, int cardNr) {
        switch (levelId) {
            // WORLD 1 LEVEL 1
            case 1:
                switch (cardNr) {
                    case 0:
                        return cardIconField;
                }
                // WORLD 1 LEVEL 2
            case 2:
                switch (cardNr) {
                    case 0:
                        return cardIconField;
                    case 1:
                        return cardIconField;
                }
                // WORLD 1 LEVEL 3
            case 3:
                switch (cardNr) {
                    case 0:
                        return cardIconField;
                    case 1:
                        return cardIconField;
                    case 2:
                        return cardIconAilment;
                }
                // WORLD 1 LEVEL 4
            case 4:
                switch (cardNr) {
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconField;
                    case 2:
                        return cardIconAilment;
                }
                // WORLD 1 LEVEL 5
            case 5:
                switch (cardNr) {
                    case 0:
                        return cardIconField;
                    case 1:
                        return cardIconField;
                    case 2:
                        return cardIconAilment;
                }
                // WORLD 1 LEVEL 6
            case 6:
                switch (cardNr) {
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
                switch (cardNr) {
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconAilment;
                    case 2:
                        return cardIconField;
                    case 3:
                        return cardIconField;
                }
                // WORLD 1 LEVEL 8
            case 8:
                switch (cardNr) {
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconBoosting;
                    case 2:
                        return cardIconField;
                }
                // WORLD 2 LEVEL 1
            case 9:
                switch (cardNr) {
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
                switch (cardNr) {
                    case 0:
                        return cardIconAilment;
                    case 1:
                        return cardIconAilment;
                    case 2:
                        return cardIconField;
                }
                // WORLD 2 LEVEL 3
            case 11:
                switch (cardNr) {
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
                switch (cardNr) {
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
                switch (cardNr) {
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
                switch (cardNr) {
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconAilment;
                    case 2:
                        return cardIconField;
                }
                // WORLD 2 LEVEL 7
            case 15:
                switch (cardNr) {
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
                switch (cardNr) {
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
                switch (cardNr) {
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconBoosting;
                    case 2:
                        return cardIconField;
                    case 3:
                        return cardIconField;
                }
                // WORLD 3 LEVEL 2
            case 18:
                switch (cardNr) {
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconAilment;
                    case 2:
                        return cardIconField;
                    case 3:
                        return cardIconField;
                }
                // WORLD 3 LEVEL 3
            case 19:
                switch (cardNr) {
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconField;
                    case 2:
                        return cardIconBoosting;
                    case 3:
                        return cardIconField;
                    case 4:
                        return cardIconAilment;
                    case 5:
                        return cardIconBoosting;
                }
                // WORLD 3 LEVEL 4
            case 20:
                switch (cardNr) {
                    case 0:
                        return cardIconField;
                    case 1:
                        return cardIconField;
                    case 2:
                        return cardIconBoosting;
                    case 3:
                        return cardIconBoosting;
                    case 4:
                        return cardIconBoosting;
                    case 5:
                        return cardIconBoosting;
                }
                // WORLD 3 LEVEL 5
            case 21:
                switch (cardNr) {
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconAilment;
                    case 2:
                        return cardIconBoosting;
                }
                // WORLD 3 LEVEL 6
            case 22:
                switch (cardNr) {
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconAilment;
                    case 2:
                        return cardIconBoosting;
                    case 3:
                        return cardIconBoosting;
                    case 4:
                        return cardIconField;
                }
                // WORLD 3 LEVEL 7
            case 23:
                switch (cardNr) {
                    case 0:
                        return cardIconField;
                    case 1:
                        return cardIconBoosting;
                    case 2:
                        return cardIconAilment;
                    case 3:
                        return cardIconAilment;
                    case 4:
                        return cardIconAilment;
                    case 5:
                        return cardIconBoosting;
                }
                // WORLD 3 LEVEL 8
            case 24:
                switch (cardNr) {
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconBoosting;
                    case 2:
                        return cardIconBoosting;
                    case 3:
                        return cardIconBoosting;
                    case 4:
                        return cardIconBoosting;
                    case 5:
                        return cardIconBoosting;
                }
                // WORLD 4 LEVEL 1
            case 25:
                switch (cardNr) {
                    case 0:
                        return cardIconAilment;
                    case 1:
                        return cardIconAilment;
                    case 2:
                        return cardIconField;
                    case 3:
                        return cardIconField;
                    case 4:
                        return cardIconField;
                    case 5:
                        return cardIconBoosting;
                }
                // WORLD 4 LEVEL 2
            case 26:
                switch (cardNr) {
                    case 0:
                        return cardIconField;
                    case 1:
                        return cardIconBoosting;
                    case 2:
                        return cardIconBoosting;
                    case 3:
                        return cardIconField;
                    case 4:
                        return cardIconAilment;
                    case 5:
                        return cardIconField;
                }
                // WORLD 4 LEVEL 3
            case 27:
                switch (cardNr) {
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconBoosting;
                    case 2:
                        return cardIconBoosting;
                    case 3:
                        return cardIconBoosting;
                    case 4:
                        return cardIconAilment;
                    case 5:
                        return cardIconField;
                }
                // WORLD 4 LEVEL 4
            case 28:
                switch (cardNr) {
                    case 0:
                        return cardIconAilment;
                    case 1:
                        return cardIconAilment;
                    case 2:
                        return cardIconBoosting;
                    case 3:
                        return cardIconField;
                    case 4:
                        return cardIconBoosting;
                    case 5:
                        return cardIconAilment;
                }
                // WORLD 4 LEVEL 5
            case 29:
                switch (cardNr) {
                    case 0:
                        return cardIconField;
                    case 1:
                        return cardIconField;
                    case 2:
                        return cardIconBoosting;
                    case 3:
                        return cardIconBoosting;
                    case 4:
                        return cardIconField;
                    case 5:
                        return cardIconBoosting;
                }
                // WORLD 4 LEVEL 6
            case 30:
                switch (cardNr) {
                    case 0:
                        return cardIconAilment;
                    case 1:
                        return cardIconField;
                    case 2:
                        return cardIconAilment;
                    case 3:
                        return cardIconBoosting;
                    case 4:
                        return cardIconField;
                    case 5:
                        return cardIconBoosting;
                }
                // WORLD 4 LEVEL 7
            case 31:
                switch (cardNr) {
                    case 0:
                        return cardIconAilment;
                    case 1:
                        return cardIconAilment;
                    case 2:
                        return cardIconAilment;
                    case 3:
                        return cardIconBoosting;
                    case 4:
                        return cardIconBoosting;
                    case 5:
                        return cardIconField;
                }
                // WORLD 4 LEVEL 8
            case 32:
                switch (cardNr) {
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconBoosting;
                    case 2:
                        return cardIconAilment;
                    case 3:
                        return cardIconField;
                    case 4:
                        return cardIconField;
                    case 5:
                        return cardIconField;
                }
                // WORLD 5 LEVEL 1
            case 33:
                switch (cardNr) {
                    case 0:
                        return cardIconAilment;
                    case 1:
                        return cardIconAilment;
                    case 2:
                        return cardIconField;
                    case 3:
                        return cardIconBoosting;
                    case 4:
                        return cardIconAilment;
                    case 5:
                        return cardIconAilment;
                }
                // WORLD 5 LEVEL 2
            case 34:
                switch (cardNr) {
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconField;
                    case 2:
                        return cardIconField;
                    case 3:
                        return cardIconBoosting;
                    case 4:
                        return cardIconField;
                    case 5:
                        return cardIconAilment;
                }
                // WORLD 5 LEVEL 3
            case 35:
                switch (cardNr) {
                    case 0:
                        return cardIconAilment;
                    case 1:
                        return cardIconBoosting;
                    case 2:
                        return cardIconField;
                    case 3:
                        return cardIconBoosting;
                    case 4:
                        return cardIconBoosting;
                    case 5:
                        return cardIconAilment;
                }
                // WORLD 5 LEVEL 4
            case 36:
                switch (cardNr) {
                    case 0:
                        return cardIconAilment;
                    case 1:
                        return cardIconAilment;
                    case 2:
                        return cardIconAilment;
                    case 3:
                        return cardIconAilment;
                    case 4:
                        return cardIconAilment;
                    case 5:
                        return cardIconAilment;
                }
                // WORLD 5 LEVEL 5
            case 37:
                switch (cardNr) {
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconAilment;
                    case 2:
                        return cardIconBoosting;
                    case 3:
                        return cardIconAilment;
                    case 4:
                        return cardIconBoosting;
                    case 5:
                        return cardIconAilment;
                }
                // WORLD 5 LEVEL 6
            case 38:
                switch (cardNr) {
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconBoosting;
                    case 2:
                        return cardIconField;
                    case 3:
                        return cardIconAilment;
                    case 4:
                        return cardIconAilment;
                    case 5:
                        return cardIconBoosting;
                }
                // WORLD 5 LEVEL 7
            case 39:
                switch (cardNr) {
                    case 0:
                        return cardIconField;
                    case 1:
                        return cardIconField;
                    case 2:
                        return cardIconBoosting;
                    case 3:
                        return cardIconBoosting;
                    case 4:
                        return cardIconAilment;
                    case 5:
                        return cardIconBoosting;
                }
                // WORLD 5 LEVEL 8
            case 40:
                switch (cardNr) {
                    case 0:
                        return cardIconBoosting;
                    case 1:
                        return cardIconAilment;
                    case 2:
                        return cardIconField;
                    case 3:
                        return cardIconBoosting;
                    case 4:
                        return cardIconAilment;
                    case 5:
                        return cardIconAilment;
                }
                // WORLD 6
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
                switch (cardNr) {
                    case 0:
                        return setEnemyRandomCardIcon(card1Type);
                    case 1:
                        return setEnemyRandomCardIcon(card2Type);
                    case 2:
                        return setEnemyRandomCardIcon(card3Type);
                    case 3:
                        return setEnemyRandomCardIcon(card4Type);
                    case 4:
                        return setEnemyRandomCardIcon(card5Type);
                    case 5:
                        return setEnemyRandomCardIcon(card6Type);
                }
        }
        return "";
    }

    public static String getEnemyCardTypeName(int levelId, int cardNr) {
        switch (levelId) {
            // WORLD 1 LEVEL 1
            case 1:
                switch (cardNr) {
                    case 0:
                        return cardTypeField;
                }
                // WORLD 1 LEVEL 2
            case 2:
                switch (cardNr) {
                    case 0:
                        return cardTypeField;
                    case 1:
                        return cardTypeField;
                }
                // WORLD 1 LEVEL 3
            case 3:
                switch (cardNr) {
                    case 0:
                        return cardTypeField;
                    case 1:
                        return cardTypeField;
                    case 2:
                        return cardTypeAilment;
                }
                // WORLD 1 LEVEL 4
            case 4:
                switch (cardNr) {
                    case 0:
                        return cardTypeBoosting;
                    case 1:
                        return cardTypeField;
                    case 2:
                        return cardTypeAilment;
                }
                // WORLD 1 LEVEL 5
            case 5:
                switch (cardNr) {
                    case 0:
                        return cardTypeField;
                    case 1:
                        return cardTypeField;
                    case 2:
                        return cardTypeAilment;
                }
                // WORLD 1 LEVEL 6
            case 6:
                switch (cardNr) {
                    case 0:
                        return cardTypeBoosting;
                    case 1:
                        return cardTypeAilment;
                    case 2:
                        return cardTypeAilment;
                    case 3:
                        return cardTypeField;
                }
                // WORLD 1 LEVEL 7
            case 7:
                switch (cardNr) {
                    case 0:
                        return cardTypeBoosting;
                    case 1:
                        return cardTypeAilment;
                    case 2:
                        return cardTypeField;
                    case 3:
                        return cardTypeField;
                }
                // WORLD 1 LEVEL 8
            case 8:
                switch (cardNr) {
                    case 0:
                        return cardTypeBoosting;
                    case 1:
                        return cardTypeBoosting;
                    case 2:
                        return cardTypeField;
                }
                // WORLD 2 LEVEL 1
            case 9:
                switch (cardNr) {
                    case 0:
                        return cardTypeAilment;
                    case 1:
                        return cardTypeAilment;
                    case 2:
                        return cardTypeAilment;
                    case 3:
                        return cardTypeBoosting;
                }
                // WORLD 2 LEVEL 2
            case 10:
                switch (cardNr) {
                    case 0:
                        return cardTypeAilment;
                    case 1:
                        return cardTypeAilment;
                    case 2:
                        return cardTypeField;
                }
                // WORLD 2 LEVEL 3
            case 11:
                switch (cardNr) {
                    case 0:
                        return cardTypeField;
                    case 1:
                        return cardTypeBoosting;
                    case 2:
                        return cardTypeAilment;
                    case 3:
                        return cardTypeField;
                    case 4:
                        return cardTypeField;
                    case 5:
                        return cardTypeAilment;
                }
                // WORLD 2 LEVEL 4
            case 12:
                switch (cardNr) {
                    case 0:
                        return cardTypeAilment;
                    case 1:
                        return cardTypeAilment;
                    case 2:
                        return cardTypeAilment;
                    case 3:
                        return cardTypeAilment;
                }
                // WORLD 2 LEVEL 5
            case 13:
                switch (cardNr) {
                    case 0:
                        return cardTypeAilment;
                    case 1:
                        return cardTypeAilment;
                    case 2:
                        return cardTypeBoosting;
                    case 3:
                        return cardTypeField;
                }
                // WORLD 2 LEVEL 6
            case 14:
                switch (cardNr) {
                    case 0:
                        return cardTypeBoosting;
                    case 1:
                        return cardTypeAilment;
                    case 2:
                        return cardTypeField;
                }
                // WORLD 2 LEVEL 7
            case 15:
                switch (cardNr) {
                    case 0:
                        return cardTypeBoosting;
                    case 1:
                        return cardTypeAilment;
                    case 2:
                        return cardTypeField;
                    case 3:
                        return cardTypeBoosting;
                }
                // WORLD 2 LEVEL 8
            case 16:
                switch (cardNr) {
                    case 0:
                        return cardTypeField;
                    case 1:
                        return cardTypeField;
                    case 2:
                        return cardTypeAilment;
                    case 3:
                        return cardTypeBoosting;
                    case 4:
                        return cardTypeAilment;
                    case 5:
                        return cardTypeAilment;
                }
                // WORLD 3 LEVEL 1
            case 17:
                switch (cardNr) {
                    case 0:
                        return cardTypeBoosting;
                    case 1:
                        return cardTypeBoosting;
                    case 2:
                        return cardTypeField;
                    case 3:
                        return cardTypeField;
                }
                // WORLD 3 LEVEL 2
            case 18:
                switch (cardNr) {
                    case 0:
                        return cardTypeBoosting;
                    case 1:
                        return cardTypeAilment;
                    case 2:
                        return cardTypeField;
                    case 3:
                        return cardTypeField;
                }
                // WORLD 3 LEVEL 3
            case 19:
                switch (cardNr) {
                    case 0:
                        return cardTypeBoosting;
                    case 1:
                        return cardTypeField;
                    case 2:
                        return cardTypeBoosting;
                    case 3:
                        return cardTypeField;
                    case 4:
                        return cardTypeAilment;
                    case 5:
                        return cardTypeBoosting;
                }
                // WORLD 3 LEVEL 4
            case 20:
                switch (cardNr) {
                    case 0:
                        return cardTypeField;
                    case 1:
                        return cardTypeField;
                    case 2:
                        return cardTypeBoosting;
                    case 3:
                        return cardTypeBoosting;
                    case 4:
                        return cardTypeBoosting;
                    case 5:
                        return cardTypeBoosting;
                }
                // WORLD 3 LEVEL 5
            case 21:
                switch (cardNr) {
                    case 0:
                        return cardTypeBoosting;
                    case 1:
                        return cardTypeAilment;
                    case 2:
                        return cardTypeBoosting;
                }
                // WORLD 3 LEVEL 6
            case 22:
                switch (cardNr) {
                    case 0:
                        return cardTypeBoosting;
                    case 1:
                        return cardTypeAilment;
                    case 2:
                        return cardTypeBoosting;
                    case 3:
                        return cardTypeBoosting;
                    case 4:
                        return cardTypeField;
                }
                // WORLD 3 LEVEL 7
            case 23:
                switch (cardNr) {
                    case 0:
                        return cardTypeField;
                    case 1:
                        return cardTypeBoosting;
                    case 2:
                        return cardTypeAilment;
                    case 3:
                        return cardTypeAilment;
                    case 4:
                        return cardTypeAilment;
                    case 5:
                        return cardTypeBoosting;
                }
                // WORLD 3 LEVEL 8
            case 24:
                switch (cardNr) {
                    case 0:
                        return cardTypeBoosting;
                    case 1:
                        return cardTypeBoosting;
                    case 2:
                        return cardTypeBoosting;
                    case 3:
                        return cardTypeBoosting;
                    case 4:
                        return cardTypeBoosting;
                    case 5:
                        return cardTypeBoosting;
                }
                // WORLD 4 LEVEL 1
            case 25:
                switch (cardNr) {
                    case 0:
                        return cardTypeAilment;
                    case 1:
                        return cardTypeAilment;
                    case 2:
                        return cardTypeField;
                    case 3:
                        return cardTypeField;
                    case 4:
                        return cardTypeField;
                    case 5:
                        return cardTypeBoosting;
                }
                // WORLD 4 LEVEL 2
            case 26:
                switch (cardNr) {
                    case 0:
                        return cardTypeField;
                    case 1:
                        return cardTypeBoosting;
                    case 2:
                        return cardTypeBoosting;
                    case 3:
                        return cardTypeField;
                    case 4:
                        return cardTypeAilment;
                    case 5:
                        return cardTypeField;
                }
                // WORLD 4 LEVEL 3
            case 27:
                switch (cardNr) {
                    case 0:
                        return cardTypeBoosting;
                    case 1:
                        return cardTypeBoosting;
                    case 2:
                        return cardTypeBoosting;
                    case 3:
                        return cardTypeBoosting;
                    case 4:
                        return cardTypeAilment;
                    case 5:
                        return cardTypeField;
                }
                // WORLD 4 LEVEL 4
            case 28:
                switch (cardNr) {
                    case 0:
                        return cardTypeAilment;
                    case 1:
                        return cardTypeAilment;
                    case 2:
                        return cardTypeBoosting;
                    case 3:
                        return cardTypeField;
                    case 4:
                        return cardTypeBoosting;
                    case 5:
                        return cardTypeAilment;
                }
                // WORLD 4 LEVEL 5
            case 29:
                switch (cardNr) {
                    case 0:
                        return cardTypeField;
                    case 1:
                        return cardTypeField;
                    case 2:
                        return cardTypeBoosting;
                    case 3:
                        return cardTypeBoosting;
                    case 4:
                        return cardTypeField;
                    case 5:
                        return cardTypeBoosting;
                }
                // WORLD 4 LEVEL 6
            case 30:
                switch (cardNr) {
                    case 0:
                        return cardTypeAilment;
                    case 1:
                        return cardTypeField;
                    case 2:
                        return cardTypeAilment;
                    case 3:
                        return cardTypeBoosting;
                    case 4:
                        return cardTypeField;
                    case 5:
                        return cardTypeBoosting;
                }
                // WORLD 4 LEVEL 7
            case 31:
                switch (cardNr) {
                    case 0:
                        return cardTypeAilment;
                    case 1:
                        return cardTypeAilment;
                    case 2:
                        return cardTypeAilment;
                    case 3:
                        return cardTypeBoosting;
                    case 4:
                        return cardTypeBoosting;
                    case 5:
                        return cardTypeField;
                }
                // WORLD 4 LEVEL 8
            case 32:
                switch (cardNr) {
                    case 0:
                        return cardTypeBoosting;
                    case 1:
                        return cardTypeBoosting;
                    case 2:
                        return cardTypeAilment;
                    case 3:
                        return cardTypeField;
                    case 4:
                        return cardTypeField;
                    case 5:
                        return cardTypeField;
                }
                // WORLD 5 LEVEL 1
            case 33:
                switch (cardNr) {
                    case 0:
                        return cardTypeAilment;
                    case 1:
                        return cardTypeAilment;
                    case 2:
                        return cardTypeField;
                    case 3:
                        return cardTypeBoosting;
                    case 4:
                        return cardTypeAilment;
                    case 5:
                        return cardTypeAilment;
                }
                // WORLD 5 LEVEL 2
            case 34:
                switch (cardNr) {
                    case 0:
                        return cardTypeBoosting;
                    case 1:
                        return cardTypeField;
                    case 2:
                        return cardTypeField;
                    case 3:
                        return cardTypeBoosting;
                    case 4:
                        return cardTypeField;
                    case 5:
                        return cardTypeAilment;
                }
                // WORLD 5 LEVEL 3
            case 35:
                switch (cardNr) {
                    case 0:
                        return cardTypeAilment;
                    case 1:
                        return cardTypeBoosting;
                    case 2:
                        return cardTypeField;
                    case 3:
                        return cardTypeBoosting;
                    case 4:
                        return cardTypeBoosting;
                    case 5:
                        return cardTypeAilment;
                }
                // WORLD 5 LEVEL 4
            case 36:
                switch (cardNr) {
                    case 0:
                        return cardTypeAilment;
                    case 1:
                        return cardTypeAilment;
                    case 2:
                        return cardTypeAilment;
                    case 3:
                        return cardTypeAilment;
                    case 4:
                        return cardTypeAilment;
                    case 5:
                        return cardTypeAilment;
                }
                // WORLD 5 LEVEL 5
            case 37:
                switch (cardNr) {
                    case 0:
                        return cardTypeBoosting;
                    case 1:
                        return cardTypeAilment;
                    case 2:
                        return cardTypeBoosting;
                    case 3:
                        return cardTypeAilment;
                    case 4:
                        return cardTypeBoosting;
                    case 5:
                        return cardTypeAilment;
                }
                // WORLD 5 LEVEL 6
            case 38:
                switch (cardNr) {
                    case 0:
                        return cardTypeBoosting;
                    case 1:
                        return cardTypeBoosting;
                    case 2:
                        return cardTypeField;
                    case 3:
                        return cardTypeAilment;
                    case 4:
                        return cardTypeAilment;
                    case 5:
                        return cardTypeBoosting;
                }
                // WORLD 5 LEVEL 7
            case 39:
                switch (cardNr) {
                    case 0:
                        return cardTypeField;
                    case 1:
                        return cardTypeField;
                    case 2:
                        return cardTypeBoosting;
                    case 3:
                        return cardTypeBoosting;
                    case 4:
                        return cardTypeAilment;
                    case 5:
                        return cardTypeBoosting;
                }
                // WORLD 5 LEVEL 8
            case 40:
                switch (cardNr) {
                    case 0:
                        return cardTypeBoosting;
                    case 1:
                        return cardTypeAilment;
                    case 2:
                        return cardTypeField;
                    case 3:
                        return cardTypeBoosting;
                    case 4:
                        return cardTypeAilment;
                    case 5:
                        return cardTypeAilment;
                }
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
                switch (cardNr) {
                    case 0:
                        return setEnemyRandomCardType(card1Type);
                    case 1:
                        return setEnemyRandomCardType(card2Type);
                    case 2:
                        return setEnemyRandomCardType(card3Type);
                    case 3:
                        return setEnemyRandomCardType(card4Type);
                    case 4:
                        return setEnemyRandomCardType(card5Type);
                    case 5:
                        return setEnemyRandomCardType(card6Type);
                }
        }
        return "";
    }

    public static boolean getCardPresent(int levelId, int cardNr) {
        switch (levelId) {
            // WORLD 1 LEVEL 1
            case 1:
                switch (cardNr) {
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
                switch (cardNr) {
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
                switch (cardNr) {
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
                switch (cardNr) {
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
                switch (cardNr) {
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
                switch (cardNr) {
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
                switch (cardNr) {
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
                // WORLD 1 LEVEL 8
            case 8:
                switch (cardNr) {
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
                switch (cardNr) {
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
                switch (cardNr) {
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
                switch (cardNr) {
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
                switch (cardNr) {
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
                switch (cardNr) {
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
                switch (cardNr) {
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
                switch (cardNr) {
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
                switch (cardNr) {
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
                switch (cardNr) {
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
                // WORLD 3 LEVEL 2
            case 18:
                switch (cardNr) {
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
                // WORLD 3 LEVEL 3
            case 19:
                switch (cardNr) {
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
                // WORLD 3 LEVEL 4
            case 20:
                switch (cardNr) {
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
                // WORLD 3 LEVEL 5
            case 21:
                switch (cardNr) {
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
                // WORLD 3 LEVEL 6
            case 22:
                switch (cardNr) {
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
                // WORLD 3 LEVEL 7
            case 23:
                switch (cardNr) {
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
                // WORLD 3 LEVEL 8
            case 24:
                switch (cardNr) {
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
                // WORLD 4 LEVEL 1
            case 25:
                switch (cardNr) {
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
                // WORLD 4 LEVEL 2
            case 26:
                switch (cardNr) {
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
                // WORLD 4 LEVEL 3
            case 27:
                switch (cardNr) {
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
                // WORLD 4 LEVEL 4
            case 28:
                switch (cardNr) {
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
                // WORLD 4 LEVEL 5
            case 29:
                switch (cardNr) {
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
                // WORLD 4 LEVEL 6
            case 30:
                switch (cardNr) {
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
                // WORLD 4 LEVEL 7
            case 31:
                switch (cardNr) {
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
                // WORLD 4 LEVEL 8
            case 32:
                switch (cardNr) {
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
                // WORLD 5 LEVEL 1
            case 33:
                switch (cardNr) {
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
                // WORLD 5 LEVEL 2
            case 34:
                switch (cardNr) {
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
                // WORLD 5 LEVEL 3
            case 35:
                switch (cardNr) {
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
                // WORLD 5 LEVEL 4
            case 36:
                switch (cardNr) {
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
                // WORLD 5 LEVEL 5
            case 37:
                switch (cardNr) {
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
                // WORLD 5 LEVEL 6
            case 38:
                switch (cardNr) {
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
                // WORLD 5 LEVEL 7
            case 39:
                switch (cardNr) {
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
                // WORLD 5 LEVEL 8
            case 40:
                switch (cardNr) {
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
                //WORLD 6
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
                switch (cardNr) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return true;
                }
        }
        return false;
    }

    public static String getEnemyCardImgName(int levelId, int cardNr) {
        switch (levelId) {
            // WORLD 1 LEVEL 1
            case 1:
                switch (cardNr) {
                    case 0:
                        return Reinforce3ImgPath;
                }
                // WORLD 1 LEVEL 2
            case 2:
                switch (cardNr) {
                    case 0:
                        return Reinforce3ImgPath;
                    case 1:
                        return Reinforce3ImgPath;
                }
                // WORLD 1 LEVEL 3
            case 3:
                switch (cardNr) {
                    case 0:
                        return Reinforce3ImgPath;
                    case 1:
                        return Reinforce3ImgPath;
                    case 2:
                        return SlowDownImgPath;
                }
                // WORLD 1 LEVEL 4
            case 4:
                switch (cardNr) {
                    case 0:
                        return SpeedUpImgPath;
                    case 1:
                        return Reinforce3ImgPath;
                    case 2:
                        return SlowDownImgPath;
                }
                // WORLD 1 LEVEL 5
            case 5:
                switch (cardNr) {
                    case 0:
                        return Reinforce3ImgPath;
                    case 1:
                        return Reinforce3ImgPath;
                    case 2:
                        return SlowDownImgPath;
                }
                // WORLD 1 LEVEL 6
            case 6:
                switch (cardNr) {
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
                switch (cardNr) {
                    case 0:
                        return SpeedUpImgPath;
                    case 1:
                        return SlowDownImgPath;
                    case 2:
                        return Reinforce3ImgPath;
                    case 3:
                        return Reinforce3ImgPath;
                }
                // WORLD 1 LEVEL 8
            case 8:
                switch (cardNr) {
                    case 0:
                        return SpeedUpImgPath;
                    case 1:
                        return ConcentrateImgPath;
                    case 2:
                        return Leech1ImgPath;
                }
                // WORLD 2 LEVEL 1
            case 9:
                switch (cardNr) {
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
                switch (cardNr) {
                    case 0:
                        return CorruptionImgPath;
                    case 1:
                        return CurseImgPath;
                    case 2:
                        return Reinforce3ImgPath;
                }
                // WORLD 2 LEVEL 3
            case 11:
                switch (cardNr) {
                    case 0:
                        return Leech1ImgPath;
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
                switch (cardNr) {
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
                switch (cardNr) {
                    case 0:
                        return CorruptionImgPath;
                    case 1:
                        return CorruptionImgPath;
                    case 2:
                        return ConcentrateImgPath;
                    case 3:
                        return Reinforce3ImgPath;
                }
                // WORLD 2 LEVEL 6
            case 14:
                switch (cardNr) {
                    case 0:
                        return SpeedUpImgPath;
                    case 1:
                        return CurseImgPath;
                    case 2:
                        return Leech2ImgPath;
                }
                // WORLD 2 LEVEL 7
            case 15:
                switch (cardNr) {
                    case 0:
                        return ConcentrateImgPath;
                    case 1:
                        return AgonyImgPath;
                    case 2:
                        return Leech1ImgPath;
                    case 3:
                        return MimicImgPath;
                }
                // WORLD 2 LEVEL 8
            case 16:
                switch (cardNr) {
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
                switch (cardNr) {
                    case 0:
                        return ConcentrateImgPath;
                    case 1:
                        return SpeedUpImgPath;
                    case 2:
                        return Leech2ImgPath;
                    case 3:
                        return Leech2ImgPath;
                }
                // WORLD 3 LEVEL 2
            case 18:
                switch (cardNr) {
                    case 0:
                        return CureImgPath;
                    case 1:
                        return AgonyImgPath;
                    case 2:
                        return InfestImgPath;
                    case 3:
                        return InfestImgPath;
                }
                // WORLD 3 LEVEL 3
            case 19:
                switch (cardNr) {
                    case 0:
                        return CureImgPath;
                    case 1:
                        return Reinforce3ImgPath;
                    case 2:
                        return ConcentrateImgPath;
                    case 3:
                        return Leech2ImgPath;
                    case 4:
                        return CorruptionImgPath;
                    case 5:
                        return MimicImgPath;
                }
                // WORLD 3 LEVEL 4
            case 20:
                switch (cardNr) {
                    case 0:
                        return Leech2ImgPath;
                    case 1:
                        return Leech2ImgPath;
                    case 2:
                        return ConcentrateImgPath;
                    case 3:
                        return ConcentrateImgPath;
                    case 4:
                        return SpeedUpImgPath;
                    case 5:
                        return SpeedUpImgPath;
                }
                // WORLD 3 LEVEL 5
            case 21:
                switch (cardNr) {
                    case 0:
                        return ProtectImgPath;
                    case 1:
                        return AgonyImgPath;
                    case 2:
                        return MimicImgPath;
                }
                // WORLD 3 LEVEL 6
            case 22:
                switch (cardNr) {
                    case 0:
                        return ProtectImgPath;
                    case 1:
                        return CurseImgPath;
                    case 2:
                        return MimicImgPath;
                    case 3:
                        return CureImgPath;
                    case 4:
                        return Reinforce3ImgPath;
                }
                // WORLD 3 LEVEL 7
            case 23:
                switch (cardNr) {
                    case 0:
                        return InfestImgPath;
                    case 1:
                        return SpeedUpImgPath;
                    case 2:
                        return CorruptionImgPath;
                    case 3:
                        return AgonyImgPath;
                    case 4:
                        return SlowDownImgPath;
                    case 5:
                        return CureImgPath;
                }
                // WORLD 3 LEVEL 8
            case 24:
                switch (cardNr) {
                    case 0:
                        return MimicImgPath;
                    case 1:
                        return MimicImgPath;
                    case 2:
                        return ProtectImgPath;
                    case 3:
                        return CureImgPath;
                    case 4:
                        return ConcentrateImgPath;
                    case 5:
                        return SpeedUpImgPath;
                }
                // WORLD 4 LEVEL 1
            case 25:
                switch (cardNr) {
                    case 0:
                        return SlowDownImgPath;
                    case 1:
                        return SlowDownImgPath;
                    case 2:
                        return ChargeImgPath;
                    case 3:
                        return Reinforce5ImgPath;
                    case 4:
                        return Reinforce5ImgPath;
                    case 5:
                        return SpeedUpImgPath;
                }
                // WORLD 4 LEVEL 2
            case 26:
                switch (cardNr) {
                    case 0:
                        return Reinforce5ImgPath;
                    case 1:
                        return ConcentrateImgPath;
                    case 2:
                        return ProtectImgPath;
                    case 3:
                        return Leech2ImgPath;
                    case 4:
                        return BlindImgPath;
                    case 5:
                        return InfestImgPath;
                }
                // WORLD 4 LEVEL 3
            case 27:
                switch (cardNr) {
                    case 0:
                        return TakeAimImgPath;
                    case 1:
                        return ConcentrateImgPath;
                    case 2:
                        return CureImgPath;
                    case 3:
                        return ChargeImgPath;
                    case 4:
                        return BlindImgPath;
                    case 5:
                        return Reinforce5ImgPath;
                }
                // WORLD 4 LEVEL 4
            case 28:
                switch (cardNr) {
                    case 0:
                        return CurseImgPath;
                    case 1:
                        return SilenceImgPath;
                    case 2:
                        return ChargeImgPath;
                    case 3:
                        return SalvageImgPath;
                    case 4:
                        return SpeedUp2ImgPath;
                    case 5:
                        return DispelImgPath;
                }
                // WORLD 4 LEVEL 5
            case 29:
                switch (cardNr) {
                    case 0:
                        return SalvageImgPath;
                    case 1:
                        return Reinforce5ImgPath;
                    case 2:
                        return ConcentrateImgPath;
                    case 3:
                        return TakeAimImgPath;
                    case 4:
                        return Leech2ImgPath;
                    case 5:
                        return SpeedUp2ImgPath;
                }
                // WORLD 4 LEVEL 6
            case 30:
                switch (cardNr) {
                    case 0:
                        return BlindImgPath;
                    case 1:
                        return InfestImgPath;
                    case 2:
                        return CurseImgPath;
                    case 3:
                        return MimicImgPath;
                    case 4:
                        return Reinforce5ImgPath;
                    case 5:
                        return CureImgPath;
                }
                // WORLD 4 LEVEL 7
            case 31:
                switch (cardNr) {
                    case 0:
                        return AgonyImgPath;
                    case 1:
                        return DispelImgPath;
                    case 2:
                        return SilenceImgPath;
                    case 3:
                        return ChargeImgPath;
                    case 4:
                        return ChargeImgPath;
                    case 5:
                        return InfestImgPath;
                }
                // WORLD 4 LEVEL 8
            case 32:
                switch (cardNr) {
                    case 0:
                        return ProtectImgPath;
                    case 1:
                        return HoardImgPath;
                    case 2:
                        return DeathSentenceImgPath;
                    case 3:
                        return Reinforce5ImgPath;
                    case 4:
                        return Leech2ImgPath;
                    case 5:
                        return Leech2ImgPath;
                }
                // WORLD 5 LEVEL 1
            case 33:
                switch (cardNr) {
                    case 0:
                        return DeathSentenceImgPath;
                    case 1:
                        return CorruptionImgPath;
                    case 2:
                        return InfestImgPath;
                    case 3:
                        return CureImgPath;
                    case 4:
                        return ConfuseImgPath;
                    case 5:
                        return AgonyImgPath;
                }
                // WORLD 5 LEVEL 2
            case 34:
                switch (cardNr) {
                    case 0:
                        return TakeAimImgPath;
                    case 1:
                        return SalvageImgPath;
                    case 2:
                        return RestoreImgPath;
                    case 3:
                        return ConcentrateImgPath;
                    case 4:
                        return Leech3ImgPath;
                    case 5:
                        return BlindImgPath;
                }
                // WORLD 5 LEVEL 3
            case 35:
                switch (cardNr) {
                    case 0:
                        return MaledictionImgPath;
                    case 1:
                        return RewindImgPath;
                    case 2:
                        return InfestImgPath;
                    case 3:
                        return ConcentrateImgPath;
                    case 4:
                        return ChargeImgPath;
                    case 5:
                        return BlindImgPath;
                }
                // WORLD 5 LEVEL 4
            case 36:
                switch (cardNr) {
                    case 0:
                        return CurseImgPath;
                    case 1:
                        return SlowDownImgPath;
                    case 2:
                        return ConfuseImgPath;
                    case 3:
                        return AgonyImgPath;
                    case 4:
                        return DispelImgPath;
                    case 5:
                        return SilenceImgPath;
                }
                // WORLD 5 LEVEL 5
            case 37:
                switch (cardNr) {
                    case 0:
                        return RewindImgPath;
                    case 1:
                        return DeathSentenceImgPath;
                    case 2:
                        return HoardImgPath;
                    case 3:
                        return BlindImgPath;
                    case 4:
                        return ChargeImgPath;
                    case 5:
                        return SilenceImgPath;
                }
                // WORLD 5 LEVEL 6
            case 38:
                switch (cardNr) {
                    case 0:
                        return SpeedUp2ImgPath;
                    case 1:
                        return ConcentrateImgPath;
                    case 2:
                        return Reinforce5ImgPath;
                    case 3:
                        return CorruptionImgPath;
                    case 4:
                        return DemonicPrayerImgPath;
                    case 5:
                        return MimicImgPath;
                }
                // WORLD 5 LEVEL 7
            case 39:
                switch (cardNr) {
                    case 0:
                        return Leech3ImgPath;
                    case 1:
                        return Leech3ImgPath;
                    case 2:
                        return ChargeImgPath;
                    case 3:
                        return ConcentrateImgPath;
                    case 4:
                        return DispelImgPath;
                    case 5:
                        return CureImgPath;
                }
                // WORLD 5 LEVEL 8
            case 40:
                switch (cardNr) {
                    case 0:
                        return SpeedUpImgPath;
                    case 1:
                        return ConfuseImgPath;
                    case 2:
                        return RestoreImgPath;
                    case 3:
                        return ConcentrateImgPath;
                    case 4:
                        return AgonyImgPath;
                    case 5:
                        return MaledictionImgPath;
                }
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
                switch (cardNr) {
                    case 0:
                        return setRandomCardImg(card1Name);
                    case 1:
                        return setRandomCardImg(card2Name);
                    case 2:
                        return setRandomCardImg(card3Name);
                    case 3:
                        return setRandomCardImg(card4Name);
                    case 4:
                        return setRandomCardImg(card5Name);
                    case 5:
                        return setRandomCardImg(card6Name);
                }
        }
        return "";
    }

    public static String getEnemyCardName(int levelId, int cardNr, ArrayList<String> enemyCardsArray) {
        switch (levelId) {
            // WORLD 1 LEVEL 1
            case 1:
                switch (cardNr) {
                    case 0:
                        return Reinforce3CardName;
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
                switch (cardNr) {
                    case 0:
                        return Reinforce3CardName;
                    case 1:
                        return Reinforce3CardName;
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
                switch (cardNr) {
                    case 0:
                        return Reinforce3CardName;
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
                // WORLD 1 LEVEL 4
            case 4:
                switch (cardNr) {
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
                switch (cardNr) {
                    case 0:
                        return Reinforce3CardName;
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
                // WORLD 1 LEVEL 6
            case 6:
                switch (cardNr) {
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
                switch (cardNr) {
                    case 0:
                        return SpeedUpCardName;
                    case 1:
                        return SlowDownCardName;
                    case 2:
                        return Reinforce3CardName;
                    case 3:
                        return Reinforce3CardName;
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
                // WORLD 1 LEVEL 8
            case 8:
                switch (cardNr) {
                    case 0:
                        return SpeedUpCardName;
                    case 1:
                        return ConcentrateCardName;
                    case 2:
                        return Leech1CardName;
                    case 3:
                        return "";
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
                // WORLD 2 LEVEL 1
            case 9:
                switch (cardNr) {
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
                switch (cardNr) {
                    case 0:
                        return CorruptionCardName;
                    case 1:
                        return CurseCardName;
                    case 2:
                        return Reinforce3CardName;
                    case 3:
                        return "";
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
                // WORLD 2 LEVEL 3
            case 11:
                switch (cardNr) {
                    case 0:
                        return Leech1CardName;
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
                switch (cardNr) {
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
                switch (cardNr) {
                    case 0:
                        return CorruptionCardName;
                    case 1:
                        return CorruptionCardName;
                    case 2:
                        return ConcentrateCardName;
                    case 3:
                        return Reinforce3CardName;
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
                // WORLD 2 LEVEL 6
            case 14:
                switch (cardNr) {
                    case 0:
                        return SpeedUpCardName;
                    case 1:
                        return CurseCardName;
                    case 2:
                        return Leech2CardName;
                    case 3:
                        return "";
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
                // WORLD 2 LEVEL 7
            case 15:
                switch (cardNr) {
                    case 0:
                        return ConcentrateCardName;
                    case 1:
                        return AgonyCardName;
                    case 2:
                        return Leech1CardName;
                    case 3:
                        return MimicCardName;
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
                // WORLD 2 LEVEL 8
            case 16:
                switch (cardNr) {
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
                switch (cardNr) {
                    case 0:
                        return ConcentrateCardName;
                    case 1:
                        return SpeedUpCardName;
                    case 2:
                        return Leech2CardName;
                    case 3:
                        return Leech2CardName;
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
                // WORLD 3 LEVEL 2
            case 18:
                switch (cardNr) {
                    case 0:
                        return CureCardName;
                    case 1:
                        return AgonyCardName;
                    case 2:
                        return InfestCardName;
                    case 3:
                        return InfestCardName;
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
                // WORLD 3 LEVEL 3
            case 19:
                switch (cardNr) {
                    case 0:
                        return CureCardName;
                    case 1:
                        return Reinforce3CardName;
                    case 2:
                        return ConcentrateCardName;
                    case 3:
                        return Leech2CardName;
                    case 4:
                        return CorruptionCardName;
                    case 5:
                        return MimicCardName;
                }
                // WORLD 3 LEVEL 4
            case 20:
                switch (cardNr) {
                    case 0:
                        return Leech2CardName;
                    case 1:
                        return Leech2CardName;
                    case 2:
                        return ConcentrateCardName;
                    case 3:
                        return ConcentrateCardName;
                    case 4:
                        return SpeedUpCardName;
                    case 5:
                        return SpeedUpCardName;
                }
                // WORLD 3 LEVEL 5
            case 21:
                switch (cardNr) {
                    case 0:
                        return ProtectCardName;
                    case 1:
                        return AgonyCardName;
                    case 2:
                        return MimicCardName;
                    case 3:
                        return "";
                    case 4:
                        return "";
                    case 5:
                        return "";
                }
                // WORLD 3 LEVEL 6
            case 22:
                switch (cardNr) {
                    case 0:
                        return ProtectCardName;
                    case 1:
                        return CurseCardName;
                    case 2:
                        return MimicCardName;
                    case 3:
                        return CureCardName;
                    case 4:
                        return Reinforce3CardName;
                    case 5:
                        return "";
                }
                // WORLD 3 LEVEL 7
            case 23:
                switch (cardNr) {
                    case 0:
                        return InfestCardName;
                    case 1:
                        return SpeedUpCardName;
                    case 2:
                        return CorruptionCardName;
                    case 3:
                        return AgonyCardName;
                    case 4:
                        return SlowDownCardName;
                    case 5:
                        return CureCardName;
                }
                // WORLD 3 LEVEL 8
            case 24:
                switch (cardNr) {
                    case 0:
                        return MimicCardName;
                    case 1:
                        return MimicCardName;
                    case 2:
                        return ProtectCardName;
                    case 3:
                        return CureCardName;
                    case 4:
                        return ConcentrateCardName;
                    case 5:
                        return SpeedUpCardName;
                }
                // WORLD 4 LEVEL 1
            case 25:
                switch (cardNr) {
                    case 0:
                        return SlowDownCardName;
                    case 1:
                        return SlowDownCardName;
                    case 2:
                        return ChargeCardName;
                    case 3:
                        return Reinforce5CardName;
                    case 4:
                        return Reinforce5CardName;
                    case 5:
                        return SpeedUpCardName;
                }
                // WORLD 4 LEVEL 2
            case 26:
                switch (cardNr) {
                    case 0:
                        return Reinforce5CardName;
                    case 1:
                        return ConcentrateCardName;
                    case 2:
                        return ProtectCardName;
                    case 3:
                        return Leech2CardName;
                    case 4:
                        return BlindCardName;
                    case 5:
                        return InfestCardName;
                }
                // WORLD 4 LEVEL 3
            case 27:
                switch (cardNr) {
                    case 0:
                        return TakeAimCardName;
                    case 1:
                        return ConcentrateCardName;
                    case 2:
                        return CureCardName;
                    case 3:
                        return ChargeCardName;
                    case 4:
                        return BlindCardName;
                    case 5:
                        return Reinforce5CardName;
                }
                // WORLD 4 LEVEL 4
            case 28:
                switch (cardNr) {
                    case 0:
                        return CurseCardName;
                    case 1:
                        return SilenceCardName;
                    case 2:
                        return ChargeCardName;
                    case 3:
                        return SalvageCardName;
                    case 4:
                        return SpeedUp2CardName;
                    case 5:
                        return DispelCardName;
                }
                // WORLD 4 LEVEL 5
            case 29:
                switch (cardNr) {
                    case 0:
                        return SalvageCardName;
                    case 1:
                        return Reinforce5CardName;
                    case 2:
                        return ConcentrateCardName;
                    case 3:
                        return TakeAimCardName;
                    case 4:
                        return Leech2CardName;
                    case 5:
                        return SpeedUp2CardName;
                }
                // WORLD 4 LEVEL 6
            case 30:
                switch (cardNr) {
                    case 0:
                        return BlindCardName;
                    case 1:
                        return InfestCardName;
                    case 2:
                        return CurseCardName;
                    case 3:
                        return MimicCardName;
                    case 4:
                        return Reinforce5CardName;
                    case 5:
                        return CureCardName;
                }
                // WORLD 4 LEVEL 7
            case 31:
                switch (cardNr) {
                    case 0:
                        return AgonyCardName;
                    case 1:
                        return DispelCardName;
                    case 2:
                        return SilenceCardName;
                    case 3:
                        return ChargeCardName;
                    case 4:
                        return ChargeCardName;
                    case 5:
                        return InfestCardName;
                }
                // WORLD 4 LEVEL 8
            case 32:
                switch (cardNr) {
                    case 0:
                        return ProtectCardName;
                    case 1:
                        return HoardCardName;
                    case 2:
                        return DeathSentenceCardName;
                    case 3:
                        return Reinforce5CardName;
                    case 4:
                        return Leech2CardName;
                    case 5:
                        return Leech2CardName;
                }
                // WORLD 5 LEVEL 1
            case 33:
                switch (cardNr) {
                    case 0:
                        return DeathSentenceCardName;
                    case 1:
                        return CorruptionCardName;
                    case 2:
                        return InfestCardName;
                    case 3:
                        return CureCardName;
                    case 4:
                        return ConfuseCardName;
                    case 5:
                        return AgonyCardName;
                }
                // WORLD 5 LEVEL 2
            case 34:
                switch (cardNr) {
                    case 0:
                        return TakeAimCardName;
                    case 1:
                        return SalvageCardName;
                    case 2:
                        return RestoreCardName;
                    case 3:
                        return ConcentrateCardName;
                    case 4:
                        return Leech3CardName;
                    case 5:
                        return BlindCardName;
                }
                // WORLD 5 LEVEL 3
            case 35:
                switch (cardNr) {
                    case 0:
                        return MaledictionCardName;
                    case 1:
                        return RewindCardName;
                    case 2:
                        return InfestCardName;
                    case 3:
                        return ConcentrateCardName;
                    case 4:
                        return ChargeCardName;
                    case 5:
                        return BlindCardName;
                }
                // WORLD 5 LEVEL 4
            case 36:
                switch (cardNr) {
                    case 0:
                        return CurseCardName;
                    case 1:
                        return SlowDownCardName;
                    case 2:
                        return ConfuseCardName;
                    case 3:
                        return AgonyCardName;
                    case 4:
                        return DispelCardName;
                    case 5:
                        return SilenceCardName;
                }
                // WORLD 5 LEVEL 5
            case 37:
                switch (cardNr) {
                    case 0:
                        return RewindCardName;
                    case 1:
                        return DeathSentenceCardName;
                    case 2:
                        return HoardCardName;
                    case 3:
                        return BlindCardName;
                    case 4:
                        return ChargeCardName;
                    case 5:
                        return SilenceCardName;
                }
                // WORLD 5 LEVEL 6
            case 38:
                switch (cardNr) {
                    case 0:
                        return SpeedUp2CardName;
                    case 1:
                        return ConcentrateCardName;
                    case 2:
                        return Reinforce5CardName;
                    case 3:
                        return CorruptionCardName;
                    case 4:
                        return DemonicPrayerCardName;
                    case 5:
                        return MimicCardName;
                }
                // WORLD 5 LEVEL 7
            case 39:
                switch (cardNr) {
                    case 0:
                        return Leech3CardName;
                    case 1:
                        return Leech3CardName;
                    case 2:
                        return ChargeCardName;
                    case 3:
                        return ConcentrateCardName;
                    case 4:
                        return DispelCardName;
                    case 5:
                        return CureCardName;
                }
                // WORLD 5 LEVEL 8
            case 40:
                switch (cardNr) {
                    case 0:
                        return SpeedUpCardName;
                    case 1:
                        return ConfuseCardName;
                    case 2:
                        return RestoreCardName;
                    case 3:
                        return ConcentrateCardName;
                    case 4:
                        return AgonyCardName;
                    case 5:
                        return MaledictionCardName;
                }
                //WORLD 6 LEVEL 1-8
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
                switch (cardNr) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        cardAdded = false;
                        return setEnemyRandomCardName(cardNr, enemyCardsArray);
                }
        }
        return "";
    }

    public static int getEnemyCardCost(int levelId, int cardNr) {
        switch (levelId) {
            // WORLD 1 LEVEL 1
            case 1:
                switch (cardNr) {
                    case 0:
                        return Reinforce3CardCost;
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
                switch (cardNr) {
                    case 0:
                        return Reinforce3CardCost;
                    case 1:
                        return Reinforce3CardCost;
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
                switch (cardNr) {
                    case 0:
                        return Reinforce3CardCost;
                    case 1:
                        return Reinforce3CardCost;
                    case 2:
                        return SlowDownCardCost;
                    case 3:
                        return 0;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
                // WORLD 1 LEVEL 4
            case 4:
                switch (cardNr) {
                    case 0:
                        return SpeedUpCardCost;
                    case 1:
                        return Reinforce3CardCost;
                    case 2:
                        return SlowDownCardCost;
                    case 3:
                        return 0;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
                // WORLD 1 LEVEL 5
            case 5:
                switch (cardNr) {
                    case 0:
                        return Reinforce3CardCost;
                    case 1:
                        return Reinforce3CardCost;
                    case 2:
                        return SlowDownCardCost;
                    case 3:
                        return 0;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
                // WORLD 1 LEVEL 6
            case 6:
                switch (cardNr) {
                    case 0:
                        return SpeedUpCardCost;
                    case 1:
                        return SlowDownCardCost;
                    case 2:
                        return SlowDownCardCost;
                    case 3:
                        return Reinforce3CardCost;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
                // WORLD 1 LEVEL 7
            case 7:
                switch (cardNr) {
                    case 0:
                        return SpeedUpCardCost;
                    case 1:
                        return SlowDownCardCost;
                    case 2:
                        return Reinforce3CardCost;
                    case 3:
                        return Reinforce3CardCost;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
                // WORLD 1 LEVEL 8
            case 8:
                switch (cardNr) {
                    case 0:
                        return SpeedUpCardCost;
                    case 1:
                        return ConcentrateCardCost;
                    case 2:
                        return Leech1CardCost;
                    case 3:
                        return 0;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
                // WORLD 2 LEVEL 1
            case 9:
                switch (cardNr) {
                    case 0:
                        return SlowDownCardCost;
                    case 1:
                        return CorruptionCardCost;
                    case 2:
                        return AgonyCardCost;
                    case 3:
                        return SpeedUpCardCost;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
                // WORLD 2 LEVEL 2
            case 10:
                switch (cardNr) {
                    case 0:
                        return CorruptionCardCost;
                    case 1:
                        return CurseCardCost;
                    case 2:
                        return Reinforce3CardCost;
                    case 3:
                        return 0;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
                // WORLD 2 LEVEL 3
            case 11:
                switch (cardNr) {
                    case 0:
                        return Leech1CardCost;
                    case 1:
                        return SpeedUpCardCost;
                    case 2:
                        return AgonyCardCost;
                    case 3:
                        return Reinforce3CardCost;
                    case 4:
                        return Reinforce3CardCost;
                    case 5:
                        return CorruptionCardCost;
                }
                // WORLD 2 LEVEL 4
            case 12:
                switch (cardNr) {
                    case 0:
                        return AgonyCardCost;
                    case 1:
                        return AgonyCardCost;
                    case 2:
                        return SlowDownCardCost;
                    case 3:
                        return SlowDownCardCost;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
                // WORLD 2 LEVEL 5
            case 13:
                switch (cardNr) {
                    case 0:
                        return CorruptionCardCost;
                    case 1:
                        return CorruptionCardCost;
                    case 2:
                        return ConcentrateCardCost;
                    case 3:
                        return Reinforce3CardCost;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
                // WORLD 2 LEVEL 6
            case 14:
                switch (cardNr) {
                    case 0:
                        return SpeedUpCardCost;
                    case 1:
                        return CurseCardCost;
                    case 2:
                        return Leech2CardCost;
                    case 3:
                        return 0;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
                // WORLD 2 LEVEL 7
            case 15:
                switch (cardNr) {
                    case 0:
                        return ConcentrateCardCost;
                    case 1:
                        return AgonyCardCost;
                    case 2:
                        return Leech1CardCost;
                    case 3:
                        return MimicCardCost;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
                // WORLD 2 LEVEL 8
            case 16:
                switch (cardNr) {
                    case 0:
                        return Reinforce3CardCost;
                    case 1:
                        return Reinforce3CardCost;
                    case 2:
                        return AgonyCardCost;
                    case 3:
                        return MimicCardCost;
                    case 4:
                        return CurseCardCost;
                    case 5:
                        return CorruptionCardCost;
                }
                // WORLD 3 LEVEL 1
            case 17:
                switch (cardNr) {
                    case 0:
                        return ConcentrateCardCost;
                    case 1:
                        return SpeedUpCardCost;
                    case 2:
                        return Leech2CardCost;
                    case 3:
                        return Leech2CardCost;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
                // WORLD 3 LEVEL 2
            case 18:
                switch (cardNr) {
                    case 0:
                        return CureCardCost;
                    case 1:
                        return AgonyCardCost;
                    case 2:
                        return InfestCardCost;
                    case 3:
                        return InfestCardCost;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
                // WORLD 3 LEVEL 3
            case 19:
                switch (cardNr) {
                    case 0:
                        return CureCardCost;
                    case 1:
                        return Reinforce3CardCost;
                    case 2:
                        return ConcentrateCardCost;
                    case 3:
                        return Leech2CardCost;
                    case 4:
                        return CorruptionCardCost;
                    case 5:
                        return MimicCardCost;
                }
                // WORLD 3 LEVEL 4
            case 20:
                switch (cardNr) {
                    case 0:
                        return Leech2CardCost;
                    case 1:
                        return Leech2CardCost;
                    case 2:
                        return ConcentrateCardCost;
                    case 3:
                        return ConcentrateCardCost;
                    case 4:
                        return SpeedUpCardCost;
                    case 5:
                        return SpeedUpCardCost;
                }
                // WORLD 3 LEVEL 5
            case 21:
                switch (cardNr) {
                    case 0:
                        return ProtectCardCost;
                    case 1:
                        return AgonyCardCost;
                    case 2:
                        return MimicCardCost;
                    case 3:
                        return 0;
                    case 4:
                        return 0;
                    case 5:
                        return 0;
                }
                // WORLD 3 LEVEL 6
            case 22:
                switch (cardNr) {
                    case 0:
                        return ProtectCardCost;
                    case 1:
                        return CurseCardCost;
                    case 2:
                        return MimicCardCost;
                    case 3:
                        return CureCardCost;
                    case 4:
                        return Reinforce3CardCost;
                    case 5:
                        return 0;
                }
                // WORLD 3 LEVEL 7
            case 23:
                switch (cardNr) {
                    case 0:
                        return InfestCardCost;
                    case 1:
                        return 1;
                    case 2:
                        return CorruptionCardCost;
                    case 3:
                        return AgonyCardCost;
                    case 4:
                        return SlowDownCardCost;
                    case 5:
                        return CureCardCost;
                }
                // WORLD 3 LEVEL 8
            case 24:
                switch (cardNr) {
                    case 0:
                        return MimicCardCost;
                    case 1:
                        return MimicCardCost;
                    case 2:
                        return ProtectCardCost;
                    case 3:
                        return CureCardCost;
                    case 4:
                        return ConcentrateCardCost;
                    case 5:
                        return SpeedUpCardCost;
                }
                // WORLD 4 LEVEL 1
            case 25:
                switch (cardNr) {
                    case 0:
                        return SlowDownCardCost;
                    case 1:
                        return SlowDownCardCost;
                    case 2:
                        return ChargeCardCost;
                    case 3:
                        return Reinforce5CardCost;
                    case 4:
                        return Reinforce5CardCost;
                    case 5:
                        return SpeedUpCardCost;
                }
                // WORLD 4 LEVEL 2
            case 26:
                switch (cardNr) {
                    case 0:
                        return Reinforce5CardCost;
                    case 1:
                        return ConcentrateCardCost;
                    case 2:
                        return ProtectCardCost;
                    case 3:
                        return Leech2CardCost;
                    case 4:
                        return BlindCardCost;
                    case 5:
                        return InfestCardCost;
                }
                // WORLD 4 LEVEL 3
            case 27:
                switch (cardNr) {
                    case 0:
                        return TakeAimCardCost;
                    case 1:
                        return ConcentrateCardCost;
                    case 2:
                        return CureCardCost;
                    case 3:
                        return ChargeCardCost;
                    case 4:
                        return BlindCardCost;
                    case 5:
                        return Reinforce5CardCost;
                }
                // WORLD 4 LEVEL 4
            case 28:
                switch (cardNr) {
                    case 0:
                        return CurseCardCost;
                    case 1:
                        return SilenceCardCost;
                    case 2:
                        return ChargeCardCost;
                    case 3:
                        return SalvageCardCost;
                    case 4:
                        return SpeedUp2CardCost;
                    case 5:
                        return DispelCardCost;
                }
                // WORLD 4 LEVEL 5
            case 29:
                switch (cardNr) {
                    case 0:
                        return SalvageCardCost;
                    case 1:
                        return Reinforce5CardCost;
                    case 2:
                        return ConcentrateCardCost;
                    case 3:
                        return TakeAimCardCost;
                    case 4:
                        return Leech2CardCost;
                    case 5:
                        return SpeedUp2CardCost;
                }
                // WORLD 4 LEVEL 6
            case 30:
                switch (cardNr) {
                    case 0:
                        return BlindCardCost;
                    case 1:
                        return InfestCardCost;
                    case 2:
                        return CurseCardCost;
                    case 3:
                        return MimicCardCost;
                    case 4:
                        return Reinforce5CardCost;
                    case 5:
                        return CureCardCost;
                }
                // WORLD 4 LEVEL 7
            case 31:
                switch (cardNr) {
                    case 0:
                        return AgonyCardCost;
                    case 1:
                        return DispelCardCost;
                    case 2:
                        return SilenceCardCost;
                    case 3:
                        return ChargeCardCost;
                    case 4:
                        return ChargeCardCost;
                    case 5:
                        return InfestCardCost;
                }
                // WORLD 4 LEVEL 8
            case 32:
                switch (cardNr) {
                    case 0:
                        return ProtectCardCost;
                    case 1:
                        return HoardCardCost;
                    case 2:
                        return DeathSentenceCardCost;
                    case 3:
                        return Reinforce5CardCost;
                    case 4:
                        return Leech2CardCost;
                    case 5:
                        return Leech2CardCost;
                }
                // WORLD 5 LEVEL 1
            case 33:
                switch (cardNr) {
                    case 0:
                        return DeathSentenceCardCost;
                    case 1:
                        return CorruptionCardCost;
                    case 2:
                        return InfestCardCost;
                    case 3:
                        return CureCardCost;
                    case 4:
                        return ConfuseCardCost;
                    case 5:
                        return AgonyCardCost;
                }
                // WORLD 5 LEVEL 2
            case 34:
                switch (cardNr) {
                    case 0:
                        return TakeAimCardCost;
                    case 1:
                        return SalvageCardCost;
                    case 2:
                        return RestoreCardCost;
                    case 3:
                        return ConcentrateCardCost;
                    case 4:
                        return Leech3CardCost;
                    case 5:
                        return BlindCardCost;
                }
                // WORLD 5 LEVEL 3
            case 35:
                switch (cardNr) {
                    case 0:
                        return MaledictionCardCost;
                    case 1:
                        return RewindCardCost;
                    case 2:
                        return InfestCardCost;
                    case 3:
                        return ConcentrateCardCost;
                    case 4:
                        return ChargeCardCost;
                    case 5:
                        return BlindCardCost;
                }
                // WORLD 5 LEVEL 4
            case 36:
                switch (cardNr) {
                    case 0:
                        return CurseCardCost;
                    case 1:
                        return SlowDownCardCost;
                    case 2:
                        return ConfuseCardCost;
                    case 3:
                        return AgonyCardCost;
                    case 4:
                        return DispelCardCost;
                    case 5:
                        return SilenceCardCost;
                }
                // WORLD 5 LEVEL 5
            case 37:
                switch (cardNr) {
                    case 0:
                        return RewindCardCost;
                    case 1:
                        return DeathSentenceCardCost;
                    case 2:
                        return HoardCardCost;
                    case 3:
                        return BlindCardCost;
                    case 4:
                        return ChargeCardCost;
                    case 5:
                        return SilenceCardCost;
                }
                // WORLD 5 LEVEL 6
            case 38:
                switch (cardNr) {
                    case 0:
                        return SpeedUp2CardCost;
                    case 1:
                        return ConcentrateCardCost;
                    case 2:
                        return Reinforce5CardCost;
                    case 3:
                        return CorruptionCardCost;
                    case 4:
                        return DemonicPrayerCardCost;
                    case 5:
                        return MimicCardCost;
                }
                // WORLD 5 LEVEL 7
            case 39:
                switch (cardNr) {
                    case 0:
                        return Leech3CardCost;
                    case 1:
                        return Leech3CardCost;
                    case 2:
                        return ChargeCardCost;
                    case 3:
                        return ConcentrateCardCost;
                    case 4:
                        return DispelCardCost;
                    case 5:
                        return CureCardCost;
                }
                // WORLD 5 LEVEL 8
            case 40:
                switch (cardNr) {
                    case 0:
                        return SpeedUpCardCost;
                    case 1:
                        return ConfuseCardCost;
                    case 2:
                        return RestoreCardCost;
                    case 3:
                        return ConcentrateCardCost;
                    case 4:
                        return AgonyCardCost;
                    case 5:
                        return MaledictionCardCost;
                }
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
                switch (cardNr) {
                    case 0:
                        return setRandomCardCost(card1Name);
                    case 1:
                        return setRandomCardCost(card2Name);
                    case 2:
                        return setRandomCardCost(card3Name);
                    case 3:
                        return setRandomCardCost(card4Name);
                    case 4:
                        return setRandomCardCost(card5Name);
                    case 5:
                        return setRandomCardCost(card6Name);
                }
        }
        return 0;
    }

}
