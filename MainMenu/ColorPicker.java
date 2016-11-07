import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class ColorPicker here.
 * 
 * @author jonguan 
 * @version 11-7-16
 */
public class ColorPicker extends Actor
{
    int width, height = 75;
    int numColors = 2;

    Color lineColor = Color.WHITE;
    Color fillColor = Color.GRAY;
    Color[] colors = {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE};
    int selectionIndex = -1;

    public Color getPickedColor(){
        return null;
    }
    
    /**
     * Act - do whatever the ColorPicker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            // Set selectionIndex
            int clickX = Greenfoot.getMouseInfo().getX();
            selectionIndex = clickX / (colorWidth());
            BaseGraph world = (BaseGraph)getWorld();
            world.updateColor(selectedColor());
            updateImage();
        }
<<<<<<< HEAD
    }    
=======
        
        if (Greenfoot.mouseDragged(this))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(), mouse.getY());
        }
    }   
>>>>>>> 44619e80702f6e6e65e7db65f289cad9f0636439

    public Color selectedColor() {
        if (selectionIndex < 0) {
            return null;
        }
        return colors[selectionIndex];
    }
<<<<<<< HEAD
    
    private int colorWidth() {
        return (int)Math.floor(width/numColors*1.0);
    }

    public ColorPicker(int width, int height, int numColors){
=======
    public ColorPicker(){
         //do nothing 
     }
    public ColorPicker(int width, int height){
>>>>>>> 44619e80702f6e6e65e7db65f289cad9f0636439
        this.width = width;
        this.height = height;
        this.numColors = numColors;

        updateImage();
    }

    public void setNumColors(int numColors) {
        this.numColors = numColors;
        updateImage();
    }

    public void updateImage(){
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(lineColor);
        image.drawRect(0, 0, width, height);
        
        int colorWidth = colorWidth();

        // Fill in colors
        for (int i = 0; i < numColors; i++) {
            Color color = colors[i];
            image.setColor(color);
            image.fillRect(i*colorWidth, 0, colorWidth, height);
        }

        // Selection color
        if (selectionIndex >= 0) {
            image.setColor(Color.BLACK);
            image.drawLine(selectionIndex*colorWidth, 0, (selectionIndex+1)*colorWidth, height);
        }

        setImage(image);
    }
}
