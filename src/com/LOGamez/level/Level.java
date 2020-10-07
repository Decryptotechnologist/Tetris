/*
	OneLoneCoder.com - Command Line Tetris
	"Put Your Money Where Your Mouth Is" - @Javidx9
	
	License
	~~~~~~~
	Copyright (C) 2018  Javidx9
	This program comes with ABSOLUTELY NO WARRANTY.
	This is free software, and you are welcome to redistribute it
	under certain conditions; See license for details. 
	Original works located at:
	https://www.github.com/onelonecoder
	https://www.onelonecoder.com
	https://www.youtube.com/javidx9
	GNU GPLv3
	https://github.com/OneLoneCoder/videos/blob/master/LICENSE
	From Javidx9 :)
	~~~~~~~~~~~~~~~
	Hello! Ultimately I don't care what you use this for. It's intended to be 
	educational, and perhaps to the oddly minded - a little bit of fun. 
	Please hack this, change it and use it in any way you see fit. You acknowledge 
	that I am not responsible for anything bad that happens as a result of 
	your actions. However this code is protected by GNU GPLv3, see the license in the
	github repo. This means you must attribute me if you use it. You can view this
	license here: https://github.com/OneLoneCoder/videos/blob/master/LICENSE
	Cheers!
	
	Background
	~~~~~~~~~~
	I made a video "8-Bits of advice for new programmers" (https://youtu.be/vVRCJ52g5m4)
	and suggested that building a tetris clone instead of Dark Sould IV might be a better 
	approach to learning to code. Tetris is nice as it makes you think about algorithms. 
	
	Controls are Arrow keys Left, Right & Down. Use Z to rotate the piece. 
	You score 25pts per tetronimo, and 2^(number of lines)*100 when you get lines.
	
	Future Modifications
	~~~~~~~~~~~~~~~~~~~~
	1) Show next block and line counter
	
	Author
	~~~~~~
	Twitter: @javidx9
	Blog: www.onelonecoder.com
	
	Video:
	~~~~~~
	https://youtu.be/8OK8_tHeCIA
	
	Last Updated: 30/03/2017
*/
package com.LOGamez.level;

import com.LOGamez.audio.Sound;
import com.LOGamez.graphics.*;
import com.LOGamez.tetris.*;
import com.LOGamez.player.Player;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 *
 * @author Nicholas Wright, Javidx9
 */
public class Level {
    
    /**Attributes*/ 
    
    /**EnSpeedGlobal variable of Level*/ 
    public static int EnSpeedGlobal = 1;
    
    /**background variable of Level*/ 
    public static int background = 1;
    
    /**bgW coordinate of Level*/ 
    public static double bgW = 0.18 * 6;
    
    /**bgH coordinate of Level*/ 
    public static double bgH = 0.18 * 6;
    
    /**bgX coordinate of Level*/ 
    public static double bgX = (Tetris.getMainWidth()/5);
    
    /**bgY coordinate of Level*/ 
    public static double bgY = 200 + (720/6.0) /8;
    
    /**levelNo variable of Level*/ 
    public static int levelNo;
    
    /**levelName variable of Level*/ 
    private static String levelName;
    
    /**levelComplete variable of Level*/ 
    public static boolean levelComplete = false;
    
    /**gameComplete variable of Level*/ 
    private static boolean gameComplete;
    
    /**groundScale variable of Level*/ 
    public static double groundScale;
    
    /**groundX coordinate of Level*/ 
    public static int groundX;
    
    /**groundY coordinate of Level*/ 
    public static int groundY;
    
    /**powScale variable of Level*/ 
    //public static double powScale;
    
    /**groundBounds Rectangle of Level*/ 
    //public static Rectangle groundBounds;
    
    /**anim variable of Level*/ 
    //private static Animation anim;
    
    /**animEarth variable of Level*/ 
    //private static Animation animEarth;
    
    /**animMars variable of Level*/ 
    //private static Animation animMars;
    
    /**animSun variable of Level*/ 
    //private static Animation animSun;
    
    /**playerStartX variable of Level*/
    public static int playerStartX;
    
    /**playerStartY variable of Level*/
    public static int playerStartY;
    
    /**levelCompleteCount variable of Level*/ 
    //private int levelCompleteCount;
    
    /**levelStartCount variable of Level*/ 
    //private int levelStartCount;
    
    /**firstTick variable of Level*/
    public static boolean firstTick;
    
    /**lastTick variable of Level*/
    public static boolean lastTick;
    
    /**groundColor variable of Level*/
    //private int groundColor;
    
    /**levelTxtBGCol variable of Level*/
    //private int levelTxtBGCol;
    
    /**enterLvlIconBG variable of Level*/
    //private int enterLvlIconBG;
    
    /**enterLvlIconFG variable of Level*/
    //private int enterLvlIconFG;
    
    /**theLevelTime variable of Level*/
    public static String theLevelTime;
    
    /**tetromino variable of Level*/
    private String[] tetromino = new String[7];
    
    /**fieldWidth variable of Level*/
    int fieldWidth = 12;
    
    /**fieldHeight variable of Level*/
    int fieldHeight = 19;
    
    /**pField variable of Level*/
    char[] pField = null;
    
    /**screenWidth variable of Level*/
    int screenWidth = 80;//Tetris.getMainWidth();
    
    /**screenHeight variable of Level*/
    int screenHeight = 32;//Tetris.getMainHeight();
    
    /**pScreen variable of Level*/
    char[] pScreen = null;
    
    /**gameOver variable of Level*/
    boolean gameOver = false;
    
    /**currentPiece variable of Level*/
    public int currentPiece = 0;
    
    /**currentRot variable of Level*/
    public int currentRot = 0;
    
    /**currentPieceX variable of Level*/
    public int currentPieceX = fieldWidth/2;
    
    /**currentPieceY variable of Level*/
    public int currentPieceY = 0;
    
    /**speed variable of Level*/
    int speed = 20;
    
    /**speedCount variable of Level*/
    int speedCount = 0;
    
    /**forceDown variable of Level*/
    boolean forceDown = false;
    
    /**rotateHold variable of Level*/
    public boolean rotateHold = true;
    
    /**pieceCount variable of Level*/
    int pieceCount = 0;
    
    /**score variable of Level*/
    int score = 0;
    
    /**vLines variable of Level*/
    private List<Integer> vLines = new ArrayList<>();
    
    /**random variable of Level*/
    private Random random;
    
    /**currentPieceColor variable of Level*/
    private Color currentPieceColor;
    
    /**pieceWidth variable of Level*/
    private int pieceWidth = 36;
    
    /**pieceHeight variable of Level*/
    private int pieceHeight = 30;
    
    /**currentPiecePaint variable of Level*/
    private GradientPaint currentPiecePaint;
    
    private Rectangle currentPieceRectA;
    
    /**currentPieceRect variable of Level*/
    private RoundRectangle2D currentPieceRect;
    
    /**gradientPaintRed variable of Level*/
    private final GradientPaint gradientPaintRed = new GradientPaint(0, 0, Color.BLACK, 36, 30, Color.decode("#BF0000"), false);
    
    /**gradientPaintRed1 variable of Level*/
    private final GradientPaint gradientPaintRed1 = new GradientPaint(0, 15, Color.WHITE, pieceWidth, pieceHeight, Color.decode("#262626"), false);
    
    /**gradientPaintYellow variable of Level*/
    private final GradientPaint gradientPaintYellow = new GradientPaint(0, 15, Color.lightGray, pieceWidth, pieceHeight, Color.decode("#BFBF00"), false);
    
    /**gradientPaintGreen variable of Level*/
    private final GradientPaint gradientPaintGreen = new GradientPaint(0, 15, Color.lightGray, pieceWidth, pieceHeight, Color.decode("#00BF00"), false);
    
    /**gradientPaintBlue variable of Level*/
    private final GradientPaint gradientPaintBlue = new GradientPaint(0, 15, Color.lightGray, pieceWidth, pieceHeight, Color.decode("#00007F"), false);
    
    /**gradientPaintCyan variable of Level*/
    private final GradientPaint gradientPaintCyan = new GradientPaint(0, 15, Color.lightGray, pieceWidth, pieceHeight, Color.decode("#00BF60"), false);
    
    /**gradientPaintOrange variable of Level*/
    private final GradientPaint gradientPaintOrange = new GradientPaint(0, 15, Color.lightGray, pieceWidth, pieceHeight, Color.decode("#BF8000"), false);
    
    /**gradientPaintMagenta variable of Level*/
    private final GradientPaint gradientPaintMagenta = new GradientPaint(0, 15, Color.lightGray, pieceWidth, pieceHeight, Color.decode("#BF005F"), false);
    
    /**gradientPaintGray variable of Level*/
    private final GradientPaint gradientPaintGray = new GradientPaint(0, 15, Color.lightGray, pieceWidth, pieceHeight, Color.decode("#262626"), false);
    
    /**linesComplete variable of Level*/
    private int linesComplete = 0;
    
    /**backgroundColor variable of Level*/
    private Color backgroundColor = new Color(50,50,50,150);
    
    /**rectangleFG variable of Level*/
    private Color rectangleFG = new Color(60,60,60, 160);
    private long fallSpeed;
    
    
    
    
    /**Constructor*/
    
    /**
     * Level Constructor
     * 
     * @param lNo - level number of Level Object
     * @param w
     * @param h
     */
    public Level(int lNo, int w, int h){
        System.out.println("Level: New Level "+lNo+" Created");
        Game.labels = new Labels();
        //Game.hud = new HUD();
        levelNo = lNo;
        
        System.out.println("Level: Loading Level "+levelNo+" : "+getLevelName());
        
        //Create Player
        if(Player.getLives() > 0 && levelNo != 1){
            //set player lives to current player lives
            Game.player = new Player(Game.gameWidth/2 +10, Game.gameHeight - 120, 80, 80, Game.getPName(), Player.getLives());
        } else {
            //set player lives to 3
            Game.player = new Player(Game.gameWidth/2 +10, Game.gameHeight - 120, 80, 80, Game.getPName(), 1);
        }
        
        setUp();
        
        fallSpeed = 50;
        
        init();
    }
    
    
    /**
     * setUp()
     * 
     */
    private void setUp(){
        
        switch(levelNo){
            case 1:
                setUpLevel1();
                break;
            case 2:
                setUpLevel2();
                break;
            case 3:
                setUpLevel3();
                break;
            case 4:
                setUpLevel4();
                break;
            case 5:
                setUpLevel5();
                break;
            case 6:
                setUpLevel6();
                break;
            case 7:
                setUpLevel7();
                break;
            case 8:
                setUpLevel8();
                break;
            case 9:
                setUpLevel9();
                break;
        }
        
    }
    
    
    /**
     * setUpLevel1()
     * 
     */
    private void setUpLevel1() {
        int width = Tetris.getMainWidth();
        
        //Set Enemies Color
        //Set Enemy Color: White
//        Enemy.setEnemyCol(0xffffff);//White

        //Set Enemy Bullet Color: White
//        Bullet.setEnemyBulletCol(0xffffff);//White

        //Set Level Background: 1
        setBackground(1);//1: Moon(Small)
        
        //Set Barricade Color: Green
//        Barricade.setBarricadeCol(0x00ff00);//Green
        
        //Set Ground Color: Green
        setGroundColor(0x00ff00);//Green

        //Set Level Text Background Color: Green
//        levelTxtBGCol = 0x00ff00;//Green

        //Set Enter Level Icon Background Color: Light Green
//        enterLvlIconBG = 0x00CD02;//Light Green

        //Set Enter Level Icon Foreground Color: Crimson
//        enterLvlIconFG = 0x00B200;//Crimson
                
        switch(width){
            case 300:
                //Set Enemies
                //E0rows = 10, E1rows = 10, E2rows = 10, E3rows = 10, E4rows = 10, E5rows = 10, E6rows = 10, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(10, 10, 10, 10, 10, 10, 10, 0, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
//                //Set Enemy Color: White
//                Enemy.setEnemyCol(0xffffff);//White
//                
//                //Set Enemy Bullet Color: White
//                Bullet.setEnemyBulletCol(0xffffff);//White
//    
//                //Set Level Background: 1
//                setBackground(1);//1: Moon(Small)
            
                //Set Barricades
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **     **
                *  ****   ****   ****   ****
                *  ****   ****   ****   ****
                */
//                Barricade.setNoBarricades(4);
                
//                //Set Barricade Color: Green
//                Barricade.setBarricadeCol(0x00ff00);//Green
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
            
                //Set Ground
                //Set Ground Scale: 1.0
                groundScale = 1.0;
                
                //Set Ground POS: 4, Game.getGameHeight() - 140;
                groundX = 4;
                groundY = Tetris.getMainHeight() - 140;
                
//                //Set Ground Color: Green
//                setGroundColor(0x00ff00);//Green
//                
//                //Set Level Text Background Color: Green
//                levelTxtBGCol = 0x00ff00;//Green
//                
//                //Set Enter Level Icon Background Color: Light Green
//                enterLvlIconBG = 0x00CD02;//Light Green
//                
//                //Set Enter Level Icon Foreground Color: Crimson
//                enterLvlIconFG = 0x00B200;//Crimson
                
                break;
                
            case 480:
                //Set Enemies
                //E0rows = 10, E1rows = 10, E2rows = 10, E3rows = 10, E4rows = 10, E5rows = 10, E6rows = 10, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(10, 10, 10, 10, 10, 10, 10, 0, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
//                //Set Enemy Color: White
//                Enemy.setEnemyCol(0xffffff);//White
//                
//                //Set Enemy Bullet Color: White
//                Bullet.setEnemyBulletCol(0xffffff);//White
//    
//                //Set Level Background: 1
//                setBackground(1);//1: Moon(Small)
            
                //Set Barricades
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **     **
                *  ****   ****   ****   ****
                *  ****   ****   ****   ****
                */
//                Barricade.setNoBarricades(4);
                
//                //Set Barricade Color: Green
//                Barricade.setBarricadeCol(0x00ff00);//Green
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 1.25
                groundScale = 1.25;
                
                //Set Ground POS: 10, Game.getGameHeight() - 140
                groundX = 10;
                groundY = Tetris.getMainHeight() - 140;
                
//                //Set Ground Color: Green
//                setGroundColor(0x00ff00);//Green
//                
//                //Set Level Text Background Color: Green
//                levelTxtBGCol = 0x00ff00;//Green
//                
//                //Set Enter Level Icon Background Color: Light Green
//                enterLvlIconBG = 0x00CD02;//Light Green
//                
//                //Set Enter Level Icon Foreground Color: Crimson
//                enterLvlIconFG = 0x00B200;//Crimson
                
                break;
                
            case 604:
                //Set Enemies
                //E0rows = 10, E1rows = 10, E2rows = 10, E3rows = 10, E4rows = 10, E5rows = 10, E6rows = 10, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(10, 10, 10, 10, 10, 10, 10, 0, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
//                //Set Enemy Color: White
//                Enemy.setEnemyCol(0xffffff);//White
//                
//                //Set Enemy Bullet Color: White
//                Bullet.setEnemyBulletCol(0xffffff);//White
//    
//                //Set Level Background: 1
//                setBackground(1);//1: Moon(Small)
            
                //Set Barricades
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **     **
                *  ****   ****   ****   ****
                *  ****   ****   ****   ****
                */
//                Barricade.setNoBarricades(4);
                
//                //Set Barricade Color: Green
//                Barricade.setBarricadeCol(0x00ff00);//Green
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140
                groundX = -14;
                groundY = Tetris.getMainHeight() - 140;
                
//                //Set Ground Color: Green
//                setGroundColor(0x00ff00);//Green
//                
//                //Set Level Text Background Color: Green
//                levelTxtBGCol = 0x00ff00;//Green
//                
//                //Set Enter Level Icon Background Color: Light Green
//                enterLvlIconBG = 0x00CD02;//Light Green
//                
//                //Set Enter Level Icon Foreground Color: Crimson
//                enterLvlIconFG = 0x00B200;//Crimson
                
                break;
                
            default:
                //Set Enemies
                //E0rows = 10, E1rows = 10, E2rows = 10, E3rows = 10, E4rows = 10, E5rows = 10, E6rows = 10, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(10, 10, 10, 10, 10, 10, 10, 0, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
//                //Set Enemy Color: White
//                Enemy.setEnemyCol(0xffffff);//White
//                
//                //Set Enemy Bullet Color: White
//                Bullet.setEnemyBulletCol(0xffffff);//White
//    
//                //Set Level Background: 1
//                setBackground(1);//1: Moon(Small)
            
                //Set Barricades
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **     **
                *  ****   ****   ****   ****
                *  ****   ****   ****   ****
                */
//                Barricade.setNoBarricades(4);
                
//                //Set Barricade Color: Green
//                Barricade.setBarricadeCol(0x00ff00);//Green
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140
                groundX = -14;
                groundY = Tetris.getMainHeight() - 140;
                
//                //Set Ground Color: Green
//                setGroundColor(0x00ff00);//Green
//                
//                //Set Level Text Background Color: Green
//                levelTxtBGCol = 0x00ff00;//Green
//                
//                //Set Enter Level Icon Background Color: Light Green
//                enterLvlIconBG = 0x00CD02;//Light Green
//                
//                //Set Enter Level Icon Foreground Color: Crimson
//                enterLvlIconFG = 0x00B200;//Crimson
                
                break;
                
        }
        
    }

    
    /**
     * setUpLevel2()
     * 
     */
    private void setUpLevel2(){
        int width = Tetris.getMainWidth();
        
        //Set Enemy Color: Red
//        Enemy.setEnemyCol(0xff0000);//Red

        //Set Enemy Bullet Color: Red
//        Bullet.setEnemyBulletCol(0xff0000);//Red

        //Set Level Background: 2
        setBackground(2);//2: Mars(Small)
        
        //Set Ground Color: Maroon
        setGroundColor(0x800000);

        //Set Level Text Background Color: Maroon
//        levelTxtBGCol = 0x800000;//Maroon

        //Set Enter Level Icon Background Color: Indian Red
//        enterLvlIconBG = 0xCD5C5C;//Indian Red

        //Set Enter Level Icon Foreground Color: Crimson
//        enterLvlIconFG = 0xDC100C;//Crimson
        
        switch(width){
            case 300:
                //Set Enemies
                //E0rows = 11, E1rows = 11, E2rows = 11, E3rows = 9, E4rows = 7, E5rows = 5, E6rows = 5, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   ***********
                *   ***********
                *    *********
                *     *******
                *      *****
                *      *****
                *   
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(11, 11, 11, 9, 7, 5, 5, 0, 0, 0);
                
                //Set Enemy UFOfreq: 8
//                Enemy.setUFOFreq(8);
                
//                //Set Enemy Color: Red
//                Enemy.setEnemyCol(0xff0000);//Red
//                
//                //Set Enemy Bullet Color: Red
//                Bullet.setEnemyBulletCol(0xff0000);//Red
//    
//                //Set Level Background: 2
//                setBackground(2);//2: Mars(Small)
            
                //Set Barricades
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *      **     **
                *     ****   ****
                *     ****   ****
                */
//                Barricade.setNoBarricades(2);
                
                //Set Barricade Color: Indian Red
//                Barricade.setBarricadeCol(0xCD5C5C);//Indian Red
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
            
                //Set Ground
                //Set Ground Scale: 1.0
                groundScale = 1.0;
                
                //Set Ground POS: 4, Game.getGameHeight() - 140;
                groundX = 4;
                groundY = Tetris.getMainHeight() - 140;
//                
//                //Set Ground Color: Maroon
//                setGroundColor(0x800000);
//                
//                //Set Level Text Background Color: Maroon
//                levelTxtBGCol = 0x800000;//Maroon
//                
//                //Set Enter Level Icon Background Color: Indian Red
//                enterLvlIconBG = 0xCD5C5C;//Indian Red
//                
//                //Set Enter Level Icon Foreground Color: Crimson
//                enterLvlIconFG = 0xDC100C;//Crimson
                
                break;
                
            case 480:
                //Set Enemies
                //E0rows = 11, E1rows = 11, E2rows = 11, E3rows = 9, E4rows = 7, E5rows = 5, E6rows = 5, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   ***********
                *   ***********
                *    *********
                *     *******
                *      *****
                *      *****
                *   
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(11, 11, 11, 9, 7, 5, 5, 0, 0, 0);
                
                //Set Enemy UFOfreq: 8
//                Enemy.setUFOFreq(8);
                
//                //Set Enemy Color: Red
//                Enemy.setEnemyCol(0xff0000);//Red
//                
//                //Set Enemy Bullet Color: Red
//                Bullet.setEnemyBulletCol(0xff0000);//Red
//    
//                //Set Level Background: 2
//                setBackground(2);//2: Mars(Small)
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *      **     **
                *     ****   ****
                *     ****   ****
                */
//                Barricade.setNoBarricades(2);
                
                //Set Barricade Color: Indian Red
//                Barricade.setBarricadeCol(0xCD5C5C);//Indian Red
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 1.25
                groundScale = 1.25;
                
                //Set Ground POS: 10, Game.getGameHeight() - 140;
                groundX = 10;
                groundY = Tetris.getMainHeight() - 140;
                
//                //Set Ground Color: Maroon
//                setGroundColor(0x800000);//Maroon
//                
//                //Set Level Text Background Color: Maroon
//                levelTxtBGCol = 0x800000;//Maroon
//                
//                //Set Enter Level Icon Background Color: Indian Red
//                enterLvlIconBG = 0xCD5C5C;//Indian Red
//                
//                //Set Enter Level Icon Foreground Color: Crimson
//                enterLvlIconFG = 0xDC100C;//Crimson
                
                break;
                
            case 604:
                //Set Enemies
                //E0rows = 11, E1rows = 11, E2rows = 11, E3rows = 9, E4rows = 7, E5rows = 5, E6rows = 5, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   ***********
                *   ***********
                *    *********
                *     *******
                *      *****
                *      *****
                *   
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(11, 11, 11, 9, 7, 5, 5, 0, 0, 0);
                
                //Set Enemy UFOfreq: 8
//                Enemy.setUFOFreq(8);
                
//                //Set Enemy Color: Red
//                Enemy.setEnemyCol(0xff0000);//Red
//                
//                //Set Enemy Bullet Color: Red
//                Bullet.setEnemyBulletCol(0xff0000);//Red
//    
//                //Set Level Background: 2
//                setBackground(2);//2: Mars(Small)
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *      **     **
                *     ****   ****
                *     ****   ****
                */
//                Barricade.setNoBarricades(2);
                
//                //Set Barricade Color: Indian Red
//                Barricade.setBarricadeCol(0xCD5C5C);//Indian Red
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Tetris.getMainHeight() - 140;
                
//                //Set Ground Color: Maroon
//                setGroundColor(0x800000);//Maroon
//                
//                //Set Level Text Background Color: Maroon
//                levelTxtBGCol = 0x800000;//Maroon
//                
//                //Set Enter Level Icon Background Color: Indian Red
//                enterLvlIconBG = 0xCD5C5C;//Indian Red
//                
//                //Set Enter Level Icon Foreground Color: Crimson
//                enterLvlIconFG = 0xDC100C;//Crimson
                
                break;
                
            default:
                //Set Enemies
                //E0rows = 11, E1rows = 11, E2rows = 11, E3rows = 9, E4rows = 7, E5rows = 5, E6rows = 5, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   ***********
                *   ***********
                *    *********
                *     *******
                *      *****
                *      *****
                *   
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(11, 11, 11, 9, 7, 5, 5, 0, 0, 0);
                
                //Set Enemy UFOfreq: 8
//                Enemy.setUFOFreq(8);
                
//                //Set Enemy Color: Red
//                Enemy.setEnemyCol(0xff0000);//Red
//                
//                //Set Enemy Bullet Color: Red
//                Bullet.setEnemyBulletCol(0xff0000);//Red
//    
//                //Set Level Background: 2
//                setBackground(2);//2: Mars(Small)
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *      **     **
                *     ****   ****
                *     ****   ****
                */
//                Barricade.setNoBarricades(2);
                
//                //Set Barricade Color: Indian Red
//                Barricade.setBarricadeCol(0xCD5C5C);//Indian Red
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Tetris.getMainHeight() - 140;
                
//                //Set Ground Color: Maroon
//                setGroundColor(0x800000);//Maroon
//                
//                //Set Level Text Background Color: Maroon
//                levelTxtBGCol = 0x800000;//Maroon
//                
//                //Set Enter Level Icon Background Color: Indian Red
//                enterLvlIconBG = 0xCD5C5C;//Indian Red
//                
//                //Set Enter Level Icon Foreground Color: Crimson
//                enterLvlIconFG = 0xDC100C;//Crimson
                
                break;
        }
        
    }
    
    
    /**
     * setUpLevel3()
     * 
     */
    private void setUpLevel3(){
        int width = Tetris.getMainWidth();
        
        //Set Enemy Color: Cadet Blue
//        Enemy.setEnemyCol(0x5F9EA0);//Cadet Blue

        //Set Enemy Bullet Color: Green
//        Bullet.setEnemyBulletCol(0x00ff00);//Green

        //Set Level Background: 3
        setBackground(3);//3: Earth(Small)
        
        //Set Barricade Color: Blue
//        Barricade.setBarricadeCol(0x0000ff);//Blue
        
        //Set Ground Color: Medium Blue
        setGroundColor(0x0000dd);//Medium Blue

        //Set Level Text Background Color: Medium Blue
//        levelTxtBGCol = 0x0000dd;//Medium Blue

        //Set Enter Level Icon Background Color: Green Blue
//        enterLvlIconBG = 0x00d5fc;//Green Blue

        //Set Enter Level Icon Foreground Color: Dark Green blue
//        enterLvlIconFG = 0xc0c0c0;//Dark Green blue
        
        switch(width){
            case 300:
                //Set Enemies
                //E0rows = 0, E1rows = 11, E2rows = 11, E3rows = 11, E4rows = 0, E5rows = 11, E6rows = 11, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   
                *   ***********
                *   ***********
                *   ***********
                *   
                *   ***********
                *   ***********
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(0, 11, 11, 11, 0, 11, 11, 0, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
//                //Set Enemy Color: Cadet Blue
//                Enemy.setEnemyCol(0x5F9EA0);//Cadet Blue
//                
//                //Set Enemy Bullet Color: Green
//                Bullet.setEnemyBulletCol(0x00ff00);//Green
//    
//                //Set Level Background: 3
//                setBackground(3);//3: Earth(Small)
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
//                //Set Barricade Color: Blue
//                Barricade.setBarricadeCol(0x0000ff);//Blue
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
            
                //Set Ground
                //Set Ground Scale: 1.0
                groundScale = 1.0;
                
                //Set Ground POS: 4, Game.getGameHeight() - 140;
                groundX = 4;
                groundY = Tetris.getMainHeight() - 140;
                
//                //Set Ground Color: Medium Blue
//                setGroundColor(0x0000dd);//Medium Blue
//                
//                //Set Level Text Background Color: Medium Blue
//                levelTxtBGCol = 0x0000dd;//Medium Blue
//                
//                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
//                
//                //Set Enter Level Icon Foreground Color: Dark Green blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            case 480:
                //E0rows = 0, E1rows = 11, E2rows = 11, E3rows = 11, E4rows = 0, E5rows = 11, E6rows = 11, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   
                *   ***********
                *   ***********
                *   ***********
                *   
                *   ***********
                *   ***********
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(0, 11, 11, 11, 0, 11, 11, 0, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
//                //Set Enemy Color: Cadet Blue
//                Enemy.setEnemyCol(0x5F9EA0);//Cadet Blue
//                
//                //Set Enemy Bullet Color: Green
//                Bullet.setEnemyBulletCol(0x00ff00);//Green
//    
//                //Set Level Background: 3
//                setBackground(3);//3: Earth(Small)
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
//                //Set Barricade Color: Blue
//                Barricade.setBarricadeCol(0x0000ff);//Blue
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 1.25
                groundScale = 1.25;
                
                //Set Ground POS: 10, Game.getGameHeight() - 140;
                groundX = 10;
                groundY = Tetris.getMainHeight() - 140;
                
//                //Set Ground Color: Medium Blue
//                setGroundColor(0x0000dd);//Medium Blue
//                
//                //Set Level Text Background Color: Medium Blue
//                levelTxtBGCol = 0x0000dd;//Medium Blue
//                
//                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
//                
//                //Set Enter Level Icon Foreground Color: Dark Green blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            case 604:
                //E0rows = 0, E1rows = 11, E2rows = 11, E3rows = 11, E4rows = 0, E5rows = 11, E6rows = 11, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   
                *   ***********
                *   ***********
                *   ***********
                *   
                *   ***********
                *   ***********
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(0, 11, 11, 11, 0, 11, 11, 0, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
//                //Set Enemy Color: Cadet Blue
//                Enemy.setEnemyCol(0x5F9EA0);//Cadet Blue
//                
//                //Set Enemy Bullet Color: Green
//                Bullet.setEnemyBulletCol(0x00ff00);//Green
//    
//                //Set Level Background: 3
//                setBackground(3);//3: Earth(Small)
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
//                //Set Barricade Color: Blue
//                Barricade.setBarricadeCol(0x0000ff);//Blue
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Tetris.getMainHeight() - 140;
                
//                //Set Ground Color: Medium Blue
//                setGroundColor(0x0000dd);//Medium Blue
//                
//                //Set Level Text Background Color: Medium Blue
//                levelTxtBGCol = 0x0000dd;//Medium Blue
//                
//                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
//                
//                //Set Enter Level Icon Foreground Color: Dark Green blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            default:
                //E0rows = 0, E1rows = 11, E2rows = 11, E3rows = 11, E4rows = 0, E5rows = 11, E6rows = 11, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   
                *   ***********
                *   ***********
                *   ***********
                *   
                *   ***********
                *   ***********
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(0, 11, 11, 11, 0, 11, 11, 0, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
//                //Set Enemy Color: Cadet Blue
//                Enemy.setEnemyCol(0x5F9EA0);//Cadet Blue
//                
//                //Set Enemy Bullet Color: Green
//                Bullet.setEnemyBulletCol(0x00ff00);//Green
//    
//                //Set Level Background: 3
//                setBackground(3);//3; Earth(Small)
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
//                //Set Barricade Color: Blue
//                Barricade.setBarricadeCol(0x0000ff);//Blue
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Tetris.getMainHeight() - 140;
                
//                //Set Ground Color: Medium Blue
//                setGroundColor(0x0000dd);//Medium Blue
//                
//                //Set Level Text Background Color: Medium Blue
//                levelTxtBGCol = 0x0000dd;//Medium Blue
//                
//                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
//                
//                //Set Enter Level Icon Foreground Color: Dark Green blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
        }
        
    }
    
    
    /**
     * setUpLevel4()
     * 
     */
    private void setUpLevel4(){
        int width = Tetris.getMainWidth();
        switch(width){
            case 300:
                //Set Enemies
                //E0rows = 11, E1rows = 6, E2rows = 11, E3rows = 11, E4rows = 6, E5rows = 11, E6rows = 4, E7rows = 0, E8rows = 0, E9rows = 2;
                /**
                *   ***********
                *     ******
                *   ***********
                *   ***********
                *     ******
                *   ***********
                *      ****
                * 
                * 
                *       **
                */
//                Enemy.setNoEnemy(11, 6, 11, 11, 6, 11, 4, 0, 0, 2);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: 0xf7cb07
//                Enemy.setEnemyCol(0xf7cb07);
                
                //Set Enemy Bullet Color: 0xf7cb07
//                Bullet.setEnemyBulletCol(0xf7cb07);
    
                //Set Level Background: 4
                setBackground(4);//4: Sun
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Red
//                Barricade.setBarricadeCol(0xff0000);//Red
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
            
                //Set Ground
                //Set Ground Scale: 1.0
                groundScale = 1.0;
                
                //Set Ground POS: 4, Game.getGameHeight() - 140;
                groundX = 4;
                groundY = Tetris.getMainHeight() - 140;
                
                //Set Ground Color: OrangeRed
                setGroundColor(0xFF4500);//OrangeRed
                
                //Set Level Text Background Color: OrangeRed
//                levelTxtBGCol = 0xFF4500;//OrangeRed
                
                //Set Enter Level Icon Background Color: Orange
//                enterLvlIconBG = 0xFFA500;//Orange
                
                //Set Enter Level Icon Foreground Color: Gold
//                enterLvlIconFG = 0xffd700;//Gold
                
                break;
                
            case 480:
                //E0rows = 11, E1rows = 6, E2rows = 11, E3rows = 11, E4rows = 6, E5rows = 11, E6rows = 4, E7rows = 0, E8rows = 0, E9rows = 2;
                /**
                *   ***********
                *     ******
                *   ***********
                *   ***********
                *     ******
                *   ***********
                *      ****
                * 
                * 
                *       **
                */
//                Enemy.setNoEnemy(11, 6, 11, 11, 6, 11, 4, 0, 0, 2);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: 0xf7cb07
//                Enemy.setEnemyCol(0xf7cb07);
                
                //Set Enemy Bullet Color: 0xf7cb07
//                Bullet.setEnemyBulletCol(0xf7cb07);
    
                //Set Level Background: 4
                setBackground(4);//4: Sun
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Red
//                Barricade.setBarricadeCol(0xff0000);//Red
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 1.25
                groundScale = 1.25;
                
                //Set Ground POS: 10, Game.getGameHeight() - 140;
                groundX = 10;
                groundY = Tetris.getMainHeight() - 140;
                
                //Set Ground Color: OrangeRed
                setGroundColor(0xFF4500);//OrangeRed
                
                //Set Level Text Background Color: OrangeRed
//                levelTxtBGCol = 0xFF4500;//OrangeRed
                
                //Set Enter Level Icon Background Color: Orange
//                enterLvlIconBG = 0xFFA500;//Orange
                
                //Set Enter Level Icon Foreground Color: Gold
//                enterLvlIconFG = 0xffd700;//Gold
                
                break;
                
            case 604:
                //E0rows = 11, E1rows = 6, E2rows = 11, E3rows = 11, E4rows = 6, E5rows = 11, E6rows = 4, E7rows = 0, E8rows = 0, E9rows = 2;
                /**
                *   ***********
                *     ******
                *   ***********
                *   ***********
                *     ******
                *   ***********
                *      ****
                * 
                * 
                *       **
                */
//                Enemy.setNoEnemy(11, 6, 11, 11, 6, 11, 4, 0, 0, 2);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: 0xf7cb07
//                Enemy.setEnemyCol(0xf7cb07);
                
                //Set Enemy Bullet Color: 0xf7cb07
//                Bullet.setEnemyBulletCol(0xf7cb07);
    
                //Set Level Background: 4
                setBackground(4);//4: Sun
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Red
//                Barricade.setBarricadeCol(0xff0000);//Red
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Tetris.getMainHeight() - 140;
                
                //Set Ground Color: OrangeRed
                setGroundColor(0xFF4500);//OrangeRed
                
                //Set Level Text Background Color: OrangeRed
//                levelTxtBGCol = 0xFF4500;//OrangeRed
                
                //Set Enter Level Icon Background Color: Orange
//                enterLvlIconBG = 0xFFA500;//Orange
                
                //Set Enter Level Icon Foreground Color: Gold
//                enterLvlIconFG = 0xffd700;//Gold
                
                break;
                
            default:
                //E0rows = 11, E1rows = 6, E2rows = 11, E3rows = 11, E4rows = 6, E5rows = 11, E6rows = 4, E7rows = 0, E8rows = 0, E9rows = 2;
                /**
                *   ***********
                *     ******
                *   ***********
                *   ***********
                *     ******
                *   ***********
                *      ****
                * 
                * 
                *       **
                */
//                Enemy.setNoEnemy(11, 6, 11, 11, 6, 11, 4, 0, 0, 2);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: 0xf7cb07
//                Enemy.setEnemyCol(0xf7cb07);
                
                //Set Enemy Bullet Color: 0xf7cb07
//                Bullet.setEnemyBulletCol(0xf7cb07);
    
                //Set Level Background: 4
                setBackground(4);//4: Sun
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Red
//                Barricade.setBarricadeCol(0xff0000);//Red
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Tetris.getMainHeight() - 140;
                
                //Set Ground Color: OrangeRed
                setGroundColor(0xFF4500);//OrangeRed
                
                //Set Level Text Background Color: OrangeRed
//                levelTxtBGCol = 0xFF4500;//OrangeRed
                
                //Set Enter Level Icon Background Color: Orange
//                enterLvlIconBG = 0xFFA500;//Orange
                
                //Set Enter Level Icon Foreground Color: Gold
//                enterLvlIconFG = 0xffd700;//Gold
                
                break;
        }
        
    }
    
    
    /**
     * setUpLevel5()
     * 
     */
    private void setUpLevel5() {
        int width = Tetris.getMainWidth();
        switch(width){
            case 300:
                //Set Enemies
                //E0rows = 5, E1rows = 5, E2rows = 11, E3rows = 10, E4rows = 7, E5rows = 7, E6rows = 4, E7rows = 10, E8rows = 0, E9rows = 0;
                /**
                *      *****
                *      *****
                *   ***********
                *   **********
                *     *******
                *     *******
                *      ****
                *   **********
                * 
                *   
                */
//                Enemy.setNoEnemy(5, 5, 11, 10, 7, 7, 4, 10, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: Grey
//                Enemy.setEnemyCol(0x778899);//Grey
                
                //Set Enemy Bullet Color: Dark Grey
//                Bullet.setEnemyBulletCol(0x2F4FFF);//Dark Grey
    
                //Set Level Background: 1
                setBackground(1);//1: Moon
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Dark Grey
//                Barricade.setBarricadeCol(0x090909);//Dark Grey
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
            
                //Set Ground
                //Set Ground Scale: 1.0
                groundScale = 1.0;
                
                //Set Ground POS: 4, Game.getGameHeight() - 140;
                groundX = 4;
                groundY = Tetris.getMainHeight() - 140;
                
                //Set Ground Color: Grey
                setGroundColor(0x696969);//Grey
                
                //Set Level Text Background Color: Grey
//                levelTxtBGCol = 0x696969;//Grey
                
                //Set Enter Level Icon Background Color: Grey
//                enterLvlIconBG = 0x696969;//Grey
                
                //Set Enter Level Icon Foreground Color: Dark Grey
//                enterLvlIconFG = 0x090909;//Dark Grey
                
                break;
                
            case 480:
                //E0rows = 5, E1rows = 5, E2rows = 11, E3rows = 10, E4rows = 7, E5rows = 7, E6rows = 4, E7rows = 10, E8rows = 0, E9rows = 0;
                /**
                *      *****
                *      *****
                *   ***********
                *   **********
                *     *******
                *     *******
                *      ****
                *   **********
                * 
                *   
                */
//                Enemy.setNoEnemy(5, 5, 11, 10, 7, 7, 4, 10, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: Grey
//                Enemy.setEnemyCol(0x778899);//Grey
                
                //Set Enemy Bullet Color: Dark Grey
//                Bullet.setEnemyBulletCol(0x2F4FFF);//Dark Grey
    
                //Set Level Background: 1
                setBackground(1);//1: Moon
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Dark Grey
//                Barricade.setBarricadeCol(0x090909);//Dark Grey
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 1.25
                groundScale = 1.25;
                
                //Set Ground POS: 10, Game.getGameHeight() - 140;
                groundX = 10;
                groundY = Tetris.getMainHeight() - 140;
                
                //Set Ground Color: Grey
                setGroundColor(0x696969);//Grey
                
                //Set Level Text Background Color: Grey
//                levelTxtBGCol = 0x696969;//Grey
                
                //Set Enter Level Icon Background Color: Grey
//                enterLvlIconBG = 0x696969;//Grey
                
                //Set Enter Level Icon Foreground Color: Dark Grey
//                enterLvlIconFG = 0x090909;//Dark Grey
                
                break;
                
            case 604:
                //E0rows = 5, E1rows = 5, E2rows = 11, E3rows = 10, E4rows = 7, E5rows = 7, E6rows = 4, E7rows = 10, E8rows = 0, E9rows = 0;
                /**
                *      *****
                *      *****
                *   ***********
                *   **********
                *     *******
                *     *******
                *      ****
                *   **********
                * 
                *   
                */
//                Enemy.setNoEnemy(5, 5, 11, 10, 7, 7, 4, 10, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: Grey
//                Enemy.setEnemyCol(0x778899);//Grey
                
                //Set Enemy Bullet Color: Dark Grey
//                Bullet.setEnemyBulletCol(0x2F4F4F);//Dark Grey
    
                //Set Level Background: 1
                setBackground(1);//1: Moon
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Dark Grey
//                Barricade.setBarricadeCol(0x090909);//Dark Grey
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Tetris.getMainHeight() - 140;
                
                //Set Ground Color: Grey
                setGroundColor(0x696969);//Grey
                
                //Set Level Text Background Color: Grey
//                levelTxtBGCol = 0x696969;//Grey
                
                //Set Enter Level Icon Background Color: Grey
//                enterLvlIconBG = 0x696969;//Grey
                
                //Set Enter Level Icon Foreground Color: Dark Grey
//                enterLvlIconFG = 0x090909;//Dark Grey
                
                break;
                
            default:
                //E0rows = 5, E1rows = 5, E2rows = 11, E3rows = 10, E4rows = 7, E5rows = 7, E6rows = 4, E7rows = 10, E8rows = 0, E9rows = 0;
                /**
                *      *****
                *      *****
                *   ***********
                *   **********
                *     *******
                *     *******
                *      ****
                *   **********
                * 
                *   
                */
//                Enemy.setNoEnemy(5, 5, 11, 10, 7, 7, 4, 10, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: Grey
//                Enemy.setEnemyCol(0x778899);//Grey
                
                //Set Enemy Bullet Color: Dark Grey
//                Bullet.setEnemyBulletCol(0x2F4F4F);//Dark Grey
    
                //Set Level Background: 1
                setBackground(1);
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Dark Grey
//                Barricade.setBarricadeCol(0x090909);//Dark Grey
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Tetris.getMainHeight() - 140;
                
                //Set Ground Color: Grey
                setGroundColor(0x696969);//Grey
                
                //Set Level Text Background Color: Grey
//                levelTxtBGCol = 0x696969;//Grey
                
                //Set Enter Level Icon Background Color: Grey
//                enterLvlIconBG = 0x696969;//Grey
                
                //Set Enter Level Icon Foreground Color: Dark Grey
//                enterLvlIconFG = 0x090909;//Dark Grey
                
                break;
        }
        
    }
    
    
    /**
     * setUpLevel6()
     * 
     */
    private void setUpLevel6(){
        int width = Tetris.getMainWidth();
        switch(width){
            case 300:
                //Set Enemies
                //E0rows = 6, E1rows = 6, E2rows = 6, E3rows = 6, E4rows = 6, E5rows = 6, E6rows = 10, E7rows = 4, E8rows = 0, E9rows = 0;
                /**
                *     ******
                *     ******
                *     ******
                *     ******
                *     ******
                *     ******
                *   **********
                *      ****
                * 
                *   
                */
//                Enemy.setNoEnemy(6, 6, 6, 6, 6, 6, 10, 4, 0, 0);
                
                //Set Enemy UFOfreq: 8
//                Enemy.setUFOFreq(8);
                
                //Set Enemy Color: Crimson
//                Enemy.setEnemyCol(0xDC1000);//Crimson
                
                //Set Enemy Bullet Color: Red
//                Bullet.setEnemyBulletCol(0xff0000);//Red
    
                //Set Level Background: 2
                setBackground(2);//2: Mars
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *      **     **
                *     ****   ****
                *     ****   ****
                */
//                Barricade.setNoBarricades(2);
                
                //Set Barricade Color: Red
//                Barricade.setBarricadeCol(0xff0000);//Red
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
            
                //Set Ground
                //Set Ground Scale: 1.0
                groundScale = 1.0;
                
                //Set Ground POS: 4, Game.getGameHeight() - 140;
                groundX = 4;
                groundY = Tetris.getMainHeight() - 140;
                
                //Set Ground Color: Maroon
                setGroundColor(0x800000);//Maroon
                
                //Set Level Text Background Color: Maroon
//                levelTxtBGCol = 0x800000;//Maroon
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            case 480:
                //E0rows = 6, E1rows = 6, E2rows = 6, E3rows = 6, E4rows = 6, E5rows = 6, E6rows = 10, E7rows = 4, E8rows = 0, E9rows = 0;
                /**
                *     ******
                *     ******
                *     ******
                *     ******
                *     ******
                *     ******
                *   **********
                *      ****
                * 
                *   
                */
//                Enemy.setNoEnemy(6, 6, 6, 6, 6, 6, 10, 4, 0, 0);
                
                //Set Enemy UFOfreq: 8
//                Enemy.setUFOFreq(8);
                
                //Set Enemy Color: Crimson
//                Enemy.setEnemyCol(0xDC1000);//Crimson
                
                //Set Enemy Bullet Color: Red
//                Bullet.setEnemyBulletCol(0xff0000);//Red
    
                //Set Level Background: 2
                setBackground(2);//2: Mars
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *      **     **
                *     ****   ****
                *     ****   ****
                */
//                Barricade.setNoBarricades(2);
                
                //Set Barricade Color: Red
//                Barricade.setBarricadeCol(0xff0000);//Red
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 1.25
                groundScale = 1.25;
                
                //Set Ground POS: 10, Game.getGameHeight() - 140;
                groundX = 10;
                groundY = Tetris.getMainHeight() - 140;
                
                //Set Ground Color: Maroon
                setGroundColor(0x800000);//Maroon
                
                //Set Level Text Background Color: Maroon
//                levelTxtBGCol = 0x800000;//Maroon
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            case 604:
                //E0rows = 6, E1rows = 6, E2rows = 6, E3rows = 6, E4rows = 6, E5rows = 6, E6rows = 10, E7rows = 4, E8rows = 0, E9rows = 0;
                /**
                *     ******
                *     ******
                *     ******
                *     ******
                *     ******
                *     ******
                *   **********
                *      ****
                * 
                *   
                */
//                Enemy.setNoEnemy(6, 6, 6, 6, 6, 6, 10, 4, 0, 0);
                
                //Set Enemy UFOfreq: 8
//                Enemy.setUFOFreq(8);
                
                //Set Enemy Color: Crimson
//                Enemy.setEnemyCol(0xDC1000);//Crimson
                
                //Set Enemy Bullet Color: Red
//                Bullet.setEnemyBulletCol(0xff0000);//Red
    
                //Set Level Background: 2
                setBackground(2);//2: Mars
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *      **     **
                *     ****   ****
                *     ****   ****
                */
//                Barricade.setNoBarricades(2);
                
                //Set Barricade Color: Red
//                Barricade.setBarricadeCol(0xff0000);//Red
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Tetris.getMainHeight() - 140;
                
                //Set Ground Color: Maroon
                setGroundColor(0x800000);//Maroon
                
                //Set Level Text Background Color: Maroon
//                levelTxtBGCol = 0x800000;//Maroon
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            default:
                //E0rows = 6, E1rows = 6, E2rows = 6, E3rows = 6, E4rows = 6, E5rows = 6, E6rows = 10, E7rows = 4, E8rows = 0, E9rows = 0;
                /**
                *     ******
                *     ******
                *     ******
                *     ******
                *     ******
                *     ******
                *   **********
                *      ****
                * 
                *   
                */
//                Enemy.setNoEnemy(6, 6, 6, 6, 6, 6, 10, 4, 0, 0);
                
                //Set Enemy UFOfreq: 8
//                Enemy.setUFOFreq(8);
                
                //Set Enemy Color: Crimson
//                Enemy.setEnemyCol(0xDC1000);//Crimson
                
                //Set Enemy Bullet Color: Red
//                Bullet.setEnemyBulletCol(0xff0000);//Red
    
                //Set Level Background: 2
                setBackground(2);//2: Mars
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *      **     **
                *     ****   ****
                *     ****   ****
                */
//                Barricade.setNoBarricades(2);
                
                //Set Barricade Color: Red
//                Barricade.setBarricadeCol(0xff0000);//Red
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Tetris.getMainHeight() - 140;
                
                //Set Ground Color: Maroon
                setGroundColor(0x800000);//Maroon
                
                //Set Level Text Background Color: Maroon
//                levelTxtBGCol = 0x800000;//Maroon
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
        }
        
    }
    
    
    /**
     * setUpLevel7()
     * 
     */
    private void setUpLevel7(){
        int width = Tetris.getMainWidth();
        switch(width){
            case 300:
                //Set Enemies
                //E0rows = 10, E1rows = 2, E2rows = 10, E3rows = 8, E4rows = 10, E5rows = 6, E6rows = 9, E7rows = 6, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *       **
                *   **********
                *    ********
                *   **********
                *     ******
                *    *********
                *     ******
                * 
                *   
                */
//                Enemy.setNoEnemy(10, 2, 10, 8, 10, 6, 9, 6, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: 0xf7cb07
//                Enemy.setEnemyCol(0xf7cb07);
                
                //Set Enemy Bullet Color: 0xf7cb07
//                Bullet.setEnemyBulletCol(0xf7cb07);
    
                //Set Level Background: 4
                setBackground(4);//4: Sun
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Gold
//                Barricade.setBarricadeCol(0xFFD700);//Gold
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
            
                //Set Ground
                //Set Ground Scale: 1.0
                groundScale = 1.0;
                
                //Set Ground POS: 4, Game.getGameHeight() - 140;
                groundX = 4;
                groundY = Tetris.getMainHeight() - 140;
                
                //Set Ground Color: Red
                setGroundColor(0xff0000);//Red
                
                //Set Level Text Background Color: Red
//                levelTxtBGCol = 0xff0000;//Red
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            case 480:
                //E0rows = 10, E1rows = 2, E2rows = 10, E3rows = 8, E4rows = 10, E5rows = 6, E6rows = 9, E7rows = 6, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *       **
                *   **********
                *    ********
                *   **********
                *     ******
                *    *********
                *     ******
                * 
                *   
                */
//                Enemy.setNoEnemy(10, 2, 10, 8, 10, 6, 9, 6, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: 0xf7cb07
//                Enemy.setEnemyCol(0xf7cb07);
                
                //Set Enemy Bullet Color: 0xf7cb07
//                Bullet.setEnemyBulletCol(0xf7cb07);
    
                //Set Level Background: 4
                setBackground(4);//4: Sun
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Gold
//                Barricade.setBarricadeCol(0xFFD700);//Gold
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 1.25
                groundScale = 1.25;
                
                //Set Ground POS: 10, Game.getGameHeight() - 140;
                groundX = 10;
                groundY = Tetris.getMainHeight() - 140;
                
                //Set Ground Color: Red
                setGroundColor(0xff0000);//Red
                
                //Set Level Text Background Color: Red
//                levelTxtBGCol = 0xff0000;//Red
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            case 604:
                //E0rows = 10, E1rows = 2, E2rows = 10, E3rows = 8, E4rows = 10, E5rows = 6, E6rows = 9, E7rows = 6, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *       **
                *   **********
                *    ********
                *   **********
                *     ******
                *    *********
                *     ******
                * 
                *   
                */
//                Enemy.setNoEnemy(10, 2, 10, 8, 10, 6, 9, 6, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: 0xf7cb07
//                Enemy.setEnemyCol(0xf7cb07);
                
                //Set Enemy Bullet Color: 0xf7cb07
//                Bullet.setEnemyBulletCol(0xf7cb07);
    
                //Set Level Background: 4
                setBackground(4);//4: Sun
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Gold
//                Barricade.setBarricadeCol(0xFFD700);//Gold
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Tetris.getMainHeight() - 140;
                
                //Set Ground Color: Red
                setGroundColor(0xff0000);//Red
                
                //Set Level Text Background Color: Red
//                levelTxtBGCol = 0xff0000;//Red
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            default:
                //E0rows = 10, E1rows = 2, E2rows = 10, E3rows = 8, E4rows = 10, E5rows = 6, E6rows = 9, E7rows = 6, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *       **
                *   **********
                *    ********
                *   **********
                *     ******
                *    *********
                *     ******
                * 
                *   
                */
//                Enemy.setNoEnemy(10, 2, 10, 8, 10, 6, 9, 6, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: 0xf7cb07
//                Enemy.setEnemyCol(0xf7cb07);
                
                //Set Enemy Bullet Color: 0xf7cb07
//                Bullet.setEnemyBulletCol(0xf7cb07);
    
                //Set Level Background: 4
                setBackground(4);//4: Sun
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Gold
//                Barricade.setBarricadeCol(0xFFD700);//Gold
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Tetris.getMainHeight() - 140;
                
                //Set Ground Color: Red
                setGroundColor(0xff0000);//Red
                
                //Set Level Text Background Color: Red
//                levelTxtBGCol = 0xff0000;//Red
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
        }
        
    }
    
    
    /**
     * setUpLevel8()
     * 
     */
    private void setUpLevel8(){
        int width = Tetris.getMainWidth();
        Random random = new Random();
        switch(width){
            case 300:
                //Set Enemies
                //E0rows = 10, E1rows = 10, E2rows = 10, E3rows = 8, E4rows = 8, E5rows = 6, E6rows = 6, E7rows = 4, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *   **********
                *   **********
                *    ********
                *    ********
                *     ******
                *     ******
                *      ****
                * 
                *   
                */
//                Enemy.setNoEnemy(10, 10, 10, 8, 8, 6, 6, 4, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: Random Blue
//                Enemy.setEnemyCol(0x0000ff + random.nextInt(0x0000ff));//Random Blue
                
                //Set Enemy Bullet Color: Random Blue
//                Bullet.setEnemyBulletCol(0x0000ff + random.nextInt(0x0000ff));//Random Blue
    
                //Set Level Background: 3
                setBackground(3);//3: Earth
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Random Green
//                Barricade.setBarricadeCol(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
            
                //Set Ground
                //Set Ground Scale: 1.0
                groundScale = 1.0;
                
                //Set Ground POS: 4, Game.getGameHeight() - 140;
                groundX = 4;
                groundY = Tetris.getMainHeight() - 140;
                
                //Set Ground Color: Random Green
                setGroundColor(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
                //Set Level Text Background Color: Green
//                levelTxtBGCol = 0x00ff00;//Green
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            case 480:
                //E0rows = 10, E1rows = 10, E2rows = 10, E3rows = 8, E4rows = 8, E5rows = 6, E6rows = 6, E7rows = 4, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *   **********
                *   **********
                *    ********
                *    ********
                *     ******
                *     ******
                *      ****
                * 
                *   
                */
//                Enemy.setNoEnemy(10, 10, 10, 8, 8, 6, 6, 4, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: Random Blue
//                Enemy.setEnemyCol(0x0000ff + random.nextInt(0x0000ff));//Random Blue
                
                //Set Enemy Bullet Color: Random Blue
//                Bullet.setEnemyBulletCol(0x0000ff + random.nextInt(0x0000ff));//Random Blue
    
                //Set Level Background: 3
                setBackground(3);//3: Earth
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Random Green
//                Barricade.setBarricadeCol(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 1.25
                groundScale = 1.25;
                
                //Set Ground POS: 10, Game.getGameHeight() - 140;
                groundX = 10;
                groundY = Tetris.getMainHeight() - 140;
                
                //Set Ground Color: Random Green
                setGroundColor(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
                //Set Level Text Background Color: Green
//                levelTxtBGCol = 0x00ff00;//Green
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            case 604:
                //E0rows = 10, E1rows = 10, E2rows = 10, E3rows = 8, E4rows = 8, E5rows = 6, E6rows = 6, E7rows = 4, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *   **********
                *   **********
                *    ********
                *    ********
                *     ******
                *     ******
                *      ****
                * 
                *   
                */
//                Enemy.setNoEnemy(10, 10, 10, 8, 8, 6, 6, 4, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: Random Blue
//                Enemy.setEnemyCol(0x0000ff + random.nextInt(0x0000ff));//Random Blue
                
                //Set Enemy Bullet Color: Random Blue
//                Bullet.setEnemyBulletCol(0x0000ff + random.nextInt(0x0000ff));//Random Blue
    
                //Set Level Background: 3
                setBackground(3);//3: Earth
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Random Green
//                Barricade.setBarricadeCol(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Tetris.getMainHeight() - 140;
                
                //Set Ground Color: Random Green
                setGroundColor(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
                //Set Level Text Background Color: Green
//                levelTxtBGCol = 0x00ff00;//Green
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            default:
                //E0rows = 10, E1rows = 10, E2rows = 10, E3rows = 8, E4rows = 8, E5rows = 6, E6rows = 6, E7rows = 4, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *   **********
                *   **********
                *    ********
                *    ********
                *     ******
                *     ******
                *      ****
                * 
                *   
                */
//                Enemy.setNoEnemy(10, 10, 10, 8, 8, 6, 6, 4, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: Random Blue
//                Enemy.setEnemyCol(0x0000ff + random.nextInt(0x0000ff));//Random Blue
                
                //Set Enemy Bullet Color: Random Blue
//                Bullet.setEnemyBulletCol(0x0000ff + random.nextInt(0x0000ff));//Random Blue
    
                //Set Level Background: 3
                setBackground(3);//3: Earth
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Random Green
//                Barricade.setBarricadeCol(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
                //Set POW Scale: 0.75
//                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Tetris.getMainHeight() - 140;
                
                //Set Ground Color: Random Green
                setGroundColor(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
                //Set Level Text Background Color: Green
//                levelTxtBGCol = 0x00ff00;//Green
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
        }
        
    }
    
    
    /**
     * setUpLevel9()
     * 
     */
    private void setUpLevel9(){
        int width = Tetris.getMainWidth();
        Random random = new Random();
        switch(width){
            case 300:
                
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Random Green
//                Barricade.setBarricadeCol(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
//                powScale = 0.75;
            
                groundScale = 1.0;
                groundX = 4;
                groundY = Tetris.getMainHeight() - 140;
                setGroundColor(0x00ff00 + random.nextInt(0xffffff));
                
                break;
                
            case 480:
                
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Random Green
//                Barricade.setBarricadeCol(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
//                powScale = 0.75;
           
                groundScale = 1.25;
                groundX = 10;
                groundY = Tetris.getMainHeight() - 140;
                setGroundColor(0x00ff00 + random.nextInt(0xffffff));
                
                break;
                
            case 604:
                
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Random Green
//                Barricade.setBarricadeCol(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
//                powScale = 0.75;
           
                groundScale = 2.45;
                groundX = -14;
                groundY = Tetris.getMainHeight() - 140;
                setGroundColor(0x00ff00 + random.nextInt(0xffffff));
                
                break;
                
            default:
                
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Random Green
//                Barricade.setBarricadeCol(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
//                powScale = 0.75;
           
                groundScale = 2.45;
                groundX = -14;
                groundY = Tetris.getMainHeight() - 140;
                setGroundColor(0x00ff00 + random.nextInt(0xffffff));
                
                break;
                
        }
    }
    
    
    /**
     * init()
     * 
     */
    private void init(){
        Texture.clearMaps();

        //Create Assets
        tetromino[0] =  "..X.";
        tetromino[0] += "..X.";
        tetromino[0] += "..X.";
        tetromino[0] += "..X.";
        
        tetromino[1] =  "..X.";
        tetromino[1] += ".XX.";
        tetromino[1] += ".X..";
        tetromino[1] += "....";
        
        tetromino[2] =  ".X..";
        tetromino[2] += ".XX.";
        tetromino[2] += "..X.";
        tetromino[2] += "....";
        
        tetromino[3] =  "....";
        tetromino[3] += ".XX.";
        tetromino[3] += ".XX.";
        tetromino[3] += "....";
        
        tetromino[4] =  "..X.";
        tetromino[4] += ".XX.";
        tetromino[4] += "..X.";
        tetromino[4] += "....";
        
        tetromino[5] =  "....";
        tetromino[5] += ".XX.";
        tetromino[5] += "..X.";
        tetromino[5] += "..X.";
        
        tetromino[6] =  "....";
        tetromino[6] += ".XX.";
        tetromino[6] += ".X..";
        tetromino[6] += ".X..";
        
        pField = new char[fieldWidth * fieldHeight];
        
        for(int x = 0; x < fieldWidth; x++){
            for(int y = 0; y < fieldHeight; y++){
                pField[y * fieldWidth + x] = (x == 0 || x == fieldWidth - 1 || y == fieldHeight - 1) ? '9' : '0';
            }
        }
        
        pScreen = new char[screenWidth * screenHeight];
        
        for(int i = 0; i < screenWidth * screenHeight; i++) pScreen[i] = ' ';
        
        firstTick = true;
        lastTick = false;

        //Reset Level Time
        resetLevelTime();
        
        random = new Random(System.currentTimeMillis());
    }
    
    
    /**
     * changeLevel()
     * 
     */
    public static void changeLevel(){
        if(levelNo < 8){
            levelNo++;
            setLevelNo(levelNo);
        } else {
            gameComplete = true;
        }
    }
    
    
    /**
     * getLevelNo()
     * 
     * 
     * @return levelNo
     */
    public static int getLevelNo(){
        return levelNo;
    }
    
    
    /**
     * setLevelNo()
     * 
     * 
     * @param levNo
     */
    public static void setLevelNo(int levNo){
        levelNo = levNo;
        Game.level = new Level(levelNo, Tetris.getMainWidth(), Tetris.getMainHeight());
    }
    
    
    /**
     * getLevelName()
     * 
     * 
     * @return levelName
     */
    public static String getLevelName(){
        switch(levelNo){
            case 1:
                levelName = "Start Zone - Dark side of the moon";
                
                break;
                
            case 2:
                levelName = "Martian Orbit - The Red Planet";
                
                break;
                
            case 3:
                levelName = "Terra Ferma - Protect Earth";
                
                break;
                
            case 4:
                levelName = "Fourth Quarter - Save the Sun";
                
                break;
                
            case 5:
                levelName = "Lunar Orbit - The Full Moon";
                
                break;
                
            case 6:
                levelName = "Martian Resistance - Defend Mars";
                
                break;
                
            case 7:
                levelName = "3rd Rock From The Sun - Protect Earth (again)";
                
                break;
                
            case 8:
                levelName = "Final Frontier - Send em to the Sun";
                
                break;
            
            default:
                levelName = "GAME COMPLETE!";
                
                break;
            
        }

        return levelName;
    }
    
    
    /**
    * tick()
    * 
    * 
    * Updates Level Object
    */
    public static synchronized void tick(){
        //Manage Level: First Tick
        if(firstTick) {
            //Set firstTick: false
            firstTick = false;
            
            //Reset Game Time
            Game.resetGameTime();
            
            //Reset Level Time
            resetLevelTime();
            
            if(Game.getGame().getGameMusic()){
                if(Game.levelNo == 1 && !Sound.Level1.isPlaying()){
                    Sound.Level1.loop();
                }
                if(Game.levelNo == 2 && !Sound.Level2.isPlaying()){
                    Sound.Level2.loop();
                }
                if(Game.levelNo == 3 && !Sound.Level3.isPlaying()){
                    Sound.Level3.loop();
                }
                if(Game.levelNo == 4 && !Sound.Level4.isPlaying()){
                    Sound.Level4.loop();
                }
                if(Game.levelNo == 5 && !Sound.Level5.isPlaying()){
                    Sound.Level5.loop();
                }
                if(Game.levelNo == 6 && !Sound.Level6.isPlaying()){
                    Sound.Level6.loop();
                }
                if(Game.levelNo == 7 && !Sound.Level7.isPlaying()){
                    Sound.Level7.loop();
                }
                if(Game.levelNo == 8 && !Sound.Level8.isPlaying()){
                    Sound.Level8.loop();
                }
            }
        }
        
        //Manage Level: Last Tick
        if(lastTick) {
            lastTick = false;
            Sound.stopAll();
            if(!Sound.creditsSoundtrack.isPlaying()){
                Sound.creditsSoundtrack.play();
            }
            
            //Reset Level Time
            resetLevelTime();
        }
          
    }
    
    
    /**
    * render(Render target, Graphics2D g)
    * 
    * 
    * Renders/Repaints Level Objects
    * 
    * @param g2d
    */
    public void render(Graphics2D g2d){
        Graphics2D g2d_Level = g2d;
        AffineTransform oldXForm = g2d.getTransform();
        
        g2d_Level.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if(!gameOver && !Game.paused && Game.getGame().menu == null){
        
            //GAME TIMING=========================================================================================================================
            try {
                Thread.sleep(fallSpeed);
            } catch (InterruptedException ex) {
                Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            speedCount++;
            forceDown = (speedCount == speed);
            
            //Force the Piece down the playfield if it's time
            if(forceDown){
                
                //Update difficulty every 50 pieces
                speedCount = 0;
                pieceCount++;
                if(pieceCount % 50 == 0){
                    if(speed >= 10){
                        speed--;
                        if(fallSpeed > 10){ 
                            fallSpeed -= 2;
                            if(Game.getGameSound()){
                                Sound.success.play();
                            }
                        }
                    }
                }
                
                //Test if piece can be moved down
                if(doesPieceFit(currentPiece, currentRot, currentPieceX, currentPieceY + 1)){
                    currentPieceY++;//It can, so do it!
                    if(Game.getGameSound()){
                        Sound.fall.play();
                    }
                } else {
                    //It can't!, Lock the piece in place
                    for(int px = 0; px < 4; px++){
                        for(int py = 0; py < 4; py++){
                            if(tetromino[currentPiece].toCharArray()[rotate(px, py, currentRot)] != '.') pField[(currentPieceY + py) * fieldWidth + (currentPieceX + px)] = (char) (currentPiece + 65);//tetromino[currentPiece].toCharArray()[rotate(px, py, currentRot)];
                        }
                    }
                    if(Game.getGameSound()){
                        Sound.clear.play();
                    }
                    
                    //Check for Lines
                    for(int py = 0; py < 4; py++){
                        if(currentPieceY + py < fieldHeight - 1){
                            boolean bLine = true;
                            for(int px = 1; px < fieldWidth - 1; px++){
                                bLine &= (pField[(currentPieceY + py) * fieldWidth + px]) != '0';
                            }
                            
                            if(bLine){
                                //Remove Line, set to =
                                for(int px = 1; px < fieldWidth - 1; px++){
                                    pField[(currentPieceY + py) * fieldWidth + px] = '=';
                                }
                                vLines.add(currentPieceY + py);
                            }
                            
                        }
                    }
                    
                    //score += 25;
                    
                    if(!vLines.isEmpty()) score += (1 << vLines.size()) * 100;
                    
                    random = new Random(System.currentTimeMillis());
                    
                    //Pick new Piece
                    currentPieceX = fieldWidth / 2;
                    currentPieceY = 0;
                    currentRot = 0;
                    currentPiece = random.nextInt(7);
                    
                    //If piece doesn't fit straight away, game over!
                    gameOver = !doesPieceFit(currentPiece, currentRot, currentPieceX, currentPieceY);
                }
                
            }
            
            //Render OUTPUT=========================================================================================================================
            //Draw Field
            for(int x = 0; x < fieldWidth; x++){
                for(int y = 0; y < fieldHeight; y++){
                    pScreen[(y + 2) * screenWidth + (x + 2)] = pField[y * fieldWidth + x];
                    if(pScreen[(y + 2) * screenWidth + (x + 2)] != '0'){
                        switch(pScreen[(y + 2) * screenWidth + (x + 2)]){
                            case 'A': currentPiecePaint = gradientPaintRed; break;
                            case 'B': currentPiecePaint = gradientPaintYellow; break;
                            case 'C': currentPiecePaint = gradientPaintGreen; break;
                            case 'D': currentPiecePaint = gradientPaintBlue; break;
                            case 'E': currentPiecePaint = gradientPaintCyan; break;
                            case 'F': currentPiecePaint = gradientPaintOrange; break;
                            case 'G': currentPiecePaint = gradientPaintMagenta; break;
                            case '9': currentPiecePaint = gradientPaintGray; break;
                            case '=': currentPiecePaint = gradientPaintRed1; break;
                            default: currentPiecePaint = gradientPaintGray; break;
                        }
                        
                        currentPieceRectA = new Rectangle((x + 2) * screenWidth/2 - 5, (y + 2) * screenHeight - 10, pieceWidth, pieceHeight);
                        currentPieceRect = new RoundRectangle2D.Float((x + 2) * screenWidth/2 - 5, (y + 2) * screenHeight - 10, pieceWidth, pieceHeight, 10, 10);
                        g2d_Level.setPaint(currentPiecePaint);
                        
                        if(pScreen[(y + 2) * screenWidth + (x + 2)] == '9'){
                            g2d_Level.fill(currentPieceRectA);
                        } else{
                            g2d_Level.fill(currentPieceRect);
                        }
                        
                        g2d_Level.setColor(rectangleFG);
                        g2d_Level.drawRect((x + 2) * screenWidth/2 - 3, (y + 2) * screenHeight - 8, 32, 26);
                        g2d_Level.drawRect((x + 2) * screenWidth/2 - 4, (y + 2) * screenHeight - 9, 32, 26);
                    } else {
                        //Draw Background
                        g2d_Level.setColor(backgroundColor);
                        g2d_Level.drawRect((x + 2) * screenWidth/2 - 3, (y + 2) * screenHeight - 8, 32, 26);
                    }
                }
            }
            
            //Draw CurrentPiece
            for(int px = 0; px < 4; px++){
                for(int py = 0; py < 4; py++){
                    if(tetromino[currentPiece].toCharArray()[rotate(px, py, currentRot)] == 'X')
                    pScreen[(currentPieceY + py + 2) * screenWidth + (currentPieceX + px + 2)] = (char) (currentPiece + 65);
                    if(pScreen[(currentPieceY + py + 2) * screenWidth + (currentPieceX + px + 2)] != '0' && 
                            pScreen[(currentPieceY + py + 2) * screenWidth + (currentPieceX + px + 2)] != '9' && 
                            (currentPieceX + px + 2) > 2 && (currentPieceY + py + 2) > 1){
                        
                        switch(pScreen[(currentPieceY + py + 2) * screenWidth + (currentPieceX + px + 2)]){
                            case 'A': currentPieceColor = Color.red; break;
                            case 'B': currentPieceColor = Color.yellow; break;
                            case 'C': currentPieceColor = Color.green; break;
                            case 'D': currentPieceColor = Color.blue; break;
                            case 'E': currentPieceColor = Color.cyan; break;
                            case 'F': currentPieceColor = Color.orange; break;
                            case 'G': currentPieceColor = Color.magenta; break;
                        }
                        
                        g2d_Level.setColor(currentPieceColor);
                        g2d_Level.drawRect((currentPieceX + px + 2) * screenWidth/2 - 5, (currentPieceY + py + 2) * screenHeight - 10, pieceWidth, pieceHeight);
                        //g2d_Level.setColor(Color.white);
                        //g2d_Level.drawString(""+pScreen[(currentPieceY + py + 2) * screenWidth + (currentPieceX + px + 2)]+" :"+(currentPieceX + px + 2), (currentPieceX + px + 2) * screenWidth/2, (currentPieceY + py + 2) * screenHeight);
                    }
                }
            }
            
            
            
            //Animate Line Completion
            if(!vLines.isEmpty()){
                
                //Draw Score
                Game.increaseScore(vLines.size() * 25);
                linesComplete += vLines.size();
                
                for(Integer v : vLines){
                    
                    for(int px = 1; px < fieldWidth - 1; px++){
                        for(int py = v; py > 0; py--){
                            pField[py * fieldWidth + px] = pField[(py -1) * fieldWidth + px];
                            pField[px] = '0';
                        }
                    }
                }
                
                try {
                    Thread.sleep(600);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                
                if(Game.getGameSound()){
                    Sound.line.play();
                    //Sound.clear.play();
                }
                vLines.clear();
                score = 0;
            }
        
        
        
        
        
//        Game.hud.render(target, g2d_Level);
        
            if(Game.showFPS){
                g2d_Level.setColor(Color.decode("#fe1300"));
                g2d_Level.drawString(Game.theFPS, Labels.fpsX, Labels.fpsY);

            }
            if(Game.showUPS){
                g2d_Level.setColor(Color.decode("#f0ff00"));
                g2d_Level.drawString(Game.theUPS, Labels.upsX, Labels.upsY);
            }
            if(Game.showGameTime){
                g2d_Level.setFont(new Font("default", Font.BOLD, 18));
                g2d_Level.setColor(Color.DARK_GRAY);
                g2d_Level.drawString(Game.theGameTime, Labels.upsX+51, Labels.upsY+55);
                g2d_Level.setColor(Color.decode("#008fea"));
                g2d_Level.drawString(Game.theGameTime, Labels.upsX+50, Labels.upsY+54);
            }
            if(Game.showLevelTime){
                g2d_Level.setFont(new Font("default", Font.BOLD, 18));
                g2d_Level.setColor(Color.DARK_GRAY);
                g2d_Level.drawString(theLevelTime, Labels.upsX+231, Labels.upsY+55);
                g2d_Level.setColor(Color.decode("#ff8fea"));
                g2d_Level.drawString(theLevelTime, Labels.upsX+230, Labels.upsY+54);
            }

            g2d_Level.setFont(new Font("default", Font.BOLD, 18));
            g2d_Level.setColor(Color.DARK_GRAY);
            g2d_Level.drawString("Lines Complete: "+linesComplete, Labels.upsX+401, Labels.upsY+55);
            g2d_Level.setColor(Color.BLUE);
            g2d_Level.drawString("Lines Complete: "+linesComplete, Labels.upsX+400, Labels.upsY+54);
                

        } 
        if(gameOver) {
            Game.player.P1Hit();
            if(Game.getGameSound()){
                Sound.gameover.play();
            }
        }

        
        if(Game.showBounds){
//            g2d_Level.setColor(Color.GREEN);
//            g2d_Level.drawRect(groundBounds.x, groundBounds.y, groundBounds.width, groundBounds.height);
//            g2d_Level.setColor(Color.WHITE);
//            //g.drawRect(Enemy.leftSide - 5, 29, 5, Display.game.getHeight() - (28 + groundBounds.height + 8));
//            g2d_Level.setColor(Color.WHITE);
//            //g.drawRect(Enemy.rightSide + 19, 29, 5, Display.game.getHeight() - (28 + groundBounds.height + 8));
        }    
        
        g2d.setTransform(oldXForm);
        g2d_Level.setTransform(oldXForm);
    
    }

    
    /**
    * setBackground(int index)
    * 
    * 
    * @param index
    */
    public static void setBackground(int index) {
        background = index;
    }

    
    /**
    * setGroundColor(int col)
    * 
    * 
    * @param col
    */
    private void setGroundColor(int col) {
//        groundColor = col;
    }

    
    /**
    * resetLevelTime()
    * 
    */
    public static void resetLevelTime() {
        System.out.println("Level: Resetting Level Time");
        Game.levelTime = 0;
    }
    
    
    public int rotate(int px, int py, int r){
        switch(r % 4){
            case 0: return py * 4 + px; //0 Degrees
            case 1: return 12 + py - (px * 4); //90 Degrees
            case 2: return 15 - (py * 4) - px; //180 Degrees
            case 3: return 3 - py + (px * 4); //270 Degrees
        }
        return 0;
    }
    
    
    public boolean doesPieceFit(int tetro, int rot, int posX, int posY){
         
        for(int px = 0; px < 4; px++){
            for(int py = 0; py < 4; py++){
                //Get index into piece
                int pi = rotate(px, py, rot);
                
                //Get index into field
                int fi = (posY + py) * fieldWidth + (posX + px);
                
                if(posX + px >= 0 && posX + px < fieldWidth){
                    if(posY + py >= 0 && posY + py < fieldHeight){
                        if(tetromino[tetro].toCharArray()[pi] == 'X' && pField[fi] != '0'){
                            return false; // fail on first hit
                        }
                    }
                }
            }
        }
        
        
        return true;
    }
    
}
