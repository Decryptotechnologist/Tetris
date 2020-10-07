/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.menu;

import com.LOGamez.graphics.*;
import com.LOGamez.tetris.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Nicholas Wright
 */
public class Menu {

    /**Attributes*/
    
    /**copyRight variable of Menu*/ 
    public static final String copyRight = "(C) Tetris 2020";
    
    /**startTxtScale variable of Menu*/ 
    //public static double startTxtScale;// = 2;
    
    /**pauseTxtScale variable of Menu*/ 
    //public static double pauseTxtScale;// = 2;
    
    /**logoScale variable of Menu*/ 
    public static double logoScale;// = 1.15;
    
    /**scoreSheetScale variable of Menu*/ 
    public static double scoreSheetScale;// = 1.0;
    
    /**startTxtX coordinate of Menu*/ 
    //public static int startTxtX;
    
    /**startTxtY coordinate of Menu*/ 
    //public static int startTxtY;
    
    /**pauseTxtX coordinate of Menu*/ 
    //public static int pauseTxtX;
    
    /**pauseTxtY coordinate of Menu*/ 
    //public static int pauseTxtY;
    
    /**logoX coordinate of Menu*/ 
    public static int logoX;
    
    /**logoY coordinate of Menu*/ 
    public static int logoY;
    
    /**scoreSheetX coordinate of Menu*/ 
    public static int scoreSheetX;
    
    /**scoreSheetY coordinate of Menu*/ 
    public static int scoreSheetY;
    
    /**copyRightX coordinate of Menu*/ 
    public static int copyRightX;
    
    /**copyRightY coordinate of Menu*/ 
    public static int copyRightY;
    
    /**gameOverTxtScale variable of Menu*/ 
    public static double gameOverTxtScale;
    
    /**gameOverTxtX coordinate of Menu*/ 
    public static int gameOverTxtX;
    
    /**gameOverTxtY coordinate of Menu*/ 
    public static int gameOverTxtY;
    
    /**options variable of Menu*/ 
    public static String[] options = { "Resume", "Restart", "Quit" };
    
    /**msg variable of Menu*/ 
    public static String msg;
    
    /**optionsTxtX0 coordinate of Menu*/ 
    public static int optionsTxtX0;
    
    /**optionsTxtY0 coordinate of Menu*/ 
    public static int optionsTxtY0;
    
    /**optionsTxtX1 coordinate of Menu*/ 
    public static int optionsTxtX1;
    
    /**optionsTxtY1 coordinate of Menu*/ 
    public static int optionsTxtY1;

    /**menuImage BufferedImage of Menu*/
    public static BufferedImage menuImage;
    
    /**menuImage0 BufferedImage of Menu*/
    public static BufferedImage menuImage0;
    
    /**menuImage1 BufferedImage of Menu*/
    public static BufferedImage menuImage1;
    
    /**menuImage2 BufferedImage of Menu*/
    public static BufferedImage menuImage2;
    
    /**menuImage3 BufferedImage of Menu*/
    public static BufferedImage menuImage3;
    
//    /**startMenuImage BufferedImage of Menu*/
//    public static BufferedImage startMenuImage;
//    
//    /**startMenuImage0 BufferedImage of Menu*/
//    public static BufferedImage startMenuImage0;
//    
//    /**startMenuImage1 BufferedImage of Menu*/
//    public static BufferedImage startMenuImage1;
    
    /**playOffBtn BufferedImage of Menu*/
    public static BufferedImage resumeOffBtn;
    
    /**playOnBtn BufferedImage of Menu*/
    public static BufferedImage resumeOnBtn;
    
    /**optionsOffBtn BufferedImage of Menu*/
    public static BufferedImage restartOffBtn;
    
    /**optionsOnBtn BufferedImage of Menu*/
    public static BufferedImage restartOnBtn;
    
    /**quitOffBtn BufferedImage of Menu*/
    public static BufferedImage quitOffBtn;
    
    /**quitOnBtn BufferedImage of Menu*/
    public static BufferedImage quitOnBtn;
    
    /**backOffBtn BufferedImage of Menu*/
    public static BufferedImage backOffBtn;
    
    /**backOnBtn BufferedImage of Menu*/
    public static BufferedImage backOnBtn;
    
    /**backOffBtn BufferedImage of Menu*/
    public static BufferedImage OKOffBtn;
    
    /**backOnBtn BufferedImage of Menu*/
    public static BufferedImage OKOnBtn;
    
    /**backOffBtn BufferedImage of Menu*/
    public static BufferedImage cancelOffBtn;
    
    /**backOnBtn BufferedImage of Menu*/
    public static BufferedImage cancelOnBtn;
    
    /**skipOffBtn BufferedImage of Menu*/
    public static BufferedImage skipOffBtn;
    
    /**skipOnBtn BufferedImage of Menu*/
    public static BufferedImage skipOnBtn;    
    
    /**leftArrowIcon BufferedImage of Menu*/
    public static BufferedImage leftArrowIcon;
    
    /**rightArrowIcon BufferedImage of Menu*/
    public static BufferedImage rightArrowIcon;
    
    /**instructionsMenuImage BufferedImage of Menu*/
    public static BufferedImage instructionsMenuImage;
    
    /**instructionsMenuImage0 BufferedImage of Menu*/
    public static BufferedImage instructionsMenuImage0;
    
    /**instructionsMenuImage1 BufferedImage of Menu*/
    public static BufferedImage instructionsMenuImage1;
    
    /**aboutMenuImage BufferedImage of Menu*/
    public static BufferedImage aboutMenuImage;
    
    /**aboutMenuImage0 BufferedImage of Menu*/
    public static BufferedImage aboutMenuImage0;
    
    /**aboutMenuImage1 BufferedImage of Menu*/
    public static BufferedImage aboutMenuImage1;
    
    /**optionsMenuImage BufferedImage of Menu*/
    public static BufferedImage optionsMenuImage;
    
    /**optionsMenuImage0 BufferedImage of Menu*/
    public static BufferedImage optionsMenuImage0;
    
    /**optionsMenuImage1 BufferedImage of Menu*/
    public static BufferedImage optionsMenuImage1;
    
    /**optionsMenuImage2 BufferedImage of Menu*/
    public static BufferedImage optionsMenuImage2;
    
    /**graphicsPanelImage BufferedImage of Menu*/
    public static BufferedImage graphicsPanelImage;
    
    /**graphicsPanelImage0 BufferedImage of Menu*/
    public static BufferedImage graphicsPanelImage0;
    
    /**graphicsPanelImage1 BufferedImage of Menu*/
    public static BufferedImage graphicsPanelImage1;
    
    /**controlsPanelImage BufferedImage of Menu*/
    public static BufferedImage controlsPanelImage;
    
    /**controlsPanelImage0 BufferedImage of Menu*/
    public static BufferedImage controlsPanelImage0;
    
    /**controlsPanelImage1 BufferedImage of Menu*/
    public static BufferedImage controlsPanelImage1;
    
    /**gameplayPanelImage BufferedImage of Menu*/
    public static BufferedImage gameplayPanelImage;
    
    /**gameplayPanelImage0 BufferedImage of Menu*/
    public static BufferedImage gameplayPanelImage0;
    
    /**gameplayPanelImage1 BufferedImage of Menu*/
    public static BufferedImage gameplayPanelImage1;
    
    /**soundPanelImage BufferedImage of Menu*/
    public static BufferedImage soundPanelImage;
    
    /**soundPanelImage0 BufferedImage of Menu*/
    public static BufferedImage soundPanelImage0;
    
    /**soundPanelImage1 BufferedImage of Menu*/
    public static BufferedImage soundPanelImage1;
    
    /**devPanelImage BufferedImage of Menu*/
    public static BufferedImage devPanelImage;
    
    /**devPanelImage0 BufferedImage of Menu*/
    public static BufferedImage devPanelImage0;
    
    /**devPanelImage1 BufferedImage of Menu*/
    public static BufferedImage devPanelImage1;
    
    /**sliderIconImage BufferedImage of Menu*/
    public static BufferedImage sliderIconImage;
    
    /**mainPanelImage BufferedImage of Menu*/
    public static BufferedImage mainPanelImage;
    
    /**panelImage0 BufferedImage of Menu*/
    public static BufferedImage panelImage0;
    
    /**panelImage1 BufferedImage of Menu*/
    public static BufferedImage panelImage1;
    
    /**icon1 BufferedImage of Menu*/
    public static BufferedImage icon1;
    
    /**logo1 BufferedImage of Menu*/
    public static BufferedImage logo1;
    
    
    /**creditsX coordinate of Menu*/
    public static int creditsX;
    
    /**creditsY coordinate of Menu*/
    public static int creditsY;
    
    /**CreditsRectHeight variable of Menu*/
    public static int CreditsRectHeight;// = 135 / 12;
    
    /**CreditsRectWidth variable of Menu*/
    public static int CreditsRectWidth;// = 100 / 18;
    
    /**xSpace0 variable of Menu*/
    public static int xSpace0;// = 45;
    
    /**xSpace1 variable of Menu*/
    public static int xSpace1;// = 65;
    
    /**creditsr_w variable of Menu*/
    public static int creditsr_w;// = 18;
    
    /**creditsr_h variable of Menu*/
    public static int creditsr_h;// = 12;
    
    /**creditsWidth variable of Menu*/
    public static int creditsWidth = 340;
    
    /**creditsHeight variable of Menu*/
    public static int creditsHeight = 180;
    
    
    
    
    /**Links*/
    
    /**game Game of Menu*/ 
    public Game game;
    
    
    /**Public protocol*/

    
    /**
     * setUp()
     * 
     */
    public static void setUp(){
        
        resumeOffBtn = new Texture("/buttons/resume_off2").getImage();
        resumeOnBtn = new Texture("/buttons/resume_on2").getImage();
        restartOffBtn = new Texture("/buttons/restart_off2").getImage();
        restartOnBtn = new Texture("/buttons/restart_on2").getImage();
        quitOffBtn = new Texture("/buttons/quit_off3").getImage();
        quitOnBtn = new Texture("/buttons/quit_on3").getImage();
        
        backOffBtn = new Texture("/buttons/back_off2").getImage();
        backOnBtn = new Texture("/buttons/back_on2").getImage();
        OKOffBtn = new Texture("/buttons/ok_off2").getImage();
        OKOnBtn = new Texture("/buttons/ok_on2").getImage();
        cancelOffBtn = new Texture("/buttons/cancel_off2").getImage();
        cancelOnBtn = new Texture("/buttons/cancel_on2").getImage();
        
        skipOffBtn = new Texture("/buttons/skip_off2").getImage();
        skipOnBtn = new Texture("/buttons/skip_on2").getImage();

        leftArrowIcon = new Texture("/menu/arrow").getImage();
        rightArrowIcon = new Texture("/menu/arrowR").getImage();
        
        try {
            menuImage = ImageIO.read(Menu.class.getResource("/menu/menuState_2.png"));
            menuImage0 = ImageIO.read(Menu.class.getResource("/menu/menuState_1.png"));
            menuImage2 = ImageIO.read(Menu.class.getResource("/menu/menuState_2.png"));
            menuImage1 = ImageIO.read(Menu.class.getResource("/menu/menuState_3.png"));
            menuImage3 = ImageIO.read(Menu.class.getResource("/menu/menuState_4.png"));
            
//            icon1 = ImageIO.read(Menu.class.getResource("/Sprites/Planes-and-Saucers-Icon1.png"));
//            logo1 = ImageIO.read(Menu.class.getResource("/Sprites/Planes-and-Saucers-LOGO1.png"));
            
//            startMenuImage = ImageIO.read(Menu.class.getResource("/menu/startMenu_1.png"));
//            startMenuImage0 = ImageIO.read(Menu.class.getResource("/menu/startMenu_1.png"));
//            startMenuImage1 = ImageIO.read(Menu.class.getResource("/menu/startMenu_2.png"));
            
            instructionsMenuImage = ImageIO.read(Menu.class.getResource("/menu/instructionMenu_1.png"));
            instructionsMenuImage0 = ImageIO.read(Menu.class.getResource("/menu/instructionMenu_1.png"));
            instructionsMenuImage1 = ImageIO.read(Menu.class.getResource("/menu/instructionMenu_2.png"));
            
//            aboutMenuImage = ImageIO.read(Menu.class.getResource("/menu/aboutMenu_1.png"));
//            aboutMenuImage0 = ImageIO.read(Menu.class.getResource("/menu/aboutMenu_1.png"));
//            aboutMenuImage1 = ImageIO.read(Menu.class.getResource("/menu/aboutMenu_2.png"));
            
            optionsMenuImage = ImageIO.read(Menu.class.getResource("/menu/optionsMenu_2b.png"));
            optionsMenuImage0 = ImageIO.read(Menu.class.getResource("/menu/optionsMenu_2b.png"));
            optionsMenuImage1 = ImageIO.read(Menu.class.getResource("/menu/optionsMenu_1b.png"));
            optionsMenuImage2 = ImageIO.read(Menu.class.getResource("/menu/optionsMenu_3a.png"));
            
            mainPanelImage = ImageIO.read(Menu.class.getResource("/menu/optionsMenu_1a.png"));
            
            graphicsPanelImage = ImageIO.read(Menu.class.getResource("/menu/SI2018-PanelLgeBG.png"));
            graphicsPanelImage0 = ImageIO.read(Menu.class.getResource("/menu/SI2018-PanelLgeBG2.png"));
            graphicsPanelImage1 = ImageIO.read(Menu.class.getResource("/menu/SI2018-PanelLgeBG.png"));
            
            controlsPanelImage = ImageIO.read(Menu.class.getResource("/menu/SI2018-PanelLgeBG.png"));
            controlsPanelImage0 = ImageIO.read(Menu.class.getResource("/menu/SI2018-PanelLgeBG.png"));
            controlsPanelImage1 = ImageIO.read(Menu.class.getResource("/menu/SI2018-PanelLgeBG2.png"));
            
            gameplayPanelImage = ImageIO.read(Menu.class.getResource("/menu/SI2018-PanelLgeBG.png"));
            gameplayPanelImage0 = ImageIO.read(Menu.class.getResource("/menu/SI2018-PanelLgeBG.png"));
            gameplayPanelImage1 = ImageIO.read(Menu.class.getResource("/menu/SI2018-PanelLgeBG2.png"));
            
            soundPanelImage = ImageIO.read(Menu.class.getResource("/menu/SI2018-PanelLgeBG.png"));
            soundPanelImage0 = ImageIO.read(Menu.class.getResource("/menu/SI2018-PanelLgeBG.png"));
            soundPanelImage1 = ImageIO.read(Menu.class.getResource("/menu/SI2018-PanelLgeBG2.png"));
            
            devPanelImage = ImageIO.read(Menu.class.getResource("/menu/SI2018-PanelLgeBG.png"));
            devPanelImage0 = ImageIO.read(Menu.class.getResource("/menu/SI2018-PanelLgeBG.png"));
            devPanelImage1 = ImageIO.read(Menu.class.getResource("/menu/SI2018-PanelLgeBG2.png"));
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int width = Tetris.getMainWidth();
        switch(width){
            case 300:
                creditsr_w = 9;
                creditsr_h = 6;

                xSpace0 = 25;
                xSpace1 = 35;
                creditsX = width/2 - creditsWidth/2;
                creditsY = Tetris.getMainHeight()/2 - creditsHeight/2;

                CreditsRectWidth = 100 / creditsr_w;
                CreditsRectHeight = 135 / creditsr_h;
            
                break;
                
            case 480:
                creditsr_w = 18;
                creditsr_h = 12;

                xSpace0 = 45;
                xSpace1 = 65;
                creditsX = width/2 - creditsWidth/2;
                creditsY = Tetris.getMainHeight()/2 - creditsHeight/2;

                CreditsRectWidth = 100 / creditsr_w;
                CreditsRectHeight = 135 / creditsr_h;
            
                break;
                
            case 604:
                creditsr_w = 18;
                creditsr_h = 12;

                xSpace0 = 45;
                xSpace1 = 65;
                creditsX = width/2 - creditsWidth/2;
                creditsY = Tetris.getMainHeight()/2 - creditsHeight/2;

                CreditsRectWidth = 180 / creditsr_w;
                CreditsRectHeight = 115 / creditsr_h;
                
                break;
                
            default:
                creditsr_w = 18;
                creditsr_h = 12;

                xSpace0 = 45;
                xSpace1 = 65;
                creditsX = width/2 - creditsWidth/2;
                creditsY = Tetris.getMainHeight()/2 - creditsHeight/2;

                CreditsRectWidth = 180 / creditsr_w;
                CreditsRectHeight = 115 / creditsr_h;
                
                break;
        }
    }
    
    
    /**
    * render(Graphics2D g)
    * 
    * Renders/Repaints Menu Objects(Overridden)
    * 
    * @param game
    * @param g
    */     
    public void render(Game game, Graphics2D g) {
    }

    
    /**
    * tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean fire)
    * 
    * Updates Menu Object(Overridden)
    * 
    * @param game - the Game of Menu
    * @param up - the up variable of Menu
    * @param down - the down variable of Menu
    * @param left - the left variable of Menu
    * @param right - the right variable of Menu
    * @param fire - the fire variable of Menu
    */
    public void tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean fire) {
    }
    
}
