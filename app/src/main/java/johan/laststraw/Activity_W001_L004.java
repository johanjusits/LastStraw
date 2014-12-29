package johan.laststraw;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static android.graphics.Color.TRANSPARENT;

/**
 * Created by Johan on 2014-12-21.
 */
public class Activity_W001_L004 extends Activity implements View.OnClickListener, Animation.AnimationListener {

    ImageButton obj001, obj002, obj003, obj004, obj005, obj006, obj007, obj008, obj009,
            obj010, obj011, obj012, obj013, obj014, obj015, obj016;
    ImageButton playerCard1, playerCard2, playerCard3, playerCard4, playerCard5, playerCard6;
    ImageButton enemyCard1, enemyCard2, enemyCard3, enemyCard4, enemyCard5, enemyCard6;
    ImageView playerStatusIcon1, playerStatusIcon2, playerStatusIcon3, playerStatusIcon4, playerStatusIcon5;
    ImageView enemyStatusIcon1, enemyStatusIcon2, enemyStatusIcon3, enemyStatusIcon4, enemyStatusIcon5;
    ImageView ivCenterImage;
    Button btnEndTurn;
    TextView tvCenterMessage, tvPlayerMovesNumber, tvEnemyMovesNumber;
    TextView tvPlayerName, tvPlayerExp, tvPlayerLevel, tvPlayerScore, tvEnemyScore, tvEnemyName, tvEnemyLvl;
    ImageView ivPlayerPortrait, ivEnemyPortrait, ivCenterCardFrame;
    ViewGroup layout_objectRow;
    Animation ani_fadeIn, ani_fadeOut, ani_zoomIn, ani_shake, ani_scoregain, ani_resetscore, ani_infest_shake;
    /* STRINGS */
    String playerGender = "";
    String playerName = "";
    String enemyName = "Farmboss Leo";
    String boardIsFullError = "Board is full. No effect";
    String infestMsg = "Spiders infests the wheat";
    String infestError = "Wheat is already infested";
    String ailmentFailed = "Protect wards off ailment.";
    String enemySlowed = "Enemy suffers Slow";
    String enemyHaste = "Enemy gains Haste";
    String enemyHoard = "Enemy gains Hoard";
    String enemyConcentrate = "Enemy gains Concentrate";
    String enemyCorrupted = "Enemy suffers Corruption";
    String enemyMaledicted = "Enemy suffers Malediction";
    String enemyCursed = "Enemy suffers Curse";
    String enemyAgonized = "Enemy suffers Agony";
    String enemySentenced = "Enemy suffers Death Sentence";
    String enemyCured = "Enemy cures all ailments";
    String enemyAlteredTime = "Enemy gains Rewind";
    String enemyGainAnother = "Enemy gains another turn!";
    String enemyProtected = "Enemy gains Protect";
    String enemyHoarded = "Enemy keeps played card!";
    String enemyDispelled = "Enemy suffers Dispel";
    String playerHaste = "";
    String playerHoard = "";
    String playerSlowed = "";
    String playerConcentrate = "";
    String playerCorrupted = "";
    String playerCursed = "";
    String playerMaledicted = "";
    String playerAgonized = "";
    String playerSentenced = "";
    String playerCured = "";
    String playerAlteredTime = "";
    String playerGainAnother = "";
    String playerProtected = "";
    String playerHoarded = "";
    String playerDispelled = "";
    String buffAlreadyActiveError = "Buff already active. No effect.";
    String debuffAlreadyActiveError = "Debuff already active. No effect.";
    String playerCard1Name = "", playerCard2Name = "", playerCard3Name = "", playerCard4Name = "",
            playerCard5Name = "", playerCard6Name = "";
    /* Modify enemy card names to make Mimic card work properly */
    String enemyCard1Name = "Speed Up", enemyCard2Name = "Reinforce III", enemyCard3Name = "Slow Down", enemyCard4Name = "",
            enemyCard5Name = "", enemyCard6Name = "";
    String playerCard1Img = "", playerCard2Img = "", playerCard3Img = "", playerCard4Img = "",
            playerCard5Img = "", playerCard6Img = "";
    String[] playerStatuses = new String[5];
    String[] enemyStatuses = new String[5];
    String lastEnemyPlayedCard = "";
    String lastPlayerPlayedCard = "";
    String sizeName;
    String densityName;
    /* INTS */
    int clearSoundId;
    int infestedObjRemainingHits = -1;
    int newExp;
    int expToNextLevel;
    int checkIfExpRoof;
    int playerLevel;
    int playerExp;
    int playerProgress;
    int playerScore = 0, enemyScore = 0, finalPlayerScore, finalEnemyScore;
    int playerCard1Type = 0, playerCard2Type = 0, playerCard3Type = 0, playerCard4Type = 0,
            playerCard5Type = 0, playerCard6Type = 0;
    int playerCard1Cost, playerCard2Cost, playerCard3Cost, playerCard4Cost,
            playerCard5Cost, playerCard6Cost;
    int enemyCard1Cost = 1, enemyCard2Cost = 1, enemyCard3Cost = 1, enemyCard4Cost = 1,
            enemyCard5Cost = 1, enemyCard6Cost = 1;
    int playerMoves = 3, enemyMoves = 0;
    int objectsRemaining = 16;
    int selectedCard = 0;
    int enemyPickedCard;
    int enemyStartingCards = 3;
    int enemyCardsRemaining = 3;
    int lvlcleared;
    int lvlhighscore;
    int lvlId;
    int activePlayerStatuses = 0;
    int activeEnemyStatuses = 0;
    int playerClearAward = 2;
    int enemyClearAward = 2;
    int playerCorruptedPenalty = 0;
    int enemyCorruptedPenalty = 0;
    int playerCurseCountdown = -1;
    int enemyCurseCountdown = -1;
    int playerAgonyCountdown = -1;
    int enemyAgonyCountdown = -1;
    int playerMaledictionCountdown = -1;
    int enemyMaledictionCountdown = -1;
    int playerSentenceCountdown = -1;
    int enemySentenceCountdown = -1;
    int playerProtectCountdown = -1;
    int enemyProtectCountdown = -1;
    int coinCycle;
    int enemyTurnCounter = 0;
    ArrayList<Integer> pool = new ArrayList<Integer>();
    /* BOOLEANS */
    boolean enemyIsSlowed = false;
    boolean playerIsSlowed = false;
    boolean enemyHasHaste = false;
    boolean enemyHasHaste2 = false;
    boolean playerHasHaste = false;
    boolean playerHasHaste2 = false;
    boolean playerHasProtect = false;
    boolean enemyHasProtect = false;
    boolean playerHasConcentrate = false;
    boolean enemyHasConcentrate = false;
    boolean playerHasAlteredTime = false;
    boolean enemyHasAlteredTime = false;
    boolean playerIsCorrupted = false;
    boolean enemyIsCorrupted = false;
    boolean playerIsCursed = false;
    boolean enemyIsCursed = false;
    boolean playerIsAgonized = false;
    boolean enemyIsAgonized = false;
    boolean playerIsMaledicted = false;
    boolean enemyIsMaledicted = false;
    boolean playerIsSentenced = false;
    boolean enemyIsSentenced = false;
    boolean playerIsHoarding = false;
    boolean enemyIsHoarding = false;
    boolean playerTurn = true;
    boolean playerCard1Used = false, playerCard2Used = false, playerCard3Used = false, playerCard4Used = false,
            playerCard5Used = false, playerCard6Used = false;
    boolean enemyCard1Used = false, enemyCard2Used = false, enemyCard3Used = false, enemyCard4Used = false,
            enemyCard5Used = false, enemyCard6Used = false;
    boolean errorMsg = false;
    boolean playerWon = false;
    boolean nextObjIsInfested = false;
    boolean resetWorked = false;
    boolean playerStrawSelected = false;
    boolean strawWon = false;
    private Handler myHandler = new Handler();
    DBHandler db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world001);
        layout_objectRow = (ViewGroup) findViewById(R.id.objectRow);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        db = new DBHandler(this);

        /* SETS ANIMATIONS */
        ani_fadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.ani_fade_in);
        ani_fadeOut = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.ani_fade_out);
        ani_zoomIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.ani_zoom_in);
        ani_shake = AnimationUtils.loadAnimation(this, R.anim.ani_shake);
        ani_infest_shake = AnimationUtils.loadAnimation(this, R.anim.ani_infest_shake);
        ani_scoregain = AnimationUtils.loadAnimation(this, R.anim.ani_scoregain);
        ani_resetscore = AnimationUtils.loadAnimation(this, R.anim.ani_resetscore);

        /* SETS OBJECTS IN OBJECT ROW */
        obj001 = (ImageButton) findViewById(R.id.obj001);
        obj002 = (ImageButton) findViewById(R.id.obj002);
        obj003 = (ImageButton) findViewById(R.id.obj003);
        obj004 = (ImageButton) findViewById(R.id.obj004);
        obj005 = (ImageButton) findViewById(R.id.obj005);
        obj006 = (ImageButton) findViewById(R.id.obj006);
        obj007 = (ImageButton) findViewById(R.id.obj007);
        obj008 = (ImageButton) findViewById(R.id.obj008);
        obj009 = (ImageButton) findViewById(R.id.obj009);
        obj010 = (ImageButton) findViewById(R.id.obj010);
        obj011 = (ImageButton) findViewById(R.id.obj011);
        obj012 = (ImageButton) findViewById(R.id.obj012);
        obj013 = (ImageButton) findViewById(R.id.obj013);
        obj014 = (ImageButton) findViewById(R.id.obj014);
        obj015 = (ImageButton) findViewById(R.id.obj015);
        obj016 = (ImageButton) findViewById(R.id.obj016);
        obj001.setOnClickListener(this);
        obj002.setOnClickListener(this);
        obj003.setOnClickListener(this);
        obj004.setOnClickListener(this);
        obj005.setOnClickListener(this);
        obj006.setOnClickListener(this);
        obj007.setOnClickListener(this);
        obj008.setOnClickListener(this);
        obj009.setOnClickListener(this);
        obj010.setOnClickListener(this);
        obj011.setOnClickListener(this);
        obj012.setOnClickListener(this);
        obj013.setOnClickListener(this);
        obj014.setOnClickListener(this);
        obj015.setOnClickListener(this);
        obj016.setOnClickListener(this);

        /* SETS THE BUTTON */
        btnEndTurn = (Button) findViewById(R.id.bEndTurn);
        btnEndTurn.setOnClickListener(this);

        /*SETS STATUS ICONS */
        playerStatusIcon1 = (ImageView) findViewById(R.id.tvPlayerStatus1);
        playerStatusIcon2 = (ImageView) findViewById(R.id.tvPlayerStatus2);
        playerStatusIcon3 = (ImageView) findViewById(R.id.tvPlayerStatus3);
        playerStatusIcon4 = (ImageView) findViewById(R.id.tvPlayerStatus4);
        playerStatusIcon5 = (ImageView) findViewById(R.id.tvPlayerStatus5);
        enemyStatusIcon1 = (ImageView) findViewById(R.id.tvEnemyStatus1);
        enemyStatusIcon2 = (ImageView) findViewById(R.id.tvEnemyStatus2);
        enemyStatusIcon3 = (ImageView) findViewById(R.id.tvEnemyStatus3);
        enemyStatusIcon4 = (ImageView) findViewById(R.id.tvEnemyStatus4);
        enemyStatusIcon5 = (ImageView) findViewById(R.id.tvEnemyStatus5);

        /* SETS CARDS  */
        ivPlayerPortrait = (ImageView) findViewById(R.id.ivPlayerPortrait);
        ivEnemyPortrait = (ImageView) findViewById(R.id.ivEnemyPortrait);
        ivEnemyPortrait.setImageResource(R.drawable.portraint_miniboss);
        ivCenterCardFrame = (ImageView) findViewById(R.id.ivCenterCardFrame);
        playerCard1 = (ImageButton) findViewById(R.id.ibPlayerCard1);
        playerCard2 = (ImageButton) findViewById(R.id.ibPlayerCard2);
        playerCard3 = (ImageButton) findViewById(R.id.ibPlayerCard3);
        playerCard4 = (ImageButton) findViewById(R.id.ibPlayerCard4);
        playerCard5 = (ImageButton) findViewById(R.id.ibPlayerCard5);
        playerCard6 = (ImageButton) findViewById(R.id.ibPlayerCard6);
        playerCard1.setOnClickListener(this);
        playerCard2.setOnClickListener(this);
        playerCard3.setOnClickListener(this);
        playerCard4.setOnClickListener(this);
        playerCard5.setOnClickListener(this);
        playerCard6.setOnClickListener(this);

        enemyCard1 = (ImageButton) findViewById((R.id.ibEnemyCard1));
        enemyCard2 = (ImageButton) findViewById((R.id.ibEnemyCard2));
        enemyCard3 = (ImageButton) findViewById((R.id.ibEnemyCard3));
        enemyCard4 = (ImageButton) findViewById((R.id.ibEnemyCard4));
        enemyCard5 = (ImageButton) findViewById((R.id.ibEnemyCard5));
        enemyCard6 = (ImageButton) findViewById((R.id.ibEnemyCard6));

        /* SETS VARIOUS VIEWS */
        ivCenterImage = (ImageView) findViewById(R.id.ivCenterImage);
        tvPlayerName = (TextView) findViewById(R.id.tvPlayerName);
        tvPlayerLevel = (TextView) findViewById(R.id.tvLvNumber);
        tvPlayerExp = (TextView) findViewById(R.id.tvExpNumber);
        tvPlayerScore = (TextView) findViewById(R.id.tvPlayerScore);
        tvCenterMessage = (TextView) findViewById(R.id.tvcenterMessage);
        tvPlayerMovesNumber = (TextView) findViewById(R.id.tvPlayerMovesLeftNumber);
        tvEnemyMovesNumber = (TextView) findViewById(R.id.tvEnemyMovesNr);
        tvEnemyScore = (TextView) findViewById(R.id.tvEnemyScore);
        tvEnemyName = (TextView) findViewById(R.id.tvEnemyName);
        tvCenterMessage.setText("");
        tvEnemyName.setText(enemyName);
        tvEnemyLvl = (TextView) findViewById(R.id.tvEnemyLvl);
        tvEnemyLvl.setText("Lv: 2");
        tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
        tvEnemyMovesNumber.setText(String.valueOf(enemyMoves));

        setCenterTextSize();
        getScreenSize();
        getPlayerInfo();
        getLevelInfo();
        storeCurrentLevel();
        getPlayerCards();
        setPlayerCardIcons();
        setEnemyCardsIcons();

        playerHaste = playerName + " gains Haste";
        playerConcentrate = playerName + " gains Concentrate";
        playerSlowed = playerName + " suffers Slow";
        playerCorrupted = playerName + " suffers Corruption";
        playerCursed = playerName + " suffers Curse";
        playerAgonized = playerName + " suffers Agony";
        playerMaledicted = playerName + " suffers Malediction";
        playerSentenced = playerName + " suffers Death Sentence";
        playerCured = playerName + " cures all ailments";
        playerAlteredTime = playerName + " alters time";
        playerGainAnother = playerName + " gains another turn!";
        playerProtected = playerName + " gains Protect";
        playerHoarded = playerName + " keeps played card!";
        playerHoard = playerName + " gains Hoard";
        playerDispelled = playerName + " suffers Dispel";
        playerStatuses[0] = "";
        playerStatuses[1] = "";
        playerStatuses[2] = "";
        playerStatuses[3] = "";
        playerStatuses[4] = "";

        enemyStatuses[0] = "";
        enemyStatuses[1] = "";
        enemyStatuses[2] = "";
        enemyStatuses[3] = "";
        enemyStatuses[4] = "";

        SoundEffects.setupSounds(this);
        clearSoundId = 0;

        coinFlipStart();
    }

    /* This Method contains a switch handling player clicks on wheat */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ibPlayerCard1:
                selectedCard = 1;
                if (playerCard1Type != 0 && playerMoves >= getCardCost() + playerCorruptedPenalty && objectsRemaining != 0) {
                    String message = "Play this card?";
                    playCardConfirm(message, Activity_W001_L004.this);
                }
                break;
            case R.id.ibPlayerCard2:
                selectedCard = 2;
                if (playerCard2Type != 0 && playerMoves >= getCardCost() + playerCorruptedPenalty && objectsRemaining != 0) {
                    String message = "Play this card?";
                    playCardConfirm(message, Activity_W001_L004.this);
                }
                break;
            case R.id.ibPlayerCard3:
                selectedCard = 3;
                if (playerCard3Type != 0 && playerMoves >= getCardCost() + playerCorruptedPenalty && objectsRemaining != 0) {
                    String message = "Play this card?";
                    playCardConfirm(message, Activity_W001_L004.this);
                }
                break;
            case R.id.ibPlayerCard4:
                selectedCard = 4;
                if (playerCard4Type != 0 && playerMoves >= getCardCost() + playerCorruptedPenalty && objectsRemaining != 0) {
                    String message = "Play this card?";
                    playCardConfirm(message, Activity_W001_L004.this);
                }
                break;
            case R.id.ibPlayerCard5:
                selectedCard = 5;
                if (playerCard5Type != 0 && playerMoves >= getCardCost() + playerCorruptedPenalty && objectsRemaining != 0) {
                    String message = "Play this card?";
                    playCardConfirm(message, Activity_W001_L004.this);
                }
                break;
            case R.id.ibPlayerCard6:
                selectedCard = 6;
                if (playerCard6Type != 0 && playerMoves >= getCardCost() + playerCorruptedPenalty && objectsRemaining != 0) {
                    String message = "Play this card?";
                    playCardConfirm(message, Activity_W001_L004.this);
                }
                break;
            case R.id.bEndTurn:
                if (objectsRemaining != 1 || playerMoves <= 2) {
                    btnEndTurn.setEnabled(false);
                    btnEndTurn.setText("Enemy Turn");
                    disable(layout_objectRow);
                    disablePlayerCards();
                    enemyTurnStart();
                } else {
                    tvCenterMessage.setText("You can't pass now");
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 500);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                        }
                    }, 1000);
                }
                break;
            case R.id.obj001:
                if (nextObjIsInfested && infestedObjRemainingHits >= 1){
                    if (objectsRemaining == 16 && playerMoves >= 1 + playerCorruptedPenalty){
                        playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                        tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                        obj001.startAnimation(ani_infest_shake);
                        disable(layout_objectRow);
                        disablePlayerCards();
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                enable(layout_objectRow);
                                enablePlayerCards();
                                infestedObjRemainingHits--;
                            }
                        }, 1000);
                        break;
                    }
                } else if (nextObjIsInfested && infestedObjRemainingHits == 0){
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj001.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                            nextObjIsInfested = false;
                        }
                    }, 100);
                    break;
                }
                if (objectsRemaining == 16 && playerMoves >= 1 + playerCorruptedPenalty) {
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj001.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                        }
                    }, 100);
                }
                break;
            case R.id.obj002:
                if (nextObjIsInfested && infestedObjRemainingHits >= 1){
                    if (objectsRemaining == 15 && playerMoves >= 1 + playerCorruptedPenalty){
                        playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                        tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                        obj002.startAnimation(ani_infest_shake);
                        disable(layout_objectRow);
                        disablePlayerCards();
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                enable(layout_objectRow);
                                enablePlayerCards();
                                infestedObjRemainingHits--;
                            }
                        }, 1000);
                        break;
                    }
                } else if (nextObjIsInfested && infestedObjRemainingHits == 0){
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj002.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                            nextObjIsInfested = false;
                        }
                    }, 100);
                    break;
                }
                if (objectsRemaining == 15 && playerMoves >= 1 + playerCorruptedPenalty) {
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj002.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                        }
                    }, 100);
                }
                break;
            case R.id.obj003:
                if (nextObjIsInfested && infestedObjRemainingHits >= 1){
                    if (objectsRemaining == 14 && playerMoves >= 1 + playerCorruptedPenalty){
                        playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                        tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                        obj003.startAnimation(ani_infest_shake);
                        disable(layout_objectRow);
                        disablePlayerCards();
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                enable(layout_objectRow);
                                enablePlayerCards();
                                infestedObjRemainingHits--;
                            }
                        }, 1000);
                        break;
                    }
                } else if (nextObjIsInfested && infestedObjRemainingHits == 0){
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj003.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                            nextObjIsInfested = false;
                        }
                    }, 100);
                    break;
                }
                if (objectsRemaining == 14 && playerMoves >= 1 + playerCorruptedPenalty) {
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj003.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                        }
                    }, 100);
                }
                break;
            case R.id.obj004:
                if (nextObjIsInfested && infestedObjRemainingHits >= 1){
                    if (objectsRemaining == 13 && playerMoves >= 1 + playerCorruptedPenalty){
                        playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                        tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                        obj004.startAnimation(ani_infest_shake);
                        disable(layout_objectRow);
                        disablePlayerCards();
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                enable(layout_objectRow);
                                enablePlayerCards();
                                infestedObjRemainingHits--;
                            }
                        }, 1000);
                        break;
                    }
                } else if (nextObjIsInfested && infestedObjRemainingHits == 0){
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj004.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                            nextObjIsInfested = false;
                        }
                    }, 100);
                    break;
                }
                if (objectsRemaining == 13 && playerMoves >= 1 + playerCorruptedPenalty) {
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj004.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                        }
                    }, 100);
                }
                break;
            case R.id.obj005:
                if (nextObjIsInfested && infestedObjRemainingHits >= 1){
                    if (objectsRemaining == 12 && playerMoves >= 1 + playerCorruptedPenalty){
                        playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                        tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                        obj005.startAnimation(ani_infest_shake);
                        disable(layout_objectRow);
                        disablePlayerCards();
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                enable(layout_objectRow);
                                enablePlayerCards();
                                infestedObjRemainingHits--;
                            }
                        }, 1000);
                        break;
                    }
                } else if (nextObjIsInfested && infestedObjRemainingHits == 0){
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj005.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                            nextObjIsInfested = false;
                        }
                    }, 100);
                    break;
                }
                if (objectsRemaining == 12 && playerMoves >= 1 + playerCorruptedPenalty) {
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj005.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                        }
                    }, 100);
                }
                break;
            case R.id.obj006:
                if (nextObjIsInfested && infestedObjRemainingHits >= 1){
                    if (objectsRemaining == 11 && playerMoves >= 1 + playerCorruptedPenalty){
                        playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                        tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                        obj006.startAnimation(ani_infest_shake);
                        disable(layout_objectRow);
                        disablePlayerCards();
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                enable(layout_objectRow);
                                enablePlayerCards();
                                infestedObjRemainingHits--;
                            }
                        }, 1000);
                        break;
                    }
                } else if (nextObjIsInfested && infestedObjRemainingHits == 0){
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj006.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                            nextObjIsInfested = false;
                        }
                    }, 100);
                    break;
                }
                if (objectsRemaining == 11 && playerMoves >= 1 + playerCorruptedPenalty) {
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj006.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                        }
                    }, 100);
                }
                break;
            case R.id.obj007:
                if (nextObjIsInfested && infestedObjRemainingHits >= 1){
                    if (objectsRemaining == 10 && playerMoves >= 1 + playerCorruptedPenalty){
                        playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                        tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                        obj007.startAnimation(ani_infest_shake);
                        disable(layout_objectRow);
                        disablePlayerCards();
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                enable(layout_objectRow);
                                enablePlayerCards();
                                infestedObjRemainingHits--;
                            }
                        }, 1000);
                        break;
                    }
                } else if (nextObjIsInfested && infestedObjRemainingHits == 0){
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj007.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                            nextObjIsInfested = false;
                        }
                    }, 100);
                    break;
                }
                if (objectsRemaining == 10 && playerMoves >= 1 + playerCorruptedPenalty) {
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj007.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                        }
                    }, 100);
                }
                break;
            case R.id.obj008:
                if (nextObjIsInfested && infestedObjRemainingHits >= 1){
                    if (objectsRemaining == 9 && playerMoves >= 1 + playerCorruptedPenalty){
                        playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                        tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                        obj008.startAnimation(ani_infest_shake);
                        disable(layout_objectRow);
                        disablePlayerCards();
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                enable(layout_objectRow);
                                enablePlayerCards();
                                infestedObjRemainingHits--;
                            }
                        }, 1000);
                        break;
                    }
                } else if (nextObjIsInfested && infestedObjRemainingHits == 0){
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj008.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                            nextObjIsInfested = false;
                        }
                    }, 100);
                    break;
                }
                if (objectsRemaining == 9 && playerMoves >= 1 + playerCorruptedPenalty) {
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj008.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                        }
                    }, 100);
                }
                break;
            case R.id.obj009:
                if (nextObjIsInfested && infestedObjRemainingHits >= 1){
                    if (objectsRemaining == 8 && playerMoves >= 1 + playerCorruptedPenalty){
                        playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                        tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                        obj009.startAnimation(ani_infest_shake);
                        disable(layout_objectRow);
                        disablePlayerCards();
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                enable(layout_objectRow);
                                enablePlayerCards();
                                infestedObjRemainingHits--;
                            }
                        }, 1000);
                        break;
                    }
                } else if (nextObjIsInfested && infestedObjRemainingHits == 0){
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj009.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                            nextObjIsInfested = false;
                        }
                    }, 100);
                    break;
                }
                if (objectsRemaining == 8 && playerMoves >= 1 + playerCorruptedPenalty) {
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj009.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                        }
                    }, 100);
                }
                break;
            case R.id.obj010:
                if (nextObjIsInfested && infestedObjRemainingHits >= 1){
                    if (objectsRemaining == 7 && playerMoves >= 1 + playerCorruptedPenalty){
                        playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                        tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                        obj010.startAnimation(ani_infest_shake);
                        disable(layout_objectRow);
                        disablePlayerCards();
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                enable(layout_objectRow);
                                enablePlayerCards();
                                infestedObjRemainingHits--;
                            }
                        }, 1000);
                        break;
                    }
                } else if (nextObjIsInfested && infestedObjRemainingHits == 0){
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj010.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                            nextObjIsInfested = false;
                        }
                    }, 100);
                    break;
                }
                if (objectsRemaining == 7 && playerMoves >= 1 + playerCorruptedPenalty) {
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj010.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                        }
                    }, 100);
                }
                break;
            case R.id.obj011:
                if (nextObjIsInfested && infestedObjRemainingHits >= 1){
                    if (objectsRemaining == 6 && playerMoves >= 1 + playerCorruptedPenalty){
                        playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                        tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                        obj011.startAnimation(ani_infest_shake);
                        disable(layout_objectRow);
                        disablePlayerCards();
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                enable(layout_objectRow);
                                enablePlayerCards();
                                infestedObjRemainingHits--;
                            }
                        }, 1000);
                        break;
                    }
                } else if (nextObjIsInfested && infestedObjRemainingHits == 0){
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj011.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                            nextObjIsInfested = false;
                        }
                    }, 100);
                    break;
                }
                if (objectsRemaining == 6 && playerMoves >= 1 + playerCorruptedPenalty) {
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj011.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                        }
                    }, 100);
                }
                break;
            case R.id.obj012:
                if (nextObjIsInfested && infestedObjRemainingHits >= 1){
                    if (objectsRemaining == 5 && playerMoves >= 1 + playerCorruptedPenalty){
                        playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                        tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                        obj012.startAnimation(ani_infest_shake);
                        disable(layout_objectRow);
                        disablePlayerCards();
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                enable(layout_objectRow);
                                enablePlayerCards();
                                infestedObjRemainingHits--;
                            }
                        }, 1000);
                        break;
                    }
                } else if (nextObjIsInfested && infestedObjRemainingHits == 0){
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj012.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                            nextObjIsInfested = false;
                        }
                    }, 100);
                    break;
                }
                if (objectsRemaining == 5 && playerMoves >= 1 + playerCorruptedPenalty) {
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj012.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                        }
                    }, 100);
                }
                break;
            case R.id.obj013:
                if (nextObjIsInfested && infestedObjRemainingHits >= 1){
                    if (objectsRemaining == 4 && playerMoves >= 1 + playerCorruptedPenalty){
                        playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                        tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                        obj013.startAnimation(ani_infest_shake);
                        disable(layout_objectRow);
                        disablePlayerCards();
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                enable(layout_objectRow);
                                enablePlayerCards();
                                infestedObjRemainingHits--;
                            }
                        }, 1000);
                        break;
                    }
                } else if (nextObjIsInfested && infestedObjRemainingHits == 0){
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj013.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                            nextObjIsInfested = false;
                        }
                    }, 100);
                    break;
                }
                if (objectsRemaining == 4 && playerMoves >= 1 + playerCorruptedPenalty) {
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj013.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                        }
                    }, 100);
                }
                break;
            case R.id.obj014:
                if (nextObjIsInfested && infestedObjRemainingHits >= 1){
                    if (objectsRemaining == 3 && playerMoves >= 1 + playerCorruptedPenalty){
                        playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                        tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                        obj014.startAnimation(ani_infest_shake);
                        disable(layout_objectRow);
                        disablePlayerCards();
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                enable(layout_objectRow);
                                enablePlayerCards();
                                infestedObjRemainingHits--;
                            }
                        }, 1000);
                        break;
                    }
                } else if (nextObjIsInfested && infestedObjRemainingHits == 0){
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj014.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                            nextObjIsInfested = false;
                        }
                    }, 100);
                    break;
                }
                if (objectsRemaining == 3 && playerMoves >= 1 + playerCorruptedPenalty) {
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj014.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                        }
                    }, 100);
                }
                break;
            case R.id.obj015:
                if (nextObjIsInfested && infestedObjRemainingHits >= 1){
                    if (objectsRemaining == 2 && playerMoves >= 1 + playerCorruptedPenalty){
                        playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                        tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                        obj015.startAnimation(ani_infest_shake);
                        disable(layout_objectRow);
                        disablePlayerCards();
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                enable(layout_objectRow);
                                enablePlayerCards();
                                infestedObjRemainingHits--;
                            }
                        }, 1000);
                        break;
                    }
                } else if (nextObjIsInfested && infestedObjRemainingHits == 0){
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj015.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                            nextObjIsInfested = false;
                        }
                    }, 100);
                    break;
                }
                if (objectsRemaining == 2 && playerMoves >= 1 + playerCorruptedPenalty) {
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    playerScore = playerScore + playerClearAward;
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj015.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enable(layout_objectRow);
                            enablePlayerCards();
                            objectsRemaining--;
                        }
                    }, 100);
                }
                break;
            case R.id.obj016:
                if (nextObjIsInfested && infestedObjRemainingHits >= 1){
                    if (objectsRemaining == 1 && playerMoves >= 1 + playerCorruptedPenalty){
                        playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                        tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                        obj016.startAnimation(ani_infest_shake);
                        disable(layout_objectRow);
                        disablePlayerCards();
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                enable(layout_objectRow);
                                enablePlayerCards();
                                infestedObjRemainingHits--;
                            }
                        }, 1000);
                        break;
                    }
                } else if (nextObjIsInfested && infestedObjRemainingHits == 0){
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj016.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            objectsRemaining--;
                            nextObjIsInfested = false;
                        }
                    }, 100);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            checkIfNoObjRemains();
                        }
                    }, 1400);
                    break;
                }
                if (objectsRemaining == 1 && playerMoves >= 1 + playerCorruptedPenalty) {
                    SoundEffects.playSound(clearSoundId);
                    playerMoves = playerMoves - 1 - playerCorruptedPenalty;
                    tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                    obj016.setImageResource(R.drawable.object_wheatbroken);
                    disable(layout_objectRow);
                    disablePlayerCards();
                    btnEndTurn.setClickable(false);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            objectsRemaining--;
                        }
                    }, 100);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            checkIfNoObjRemains();
                        }
                    }, 1400);
                }
                break;
        }
    }

    /* ENEMY TURN START METHOD */
    private void enemyTurnStart() {
        if (playerHasAlteredTime){
            playerHasAlteredTime = false;
            tvCenterMessage.setText(playerGainAnother);
            tvCenterMessage.startAnimation(ani_fadeIn);
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                }
            }, 1000);
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    clearPlayerStatus("Rewind");
                    playerTurnStart();
                }
            }, 2000);
        } else {
            enemyMoves = 3;
            playerTurn = false;
            updateEnemyStatuses();
        /* Calls the method to check if player buffs have run out their duration */
            checkPlayerStatues();
            disablePlayerCards();
            tvCenterMessage.setText("ENEMY TURN");
            tvCenterMessage.startAnimation(ani_fadeIn);
            tvEnemyMovesNumber.setText(String.valueOf(enemyMoves));

            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                }
            }, 1000);

            myHandler.postDelayed(new Runnable() {
                public void run() {
                    checkIfEnemyCurseEnds();
                }
            }, 2000);
        }
    }

    /* CHECKING IF ENEMY HAS DEBUFFS THAT RUNS OUT. TO AVOID A MESS, THEY ARE
    ALL CHECKED AND REMOVED SEPERATELY. STARTING WITH CURSE, THEN AGONY, AND SO
    ON, AT THE END OF THE CHAIN, IT STARTS ENEMY TURN.
     */

    private void checkIfEnemyCurseEnds(){
        if (enemyIsCursed && enemyCurseCountdown == 0){
            enemyCursedEffect();
        } else {
            checkIfEnemyAgonyEnds();
        }
    }

    private void checkIfEnemyAgonyEnds(){
        if (enemyIsAgonized && enemyAgonyCountdown == 0){
            enemyAgonizedEnd();
        } else {
            checkIfEnemyMaledictionEnds();
        }
    }

    private void checkIfEnemyMaledictionEnds(){
        if (enemyIsMaledicted && enemyMaledictionCountdown == 0){
            enemyMaledictedEffect();
        } else {
            checkIfEnemySentenceEnds();
        }
    }

    private void checkIfEnemySentenceEnds(){
        if (enemyIsSentenced && enemySentenceCountdown == 0){
            enemySentencedEffect();
        } else {
            checkIfEnemyProtectEnds();
        }
    }

    private void checkIfEnemyProtectEnds(){
        if (enemyHasProtect && enemyProtectCountdown == 0){
            enemyProtectEnd();
        } else {
            enemyTurn();
        }
    }

    /*---------------------------------*/

    /* ENEMY TURN MOVES */
    private void enemyTurn(){
        enemyTurnCounter++;
        /* Checks if enemy has any cards left and decides move pattern accordingly */
        if (enemyCardsRemaining > 0){
            int cardOrClear;
            if (enemyTurnCounter == 1){
                cardOrClear = 99;
            } else {
                cardOrClear = genRand(100);
            }
            /* If number is higher than 80 the AI will play a card */
            if (cardOrClear >= 80){
                if (enemyTurnCounter == 1){
                    enemyPickedCard = 0;
                } else {
                    enemyPickedCard = randomizeEnemyCardSelect();
                }
                if (enemyPickedCard == 0 && enemyMoves >= enemyCard1Cost + enemyCorruptedPenalty){
                    lastEnemyPlayedCard = enemyCard1Name;
                    enemyCard1.setColorFilter(Color.argb(255, 255, 255, 255));
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enemyMoves = enemyMoves - enemyCard1Cost - enemyCorruptedPenalty;
                            tvEnemyMovesNumber.setText(String.valueOf(enemyMoves));
                            animateEnemyCard();
                        }
                    }, 2000);
                    if (!enemyIsHoarding){
                        enemyCard1Used = true;
                        enemyCardsRemaining--;
                        pool.add(0);
                    } else {
                        tvCenterMessage.setText(enemyHoarded);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                    }
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            executeEnemyCardEffect();
                        }
                    }, 6500);

                    //CHANGE WAIT VALUE DEPENDING ON WHICH CARD THE AI IS ASSIGNED (8000 default, 18000 for Demonic Prayer)
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            checkEnemyMoves();
                        }
                    }, 8000);
                } else if (enemyPickedCard == 0 && enemyMoves < enemyCard1Cost + enemyCorruptedPenalty) {
                    aiClearObject();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            checkEnemyMoves();
                        }
                    }, 1000);
                }

                if (enemyPickedCard == 1 && enemyMoves >= enemyCard2Cost + enemyCorruptedPenalty){
                    lastEnemyPlayedCard = enemyCard2Name;
                    enemyCard2.setColorFilter(Color.argb(255, 255, 255, 255));
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enemyMoves = enemyMoves - enemyCard2Cost - enemyCorruptedPenalty;
                            tvEnemyMovesNumber.setText(String.valueOf(enemyMoves));
                            animateEnemyCard();
                        }
                    }, 2000);
                    if (!enemyIsHoarding){
                        enemyCard2Used = true;
                        enemyCardsRemaining--;
                        pool.add(1);
                    } else {
                        tvCenterMessage.setText(enemyHoarded);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                    }
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            executeEnemyCardEffect();
                        }
                    }, 6500);

                    //CHANGE WAIT VALUE DEPENDING ON WHICH CARD THE AI IS ASSIGNED (8000 default, 18000 for Demonic Prayer)
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            checkEnemyMoves();
                        }
                    }, 8000);
                } else if (enemyPickedCard == 1 && enemyMoves < enemyCard2Cost + enemyCorruptedPenalty) {
                    aiClearObject();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            checkEnemyMoves();
                        }
                    }, 1000);
                }

                if (enemyPickedCard == 2 && enemyMoves >= enemyCard3Cost + enemyCorruptedPenalty){
                    lastEnemyPlayedCard = enemyCard3Name;
                    enemyCard3.setColorFilter(Color.argb(255, 255, 255, 255));
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enemyMoves = enemyMoves - enemyCard3Cost - enemyCorruptedPenalty;
                            tvEnemyMovesNumber.setText(String.valueOf(enemyMoves));
                            animateEnemyCard();
                        }
                    }, 2000);
                    if (!enemyIsHoarding){
                        enemyCard3Used = true;
                        enemyCardsRemaining--;
                        pool.add(2);
                    } else {
                        tvCenterMessage.setText(enemyHoarded);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                    }
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            executeEnemyCardEffect();
                        }
                    }, 6500);

                    //CHANGE WAIT VALUE DEPENDING ON WHICH CARD THE AI IS ASSIGNED (8000 default, 18000 for Demonic Prayer)
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            checkEnemyMoves();
                        }
                    }, 8000);
                } else if (enemyPickedCard == 2 && enemyMoves < enemyCard3Cost + enemyCorruptedPenalty) {
                    aiClearObject();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            checkEnemyMoves();
                        }
                    }, 1000);
                }

                if (enemyPickedCard == 3 && enemyMoves >= enemyCard4Cost + enemyCorruptedPenalty){
                    lastEnemyPlayedCard = enemyCard4Name;
                    enemyCard4.setColorFilter(Color.argb(255, 255, 255, 255));
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enemyMoves = enemyMoves - enemyCard4Cost - enemyCorruptedPenalty;
                            tvEnemyMovesNumber.setText(String.valueOf(enemyMoves));
                            animateEnemyCard();
                        }
                    }, 2000);
                    if (!enemyIsHoarding){
                        enemyCard4Used = true;
                        enemyCardsRemaining--;
                        pool.add(3);
                    } else {
                        tvCenterMessage.setText(enemyHoarded);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                    }
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            executeEnemyCardEffect();
                        }
                    }, 6500);

                    //CHANGE WAIT VALUE DEPENDING ON WHICH CARD THE AI IS ASSIGNED (8000 default, 18000 for Demonic Prayer)
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            checkEnemyMoves();
                        }
                    }, 8000);
                } else if (enemyPickedCard == 3 && enemyMoves < enemyCard4Cost + enemyCorruptedPenalty) {
                    aiClearObject();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            checkEnemyMoves();
                        }
                    }, 1000);
                }

                if (enemyPickedCard == 4 && enemyMoves >= enemyCard5Cost + enemyCorruptedPenalty){
                    lastEnemyPlayedCard = enemyCard5Name;
                    enemyCard5.setColorFilter(Color.argb(255, 255, 255, 255));
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enemyMoves = enemyMoves - enemyCard5Cost - enemyCorruptedPenalty;
                            tvEnemyMovesNumber.setText(String.valueOf(enemyMoves));
                            animateEnemyCard();
                        }
                    }, 2000);
                    if (!enemyIsHoarding){
                        enemyCard5Used = true;
                        enemyCardsRemaining--;
                        pool.add(4);
                    } else {
                        tvCenterMessage.setText(enemyHoarded);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                    }
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            executeEnemyCardEffect();
                        }
                    }, 6500);

                    //IF ENEMY USES MIMIC CARD IT NEEDS LONGER WAIT (18000) TIMER THAN NORMAL (8000)
                    if (lastPlayerPlayedCard.equals("Demonic Prayer")){
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                checkEnemyMoves();
                            }
                        }, 18000);
                    } else {
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                checkEnemyMoves();
                            }
                        }, 8000);
                    }

                } else if (enemyPickedCard == 4 && enemyMoves < enemyCard5Cost + enemyCorruptedPenalty) {
                    aiClearObject();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            checkEnemyMoves();
                        }
                    }, 1000);
                }

                if (enemyPickedCard == 5 && enemyMoves >= enemyCard6Cost + enemyCorruptedPenalty){
                    lastEnemyPlayedCard = enemyCard6Name;
                    enemyCard6.setColorFilter(Color.argb(255, 255, 255, 255));
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enemyMoves = enemyMoves - enemyCard6Cost - enemyCorruptedPenalty;
                            tvEnemyMovesNumber.setText(String.valueOf(enemyMoves));
                            animateEnemyCard();
                        }
                    }, 2000);
                    if (!enemyIsHoarding){
                        enemyCard6Used = true;
                        enemyCardsRemaining--;
                        pool.add(5);
                    } else {
                        tvCenterMessage.setText(enemyHoarded);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                    }
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            executeEnemyCardEffect();
                        }
                    }, 6500);

                    //IF ENEMY USES MIMIC CARD IT NEEDS LONGER WAIT (18000) TIMER THAN NORMAL (8000)
                    if (lastPlayerPlayedCard.equals("Demonic Prayer")){
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                checkEnemyMoves();
                            }
                        }, 18000);
                    } else {
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                checkEnemyMoves();
                            }
                        }, 8000);
                    }

                } else if (enemyPickedCard == 5 && enemyMoves < enemyCard6Cost + enemyCorruptedPenalty) {
                    aiClearObject();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            checkEnemyMoves();
                        }
                    }, 1000);
                }

            } else {
               /* If number is less than 80, the AI will clear */
                if (cardOrClear < 80) {
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            aiClearObject();
                            checkEnemyMoves();
                        }
                    }, 1000);
                }
            }
        } else {
           /* IF ENEMY HAS NO CARDS LEFT, IT WILL CLEAR */
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    aiClearObject();
                    checkEnemyMoves();
                }
            }, 1000);
        }

    }

    /* UPDATE ENEMY STATUSES */
    private void updateEnemyStatuses(){
        if (enemyHasConcentrate){
            enemyClearAward = 4;
            enemyHasConcentrate = false;
        }
        if (enemyIsCorrupted){
            enemyCorruptedPenalty = 1;
        }
        if (enemyHasHaste){
            enemyMoves = enemyMoves + 1;
        }
        if (enemyHasHaste2){
            enemyMoves = enemyMoves + 2;
        }
        if (enemyIsSlowed){
            enemyMoves = enemyMoves - 1;
        }
        if (enemyIsCursed && enemyCurseCountdown == -1){
            enemyCurseCountdown = 3;
        }
        if (enemyIsCursed && enemyCurseCountdown != -1){
            enemyCurseCountdown--;
        }
        if (enemyIsAgonized && enemyAgonyCountdown == -1){
            enemyAgonyCountdown = 3;
        }
        if (enemyIsAgonized && enemyAgonyCountdown >= 1){
            enemyScore = enemyScore - 3;
            tvEnemyScore.startAnimation(ani_shake);
            tvEnemyScore.setTextColor(getResources().getColor(R.color.textBrightRed));
            tvEnemyScore.setText("-3");
            if (enemyScore < 0){
                enemyScore = 0;
            }
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvEnemyScore.setTextColor(getResources().getColor(R.color.textBlack));
                    tvEnemyScore.setText(String.valueOf(enemyScore));
                    tvEnemyScore.startAnimation(ani_resetscore);
                    tvPlayerScore.clearAnimation();
                }
            }, 1000);
            enemyAgonyCountdown--;
        }
        if (enemyIsMaledicted && enemyMaledictionCountdown == -1){
            enemyMaledictionCountdown = 4;
        }
        if (enemyIsMaledicted && enemyMaledictionCountdown != -1){
            enemyMaledictionCountdown--;
        }
        if (enemyIsSentenced && enemySentenceCountdown == -1){
            enemySentenceCountdown = 3;
        }
        if (enemyIsSentenced && enemySentenceCountdown != -1){
            enemySentenceCountdown--;
        }
        if (enemyHasProtect && enemyProtectCountdown == -1){
            enemyProtectCountdown = 3;
        }
        if (enemyHasProtect && enemyProtectCountdown != -1){
            enemyProtectCountdown--;
        }
        enemyHasHaste = false;
        enemyHasHaste2 = false;
        enemyIsCorrupted = false;
    }

    /* CHECK ENEMY REMAINING MOVES */
    private void checkEnemyMoves(){

        myHandler.postDelayed(new Runnable() {
            public void run() {
                if (enemyMoves <= 0 || enemyCorruptedPenalty != 0 || objectsRemaining == 1){
                    enemyTurnEnd();
                } else {
                    if (objectsRemaining == 0){
                        checkIfNoObjRemains();
                    } else {
                        enemyTurn();
                    }
                }
            }
        }, 1000);
    }

    /* ENEMY TURN END METHOD */
    private void enemyTurnEnd() {
        if (objectsRemaining == 0) {
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    checkIfNoObjRemains();
                }
            }, 1000);
        } else {
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    playerTurnStart();
                }
            }, 1000);
        }
    }

    /* RETURN TO PLAYER TURN METHOD */
    private void playerTurnStart() {
        if (enemyHasAlteredTime) {
            enemyHasAlteredTime = false;
            tvCenterMessage.setText(enemyGainAnother);
            tvCenterMessage.startAnimation(ani_fadeIn);
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                }
            }, 1000);
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    clearEnemyStatus("Rewind");
                    enemyTurnStart();
                }
            }, 2000);
        } else {
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    playerTurn = true;
                    enemyMoves = 0;
                    playerMoves = 3;
                    updatePlayerStatuses();
                    tvEnemyMovesNumber.setText(String.valueOf(enemyMoves));
                    enemyIsSlowed = false;
                /* Calls the method to check if enemy buffs have run out their duration */
                    checkEnemyStatuses();
                    tvCenterMessage.setText("YOUR TURN");
                    tvCenterMessage.startAnimation(ani_fadeIn);
                }
            }, 1000);
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                }
            }, 2000);
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    checkIfPlayerCurseEnds();
                }
            }, 3000);
        }
    }

    /* CHECKING IF PLAYER HAS DEBUFFS THAT RUNS OUT. TO AVOID A MESS, THEY ARE
    ALL CHECKED AND REMOVED SEPERATELY. STARTING WITH CURSE, THEN AGONY, AND SO
    ON, AT THE END OF THE CHAIN, IT STARTS PLAYER TURN.
     */

    private void checkIfPlayerCurseEnds(){
        if (playerIsCursed && playerCurseCountdown == 0){
            playerCursedEffect();
        } else {
            checkIfPlayerAgonyEnds();
        }
    }

    private void checkIfPlayerAgonyEnds(){
        if (playerIsAgonized && playerAgonyCountdown == 0){
            playerAgonizedEnd();
        } else {
            checkIfPlayerMaledictionEnds();
        }
    }

    private void checkIfPlayerMaledictionEnds(){
        if (playerIsMaledicted && playerMaledictionCountdown == 0){
            playerMaledictedEffect();
        } else {
            checkIfPlayerSentenceEnds();
        }
    }

    private void checkIfPlayerSentenceEnds(){
        if (playerIsSentenced && playerSentenceCountdown == 0){
            playerSentencedEffect();
        } else {
            checkIfPlayerProtectEnds();
        }
    }

    private void checkIfPlayerProtectEnds(){
        if (playerHasProtect && playerProtectCountdown == 0){
            playerProtectEnd();
        } else {
            playerTurn();
        }
    }

    /*---------------------------------*/

    /* PLAYER TURN START */
    private void playerTurn(){
        btnEndTurn.setEnabled(true);
        btnEndTurn.setText("End Turn");
        enable(layout_objectRow);
        enablePlayerCards();
        tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
    }

    /* UPDATE PLAYER STATUSES */
    private void updatePlayerStatuses(){
        if (playerHasConcentrate){
            playerClearAward = 4;
            playerHasConcentrate = false;
        }
        if (playerIsCorrupted){
            playerCorruptedPenalty = 1;
        }
        if (playerHasHaste){
            playerMoves = playerMoves + 1;
        }
        if (playerHasHaste2){
            playerMoves = playerMoves + 2;
        }
        if (playerIsSlowed){
            playerMoves = playerMoves - 1;
        }
        if (playerIsCursed && playerCurseCountdown == -1){
            playerCurseCountdown = 3;
        }
        if (playerIsCursed && playerCurseCountdown != -1){
            playerCurseCountdown--;
        }
        if (playerIsAgonized && playerAgonyCountdown == -1){
            playerAgonyCountdown = 3;
        }
        if (playerIsAgonized && playerAgonyCountdown >= 1){
            playerScore = playerScore - 3;
            tvPlayerScore.startAnimation(ani_shake);
            tvPlayerScore.setTextColor(getResources().getColor(R.color.textBrightRed));
            tvPlayerScore.setText("-3");
            if (playerScore < 0){
                playerScore = 0;
            }
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvPlayerScore.setTextColor(getResources().getColor(R.color.textBlack));
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerScore.startAnimation(ani_resetscore);
                    tvEnemyScore.clearAnimation();
                }
            }, 1000);
            playerAgonyCountdown--;
        }
        if (playerIsMaledicted && playerMaledictionCountdown == -1){
            playerMaledictionCountdown = 3;
        }
        if (playerIsMaledicted && playerMaledictionCountdown != -1){
            playerMaledictionCountdown--;
        }
        if (playerIsSentenced && playerSentenceCountdown == -1){
            playerSentenceCountdown = 3;
        }
        if (playerIsSentenced && playerSentenceCountdown != -1){
            playerSentenceCountdown--;
        }
        if (playerHasProtect && playerProtectCountdown == -1){
            playerProtectCountdown = 3;
        }
        if (playerHasProtect && playerProtectCountdown != -1){
            playerProtectCountdown--;
        }
        playerIsSlowed = false;
        playerIsCorrupted = false;
        playerHasHaste = false;
        playerHasHaste2 = false;
    }

    /* DISABLES THE INTERFACE, PREVENTING PLAYER FROM CLICKING THE OBJECT ROW */
    private static void disable(ViewGroup layout) {
        layout.setEnabled(false);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            if (child instanceof ViewGroup) {
                disable((ViewGroup) child);
            } else {
                child.setEnabled(false);
            }
        }

    }

    /* ENABLES THE INTERFACE, ENABLING PLAYER TO USE ACTIONS */
    private static void enable(ViewGroup layout) {
        layout.setEnabled(true);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            if (child instanceof ViewGroup) {
                disable((ViewGroup) child);
            } else {
                child.setEnabled(true);
            }
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    /* THIS METHOD RUNS WHEN THE AI WANTS TO REMOVE 1 */
    private void aiClearObject() {
        enemyMoves = enemyMoves - 1 - enemyCorruptedPenalty;
        tvEnemyMovesNumber.setText(String.valueOf(enemyMoves));
        if (objectsRemaining == 16) {
            if (nextObjIsInfested && infestedObjRemainingHits >= 1) {
                obj001.startAnimation(ani_infest_shake);
                infestedObjRemainingHits--;
                return;
            }
            if (nextObjIsInfested && infestedObjRemainingHits == 0) {
                SoundEffects.playSound(clearSoundId);
                obj001.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                nextObjIsInfested = false;
                return;
            }
            if (!nextObjIsInfested){
                SoundEffects.playSound(clearSoundId);
                obj001.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                return;
            }
        }
        if (objectsRemaining == 15) {
            if (nextObjIsInfested && infestedObjRemainingHits >= 1) {
                obj002.startAnimation(ani_infest_shake);
                infestedObjRemainingHits--;
                return;
            }
            if (nextObjIsInfested && infestedObjRemainingHits == 0) {
                SoundEffects.playSound(clearSoundId);
                obj002.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                nextObjIsInfested = false;
                return;
            }
            if (!nextObjIsInfested){
                SoundEffects.playSound(clearSoundId);
                obj002.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                return;
            }
        }
        if (objectsRemaining == 14){
            if (nextObjIsInfested && infestedObjRemainingHits >= 1) {
                obj003.startAnimation(ani_infest_shake);
                infestedObjRemainingHits--;
                return;
            }
            if (nextObjIsInfested && infestedObjRemainingHits == 0) {
                SoundEffects.playSound(clearSoundId);
                obj003.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                nextObjIsInfested = false;
                return;
            }
            if (!nextObjIsInfested){
                SoundEffects.playSound(clearSoundId);
                obj003.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                return;
            }
        }
        if (objectsRemaining == 13){
            if (nextObjIsInfested && infestedObjRemainingHits >= 1) {
                obj004.startAnimation(ani_infest_shake);
                infestedObjRemainingHits--;
                return;
            }
            if (nextObjIsInfested && infestedObjRemainingHits == 0) {
                SoundEffects.playSound(clearSoundId);
                obj004.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                nextObjIsInfested = false;
                return;
            }
            if (!nextObjIsInfested){
                SoundEffects.playSound(clearSoundId);
                obj004.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                return;
            }
        }
        if (objectsRemaining == 12){
            if (nextObjIsInfested && infestedObjRemainingHits >= 1) {
                obj005.startAnimation(ani_infest_shake);
                infestedObjRemainingHits--;
                return;
            }
            if (nextObjIsInfested && infestedObjRemainingHits == 0) {
                SoundEffects.playSound(clearSoundId);
                obj005.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                nextObjIsInfested = false;
                return;
            }
            if (!nextObjIsInfested){
                SoundEffects.playSound(clearSoundId);
                obj005.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                return;
            }
        }
        if (objectsRemaining == 11){
            if (nextObjIsInfested && infestedObjRemainingHits >= 1) {
                obj006.startAnimation(ani_infest_shake);
                infestedObjRemainingHits--;
                return;
            }
            if (nextObjIsInfested && infestedObjRemainingHits == 0) {
                SoundEffects.playSound(clearSoundId);
                obj006.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                nextObjIsInfested = false;
                return;
            }
            if (!nextObjIsInfested){
                SoundEffects.playSound(clearSoundId);
                obj006.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                return;
            }
        }
        if (objectsRemaining == 10){
            if (nextObjIsInfested && infestedObjRemainingHits >= 1) {
                obj007.startAnimation(ani_infest_shake);
                infestedObjRemainingHits--;
                return;
            }
            if (nextObjIsInfested && infestedObjRemainingHits == 0) {
                SoundEffects.playSound(clearSoundId);
                obj007.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                nextObjIsInfested = false;
                return;
            }
            if (!nextObjIsInfested){
                SoundEffects.playSound(clearSoundId);
                obj007.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                return;
            }
        }
        if (objectsRemaining == 9){
            if (nextObjIsInfested && infestedObjRemainingHits >= 1) {
                obj008.startAnimation(ani_infest_shake);
                infestedObjRemainingHits--;
                return;
            }
            if (nextObjIsInfested && infestedObjRemainingHits == 0) {
                SoundEffects.playSound(clearSoundId);
                obj008.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                nextObjIsInfested = false;
                return;
            }
            if (!nextObjIsInfested){
                SoundEffects.playSound(clearSoundId);
                obj008.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                return;
            }
        }
        if (objectsRemaining == 8){
            if (nextObjIsInfested && infestedObjRemainingHits >= 1) {
                obj009.startAnimation(ani_infest_shake);
                infestedObjRemainingHits--;
                return;
            }
            if (nextObjIsInfested && infestedObjRemainingHits == 0) {
                SoundEffects.playSound(clearSoundId);
                obj009.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                nextObjIsInfested = false;
                return;
            }
            if (!nextObjIsInfested){
                SoundEffects.playSound(clearSoundId);
                obj009.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                return;
            }
        }
        if (objectsRemaining == 7){
            if (nextObjIsInfested && infestedObjRemainingHits >= 1) {
                obj010.startAnimation(ani_infest_shake);
                infestedObjRemainingHits--;
                return;
            }
            if (nextObjIsInfested && infestedObjRemainingHits == 0) {
                SoundEffects.playSound(clearSoundId);
                obj010.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                nextObjIsInfested = false;
                return;
            }
            if (!nextObjIsInfested){
                SoundEffects.playSound(clearSoundId);
                obj010.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                return;
            }
        }
        if (objectsRemaining == 6){
            if (nextObjIsInfested && infestedObjRemainingHits >= 1) {
                obj011.startAnimation(ani_infest_shake);
                infestedObjRemainingHits--;
                return;
            }
            if (nextObjIsInfested && infestedObjRemainingHits == 0) {
                SoundEffects.playSound(clearSoundId);
                obj011.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                nextObjIsInfested = false;
                return;
            }
            if (!nextObjIsInfested){
                SoundEffects.playSound(clearSoundId);
                obj011.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                return;
            }
        }
        if (objectsRemaining == 5){
            if (nextObjIsInfested && infestedObjRemainingHits >= 1) {
                obj012.startAnimation(ani_infest_shake);
                infestedObjRemainingHits--;
                return;
            }
            if (nextObjIsInfested && infestedObjRemainingHits == 0) {
                SoundEffects.playSound(clearSoundId);
                obj012.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                nextObjIsInfested = false;
                return;
            }
            if (!nextObjIsInfested){
                SoundEffects.playSound(clearSoundId);
                obj012.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                return;
            }
        }
        if (objectsRemaining == 4){
            if (nextObjIsInfested && infestedObjRemainingHits >= 1) {
                obj013.startAnimation(ani_infest_shake);
                infestedObjRemainingHits--;
                return;
            }
            if (nextObjIsInfested && infestedObjRemainingHits == 0) {
                SoundEffects.playSound(clearSoundId);
                obj013.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                nextObjIsInfested = false;
                return;
            }
            if (!nextObjIsInfested){
                SoundEffects.playSound(clearSoundId);
                obj013.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                return;
            }
        }
        if (objectsRemaining == 3){
            if (nextObjIsInfested && infestedObjRemainingHits >= 1) {
                obj014.startAnimation(ani_infest_shake);
                infestedObjRemainingHits--;
                return;
            }
            if (nextObjIsInfested && infestedObjRemainingHits == 0) {
                SoundEffects.playSound(clearSoundId);
                obj014.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                nextObjIsInfested = false;
                return;
            }
            if (!nextObjIsInfested){
                SoundEffects.playSound(clearSoundId);
                obj014.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                return;
            }
        }
        if (objectsRemaining == 2){
            if (nextObjIsInfested && infestedObjRemainingHits >= 1) {
                obj015.startAnimation(ani_infest_shake);
                infestedObjRemainingHits--;
                return;
            }
            if (nextObjIsInfested && infestedObjRemainingHits == 0) {
                SoundEffects.playSound(clearSoundId);
                obj015.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                nextObjIsInfested = false;
                return;
            }
            if (!nextObjIsInfested){
                SoundEffects.playSound(clearSoundId);
                obj015.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                enemyScore = enemyScore + enemyClearAward;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                return;
            }
        }
        if (objectsRemaining == 1){
            if (nextObjIsInfested && infestedObjRemainingHits >= 1) {
                obj016.startAnimation(ani_infest_shake);
                infestedObjRemainingHits--;
                return;
            }
            if (nextObjIsInfested && infestedObjRemainingHits == 0) {
                SoundEffects.playSound(clearSoundId);
                obj016.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
                nextObjIsInfested = false;
                return;
            }
            if (!nextObjIsInfested){
                SoundEffects.playSound(clearSoundId);
                obj016.setImageResource(R.drawable.object_wheatbroken);
                objectsRemaining = objectsRemaining - 1;
            }
        }

    }

    /* Selects random card among the ones the enemy has left. This method will have to
    be modified depending on how many cards the enemy has. */
    public int randomizeEnemyCardSelect(){
        int randomizedCard;

        //IF ENEMY ONLY HAS ONE CARD, USE THIS
        if (enemyStartingCards == 1){
            return 0;
        }

        //IF ENEMY HAS 6 CARDS AND ALL REMAINING
        if (enemyCardsRemaining == 6){
            randomizedCard = genRand(6);
            return randomizedCard;
        }

        //IF ENEMY STARTS WITH TWO CARDS
        if (enemyStartingCards == 2){
            do{
                randomizedCard = genRand(2);
            }while( pool.contains(randomizedCard) );
            return randomizedCard;
        }

        //IF ENEMY STARTS WITH THREE CARDS
        if (enemyStartingCards == 3){
            do{
                randomizedCard = genRand(3);
            }while( pool.contains(randomizedCard) );
            return randomizedCard;
        }

        //IF ENEMY STARTED WITH 6 CARDS AND HAS LESS THAN 6 REMAINING
        if (enemyCardsRemaining <= 5 & enemyStartingCards == 6){
            do{
                randomizedCard = genRand(6);
            }while( pool.contains(randomizedCard) );
            return randomizedCard;
        }

        return 0;
    }

    public int genRand(int number) {
        return new Random().nextInt(number);
    }

    public int genRandRange(int min, int max){
        return new Random().nextInt((max - min) + 1) + min;
    }

    private void checkIfNoObjRemains() {
        if (objectsRemaining == 0) {
            if (!playerTurn) {
                finalEnemyScore = enemyScore - 5;
                finalPlayerScore = playerScore;
                if (finalEnemyScore < 0) {
                    finalEnemyScore = 0;
                }
            } else {
                finalPlayerScore = playerScore - 5;
                finalEnemyScore = enemyScore;
                if (finalPlayerScore < 0) {
                    finalPlayerScore = 0;
                }
            }
            gameOver();
        }
    }

    /* METHOD CALLED WHEN THE GAME IS OVER */
    private void gameOver() {
        final String density = DeviceDensity.getDensityName(this);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                final Dialog dialog = new Dialog(Activity_W001_L004.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.confirmdialog_finalscore);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));
                if (density.equals("xxhdpi")){
                    dialog.getWindow().setLayout(1000,600);
                } else if (density.equals("hdpi")) {
                    dialog.getWindow().setLayout(500, 300);
                } else if (density.equals("mdpi")) {
                    dialog.getWindow().setLayout(400, 250);
                }
                dialog.setCancelable(false);

                TextView tvPlayer = (TextView) dialog.findViewById(R.id.tvPlayer);
                TextView tvEnemy = (TextView) dialog.findViewById(R.id.tvEnemy);
                TextView tvWhoWon = (TextView) dialog.findViewById(R.id.tvWhoWins);
                TextView tvPlayerFinalScore = (TextView) dialog.findViewById(R.id.tvPlayerFinalScore);
                TextView tvEnemyFinalScore = (TextView) dialog.findViewById(R.id.tvEnemyFinalScore);
                tvPlayer.setText(playerName);
                tvEnemy.setText(enemyName);
                if (finalPlayerScore > finalEnemyScore) {
                    tvWhoWon.setTextColor(getResources().getColor(R.color.textBlack));
                    tvWhoWon.setText("You Win!");
                    playerWon = true;
                    checkLevelInfo();
                } else {
                    tvWhoWon.setTextColor(getResources().getColor(R.color.textRed));
                    tvWhoWon.setText("You Lose..");
                    checkLevelInfo();
                }
                tvPlayerFinalScore.setText(String.valueOf(finalPlayerScore));
                tvEnemyFinalScore.setText(String.valueOf(finalEnemyScore));

                /* YES CLICKED */
                Button buttonDialogYes = (Button) dialog.findViewById(R.id.bConfirmOk);
                buttonDialogYes.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialog.dismiss();
                        if (finalPlayerScore > lvlhighscore){
                            myHandler.postDelayed(new Runnable() {
                                public void run() {
                                    tvCenterMessage.setText("NEW HIGH SCORE!");
                                    tvCenterMessage.startAnimation(ani_fadeIn);
                                }
                            }, 500);
                            myHandler.postDelayed(new Runnable() {
                                public void run() {
                                    tvCenterMessage.startAnimation(ani_fadeOut);
                                    updateExp();
                                }
                            }, 3500);
                        } else {
                            myHandler.postDelayed(new Runnable() {
                                public void run() {
                                    updateExp();
                                }
                            }, 500);
                        }
                    }
                });
                dialog.show();
            }
        }, 1000);
    }

    /* CHECKS LEVEL INFO FOR UPDATE */
    private void checkLevelInfo(){
        if (lvlcleared == 0){
            try {
                db.open();
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
            if (finalPlayerScore > lvlhighscore){
                cursor = db.getLvlInfo(4);
                if (cursor != null && cursor.moveToFirst()) {
                    if (playerWon){
                        db.updateLvlInfo(4, 1, finalPlayerScore);
                    } else {
                        db.updateLvlInfo(4, lvlcleared, finalPlayerScore);
                    }
                }
            } else {
                cursor = db.getLvlInfo(4);
                if (cursor != null && cursor.moveToFirst()) {
                    if (playerWon){
                        db.updateLvlInfo(4, 1, lvlhighscore);
                    } else {
                        db.updateLvlInfo(4, lvlcleared, lvlhighscore);
                    }
                }
            }

        } else {
            try {
                db.open();
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
            if (finalPlayerScore > lvlhighscore){
                cursor = db.getLvlInfo(4);
                if (cursor != null && cursor.moveToFirst()) {
                    db.updateLvlInfo(4, lvlcleared, finalPlayerScore);
                }
            } else {
                cursor = db.getLvlInfo(4);
                if (cursor != null && cursor.moveToFirst()) {
                    db.updateLvlInfo(4, lvlcleared, lvlhighscore);
                }
            }
        }
        db.close();
    }

    /* METHOD TO UPDATE EXP/LEVEL UP */
    private void updateExp() {
        final String density = DeviceDensity.getDensityName(this);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                int xpPenalty = 1;
                //lv2-3
                if (playerLevel >= 3 && playerLevel < 5 ){
                    xpPenalty = 2;
                }
                //lv4-5
                if (playerLevel >= 5 && playerLevel < 7){
                    xpPenalty = 3;
                }
                //lv5-7
                if (playerLevel >= 7 && playerLevel < 9){
                    xpPenalty = 4;
                }
                //lv7+
                if (playerLevel >= 9){
                    xpPenalty = 5;
                }
                if (playerLevel == 20){
                    finish();
                    overridePendingTransition(0, 0);
                }
                final int gainedXp = finalPlayerScore / xpPenalty;
                final Dialog dialog = new Dialog(Activity_W001_L004.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.confirmdialog_exp_gain);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));
                if (density.equals("xxhdpi")){
                    dialog.getWindow().setLayout(1000,600);
                } else if (density.equals("hdpi")) {
                    dialog.getWindow().setLayout(500, 300);
                }
                dialog.setCancelable(false);

                final ProgressBar expBar = (ProgressBar) dialog.findViewById(R.id.expBarUpd);
                Drawable draw = getResources().getDrawable(R.drawable.customprogressbar);
                expBar.setProgressDrawable(draw);

                final TextView tvTitle = (TextView) dialog.findViewById(R.id.tvExpGainTitle);
                final TextView tvExpText = (TextView) dialog.findViewById(R.id.tvExp);
                final TextView tvGainedExp = (TextView) dialog.findViewById(R.id.tvGainedExp);
                tvGainedExp.setText(String.valueOf(gainedXp));
                expBar.setProgress(playerExp);

                myHandler.postDelayed(new Runnable() {
                    public void run() {

                        if (android.os.Build.VERSION.SDK_INT >= 11) {
                            ObjectAnimator animation = ObjectAnimator.ofInt(expBar, "progress", playerExp + finalPlayerScore);
                            animation.setDuration(1000);
                            animation.setInterpolator(new DecelerateInterpolator());
                            animation.start();
                        } else {
                            expBar.setProgress(playerExp + gainedXp);
                        }
                        checkIfExpRoof = playerExp + gainedXp;

                        if (checkIfExpRoof > 100) {
                            expToNextLevel = checkIfExpRoof - 100;
                        }

                        try {
                            db.open();
                        } catch (java.sql.SQLException e) {
                            e.printStackTrace();
                        }
                        cursor = db.getPlayerInfo();
                        if (cursor != null && cursor.moveToFirst()) {
                            newExp = playerExp + gainedXp;
                            db.updatePlayerExp(newExp);
                        }
                        db.close();
                        expBar.setProgress(playerExp + gainedXp);

                        if (expBar.getProgress() >= 100) {
                            myHandler.postDelayed(new Runnable() {
                                public void run() {
                                    try {
                                        db.open();
                                    } catch (java.sql.SQLException e) {
                                        e.printStackTrace();
                                    }
                                    cursor = db.getPlayerInfo();
                                    expBar.setProgress(0);

                                    if (android.os.Build.VERSION.SDK_INT >= 11) {
                                        ObjectAnimator animation = ObjectAnimator.ofInt(expBar, "progress", expToNextLevel);
                                        animation.setDuration(500);
                                        animation.setInterpolator(new DecelerateInterpolator());
                                        animation.start();
                                    } else {
                                        expBar.setProgress(expToNextLevel);
                                    }
                                    playerLevel++;
                                    tvTitle.setText("Congratulations! You reached");
                                    tvGainedExp.setText("Level");
                                    tvExpText.setText(String.valueOf(playerLevel));
                                    if (cursor != null && cursor.moveToFirst()) {
                                        db.updatePlayerLevel(playerLevel);
                                        db.updatePlayerExp(expToNextLevel);
                                    }
                                    db.close();

                                    myHandler.postDelayed(new Runnable() {
                                        public void run() {
                                            dialog.dismiss();
                                            finish();
                                            overridePendingTransition(0, 0);
                                        }
                                    }, 4000);
                                }
                            }, 1500);
                        }

                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                dialog.dismiss();
                                finish();
                            }
                        }, 5000);
                    }
                }, 2000);

                /* YES CLICKED */
                Button buttonDialogYes = (Button) dialog.findViewById(R.id.bConfirmOk);
                buttonDialogYes.setClickable(false);
                buttonDialogYes.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                    }
                });
                dialog.show();
            }
        }, 1000);
    }

    /* THIS METHOD STARTS THE CONFIRM CARD SELECTION DIALOG */
    private void playCardConfirm(String message, final Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confirmdialog_playcard);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));

        TextView tvText = (TextView) dialog.findViewById(R.id.tvError);
        TextView tvName = (TextView) dialog.findViewById(R.id.tvCardName);
        tvText.setText(message);

        ImageView ivCard = (ImageView) dialog.findViewById(R.id.ivCardPreview);

        /* HERE A METHODS ARE CALLED TO SET CARD NAME AND GRAPHIC FOR THE PREVIEW */
        tvName.setText(getCardName());
        ivCard.setImageResource(getResources().getIdentifier(getCardGraphic(), "drawable", getPackageName()));

        /* YES CLICKED */
        Button buttonDialogYes = (Button) dialog.findViewById(R.id.bConfirmOk);
        buttonDialogYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
                playerMoves = playerMoves - getCardCost() - playerCorruptedPenalty;
                lastPlayerPlayedCard = getCardName();
                tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
                disable(layout_objectRow);
                disablePlayerCards();
                btnEndTurn.setClickable(false);
                animatePlayerCard();
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        executeCardEffect();
                    }
                }, 3500);
            }
        });

        /* NO CLICKED */
        Button buttonDialogNo = (Button) dialog.findViewById(R.id.bConfirmCancel);
        buttonDialogNo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* THIS METHOD DISABLES THE CARDS WHILE SOMETHING ELSE IS HAPPENING AND
    YOU SHOULDN'T BE ABLE TO CLICK THEM */
    private void disablePlayerCards() {
        playerCard1.setClickable(false);
        playerCard2.setClickable(false);
        playerCard3.setClickable(false);
        playerCard4.setClickable(false);
        playerCard5.setClickable(false);
        playerCard6.setClickable(false);
    }

    /* THIS METHOD ENABLES ALL AVAILABLE CARDS BACK TO CLICKABLE */
    private void enablePlayerCards() {
        if (!playerCard1Used) {
            playerCard1.setClickable(true);
        }
        if (!playerCard2Used) {
            playerCard2.setClickable(true);
        }
        if (!playerCard3Used) {
            playerCard3.setClickable(true);
        }
        if (!playerCard4Used) {
            playerCard4.setClickable(true);
        }
        if (!playerCard5Used) {
            playerCard5.setClickable(true);
        }
        if (!playerCard6Used) {
            playerCard6.setClickable(true);
        }
    }

    /* THIS METHOD FETCHES PLAYER INFO */
    private void getPlayerInfo() {
        try {
            db.open();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        cursor = db.getPlayerInfo();
        if (cursor != null && cursor.moveToFirst()) {
            tvPlayerName.setText(cursor.getString(cursor.getColumnIndex("name")));
            playerName = cursor.getString(cursor.getColumnIndex("name"));
            playerLevel = cursor.getInt(cursor.getColumnIndex("level"));
            tvPlayerLevel.setText(String.valueOf(playerLevel));
            playerExp = cursor.getInt(cursor.getColumnIndex("exp"));
            tvPlayerExp.setText(String.valueOf(playerExp));
            playerGender = cursor.getString(cursor.getColumnIndex("gender"));
            playerProgress = cursor.getInt(cursor.getColumnIndex("lvlsbeaten"));
        }

        if (playerGender.equals("Male")) {
            ivPlayerPortrait.setImageResource(R.drawable.portrait_placeholder_boy);
        } else {
            ivPlayerPortrait.setImageResource(R.drawable.portrait_placeholder_girl);
        }

        db.close();
    }

    /* THIS METHOD FETCHES THE CARDS FROM THE DB (THE SET CARDS FOR THIS BATTLE) */
    private void getPlayerCards() {
        String names[] = new String[6];
        String image[] = new String[6];
        int types[] = new int[6];
        int cost[] = new int[6];
        int i = 0;

        try {
            db.open();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        cursor = db.getAllSelectedCards();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    names[i] = cursor.getString(cursor.getColumnIndex("name"));
                    image[i] = cursor.getString(cursor.getColumnIndex("image"));
                    types[i] = cursor.getInt(cursor.getColumnIndex("type"));
                    cost[i] = cursor.getInt(cursor.getColumnIndex("cost"));
                    i++;
                } while (cursor.moveToNext());
                db.close();
            }
        }
        playerCard1Type = types[0];
        playerCard1Cost = cost[0];
        playerCard1Name = names[0];
        playerCard1Img = image[0];
        playerCard2Type = types[1];
        playerCard2Cost = cost[1];
        playerCard2Name = names[1];
        playerCard2Img = image[1];
        playerCard3Type = types[2];
        playerCard3Cost = cost[2];
        playerCard3Name = names[2];
        playerCard3Img = image[2];
        playerCard4Type = types[3];
        playerCard4Cost = cost[3];
        playerCard4Name = names[3];
        playerCard4Img = image[3];
        playerCard5Type = types[4];
        playerCard5Cost = cost[4];
        playerCard5Name = names[4];
        playerCard5Img = image[4];
        playerCard6Type = types[5];
        playerCard6Cost = cost[5];
        playerCard6Name = names[5];
        playerCard6Img = image[5];
    }

    /* THIS METHOD SETS THE PLAYER CARD ICONS */
    private void setPlayerCardIcons() {
            /* CARD 1 */
        if (playerCard1Type == 0) {
            playerCard1.setVisibility(View.GONE);
        }
        if (playerCard1Type == 1) {
            playerCard1.setBackgroundResource(R.drawable.card_icon_field);
            if (!sizeName.equals("xlarge")){
                playerCard1.setImageResource(R.drawable.card_type_field);
            } else {
                playerCard1.setImageResource(R.drawable.card_type_field_tablet);
            }
        }
        if (playerCard1Type == 2) {
            if (!sizeName.equals("xlarge")){
                playerCard1.setImageResource(R.drawable.card_type_ailment);
            } else {
                playerCard1.setImageResource(R.drawable.card_type_ailment_tablet);
            }
        }
        if (playerCard1Type == 3) {
            playerCard1.setBackgroundResource(R.drawable.card_icon_boosting);
            if (!sizeName.equals("xlarge")){
                playerCard1.setImageResource(R.drawable.card_type_boosting);
            } else {
                playerCard1.setImageResource(R.drawable.card_type_boosting_tablet);
            }
        }
        /* CARD 2 */
        if (playerCard2Type == 0) {
            playerCard2.setVisibility(View.GONE);
        }
        if (playerCard2Type == 1) {
            playerCard2.setBackgroundResource(R.drawable.card_icon_field);
            if (!sizeName.equals("xlarge")){
                playerCard2.setImageResource(R.drawable.card_type_field);
            } else {
                playerCard2.setImageResource(R.drawable.card_type_field_tablet);
            }
        }
        if (playerCard2Type == 2) {
            if (!sizeName.equals("xlarge")){
                playerCard2.setImageResource(R.drawable.card_type_ailment);
            } else {
                playerCard2.setImageResource(R.drawable.card_type_ailment_tablet);
            }
        }
        if (playerCard2Type == 3) {
            playerCard2.setBackgroundResource(R.drawable.card_icon_boosting);
            if (!sizeName.equals("xlarge")){
                playerCard2.setImageResource(R.drawable.card_type_boosting);
            } else {
                playerCard2.setImageResource(R.drawable.card_type_boosting_tablet);
            }
        }
        /* CARD 3 */
        if (playerCard3Type == 0) {
            playerCard3.setVisibility(View.GONE);
        }
        if (playerCard3Type == 1) {
            playerCard3.setBackgroundResource(R.drawable.card_icon_field);
            if (!sizeName.equals("xlarge")){
                playerCard3.setImageResource(R.drawable.card_type_field);
            } else {
                playerCard3.setImageResource(R.drawable.card_type_field_tablet);
            }
        }
        if (playerCard3Type == 2) {
            if (!sizeName.equals("xlarge")){
                playerCard3.setImageResource(R.drawable.card_type_ailment);
            } else {
                playerCard3.setImageResource(R.drawable.card_type_ailment_tablet);
            }
        }
        if (playerCard3Type == 3) {
            playerCard3.setBackgroundResource(R.drawable.card_icon_boosting);
            if (!sizeName.equals("xlarge")){
                playerCard3.setImageResource(R.drawable.card_type_boosting);
            } else {
                playerCard3.setImageResource(R.drawable.card_type_boosting_tablet);
            }
        }
        /* CARD 4 */
        if (playerCard4Type == 0) {
            playerCard4.setVisibility(View.GONE);
        }
        if (playerCard4Type == 1) {
            playerCard4.setBackgroundResource(R.drawable.card_icon_field);
            if (!sizeName.equals("xlarge")){
                playerCard4.setImageResource(R.drawable.card_type_field);
            } else {
                playerCard4.setImageResource(R.drawable.card_type_field_tablet);
            }
        }
        if (playerCard4Type == 2) {
            if (!sizeName.equals("xlarge")){
                playerCard4.setImageResource(R.drawable.card_type_ailment);
            } else {
                playerCard4.setImageResource(R.drawable.card_type_ailment_tablet);
            }
        }
        if (playerCard4Type == 3) {
            playerCard4.setBackgroundResource(R.drawable.card_icon_boosting);
            if (!sizeName.equals("xlarge")){
                playerCard4.setImageResource(R.drawable.card_type_boosting);
            } else {
                playerCard4.setImageResource(R.drawable.card_type_boosting_tablet);
            }
        }
        /* CARD 5 */
        if (playerCard5Type == 0) {
            playerCard5.setVisibility(View.GONE);
        }
        if (playerCard5Type == 1) {
            playerCard5.setBackgroundResource(R.drawable.card_icon_field);
            if (!sizeName.equals("xlarge")){
                playerCard5.setImageResource(R.drawable.card_type_field);
            } else {
                playerCard5.setImageResource(R.drawable.card_type_field_tablet);
            }
        }
        if (playerCard5Type == 2) {
            if (!sizeName.equals("xlarge")){
                playerCard5.setImageResource(R.drawable.card_type_ailment);
            } else {
                playerCard5.setImageResource(R.drawable.card_type_ailment_tablet);
            }
        }
        if (playerCard5Type == 3) {
            playerCard5.setBackgroundResource(R.drawable.card_icon_boosting);
            if (!sizeName.equals("xlarge")){
                playerCard5.setImageResource(R.drawable.card_type_boosting);
            } else {
                playerCard5.setImageResource(R.drawable.card_type_boosting_tablet);
            }
        }
        /* CARD 6 */
        if (playerCard6Type == 0) {
            playerCard6.setVisibility(View.GONE);
        }
        if (playerCard6Type == 1) {
            playerCard6.setBackgroundResource(R.drawable.card_icon_field);
            if (!sizeName.equals("xlarge")){
                playerCard6.setImageResource(R.drawable.card_type_field);
            } else {
                playerCard6.setImageResource(R.drawable.card_type_field_tablet);
            }
        }
        if (playerCard6Type == 2) {
            if (!sizeName.equals("xlarge")){
                playerCard6.setImageResource(R.drawable.card_type_ailment);
            } else {
                playerCard6.setImageResource(R.drawable.card_type_ailment_tablet);
            }
        }
        if (playerCard6Type == 3) {
            playerCard6.setBackgroundResource(R.drawable.card_icon_boosting);
            if (!sizeName.equals("xlarge")){
                playerCard6.setImageResource(R.drawable.card_type_boosting);
            } else {
                playerCard6.setImageResource(R.drawable.card_type_boosting_tablet);
            }
        }
    }

    /* THIS METHOD SETS ENEMY CARDS */
    private void setEnemyCardsIcons(){
        enemyCard1.setVisibility(View.VISIBLE);
        enemyCard1.setBackgroundResource(R.drawable.card_icon_boosting);
        if (!sizeName.equals("xlarge")){
            enemyCard1.setImageResource(R.drawable.card_type_boosting);
        } else {
            enemyCard1.setImageResource(R.drawable.card_type_boosting_tablet);
        }
        enemyCard2.setVisibility(View.VISIBLE);
        enemyCard2.setBackgroundResource(R.drawable.card_icon_field);
        if (!sizeName.equals("xlarge")){
            enemyCard2.setImageResource(R.drawable.card_type_field);
        } else {
            enemyCard2.setImageResource(R.drawable.card_type_field_tablet);
        }
        enemyCard3.setVisibility(View.VISIBLE);
        enemyCard3.setBackgroundResource(R.drawable.card_icon_ailment);
        if (!sizeName.equals("xlarge")){
            enemyCard3.setImageResource(R.drawable.card_type_ailment);
        } else {
            enemyCard3.setImageResource(R.drawable.card_type_ailment_tablet);
        }
        /*enemyCard4.setVisibility(View.VISIBLE);
        enemyCard4.setBackgroundResource(R.drawable.card_icon_ailment);
        enemyCard4.setImageResource(R.drawable.card_type_ailment);
        enemyCard5.setVisibility(View.VISIBLE);
        enemyCard5.setBackgroundResource(R.drawable.card_icon_ailment);
        enemyCard5.setImageResource(R.drawable.card_type_ailment);
        enemyCard6.setVisibility(View.VISIBLE);
        enemyCard6.setBackgroundResource(R.drawable.card_icon_ailment);
        enemyCard6.setImageResource(R.drawable.card_type_ailment);*/
    }

    /* THIS METHOD DETERMINES SCREEN SIZE */
    private void getScreenSize() {
        sizeName = DeviceDensity.getSizeName(this);
        densityName = DeviceDensity.getDensityName(this);
    }

    /* THIS METHOD SETS THE GRAPHIC FOR PREVIEW AND PLAYED CARD */
    private String getCardGraphic() {
        String cardGraphic;
        if (selectedCard == 1) {
            cardGraphic = playerCard1Img;
            return cardGraphic;
        }
        if (selectedCard == 2) {
            cardGraphic = playerCard2Img;
            return cardGraphic;
        }
        if (selectedCard == 3) {
            cardGraphic = playerCard3Img;
            return cardGraphic;
        }
        if (selectedCard == 4) {
            cardGraphic = playerCard4Img;
            return cardGraphic;
        }
        if (selectedCard == 5) {
            cardGraphic = playerCard5Img;
            return cardGraphic;
        }
        if (selectedCard == 6) {
            cardGraphic = playerCard6Img;
            return cardGraphic;
        } else {
            return null;
        }
    }

    /* THIS METHOD SETS THE NAME FOR PREVIEW AND PLAYED CARD */
    private String getCardName() {
        String cardName;
        if (selectedCard == 1) {
            cardName = playerCard1Name;
            return cardName;
        }
        if (selectedCard == 2) {
            cardName = playerCard2Name;
            return cardName;
        }
        if (selectedCard == 3) {
            cardName = playerCard3Name;
            return cardName;
        }
        if (selectedCard == 4) {
            cardName = playerCard4Name;
            return cardName;
        }
        if (selectedCard == 5) {
            cardName = playerCard5Name;
            return cardName;
        }
        if (selectedCard == 6) {
            cardName = playerCard6Name;
            return cardName;
        } else {
            return null;
        }
    }

    /* FETCHES PLAYER CARD COST */
    private int getCardCost(){
        int cardCost;
        if (selectedCard == 1) {
            cardCost = playerCard1Cost;
            return cardCost;
        }
        if (selectedCard == 2) {
            cardCost = playerCard2Cost;
            return cardCost;
        }
        if (selectedCard == 3) {
            cardCost = playerCard3Cost;
            return cardCost;
        }
        if (selectedCard == 4) {
            cardCost = playerCard4Cost;
            return cardCost;
        }
        if (selectedCard == 5) {
            cardCost = playerCard5Cost;
            return cardCost;
        }
        if (selectedCard == 6) {
            cardCost = playerCard6Cost;
            return cardCost;
        }
        else {
            return 0;
        }
    }

    /* THIS METHOD ANIMATES THE RIGHT ENEMY CARD AND DISPLAYS IT IN THE CENTER */
    private void animateEnemyCard(){
        if (enemyPickedCard == 0) {
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    if (!enemyIsHoarding){
                        enemyCard1.setVisibility(View.INVISIBLE);
                    } else {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        enemyCard1.clearColorFilter();
                    }
                }
            }, 500);

            myHandler.postDelayed(new Runnable() {
                public void run() {
                    ivCenterCardFrame.startAnimation(ani_zoomIn);
                    ivCenterCardFrame.setImageResource(R.drawable.card_speed_up);
                }
            }, 1000);
        }
        if (enemyPickedCard == 1) {
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    if (!enemyIsHoarding){
                        enemyCard2.setVisibility(View.INVISIBLE);
                    } else {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        enemyCard2.clearColorFilter();
                    }
                }
            }, 500);

            myHandler.postDelayed(new Runnable() {
                public void run() {
                    ivCenterCardFrame.startAnimation(ani_zoomIn);
                    ivCenterCardFrame.setImageResource(R.drawable.card_obj_plus_3);
                }
            }, 1000);
        }
        if (enemyPickedCard == 2) {
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    if (!enemyIsHoarding){
                        enemyCard3.setVisibility(View.INVISIBLE);
                    } else {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        enemyCard3.clearColorFilter();
                    }
                }
            }, 500);

            myHandler.postDelayed(new Runnable() {
                public void run() {
                    ivCenterCardFrame.startAnimation(ani_zoomIn);
                    ivCenterCardFrame.setImageResource(R.drawable.card_slowdown);
                }
            }, 1000);
        }
        if (enemyPickedCard == 3) {
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    if (!enemyIsHoarding){
                        enemyCard4.setVisibility(View.INVISIBLE);
                    } else {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        enemyCard4.clearColorFilter();
                    }
                }
            }, 500);

            myHandler.postDelayed(new Runnable() {
                public void run() {
                    ivCenterCardFrame.startAnimation(ani_zoomIn);
                    ivCenterCardFrame.setImageResource(R.drawable.card_slowdown);
                }
            }, 1000);
        }
        if (enemyPickedCard == 4) {
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    if (!enemyIsHoarding){
                        enemyCard5.setVisibility(View.INVISIBLE);
                    } else {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        enemyCard5.clearColorFilter();
                    }
                }
            }, 500);

            myHandler.postDelayed(new Runnable() {
                public void run() {
                    ivCenterCardFrame.startAnimation(ani_zoomIn);
                    ivCenterCardFrame.setImageResource(R.drawable.card_dispel);
                }
            }, 1000);
        }
        if (enemyPickedCard == 5) {
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    if (!enemyIsHoarding){
                        enemyCard6.setVisibility(View.INVISIBLE);
                    } else {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        enemyCard6.clearColorFilter();
                    }
                }
            }, 500);

            myHandler.postDelayed(new Runnable() {
                public void run() {
                    ivCenterCardFrame.startAnimation(ani_zoomIn);
                    ivCenterCardFrame.setImageResource(R.drawable.card_dispel);
                }
            }, 1000);
        }
        myHandler.postDelayed(new Runnable() {
            public void run() {
                ivCenterCardFrame.clearAnimation();
                ivCenterCardFrame.setVisibility(View.INVISIBLE);
                enemyIsHoarding = false;
                clearEnemyStatus("Hoard");
            }
        }, 2500);
    }

    /* THIS METHOD ANIMATES THE RIGHT CARD AND DISPLAYS IT IN THE CENTER */
    private void animatePlayerCard() {
        if (selectedCard == 1) {
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    if (!playerIsHoarding){
                        playerCard1.setVisibility(View.INVISIBLE);
                        playerCard1.setClickable(false);
                        playerCard1Used = true;
                    } else {
                        tvCenterMessage.setText(playerHoarded);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                    }
                }
            }, 500);

            myHandler.postDelayed(new Runnable() {
                public void run() {
                    ivCenterCardFrame.startAnimation(ani_zoomIn);
                    ivCenterCardFrame.setImageResource(getResources().getIdentifier(getCardGraphic(), "drawable", getPackageName()));
                }
            }, 1000);
        }
        if (selectedCard == 2) {
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    if (!playerIsHoarding){
                        playerCard2.setVisibility(View.INVISIBLE);
                        playerCard2.setClickable(false);
                        playerCard2Used = true;
                    } else {
                        tvCenterMessage.setText(playerHoarded);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                    }
                }
            }, 500);

            myHandler.postDelayed(new Runnable() {
                public void run() {
                    ivCenterCardFrame.startAnimation(ani_zoomIn);
                    ivCenterCardFrame.setImageResource(getResources().getIdentifier(getCardGraphic(), "drawable", getPackageName()));
                }
            }, 1000);
        }
        if (selectedCard == 3) {
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    if (!playerIsHoarding){
                        playerCard3.setVisibility(View.INVISIBLE);
                        playerCard3.setClickable(false);
                        playerCard3Used = true;
                    } else {
                        tvCenterMessage.setText(playerHoarded);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                    }
                }
            }, 500);

            myHandler.postDelayed(new Runnable() {
                public void run() {
                    ivCenterCardFrame.startAnimation(ani_zoomIn);
                    ivCenterCardFrame.setImageResource(getResources().getIdentifier(getCardGraphic(), "drawable", getPackageName()));
                }
            }, 1000);
        }
        if (selectedCard == 4) {
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    if (!playerIsHoarding){
                        playerCard4.setVisibility(View.INVISIBLE);
                        playerCard4.setClickable(false);
                        playerCard4Used = true;
                    } else {
                        tvCenterMessage.setText(playerHoarded);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                    }
                }
            }, 500);

            myHandler.postDelayed(new Runnable() {
                public void run() {
                    ivCenterCardFrame.startAnimation(ani_zoomIn);
                    ivCenterCardFrame.setImageResource(getResources().getIdentifier(getCardGraphic(), "drawable", getPackageName()));
                }
            }, 1000);
        }
        if (selectedCard == 5) {
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    if (!playerIsHoarding){
                        playerCard5.setVisibility(View.INVISIBLE);
                        playerCard5.setClickable(false);
                        playerCard5Used = true;
                    } else {
                        tvCenterMessage.setText(playerHoarded);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                    }
                }
            }, 500);

            myHandler.postDelayed(new Runnable() {
                public void run() {
                    ivCenterCardFrame.startAnimation(ani_zoomIn);
                    ivCenterCardFrame.setImageResource(getResources().getIdentifier(getCardGraphic(), "drawable", getPackageName()));
                }
            }, 1000);
        }
        if (selectedCard == 6) {
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    if (!playerIsHoarding){
                        playerCard6.setVisibility(View.INVISIBLE);
                        playerCard6.setClickable(false);
                        playerCard6Used = true;
                    } else {
                        tvCenterMessage.setText(playerHoarded);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                    }
                }
            }, 500);

            myHandler.postDelayed(new Runnable() {
                public void run() {
                    ivCenterCardFrame.startAnimation(ani_zoomIn);
                    ivCenterCardFrame.setImageResource(getResources().getIdentifier(getCardGraphic(), "drawable", getPackageName()));
                }
            }, 1000);
        }
        myHandler.postDelayed(new Runnable() {
            public void run() {
                ivCenterCardFrame.clearAnimation();
                ivCenterCardFrame.setVisibility(View.INVISIBLE);
                if (playerIsHoarding){
                    tvCenterMessage.startAnimation(ani_fadeOut);
                    playerIsHoarding = false;
                    clearPlayerStatus("Hoard");
                }
            }
        }, 2500);

    }

    /* THIS METHOD FINDS WHICH CARD IS PLAYED TO DETERMINE EFFECT */
    private void executeCardEffect() {
        String playedCard = getCardName();
        if (playedCard.equals("Reinforce")) {
            cardReinforce1();
        }
        if (playedCard.equals("Reinforce II")) {
            cardReinforce2();
        }
        if (playedCard.equals("Reinforce III")) {
            cardReinforce3();
        }
        if (playedCard.equals("Slow Down")) {
            cardSlowDown();
        }
        if (playedCard.equals("Speed Up")) {
            cardSpeedUp();
        }
        if (playedCard.equals("Steal")) {
            if (playerClearAward == 4){
                cardSteal(2,6);
            } else {
                cardSteal(1,3);
            }
        }
        if (playedCard.equals("Steal II")) {
            if (playerClearAward == 4){
                cardSteal(6,10);
            } else {
                cardSteal(3,5);
            }
        }
        if (playedCard.equals("Steal III")) {
            if (playerClearAward == 4){
                cardSteal(10,14);
            } else {
                cardSteal(5,7);
            }
        }
        if (playedCard.equals("Concentrate")){
            cardConcentrate();
        }
        if (playedCard.equals("Corruption")){
            cardCorruption();
        }
        if (playedCard.equals("Curse")){
            cardCurse();
        }
        if(playedCard.equals("Mimic")){
            cardMimic();
        }
        if(playedCard.equals("Speed Up II")){
            cardSpeedUp2();
        }
        if(playedCard.equals("Infest")){
            cardInfest();
        }
        if(playedCard.equals("Restore")){
            cardRestore();
        }
        if(playedCard.equals("Agony")){
            cardAgony();
        }
        if(playedCard.equals("Malediction")){
            cardMalediction();
        }
        if(playedCard.equals("Demonic Prayer")){
            cardDemonicPrayer();
        }
        if(playedCard.equals("Death Sentence")){
            cardDeathSentence();
        }
        if(playedCard.equals("Cure")){
            cardCure();
        }
        if(playedCard.equals("Rewind")){
            cardRewind();
        }
        if(playedCard.equals("Protect")){
            cardProtect();
        }
        if(playedCard.equals("Hoard")){
            cardHoard();
        }
        if(playedCard.equals("Dispel")){
            cardDispel();
        }
        if (errorMsg){
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    enable(layout_objectRow);
                    enablePlayerCards();
                    btnEndTurn.setClickable(true);
                    errorMsg = false;
                }
            }, 2500);
        } else {
            if (playedCard.equals("Mimic") && lastEnemyPlayedCard.equals("Demonic Prayer")){
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        enable(layout_objectRow);
                        enablePlayerCards();
                        btnEndTurn.setClickable(true);
                    }
                }, 15000);
            } else if (playedCard.equals("Mimic")){
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        enable(layout_objectRow);
                        enablePlayerCards();
                        btnEndTurn.setClickable(true);
                    }
                }, 3000);
            } else if (playedCard.equals("Demonic Prayer"))  {
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        enable(layout_objectRow);
                        enablePlayerCards();
                        btnEndTurn.setClickable(true);
                    }
                }, 12000);
            } else {
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        enable(layout_objectRow);
                        enablePlayerCards();
                        btnEndTurn.setClickable(true);
                    }
                }, 2000);
            }
        }
    }

    /* THIS METHOD FINDS WHICH ENEMY CARD IS PLAYED TO DETERMINE EFFECT */
    private void executeEnemyCardEffect(){
        if (enemyPickedCard == 0){
            cardSpeedUp();
        }
        if (enemyPickedCard == 1){
            cardReinforce3();
        }
        if (enemyPickedCard == 2){
            cardSlowDown();
        }
        /*if (enemyPickedCard == 3){
            cardSlowDown();
        }
        if (enemyPickedCard == 4){
            cardDispel();
        }
        if (enemyPickedCard == 5){
            cardDispel();
        }*/

    }

    /* -----------------------------------------
    * CARD EFFECT METHODS
    *  -----------------------------------------*/

    /* REINFORCE 1 CARD EFFECT METHOD */
    private void cardReinforce1() {
        if (objectsRemaining == 16) {
            tvCenterMessage.setText(boardIsFullError);
            tvCenterMessage.startAnimation(ani_fadeIn);
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                }
            }, 1000);
        }
        if (objectsRemaining == 15) {
            if (nextObjIsInfested){
                obj001.setImageResource(R.drawable.object_wheat_webbed);
                obj002.setImageResource(R.drawable.object_wheat);
            } else {
                obj001.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 14) {
            if (nextObjIsInfested){
                obj002.setImageResource(R.drawable.object_wheat_webbed);
                obj003.setImageResource(R.drawable.object_wheat);
            } else {
                obj002.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 13) {
            if (nextObjIsInfested){
                obj003.setImageResource(R.drawable.object_wheat_webbed);
                obj004.setImageResource(R.drawable.object_wheat);
            } else {
                obj003.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 12) {
            if (nextObjIsInfested){
                obj004.setImageResource(R.drawable.object_wheat_webbed);
                obj005.setImageResource(R.drawable.object_wheat);
            } else {
                obj004.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 11) {
            if (nextObjIsInfested){
                obj005.setImageResource(R.drawable.object_wheat_webbed);
                obj006.setImageResource(R.drawable.object_wheat);
            } else {
                obj005.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 10) {
            if (nextObjIsInfested){
                obj006.setImageResource(R.drawable.object_wheat_webbed);
                obj007.setImageResource(R.drawable.object_wheat);
            } else {
                obj006.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 9) {
            if (nextObjIsInfested){
                obj007.setImageResource(R.drawable.object_wheat_webbed);
                obj008.setImageResource(R.drawable.object_wheat);
            } else {
                obj007.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 8) {
            if (nextObjIsInfested){
                obj008.setImageResource(R.drawable.object_wheat_webbed);
                obj009.setImageResource(R.drawable.object_wheat);
            } else {
                obj008.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 7) {
            if (nextObjIsInfested){
                obj009.setImageResource(R.drawable.object_wheat_webbed);
                obj010.setImageResource(R.drawable.object_wheat);
            } else {
                obj009.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 6) {
            if (nextObjIsInfested){
                obj010.setImageResource(R.drawable.object_wheat_webbed);
                obj011.setImageResource(R.drawable.object_wheat);
            } else {
                obj010.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 5) {
            if (nextObjIsInfested){
                obj011.setImageResource(R.drawable.object_wheat_webbed);
                obj012.setImageResource(R.drawable.object_wheat);
            } else {
                obj011.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 4) {
            if (nextObjIsInfested){
                obj012.setImageResource(R.drawable.object_wheat_webbed);
                obj013.setImageResource(R.drawable.object_wheat);
            } else {
                obj012.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 3) {
            if (nextObjIsInfested){
                obj013.setImageResource(R.drawable.object_wheat_webbed);
                obj014.setImageResource(R.drawable.object_wheat);
            } else {
                obj013.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 2) {
            if (nextObjIsInfested){
                obj014.setImageResource(R.drawable.object_wheat_webbed);
                obj015.setImageResource(R.drawable.object_wheat);
            } else {
                obj014.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 1) {
            if (nextObjIsInfested){
                obj015.setImageResource(R.drawable.object_wheat_webbed);
                obj016.setImageResource(R.drawable.object_wheat);
            } else {
                obj015.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 1;
        }
    }

    /* REINFORCE 2 CARD EFFECT METHOD */
    private void cardReinforce2() {
        if (objectsRemaining == 16) {
            tvCenterMessage.setText(boardIsFullError);
            tvCenterMessage.startAnimation(ani_fadeIn);
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                }
            }, 1000);
        }
        if (objectsRemaining == 15) {
            if (nextObjIsInfested){
                obj001.setImageResource(R.drawable.object_wheat_webbed);
                obj002.setImageResource(R.drawable.object_wheat);
            } else {
                obj001.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 14) {
            if (nextObjIsInfested){
                obj001.setImageResource(R.drawable.object_wheat_webbed);
                obj002.setImageResource(R.drawable.object_wheat);
                obj003.setImageResource(R.drawable.object_wheat);
            } else {
                obj001.setImageResource(R.drawable.object_wheat);
                obj002.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 13) {
            if (nextObjIsInfested){
                obj002.setImageResource(R.drawable.object_wheat_webbed);
                obj003.setImageResource(R.drawable.object_wheat);
                obj004.setImageResource(R.drawable.object_wheat);
            } else {
                obj002.setImageResource(R.drawable.object_wheat);
                obj003.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 12) {
            if (nextObjIsInfested){
                obj003.setImageResource(R.drawable.object_wheat_webbed);
                obj004.setImageResource(R.drawable.object_wheat);
                obj005.setImageResource(R.drawable.object_wheat);
            } else {
                obj003.setImageResource(R.drawable.object_wheat);
                obj004.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 11) {
            if (nextObjIsInfested){
                obj004.setImageResource(R.drawable.object_wheat_webbed);
                obj005.setImageResource(R.drawable.object_wheat);
                obj006.setImageResource(R.drawable.object_wheat);
            } else {
                obj004.setImageResource(R.drawable.object_wheat);
                obj005.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 10) {
            if (nextObjIsInfested){
                obj005.setImageResource(R.drawable.object_wheat_webbed);
                obj006.setImageResource(R.drawable.object_wheat);
                obj007.setImageResource(R.drawable.object_wheat);
            } else {
                obj005.setImageResource(R.drawable.object_wheat);
                obj006.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 9) {
            if (nextObjIsInfested){
                obj006.setImageResource(R.drawable.object_wheat_webbed);
                obj007.setImageResource(R.drawable.object_wheat);
                obj008.setImageResource(R.drawable.object_wheat);
            } else {
                obj006.setImageResource(R.drawable.object_wheat);
                obj007.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 8) {
            if (nextObjIsInfested){
                obj007.setImageResource(R.drawable.object_wheat_webbed);
                obj008.setImageResource(R.drawable.object_wheat);
                obj009.setImageResource(R.drawable.object_wheat);
            } else {
                obj007.setImageResource(R.drawable.object_wheat);
                obj008.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 7) {
            if (nextObjIsInfested){
                obj008.setImageResource(R.drawable.object_wheat_webbed);
                obj009.setImageResource(R.drawable.object_wheat);
                obj010.setImageResource(R.drawable.object_wheat);
            } else {
                obj008.setImageResource(R.drawable.object_wheat);
                obj009.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 6) {
            if (nextObjIsInfested){
                obj009.setImageResource(R.drawable.object_wheat_webbed);
                obj010.setImageResource(R.drawable.object_wheat);
                obj011.setImageResource(R.drawable.object_wheat);
            } else {
                obj009.setImageResource(R.drawable.object_wheat);
                obj010.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 5) {
            if (nextObjIsInfested){
                obj010.setImageResource(R.drawable.object_wheat_webbed);
                obj011.setImageResource(R.drawable.object_wheat);
                obj012.setImageResource(R.drawable.object_wheat);
            } else {
                obj010.setImageResource(R.drawable.object_wheat);
                obj011.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 4) {
            if (nextObjIsInfested){
                obj011.setImageResource(R.drawable.object_wheat_webbed);
                obj012.setImageResource(R.drawable.object_wheat);
                obj013.setImageResource(R.drawable.object_wheat);
            } else {
                obj011.setImageResource(R.drawable.object_wheat);
                obj012.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 3) {
            if (nextObjIsInfested){
                obj012.setImageResource(R.drawable.object_wheat_webbed);
                obj013.setImageResource(R.drawable.object_wheat);
                obj014.setImageResource(R.drawable.object_wheat);
            } else {
                obj012.setImageResource(R.drawable.object_wheat);
                obj013.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 2) {
            if (nextObjIsInfested){
                obj013.setImageResource(R.drawable.object_wheat_webbed);
                obj014.setImageResource(R.drawable.object_wheat);
                obj015.setImageResource(R.drawable.object_wheat);
            } else {
                obj013.setImageResource(R.drawable.object_wheat);
                obj014.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 1) {
            if (nextObjIsInfested){
                obj014.setImageResource(R.drawable.object_wheat_webbed);
                obj015.setImageResource(R.drawable.object_wheat);
                obj016.setImageResource(R.drawable.object_wheat);
            } else {
                obj014.setImageResource(R.drawable.object_wheat);
                obj015.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 2;
        }
    }

    /* REINFORCE 3 CARD EFFECT METHOD */
    private void cardReinforce3() {
        if (objectsRemaining == 16) {
            tvCenterMessage.setText(boardIsFullError);
            tvCenterMessage.startAnimation(ani_fadeIn);
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                }
            }, 1000);
        }
        if (objectsRemaining == 15) {
            if (nextObjIsInfested){
                obj001.setImageResource(R.drawable.object_wheat_webbed);
                obj002.setImageResource(R.drawable.object_wheat);
            } else {
                obj001.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 14) {
            if (nextObjIsInfested){
                obj001.setImageResource(R.drawable.object_wheat_webbed);
                obj002.setImageResource(R.drawable.object_wheat);
                obj003.setImageResource(R.drawable.object_wheat);
            } else {
                obj001.setImageResource(R.drawable.object_wheat);
                obj002.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 13) {
            if (nextObjIsInfested){
                obj001.setImageResource(R.drawable.object_wheat_webbed);
                obj002.setImageResource(R.drawable.object_wheat);
                obj003.setImageResource(R.drawable.object_wheat);
                obj004.setImageResource(R.drawable.object_wheat);
            } else {
                obj001.setImageResource(R.drawable.object_wheat);
                obj002.setImageResource(R.drawable.object_wheat);
                obj003.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 12) {
            if (nextObjIsInfested){
                obj002.setImageResource(R.drawable.object_wheat_webbed);
                obj003.setImageResource(R.drawable.object_wheat);
                obj004.setImageResource(R.drawable.object_wheat);
                obj005.setImageResource(R.drawable.object_wheat);
            } else {
                obj002.setImageResource(R.drawable.object_wheat);
                obj003.setImageResource(R.drawable.object_wheat);
                obj004.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 11) {
            if (nextObjIsInfested){
                obj003.setImageResource(R.drawable.object_wheat_webbed);
                obj004.setImageResource(R.drawable.object_wheat);
                obj005.setImageResource(R.drawable.object_wheat);
                obj006.setImageResource(R.drawable.object_wheat);
            } else {
                obj003.setImageResource(R.drawable.object_wheat);
                obj004.setImageResource(R.drawable.object_wheat);
                obj005.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 10) {
            if (nextObjIsInfested){
                obj004.setImageResource(R.drawable.object_wheat_webbed);
                obj005.setImageResource(R.drawable.object_wheat);
                obj006.setImageResource(R.drawable.object_wheat);
                obj007.setImageResource(R.drawable.object_wheat);
            } else {
                obj004.setImageResource(R.drawable.object_wheat);
                obj005.setImageResource(R.drawable.object_wheat);
                obj006.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 9) {
            if (nextObjIsInfested){
                obj005.setImageResource(R.drawable.object_wheat_webbed);
                obj006.setImageResource(R.drawable.object_wheat);
                obj007.setImageResource(R.drawable.object_wheat);
                obj008.setImageResource(R.drawable.object_wheat);
            } else {
                obj005.setImageResource(R.drawable.object_wheat);
                obj006.setImageResource(R.drawable.object_wheat);
                obj007.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 8) {
            if (nextObjIsInfested){
                obj006.setImageResource(R.drawable.object_wheat_webbed);
                obj007.setImageResource(R.drawable.object_wheat);
                obj008.setImageResource(R.drawable.object_wheat);
                obj009.setImageResource(R.drawable.object_wheat);
            } else {
                obj006.setImageResource(R.drawable.object_wheat);
                obj007.setImageResource(R.drawable.object_wheat);
                obj008.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 7) {
            if (nextObjIsInfested){
                obj007.setImageResource(R.drawable.object_wheat_webbed);
                obj008.setImageResource(R.drawable.object_wheat);
                obj009.setImageResource(R.drawable.object_wheat);
                obj010.setImageResource(R.drawable.object_wheat);
            } else {
                obj007.setImageResource(R.drawable.object_wheat);
                obj008.setImageResource(R.drawable.object_wheat);
                obj009.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 6) {
            if (nextObjIsInfested){
                obj008.setImageResource(R.drawable.object_wheat_webbed);
                obj009.setImageResource(R.drawable.object_wheat);
                obj010.setImageResource(R.drawable.object_wheat);
                obj011.setImageResource(R.drawable.object_wheat);
            } else {
                obj008.setImageResource(R.drawable.object_wheat);
                obj009.setImageResource(R.drawable.object_wheat);
                obj010.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 5) {
            if (nextObjIsInfested){
                obj009.setImageResource(R.drawable.object_wheat_webbed);
                obj010.setImageResource(R.drawable.object_wheat);
                obj011.setImageResource(R.drawable.object_wheat);
                obj012.setImageResource(R.drawable.object_wheat);
            } else {
                obj009.setImageResource(R.drawable.object_wheat);
                obj010.setImageResource(R.drawable.object_wheat);
                obj011.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 4) {
            if (nextObjIsInfested){
                obj010.setImageResource(R.drawable.object_wheat_webbed);
                obj011.setImageResource(R.drawable.object_wheat);
                obj012.setImageResource(R.drawable.object_wheat);
                obj013.setImageResource(R.drawable.object_wheat);
            } else {
                obj010.setImageResource(R.drawable.object_wheat);
                obj011.setImageResource(R.drawable.object_wheat);
                obj012.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 3) {
            if (nextObjIsInfested){
                obj011.setImageResource(R.drawable.object_wheat_webbed);
                obj012.setImageResource(R.drawable.object_wheat);
                obj013.setImageResource(R.drawable.object_wheat);
                obj014.setImageResource(R.drawable.object_wheat);
            } else {
                obj011.setImageResource(R.drawable.object_wheat);
                obj012.setImageResource(R.drawable.object_wheat);
                obj013.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 2) {
            if (nextObjIsInfested){
                obj012.setImageResource(R.drawable.object_wheat_webbed);
                obj013.setImageResource(R.drawable.object_wheat);
                obj014.setImageResource(R.drawable.object_wheat);
                obj015.setImageResource(R.drawable.object_wheat);
            } else {
                obj012.setImageResource(R.drawable.object_wheat);
                obj013.setImageResource(R.drawable.object_wheat);
                obj014.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 1) {
            if (nextObjIsInfested){
                obj013.setImageResource(R.drawable.object_wheat_webbed);
                obj014.setImageResource(R.drawable.object_wheat);
                obj015.setImageResource(R.drawable.object_wheat);
                obj016.setImageResource(R.drawable.object_wheat);
            } else {
                obj013.setImageResource(R.drawable.object_wheat);
                obj014.setImageResource(R.drawable.object_wheat);
                obj015.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 3;
        }
    }

    /* SLOW DOWN CARD EFFECT METHOD */
    private void cardSlowDown() {
        if (playerTurn) {
            if (enemyHasProtect){
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        errorMsg = true;
                        tvCenterMessage.setText(ailmentFailed);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }, 1000);
            } else {
                if (!Arrays.asList(enemyStatuses).contains("Slow Down")){
                    tvCenterMessage.setText(enemySlowed);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                            if (activeEnemyStatuses < 5 && !Arrays.asList(enemyStatuses).contains("Slow Down")){
                                enemyIsSlowed = true;
                                addEnemySlow();
                                activeEnemyStatuses++;
                            } else {
                                errorMsg = true;
                                tvCenterMessage.setText(debuffAlreadyActiveError);
                                tvCenterMessage.startAnimation(ani_fadeIn);
                                myHandler.postDelayed(new Runnable() {
                                    public void run() {
                                        tvCenterMessage.startAnimation(ani_fadeOut);
                                    }
                                }, 1500);
                            }
                        }
                    }, 1000);
                } else {
                    errorMsg = true;
                    tvCenterMessage.setText(debuffAlreadyActiveError);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1500);
                }
            }

        } else {
            if (playerHasProtect){
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        errorMsg = true;
                        tvCenterMessage.setText(ailmentFailed);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }, 1000);
            } else {
                if (!Arrays.asList(playerStatuses).contains("Slow Down")){
                    tvCenterMessage.setText(playerSlowed);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                            if (activePlayerStatuses < 5 && !Arrays.asList(playerStatuses).contains("Slow Down")){
                                playerIsSlowed = true;
                                addPlayerSlow();
                                activePlayerStatuses++;
                            } else {
                                errorMsg = true;
                                tvCenterMessage.setText(debuffAlreadyActiveError);
                                tvCenterMessage.startAnimation(ani_fadeIn);
                                myHandler.postDelayed(new Runnable() {
                                    public void run() {
                                        tvCenterMessage.startAnimation(ani_fadeOut);
                                    }
                                }, 1500);
                            }
                        }
                    }, 1000);
                } else {
                    errorMsg = true;
                    tvCenterMessage.setText(debuffAlreadyActiveError);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1500);
                }
            }
        }
    }

    /* SPEED UP CARD EFFECT METHOD */
    private void cardSpeedUp() {
        if (playerTurn) {
            if (!Arrays.asList(playerStatuses).contains("Speed Up")){
                tvCenterMessage.setText(playerHaste);
                tvCenterMessage.startAnimation(ani_fadeIn);
            }
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                    if (activePlayerStatuses < 5 && !Arrays.asList(playerStatuses).contains("Speed Up")){
                        playerHasHaste = true;
                        addPlayerSpeedUp();
                        activePlayerStatuses++;
                    } else {
                        errorMsg = true;
                        tvCenterMessage.setText(buffAlreadyActiveError);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }
            }, 1000);
        } else {
            if (!Arrays.asList(enemyStatuses).contains("Speed Up")){
                tvCenterMessage.setText(enemyHaste);
                tvCenterMessage.startAnimation(ani_fadeIn);
            }
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                    if (activeEnemyStatuses < 5 && !Arrays.asList(enemyStatuses).contains("Speed Up")){
                        enemyHasHaste = true;
                        addEnemySpeedUp();
                        activeEnemyStatuses++;
                    } else {
                        errorMsg = true;
                        tvCenterMessage.setText(buffAlreadyActiveError);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }
            }, 1000);
        }
    }

    /* SPEED UP 2 CARD EFFECT METHOD */
    private void cardSpeedUp2() {
        if (playerTurn) {
            if (!Arrays.asList(playerStatuses).contains("Speed Up")){
                tvCenterMessage.setText(playerHaste);
                tvCenterMessage.startAnimation(ani_fadeIn);
            }
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                    if (activePlayerStatuses < 5 && !Arrays.asList(playerStatuses).contains("Speed Up")){
                        playerHasHaste2 = true;
                        addPlayerSpeedUp();
                        activePlayerStatuses++;
                    } else {
                        errorMsg = true;
                        tvCenterMessage.setText(buffAlreadyActiveError);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }
            }, 1000);
        } else {
            if (!Arrays.asList(enemyStatuses).contains("Speed Up")){
                tvCenterMessage.setText(enemyHaste);
                tvCenterMessage.startAnimation(ani_fadeIn);
            }
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                    if (activeEnemyStatuses < 5 && !Arrays.asList(enemyStatuses).contains("Speed Up")){
                        enemyHasHaste2 = true;
                        addEnemySpeedUp();
                        activeEnemyStatuses++;
                    } else {
                        errorMsg = true;
                        tvCenterMessage.setText(buffAlreadyActiveError);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }
            }, 1000);
        }
    }

    /* CONCENTRATE CARD EFFECT METHOD */
    private void cardConcentrate(){
        if (playerTurn) {
            if (!Arrays.asList(playerStatuses).contains("Concentrate")){
                tvCenterMessage.setText(playerConcentrate);
                tvCenterMessage.startAnimation(ani_fadeIn);
            }
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                    if (activePlayerStatuses < 5 && !Arrays.asList(playerStatuses).contains("Concentrate")){
                        playerHasConcentrate = true;
                        addPlayerConcentrate();
                        activePlayerStatuses++;
                    } else {
                        errorMsg = true;
                        tvCenterMessage.setText(buffAlreadyActiveError);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }
            }, 1000);
        } else {
            if (!Arrays.asList(enemyStatuses).contains("Concentrate")){
                tvCenterMessage.setText(enemyConcentrate);
                tvCenterMessage.startAnimation(ani_fadeIn);
            }
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                    if (activeEnemyStatuses < 5 && !Arrays.asList(enemyStatuses).contains("Concentrate")){
                        enemyHasConcentrate = true;
                        addEnemyConcentrate();
                        activeEnemyStatuses++;
                    } else {
                        errorMsg = true;
                        tvCenterMessage.setText(buffAlreadyActiveError);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }
            }, 1000);
        }
    }

    /* CORRUPTION CARD EFFECT METHOD */
    private void cardCorruption(){
        if (!playerTurn) {
            if (playerHasProtect){
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        errorMsg = true;
                        tvCenterMessage.setText(ailmentFailed);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }, 1000);
            } else {
                if (!Arrays.asList(playerStatuses).contains("Corruption")){
                    tvCenterMessage.setText(playerCorrupted);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                            if (activePlayerStatuses < 5 && !Arrays.asList(playerStatuses).contains("Corruption")){
                                addPlayerCorruption();
                                playerIsCorrupted = true;
                                activePlayerStatuses++;
                            } else {
                                errorMsg = true;
                                tvCenterMessage.setText(buffAlreadyActiveError);
                                tvCenterMessage.startAnimation(ani_fadeIn);
                                myHandler.postDelayed(new Runnable() {
                                    public void run() {
                                        tvCenterMessage.startAnimation(ani_fadeOut);
                                    }
                                }, 1500);
                            }
                        }
                    }, 1000);
                } else {
                    errorMsg = true;
                    tvCenterMessage.setText(buffAlreadyActiveError);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1500);
                }
            }

        } else {
            if (enemyHasProtect){
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        errorMsg = true;
                        tvCenterMessage.setText(ailmentFailed);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }, 1000);
            } else {
                if (!Arrays.asList(enemyStatuses).contains("Corruption")){
                    tvCenterMessage.setText(enemyCorrupted);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                            if (activeEnemyStatuses < 5 && !Arrays.asList(enemyStatuses).contains("Corruption")){
                                addEnemyCorruption();
                                enemyIsCorrupted = true;
                                activeEnemyStatuses++;
                            } else {
                                errorMsg = true;
                                tvCenterMessage.setText(buffAlreadyActiveError);
                                tvCenterMessage.startAnimation(ani_fadeIn);
                                myHandler.postDelayed(new Runnable() {
                                    public void run() {
                                        tvCenterMessage.startAnimation(ani_fadeOut);
                                    }
                                }, 1500);
                            }
                        }
                    }, 1000);
                } else {
                    errorMsg = true;
                    tvCenterMessage.setText(buffAlreadyActiveError);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1500);
                }
            }
        }
    }

    /* CURSE CARD EFFECT METHOD */
    private void cardCurse() {
        if (playerTurn) {
            if (enemyHasProtect){
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        errorMsg = true;
                        tvCenterMessage.setText(ailmentFailed);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }, 1000);
            } else {
                if (!Arrays.asList(enemyStatuses).contains("Curse")){
                    tvCenterMessage.setText(enemyCursed);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                            if (activeEnemyStatuses < 5 && !Arrays.asList(enemyStatuses).contains("Curse")){
                                enemyIsCursed = true;
                                addEnemyCurse();
                                activeEnemyStatuses++;
                            } else {
                                errorMsg = true;
                                tvCenterMessage.setText(debuffAlreadyActiveError);
                                tvCenterMessage.startAnimation(ani_fadeIn);
                                myHandler.postDelayed(new Runnable() {
                                    public void run() {
                                        tvCenterMessage.startAnimation(ani_fadeOut);
                                    }
                                }, 1500);
                            }
                        }
                    }, 1000);
                } else {
                    errorMsg = true;
                    tvCenterMessage.setText(buffAlreadyActiveError);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1500);
                }
            }
        } else {
            if (playerHasProtect){
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        errorMsg = true;
                        tvCenterMessage.setText(ailmentFailed);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }, 1000);
            } else {
                if (!Arrays.asList(playerStatuses).contains("Curse")){
                    tvCenterMessage.setText(playerCursed);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                            if (activePlayerStatuses < 5 && !Arrays.asList(playerStatuses).contains("Curse")){
                                playerIsCursed = true;
                                addPlayerCurse();
                                activePlayerStatuses++;
                            } else {
                                errorMsg = true;
                                tvCenterMessage.setText(debuffAlreadyActiveError);
                                tvCenterMessage.startAnimation(ani_fadeIn);
                                myHandler.postDelayed(new Runnable() {
                                    public void run() {
                                        tvCenterMessage.startAnimation(ani_fadeOut);
                                    }
                                }, 1500);
                            }
                        }
                    }, 1000);
                } else {
                    errorMsg = true;
                    tvCenterMessage.setText(buffAlreadyActiveError);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1500);
                }
            }
        }
    }

    /* AGONY CARD EFFECT METHOD */
    private void cardAgony(){
        if (playerTurn) {
            if (enemyHasProtect){
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        errorMsg = true;
                        tvCenterMessage.setText(ailmentFailed);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }, 1000);
            } else {
                if (!Arrays.asList(enemyStatuses).contains("Agony")){
                    tvCenterMessage.setText(enemyAgonized);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                            if (activeEnemyStatuses < 5 && !Arrays.asList(enemyStatuses).contains("Agony")){
                                enemyIsAgonized = true;
                                addEnemyAgony();
                                activeEnemyStatuses++;
                            } else {
                                errorMsg = true;
                                tvCenterMessage.setText(debuffAlreadyActiveError);
                                tvCenterMessage.startAnimation(ani_fadeIn);
                                myHandler.postDelayed(new Runnable() {
                                    public void run() {
                                        tvCenterMessage.startAnimation(ani_fadeOut);
                                    }
                                }, 1500);
                            }
                        }
                    }, 1000);
                } else {
                    errorMsg = true;
                    tvCenterMessage.setText(buffAlreadyActiveError);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1500);
                }
            }
        } else {
            if (playerHasProtect){
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        errorMsg = true;
                        tvCenterMessage.setText(ailmentFailed);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }, 1000);
            } else {
                if (!Arrays.asList(playerStatuses).contains("Agony")){
                    tvCenterMessage.setText(playerAgonized);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                            if (activePlayerStatuses < 5 && !Arrays.asList(playerStatuses).contains("Agony")){
                                playerIsAgonized = true;
                                addPlayerAgony();
                                activePlayerStatuses++;
                            } else {
                                errorMsg = true;
                                tvCenterMessage.setText(debuffAlreadyActiveError);
                                tvCenterMessage.startAnimation(ani_fadeIn);
                                myHandler.postDelayed(new Runnable() {
                                    public void run() {
                                        tvCenterMessage.startAnimation(ani_fadeOut);
                                    }
                                }, 1500);
                            }
                        }
                    }, 1000);
                } else {
                    errorMsg = true;
                    tvCenterMessage.setText(buffAlreadyActiveError);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1500);
                }
            }
        }
    }

    /* STEAL CARD EFFECT METHOD */
    private void cardSteal(int min, int max){
        int finalNumber;
        if (playerTurn){
            tvEnemyScore.startAnimation(ani_shake);
            if (max > enemyScore){
                max = enemyScore;
            }
            if (min > enemyScore){
                min = enemyScore;
            }

            finalNumber = genRandRange(min, max);

            tvEnemyScore.setText("-" + String.valueOf(finalNumber));
            tvPlayerScore.startAnimation(ani_scoregain);
            tvPlayerScore.setText("+" + String.valueOf(finalNumber));

            enemyScore = enemyScore - finalNumber;
            playerScore = playerScore + finalNumber;
            if (enemyScore < 0){
                enemyScore = 0;
            }
            tvPlayerScore.setTextColor(getResources().getColor(R.color.supergreen));
            tvEnemyScore.setTextColor(getResources().getColor(R.color.textBrightRed));
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerScore.setTextColor(getResources().getColor(R.color.textBlack));
                    tvEnemyScore.setTextColor(getResources().getColor(R.color.textBlack));
                    tvEnemyScore.setText(String.valueOf(enemyScore));
                    tvEnemyScore.startAnimation(ani_resetscore);
                    tvPlayerScore.startAnimation(ani_resetscore);
                }
            }, 1000);
        } else {
            tvPlayerScore.startAnimation(ani_shake);
            if (max > playerScore){
                max = playerScore;
            }
            if (min > playerScore){
                min = playerScore;
            }

            finalNumber = genRandRange(min, max);

            tvPlayerScore.setText("-" + String.valueOf(finalNumber));
            tvEnemyScore.startAnimation(ani_scoregain);
            tvEnemyScore.setText("+" + String.valueOf(finalNumber));

            enemyScore = enemyScore + finalNumber;
            playerScore = playerScore - finalNumber;
            if (playerScore < 0){
                playerScore = 0;
            }
            tvEnemyScore.setTextColor(getResources().getColor(R.color.supergreen));
            tvPlayerScore.setTextColor(getResources().getColor(R.color.textBrightRed));
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerScore.setTextColor(getResources().getColor(R.color.textBlack));
                    tvEnemyScore.setTextColor(getResources().getColor(R.color.textBlack));
                    tvEnemyScore.setText(String.valueOf(enemyScore));
                    tvEnemyScore.startAnimation(ani_resetscore);
                    tvPlayerScore.startAnimation(ani_resetscore);
                }
            }, 1000);
        }
    }

    /* MIMIC CARD EFFECT METHOD */
    private void cardMimic(){
        if (playerTurn){
            if (!lastEnemyPlayedCard.equals("")){
                tvCenterMessage.startAnimation(ani_fadeIn);
                if (lastEnemyPlayedCard.equals("Mimic")){
                    tvCenterMessage.setText("Mimic failed");
                } else {
                    tvCenterMessage.setText("Mimic copies " + lastEnemyPlayedCard);
                }
                if (lastEnemyPlayedCard.equals("Reinforce")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardReinforce1();
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Reinforce II")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardReinforce2();
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Reinforce III")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardReinforce3();
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Slow Down")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardSlowDown();
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Speed Up")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardSpeedUp();
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Speed Up II")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardSpeedUp2();
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Steal")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardSteal(1,3);
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Concentrate")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardConcentrate();
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Steal II")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardSteal(3,5);
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Steal III")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardSteal(5,7);
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Corruption")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardCorruption();
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Curse")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardCurse();
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Infest")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardInfest();
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Restore")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardRestore();
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Agony")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardAgony();
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Malediction")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardMalediction();
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Demonic Prayer")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardDemonicPrayer();
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Death Sentence")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardDeathSentence();
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Cure")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardCure();
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Rewind")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardRewind();
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Hoard")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardHoard();
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Protect")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardProtect();
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Dispel")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardDispel();
                        }
                    }, 2000);
                }
                if (lastEnemyPlayedCard.equals("Mimic")){
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    tvCenterMessage.setText("Mimic failed");
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                }
            } else {
                tvCenterMessage.startAnimation(ani_fadeIn);
                tvCenterMessage.setText("Mimic failed");
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        return;
                    }
                }, 1000);
            }
        } else {
            if (!lastPlayerPlayedCard.equals("")){
                tvCenterMessage.startAnimation(ani_fadeIn);
                if (lastPlayerPlayedCard.equals("Mimic")){
                    tvCenterMessage.setText("Mimic failed");
                } else {
                    tvCenterMessage.setText("Mimic copies " + lastPlayerPlayedCard);
                }
                if (lastPlayerPlayedCard.equals("Reinforce")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardReinforce1();
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Reinforce II")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardReinforce2();
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Reinforce III")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardReinforce3();
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Slow Down")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardSlowDown();
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Speed Up")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardSpeedUp();
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Speed Up II")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardSpeedUp2();
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Steal")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardSteal(1,3);
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Concentrate")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardConcentrate();
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Steal II")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardSteal(3,5);
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Steal III")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardSteal(5,7);
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Corruption")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardCorruption();
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Curse")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardCurse();
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Infest")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardInfest();
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Restore")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardRestore();
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Agony")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardAgony();
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Malediction")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardMalediction();
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Demonic Prayer")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardDemonicPrayer();
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Death Sentence")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardDeathSentence();
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Cure")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardCure();
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Protect")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardProtect();
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Rewind")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardRewind();
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Hoard")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardHoard();
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Dispel")){
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            cardDispel();
                        }
                    }, 2000);
                }
                if (lastPlayerPlayedCard.equals("Mimic")){
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    tvCenterMessage.setText("Mimic failed");
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1000);
                }
            } else {
                tvCenterMessage.setText("Mimic failed");
                tvCenterMessage.startAnimation(ani_fadeIn);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                    }
                }, 1000);
            }
        }
    }

    /* INFEST CARD EFFECT METHOD */
    private void cardInfest(){
        if (!nextObjIsInfested){
            nextObjIsInfested = true;
            infestedObjRemainingHits = 3;
            if (objectsRemaining == 16) {
                tvCenterMessage.setText(infestMsg);
                tvCenterMessage.startAnimation(ani_fadeIn);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        obj001.setImageResource(R.drawable.object_wheat_webbed);
                    }
                }, 1000);
            }
            if (objectsRemaining == 15) {
                tvCenterMessage.setText(infestMsg);
                tvCenterMessage.startAnimation(ani_fadeIn);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        obj002.setImageResource(R.drawable.object_wheat_webbed);
                    }
                }, 1000);
            }
            if (objectsRemaining == 14) {
                tvCenterMessage.setText(infestMsg);
                tvCenterMessage.startAnimation(ani_fadeIn);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        obj003.setImageResource(R.drawable.object_wheat_webbed);
                    }
                }, 1000);
            }
            if (objectsRemaining == 13) {
                tvCenterMessage.setText(infestMsg);
                tvCenterMessage.startAnimation(ani_fadeIn);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        obj004.setImageResource(R.drawable.object_wheat_webbed);
                    }
                }, 1000);
            }
            if (objectsRemaining == 12) {
                tvCenterMessage.setText(infestMsg);
                tvCenterMessage.startAnimation(ani_fadeIn);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        obj005.setImageResource(R.drawable.object_wheat_webbed);
                    }
                }, 1000);
            }
            if (objectsRemaining == 11) {
                tvCenterMessage.setText(infestMsg);
                tvCenterMessage.startAnimation(ani_fadeIn);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        obj006.setImageResource(R.drawable.object_wheat_webbed);
                    }
                }, 1000);
            }
            if (objectsRemaining == 10) {
                tvCenterMessage.setText(infestMsg);
                tvCenterMessage.startAnimation(ani_fadeIn);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        obj007.setImageResource(R.drawable.object_wheat_webbed);
                    }
                }, 1000);
            }
            if (objectsRemaining == 9) {
                tvCenterMessage.setText(infestMsg);
                tvCenterMessage.startAnimation(ani_fadeIn);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        obj008.setImageResource(R.drawable.object_wheat_webbed);
                    }
                }, 1000);
            }
            if (objectsRemaining == 8) {
                tvCenterMessage.setText(infestMsg);
                tvCenterMessage.startAnimation(ani_fadeIn);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        obj009.setImageResource(R.drawable.object_wheat_webbed);
                    }
                }, 1000);
            }
            if (objectsRemaining == 7) {
                tvCenterMessage.setText(infestMsg);
                tvCenterMessage.startAnimation(ani_fadeIn);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        obj010.setImageResource(R.drawable.object_wheat_webbed);
                    }
                }, 1000);
            }
            if (objectsRemaining == 6) {
                tvCenterMessage.setText(infestMsg);
                tvCenterMessage.startAnimation(ani_fadeIn);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        obj011.setImageResource(R.drawable.object_wheat_webbed);
                    }
                }, 1000);
            }
            if (objectsRemaining == 5) {
                tvCenterMessage.setText(infestMsg);
                tvCenterMessage.startAnimation(ani_fadeIn);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        obj012.setImageResource(R.drawable.object_wheat_webbed);
                    }
                }, 1000);
            }
            if (objectsRemaining == 4) {
                tvCenterMessage.setText(infestMsg);
                tvCenterMessage.startAnimation(ani_fadeIn);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        obj013.setImageResource(R.drawable.object_wheat_webbed);
                    }
                }, 1000);
            }
            if (objectsRemaining == 3) {
                tvCenterMessage.setText(infestMsg);
                tvCenterMessage.startAnimation(ani_fadeIn);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        obj014.setImageResource(R.drawable.object_wheat_webbed);
                    }
                }, 1000);
            }
            if (objectsRemaining == 2) {
                tvCenterMessage.setText(infestMsg);
                tvCenterMessage.startAnimation(ani_fadeIn);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        obj015.setImageResource(R.drawable.object_wheat_webbed);
                    }
                }, 1000);
            }
            if (objectsRemaining == 1) {
                tvCenterMessage.setText(infestMsg);
                tvCenterMessage.startAnimation(ani_fadeIn);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        tvCenterMessage.startAnimation(ani_fadeOut);
                        obj016.setImageResource(R.drawable.object_wheat_webbed);
                    }
                }, 1000);
            }
        } else {
            errorMsg = true;
            tvCenterMessage.setText(infestError);
            tvCenterMessage.startAnimation(ani_fadeIn);
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                }
            }, 1500);
        }

    }

    /* RESTORE CARD EFFECT METHOD */
    private void cardRestore(){
        if (objectsRemaining == 16) {
            tvCenterMessage.setText(boardIsFullError);
            tvCenterMessage.startAnimation(ani_fadeIn);
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                }
            }, 1000);
        }
        if (objectsRemaining == 15) {
            if (nextObjIsInfested){
                obj001.setImageResource(R.drawable.object_wheat_webbed);
                obj002.setImageResource(R.drawable.object_wheat);
            } else {
                obj001.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 14) {
            if (nextObjIsInfested){
                obj002.setImageResource(R.drawable.object_wheat_webbed);
                obj003.setImageResource(R.drawable.object_wheat);
            } else {
                obj002.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 13) {
            if (nextObjIsInfested){
                obj002.setImageResource(R.drawable.object_wheat_webbed);
                obj003.setImageResource(R.drawable.object_wheat);
                obj004.setImageResource(R.drawable.object_wheat);
            } else {
                obj002.setImageResource(R.drawable.object_wheat);
                obj003.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 12) {
            if (nextObjIsInfested){
                obj003.setImageResource(R.drawable.object_wheat_webbed);
                obj004.setImageResource(R.drawable.object_wheat);
                obj005.setImageResource(R.drawable.object_wheat);
            } else {
                obj003.setImageResource(R.drawable.object_wheat);
                obj004.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 11) {
            if (nextObjIsInfested){
                obj003.setImageResource(R.drawable.object_wheat_webbed);
                obj004.setImageResource(R.drawable.object_wheat);
                obj005.setImageResource(R.drawable.object_wheat);
                obj006.setImageResource(R.drawable.object_wheat);
            } else {
                obj003.setImageResource(R.drawable.object_wheat);
                obj004.setImageResource(R.drawable.object_wheat);
                obj005.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 10) {
            if (nextObjIsInfested){
                obj004.setImageResource(R.drawable.object_wheat_webbed);
                obj005.setImageResource(R.drawable.object_wheat);
                obj006.setImageResource(R.drawable.object_wheat);
                obj007.setImageResource(R.drawable.object_wheat);
            } else {
                obj004.setImageResource(R.drawable.object_wheat);
                obj005.setImageResource(R.drawable.object_wheat);
                obj006.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 9) {
            if (nextObjIsInfested){
                obj004.setImageResource(R.drawable.object_wheat_webbed);
                obj005.setImageResource(R.drawable.object_wheat);
                obj006.setImageResource(R.drawable.object_wheat);
                obj007.setImageResource(R.drawable.object_wheat);
                obj008.setImageResource(R.drawable.object_wheat);
            } else {
                obj004.setImageResource(R.drawable.object_wheat);
                obj005.setImageResource(R.drawable.object_wheat);
                obj006.setImageResource(R.drawable.object_wheat);
                obj007.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 4;
        }
        if (objectsRemaining == 8) {
            if (nextObjIsInfested){
                obj005.setImageResource(R.drawable.object_wheat_webbed);
                obj006.setImageResource(R.drawable.object_wheat);
                obj007.setImageResource(R.drawable.object_wheat);
                obj008.setImageResource(R.drawable.object_wheat);
                obj009.setImageResource(R.drawable.object_wheat);
            } else {
                obj006.setImageResource(R.drawable.object_wheat);
                obj007.setImageResource(R.drawable.object_wheat);
                obj008.setImageResource(R.drawable.object_wheat);
                obj009.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 4;
        }
        if (objectsRemaining == 7) {
            if (nextObjIsInfested){
                obj005.setImageResource(R.drawable.object_wheat_webbed);
                obj006.setImageResource(R.drawable.object_wheat);
                obj007.setImageResource(R.drawable.object_wheat);
                obj008.setImageResource(R.drawable.object_wheat);
                obj009.setImageResource(R.drawable.object_wheat);
                obj010.setImageResource(R.drawable.object_wheat);
            } else {
                obj005.setImageResource(R.drawable.object_wheat);
                obj006.setImageResource(R.drawable.object_wheat);
                obj007.setImageResource(R.drawable.object_wheat);
                obj008.setImageResource(R.drawable.object_wheat);
                obj009.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 5;
        }
        if (objectsRemaining == 6) {
            if (nextObjIsInfested){
                obj006.setImageResource(R.drawable.object_wheat_webbed);
                obj007.setImageResource(R.drawable.object_wheat);
                obj008.setImageResource(R.drawable.object_wheat);
                obj009.setImageResource(R.drawable.object_wheat);
                obj010.setImageResource(R.drawable.object_wheat);
                obj011.setImageResource(R.drawable.object_wheat);
            } else {
                obj006.setImageResource(R.drawable.object_wheat);
                obj007.setImageResource(R.drawable.object_wheat);
                obj008.setImageResource(R.drawable.object_wheat);
                obj009.setImageResource(R.drawable.object_wheat);
                obj010.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 5;
        }
        if (objectsRemaining == 5) {
            if (nextObjIsInfested){
                obj006.setImageResource(R.drawable.object_wheat_webbed);
                obj007.setImageResource(R.drawable.object_wheat);
                obj008.setImageResource(R.drawable.object_wheat);
                obj009.setImageResource(R.drawable.object_wheat);
                obj010.setImageResource(R.drawable.object_wheat);
                obj011.setImageResource(R.drawable.object_wheat);
                obj012.setImageResource(R.drawable.object_wheat);
            } else {
                obj006.setImageResource(R.drawable.object_wheat);
                obj007.setImageResource(R.drawable.object_wheat);
                obj008.setImageResource(R.drawable.object_wheat);
                obj009.setImageResource(R.drawable.object_wheat);
                obj010.setImageResource(R.drawable.object_wheat);
                obj011.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 6;
        }
        if (objectsRemaining == 4) {
            if (nextObjIsInfested){
                obj007.setImageResource(R.drawable.object_wheat_webbed);
                obj008.setImageResource(R.drawable.object_wheat);
                obj009.setImageResource(R.drawable.object_wheat);
                obj010.setImageResource(R.drawable.object_wheat);
                obj011.setImageResource(R.drawable.object_wheat);
                obj012.setImageResource(R.drawable.object_wheat);
                obj013.setImageResource(R.drawable.object_wheat);
            } else {
                obj007.setImageResource(R.drawable.object_wheat);
                obj008.setImageResource(R.drawable.object_wheat);
                obj009.setImageResource(R.drawable.object_wheat);
                obj010.setImageResource(R.drawable.object_wheat);
                obj011.setImageResource(R.drawable.object_wheat);
                obj012.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 6;
        }
        if (objectsRemaining == 3) {
            if (nextObjIsInfested){
                obj008.setImageResource(R.drawable.object_wheat_webbed);
                obj009.setImageResource(R.drawable.object_wheat);
                obj010.setImageResource(R.drawable.object_wheat);
                obj011.setImageResource(R.drawable.object_wheat);
                obj012.setImageResource(R.drawable.object_wheat);
                obj013.setImageResource(R.drawable.object_wheat);
                obj014.setImageResource(R.drawable.object_wheat);
            } else {
                obj008.setImageResource(R.drawable.object_wheat);
                obj009.setImageResource(R.drawable.object_wheat);
                obj010.setImageResource(R.drawable.object_wheat);
                obj011.setImageResource(R.drawable.object_wheat);
                obj012.setImageResource(R.drawable.object_wheat);
                obj013.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 6;
        }
        if (objectsRemaining == 2) {
            if (nextObjIsInfested){
                obj008.setImageResource(R.drawable.object_wheat_webbed);
                obj009.setImageResource(R.drawable.object_wheat);
                obj010.setImageResource(R.drawable.object_wheat);
                obj011.setImageResource(R.drawable.object_wheat);
                obj012.setImageResource(R.drawable.object_wheat);
                obj013.setImageResource(R.drawable.object_wheat);
                obj014.setImageResource(R.drawable.object_wheat);
                obj015.setImageResource(R.drawable.object_wheat);
            } else {
                obj008.setImageResource(R.drawable.object_wheat);
                obj009.setImageResource(R.drawable.object_wheat);
                obj010.setImageResource(R.drawable.object_wheat);
                obj011.setImageResource(R.drawable.object_wheat);
                obj012.setImageResource(R.drawable.object_wheat);
                obj013.setImageResource(R.drawable.object_wheat);
                obj014.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 7;
        }
        if (objectsRemaining == 1) {
            if (nextObjIsInfested){
                obj009.setImageResource(R.drawable.object_wheat_webbed);
                obj010.setImageResource(R.drawable.object_wheat);
                obj011.setImageResource(R.drawable.object_wheat);
                obj012.setImageResource(R.drawable.object_wheat);
                obj013.setImageResource(R.drawable.object_wheat);
                obj014.setImageResource(R.drawable.object_wheat);
                obj015.setImageResource(R.drawable.object_wheat);
                obj016.setImageResource(R.drawable.object_wheat);
            } else {
                obj009.setImageResource(R.drawable.object_wheat);
                obj010.setImageResource(R.drawable.object_wheat);
                obj011.setImageResource(R.drawable.object_wheat);
                obj012.setImageResource(R.drawable.object_wheat);
                obj013.setImageResource(R.drawable.object_wheat);
                obj014.setImageResource(R.drawable.object_wheat);
                obj015.setImageResource(R.drawable.object_wheat);
            }
            objectsRemaining = objectsRemaining + 7;
        }
    }

    /* MALEDICTION CARD EFFECT METHOD */
    private void cardMalediction(){
        if (playerTurn) {
            if (enemyHasProtect){
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        errorMsg = true;
                        tvCenterMessage.setText(ailmentFailed);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }, 1000);
            } else {
                if (!Arrays.asList(enemyStatuses).contains("Malediction")){
                    tvCenterMessage.setText(enemyMaledicted);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                            if (activeEnemyStatuses < 5 && !Arrays.asList(enemyStatuses).contains("Malediction")){
                                enemyIsMaledicted = true;
                                addEnemyMalediction();
                                activeEnemyStatuses++;
                            } else {
                                errorMsg = true;
                                tvCenterMessage.setText(debuffAlreadyActiveError);
                                tvCenterMessage.startAnimation(ani_fadeIn);
                                myHandler.postDelayed(new Runnable() {
                                    public void run() {
                                        tvCenterMessage.startAnimation(ani_fadeOut);
                                    }
                                }, 1500);
                            }
                        }
                    }, 1000);
                } else {
                    errorMsg = true;
                    tvCenterMessage.setText(buffAlreadyActiveError);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1500);
                }
            }
        } else {
            if (playerHasProtect){
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        errorMsg = true;
                        tvCenterMessage.setText(ailmentFailed);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }, 1000);
            } else {
                if (!Arrays.asList(playerStatuses).contains("Malediction")){
                    tvCenterMessage.setText(playerMaledicted);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                            if (activePlayerStatuses < 5 && !Arrays.asList(playerStatuses).contains("Malediction")){
                                playerIsMaledicted = true;
                                addPlayerMalediction();
                                activePlayerStatuses++;
                            } else {
                                errorMsg = true;
                                tvCenterMessage.setText(debuffAlreadyActiveError);
                                tvCenterMessage.startAnimation(ani_fadeIn);
                                myHandler.postDelayed(new Runnable() {
                                    public void run() {
                                        tvCenterMessage.startAnimation(ani_fadeOut);
                                    }
                                }, 1500);
                            }
                        }
                    }, 1000);
                } else {
                    errorMsg = true;
                    tvCenterMessage.setText(buffAlreadyActiveError);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1500);
                }
            }
        }
    }

    /* DEMONIC PRAYER CARD EFFECT METHOD */
    private void cardDemonicPrayer(){
        final int resetChance = genRand(100);
        ivCenterImage.setImageResource(R.drawable.demonic_prayer_effect);
        ivCenterImage.startAnimation(ani_fadeIn);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                ivCenterImage.setImageResource(R.drawable.demonic_prayer_effect_question);
            }
        }, 3000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                ivCenterImage.setImageResource(R.drawable.demonic_prayer_effect);
            }
        }, 4000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                ivCenterImage.setImageResource(R.drawable.demonic_prayer_effect_question);
            }
        }, 4200);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                ivCenterImage.setImageResource(R.drawable.demonic_prayer_effect);
            }
        }, 4400);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                ivCenterImage.setImageResource(R.drawable.demonic_prayer_effect_question);
            }
        }, 4600);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                ivCenterImage.setImageResource(R.drawable.demonic_prayer_effect);
            }
        }, 4800);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                ivCenterImage.setImageResource(R.drawable.demonic_prayer_effect_question);
            }
        }, 5000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                ivCenterImage.setImageResource(R.drawable.demonic_prayer_effect);
            }
        }, 5200);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                if (resetChance >= 10){
                    ivCenterImage.setImageResource(R.drawable.demonic_prayer_effect_green);
                    resetWorked = false;
                } else {
                    ivCenterImage.setImageResource(R.drawable.demonic_prayer_effect_red);
                    resetWorked = true;
                }
            }
        }, 7200);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                ivCenterImage.startAnimation(ani_fadeOut);
                if (resetWorked){
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    tvCenterMessage.setText("Demonic Prayer worked!");
                    if (playerTurn){
                        tvEnemyScore.startAnimation(ani_shake);
                        tvEnemyScore.setTextColor(getResources().getColor(R.color.textBrightRed));
                        tvEnemyScore.setText("0");
                        enemyScore = 0;
                    } else {
                        tvPlayerScore.startAnimation(ani_shake);
                        tvPlayerScore.setTextColor(getResources().getColor(R.color.textBrightRed));
                        tvPlayerScore.setText("0");
                        playerScore = 0;
                    }
                } else {
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    tvCenterMessage.setText("Demonic Prayer failed!");
                }
            }
        }, 9200);

        myHandler.postDelayed(new Runnable() {
            public void run() {
                tvCenterMessage.startAnimation(ani_fadeOut);
                ivCenterImage.clearAnimation();
                ivCenterImage.setVisibility(View.INVISIBLE);
            }
        }, 10200);

        myHandler.postDelayed(new Runnable() {
            public void run() {
                if (playerTurn) {
                    tvEnemyScore.setTextColor(getResources().getColor(R.color.textBlack));
                    tvEnemyScore.setText(String.valueOf(enemyScore));
                    tvEnemyScore.startAnimation(ani_resetscore);
                    tvPlayerScore.clearAnimation();
                } else {
                    tvPlayerScore.setTextColor(getResources().getColor(R.color.textBlack));
                    tvPlayerScore.setText(String.valueOf(playerScore));
                    tvPlayerScore.startAnimation(ani_resetscore);
                    tvEnemyScore.clearAnimation();
                }
            }
        }, 11200);
    }

    /* DEATH SENTENCE CARD EFFECT METHOD */
    private void cardDeathSentence(){
        if (playerTurn){
            if (enemyHasProtect){
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        errorMsg = true;
                        tvCenterMessage.setText(ailmentFailed);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }, 1000);
            } else {
                if (!Arrays.asList(enemyStatuses).contains("Death Sentence")){
                    tvCenterMessage.setText(enemySentenced);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                            if (activeEnemyStatuses < 5 && !Arrays.asList(enemyStatuses).contains("Death Sentence")){
                                enemyIsSentenced = true;
                                addEnemyDeathSentence();
                                activeEnemyStatuses++;
                            } else {
                                errorMsg = true;
                                tvCenterMessage.setText(debuffAlreadyActiveError);
                                tvCenterMessage.startAnimation(ani_fadeIn);
                                myHandler.postDelayed(new Runnable() {
                                    public void run() {
                                        tvCenterMessage.startAnimation(ani_fadeOut);
                                    }
                                }, 1500);
                            }
                        }
                    }, 1000);
                } else {
                    errorMsg = true;
                    tvCenterMessage.setText(buffAlreadyActiveError);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1500);
                }
            }
        } else {
            if (playerHasProtect){
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        errorMsg = true;
                        tvCenterMessage.setText(ailmentFailed);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }, 1000);
            } else {
                if (!Arrays.asList(playerStatuses).contains("Death Sentence")){
                    tvCenterMessage.setText(playerSentenced);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                            if (activePlayerStatuses < 5 && !Arrays.asList(playerStatuses).contains("Death Sentence")){
                                playerIsSentenced = true;
                                addPlayerDeathSentence();
                                activePlayerStatuses++;
                            } else {
                                errorMsg = true;
                                tvCenterMessage.setText(debuffAlreadyActiveError);
                                tvCenterMessage.startAnimation(ani_fadeIn);
                                myHandler.postDelayed(new Runnable() {
                                    public void run() {
                                        tvCenterMessage.startAnimation(ani_fadeOut);
                                    }
                                }, 1500);
                            }
                        }
                    }, 1000);
                } else {
                    errorMsg = true;
                    tvCenterMessage.setText(buffAlreadyActiveError);
                    tvCenterMessage.startAnimation(ani_fadeIn);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            tvCenterMessage.startAnimation(ani_fadeOut);
                        }
                    }, 1500);
                }
            }
        }
    }

    /* CURE CARD EFFECT METHOD */
    private void cardCure(){
        if (playerTurn){
            tvCenterMessage.setText(playerCured);
            tvCenterMessage.startAnimation(ani_fadeIn);
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                    checkPlayerAilments();
                }
            }, 1500);
        } else {
            tvCenterMessage.setText(enemyCured);
            tvCenterMessage.startAnimation(ani_fadeIn);
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                    checkEnemyAilments();
                }
            }, 1500);
        }
    }

    /* REWIND CARD EFFECT METHOD */
    private void cardRewind(){
        if (playerTurn) {
            if (!Arrays.asList(playerStatuses).contains("Rewind")){
                tvCenterMessage.setText(playerAlteredTime);
                tvCenterMessage.startAnimation(ani_fadeIn);
            }
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                    if (activePlayerStatuses < 5 && !Arrays.asList(playerStatuses).contains("Rewind")){
                        playerHasAlteredTime = true;
                        addPlayerRewind();
                        activePlayerStatuses++;
                    } else {
                        errorMsg = true;
                        tvCenterMessage.setText(buffAlreadyActiveError);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }
            }, 1000);
        } else {
            if (!Arrays.asList(enemyStatuses).contains("Rewind")){
                tvCenterMessage.setText(enemyAlteredTime);
                tvCenterMessage.startAnimation(ani_fadeIn);
            }
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                    if (activeEnemyStatuses < 5 && !Arrays.asList(enemyStatuses).contains("Rewind")){
                        enemyHasAlteredTime = true;
                        addEnemyRewind();
                        activeEnemyStatuses++;
                    } else {
                        errorMsg = true;
                        tvCenterMessage.setText(buffAlreadyActiveError);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }
            }, 1000);
        }
    }

    /* PROTECT CARD EFFECT METHOD */
    private void cardProtect(){
        if (playerTurn) {
            if (!Arrays.asList(playerStatuses).contains("Protect")){
                tvCenterMessage.setText(playerProtected);
                tvCenterMessage.startAnimation(ani_fadeIn);
            }
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                    if (activePlayerStatuses < 5 && !Arrays.asList(playerStatuses).contains("Protect")){
                        playerHasProtect = true;
                        addPlayerProtect();
                        activePlayerStatuses++;
                    } else {
                        errorMsg = true;
                        tvCenterMessage.setText(buffAlreadyActiveError);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }
            }, 1000);
        } else {
            if (!Arrays.asList(enemyStatuses).contains("Protect")){
                tvCenterMessage.setText(enemyProtected);
                tvCenterMessage.startAnimation(ani_fadeIn);
            }
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                    if (activeEnemyStatuses < 5 && !Arrays.asList(enemyStatuses).contains("Protect")){
                        enemyHasProtect = true;
                        addEnemyProtect();
                        activeEnemyStatuses++;
                    } else {
                        errorMsg = true;
                        tvCenterMessage.setText(buffAlreadyActiveError);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }
            }, 1000);
        }
    }

    /* HOARD CARD EFFECT METHOD */
    private void cardHoard(){
        if (playerTurn) {
            if (!Arrays.asList(playerStatuses).contains("Hoard")){
                tvCenterMessage.setText(playerHoard);
                tvCenterMessage.startAnimation(ani_fadeIn);
            }
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                    if (activePlayerStatuses < 5 && !Arrays.asList(playerStatuses).contains("Hoard")){
                        playerIsHoarding = true;
                        addPlayerHoard();
                        activePlayerStatuses++;
                    } else {
                        errorMsg = true;
                        tvCenterMessage.setText(buffAlreadyActiveError);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }
            }, 1000);
        } else {
            if (!Arrays.asList(enemyStatuses).contains("Hoard")){
                tvCenterMessage.setText(enemyHoard);
                tvCenterMessage.startAnimation(ani_fadeIn);
            }
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                    if (activeEnemyStatuses < 5 && !Arrays.asList(enemyStatuses).contains("Hoard")){
                        enemyIsHoarding = true;
                        addEnemyHoard();
                        activeEnemyStatuses++;
                    } else {
                        errorMsg = true;
                        tvCenterMessage.setText(buffAlreadyActiveError);
                        tvCenterMessage.startAnimation(ani_fadeIn);
                        myHandler.postDelayed(new Runnable() {
                            public void run() {
                                tvCenterMessage.startAnimation(ani_fadeOut);
                            }
                        }, 1500);
                    }
                }
            }, 1000);
        }
    }

    /* DISPEL CARD EFFECT METHOD */
    private void cardDispel(){
        if (playerTurn){
            tvCenterMessage.setText(enemyDispelled);
            tvCenterMessage.startAnimation(ani_fadeIn);
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                    checkEnemyBuffs();
                }
            }, 1500);
        } else {
            tvCenterMessage.setText(playerDispelled);
            tvCenterMessage.startAnimation(ani_fadeIn);
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    tvCenterMessage.startAnimation(ani_fadeOut);
                    checkPlayerBuffs();
                }
            }, 1500);
        }
    }

    /* ----------------------------------------- */

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /* STORES CURRENT PLAYER DB LEVEL TO SHAREDPREF LEVEL */
    private void storeCurrentLevel() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("CurrentLevel", playerLevel);
        editor.apply();
    }

    /* FETCHES LEVEL INFO - CHANGE THIS FOR EVERY ACTIVITY */
    private void getLevelInfo(){
        try {
            db.open();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        cursor = db.getLvlInfo(4);
        if (cursor != null && cursor.moveToFirst()) {
            lvlcleared = cursor.getInt(cursor.getColumnIndex("lvlcleared"));
            lvlhighscore = cursor.getInt(cursor.getColumnIndex("lvlhighscore"));
            lvlId = cursor.getInt(cursor.getColumnIndex("_id"));
        }
        db.close();
    }

    /* -----------------------------------------
    * ADD STATUS METHODS
    *  -----------------------------------------*/

    /* ADD PLAYER SPEED UP */
    private void addPlayerSpeedUp(){
        int freeSpot = getFreePlayerStatusSpot();
        switch (freeSpot){
            case 0:
                playerStatuses[0] = "Speed Up";
                playerStatusIcon1.setImageResource(R.drawable.buff_speed_up);
                playerStatusIcon1.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon1.setVisibility(View.VISIBLE);
                break;
            case 1:
                playerStatuses[1] = "Speed Up";
                playerStatusIcon2.setImageResource(R.drawable.buff_speed_up);
                playerStatusIcon2.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon2.setVisibility(View.VISIBLE);
                break;
            case 2:
                playerStatuses[2] = "Speed Up";
                playerStatusIcon3.setImageResource(R.drawable.buff_speed_up);
                playerStatusIcon3.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon3.setVisibility(View.VISIBLE);
                break;
            case 3:
                playerStatuses[3] = "Speed Up";
                playerStatusIcon4.setImageResource(R.drawable.buff_speed_up);
                playerStatusIcon4.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon4.setVisibility(View.VISIBLE);
                break;
            case 4:
                playerStatuses[4] = "Speed Up";
                playerStatusIcon5.setImageResource(R.drawable.buff_speed_up);
                playerStatusIcon5.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon5.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* ADD PLAYER PROTECT */
    private void addPlayerProtect(){
        int freeSpot = getFreePlayerStatusSpot();
        switch (freeSpot){
            case 0:
                playerStatuses[0] = "Protect";
                playerStatusIcon1.setImageResource(R.drawable.buff_protect);
                playerStatusIcon1.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon1.setVisibility(View.VISIBLE);
                break;
            case 1:
                playerStatuses[1] = "Protect";
                playerStatusIcon2.setImageResource(R.drawable.buff_protect);
                playerStatusIcon2.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon2.setVisibility(View.VISIBLE);
                break;
            case 2:
                playerStatuses[2] = "Protect";
                playerStatusIcon3.setImageResource(R.drawable.buff_protect);
                playerStatusIcon3.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon3.setVisibility(View.VISIBLE);
                break;
            case 3:
                playerStatuses[3] = "Protect";
                playerStatusIcon4.setImageResource(R.drawable.buff_protect);
                playerStatusIcon4.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon4.setVisibility(View.VISIBLE);
                break;
            case 4:
                playerStatuses[4] = "Protect";
                playerStatusIcon5.setImageResource(R.drawable.buff_protect);
                playerStatusIcon5.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon5.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* ADD PLAYER REWIND */
    private void addPlayerRewind(){
        int freeSpot = getFreePlayerStatusSpot();
        switch (freeSpot){
            case 0:
                playerStatuses[0] = "Rewind";
                playerStatusIcon1.setImageResource(R.drawable.buff_rewind);
                playerStatusIcon1.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon1.setVisibility(View.VISIBLE);
                break;
            case 1:
                playerStatuses[1] = "Rewind";
                playerStatusIcon2.setImageResource(R.drawable.buff_rewind);
                playerStatusIcon2.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon2.setVisibility(View.VISIBLE);
                break;
            case 2:
                playerStatuses[2] = "Rewind";
                playerStatusIcon3.setImageResource(R.drawable.buff_rewind);
                playerStatusIcon3.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon3.setVisibility(View.VISIBLE);
                break;
            case 3:
                playerStatuses[3] = "Rewind";
                playerStatusIcon4.setImageResource(R.drawable.buff_rewind);
                playerStatusIcon4.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon4.setVisibility(View.VISIBLE);
                break;
            case 4:
                playerStatuses[4] = "Rewind";
                playerStatusIcon5.setImageResource(R.drawable.buff_rewind);
                playerStatusIcon5.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon5.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* ADD PLAYER HOARD */
    private void addPlayerHoard(){
        int freeSpot = getFreePlayerStatusSpot();
        switch (freeSpot){
            case 0:
                playerStatuses[0] = "Hoard";
                playerStatusIcon1.setImageResource(R.drawable.buff_hoard);
                playerStatusIcon1.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon1.setVisibility(View.VISIBLE);
                break;
            case 1:
                playerStatuses[1] = "Hoard";
                playerStatusIcon2.setImageResource(R.drawable.buff_hoard);
                playerStatusIcon2.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon2.setVisibility(View.VISIBLE);
                break;
            case 2:
                playerStatuses[2] = "Hoard";
                playerStatusIcon3.setImageResource(R.drawable.buff_hoard);
                playerStatusIcon3.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon3.setVisibility(View.VISIBLE);
                break;
            case 3:
                playerStatuses[3] = "Hoard";
                playerStatusIcon4.setImageResource(R.drawable.buff_hoard);
                playerStatusIcon4.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon4.setVisibility(View.VISIBLE);
                break;
            case 4:
                playerStatuses[4] = "Hoard";
                playerStatusIcon5.setImageResource(R.drawable.buff_hoard);
                playerStatusIcon5.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon5.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* ADD PLAYER CONCENTRATE */
    private void addPlayerConcentrate(){
        int freeSpot = getFreePlayerStatusSpot();
        switch (freeSpot){
            case 0:
                playerStatuses[0] = "Concentrate";
                playerStatusIcon1.setImageResource(R.drawable.buff_concentrate);
                playerStatusIcon1.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon1.setVisibility(View.VISIBLE);
                break;
            case 1:
                playerStatuses[1] = "Concentrate";
                playerStatusIcon2.setImageResource(R.drawable.buff_concentrate);
                playerStatusIcon2.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon2.setVisibility(View.VISIBLE);
                break;
            case 2:
                playerStatuses[2] = "Concentrate";
                playerStatusIcon3.setImageResource(R.drawable.buff_concentrate);
                playerStatusIcon3.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon3.setVisibility(View.VISIBLE);
                break;
            case 3:
                playerStatuses[3] = "Concentrate";
                playerStatusIcon4.setImageResource(R.drawable.buff_concentrate);
                playerStatusIcon4.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon4.setVisibility(View.VISIBLE);
                break;
            case 4:
                playerStatuses[4] = "Concentrate";
                playerStatusIcon5.setImageResource(R.drawable.buff_concentrate);
                playerStatusIcon5.setBackgroundResource(R.drawable.frame_black);
                playerStatusIcon5.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* ADD PLAYER SLOW */
    private void addPlayerSlow(){
        int freeSpot = getFreePlayerStatusSpot();
        switch (freeSpot){
            case 0:
                playerStatuses[0] = "Slow Down";
                playerStatusIcon1.setImageResource(R.drawable.debuff_slow);
                playerStatusIcon1.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon1.setVisibility(View.VISIBLE);
                break;
            case 1:
                playerStatuses[1] = "Slow Down";
                playerStatusIcon2.setImageResource(R.drawable.debuff_slow);
                playerStatusIcon2.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon2.setVisibility(View.VISIBLE);
                break;
            case 2:
                playerStatuses[2] = "Slow Down";
                playerStatusIcon3.setImageResource(R.drawable.debuff_slow);
                playerStatusIcon3.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon3.setVisibility(View.VISIBLE);
                break;
            case 3:
                playerStatuses[3] = "Slow Down";
                playerStatusIcon4.setImageResource(R.drawable.debuff_slow);
                playerStatusIcon4.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon4.setVisibility(View.VISIBLE);
                break;
            case 4:
                playerStatuses[4] = "Slow Down";
                playerStatusIcon5.setImageResource(R.drawable.debuff_slow);
                playerStatusIcon5.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon5.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* ADD PLAYER CORRUPTION */
    private void addPlayerCorruption(){
        int freeSpot = getFreePlayerStatusSpot();
        switch (freeSpot){
            case 0:
                playerStatuses[0] = "Corruption";
                playerStatusIcon1.setImageResource(R.drawable.debuff_corruption);
                playerStatusIcon1.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon1.setVisibility(View.VISIBLE);
                break;
            case 1:
                playerStatuses[1] = "Corruption";
                playerStatusIcon2.setImageResource(R.drawable.debuff_corruption);
                playerStatusIcon2.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon2.setVisibility(View.VISIBLE);
                break;
            case 2:
                playerStatuses[2] = "Corruption";
                playerStatusIcon3.setImageResource(R.drawable.debuff_corruption);
                playerStatusIcon3.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon3.setVisibility(View.VISIBLE);
                break;
            case 3:
                playerStatuses[3] = "Corruption";
                playerStatusIcon4.setImageResource(R.drawable.debuff_corruption);
                playerStatusIcon4.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon4.setVisibility(View.VISIBLE);
                break;
            case 4:
                playerStatuses[4] = "Corruption";
                playerStatusIcon5.setImageResource(R.drawable.debuff_corruption);
                playerStatusIcon5.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon5.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* ADD PLAYER CURSE */
    private void addPlayerCurse(){
        int freeSpot = getFreePlayerStatusSpot();
        switch (freeSpot){
            case 0:
                playerStatuses[0] = "Curse";
                playerStatusIcon1.setImageResource(R.drawable.debuff_curse);
                playerStatusIcon1.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon1.setVisibility(View.VISIBLE);
                break;
            case 1:
                playerStatuses[1] = "Curse";
                playerStatusIcon2.setImageResource(R.drawable.debuff_curse);
                playerStatusIcon2.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon2.setVisibility(View.VISIBLE);
                break;
            case 2:
                playerStatuses[2] = "Curse";
                playerStatusIcon3.setImageResource(R.drawable.debuff_curse);
                playerStatusIcon3.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon3.setVisibility(View.VISIBLE);
                break;
            case 3:
                playerStatuses[3] = "Curse";
                playerStatusIcon4.setImageResource(R.drawable.debuff_curse);
                playerStatusIcon4.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon4.setVisibility(View.VISIBLE);
                break;
            case 4:
                playerStatuses[4] = "Curse";
                playerStatusIcon5.setImageResource(R.drawable.debuff_curse);
                playerStatusIcon5.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon5.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* ADD PLAYER AGONY */
    private void addPlayerAgony(){
        int freeSpot = getFreePlayerStatusSpot();
        switch (freeSpot){
            case 0:
                playerStatuses[0] = "Agony";
                playerStatusIcon1.setImageResource(R.drawable.debuff_agony);
                playerStatusIcon1.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon1.setVisibility(View.VISIBLE);
                break;
            case 1:
                playerStatuses[1] = "Agony";
                playerStatusIcon2.setImageResource(R.drawable.debuff_agony);
                playerStatusIcon2.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon2.setVisibility(View.VISIBLE);
                break;
            case 2:
                playerStatuses[2] = "Agony";
                playerStatusIcon3.setImageResource(R.drawable.debuff_agony);
                playerStatusIcon3.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon3.setVisibility(View.VISIBLE);
                break;
            case 3:
                playerStatuses[3] = "Agony";
                playerStatusIcon4.setImageResource(R.drawable.debuff_agony);
                playerStatusIcon4.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon4.setVisibility(View.VISIBLE);
                break;
            case 4:
                playerStatuses[4] = "Agony";
                playerStatusIcon5.setImageResource(R.drawable.debuff_agony);
                playerStatusIcon5.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon5.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* ADD PLAYER MALEDICTION */
    private void addPlayerMalediction(){
        int freeSpot = getFreePlayerStatusSpot();
        switch (freeSpot){
            case 0:
                playerStatuses[0] = "Malediction";
                playerStatusIcon1.setImageResource(R.drawable.debuff_malediction);
                playerStatusIcon1.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon1.setVisibility(View.VISIBLE);
                break;
            case 1:
                playerStatuses[1] = "Malediction";
                playerStatusIcon2.setImageResource(R.drawable.debuff_malediction);
                playerStatusIcon2.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon2.setVisibility(View.VISIBLE);
                break;
            case 2:
                playerStatuses[2] = "Malediction";
                playerStatusIcon3.setImageResource(R.drawable.debuff_malediction);
                playerStatusIcon3.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon3.setVisibility(View.VISIBLE);
                break;
            case 3:
                playerStatuses[3] = "Malediction";
                playerStatusIcon4.setImageResource(R.drawable.debuff_malediction);
                playerStatusIcon4.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon4.setVisibility(View.VISIBLE);
                break;
            case 4:
                playerStatuses[4] = "Malediction";
                playerStatusIcon5.setImageResource(R.drawable.debuff_malediction);
                playerStatusIcon5.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon5.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* ADD PLAYER DEATH SENTENCE */
    private void addPlayerDeathSentence(){
        int freeSpot = getFreePlayerStatusSpot();
        switch (freeSpot){
            case 0:
                playerStatuses[0] = "Death Sentence";
                playerStatusIcon1.setImageResource(R.drawable.debuff_death_sentence);
                playerStatusIcon1.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon1.setVisibility(View.VISIBLE);
                break;
            case 1:
                playerStatuses[1] = "Death Sentence";
                playerStatusIcon2.setImageResource(R.drawable.debuff_death_sentence);
                playerStatusIcon2.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon2.setVisibility(View.VISIBLE);
                break;
            case 2:
                playerStatuses[2] = "Death Sentence";
                playerStatusIcon3.setImageResource(R.drawable.debuff_death_sentence);
                playerStatusIcon3.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon3.setVisibility(View.VISIBLE);
                break;
            case 3:
                playerStatuses[3] = "Death Sentence";
                playerStatusIcon4.setImageResource(R.drawable.debuff_death_sentence);
                playerStatusIcon4.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon4.setVisibility(View.VISIBLE);
                break;
            case 4:
                playerStatuses[4] = "Death Sentence";
                playerStatusIcon5.setImageResource(R.drawable.debuff_death_sentence);
                playerStatusIcon5.setBackgroundResource(R.drawable.frame_white);
                playerStatusIcon5.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* ADD ENEMY SLOW */
    private void addEnemySlow(){
        int freeSpot = getFreeEnemyStatusSpot();
        switch (freeSpot){
            case 0:
                enemyStatuses[0] = "Slow Down";
                enemyStatusIcon1.setImageResource(R.drawable.debuff_slow);
                enemyStatusIcon1.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon1.setVisibility(View.VISIBLE);
                break;
            case 1:
                enemyStatuses[1] = "Slow Down";
                enemyStatusIcon2.setImageResource(R.drawable.debuff_slow);
                enemyStatusIcon2.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon2.setVisibility(View.VISIBLE);
                break;
            case 2:
                enemyStatuses[2] = "Slow Down";
                enemyStatusIcon3.setImageResource(R.drawable.debuff_slow);
                enemyStatusIcon3.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon3.setVisibility(View.VISIBLE);
                break;
            case 3:
                enemyStatuses[3] = "Slow Down";
                enemyStatusIcon4.setImageResource(R.drawable.debuff_slow);
                enemyStatusIcon4.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon4.setVisibility(View.VISIBLE);
                break;
            case 4:
                enemyStatuses[4] = "Slow Down";
                enemyStatusIcon5.setImageResource(R.drawable.debuff_slow);
                enemyStatusIcon5.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon5.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* ADD ENEMY SPEED UP */
    private void addEnemySpeedUp(){
        int freeSpot = getFreeEnemyStatusSpot();
        switch (freeSpot){
            case 0:
                enemyStatuses[0] = "Speed Up";
                enemyStatusIcon1.setImageResource(R.drawable.buff_speed_up);
                enemyStatusIcon1.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon1.setVisibility(View.VISIBLE);
                break;
            case 1:
                enemyStatuses[1] = "Speed Up";
                enemyStatusIcon2.setImageResource(R.drawable.buff_speed_up);
                enemyStatusIcon2.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon2.setVisibility(View.VISIBLE);
                break;
            case 2:
                enemyStatuses[2] = "Speed Up";
                enemyStatusIcon3.setImageResource(R.drawable.buff_speed_up);
                enemyStatusIcon3.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon3.setVisibility(View.VISIBLE);
                break;
            case 3:
                enemyStatuses[3] = "Speed Up";
                enemyStatusIcon4.setImageResource(R.drawable.buff_speed_up);
                enemyStatusIcon4.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon4.setVisibility(View.VISIBLE);
                break;
            case 4:
                enemyStatuses[4] = "Speed Up";
                enemyStatusIcon5.setImageResource(R.drawable.buff_speed_up);
                enemyStatusIcon5.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon5.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* ADD ENEMY REWIND*/
    private void addEnemyRewind(){
        int freeSpot = getFreeEnemyStatusSpot();
        switch (freeSpot){
            case 0:
                enemyStatuses[0] = "Rewind";
                enemyStatusIcon1.setImageResource(R.drawable.buff_rewind);
                enemyStatusIcon1.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon1.setVisibility(View.VISIBLE);
                break;
            case 1:
                enemyStatuses[1] = "Rewind";
                enemyStatusIcon2.setImageResource(R.drawable.buff_rewind);
                enemyStatusIcon2.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon2.setVisibility(View.VISIBLE);
                break;
            case 2:
                enemyStatuses[2] = "Rewind";
                enemyStatusIcon3.setImageResource(R.drawable.buff_rewind);
                enemyStatusIcon3.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon3.setVisibility(View.VISIBLE);
                break;
            case 3:
                enemyStatuses[3] = "Rewind";
                enemyStatusIcon4.setImageResource(R.drawable.buff_rewind);
                enemyStatusIcon4.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon4.setVisibility(View.VISIBLE);
                break;
            case 4:
                enemyStatuses[4] = "Rewind";
                enemyStatusIcon5.setImageResource(R.drawable.buff_rewind);
                enemyStatusIcon5.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon5.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* ADD ENEMY HOARD*/
    private void addEnemyHoard(){
        int freeSpot = getFreeEnemyStatusSpot();
        switch (freeSpot){
            case 0:
                enemyStatuses[0] = "Hoard";
                enemyStatusIcon1.setImageResource(R.drawable.buff_hoard);
                enemyStatusIcon1.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon1.setVisibility(View.VISIBLE);
                break;
            case 1:
                enemyStatuses[1] = "Hoard";
                enemyStatusIcon2.setImageResource(R.drawable.buff_hoard);
                enemyStatusIcon2.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon2.setVisibility(View.VISIBLE);
                break;
            case 2:
                enemyStatuses[2] = "Hoard";
                enemyStatusIcon3.setImageResource(R.drawable.buff_hoard);
                enemyStatusIcon3.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon3.setVisibility(View.VISIBLE);
                break;
            case 3:
                enemyStatuses[3] = "Hoard";
                enemyStatusIcon4.setImageResource(R.drawable.buff_hoard);
                enemyStatusIcon4.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon4.setVisibility(View.VISIBLE);
                break;
            case 4:
                enemyStatuses[4] = "Hoard";
                enemyStatusIcon5.setImageResource(R.drawable.buff_hoard);
                enemyStatusIcon5.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon5.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* ADD ENEMY PROTECT */
    private void addEnemyProtect(){
        int freeSpot = getFreeEnemyStatusSpot();
        switch (freeSpot){
            case 0:
                enemyStatuses[0] = "Protect";
                enemyStatusIcon1.setImageResource(R.drawable.buff_protect);
                enemyStatusIcon1.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon1.setVisibility(View.VISIBLE);
                break;
            case 1:
                enemyStatuses[1] = "Protect";
                enemyStatusIcon2.setImageResource(R.drawable.buff_protect);
                enemyStatusIcon2.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon2.setVisibility(View.VISIBLE);
                break;
            case 2:
                enemyStatuses[2] = "Protect";
                enemyStatusIcon3.setImageResource(R.drawable.buff_protect);
                enemyStatusIcon3.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon3.setVisibility(View.VISIBLE);
                break;
            case 3:
                enemyStatuses[3] = "Protect";
                enemyStatusIcon4.setImageResource(R.drawable.buff_protect);
                enemyStatusIcon4.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon4.setVisibility(View.VISIBLE);
                break;
            case 4:
                enemyStatuses[4] = "Protect";
                enemyStatusIcon5.setImageResource(R.drawable.buff_protect);
                enemyStatusIcon5.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon5.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* ADD ENEMY CONCENTRATE */
    private void addEnemyConcentrate(){
        int freeSpot = getFreeEnemyStatusSpot();
        switch (freeSpot){
            case 0:
                enemyStatuses[0] = "Concentrate";
                enemyStatusIcon1.setImageResource(R.drawable.buff_concentrate);
                enemyStatusIcon1.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon1.setVisibility(View.VISIBLE);
                break;
            case 1:
                enemyStatuses[1] = "Concentrate";
                enemyStatusIcon2.setImageResource(R.drawable.buff_concentrate);
                enemyStatusIcon2.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon2.setVisibility(View.VISIBLE);
                break;
            case 2:
                enemyStatuses[2] = "Concentrate";
                enemyStatusIcon3.setImageResource(R.drawable.buff_concentrate);
                enemyStatusIcon3.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon3.setVisibility(View.VISIBLE);
                break;
            case 3:
                enemyStatuses[3] = "Concentrate";
                enemyStatusIcon4.setImageResource(R.drawable.buff_concentrate);
                enemyStatusIcon4.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon4.setVisibility(View.VISIBLE);
                break;
            case 4:
                enemyStatuses[4] = "Concentrate";
                enemyStatusIcon5.setImageResource(R.drawable.buff_concentrate);
                enemyStatusIcon5.setBackgroundResource(R.drawable.frame_black);
                enemyStatusIcon5.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* ADD ENEMY CORRUPTION */
    private void addEnemyCorruption(){
        int freeSpot = getFreeEnemyStatusSpot();
        switch (freeSpot) {
            case 0:
                enemyStatuses[0] = "Corruption";
                enemyStatusIcon1.setImageResource(R.drawable.debuff_corruption);
                enemyStatusIcon1.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon1.setVisibility(View.VISIBLE);
                break;
            case 1:
                enemyStatuses[1] = "Corruption";
                enemyStatusIcon2.setImageResource(R.drawable.debuff_corruption);
                enemyStatusIcon2.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon2.setVisibility(View.VISIBLE);
                break;
            case 2:
                enemyStatuses[2] = "Corruption";
                enemyStatusIcon3.setImageResource(R.drawable.debuff_corruption);
                enemyStatusIcon3.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon3.setVisibility(View.VISIBLE);
                break;
            case 3:
                enemyStatuses[3] = "Corruption";
                enemyStatusIcon4.setImageResource(R.drawable.debuff_corruption);
                enemyStatusIcon4.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon4.setVisibility(View.VISIBLE);
                break;
            case 4:
                enemyStatuses[4] = "Corruption";
                enemyStatusIcon5.setImageResource(R.drawable.debuff_corruption);
                enemyStatusIcon5.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon5.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* ADD ENEMY CURSE */
    private void addEnemyCurse(){
        int freeSpot = getFreeEnemyStatusSpot();
        switch (freeSpot) {
            case 0:
                enemyStatuses[0] = "Curse";
                enemyStatusIcon1.setImageResource(R.drawable.debuff_curse);
                enemyStatusIcon1.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon1.setVisibility(View.VISIBLE);
                break;
            case 1:
                enemyStatuses[1] = "Curse";
                enemyStatusIcon2.setImageResource(R.drawable.debuff_curse);
                enemyStatusIcon2.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon2.setVisibility(View.VISIBLE);
                break;
            case 2:
                enemyStatuses[2] = "Curse";
                enemyStatusIcon3.setImageResource(R.drawable.debuff_curse);
                enemyStatusIcon3.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon3.setVisibility(View.VISIBLE);
                break;
            case 3:
                enemyStatuses[3] = "Curse";
                enemyStatusIcon4.setImageResource(R.drawable.debuff_curse);
                enemyStatusIcon4.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon4.setVisibility(View.VISIBLE);
                break;
            case 4:
                enemyStatuses[4] = "Curse";
                enemyStatusIcon5.setImageResource(R.drawable.debuff_curse);
                enemyStatusIcon5.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon5.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* ADD ENEMY AGONY */
    private void addEnemyAgony(){
        int freeSpot = getFreeEnemyStatusSpot();
        switch (freeSpot) {
            case 0:
                enemyStatuses[0] = "Agony";
                enemyStatusIcon1.setImageResource(R.drawable.debuff_agony);
                enemyStatusIcon1.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon1.setVisibility(View.VISIBLE);
                break;
            case 1:
                enemyStatuses[1] = "Agony";
                enemyStatusIcon2.setImageResource(R.drawable.debuff_agony);
                enemyStatusIcon2.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon2.setVisibility(View.VISIBLE);
                break;
            case 2:
                enemyStatuses[2] = "Agony";
                enemyStatusIcon3.setImageResource(R.drawable.debuff_agony);
                enemyStatusIcon3.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon3.setVisibility(View.VISIBLE);
                break;
            case 3:
                enemyStatuses[3] = "Agony";
                enemyStatusIcon4.setImageResource(R.drawable.debuff_agony);
                enemyStatusIcon4.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon4.setVisibility(View.VISIBLE);
                break;
            case 4:
                enemyStatuses[4] = "Agony";
                enemyStatusIcon5.setImageResource(R.drawable.debuff_agony);
                enemyStatusIcon5.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon5.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* ADD ENEMY MALEDICTION */
    private void addEnemyMalediction(){
        int freeSpot = getFreeEnemyStatusSpot();
        switch (freeSpot) {
            case 0:
                enemyStatuses[0] = "Malediction";
                enemyStatusIcon1.setImageResource(R.drawable.debuff_malediction);
                enemyStatusIcon1.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon1.setVisibility(View.VISIBLE);
                break;
            case 1:
                enemyStatuses[1] = "Malediction";
                enemyStatusIcon2.setImageResource(R.drawable.debuff_malediction);
                enemyStatusIcon2.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon2.setVisibility(View.VISIBLE);
                break;
            case 2:
                enemyStatuses[2] = "Malediction";
                enemyStatusIcon3.setImageResource(R.drawable.debuff_malediction);
                enemyStatusIcon3.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon3.setVisibility(View.VISIBLE);
                break;
            case 3:
                enemyStatuses[3] = "Malediction";
                enemyStatusIcon4.setImageResource(R.drawable.debuff_malediction);
                enemyStatusIcon4.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon4.setVisibility(View.VISIBLE);
                break;
            case 4:
                enemyStatuses[4] = "Malediction";
                enemyStatusIcon5.setImageResource(R.drawable.debuff_malediction);
                enemyStatusIcon5.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon5.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* ADD ENEMY DEATH SENTENCE */
    private void addEnemyDeathSentence(){
        int freeSpot = getFreeEnemyStatusSpot();
        switch (freeSpot) {
            case 0:
                enemyStatuses[0] = "Death Sentence";
                enemyStatusIcon1.setImageResource(R.drawable.debuff_death_sentence);
                enemyStatusIcon1.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon1.setVisibility(View.VISIBLE);
                break;
            case 1:
                enemyStatuses[1] = "Death Sentence";
                enemyStatusIcon2.setImageResource(R.drawable.debuff_death_sentence);
                enemyStatusIcon2.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon2.setVisibility(View.VISIBLE);
                break;
            case 2:
                enemyStatuses[2] = "Death Sentence";
                enemyStatusIcon3.setImageResource(R.drawable.debuff_death_sentence);
                enemyStatusIcon3.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon3.setVisibility(View.VISIBLE);
                break;
            case 3:
                enemyStatuses[3] = "Death Sentence";
                enemyStatusIcon4.setImageResource(R.drawable.debuff_death_sentence);
                enemyStatusIcon4.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon4.setVisibility(View.VISIBLE);
                break;
            case 4:
                enemyStatuses[4] = "Death Sentence";
                enemyStatusIcon5.setImageResource(R.drawable.debuff_death_sentence);
                enemyStatusIcon5.setBackgroundResource(R.drawable.frame_white);
                enemyStatusIcon5.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* -----------------------------------------
    *  SHORT STATUS EFFECTS
    *  -----------------------------------------*/

    /* CHECK ENEMY STATUSES */
    private void checkEnemyStatuses(){
        if (!enemyIsSlowed){
            clearEnemyStatus("Slow Down");
        }
        if (!enemyHasHaste && !enemyHasHaste2){
            clearEnemyStatus("Speed Up");
        }
        if (!enemyHasConcentrate){
            clearEnemyStatus("Concentrate");
        }
        if (!enemyIsCorrupted){
            clearEnemyStatus("Corruption");
        }
    }

    /* CHECK PLAYER STATUSES */
    private void checkPlayerStatues(){
        if (!playerHasHaste && !playerHasHaste2){
            clearPlayerStatus("Speed Up");
        }
        if (!playerIsSlowed){
            clearPlayerStatus("Slow Down");
        }
        if (!playerHasConcentrate){
            clearPlayerStatus("Concentrate");
        }
        if (!playerIsCorrupted){
            clearPlayerStatus("Corruption");
        }
    }

    /* -----------------------------------------
    *  LONGER PLAYER STATUS EFFECTS
    *  -----------------------------------------*/

    private void playerCursedEffect(){
        playerIsCursed = false;
        playerCurseCountdown = -1;
        final int halfPlayerScore = playerScore / 2;
        ivCenterCardFrame.startAnimation(ani_zoomIn);
        ivCenterCardFrame.setImageResource(R.drawable.card_curse);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                ivCenterCardFrame.clearAnimation();
                ivCenterCardFrame.setVisibility(View.INVISIBLE);
            }
        }, 2000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                tvPlayerScore.startAnimation(ani_shake);
                tvPlayerScore.setText("-" + String.valueOf(halfPlayerScore));
                tvPlayerScore.setTextColor(getResources().getColor(R.color.textBrightRed));
            }
        }, 3000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                playerScore = playerScore - halfPlayerScore;
                tvPlayerScore.setText(String.valueOf(playerScore));
                tvPlayerScore.setTextColor(getResources().getColor(R.color.textBlack));
                tvPlayerScore.startAnimation(ani_resetscore);
                tvEnemyScore.clearAnimation();
            }
        }, 4000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                clearPlayerStatus("Curse");
            }
        }, 6000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                checkIfPlayerAgonyEnds();
            }
        }, 7000);
    }

    private void playerAgonizedEnd(){
        playerIsAgonized = false;
        playerAgonyCountdown = -1;
        myHandler.postDelayed(new Runnable() {
            public void run() {
                tvCenterMessage.startAnimation(ani_fadeIn);
                tvCenterMessage.setText(playerName + " is no longer agonized");
            }
        }, 1000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                tvCenterMessage.startAnimation(ani_fadeOut);
                clearPlayerStatus("Agony");
            }
        }, 2000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                checkIfPlayerMaledictionEnds();
            }
        }, 3000);
    }

    private void playerMaledictedEffect(){
        playerIsMaledicted = false;
        playerMaledictionCountdown = -1;
        int halfPlayerScore = playerScore / 2;
        int quarter = halfPlayerScore / 2;
        final int withdraw = playerScore - quarter;
        ivCenterCardFrame.startAnimation(ani_zoomIn);
        ivCenterCardFrame.setImageResource(R.drawable.card_malediction);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                ivCenterCardFrame.clearAnimation();
                ivCenterCardFrame.setVisibility(View.INVISIBLE);
            }
        }, 2000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                tvPlayerScore.startAnimation(ani_shake);
                tvPlayerScore.setText("-" + String.valueOf(withdraw));
                tvPlayerScore.setTextColor(getResources().getColor(R.color.textBrightRed));
            }
        }, 3000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                playerScore = playerScore - withdraw;
                tvPlayerScore.setText(String.valueOf(playerScore));
                tvPlayerScore.setTextColor(getResources().getColor(R.color.textBlack));
                tvPlayerScore.startAnimation(ani_resetscore);
                tvEnemyScore.clearAnimation();
            }
        }, 4000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                clearPlayerStatus("Malediction");
            }
        }, 6000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                checkIfPlayerSentenceEnds();
            }
        }, 7000);
    }

    private void playerSentencedEffect(){
        int withdraw;
        playerIsSentenced = false;
        playerSentenceCountdown = -1;
        int resetOrNot = genRand(100);
        if (resetOrNot >= 50){
            withdraw = playerScore;
            playerScore = 0;
        } else {
            withdraw = 0;
        }
        final int number = withdraw;

        ivCenterCardFrame.startAnimation(ani_zoomIn);
        ivCenterCardFrame.setImageResource(R.drawable.card_death_sentence);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                ivCenterCardFrame.clearAnimation();
                ivCenterCardFrame.setVisibility(View.INVISIBLE);
            }
        }, 2000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                tvPlayerScore.startAnimation(ani_shake);
                tvPlayerScore.setText("-" + String.valueOf(number));
                tvPlayerScore.setTextColor(getResources().getColor(R.color.textBrightRed));
            }
        }, 3000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                tvPlayerScore.setText(String.valueOf(playerScore));
                tvPlayerScore.setTextColor(getResources().getColor(R.color.textBlack));
                tvPlayerScore.startAnimation(ani_resetscore);
                tvEnemyScore.clearAnimation();
            }
        }, 4000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                clearPlayerStatus("Death Sentence");
            }
        }, 6000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                checkIfPlayerProtectEnds();
            }
        }, 7000);
    }

    private void playerProtectEnd(){
        playerHasProtect = false;
        playerProtectCountdown = -1;
        myHandler.postDelayed(new Runnable() {
            public void run() {
                tvCenterMessage.startAnimation(ani_fadeIn);
                tvCenterMessage.setText(playerName + " is no longer protected");
            }
        }, 1000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                tvCenterMessage.startAnimation(ani_fadeOut);
                clearPlayerStatus("Protect");
            }
        }, 2000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                playerTurn();
            }
        }, 3000);
    }


    /* -----------------------------------------
    *  LONGER ENEMY STATUS EFFECTS
    *  -----------------------------------------*/

    private void enemyCursedEffect(){
        enemyIsCursed = false;
        enemyCurseCountdown = -1;
        final int halfEnemyScore = enemyScore / 2;
        ivCenterCardFrame.startAnimation(ani_zoomIn);
        ivCenterCardFrame.setImageResource(R.drawable.card_curse);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                ivCenterCardFrame.clearAnimation();
                ivCenterCardFrame.setVisibility(View.INVISIBLE);
            }
        }, 2000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                tvEnemyScore.startAnimation(ani_shake);
                tvEnemyScore.setText("-" + String.valueOf(halfEnemyScore));
                tvEnemyScore.setTextColor(getResources().getColor(R.color.textBrightRed));
            }
        }, 3000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                enemyScore = enemyScore - halfEnemyScore;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                tvEnemyScore.setTextColor(getResources().getColor(R.color.textBlack));
                tvEnemyScore.startAnimation(ani_resetscore);
                tvPlayerScore.clearAnimation();
            }
        }, 4000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                clearEnemyStatus("Curse");
            }
        }, 6000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                checkIfEnemyAgonyEnds();
            }
        }, 7000);
    }

    private void enemyAgonizedEnd(){
        enemyIsAgonized = false;
        enemyAgonyCountdown = -1;
        myHandler.postDelayed(new Runnable() {
            public void run() {
                tvCenterMessage.startAnimation(ani_fadeIn);
                tvCenterMessage.setText("Enemy is no longer agonized");
            }
        }, 1000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                tvCenterMessage.startAnimation(ani_fadeOut);
                clearEnemyStatus("Agony");
            }
        }, 2000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                checkIfEnemyMaledictionEnds();
            }
        }, 3000);
    }

    private void enemyMaledictedEffect(){
        enemyIsMaledicted = false;
        enemyMaledictionCountdown = -1;
        int halfEnemyScore = enemyScore / 2;
        int quarter = halfEnemyScore / 2;
        final int withdraw = enemyScore - quarter;
        ivCenterCardFrame.startAnimation(ani_zoomIn);
        ivCenterCardFrame.setImageResource(R.drawable.card_malediction);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                ivCenterCardFrame.clearAnimation();
                ivCenterCardFrame.setVisibility(View.INVISIBLE);
            }
        }, 2000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                tvEnemyScore.startAnimation(ani_shake);
                tvEnemyScore.setText("-" + String.valueOf(withdraw));
                tvEnemyScore.setTextColor(getResources().getColor(R.color.textBrightRed));
            }
        }, 3000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                enemyScore = enemyScore - withdraw;
                tvEnemyScore.setText(String.valueOf(enemyScore));
                tvEnemyScore.setTextColor(getResources().getColor(R.color.textBlack));
                tvEnemyScore.startAnimation(ani_resetscore);
                tvPlayerScore.clearAnimation();
            }
        }, 4000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                clearEnemyStatus("Malediction");
            }
        }, 6000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                checkIfEnemySentenceEnds();
            }
        }, 7000);
    }

    private void enemySentencedEffect(){
        int withdraw;
        enemyIsSentenced = false;
        enemySentenceCountdown = -1;
        int resetOrNot = genRand(100);
        if (resetOrNot >= 50){
            withdraw = enemyScore;
            enemyScore = 0;
        } else {
            withdraw = 0;
        }
        final int number = withdraw;

        ivCenterCardFrame.startAnimation(ani_zoomIn);
        ivCenterCardFrame.setImageResource(R.drawable.card_death_sentence);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                ivCenterCardFrame.clearAnimation();
                ivCenterCardFrame.setVisibility(View.INVISIBLE);
            }
        }, 2000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                tvEnemyScore.startAnimation(ani_shake);
                tvEnemyScore.setText("-" + String.valueOf(number));
                tvEnemyScore.setTextColor(getResources().getColor(R.color.textBrightRed));
            }
        }, 3000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                tvEnemyScore.setText(String.valueOf(enemyScore));
                tvEnemyScore.setTextColor(getResources().getColor(R.color.textBlack));
                tvEnemyScore.startAnimation(ani_resetscore);
                tvPlayerScore.clearAnimation();
            }
        }, 4000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                clearEnemyStatus("Death Sentence");
            }
        }, 6000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                checkIfEnemyProtectEnds();
            }
        }, 7000);
    }

    private void enemyProtectEnd(){
        enemyHasProtect = false;
        enemyProtectCountdown = -1;
        myHandler.postDelayed(new Runnable() {
            public void run() {
                tvCenterMessage.startAnimation(ani_fadeIn);
                tvCenterMessage.setText("Enemy is no longer protected");
            }
        }, 1000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                tvCenterMessage.startAnimation(ani_fadeOut);
                clearEnemyStatus("Protect");
            }
        }, 2000);
        myHandler.postDelayed(new Runnable() {
            public void run() {
                enemyTurn();
            }
        }, 3000);
    }


    /* -----------------------------------------
    * CLEAR STATUS METHODS
    *  -----------------------------------------*/

    private void clearEnemyStatus(String debuffName){
        if (enemyStatuses[0].equals(debuffName)){
            enemyStatuses[0] = "";
            enemyStatusIcon1.setVisibility(View.INVISIBLE);
            activeEnemyStatuses--;
        }
        if (enemyStatuses[1].equals(debuffName)){
            enemyStatuses[1] = "";
            enemyStatusIcon2.setVisibility(View.INVISIBLE);
            activeEnemyStatuses--;
        }
        if (enemyStatuses[2].equals(debuffName)){
            enemyStatuses[2] = "";
            enemyStatusIcon3.setVisibility(View.INVISIBLE);
            activeEnemyStatuses--;
        }
        if (enemyStatuses[3].equals(debuffName)){
            enemyStatuses[3] = "";
            enemyStatusIcon4.setVisibility(View.INVISIBLE);
            activeEnemyStatuses--;
        }
        if (enemyStatuses[4].equals(debuffName)){
            enemyStatuses[4] = "";
            enemyStatusIcon5.setVisibility(View.INVISIBLE);
            activeEnemyStatuses--;
        }
        if (debuffName.equals("Concentrate")){
            enemyClearAward = 2;
        }
        if (debuffName.equals("Corruption")){
            enemyCorruptedPenalty = 0;
        }
    }

    private void clearPlayerStatus(String debuffName){
        if (playerStatuses[0].equals(debuffName)){
            playerStatuses[0] = "";
            playerStatusIcon1.setVisibility(View.INVISIBLE);
            activePlayerStatuses--;
        }
        if (playerStatuses[1].equals(debuffName)){
            playerStatuses[1] = "";
            playerStatusIcon2.setVisibility(View.INVISIBLE);
            activePlayerStatuses--;
        }
        if (playerStatuses[2].equals(debuffName)){
            playerStatuses[2] = "";
            playerStatusIcon3.setVisibility(View.INVISIBLE);
            activePlayerStatuses--;
        }
        if (playerStatuses[3].equals(debuffName)){
            playerStatuses[3] = "";
            playerStatusIcon4.setVisibility(View.INVISIBLE);
            activePlayerStatuses--;
        }
        if (playerStatuses[4].equals(debuffName)){
            playerStatuses[4] = "";
            playerStatusIcon5.setVisibility(View.INVISIBLE);
            activePlayerStatuses--;
        }
        if (debuffName.equals("Concentrate")){
            playerClearAward = 2;
        }
        if (debuffName.equals("Corruption")){
            playerCorruptedPenalty = 0;
        }
    }

    /* ----------------------------------------- */

    /* CHECK FOR EMPTY PLAYER STATUS SPOT */
    private int getFreePlayerStatusSpot(){
        int number;
        if (playerStatuses[0].equals("")){
            number = 0;
            return number;
        }
        if (playerStatuses[1].equals("")){
            number = 1;
            return number;
        }
        if (playerStatuses[2].equals("")){
            number = 2;
            return number;
        }
        if (playerStatuses[3].equals("")){
            number = 3;
            return number;
        }
        if (playerStatuses[4].equals("")){
            number = 4;
            return number;
        }
        //IF AILMENT ISNT FOUND, IT RETURNS NEGATIVE NUMBER
        return -1;
    }

    /* CHECK FOR EMPTY ENEMY STATUS */
    private int getFreeEnemyStatusSpot(){
        int number;
        if (enemyStatuses[0].equals("")){
            number = 0;
            return number;
        }
        if (enemyStatuses[1].equals("")){
            number = 1;
            return number;
        }
        if (enemyStatuses[2].equals("")){
            number = 2;
            return number;
        }
        if (enemyStatuses[3].equals("")){
            number = 3;
            return number;
        }
        if (enemyStatuses[4].equals("")){
            number = 4;
            return number;
        }
        return 0;
    }

    /* ----------------------------------------- */

    /* FIND PLAYER AILMENTS */
    private int findPlayerAilment(String debuffName){
        int number;
        if (playerStatuses[0].equals(debuffName)){
            number = 0;
            return number;
        }
        if (playerStatuses[1].equals(debuffName)){
            number = 1;
            return number;
        }
        if (playerStatuses[2].equals(debuffName)){
            number = 2;
            return number;
        }
        if (playerStatuses[3].equals(debuffName)){
            number = 3;
            return number;
        }
        if (playerStatuses[4].equals(debuffName)){
            number = 4;
            return number;
        }
        return 0;
    }

    /* CHECK PLAYER FOR AILMENTS */
    private void checkPlayerAilments(){
        int check = findPlayerAilment("Slow Down");
        if (check != -1){
            playerIsSlowed = false;
            clearPlayerStatus("Slow Down");
        }
        check = findPlayerAilment("Corruption");
        if (check != -1){
            playerIsCorrupted = false;
            clearPlayerStatus("Corruption");
        }
        check = findPlayerAilment("Curse");
        if (check != -1){
            playerIsCursed = false;
            playerCurseCountdown = -1;
            clearPlayerStatus("Curse");
        }
        check = findPlayerAilment("Agony");
        if (check != -1){
            playerIsAgonized = false;
            playerAgonyCountdown = -1;
            clearPlayerStatus("Agony");
        }
        check = findPlayerAilment("Malediction");
        if (check != -1){
            playerIsMaledicted = false;
            playerMaledictionCountdown = -1;
            clearPlayerStatus("Malediction");
        }
        check = findPlayerAilment("Death Sentence");
        if (check != -1){
            playerIsSentenced = false;
            playerSentenceCountdown = -1;
            clearPlayerStatus("Death Sentence");
        }
    }

    /* FIND ENEMY AILMENTS */
    private int findEnemyAilments(String debuffName){
        int number;
        if (enemyStatuses[0].equals(debuffName)){
            number = 0;
            return number;
        }
        if (enemyStatuses[1].equals(debuffName)){
            number = 1;
            return number;
        }
        if (enemyStatuses[2].equals(debuffName)){
            number = 2;
            return number;
        }
        if (enemyStatuses[3].equals(debuffName)){
            number = 3;
            return number;
        }
        if (enemyStatuses[4].equals(debuffName)){
            number = 4;
            return number;
        }
        return 0;
    }

    /* CHECK ENEMY FOR AILMENTS */
    private void checkEnemyAilments(){
        int check = findEnemyAilments("Slow Down");
        if (check != -1){
            enemyIsSlowed = false;
            clearEnemyStatus("Slow Down");
        }
        check = findEnemyAilments("Corruption");
        if (check != -1){
            enemyIsCorrupted = false;
            clearEnemyStatus("Corruption");
        }
        check = findEnemyAilments("Curse");
        if (check != -1){
            enemyIsCursed = false;
            enemyCurseCountdown = -1;
            clearEnemyStatus("Curse");
        }
        check = findEnemyAilments("Agony");
        if (check != -1){
            enemyIsAgonized = false;
            enemyAgonyCountdown = -1;
            clearEnemyStatus("Agony");
        }
        check = findEnemyAilments("Malediction");
        if (check != -1){
            enemyIsMaledicted = false;
            enemyMaledictionCountdown = -1;
            clearEnemyStatus("Malediction");
        }
        check = findEnemyAilments("Death Sentence");
        if (check != -1){
            enemyIsSentenced = false;
            enemySentenceCountdown = -1;
            clearEnemyStatus("Death Sentence");
        }
    }

    /* ----------------------------------------- */

    /* FIND PLAYER BUFFS */
    private int findPlayerBuff(String buffName){
        int number;
        if (playerStatuses[0].equals(buffName)){
            number = 0;
            return number;
        }
        if (playerStatuses[1].equals(buffName)){
            number = 1;
            return number;
        }
        if (playerStatuses[2].equals(buffName)){
            number = 2;
            return number;
        }
        if (playerStatuses[3].equals(buffName)){
            number = 3;
            return number;
        }
        if (playerStatuses[4].equals(buffName)){
            number = 4;
            return number;
        }
        return 0;
    }

    /* CHECK PLAYER FOR BUFFS */
    private void checkPlayerBuffs(){
        int check = findPlayerBuff("Speed Up");
        if (check != -1){
            playerHasHaste = false;
            playerHasHaste2 = false;
            clearPlayerStatus("Speed Up");
        }
        check = findPlayerBuff("Protect");
        if (check != -1){
            playerHasProtect = false;
            clearPlayerStatus("Protect");
        }
        check = findPlayerBuff("Rewind");
        if (check != -1){
            playerHasAlteredTime = false;
            clearPlayerStatus("Rewind");
        }
        check = findPlayerBuff("Hoard");
        if (check != -1){
            playerIsHoarding = false;
            clearPlayerStatus("Hoard");
        }
        check = findPlayerBuff("Concentrate");
        if (check != -1){
            playerHasConcentrate = false;
            clearPlayerStatus("Concentrate");
        }
    }

    /* FIND ENEMY BUFFS */
    private int findEnemyBuff(String buffName){
        int number;
        if (enemyStatuses[0].equals(buffName)){
            number = 0;
            return number;
        }
        if (enemyStatuses[1].equals(buffName)){
            number = 1;
            return number;
        }
        if (enemyStatuses[2].equals(buffName)){
            number = 2;
            return number;
        }
        if (enemyStatuses[3].equals(buffName)){
            number = 3;
            return number;
        }
        if (enemyStatuses[4].equals(buffName)){
            number = 4;
            return number;
        }
        return 0;
    }

    /* CHECK ENEMY FOR BUFFS */
    private void checkEnemyBuffs(){
        int check = findEnemyBuff("Speed Up");
        if (check != -1){
            enemyHasHaste = false;
            enemyHasHaste2 = false;
            clearEnemyStatus("Speed Up");
        }
        check = findEnemyBuff("Protect");
        if (check != -1){
            enemyHasProtect = false;
            clearEnemyStatus("Protect");
        }
        check = findEnemyBuff("Rewind");
        if (check != -1){
            enemyHasAlteredTime = false;
            clearEnemyStatus("Rewind");
        }
        check = findEnemyBuff("Hoard");
        if (check != -1){
            enemyIsHoarding = false;
            clearEnemyStatus("Hoard");
        }
        check = findEnemyBuff("Concentrate");
        if (check != -1){
            enemyHasConcentrate = false;
            clearEnemyStatus("Concentrate");
        }
    }

    /* COIN FLIP START */
    private void coinFlipStart(){
        btnEndTurn.setEnabled(false);
        btnEndTurn.setText("");
        disable(layout_objectRow);
        disablePlayerCards();

        myHandler.postDelayed(new Runnable() {
            public void run() {
                chooseCoinSide(Activity_W001_L004.this);
            }
        }, 1500);
    }

    /* CHOOSE COIN SIDE WINDOW */
    private void chooseCoinSide(Context context){
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confirmdialog_coinflip);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));
        dialog.setCancelable(false);

        ImageButton ibRat = (ImageButton) dialog.findViewById(R.id.ibRat);
        ImageButton ibStraw = (ImageButton) dialog.findViewById(R.id.ibStraw);

        ibRat.setImageResource(R.drawable.coin_rat_1);
        ibStraw.setImageResource(R.drawable.coin_straw_1);

        /* YES CLICKED */
        ImageButton buttonDialogYes = (ImageButton) dialog.findViewById(R.id.ibRat);
        buttonDialogYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playerStrawSelected = false;
                coinCycle = genRand(2);
                dialog.dismiss();
                spinCoin();
            }
        });

        /* NO CLICKED */
        ImageButton buttonDialogNo = (ImageButton) dialog.findViewById(R.id.ibStraw);
        buttonDialogNo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playerStrawSelected = true;
                coinCycle = genRand(2);
                dialog.dismiss();
                spinCoin();
            }
        });

        dialog.show();
    }

    /* COIN SPIN */
    private void spinCoin(){
        switch (coinCycle){
            case 0:
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_side);
                    }
                }, 25);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_4);
                    }
                }, 50);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_3);
                    }
                }, 75);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_2);
                    }
                }, 100);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_1);
                    }
                }, 125);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_2_rev);
                    }
                }, 150);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_3_rev);
                    }
                }, 175);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_4_rev);
                    }
                }, 200);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_side);
                    }
                }, 225);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_side);
                    }
                }, 250);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_side);
                    }
                }, 275);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_4_rev);
                    }
                }, 300);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_3_rev);
                    }
                }, 325);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_2_rev);
                    }
                }, 350);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_1);
                    }
                }, 375);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_2);
                    }
                }, 400);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_3);
                    }
                }, 425);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_4);
                    }
                }, 450);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_side);
                    }
                }, 475);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_side);
                    }
                }, 500);

                // 1 LAP

                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_side);
                    }
                }, 525);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_4);
                    }
                }, 550);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_3);
                    }
                }, 575);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_2);
                    }
                }, 600);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_1);
                    }
                }, 625);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_2_rev);
                    }
                }, 650);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_3_rev);
                    }
                }, 675);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_4_rev);
                    }
                }, 700);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_side);
                    }
                }, 725);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_side);
                    }
                }, 750);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_side);
                    }
                }, 775);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_4_rev);
                    }
                }, 800);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_3_rev);
                    }
                }, 825);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_2_rev);
                    }
                }, 850);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_1);
                    }
                }, 875);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_2);
                    }
                }, 900);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_3);
                    }
                }, 925);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_4);
                    }
                }, 950);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_side);
                    }
                }, 975);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_side);
                    }
                }, 900);

                // 2 LAPS

                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_side);
                    }
                }, 925);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_4);
                    }
                }, 950);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_3);
                    }
                }, 975);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_2);
                    }
                }, 1000);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_1);
                    }
                }, 1025);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_2_rev);
                    }
                }, 1050);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_3_rev);
                    }
                }, 1075);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_4_rev);
                    }
                }, 1100);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_side);
                    }
                }, 1125);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_side);
                    }
                }, 1150);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_side);
                    }
                }, 1175);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_4_rev);
                    }
                }, 1200);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_3_rev);
                    }
                }, 1225);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_2_rev);
                    }
                }, 1250);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_1);
                    }
                }, 1275);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_2);
                    }
                }, 1300);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_3);
                    }
                }, 1325);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_4);
                    }
                }, 1350);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_side);
                    }
                }, 1375);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_side);
                    }
                }, 1400);

                // 3 LAPS

                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_side);
                    }
                }, 1425);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_4);
                    }
                }, 1450);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_3);
                    }
                }, 1475);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_2);
                    }
                }, 1500);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_1);
                    }
                }, 1525);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_2_rev);
                    }
                }, 1550);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_3_rev);
                    }
                }, 1575);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_4_rev);
                    }
                }, 1600);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_side);
                    }
                }, 1625);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_side);
                    }
                }, 1650);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_side);
                    }
                }, 1675);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_4_rev);
                    }
                }, 1700);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_3_rev);
                    }
                }, 1725);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_2_rev);
                    }
                }, 1750);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_1);
                    }
                }, 1775);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_2);
                    }
                }, 1800);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_3);
                    }
                }, 1825);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_4);
                    }
                }, 1850);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_side);
                    }
                }, 1875);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_side);
                    }
                }, 1900);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_side);
                    }
                }, 1925);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_4);
                    }
                }, 1950);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_3);
                    }
                }, 1975);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_2);
                    }
                }, 2000);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_1);
                    }
                }, 2025);
                break;
            case 1:
                strawWon = true;
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_side);
                    }
                }, 25);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_4);
                    }
                }, 50);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_3);
                    }
                }, 75);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_2);
                    }
                }, 100);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_1);
                    }
                }, 125);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_2_rev);
                    }
                }, 150);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_3_rev);
                    }
                }, 175);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_4_rev);
                    }
                }, 200);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_side);
                    }
                }, 225);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_side);
                    }
                }, 250);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_side);
                    }
                }, 275);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_4_rev);
                    }
                }, 300);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_3_rev);
                    }
                }, 325);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_2_rev);
                    }
                }, 350);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_1);
                    }
                }, 375);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_2);
                    }
                }, 400);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_3);
                    }
                }, 425);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_4);
                    }
                }, 450);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_side);
                    }
                }, 475);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_side);
                    }
                }, 500);

                // 1 LAP

                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_side);
                    }
                }, 525);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_4);
                    }
                }, 550);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_3);
                    }
                }, 575);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_2);
                    }
                }, 600);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_1);
                    }
                }, 625);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_2_rev);
                    }
                }, 650);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_3_rev);
                    }
                }, 675);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_4_rev);
                    }
                }, 700);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_side);
                    }
                }, 725);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_side);
                    }
                }, 750);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_side);
                    }
                }, 775);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_4_rev);
                    }
                }, 800);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_3_rev);
                    }
                }, 825);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_2_rev);
                    }
                }, 850);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_1);
                    }
                }, 875);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_2);
                    }
                }, 900);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_3);
                    }
                }, 925);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_4);
                    }
                }, 950);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_side);
                    }
                }, 975);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_side);
                    }
                }, 900);

                // 2 LAPS

                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_side);
                    }
                }, 925);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_4);
                    }
                }, 950);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_3);
                    }
                }, 975);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_2);
                    }
                }, 1000);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_1);
                    }
                }, 1025);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_2_rev);
                    }
                }, 1050);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_3_rev);
                    }
                }, 1075);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_4_rev);
                    }
                }, 1100);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_side);
                    }
                }, 1125);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_side);
                    }
                }, 1150);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_side);
                    }
                }, 1175);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_4_rev);
                    }
                }, 1200);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_3_rev);
                    }
                }, 1225);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_2_rev);
                    }
                }, 1250);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_1);
                    }
                }, 1275);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_2);
                    }
                }, 1300);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_3);
                    }
                }, 1325);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_4);
                    }
                }, 1350);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_side);
                    }
                }, 1375);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_side);
                    }
                }, 1400);

                // 3 LAPS

                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_side);
                    }
                }, 1425);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_4);
                    }
                }, 1450);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_3);
                    }
                }, 1475);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_2);
                    }
                }, 1500);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_1);
                    }
                }, 1525);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_2_rev);
                    }
                }, 1550);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_3_rev);
                    }
                }, 1575);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_4_rev);
                    }
                }, 1600);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_side);
                    }
                }, 1625);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_side);
                    }
                }, 1650);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_side);
                    }
                }, 1675);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_4_rev);
                    }
                }, 1700);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_3_rev);
                    }
                }, 1725);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_2_rev);
                    }
                }, 1750);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_1);
                    }
                }, 1775);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_2);
                    }
                }, 1800);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_3);
                    }
                }, 1825);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_4);
                    }
                }, 1850);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_side);
                    }
                }, 1875);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_side);
                    }
                }, 1900);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_side);
                    }
                }, 1925);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_4);
                    }
                }, 1950);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_3);
                    }
                }, 1975);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_2);
                    }
                }, 2000);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_1);
                    }
                }, 2025);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_2_rev);
                    }
                }, 2050);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_3_rev);
                    }
                }, 2075);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_4_rev);
                    }
                }, 2100);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_side);
                    }
                }, 2125);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_side);
                    }
                }, 2250);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_rat_side);
                    }
                }, 2275);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_4_rev);
                    }
                }, 2300);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_3_rev);
                    }
                }, 2325);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_2_rev);
                    }
                }, 2350);
                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        ivCenterImage.setImageResource(R.drawable.coin_straw_1);
                    }
                }, 2375);
                break;
        }

        myHandler.postDelayed(new Runnable() {
            public void run() {
                ivCenterImage.startAnimation(ani_fadeOut);
            }
        }, 3000);

        myHandler.postDelayed(new Runnable() {
            public void run() {
                ivCenterImage.clearAnimation();
                ivCenterImage.setVisibility(View.GONE);
                if (playerStrawSelected && strawWon){
                    playerTurnStart();
                }
                else if (!playerStrawSelected && !strawWon){
                    playerTurnStart();
                } else {
                    btnEndTurn.setText("Enemy Turn");
                    enemyTurnStart();
                }
            }
        }, 4000);
    }

    /* SET CENTER TEXT SIZE */
    private void setCenterTextSize(){
        String density = DeviceDensity.getDensityName(this);
        if (density.equals("xxhdpi")){
            tvCenterMessage.setTextSize(22);
        } else if (density.equals("hdpi")) {
            tvCenterMessage.setTextSize(20);
        }
    }
}

