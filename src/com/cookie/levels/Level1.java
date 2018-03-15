package com.cookie.levels;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.Timer;
import com.cookie.game.CookieGame;
import com.cookie.character.Player;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This panel represents the game world.
 * It contains all of the objects that take part in the game.
 * It uses a timer to update every 10 milliseconds.
 * It uses a keyAdapter to listen for user key presses and update the
 * player's position.
 */

public class Level1 extends JPanel implements ActionListener
{
    private CookieGame game;
    private Timer timer;
    BufferedImage background;
    private Player thePlayer;
    
    public Level1(CookieGame theGame)
    {
        game = theGame;
        thePlayer = new Player();
        init();
        
    }
    
    /**
     * This is the private init method that we use to set defaults for the
     * level.
     * We can call this method to reset the level (if required) - we can't
     * do that with the constructor method - that can only be called once.
     */
    private void init()
    {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setDoubleBuffered(true);
        
        try
        {
            background = ImageIO.read(getClass().getResource("/Images/background.png"));
        }catch(Exception ex)
        {
            System.err.println("Error loading background image");
        }
        
        timer = new Timer(10, this);
    }
    
    /**
     * This method initiates the in-game drawing.
     * The graphics parameter allows drawing operations to be carried out on
     * the component.
     * 
     * We use this method to draw all of the game components - layering them
     * from back to front.
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //Draw Background
        g2d.drawImage(background, 0, 0, null);
        
        //Draw all game objects by calling their draw method
        thePlayer.draw(g2d);
        
        g.dispose();
    }
    
    /**
     * This method will be called to check for collisions
     */
    public void collisions()
    {
        
    }
    
    public void start()
    {
        timer.start();
    }
    
    public void stop()
    {
        timer.stop();
    }
    
     public void movement()
    {
        thePlayer.doMove();
    }
    
    /**
     * This method is called in response to the timer firing.
     * Every 10 milliseconds, this method will update the state of the game
     * in response to changes such as key presses and to generate computer
     * movement.
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        //The repaint method starts the process of updating the screen - calling
        //our version of the paintComponent method, which has the code for
        //drawing our characters and objects.
        collisions();
        movement();
        repaint();
    }
    
    /**
     * This is a private keyAdapter Class that we use to process key presses.
     */
    private class TAdapter extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            int move = 0;
            
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_UP:
                    move = 1;
                    break;
                case KeyEvent.VK_DOWN:
                    move = 2;
                    break;
                case KeyEvent.VK_LEFT:
                    move = 3;
                    break;
                case KeyEvent.VK_RIGHT:
                    move = 4;
                    break;
            }
            thePlayer.move(move);
        }
        
        @Override
        public void keyReleased(KeyEvent e)
        {
            thePlayer.stop();
        }
    }
    
}
