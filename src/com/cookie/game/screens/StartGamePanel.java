/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cookie.game.screens;

import com.cookie.game.CookieGame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author 1739288
 */
public class StartGamePanel extends JPanel{
    
    private CookieGame game; //Links back to Game controller class
    private BufferedImage backgroundImage = null; //Background image
    
    public StartGamePanel(CookieGame theGame)
    {
        game = theGame;
        init();
    }
    
    private void init()
    {
        //Load background image
        try
        {
            backgroundImage = ImageIO.read(getClass().getResource("/Images/background.png"));
        }catch(Exception ex)
        {
            System.err.println("Error Loading Image");
        }
        
        //Make sure the panel has the GUI focus
        //so keypresses are registered to this panel
        setFocusable(true);
        
        addKeyListener(new TAdapter());
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        //Call paintComponent method on the superclass to initialise drawing
        super.paintComponent(g);
        
        //Start drawing, with background first
        g.drawImage(backgroundImage, 0, 0, null);
    }
    
    private class TAdapter extends KeyAdapter
    {
        @Override
        public void keyReleased(KeyEvent e)
        {
            //This if statement checks if the key press is P.
            //If it is a P, then we use the gameWindow link
            //to tell the Game Object that the user has pressed P.
            if(e.getKeyCode() == KeyEvent.VK_P)
                game.startGame();
        }
        
        @Override
        public void keyPressed(KeyEvent e)
        {
            
        }
    }
    
}
