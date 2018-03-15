package com.cookie.character;

import javax.imageio.ImageIO;
import com.cookie.levels.Vector;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Player {
    
    //Vectors to represent the character's current position
    //and movement from the current position.
    Vector position;
    Vector displacement;
    
    //This image represents the character.
    private BufferedImage sprite;
    
    //This variable stores the width of the image.
    private int spriteWidth;
    //This variable stores the height of the image.
    private int spriteHeight;
    //A score value - could be health or any other appropriate value.
    private int score;
    
    /**
     * Default constructor that sets X and Y coordinates to 10.
     */
    public Player()
    {
        //Starting X and Y coordinates
        position = new Vector(100, 100);
        
        //This vector will hold the movement from the current position.
        displacement = new Vector(0,0);
        score = 0;
        init();
    }
    
    /**
     * This method is called to initialise the player.
     */
    private void init()
    {
        try
        {
            sprite = ImageIO.read(getClass().getResource("/Images/character.png"));
        }catch(Exception ex)
        {
            System.err.println("Error loading player sprite");
        }
        
        spriteWidth = sprite.getWidth();
        spriteHeight = sprite.getHeight();
    }
    
    public void setPosition(Vector v)
    {
        position = v;
    }
    
    public Vector getPosition()
    {
        return position;
    }
    
    public int getSpriteWidth()
    {
        return spriteWidth;
    }
    
    public int getSpriteHeight()
    {
        return spriteHeight;
    }
    
    public void setScore(int newScore)
    {
        score = newScore;
    }
    
    public int getScore()
    {
        return score;
    }
    
     /**
     * This method returns the sprite.
     * @return
     */
    public BufferedImage getSprite()
    {
        return sprite;
    }
    
    /**
     * This method updates the displacement of the character based on the
     * user's key press.
     * @param direction
     */
    public void move(int direction)
    {
        switch(direction)
        {
            case 1:
                displacement.setY(-1);
                break;
            case 2:
                displacement.setY(1);
                break;
            case 3:
                displacement.setX(-1);
                break;
            case 4:
                displacement.setX(1);
                break;
            default:
                break;
        }
    }
    
    /**
     * This method is called to move the position of the player.
     */
    public void doMove()
    {
        position.add(displacement);
    }
    
    /**
     * When the user releases the key, reset the move displacement to 0.
     */
    public void stop()
    {
        displacement.setX(0);
        displacement.setY(0);
    }
    
    public void draw(Graphics2D g)
    {
        //Draw sprite at correct coordinates in the graphic's context.
        g.drawImage(sprite, position.getX(),position.getY(), null);
    }
    
}
