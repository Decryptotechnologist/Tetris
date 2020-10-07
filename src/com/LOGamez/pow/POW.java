/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.pow;

//import com.LOGamez.enemies.Enemy;
import com.LOGamez.graphics.Render;
import com.LOGamez.tetris.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Nicholas Wright
 */
public class POW {
    
    /**Attributes*/
    
    /**x variable of POW*/
    public int x;
    
    /**y variable of POW*/
    public int y;
    
    /**width variable of POW*/
    public static int pow_w;// = 40;
    
    /**height variable of POW*/
    public static int pow_h;// = 40;
    
    /**width variable of POW*/
    public int width;
    
    /**height variable of POW*/
    public int height;
    
    /**speed variable of POW*/
    public static int speed;
    
    /**visibility variable of POW*/
    public boolean visible;
    
    /**isDead variable of POW*/
    public boolean isDead;
    
    /**suit variable of POW*/
    public int suit;
    
    /**random variable of POW*/
    public static Random random;
    
    /**cannonPOWz List variable of POW*/
//    public static List<cannonPOW> cannonPOWz = new ArrayList<>();
    
    /**cannonPOWzA List variable of POW*/
//    public static List<cannonPOW> cannonPOWzA;
    
    /**shieldPOWz List variable of POW*/
//    public static List<shieldPOW> shieldPOWz = new ArrayList<>();
    
    /**shieldPOWzA List variable of POW*/
//    public static List<shieldPOW> shieldPOWzA;
    
    /**speedPOWz List variable of POW*/
//    public static List<speedPOW> speedPOWz = new ArrayList<>();
    
    /**speedPOWzA List variable of POW*/
//    public static List<speedPOW> speedPOWzA;
    
    /**extraLifePOWz List variable of POW*/
//    public static List<extraLifePOW> extraLifePOWz = new ArrayList<>();
    
    /**extraLifePOWzA List variable of POW*/
//    public static List<extraLifePOW> extraLifePOWzA;
    
    
    
    /**Constructor*/
    
    /**
     * POW Constructor
     * 
     */ 
    public POW(){
        System.out.println("POW: New POW Created");
        random = new Random();
        setUP();
    }
    
    
    /**Public Protocol*/   


    /**
     * setUP()
     * 
     */
    private void setUP() {
        int screenWidth = Tetris.getMainWidth();
        switch(screenWidth){
            case 300:
                pow_w = 25;
                pow_h = 25;
            
                break;
                
            case 480:
                pow_w = 30;
                pow_h = 30;
                
                break;
                
            case 604:
                pow_w = 40;
                pow_h = 40;
                
                break;
                
            default:
                pow_w = 40;
                pow_h = 40;
                
                break;
                
        }
        
    }
    
    
    /**
     * init(Enemy en)
     * 
     * initiate POW objects
     * 
     * @param en
     */
//    public static void init(Enemy en){
//        int choice = random.nextInt(4)+1;
//        
//        if(choice == 1){
//            cannonPOW.init(en);
//        }
//        if(choice == 2){
//            shieldPOW.init(en);
//        }
//        if(choice == 3){
//            speedPOW.init(en);
//        }
//        if(choice == 4){
//            extraLifePOW.init(en);
//        }
//        
//    }
    
    
    /**
    * getBounds()
    * 
    * @return null
    */ 
    public Rectangle getBounds(){
      return null;
    }
    
    
    /**
    * move(POW p)
    * 
    * Moves each of the POW objects (depending how
    * many POW objects remain in POWz List) 
    * after checking that the POW object isDead 
    * value is false and visible value is true.
    * 
    * @param p the p reference of an POW object (within POWz List)
    */
    public static void move(POW p){
        if(p.visible == true){
//            if(p instanceof cannonPOW){
//                cannonPOW.move((cannonPOW) p);
//            } else if(p instanceof shieldPOW){
//                shieldPOW.move((shieldPOW) p);
//            } else if(p instanceof speedPOW){
//                speedPOW.move((speedPOW) p);
//            } else if(p instanceof extraLifePOW){
//                extraLifePOW.move((extraLifePOW) p);
//            }
        }
    }

        
    /**
    * tick()
    * 
    * Updates POW Objects
    */
    public static void tick(){
        checkCollisions();
        
//        cannonPOW.tick();
//        shieldPOW.tick();
//        speedPOW.tick();
//        extraLifePOW.tick();        
    }
    
    
    /**
    * render()
    * 
    * Renders/Repaints POW Objects
    * 
    * @param target
    * @param g
    */
    public static void render(Render target, Graphics2D g) {
//        cannonPOW.render(target, g);
//        shieldPOW.render(target, g);
//        speedPOW.render(target, g);
//        extraLifePOW.render(target, g);
    }

    
    /**
    * checkCollisions()
    * 
    */
    private static void checkCollisions() {

        //Check collisions between cannonPOWs & Player1
//        for(int c = 0; c < cannonPOWz.size(); c++){
//            if(cannonPOWz.get(c).isDead == false){
//                //cannonPOWz.get(c).move(c);
//                move(cannonPOWz.get(c));
//                
//                if(cannonPOWz.get(c).getBounds().intersects(Game.player.P1rect)){
//                    
//                    //message POW hit  POWHit(int id)
//                    //cannonPOWz.get(c).POWHit(c);
//                    POWHit(cannonPOWz.get(c));
//                        
//                    //play sound
//                    if(Game.getGameSound()){
//                        Sound.chargeCannon.play();
//                    }
//                }
//            }
//        }
        
        //Check collisions between shieldPOWs & Player1
//        for(int c = 0; c < shieldPOWz.size(); c++){
//            if(shieldPOWz.get(c).isDead == false){
//                //shieldPOWz.get(c).move(c);
//                move(shieldPOWz.get(c));
//                
//                if(shieldPOWz.get(c).getBounds().intersects(Game.player.P1rect)){
//                    
//                    //message POW hit  POWHit(int id)
//                    //shieldPOWz.get(c).POWHit(c);
//                    POWHit(shieldPOWz.get(c));
//                        
//                    //play sound
//                    if(Game.getGameSound()){
//                        Sound.shieldOn.play();
//                    }
//                }
//            }
//        }
        
        //Check collisions between speedPOWs & Player1
//        for(int c = 0; c < speedPOWz.size(); c++){
//            if(speedPOWz.get(c).isDead == false){
//                //speedPOWz.get(c).move(c);
//                move(speedPOWz.get(c));
//                
//                if(speedPOWz.get(c).getBounds().intersects(Game.player.P1rect)){
//                    
//                    //message POW hit  POWHit(int id)
//                    //speedPOWz.get(c).POWHit(c);
//                    POWHit(speedPOWz.get(c));
//                        
//                    //play sound
//                    if(Game.getGameSound()){
//                        Sound.speedOn.play();
//                    }
//                }
//            }
//        }
        
        //Check collisions between extraLifePOWs & Player1
//        for(int c = 0; c < extraLifePOWz.size(); c++){
//            if(extraLifePOWz.get(c).isDead == false){
//                //extraLifePOWz.get(c).move(c);
//                move(extraLifePOWz.get(c));
//                
//                if(extraLifePOWz.get(c).getBounds().intersects(Game.player.P1rect)){
//                    
//                    //message POW hit  POWHit(int id)
//                    //extraLifePOWz.get(c).POWHit(c);
//                    POWHit(extraLifePOWz.get(c));
//                    Game.player.extraLife();
//                        
//                    //play sound
//                    if(Game.getGameSound()){
//                        Sound.extraLife.play();
//                    }
//                }
//            }
//        }
        
    }
    
    
    /**
    * POWHit(POW p)
    * 
    * @param p
    */
    public static void POWHit(POW p){
        if(p.visible == true){
//            if(p instanceof cannonPOW){
//                cannonPOW.POWHit((cannonPOW) p);
//            } else if(p instanceof shieldPOW){
//                shieldPOW.POWHit((shieldPOW) p);
//            } else if(p instanceof speedPOW){
//                speedPOW.POWHit((speedPOW) p);
//            } else if(p instanceof extraLifePOW){
//                extraLifePOW.POWHit((extraLifePOW) p);
//            }
        }
    }
    
}
