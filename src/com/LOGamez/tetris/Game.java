/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.tetris;

import com.LOGamez.audio.Sound;
import com.LOGamez.graphics.*;
import com.LOGamez.gui.HUD;
import com.LOGamez.input.*;
import com.LOGamez.level.*;
import com.LOGamez.menu.Menu;
import com.LOGamez.menu.*;
import com.LOGamez.player.Player;
import com.LOGamez.pow.POW;
import com.LOGamez.states.GameState;
import com.LOGamez.states.MenuState;
import com.LOGamez.states.StateManager;
import com.LOGamez.utils.Util;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.logging.Logger;

/**
 *
 * @author Nicholas Wright
 */
public class Game extends Canvas implements Runnable {

    /**Attributes*/
    
    /**TITLE variable of Game*/
    public static String TITLE = "Tetris";
    
    /**version variable of Game*/
    public static String version = "v0.3.8";
    
    /**textCount variable of Game*/
    public static int textCount = 0;
    
    /**renderCount variable of Game*/
    public static int renderCount = 0;
    
    /**showBounds variable of Game*/
    public static boolean showBounds = false;
    
    /**showPlayerBounds variable of Game*/
    public static boolean showPlayerBounds = false;
    
    /**showEnemyBounds variable of Game*/
    public static boolean showEnemyBounds = false;
    
    /**showMazeBounds variable of Game*/
    public static boolean showMazeBounds = false;
    
    /**showBlockBounds variable of Game*/
    public static boolean showBlockBounds = false;
    
    /**renderCount variable of Game*/
    private static String PlayerN;
    
    /**renderCount variable of Game*/
    public static boolean showFPS = true;
    
    /**renderCount variable of Game*/
    public static boolean showUPS = true;
    
    /**renderCount variable of Game*/
    public static boolean showGameTime = true;
    
    /**theGameTime variable of Game*/
    public static String theGameTime = "GameTime:";
    
    /**showScreenBounds variable of Game*/
    public static boolean showScreenBounds = false;
    
    /**showHUD variable of Game*/
    public static boolean showHUD = true;
    
    /**gameMusicOn variable of Game*/
    private static boolean gameMusicOn = true;
    
    /**LEFTSIDE variable of Game*/
    public static Rectangle LEFTSIDE;
    
    /**RIGHTSIDE variable of Game*/
    public static Rectangle RIGHTSIDE;
    
    /**TOPSIDE variable of Game*/
    public static Rectangle TOPSIDE;
    
    /**BOTTOMSIDE variable of Game*/
    public static Rectangle BOTTOMSIDE;
    
    /**levelTime variable of Game*/
    public static int levelTime;
    
    /**showLevelTime variable of Game*/
    public static boolean showLevelTime = true;
    
    /**pauseTime variable of Game*/
    public static int pauseTime = 50;    
    
    /**thefps variable of Game*/
    //public static String thefps = "FPS: xxx";
    
    /**theUps variable of Game*/
    //public static String theUps;
    
    /**img variable of Game*/
    private final BufferedImage img;
    
    /**gameSndOn variable of Game*/
    static boolean gameSndOn = true;
    
    /**gameTimer variable of Game*/
    static int gameTimer = 0;
    
    /**gameTimer variable of Game*/
    public static int gameScore = 0;
    
    /**paused variable of Game*/
    public static boolean paused;

    /**running variable of Game*/
    private boolean running;
    
    /**thread variable of Game*/
    private Thread thread;
    
    /**pixels variable of Game*/
    int[] pixels;
    
    /**frames variable of Game*/
    private int frames;
    
    /**currentTime variable of Game*/
    private long currentTime;
    
    /**score variable of Game*/
    public static int score;
    
    /**fps variable of Game*/
    private int fps;
    
    /**ups variable of Game*/
    private int ups;
    
    /**theFPS variable of Game*/
    public static String theFPS = 0+"FPS";
    
    /**theUPS variable of Game*/
    public static String theUPS = 0+"UPS";
    
    /**gameWidth variable of Game*/
    public static int gameWidth;
    
    /**gameHeight variable of Game*/
    public static int gameHeight;
    
    /**bs variable of Game*/
    private BufferStrategy bs;
    
    /**newX variable of Game*/
    private int newX;
    
    /**oldX variable of Game*/
    private int oldX;
    
    /**MouseSpeed variable of Game*/
    public static int MouseSpeed;
    
    /**shotsFired variable of Game*/
    private int shotsFired;
    
    /**enemizHit variable of Game*/
    private int bloxHit;
    
    /**timeBonus variable of Game*/
    public static int timeBonus;
    
    /**accuracyBonus variable of Game*/
    public static int accuracyBonus;
    
    /**levelBonus variable of Game*/    
    public static int levelBonus;
    
    /**livesBonus variable of Game*/
    public static int livesBonus;
    
    /**hadFocus variable of Game*/
    private boolean hadFocus;
    
    /**emptyCursor variable of Game*/
    private Cursor emptyCursor;
    
    /**defaultCursor variable of Game*/
    private Cursor defaultCursor;
    
    /**levelNo variable of Game*/
    public static int levelNo;
    
    /**startLevel variable of Game*/
    public static int startLevel = 1;
    
    
    /**Links*/
    
    /**aGame Game of Game*/
    public static Game aGame;
    
    /**screen Screen of Game*/
//    private Screen screen;
    
    /**labels Labels of Game*/
    public static Labels labels;
    
    /**stateManager StateManager of Game*/
    public StateManager stateManager;
    
    /**input KeyInput of Game*/
    KeyInput input;
    
    /**mouseInput MouseInput of Game*/
    MouseInput mouseInput;
    
    /**menu Menu of Game*/
    public Menu menu;
    
    /**pac Player of Game*/
    public static Player pac;
    
    /**level Level of Game*/
    public static Level level;
    
    /**hud HUD of Game*/
    public static HUD hud;
    
    /**player Player of Game*/
    public static Player player;
    
    /**pows POW of Game*/
    public static POW pows;
    
    
    /**Constructor*/
    
    
    /**
     * Game Constructor
     * 
     * @param width
     * @param height
     */
    public Game(int width, int height){
        System.out.println("Game: New Game created: "+width+" * "+height+" = "+(width * height)+" pixels");
        gameWidth = width;
        gameHeight = height;
        
        //Create Keys and/or Mouse Inputs
        input = new KeyInput();
        mouseInput = new MouseInput();
        
        //Set Keys and Mouse
       addKeyListener(input);//Set Game KeyListener to input
       addFocusListener(input);//Set Game FocusListener to input
       addMouseListener(mouseInput);//Set Game mouseListener to mouseInput
       addMouseMotionListener(mouseInput);//Set Game mouseMotionListener to mouseInput
        
       //If screen null create new screen : gameWidth, gameHeight args
//        if(screen == null){
//            screen = new Screen(gameWidth, gameHeight);
//        }
        
        //Create new blank Buffered Image
        img = new BufferedImage(Tetris.getMainWidth(), Tetris.getMainHeight(), BufferedImage.TYPE_INT_RGB);
        //Grab pixel data from img
        pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
        
        //Set Game Sound
        Game.gameSndOn = Game.getGameSound();
        
        gameTimer = 0;
        resetScore();
        resetGameTime();
        paused = false;
        
        aGame = this;
        
        init();//Initiate the game
        
    }

    
    
    /**Public Protocol*/
    
    
    /**
     * init()
     * 
     */
    private void init(){
        System.out.println("Game: Initiating Game . . .");
        
        LEFTSIDE = new Rectangle(0, 0, 5, gameHeight);
        RIGHTSIDE = new Rectangle(gameWidth+4, 0, 5, gameHeight);
        TOPSIDE = new Rectangle(0, 26, gameWidth+10, 5);
        BOTTOMSIDE = new Rectangle(0, gameHeight - 42, gameWidth+10, 5);
        
        stateManager = new StateManager();
        stateManager.addState(new MenuState());
        stateManager.addState(new GameState());
        
        if(level == null){
            levelNo = startLevel;
            Game.level = new Level(levelNo, Tetris.getMainWidth(), Tetris.getMainHeight());
        }
        
        requestFocus();
        start();//start the game
    }
    
    
    
    ///////THREAD MANAGEMENT START
    /**
     * start()
     * 
     */
    private void start(){
        System.out.println("Game: Starting Game . . .");
        if(running) return;
        
        running = true;
        thread = new Thread(this, "Game-Thread");
        thread.start();
    }
    
    
    /**
     * stop()
     * 
     */
    public void stop(){
        System.out.println("Game: Stopping Game . . .");
        if(!running) return;
        
        running = false;
    }
    
    
    /**
     * run()
     * 
     */
    @Override
    public void run(){
        System.out.println("Running Game . . .");
        double ns = 1000000000.0 / 60;//Update 60 times per second ||
        //double ns = 1000000000.0 / 30;//Update 30 times per second
        long prevTime = System.nanoTime();
        double delta = 0;
        frames = 0;
        
        int updates = 0;
        long timer = System.currentTimeMillis();
        
        while(running){
            currentTime = System.nanoTime();
            delta += (currentTime - prevTime) / ns;
            prevTime = currentTime;
            
            if(delta >= 1){
                tick();
                updates++;
                delta--;
            }
            Game.gameScore = getScore();//score;
            while(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                gameTimer += 1;
                levelTime++;
                
                fps = frames;
                ups = updates;
                
                theFPS = fps+"FPS";
                theUPS = ups+"UPS";
                theGameTime = "Game Time: "+gameTimer;
                Level.theLevelTime = "Level Time:"+levelTime;
                
                frames = 0;
                updates = 0;
            }
            render();
            frames++;
            setScore(score);
        }
    }
    ///////THREAD MANAGEMENT END
    
    
    
    
    /**
     * tick() AKA Update()
     */
    private void tick(){        
        if (pauseTime > 0 && (this.menu == null && !this.stateManager.currentState.getName().equals("menu")) || 
                stateManager.currentState.getName().equals("Credits")) {           
            pauseTime --; 
            return;
	}
        
        if(hasFocus()) {
            input.tick(this, this.menu, this.player);//Render another class using args Game, menu, player
            
            newX = MouseInput.MouseX;
            //newY = InputHandler.MouseY;
            if (MouseInput.MouseButton == 1) {
                Player.mouseFire = true;
            }
            if (MouseInput.MouseButton != 1) {
                Player.mouseFire = false;
            }
            if (newX > oldX) {
                Player.mouseRight = true;
            }
            if (newX < oldX) {
                Player.mouseLeft = true;
            }
            if (newX == oldX) {
                Player.mouseLeft = false;
                Player.mouseRight = false;
            }
            MouseSpeed = Math.abs(newX - oldX);
            oldX = newX;
        }
        
        stateManager.tick();
        
        if (pauseTime == 0 && Level.levelComplete){
//            win();
        }
        
    }
    
    /**
    * win()
    * 
    */
    public void win() {
        //Record Game Time and Player Accuracy and determine Bonus'
        levelTime = getGameTime();
        shotsFired = 5;//Player.getShotsFired();
        //bloxHit = Block.getBlocksHit();

        System.out.println("Level Time: "+levelTime+" Shots Fired: "+shotsFired+" Enemies Hit: "+bloxHit);

        if(levelTime < 50){
            livesBonus = 300;
            timeBonus = 1000;
            accuracyBonus = 30;
        } else if(levelTime > 50 && levelTime < 150){
            livesBonus = 200;
            timeBonus = 500;
            accuracyBonus = 20;
        } else {
            livesBonus = 100;
            timeBonus = 350;
            accuracyBonus = 10;
        }

        //livesBonus *= Player.getLives();
        accuracyBonus *= (double) (shotsFired / bloxHit);
        levelBonus = timeBonus + levelTime / 100;
        //levelBonus *= accuracyBonus + Player.getLives() * Block.blockStrength;
        levelBonus = levelBonus / 100;
        levelBonus = levelBonus + timeBonus + accuracyBonus;
        
        
        System.out.println("Level Bonus: "+levelBonus+" Time Bonus: "+timeBonus+" Accuracy Bonus: "+accuracyBonus);
        
        Tetris.setStatusBar("Time Bonus: "+timeBonus+" Accuracy Bonus: "+accuracyBonus+" Level Bonus: "+levelBonus);
        
        if(levelNo+1 < 21){//Game Levels Limit : Currently set to 8
            System.out.println("Level "+levelNo+" Complete!");
            setScore(getScore() + levelBonus);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            
            
            levelNo += 1;
            //level = new Level(levelNo, Tetris.getMainWidth(), Tetris.getMainHeight());
            //Level.levelComplete = false;
            pauseTime = 150;
            
            //Player.resetShotsFired();
            //Block.resetBlocksHit();
            
            //Tetris.setStatusBar("Loading Level "+levelNo+" : "+Level.getLevelName());
        } else {
            Tetris.setStatusBar("Game Complete!");
            //level = new Level(20, PacMan.getMainWidth(), PacMan.getMainHeight());
            //Level.levelComplete = false;
            pauseTime = 150;
            
            //Show Credits . . .
            //setCredits();
        }
    }
    
    
    /**
     * render() AKA Draw()
     * 
     */
    private void render(){
        if(this.menu == null){// && !stateManager.currentState.getName().equals("Credits")){
            if (hadFocus != hasFocus()) {
                hadFocus = !hadFocus;
                setCursor(hadFocus ? emptyCursor : defaultCursor);
                if(!hadFocus && this.menu == null){
                    if(getGameSound()){
                        Sound.Focus.loop();
                    }
                } else {
                    Sound.Focus.stop();
                }
            }
        }
        
        //Get Buffer Strategy
        bs = getBufferStrategy();
        if(bs == null){//Check Buffer strategy is null Create it [if true]>>
            try{
                //Create Buffer Strategy
                createBufferStrategy(3);
                return;
            } catch (Exception e){
                return;
            }
        }
        //Create/Get Graphics(Painter) object g from BufferStrategy
        Graphics g = bs.getDrawGraphics();
        
        //START OF GRAPHICS
        ///////////////////////////////////////////////////////////////////////////////////////
        //Create Graphics2D(2D Painter) object from g
        Graphics2D g2d = (Graphics2D) g;
        
        //Set ANTIALIASING(Optional)
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        //Translate Canvas(Optional)
        //g2d.translate(4, 0);
        
        if(this.menu == null){
            stateManager.render(g2d);
        }
        
        if(!stateManager.currentState.getName().equals("menu")){
            
            g2d.drawImage(img, 0, 0, gameWidth+12, gameHeight, null);
            //screen.render(this, hasFocus(), g2d);
            
            level.render(g2d);
            player.render(g2d);
            
            if (this.menu != null) {
                for (int i = 0; i < pixels.length; i++) {
                    pixels[i] = (pixels[i] & 0xfcfcfc) >> 2;
                }
                this.menu.render(this, g2d);
            } 
            
//            for (int i = 0; i < pixels.length; i++) {
//                pixels[i] = screen.pixels[i];
//            }     
        }
        
        ///////////////////////////////////////////////////////////////////////////////////////
        //END OF GRAPHICS
        
        g.dispose();//Dispose or clear g
        bs.show();//Show Buffer Strategy - Draw everything in g(g2d)
        
    }
    
    
    /**
    * getGameTime()
    * 
    * @return running
    */
    public int getGameTime() {
        return gameTimer;
    }
    
    
    /**
    * resetGameTime()
    * 
    */
    public static void resetGameTime() {
        gameTimer = 0;
    }
    
    
    /**
     * getStartLevel()
     * 
     * @return startLevel
     */
    public static int getStartLevel() {
        return Game.startLevel;
    }

    
    /**
     * setStartLevel(int startLevel)
     * 
     * @param Level
     */
    public static void setStartLevel(int Level) {
        Game.startLevel = Level;
    }
    
    
    /**
    * getScore()
    * 
    * @return score
    */
    public static int getScore() {
        return score;
    }
    
    
    /**
    * setScore()
    * 
    * @param newScore
    */
    public static void setScore(int newScore) {
        score = newScore;
    }
    
    
    /**
    * getGame()
    * 
    * @return aGame
    */
    public static Game getGame() {
        return aGame;
    }
    
    
    /**
    * setMenu(Menu menu)
    * 
    * Sets a Menu object to a Game object
    * 
    * @param menu
    */ 
    public void setMenu(com.LOGamez.menu.Menu menu) {
	this.menu = menu;
    }
    
    
    /**
    * setStart()
    * 
    */
    public void setStart() {
        stateManager.setState("Level 1");
        setMenu(new StartMenu(this));
        System.out.println("Game: Start Menu Set");
    }
    
    
    /**
    * setAbout()
    * 
    */
    public void setAbout() {
        stateManager.setState("Level 1");
        //setMenu(new AboutMenu(this));
        System.out.println("Game: About Menu Set");
    }
    
    
    /**
    * setInstructions()
    * 
    */
    public void setInstructions() {
        stateManager.setState("Level 1");
        setMenu(new InstructionsMenu(this));
        System.out.println("Game: Help Menu Set");
    }
    
    
    /**
    * setCredits()
    * 
    */
    public void setCredits() {
        stateManager.setState("Credits");
        setMenu(new CreditsMenu(this));
        System.out.println("Game: Credits Menu Set");
    }
    
    
    /**
    * setOptions()
    * 
    */
    public void setOptions() {
        stateManager.setState("Level 1");
        setMenu(new OptionsMenu(this));
        System.out.println("Game: Options Menu Set");
    }
    
    
    /**
    * setHiScore()
    * 
    */
    public void setHiScore() {
        stateManager.setState("Level 1");
        //setMenu(new HiScoreMenu(this));
        System.out.println("Game: HiScore Menu Set");
    }
    
    
    /**
    * setKeys()
    * 
    */
    public void setKeys() {
        stateManager.setState("Level 1");
        //setMenu(new KeysMenu(this));
        System.out.println("Game: Keys Menu Set");
    }
    
    
    /**
     * getPName()
     * 
     * @return PlayerN
     */
    public static String getPName() {
        if(PlayerN == null){
            setPlayerName("Tetris 1");
            if(Util.getUserNAME() == null){
                setPlayerName("Tetris 1");
            } else {
                if(Util.getUserNAME().length() > 8){
                    setPlayerName(Util.getUserNAME().substring(0, 8));
                }else{
                    setPlayerName(Util.getUserNAME());
                }
            }
        }
        return PlayerN;
    }
    
    
    /**
     * setPlayerName(String player_name)
     * 
     * @param player_name
     */
    public static void setPlayerName(String player_name) {
        PlayerN = player_name;
    }
    
    
    /**
    * increaseGameLives(int i)
    * 
    * @param i
    */
    public static void increaseGameLives(int i) {
//        pac.increasePlayerLives(i);
    }
    
    
    /**
    * getTimeBonus()
    * 
    * @return timeBonus
    */
    public static int getTimeBonus(){       
        return 0;//gameStats.getTimeBonus();
    }
    
    
    /**
    * getAccuracyBonus()
    * 
    * @return accuracyBonus
    */
    public static int getAccuracyBonus(){       
        return 0;//gameStats.getAccuracyBonus();
    }
    
    
    /**
    * getLevelBonus()
    * 
    * @return levelBonus
    */
    public static int getLevelBonus(){       
        return 0;//gameStats.getLevelBonus();
    }

    
    /**
    * getLivesBonus()
    * 
    * @return livesBonus
    */
    public static int getLivesBonus() {
        return 0;//gameStats.getLivesBonus();
    }
    
    
    /**
     * getGameSound()
     * 
     * @return gameSndOn
     */
    public static boolean getGameSound() {
        return gameSndOn;
    }

    
    /**
     * setGameSound(boolean gameSndOn)
     * 
     * @param SndOn
     */
    public static void setGameSound(boolean SndOn) {
        Game.gameSndOn = SndOn;
    }
    
    
    /**
     * getGameMusic()
     * 
     * @return gameMusicOn
     */
    public static boolean getGameMusic() {
        return gameMusicOn;
    }

    
    /**
     * setGameMusic(boolean MusicOn)
     * 
     * @param MusicOn
     */
    public static void setGameMusic(boolean MusicOn) {
        Game.gameMusicOn = MusicOn;
    }
    
    
    /**
    * increaseScore(int i)
    * 
    * @param i
    */
    public static void increaseScore(int i) {
        score += i;
    }
    
    
    /**
    * increaseScore(Enemy e)
    * 
    * @param b
    */
//    public static void increaseScore(Block b) {
////        if(e instanceof Enemy0){
////            increaseScore(50);
////        } else if(e instanceof Enemy1){
////            increaseScore(50);
////        } else if(e instanceof Enemy2){
////            increaseScore(30);
////        } else if(e instanceof Enemy3){
////            increaseScore(30);
////        } else if(e instanceof Enemy4){
////            increaseScore(30);
////        } else if(e instanceof Enemy5){
////            increaseScore(25);
////        } else if(e instanceof Enemy6){
////            increaseScore(25);
////        } else if(e instanceof Enemy7){
////            increaseScore(25);
////        } else if(e instanceof Enemy8){
////            increaseScore(10);
////        } else if(e instanceof Enemy9){
////            increaseScore(10);
////        } else if(e instanceof UFO){
////            increaseScore(100);
////        }
//        increaseScore(100);
//    }
    
    
    /**
     * resetScore()
     * 
     */
    public void resetScore() {
        gameScore = 0;
    }
    
    
    /**
    * lose()
    * 
    */
    public void lose() {
        System.out.println("Lose Game");
        if(Player.getLives() == 0){
            levelNo = 1;
            level.setLevelNo(levelNo);
            setMenu(new LoseMenu(this));
        }
    }
    
    
    /**
     * loseGame()
     * 
     */
    public static void loseGame() {
        Game.getGame().lose();
    }

    
    /**
     * quitGame()
     * 
     */
    public void quitGame() {
        stop();
        System.exit(0);
    }
    
}
