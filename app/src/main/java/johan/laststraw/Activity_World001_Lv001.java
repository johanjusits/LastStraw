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
 * Created by Johan on 2014-09-27.
 */
public class Activity_World001_Lv001 extends Activity implements View.OnClickListener, Animation.AnimationListener {

    ImageButton obj001, obj002, obj003, obj004, obj005, obj006, obj007, obj008, obj009,
            obj010, obj011, obj012, obj013, obj014, obj015, obj016;
    ImageButton playerCard1, playerCard2, playerCard3, playerCard4, playerCard5, playerCard6;
    ImageButton enemyCard1, enemyCard2, enemyCard3, enemyCard4, enemyCard5, enemyCard6;
    ImageView playerStatusIcon1, playerStatusIcon2, playerStatusIcon3, playerStatusIcon4, playerStatusIcon5;
    ImageView enemyStatusIcon1, enemyStatusIcon2, enemyStatusIcon3, enemyStatusIcon4, enemyStatusIcon5;
    Button btnEndTurn;
    TextView tvCenterMessage, tvPlayerMovesNumber, tvEnemyMovesNumber;
    TextView tvPlayerName, tvPlayerExp, tvPlayerLevel, tvPlayerScore, tvEnemyScore, tvEnemyName;
    ImageView ivPlayerPortrait, ivEnemyPortrait, ivCenterCardFrame;
    ViewGroup layout_objectRow;
    Animation ani_fadeIn, ani_fadeOut, ani_zoomIn, ani_shake, ani_scoregain, ani_resetscore;
    Random rdm = new Random();
    /* STRINGS */
    String playerGender = "";
    String playerName = "";
    String enemyName = "Farmhand Joe";
    String boardIsFullError = "Board is full. No effect";
    String enemySlowed = enemyName + " is afflicted by Slow";
    String enemyHaste = enemyName + " gains Haste";
    String playerHaste = "";
    String playerSlowed = "";
    String buffAlreadyActiveError = "Buff already active. No effect.";
    String debuffAlreadyActiveError = "Debuff already active. No effect.";
    String playerCard1Name = "", playerCard2Name = "", playerCard3Name = "", playerCard4Name = "",
            playerCard5Name = "", playerCard6Name = "";
    String playerCard1Img = "", playerCard2Img = "", playerCard3Img = "", playerCard4Img = "",
            playerCard5Img = "", playerCard6Img = "";
    String[] playerStatuses = new String[5];
    String[] enemyStatuses = new String[5];
    /* INTS */
    int newExp;
    int expToNextLevel;
    int checkIfExpRoof;
    int playerLevel;
    int playerExp = 95;
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
    int enemyCardsRemaining = 6;
    int lvlcleared;
    int lvlhighscore;
    int lvlId;
    int activePlayerStatuses = 0;
    int activeEnemyStatuses = 0;
    ArrayList<Integer> pool = new ArrayList<Integer>();
    /* BOOLEANS */
    boolean deviceIsTablet;
    boolean enemyIsSlowed = false;
    boolean playerIsSlowed = false;
    boolean enemyHasHaste = false;
    boolean playerHasHaste = false;
    boolean playerTurn = true;
    boolean playerCard1Used = false, playerCard2Used = false, playerCard3Used = false, playerCard4Used = false,
            playerCard5Used = false, playerCard6Used = false;
    boolean enemyCard1Used = false, enemyCard2Used = false, enemyCard3Used = false, enemyCard4Used = false,
            enemyCard5Used = false, enemyCard6Used = false;
    boolean errorMsg = false;
    boolean playerWon = false;
    private Handler myHandler = new Handler();
    DBHandler db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world001_lv001);
        layout_objectRow = (ViewGroup) findViewById(R.id.objectRow);

        db = new DBHandler(this);

        /* SETS ANIMATIONS */
        ani_fadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.ani_fade_in);
        ani_fadeOut = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.ani_fade_out);
        ani_zoomIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.ani_zoom_in);
        ani_shake = AnimationUtils.loadAnimation(this, R.anim.ani_shake);
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
        ivEnemyPortrait.setImageResource(R.drawable.portrait_placeholder_cpu);
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
        tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
        tvEnemyMovesNumber.setText(String.valueOf(enemyMoves));

        getScreenSize();
        getPlayerInfo();
        getLevelInfo();
        storeCurrentLevel();
        getPlayerCards();
        setPlayerCardIcons();
        setEnemyCards();

        playerHaste = playerName + " gains Haste";
        playerSlowed = playerName + " is afflicted by Slow";
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
    }

    /* This Method contains a switch handling player clicks on wheat */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ibPlayerCard1:
                selectedCard = 1;
                if (playerCard1Type != 0 && playerMoves >= getCardCost() && objectsRemaining != 0) {
                    String message = "Play this card?";
                    playCardConfirm(message, Activity_World001_Lv001.this);
                }
                break;
            case R.id.ibPlayerCard2:
                selectedCard = 2;
                if (playerCard2Type != 0 && playerMoves >= getCardCost() && objectsRemaining != 0) {
                    String message = "Play this card?";
                    playCardConfirm(message, Activity_World001_Lv001.this);
                }
                break;
            case R.id.ibPlayerCard3:
                selectedCard = 3;
                if (playerCard3Type != 0 && playerMoves >= getCardCost() && objectsRemaining != 0) {
                    String message = "Play this card?";
                    playCardConfirm(message, Activity_World001_Lv001.this);
                }
                break;
            case R.id.ibPlayerCard4:
                selectedCard = 4;
                if (playerCard4Type != 0 && playerMoves >= getCardCost() && objectsRemaining != 0) {
                    String message = "Play this card?";
                    playCardConfirm(message, Activity_World001_Lv001.this);
                }
                break;
            case R.id.ibPlayerCard5:
                selectedCard = 5;
                if (playerCard5Type != 0 && playerMoves >= getCardCost() && objectsRemaining != 0) {
                    String message = "Play this card?";
                    playCardConfirm(message, Activity_World001_Lv001.this);
                }
                break;
            case R.id.ibPlayerCard6:
                selectedCard = 6;
                if (playerCard6Type != 0 && playerMoves >= getCardCost() && objectsRemaining != 0) {
                    String message = "Play this card?";
                    playCardConfirm(message, Activity_World001_Lv001.this);
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
                if (objectsRemaining == 16 && playerMoves != 0) {
                    playerMoves--;
                    playerScore = playerScore + 2;
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
                if (objectsRemaining == 15 && playerMoves != 0) {
                    playerMoves--;
                    playerScore = playerScore + 2;
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
                if (objectsRemaining == 14 && playerMoves != 0) {
                    playerMoves--;
                    playerScore = playerScore + 2;
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
                if (objectsRemaining == 13 && playerMoves != 0) {
                    playerMoves--;
                    playerScore = playerScore + 2;
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
                if (objectsRemaining == 12 && playerMoves != 0) {
                    playerMoves--;
                    playerScore = playerScore + 2;
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
                if (objectsRemaining == 11 && playerMoves != 0) {
                    playerMoves--;
                    playerScore = playerScore + 2;
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
                if (objectsRemaining == 10 && playerMoves != 0) {
                    playerMoves--;
                    playerScore = playerScore + 2;
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
                if (objectsRemaining == 9 && playerMoves != 0) {
                    playerMoves--;
                    playerScore = playerScore + 2;
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
                if (objectsRemaining == 8 && playerMoves != 0) {
                    playerMoves--;
                    playerScore = playerScore + 2;
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
                if (objectsRemaining == 7 && playerMoves != 0) {
                    playerMoves--;
                    playerScore = playerScore + 2;
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
                if (objectsRemaining == 6 && playerMoves != 0) {
                    playerMoves--;
                    playerScore = playerScore + 2;
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
                if (objectsRemaining == 5 && playerMoves != 0) {
                    playerMoves--;
                    playerScore = playerScore + 2;
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
                if (objectsRemaining == 4 && playerMoves != 0) {
                    playerMoves--;
                    playerScore = playerScore + 2;
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
                if (objectsRemaining == 3 && playerMoves != 0) {
                    playerMoves--;
                    playerScore = playerScore + 2;
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
                if (objectsRemaining == 2 && playerMoves != 0) {
                    playerMoves--;
                    playerScore = playerScore + 2;
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
                if (objectsRemaining == 1 && playerMoves != 0) {
                    playerMoves--;
                    playerScore = playerScore + 2;
                    tvPlayerScore.setText(String.valueOf(playerScore));
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
        enemyMoves = 3;
        playerTurn = false;
        /* Calls the method to check if player buffs have run out their duration */
        checkPlayerStatues();
        disablePlayerCards();
        tvCenterMessage.setText("ENEMY TURN");
        tvCenterMessage.startAnimation(ani_fadeIn);
        if (enemyHasHaste){
            enemyMoves = enemyMoves + 1;
        }
        if (enemyIsSlowed){
            enemyMoves = enemyMoves - 1;
        }
        enemyHasHaste = false;
        tvEnemyMovesNumber.setText(String.valueOf(enemyMoves));

        myHandler.postDelayed(new Runnable() {
            public void run() {
                tvCenterMessage.startAnimation(ani_fadeOut);
            }
        }, 1000);

        myHandler.postDelayed(new Runnable() {
            public void run() {
                enemyTurn();
            }
        }, 2000);
    }

    /* ENEMY TURN MOVES */
    private void enemyTurn(){
        /* Checks if enemy has any cards left and decides move pattern accordingly */
        if (enemyCardsRemaining > 0){
            int cardOrClear = genRand(100);
            System.out.println(String.valueOf("cardOrClear = " + cardOrClear));
            /* If number is higher than 80 the AI will play a card */
            if (cardOrClear >= 80){
                enemyPickedCard = randomizeEnemyCardSelect();

                if (enemyPickedCard == 0 && enemyMoves >= enemyCard1Cost){
                    System.out.println("AI played card 1");
                    enemyCard1.setColorFilter(Color.argb(255, 255, 255, 255));
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enemyMoves = enemyMoves - enemyCard1Cost;
                            tvEnemyMovesNumber.setText(String.valueOf(enemyMoves));
                            animateEnemyCard();
                        }
                    }, 2000);
                    enemyCard1Used = true;
                    enemyCardsRemaining--;
                    pool.add(0);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            executeEnemyCardEffect();
                        }
                    }, 6500);
                }

                if (enemyPickedCard == 1 && enemyMoves >= enemyCard2Cost){
                    System.out.println("AI played card 2");
                    enemyCard2.setColorFilter(Color.argb(255, 255, 255, 255));
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enemyMoves = enemyMoves - enemyCard2Cost;
                            tvEnemyMovesNumber.setText(String.valueOf(enemyMoves));
                            animateEnemyCard();
                        }
                    }, 2000);
                    enemyCard2Used = true;
                    enemyCardsRemaining--;
                    pool.add(1);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            executeEnemyCardEffect();
                        }
                    }, 6500);
                }

                if (enemyPickedCard == 2 && enemyMoves >= enemyCard3Cost){
                    System.out.println("AI played card 3");
                    enemyCard3.setColorFilter(Color.argb(255, 255, 255, 255));
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enemyMoves = enemyMoves - enemyCard3Cost;
                            tvEnemyMovesNumber.setText(String.valueOf(enemyMoves));
                            animateEnemyCard();
                        }
                    }, 2000);
                    enemyCard3Used = true;
                    enemyCardsRemaining--;
                    pool.add(2);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            executeEnemyCardEffect();
                        }
                    }, 6500);
                }

                if (enemyPickedCard == 3 && enemyMoves >= enemyCard4Cost){
                    System.out.println("AI played card 4");
                    enemyCard4.setColorFilter(Color.argb(255, 255, 255, 255));
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enemyMoves = enemyMoves - enemyCard4Cost;
                            tvEnemyMovesNumber.setText(String.valueOf(enemyMoves));
                            animateEnemyCard();
                        }
                    }, 2000);
                    enemyCard4Used = true;
                    enemyCardsRemaining--;
                    pool.add(3);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            executeEnemyCardEffect();
                        }
                    }, 6500);
                }

                if (enemyPickedCard == 4 && enemyMoves >= enemyCard5Cost){
                    System.out.println("AI played card 5");
                    enemyCard5.setColorFilter(Color.argb(255, 255, 255, 255));
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enemyMoves = enemyMoves - enemyCard5Cost;
                            tvEnemyMovesNumber.setText(String.valueOf(enemyMoves));
                            animateEnemyCard();
                        }
                    }, 2000);
                    enemyCard5Used = true;
                    enemyCardsRemaining--;
                    pool.add(4);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            executeEnemyCardEffect();
                        }
                    }, 6500);
                }

                if (enemyPickedCard == 5 && enemyMoves >= enemyCard6Cost){
                    System.out.println("AI played card 6");
                    enemyCard6.setColorFilter(Color.argb(255, 255, 255, 255));
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            enemyMoves = enemyMoves - enemyCard6Cost;
                            tvEnemyMovesNumber.setText(String.valueOf(enemyMoves));
                            animateEnemyCard();
                        }
                    }, 2000);
                    enemyCard6Used = true;
                    enemyCardsRemaining--;
                    pool.add(5);
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            executeEnemyCardEffect();
                        }
                    }, 6500);
                }

                myHandler.postDelayed(new Runnable() {
                    public void run() {
                        checkEnemyMoves();
                    }
                }, 8500);

            } else {
               /* If number is less than 80, the AI will clear */
                if (cardOrClear < 80) {
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                            aiClearObject();
                            objectsRemaining = objectsRemaining - 1;
                            enemyScore = enemyScore + 2;
                            tvEnemyScore.setText(String.valueOf(enemyScore));
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
                    objectsRemaining = objectsRemaining - 1;
                    enemyScore = enemyScore + 2;
                    tvEnemyScore.setText(String.valueOf(enemyScore));
                    checkEnemyMoves();
                }
            }, 1000);
        }

    }

    /* CHECK ENEMY REMAINING MOVES */
    private void checkEnemyMoves(){

        myHandler.postDelayed(new Runnable() {
            public void run() {
                System.out.println("checking remaining moves...");
                if (enemyMoves <= 0){
                    enemyTurnEnd();
                } else {
                    if (objectsRemaining == 0){
                        checkIfNoObjRemains();
                    } else {
                        enemyTurn();
                    }
                }
            }
        }, 1500);
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
                    playerTurn();
                }
            }, 1000);
        }
    }

    /* RETURN TO PLAYER TURN METHOD */
    private void playerTurn() {
        myHandler.postDelayed(new Runnable() {
            public void run() {
                playerTurn = true;
                enemyMoves = 0;
                tvEnemyMovesNumber.setText(String.valueOf(enemyMoves));
                enemyIsSlowed = false;
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
                playerMoves = 3;
                btnEndTurn.setEnabled(true);
                btnEndTurn.setText("End Turn");
                enable(layout_objectRow);
                enablePlayerCards();
                if (playerHasHaste){
                    playerMoves = playerMoves + 1;
                }
                if (playerIsSlowed){
                    playerMoves = playerMoves - 1;
                }
                playerIsSlowed = false;
                playerHasHaste = false;
                tvPlayerMovesNumber.setText(String.valueOf(playerMoves));
            }
        }, 3000);
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
        enemyMoves = enemyMoves - 1;
        tvEnemyMovesNumber.setText(String.valueOf(enemyMoves));
        if (objectsRemaining == 16)
            obj001.setImageResource(R.drawable.object_wheatbroken);
        if (objectsRemaining == 15)
            obj002.setImageResource(R.drawable.object_wheatbroken);
        if (objectsRemaining == 14)
            obj003.setImageResource(R.drawable.object_wheatbroken);
        if (objectsRemaining == 13)
            obj004.setImageResource(R.drawable.object_wheatbroken);
        if (objectsRemaining == 12)
            obj005.setImageResource(R.drawable.object_wheatbroken);
        if (objectsRemaining == 11)
            obj006.setImageResource(R.drawable.object_wheatbroken);
        if (objectsRemaining == 10)
            obj007.setImageResource(R.drawable.object_wheatbroken);
        if (objectsRemaining == 9)
            obj008.setImageResource(R.drawable.object_wheatbroken);
        if (objectsRemaining == 8)
            obj009.setImageResource(R.drawable.object_wheatbroken);
        if (objectsRemaining == 7)
            obj010.setImageResource(R.drawable.object_wheatbroken);
        if (objectsRemaining == 6)
            obj011.setImageResource(R.drawable.object_wheatbroken);
        if (objectsRemaining == 5)
            obj012.setImageResource(R.drawable.object_wheatbroken);
        if (objectsRemaining == 4)
            obj013.setImageResource(R.drawable.object_wheatbroken);
        if (objectsRemaining == 3)
            obj014.setImageResource(R.drawable.object_wheatbroken);
        if (objectsRemaining == 2)
            obj015.setImageResource(R.drawable.object_wheatbroken);
        if (objectsRemaining == 1)
            obj016.setImageResource(R.drawable.object_wheatbroken);
    }

    /* Selects random card among the ones the enemy has left. This method will have to
    be modified depending on how many cards the enemy has. */
    public int randomizeEnemyCardSelect(){
        int randomizedCard;

        if (enemyCardsRemaining == 6){
            randomizedCard = genRand(6);
            return randomizedCard;
        }

        if (enemyCardsRemaining <= 5){
            do{
                randomizedCard = genRand(6);
                System.out.println(String.valueOf("randomized card = " + randomizedCard));
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
                finalPlayerScore = playerScore + 3;
                finalEnemyScore = enemyScore - 3;
                if (finalEnemyScore < 0) {
                    finalEnemyScore = 0;
                }
            } else {
                finalPlayerScore = playerScore - 3;
                finalEnemyScore = enemyScore + 3;
            }
            if (finalPlayerScore < 0) {
                finalPlayerScore = 0;
            }
            gameOver();
        }
    }

    /* METHOD CALLED WHEN THE GAME IS OVER */
    private void gameOver() {
        myHandler.postDelayed(new Runnable() {
            public void run() {
                final Dialog dialog = new Dialog(Activity_World001_Lv001.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.confirmdialog_finalscore);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));
                dialog.getWindow().setLayout(500, 300);
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
                    cursor = db.getLvlInfo(1);
                    if (cursor != null && cursor.moveToFirst()) {
                        if (playerWon){
                            db.updateLvlInfo(1, 1, finalPlayerScore);
                        } else {
                            db.updateLvlInfo(1, lvlcleared, finalPlayerScore);
                        }
                    }
                } else {
                    cursor = db.getLvlInfo(1);
                    if (cursor != null && cursor.moveToFirst()) {
                        if (playerWon){
                            db.updateLvlInfo(1, 1, lvlhighscore);
                        } else {
                            db.updateLvlInfo(1, lvlcleared, lvlhighscore);
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
                cursor = db.getLvlInfo(1);
                if (cursor != null && cursor.moveToFirst()) {
                    db.updateLvlInfo(1, lvlcleared, finalPlayerScore);
                }
            } else {
                cursor = db.getLvlInfo(1);
                if (cursor != null && cursor.moveToFirst()) {
                    db.updateLvlInfo(1, lvlcleared, lvlhighscore);
                }
            }
        }
        db.close();
    }

    /* METHOD TO UPDATE EXP/LEVEL UP */
    private void updateExp() {
        myHandler.postDelayed(new Runnable() {
            public void run() {
                final Dialog dialog = new Dialog(Activity_World001_Lv001.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.confirmdialog_exp_gain);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));
                dialog.getWindow().setLayout(500, 300);
                dialog.setCancelable(false);

                final ProgressBar expBar = (ProgressBar) dialog.findViewById(R.id.expBarUpd);
                Drawable draw = getResources().getDrawable(R.drawable.customprogressbar);
                expBar.setProgressDrawable(draw);

                final TextView tvTitle = (TextView) dialog.findViewById(R.id.tvExpGainTitle);
                final TextView tvExpText = (TextView) dialog.findViewById(R.id.tvExp);
                final TextView tvGainedExp = (TextView) dialog.findViewById(R.id.tvGainedExp);
                tvGainedExp.setText(String.valueOf(finalPlayerScore));
                expBar.setProgress(playerExp);

                checkIfExpRoof = playerExp + finalPlayerScore;

                myHandler.postDelayed(new Runnable() {
                    public void run() {

                        if (android.os.Build.VERSION.SDK_INT >= 11) {
                            ObjectAnimator animation = ObjectAnimator.ofInt(expBar, "progress", playerExp + finalPlayerScore);
                            animation.setDuration(1000);
                            animation.setInterpolator(new DecelerateInterpolator());
                            animation.start();
                        } else {
                            expBar.setProgress(playerExp + finalPlayerScore);
                        }
                        checkIfExpRoof = playerExp + finalPlayerScore;

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
                            newExp = playerExp + finalPlayerScore;
                            db.updatePlayerExp(newExp);
                        }
                        db.close();
                        expBar.setProgress(playerExp + finalPlayerScore);

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
                playerMoves = playerMoves - getCardCost();
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
            //playerExp = cursor.getInt(cursor.getColumnIndex("exp"));
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
            }
        }
        db.close();
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

        if (deviceIsTablet) {
            /* CARD 1 */
            if (playerCard1Type == 0) {
                playerCard1.setVisibility(View.GONE);
            } else {
                playerCard1.setImageResource(getResources().getIdentifier(playerCard1Img, "drawable", getPackageName()));
            }
            /* CARD 2 */
            if (playerCard2Type == 0) {
                playerCard2.setVisibility(View.GONE);
            } else {
                playerCard2.setImageResource(getResources().getIdentifier(playerCard2Img, "drawable", getPackageName()));
            }
            /* CARD 3 */
            if (playerCard3Type == 0) {
                playerCard3.setVisibility(View.GONE);
            } else {
                playerCard3.setImageResource(getResources().getIdentifier(playerCard3Img, "drawable", getPackageName()));
            }
            /* CARD 4 */
            if (playerCard4Type == 0) {
                playerCard4.setVisibility(View.GONE);
            } else {
                playerCard4.setImageResource(getResources().getIdentifier(playerCard4Img, "drawable", getPackageName()));
            }
            /* CARD 5 */
            if (playerCard5Type == 0) {
                playerCard5.setVisibility(View.GONE);
            } else {
                playerCard5.setImageResource(getResources().getIdentifier(playerCard5Img, "drawable", getPackageName()));
            }
            /* CARD 2 */
            if (playerCard6Type == 0) {
                playerCard6.setVisibility(View.GONE);
            } else {
                playerCard6.setImageResource(getResources().getIdentifier(playerCard6Img, "drawable", getPackageName()));
            }

        } else {
            /* CARD 1 */
            if (playerCard1Type == 0) {
                playerCard1.setVisibility(View.GONE);
            }
            if (playerCard1Type == 1) {
                playerCard1.setBackgroundResource(R.drawable.card_icon_field);
                playerCard1.setImageResource(R.drawable.card_type_field);
            }
            if (playerCard1Type == 2) {
                playerCard1.setBackgroundResource(R.drawable.card_icon_ailment);
                playerCard1.setImageResource(R.drawable.card_type_ailment);
            }
            if (playerCard1Type == 3) {
                playerCard1.setBackgroundResource(R.drawable.card_icon_boosting);
                playerCard1.setImageResource(R.drawable.card_type_boosting);
            }
        /* CARD 2 */
            if (playerCard2Type == 0) {
                playerCard2.setVisibility(View.GONE);
            }
            if (playerCard2Type == 1) {
                playerCard2.setBackgroundResource(R.drawable.card_icon_field);
                playerCard2.setImageResource(R.drawable.card_type_field);
            }
            if (playerCard2Type == 2) {
                playerCard2.setBackgroundResource(R.drawable.card_icon_ailment);
                playerCard2.setImageResource(R.drawable.card_type_ailment);
            }
            if (playerCard2Type == 3) {
                playerCard2.setBackgroundResource(R.drawable.card_icon_boosting);
                playerCard2.setImageResource(R.drawable.card_type_boosting);
            }
        /* CARD 3 */
            if (playerCard3Type == 0) {
                playerCard3.setVisibility(View.GONE);
            }
            if (playerCard3Type == 1) {
                playerCard3.setBackgroundResource(R.drawable.card_icon_field);
                playerCard3.setImageResource(R.drawable.card_type_field);
            }
            if (playerCard3Type == 2) {
                playerCard3.setBackgroundResource(R.drawable.card_icon_ailment);
                playerCard3.setImageResource(R.drawable.card_type_ailment);
            }
            if (playerCard3Type == 3) {
                playerCard3.setBackgroundResource(R.drawable.card_icon_boosting);
                playerCard3.setImageResource(R.drawable.card_type_boosting);
            }
        /* CARD 4 */
            if (playerCard4Type == 0) {
                playerCard4.setVisibility(View.GONE);
            }
            if (playerCard4Type == 1) {
                playerCard4.setBackgroundResource(R.drawable.card_icon_field);
                playerCard4.setImageResource(R.drawable.card_type_field);
            }
            if (playerCard4Type == 2) {
                playerCard4.setBackgroundResource(R.drawable.card_icon_ailment);
                playerCard4.setImageResource(R.drawable.card_type_ailment);
            }
            if (playerCard4Type == 3) {
                playerCard4.setBackgroundResource(R.drawable.card_icon_boosting);
                playerCard4.setImageResource(R.drawable.card_type_boosting);
            }
        /* CARD 5 */
            if (playerCard5Type == 0) {
                playerCard5.setVisibility(View.GONE);
            }
            if (playerCard5Type == 1) {
                playerCard5.setBackgroundResource(R.drawable.card_icon_field);
                playerCard5.setImageResource(R.drawable.card_type_field);
            }
            if (playerCard5Type == 2) {
                playerCard5.setBackgroundResource(R.drawable.card_icon_ailment);
                playerCard5.setImageResource(R.drawable.card_type_ailment);
            }
            if (playerCard5Type == 3) {
                playerCard5.setBackgroundResource(R.drawable.card_icon_boosting);
                playerCard5.setImageResource(R.drawable.card_type_boosting);
            }
        /* CARD 6 */
            if (playerCard6Type == 0) {
                playerCard6.setVisibility(View.GONE);
            }
            if (playerCard6Type == 1) {
                playerCard6.setBackgroundResource(R.drawable.card_icon_field);
                playerCard6.setImageResource(R.drawable.card_type_field);
            }
            if (playerCard6Type == 2) {
                playerCard6.setBackgroundResource(R.drawable.card_icon_ailment);
                playerCard6.setImageResource(R.drawable.card_type_ailment);
            }
            if (playerCard6Type == 3) {
                playerCard6.setBackgroundResource(R.drawable.card_icon_boosting);
                playerCard6.setImageResource(R.drawable.card_type_boosting);
            }
        }

    }

    /* THIS METHOD SETS ENEMY CARDS */
    private void setEnemyCards(){
        enemyCard1.setVisibility(View.VISIBLE);
        enemyCard1.setBackgroundResource(R.drawable.card_icon_field);
        enemyCard1.setImageResource(R.drawable.card_type_field);
        enemyCard2.setVisibility(View.VISIBLE);
        enemyCard2.setBackgroundResource(R.drawable.card_icon_field);
        enemyCard2.setImageResource(R.drawable.card_type_field);
        enemyCard3.setVisibility(View.VISIBLE);
        enemyCard3.setBackgroundResource(R.drawable.card_icon_field);
        enemyCard3.setImageResource(R.drawable.card_type_field);
        enemyCard4.setVisibility(View.VISIBLE);
        enemyCard4.setBackgroundResource(R.drawable.card_icon_field);
        enemyCard4.setImageResource(R.drawable.card_type_field);
        enemyCard5.setVisibility(View.VISIBLE);
        enemyCard5.setBackgroundResource(R.drawable.card_icon_field);
        enemyCard5.setImageResource(R.drawable.card_type_field);
        enemyCard6.setVisibility(View.VISIBLE);
        enemyCard6.setBackgroundResource(R.drawable.card_icon_field);
        enemyCard6.setImageResource(R.drawable.card_type_field);
    }

    /* THIS METHOD DETERMINES IF DEVICE IS A TABLET OR PHONE */
    private void getScreenSize() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int widthPixels = metrics.widthPixels;
        int heightPixels = metrics.heightPixels;

        float scaleFactor = metrics.density;
        float widthDp = widthPixels / scaleFactor;
        float heightDp = heightPixels / scaleFactor;

        float smallestWidth = Math.min(widthDp, heightDp);

        if (smallestWidth > 720) {
            //Device is a 10" tablet
            deviceIsTablet = true;
        } else if (smallestWidth < 600) {
            //Device is a 7" tablet
            deviceIsTablet = false;
        }
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
                    enemyCard1.setVisibility(View.INVISIBLE);
                }
            }, 500);

            myHandler.postDelayed(new Runnable() {
                public void run() {
                    ivCenterCardFrame.startAnimation(ani_zoomIn);
                    ivCenterCardFrame.setImageResource(R.drawable.card_steal_3);
                }
            }, 1000);
        }
        if (enemyPickedCard == 1) {
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    enemyCard2.setVisibility(View.INVISIBLE);
                }
            }, 500);

            myHandler.postDelayed(new Runnable() {
                public void run() {
                    ivCenterCardFrame.startAnimation(ani_zoomIn);
                    ivCenterCardFrame.setImageResource(R.drawable.card_steal_3);
                }
            }, 1000);
        }
        if (enemyPickedCard == 2) {
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    enemyCard3.setVisibility(View.INVISIBLE);
                }
            }, 500);

            myHandler.postDelayed(new Runnable() {
                public void run() {
                    ivCenterCardFrame.startAnimation(ani_zoomIn);
                    ivCenterCardFrame.setImageResource(R.drawable.card_steal_3);
                }
            }, 1000);
        }
        if (enemyPickedCard == 3) {
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    enemyCard4.setVisibility(View.INVISIBLE);
                }
            }, 500);

            myHandler.postDelayed(new Runnable() {
                public void run() {
                    ivCenterCardFrame.startAnimation(ani_zoomIn);
                    ivCenterCardFrame.setImageResource(R.drawable.card_steal_3);
                }
            }, 1000);
        }
        if (enemyPickedCard == 4) {
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    enemyCard5.setVisibility(View.INVISIBLE);
                }
            }, 500);

            myHandler.postDelayed(new Runnable() {
                public void run() {
                    ivCenterCardFrame.startAnimation(ani_zoomIn);
                    ivCenterCardFrame.setImageResource(R.drawable.card_steal_3);
                }
            }, 1000);
        }
        if (enemyPickedCard == 5) {
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    enemyCard6.setVisibility(View.INVISIBLE);
                }
            }, 500);

            myHandler.postDelayed(new Runnable() {
                public void run() {
                    ivCenterCardFrame.startAnimation(ani_zoomIn);
                    ivCenterCardFrame.setImageResource(R.drawable.card_steal_3);
                }
            }, 1000);
        }
        myHandler.postDelayed(new Runnable() {
            public void run() {
                ivCenterCardFrame.clearAnimation();
                ivCenterCardFrame.setVisibility(View.INVISIBLE);
            }
        }, 2500);
    }

    /* THIS METHOD ANIMATES THE RIGHT CARD AND DISPLAYS IT IN THE CENTER */
    private void animatePlayerCard() {
        if (selectedCard == 1) {
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    playerCard1.setVisibility(View.INVISIBLE);
                    playerCard1.setClickable(false);
                    playerCard1Used = true;
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
                    playerCard2.setVisibility(View.INVISIBLE);
                    playerCard2.setClickable(false);
                    playerCard2Used = true;
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
                    playerCard3.setVisibility(View.INVISIBLE);
                    playerCard3.setClickable(false);
                    playerCard3Used = true;
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
                    playerCard4.setVisibility(View.INVISIBLE);
                    playerCard4.setClickable(false);
                    playerCard4Used = true;
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
                    playerCard5.setVisibility(View.INVISIBLE);
                    playerCard5.setClickable(false);
                    playerCard5Used = true;
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
                    playerCard6.setVisibility(View.INVISIBLE);
                    playerCard6.setClickable(false);
                    playerCard6Used = true;
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
            cardSteal(1,3);
        }
        if (playedCard.equals("Steal II")) {
            cardSteal(3,5);
        }
        if (playedCard.equals("Steal III")) {
            cardSteal(5,7);
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
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    enable(layout_objectRow);
                    enablePlayerCards();
                    btnEndTurn.setClickable(true);
                }
            }, 1500);
        }
    }

    /* THIS METHOD FINDS WHICH ENEMY CARD IS PLAYED TO DETERMINE EFFECT */
    private void executeEnemyCardEffect(){
        if (enemyPickedCard == 0){
            cardSteal(1,3);
        }
        if (enemyPickedCard == 1){
            cardSteal(1,3);
        }
        if (enemyPickedCard == 2){
            cardSteal(1,3);
        }
        if (enemyPickedCard == 3){
            cardSteal(1,3);
        }
        if (enemyPickedCard == 4){
            cardSteal(1,3);
        }
        if (enemyPickedCard == 5){
            cardSteal(1,3);
        }

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
            obj001.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 14) {
            obj002.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 13) {
            obj003.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 12) {
            obj004.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 11) {
            obj005.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 10) {
            obj006.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 9) {
            obj007.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 8) {
            obj008.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 7) {
            obj009.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 6) {
            obj010.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 5) {
            obj011.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 4) {
            obj012.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 3) {
            obj013.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 2) {
            obj014.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 1) {
            obj015.setImageResource(R.drawable.object_wheat);
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
            obj001.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 14) {
            obj001.setImageResource(R.drawable.object_wheat);
            obj002.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 13) {
            obj002.setImageResource(R.drawable.object_wheat);
            obj003.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 12) {
            obj003.setImageResource(R.drawable.object_wheat);
            obj004.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 11) {
            obj004.setImageResource(R.drawable.object_wheat);
            obj005.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 10) {
            obj005.setImageResource(R.drawable.object_wheat);
            obj006.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 9) {
            obj006.setImageResource(R.drawable.object_wheat);
            obj007.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 8) {
            obj007.setImageResource(R.drawable.object_wheat);
            obj008.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 7) {
            obj008.setImageResource(R.drawable.object_wheat);
            obj009.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 6) {
            obj009.setImageResource(R.drawable.object_wheat);
            obj010.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 5) {
            obj010.setImageResource(R.drawable.object_wheat);
            obj011.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 4) {
            obj011.setImageResource(R.drawable.object_wheat);
            obj012.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 3) {
            obj012.setImageResource(R.drawable.object_wheat);
            obj013.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 2) {
            obj013.setImageResource(R.drawable.object_wheat);
            obj014.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 1) {
            obj014.setImageResource(R.drawable.object_wheat);
            obj015.setImageResource(R.drawable.object_wheat);
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
            obj001.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 1;
        }
        if (objectsRemaining == 14) {
            obj001.setImageResource(R.drawable.object_wheat);
            obj002.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 2;
        }
        if (objectsRemaining == 13) {
            obj001.setImageResource(R.drawable.object_wheat);
            obj002.setImageResource(R.drawable.object_wheat);
            obj003.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 12) {
            obj002.setImageResource(R.drawable.object_wheat);
            obj003.setImageResource(R.drawable.object_wheat);
            obj004.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 11) {
            obj003.setImageResource(R.drawable.object_wheat);
            obj004.setImageResource(R.drawable.object_wheat);
            obj005.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 10) {
            obj004.setImageResource(R.drawable.object_wheat);
            obj005.setImageResource(R.drawable.object_wheat);
            obj006.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 9) {
            obj005.setImageResource(R.drawable.object_wheat);
            obj006.setImageResource(R.drawable.object_wheat);
            obj007.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 8) {
            obj006.setImageResource(R.drawable.object_wheat);
            obj007.setImageResource(R.drawable.object_wheat);
            obj008.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 7) {
            obj007.setImageResource(R.drawable.object_wheat);
            obj008.setImageResource(R.drawable.object_wheat);
            obj009.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 6) {
            obj008.setImageResource(R.drawable.object_wheat);
            obj009.setImageResource(R.drawable.object_wheat);
            obj010.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 5) {
            obj009.setImageResource(R.drawable.object_wheat);
            obj010.setImageResource(R.drawable.object_wheat);
            obj011.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 4) {
            obj010.setImageResource(R.drawable.object_wheat);
            obj011.setImageResource(R.drawable.object_wheat);
            obj012.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 3) {
            obj011.setImageResource(R.drawable.object_wheat);
            obj012.setImageResource(R.drawable.object_wheat);
            obj013.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 2) {
            obj012.setImageResource(R.drawable.object_wheat);
            obj013.setImageResource(R.drawable.object_wheat);
            obj014.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 3;
        }
        if (objectsRemaining == 1) {
            obj013.setImageResource(R.drawable.object_wheat);
            obj014.setImageResource(R.drawable.object_wheat);
            obj015.setImageResource(R.drawable.object_wheat);
            objectsRemaining = objectsRemaining + 3;
        }
    }

    /* SLOW DOWN CARD EFFECT METHOD */
    private void cardSlowDown() {
        if (playerTurn) {
            if (!Arrays.asList(enemyStatuses).contains("Slow Down")){
                tvCenterMessage.setText(enemySlowed);
                tvCenterMessage.startAnimation(ani_fadeIn);
            }
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
            if (!Arrays.asList(playerStatuses).contains("Slow Down")){
                tvCenterMessage.setText(playerSlowed);
                tvCenterMessage.startAnimation(ani_fadeIn);
            }
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

    /* FETCHES LEVEL INFO */
    private void getLevelInfo(){
        try {
            db.open();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        cursor = db.getLvlInfo(1);
        if (cursor != null && cursor.moveToFirst()) {
            lvlcleared = cursor.getInt(cursor.getColumnIndex("lvlcleared"));
            lvlhighscore = cursor.getInt(cursor.getColumnIndex("lvlhighscore"));
            lvlId = cursor.getInt(cursor.getColumnIndex("_id"));
            System.out.println(String.valueOf(lvlcleared));
            System.out.println(String.valueOf(lvlhighscore));
            System.out.println(String.valueOf(lvlId));
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

    /* ----------------------------------------- */

    /* CHECK ENEMY STATUSES */
    private void checkEnemyStatuses(){
        if (!enemyIsSlowed){
            clearEnemySlow();
        }
        if (!enemyHasHaste){
            clearEnemySpeedUp();
        }
    }

    /* CHECK PLAYER STATUSES */
    private void checkPlayerStatues(){
        if (!playerHasHaste){
            clearPlayerSpeedUp();
        }
        if (!playerIsSlowed){
            clearPlayerSlow();
        }
    }

    /* -----------------------------------------
    * CLEAR STATUS METHODS
    *  -----------------------------------------*/

    /* CLEAR ENEMY SLOW */
    private void clearEnemySlow(){
        if (enemyStatuses[0] == "Slow Down"){
            enemyStatuses[0] = "";
            enemyStatusIcon1.setVisibility(View.INVISIBLE);
            activeEnemyStatuses--;
        }
        if (enemyStatuses[1] == "Slow Down"){
            enemyStatuses[1] = "";
            enemyStatusIcon2.setVisibility(View.INVISIBLE);
            activeEnemyStatuses--;
        }
        if (enemyStatuses[2] == "Slow Down"){
            enemyStatuses[2] = "";
            enemyStatusIcon3.setVisibility(View.INVISIBLE);
            activeEnemyStatuses--;
        }
        if (enemyStatuses[3] == "Slow Down"){
            enemyStatuses[3] = "";
            enemyStatusIcon4.setVisibility(View.INVISIBLE);
            activeEnemyStatuses--;
        }
        if (enemyStatuses[4] == "Slow Down"){
            enemyStatuses[4] = "";
            enemyStatusIcon5.setVisibility(View.INVISIBLE);
            activeEnemyStatuses--;
        }
    }

    /* CLEAR ENEMY SPEED UP */
    private void clearEnemySpeedUp(){
        if (enemyStatuses[0] == "Speed Up"){
            enemyStatuses[0] = "";
            enemyStatusIcon1.setVisibility(View.INVISIBLE);
            activeEnemyStatuses--;
        }
        if (enemyStatuses[1] == "Speed Up"){
            enemyStatuses[1] = "";
            enemyStatusIcon2.setVisibility(View.INVISIBLE);
            activeEnemyStatuses--;
        }
        if (enemyStatuses[2] == "Speed Up"){
            enemyStatuses[2] = "";
            enemyStatusIcon3.setVisibility(View.INVISIBLE);
            activeEnemyStatuses--;
        }
        if (enemyStatuses[3] == "Speed Up"){
            enemyStatuses[3] = "";
            enemyStatusIcon4.setVisibility(View.INVISIBLE);
            activeEnemyStatuses--;
        }
        if (enemyStatuses[4] == "Speed Up"){
            enemyStatuses[4] = "";
            enemyStatusIcon5.setVisibility(View.INVISIBLE);
            activeEnemyStatuses--;
        }
    }

    /* CLEAR PLAYER SPEED UP */
    private void clearPlayerSpeedUp(){
        if (playerStatuses[0] == "Speed Up"){
            playerStatuses[0] = "";
            playerStatusIcon1.setVisibility(View.INVISIBLE);
            activePlayerStatuses--;
        }
        if (playerStatuses[1].equals("Speed Up")){
            playerStatuses[1] = "";
            playerStatusIcon2.setVisibility(View.INVISIBLE);
            activePlayerStatuses--;
        }
        if (playerStatuses[2].equals("Speed Up")){
            playerStatuses[2] = "";
            playerStatusIcon3.setVisibility(View.INVISIBLE);
            activePlayerStatuses--;
        }
        if (playerStatuses[3].equals("Speed Up")){
            playerStatuses[3] = "";
            playerStatusIcon4.setVisibility(View.INVISIBLE);
            activePlayerStatuses--;
        }
        if (playerStatuses[4].equals("Speed Up")){
            playerStatuses[4] = "";
            playerStatusIcon1.setVisibility(View.INVISIBLE);
            activePlayerStatuses--;
        }
    }

    /* CLEAR PLAYER SLOW */
    private void clearPlayerSlow(){
        if (playerStatuses[0] == "Slow Down"){
            playerStatuses[0] = "";
            playerStatusIcon1.setVisibility(View.INVISIBLE);
            activePlayerStatuses--;
        }
        if (playerStatuses[1].equals("Slow Down")){
            playerStatuses[1] = "";
            playerStatusIcon2.setVisibility(View.INVISIBLE);
            activePlayerStatuses--;
        }
        if (playerStatuses[2].equals("Slow Down")){
            playerStatuses[2] = "";
            playerStatusIcon3.setVisibility(View.INVISIBLE);
            activePlayerStatuses--;
        }
        if (playerStatuses[3].equals("Slow Down")){
            playerStatuses[3] = "";
            playerStatusIcon4.setVisibility(View.INVISIBLE);
            activePlayerStatuses--;
        }
        if (playerStatuses[4].equals("Slow Down")){
            playerStatuses[4] = "";
            playerStatusIcon1.setVisibility(View.INVISIBLE);
            activePlayerStatuses--;
        }
    }

    /* ----------------------------------------- */

    /* CHECK FOR EMPTY PLAYER STATUS SPOT */
    private int getFreePlayerStatusSpot(){
        int number = 0;
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
        return 0;
    }

    /* CHECK FOR EMPTY ENEMY STATUS */
    private int getFreeEnemyStatusSpot(){
        int number = 0;
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
}



