/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.tetris;

import com.LOGamez.graphics.Texture;
import com.LOGamez.gui.*;
import com.LOGamez.utils.Util;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author Nicholas Wright
 */
public class Tetris {

    /**Attributes*/
    
    /**frame variable of Tetris*/
    JFrame frame;
    
    /**panel variable of Tetris*/
    JPanel panel;
    
    /**raisedBevel variable of Tetris*/
    Border raisedBevel;
    
    /**mainWidth variable of Tetris*/
    static int mainWidth;
    
    /**mainHeight variable of Tetris*/
    static int mainHeight;

    /**icon variable of Tetris*/
    private BufferedImage icon;
    
    /**currentStatus String of Tetris*/
    private static String currentStatus = "Ready.";
    
    /**audioMap Map<String, AudioClip> of Tetris*/
    public static Map<String, AudioClip> audioMap = new HashMap<String, AudioClip>();
    
    /**sndMap Map<String, Clip> of Tetris*/
    public static Map<String, Clip> sndMap = new HashMap<String, Clip>();
    
    /**audioCount variable of Tetris*/
    public static int audioCount = 0;
    
    /**soundCount variable of Tetris*/
    public static int soundCount = 0;
    
    /**colours variable of Tetris*/
    public static Color[] colours ={
        Color.black, 
        Color.blue, 
        Color.cyan, 
        Color.darkGray, 
        Color.gray, 
        Color.green, 
        Color.lightGray, 
        Color.magenta, 
        Color.orange, 
        Color.pink, 
        Color.red, 
        Color.white, 
        Color.yellow
    };
    
    /**optionsWindow JPanel of Tetris*/
    public static JPanel optionsWindow;
    
    
    /**Links*/
    
    /**menuBR MainMenu of Tetris*/
    public static MainMenu menuBR;
    
    /**statusBar StatusBar of Tetris*/
    public static StatusBar statusBar;
    
    /**game Game of Tetris*/
    public Game game;
    
    
    
    
    
    /**Constructor*/
    
    
    /**
     * Tetris Constructor
     *
     */
    public Tetris(){
        System.out.println("Tetris: New Tetris created");
        
        setIcon();
        setLAF();
        
        //Create new JFrame: frame(Game.TITLE+" "+Game.version)
        frame = new JFrame(Game.TITLE+" "+Game.version);
        
        //Create new Game: Game()
        game = new Game(getMainWidth(), getMainHeight());
        
        //Create new MainMenu: MainMenu(game)
        menuBR = new MainMenu(game);
        
        //Create size: new Dimension(getMainWidth(), getMainHeight())
        Dimension size = new Dimension(getMainWidth(), getMainHeight());
        
        //Create panel: new JPanel(new BorderLayout())
        panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(size);
        
        //Create new JPanel: optionsWindow(new FlowLayout())
        optionsWindow = new JPanel(new FlowLayout());
        optionsWindow.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.96f));
        optionsWindow.setSize(getMainWidth(), getMainHeight());
        optionsWindow.setOpaque(true);
        optionsWindow.setVisible(false);
        
        //Create new StatusBar: statusBar("", SwingConstants.CENTER, raisedBevel)
        statusBar = new StatusBar("Ready.", SwingConstants.CENTER, raisedBevel);
        statusBar.setVisible(true);
        
        panel.add(optionsWindow, BorderLayout.CENTER);
        panel.add(game, BorderLayout.CENTER);
        panel.add(statusBar, BorderLayout.SOUTH);
        
        
        //Setup frame
        frame.setSize(size);
        frame.setContentPane(panel);
        frame.setIconImage(icon);
        frame.pack();
        
        frame.setVisible(true);
        frame.setJMenuBar(menuBR);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        frame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.err.println("Exiting Game . . .");
                game.quitGame();
            }
        }); 
        
        
    }
    
    
    /**Public Protocol*/
    
    
    /**
     * memoryToMB(long mem)
     * 
     * @param mem 
     * 
     * @return  dec.format(result);
     */
    public static String memoryToMB(long mem){
        DecimalFormat dec = new DecimalFormat("#0.00");
        double result = (double) mem / (double) (1024 * 1024);
        return dec.format(result);
    }
    
    /**
     * getMainWidth()
     * 
     * 
     * @return mainWidth
     */
    public static int getMainWidth(){
        if(mainWidth < 600){
            setMainWidth(600);
        }
        return mainWidth;
    }
    
    
    /**
     * setMainWidth(int width)
     * 
     * @param width
     */
    private static void setMainWidth(int width) {
        mainWidth = width;
    }

    
    /**
     * getMainHeight()
     * 
     * @return mainHeight
     */
    public static int getMainHeight(){
        if(mainHeight < 720){
            setMainHeight(720);
        }
        return mainHeight;
    }
    
    
    /**
     * setMainHeight(int height)
     * 
     * @param height 
     */
    private static void setMainHeight(int height) {
        mainHeight = height;
    }
    
    
    /**
    * revalidate()
    * 
    */
    public static void revalidate(){
        // NOTE: Here we need a workaround for the HW/LW Mixing feature to work
        // correctly due to yet unfixed bug 6852592.
        // The JTextField is a validate root, so the revalidate() method called
        // during the setText() operation does not validate the parent of the
        // component. Therefore, we need to force validating its parent here.
        Container parent = menuBR.getParent();
        if (parent instanceof JComponent) {
            ((JComponent)parent).revalidate();
        }
    }
    
    
    /**
    * addOptions()
    * 
    */
    public static void addOptions() {
        System.out.println("Tetris: Adding Options");
        optionsWindow.setVisible(true);
    }
    
    
    /**
    * removeOptions()
    * 
    */
    public static void removeOptions() {
        System.out.println("Tetris: Removing Options");
        optionsWindow.setVisible(false);
        optionsWindow.removeAll();
    }
    
    
    /**
    * setStatusBar(String msg)
    * 
    * @param msg
    */
    public static void setStatusBar(String msg) {
        //System.out.println("Tetris: Setting Status Bar: "+msg);
        currentStatus = msg;
        statusBar.setText(msg);
    }
    
    
    /**
    * getStatusBar()
    * 
    * @return currentStatus
    */
    public static String getStatusBar() {
        return currentStatus;
    }
    
    
    /**
     * setIcon()
     * 
     */
    private void setIcon() {
        System.out.println("Tetris: Setting Icon");
        this.icon = new Texture("/icon/Tetris-icon-16").getImage();
    }

    
    /**
     * setLAF()
     * 
     */
    private void setLAF() {
        System.out.println("Tetris: Setting LAF");
        raisedBevel = BorderFactory.createRaisedBevelBorder();
    }

    
    /**
     * main(String[] args)
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("Starting " + Game.TITLE + " . . . Started by " + Util.getUserNAME());
        System.out.println("Running on OS:     " + Util.getOSName() + " "
                + Util.getOSARC() + " "+Util.getOSVER() +" Processor Cores: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Working Directory: " + Util.getDIR());
        System.out.println("Home Directory:    " + Util.getHomeDIR());
        System.out.println("Memory: Max Memory: " + memoryToMB(Runtime.getRuntime().maxMemory()) + " MB");
        System.out.println("Memory: Total Memory: " + memoryToMB(Runtime.getRuntime().totalMemory()) + " MB");
        System.out.println("Memory: Free Memory: " + memoryToMB(Runtime.getRuntime().freeMemory()) + " MB");
        System.out.println("Memory: Used Memory: " + memoryToMB(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) + " MB");
        System.out.println("");
        
        //Splashscreen code here
        SplashScreenDriver splashScreenDriver = new SplashScreenDriver();
        
        // TODO code application logic here
        Tetris tetris1 = new Tetris();
        
    }
    
}
