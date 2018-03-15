/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cookie.game;

import javax.swing.JFrame;
import java.awt.CardLayout;
import com.cookie.game.screens.StartGamePanel;
import com.cookie.levels.Level1;
import java.awt.Dimension;


/**
 *
 * @author 1739288
 */
public class CookieGame {
    
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 600;
    
    JFrame gameWindow; //Main game window, where components are added.
    StartGamePanel startScreen; //Startng screen before game is played.
    Level1 lvl1; //Object for Level1
    
    public CookieGame()
    {
        initWindow();
        initScreens();
    }

    private void initWindow()
    {
        gameWindow = new JFrame();
        gameWindow.setSize(WINDOW_WIDTH, WINDOW_HEIGHT); //Sets size
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Sets default close operation
        gameWindow.getContentPane().setLayout(new CardLayout()); //Adding CardLayout, to add game screens
        gameWindow.setResizable(false); //Disables resizing the window
        gameWindow.setLocationRelativeTo(null); //Centres the window
        gameWindow.setTitle("Cookie Chaser"); //Sets title
    }
    
    private void initScreens()
    {
        startScreen = new StartGamePanel(this);
        startScreen.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        lvl1 = new Level1(this);
        lvl1.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        
        //This will add a start Screen to the Main Window
        gameWindow.getContentPane().add(startScreen, "INTRO");
        gameWindow.getContentPane().add(lvl1, "LVL1");
    }
    
    public static void main(String[] args)
    {
        CookieGame window = new CookieGame();
        window.showStartScreen();
    }
        
    /*public void startGame()
    {
        //
    }*/
    
    public void showStartScreen()
    {
        gameWindow.setVisible(true);
        startScreen.requestFocus();
    }
    
    public void startGame()
    {
        //This method will start the main game
        CardLayout cl = (CardLayout)gameWindow.getContentPane().getLayout();
        
        cl.next(gameWindow.getContentPane());
        lvl1.requestFocus();
        lvl1.start();
    }
    
}