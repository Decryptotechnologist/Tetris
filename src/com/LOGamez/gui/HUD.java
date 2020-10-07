/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.gui;

import com.LOGamez.graphics.*;
import com.LOGamez.tetris.*;
import com.LOGamez.player.Player;
import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Nicholas Wright
 */
public class HUD {

    /**Attributes*/
    
    /**ceilBounds Rectangle of HUD object*/ 
    public static Rectangle ceilBounds;
    
    /**currentFont Font of HUD object*/ 
    private Font currentFont;
    
    /**gameScoreX variable of HUD object*/ 
    private int gameScoreX;
    
    
    
    /**Links*/
    
    
    
    /**Constructor*/
    
    /**
     * HUD()
     * 
     */
    public HUD() {
        System.out.println("HUD: New HUD Created");
        
        setUp();
    }
    
    
    /**Public protocol*/
    
    
    /**
     * setUp()
     * 
     */
    private void setUp(){        
        Player.levelNo = "Lv";
        Player.livesNo = "L";
    }
    
    
    /**
     * init()
     * 
     */
    private void init(){
        
    }
    
    
    /**
    * render(Render target, Graphics2D g)
    * 
    * Renders/Repaints Level Objects
    * 
    * @param target - the Render of Level
    * @param g2d
    */
    public void render(Render target, Graphics2D g2d){
        Graphics2D g2d_HUD = g2d;
        AffineTransform oldXForm = g2d.getTransform();
        
        if(Game.showHUD){
//            if(!Level.levelComplete && Game.pauseTime == 0){
//                target.scaleDraw(Texture.livesLabel, Labels.LabelScale, Labels.livesLabelX, Labels.livesLabelY, 0, 0, 64, 64, Labels.livesLabelBGCol);
//                target.scaleDraw(Texture.livesLabel, Labels.LabelScale, Labels.livesLabelX-2, Labels.livesLabelY-2, 0, 0, 64, 64, Labels.livesLabelFGCol);
//
//                if(Game.gameScore >= 100000){
//                    target.scaleDraw(Texture.scoreLabel, Labels.LabelScale, Labels.scoreLabelX-20, Labels.scoreLabelY, 0, 0, 64, 64, Labels.scoreLabelBGCol);
//                    target.scaleDraw(Texture.scoreLabel, Labels.LabelScale, Labels.scoreLabelX-18, Labels.scoreLabelY-2, 0, 0, 64, 64, Labels.scoreLabelFGCol);
//                } else {
//                    target.scaleDraw(Texture.scoreLabel, Labels.LabelScale, Labels.scoreLabelX, Labels.scoreLabelY, 0, 0, 64, 64, Labels.scoreLabelBGCol);
//                    target.scaleDraw(Texture.scoreLabel, Labels.LabelScale, Labels.scoreLabelX-2, Labels.scoreLabelY-2, 0, 0, 64, 64, Labels.scoreLabelFGCol);
//                }
            }

            Player.levelNo = "Lv-"+Game.levelNo;
            Player.livesNo = "L-"+Player.lives;

            if(Game.gameScore == 0){
//                gameScoreX = Labels.scoreX-5;
//                Game.fox.setPlayScore("0000");
            } else if(Game.gameScore > 0  && Game.gameScore < 100){
//                gameScoreX = Labels.scoreX-5;
//                Game.player.setPlayScore("00"+Game.gameScore);
            } else if(Game.gameScore >= 100 && Game.gameScore < 1000){
//                gameScoreX = Labels.scoreX-5;
//                Game.player.setPlayScore("0"+Game.gameScore);
            } else if(Game.gameScore >= 1000 && Game.gameScore < 100000){
//                gameScoreX = Labels.scoreX-5;
//                Game.player.setPlayScore(""+Game.gameScore);
            } else if(Game.gameScore >= 100000){
//                gameScoreX = Labels.scoreX-(5 + Game.player.getPlayScore().length());
//                Game.player.setPlayScore(""+Game.gameScore);
            }   
            

            if(Game.showBounds){
                g2d_HUD.setColor(Color.LIGHT_GRAY);
                g2d_HUD.drawRect(ceilBounds.x, ceilBounds.y, ceilBounds.width - 1, ceilBounds.height);
                
                //Draw Bottom EOS Bounds
                g2d_HUD.setColor(Color.green);
//                g2d_HUD.drawRect(0, Level.getLevelHeight() - 12, Level.getLevelWidth(), 5);

                //Draw Left EOS Bounds
                g2d_HUD.setColor(Color.green);
//                g2d_HUD.drawRect(0, 12, 5, Level.getLevelHeight());

                //Draw Right EOS Bounds
                g2d_HUD.setColor(Color.green);
//                g2d_HUD.drawRect(Level.getLevelWidth()+4, 12, 5, Level.getLevelHeight());
            }   


            currentFont = new Font("default", Font.PLAIN, 12);
            g2d_HUD.setFont(currentFont);
            g2d_HUD.setColor(Color.black);
//            g2d_HUD.drawString(Player.livesNo, Labels.playerNameX-29, Labels.playerNameY-3);
            g2d_HUD.setColor(Color.red);
//            g2d_HUD.drawString(Player.livesNo, Labels.playerNameX-30, Labels.playerNameY-4);
            //target.draw(Player.playName, Labels.playerNameX, Labels.playerNameY, 0x00ff0c);
            
            currentFont = new Font("default", Font.BOLD, 14);
            g2d_HUD.setFont(currentFont);
            g2d_HUD.setColor(Color.black);
//            g2d_HUD.drawString(Player.playName, Labels.playerNameX+2, Labels.playerNameY-2);
            g2d_HUD.setColor(Color.green);
//            g2d_HUD.drawString(Player.playName, Labels.playerNameX, Labels.playerNameY-4);
            //target.draw(Player.levelNo, Labels.playerNameX+126, Labels.playerNameY, 0xdd0f0c);
            
            currentFont = new Font("default", Font.PLAIN, 12);
            g2d_HUD.setFont(currentFont);
            g2d_HUD.setColor(Color.black);
//            g2d_HUD.drawString(Player.levelNo, Labels.playerNameX+127, Labels.playerNameY-3);
            g2d_HUD.setColor(Color.red);
//            g2d_HUD.drawString(Player.levelNo, Labels.playerNameX+126, Labels.playerNameY-4);
            
            //Draw Player Lives
            if(Player.lives == 3){
//                g2d_HUD.drawImage(Player.imgPLives, Player.pLives2X, Player.pLivesY, Player.pLivesScale, Player.pLivesScale, null);
//                g2d_HUD.drawImage(Player.imgPLives, Player.pLives1X, Player.pLivesY, Player.pLivesScale, Player.pLivesScale, null);
//                g2d_HUD.drawImage(Player.imgPLives, Player.pLives0X, Player.pLivesY, Player.pLivesScale, Player.pLivesScale, null);
            }

            if(Player.lives == 2){
//                g2d_HUD.drawImage(Player.imgPLives, Player.pLives1X, Player.pLivesY, Player.pLivesScale, Player.pLivesScale, null);
//                g2d_HUD.drawImage(Player.imgPLives, Player.pLives0X, Player.pLivesY, Player.pLivesScale, Player.pLivesScale, null);
            }

            if(Player.lives == 1 || Player.lives > 3){
//                g2d_HUD.drawImage(Player.imgPLives, Player.pLives0X, Player.pLivesY, Player.pLivesScale, Player.pLivesScale, null);
                if(Player.lives > 3){
//                    String l = "X "+Player.lives;
//                    currentFont = new Font("default", Font.BOLD, 24);
//                    g2d_HUD.setFont(currentFont);
//                    g2d_HUD.setColor(Color.black);
//                    g2d_HUD.drawString(l, Player.pLives1X, Player.pLivesY+24);
//                    g2d_HUD.setColor(Color.green);
//                    g2d_HUD.drawString(l, Player.pLives1X-2, Player.pLivesY+22);
//                    currentFont = new Font("default", Font.PLAIN, 10);
//                    g2d_HUD.setFont(currentFont);
                }
            }
            
            if(Game.showFPS){
                currentFont = new Font("default", Font.PLAIN, 12);
                g2d_HUD.setFont(currentFont);
                //target.drawString(fps, fpsX, fpsY+5, 0x00ff00);
                g2d_HUD.setColor(Color.black);
                if(Game.showUPS){                    
//                    g2d_HUD.drawString(Game.theFPS, Level.fpsX+1, Level.fpsY+1);
                    g2d_HUD.setColor(Color.yellow);
//                   g2d_HUD.drawString(Game.theFPS, Level.fpsX, Level.fpsY);
                } else {
//                    g2d_HUD.drawString(Game.theFPS, Level.fpsX+1, Level.upsY+1);
                    g2d_HUD.setColor(Color.yellow);
//                    g2d_HUD.drawString(Game.theFPS, Level.fpsX, Level.upsY);
                }
            }
            
            if(Game.showUPS){
                currentFont = new Font("default", Font.PLAIN, 12);
                g2d_HUD.setFont(currentFont);
                //ups = Game.theUPS;
                //target.drawString(ups, upsX, upsY, 0x00ffe0);
                g2d_HUD.setColor(Color.black);
//                g2d_HUD.drawString(Game.theUPS, Level.upsX+1, Level.upsY+1);
                g2d_HUD.setColor(Color.green);
//                g2d_HUD.drawString(Game.theUPS, Level.upsX, Level.upsY);
            }
            
            if(Game.showGameTime){
                //gTime = Game.theGameTime;
                currentFont = new Font("default", Font.BOLD, 16);
                g2d_HUD.setFont(currentFont);
                g2d_HUD.setColor(Color.black);
//                g2d_HUD.drawString(Game.theGameTime, Level.gTimeX+2, Level.gTimeY+2);
                g2d_HUD.setColor(Color.red);
//                g2d_HUD.drawString(Game.theGameTime, Level.gTimeX, Level.gTimeY);
                currentFont = new Font("default", Font.PLAIN, 12);
                g2d_HUD.setFont(currentFont);
            }
            
            if(Game.showLevelTime){
                //gTime = Game.theGameTime;
                currentFont = new Font("default", Font.BOLD, 16);
                g2d_HUD.setFont(currentFont);
                g2d_HUD.setColor(Color.black);
//                g2d_HUD.drawString(Level.theLevelTime, Level.gTimeX+2, Level.gTimeY-18);
                g2d_HUD.setColor(Color.green);
//                g2d_HUD.drawString(Level.theLevelTime, Level.gTimeX, Level.gTimeY-20);
                currentFont = new Font("default", Font.PLAIN, 12);
                g2d_HUD.setFont(currentFont);
            }
            
            
            
            if (Game.pauseTime > 0 && !Game.paused && Game.getGame().menu == null) {
                //if(Level.levelComplete){
                    long time = System.currentTimeMillis();
                    //P1Explode.clearAll();
                    //P1Bullet.clearAll();

  //                  for (Level.levelCompleteCount = 0; Level.levelCompleteCount < 500; Level.levelCompleteCount++) {
                        System.out.println("Level: Drawing Level Complete Text");
                        
                        //Draw scaled 3D SI Icon: GOLD
                        if(time / 25 % 5 == 0){
                            //render Space Invaders Icon
                            //target.scaleDraw(Texture.buttonsA, 3, 234, 132, 48, 126, 50, 38, 0xFFBF00);
                            //target.scaleDraw(Texture.buttonsA, 3, 230, 128, 48, 126, 50, 38, 0xBF9B30);
                        } else if(time / 200 % 40 == 0){
                            //render Space Invaders Icon
                            //target.scaleDraw(Texture.buttonsA, 3, 234, 132, 48, 126, 50, 38, 0xBF9B30);
                            //target.scaleDraw(Texture.buttonsA, 3, 230, 128, 48, 126, 50, 38, 0xFFBF00);
                        }
                        if (time / 450 % 2 == 0) {

                            //COMPLETE
                            currentFont = new Font("default", Font.BOLD, 36);
                            g2d_HUD.setFont(currentFont);
                            g2d_HUD.setColor(new Color(0xBF9B30));
//                            g2d_HUD.drawString("COMPLETE", Labels.click2FocusX+120, Labels.click2FocusY+40);
                            g2d_HUD.setColor(new Color(0xffffff));
//                            g2d_HUD.drawString("COMPLETE", Labels.click2FocusX+124, Labels.click2FocusY+36);
                            currentFont = new Font("default", Font.PLAIN, 12);
                            g2d_HUD.setFont(currentFont);
                            
                            //target.scaleDraw(Texture.buttonsA, Labels.click2FocusScale, Labels.click2FocusX-20, Labels.click2FocusY+40, 235, 200, 220, 30, 0xBF9B30);
                            //target.scaleDraw(Texture.buttonsA, Labels.click2FocusScale, Labels.click2FocusX-24, Labels.click2FocusY+36, 235, 200, 220, 30, 0xffffff);


                            //Level
                            currentFont = new Font("default", Font.BOLD, 36);
                            g2d_HUD.setFont(currentFont);
//                            g2d_HUD.setColor(new Color(Level.levelTxtBGCol));
//                            g2d_HUD.drawString("LEVEL", Labels.LevelX-100, Labels.LevelY);
                            g2d_HUD.setColor(new Color(0xffffff));
//                            g2d_HUD.drawString("LEVEL", Labels.LevelX-96, Labels.LevelY-4);
                            currentFont = new Font("default", Font.PLAIN, 12);
                            g2d_HUD.setFont(currentFont);
                            
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelX-120, Labels.LevelY, 130, 300, 73, 35, levelTxtBGCol);
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelX-116, Labels.LevelY-4, 130, 300, 73, 35, 0xffffff);
                            
                            System.out.println("Level: Drawing Level 1 No.");
                            String lvlNo = ""+Game.levelNo;
                            currentFont = new Font("default", Font.BOLD, 36);
                            g2d_HUD.setFont(currentFont);
//                            g2d_HUD.setColor(new Color(Level.levelTxtBGCol));
//                            g2d_HUD.drawString(lvlNo, Labels.LevelX+50, Labels.LevelY);
                            g2d_HUD.setColor(new Color(0xffffff));
//                            g2d_HUD.drawString(lvlNo, Labels.LevelX+46, Labels.LevelY-4);
                            currentFont = new Font("default", Font.PLAIN, 12);
                            g2d_HUD.setFont(currentFont);

                        } else {
                            //target.drawText("Level Bonus: "+Game.getLevelBonus(), 3, Labels.enterLevelX+120, Labels.enterLevelY+275, 0xffffff);
                        }

                        System.out.println("Level: Drawing Level 1 Name");
                        currentFont = new Font("default", Font.BOLD, 16);
                        g2d_HUD.setFont(currentFont);
//                        g2d_HUD.setColor(new Color(Level.levelTxtBGCol));
//                        g2d_HUD.drawString(Level.getLevelName(), Labels.enterLevelX+180, Labels.enterLevelY+40);
                        g2d_HUD.setColor(new Color(0xffffff));
//                        g2d_HUD.drawString(Level.getLevelName(), Labels.enterLevelX+182, Labels.enterLevelY+38);
                        currentFont = new Font("default", Font.PLAIN, 12);
                        g2d_HUD.setFont(currentFont);
                            

            } else {           
            
            
            g2d.setTransform(oldXForm);
        }
    }
    
}
