import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class JPanelOne extends JPanel {
    private String font = "18thCentury";
    private Color textColor = new Color(0,0,0);
    private int style = Font.PLAIN;
    private int size = 20;
    private String name = "Add Logo Name Here";
    private int xText = 10;
    private int yText = 30;
    private int vari = 0;
    private Image square;
    private Image[] ArrayImage = new Image[99];
    private int[][] ImageLocation = new int[99][2]; 
    private String[] ImageType = new String[99];
    private int[] ImageSize = new int[99];
    private int Index = 0;
    private File image2;
    public JPanelOne() 
    {

    }

    public void addImage(int e)//whicherver button is pressed it will set the newest index spot for every array to a set image for the button.
    {
        if(e==1)//Circle
        {
            image2 = new File("circleBlack.png");//set the file to be black circle
            ImageType[Index] = "Circle";//set the type to be type circle
        }
        else if(e==2)//Up Triangle
        {
            image2 = new File("uptriangleBlack.png");//set the file to be black circle
            ImageType[Index] = "Up Triangle";//set the type to be type up triangle
        }
        else if(e==3)//Down Triangle
        {
            image2 = new File("downtriangleBlack.png");//set the file to be black circle
            ImageType[Index] = "Down Triangle";//set the image to be down triangle type
        }
        else if(e==4)//Square
        {
            image2 = new File("squareBlack.jpg");//set the file to be black square
            ImageType[Index] = "Square";//set the image to be square type
        }

        try
        {
            square = ImageIO.read(image2); //set the image file
        }
        catch(IOException en)
        {

        }
        ArrayImage[Index]=square;  //add iamge to the array
        ImageLocation[Index][0] = 100 + Index*10; //create new x location
        ImageLocation[Index][1] = 100 + Index*10;//create new y location
        ImageSize[Index]= 400;//set the image size
        Index++;// increases the size of how many images are printed
        repaint();
    }

    public void copy()//takes all the characteristics of the selected image and creats an exact copy
    {
        ArrayImage[Index]=ArrayImage[Index-1];//cope image
        ImageLocation[Index][0] = ImageLocation[Index-1][0]+10;//copy the x loc
        ImageLocation[Index][1] = ImageLocation[Index-1][1]+10;//copy the y loc
        ImageType[Index]=ImageType[Index-1];  //copy the image type
        ImageSize[Index]=ImageSize[Index-1];//copy the image size
        Index++; //increase the maige counter
        repaint();
    }

    public void move(String e)//moves the texts coordinates depending on which way you want it to move
    {
        if(e.equals("up"))//move text up
        {
            yText = yText - 20;//20 up
        }
        else if(e.equals("down"))//move text down
        {
            yText = yText + 20;//20 down
        }
        else if(e.equals("left"))//move text left
        {
            xText = xText - 20;//20 to the left
        }
        else if(e.equals("right"))//move text right
        {
            xText = xText + 20; //20 pixel to the right
        }
        repaint();
    }

    public void getVari(int e)// set vari number
    {
        vari = e;    
    }

    public void changeFont(String e)//changes the font to the one you selected
    {
        font = e; //change the font
        repaint();
    }

    public void changeColor(Color e)//changes the text's color to the one you selected
    {
        textColor = e;//change the color
        repaint();
    }

    public void incSize()//increases the size of the text
    {
        size = size+2; //increase size by 2
        repaint();
    }

    public void decSize()//decreases the size of the text
    {
        size=size-2;//decrease size by 2
        repaint();
    }

    public void changeName(String e)//change what is written in the text
    {
        name = e;  //change the text
        repaint();
    }

    public void moveImage(int x,int y)
    {

        for(int i = Index-1;i>=0;i--)//checks every image in the array starting from the top
        {

            if(y>ImageLocation[i][1]&&y<ImageLocation[i][1]+ImageSize[i])
            {
                if(x>ImageLocation[i][0]&&x<ImageLocation[i][0]+ImageSize[i])//if the click is between the size of the image then...
                {

                    Image temp=ArrayImage[i];//create a temp iamge
                    int tempx=ImageLocation[i][0];//create a x loc
                    int tempy=ImageLocation[i][1];//create a y loc
                    String temptype=ImageType[i];//create a temp image type
                    int tempsize=ImageSize[i];//create the get the size
                    for(int j=i;j<=Index-1;j++)//puts the selected image to the front and pushes all the pther images back one in the array.
                    {
                        ArrayImage[j]=ArrayImage[j+1];//swap the image
                        ImageLocation[j][0]=ImageLocation[j+1][0];//swap the x location
                        ImageLocation[j][1]=ImageLocation[j+1][1];//swap the y location
                        ImageType[j]=ImageType[j+1];//swap the iamge type
                        ImageSize[j]=ImageSize[j+1];//swap the size
                        if(j==Index-1)
                        {

                            ArrayImage[Index-1]=temp;//restore the temp image to the front image
                            ImageLocation[Index-1][0]=tempx;//restore the temp x location to the front image x location
                            ImageLocation[Index-1][1]=tempy;//restore the temp y loc to the front image y loc
                            ImageType[Index-1]=temptype;//restore the temp type to the front image type
                            ImageSize[Index-1]=tempsize;//restore the temp image size to the front image size
                        }
                    }
                    break;//stops the for loop
                }

            }
        }

        repaint();
    }

    public void IncImageSize()//increases the image size and the click box of the image too
    {
        ImageSize[Index-1]=ImageSize[Index-1]+10;//increase size by 10
        Image temp=ArrayImage[Index-1].getScaledInstance(ImageSize[Index-1],ImageSize[Index-1],100); //create a new temp image of the current image
        ArrayImage[Index-1]=temp;//set the top image to the new scele image
        repaint();
    }

    public void checkImage()//checks that the size of the image is the size its supposed to be, in case of color change
    {
        Image temp=ArrayImage[Index-1].getScaledInstance(ImageSize[Index-1],ImageSize[Index-1],100);//create a new temp image of the current image
        ArrayImage[Index-1]=temp;//set the top image to the new scele image
        repaint();
    }

    public void DecImageSize()//decreases the image size and the click box of the image too
    {
        ImageSize[Index-1]=ImageSize[Index-1]-10;//decrease image by 10
        Image temp=ArrayImage[Index-1].getScaledInstance(ImageSize[Index-1],ImageSize[Index-1],100);//create a new temp image of the current image
        ArrayImage[Index-1]=temp;//set the top image to the new scele image
        repaint();
    }

    public void changeColor(int e)// changes the image bases on which type of image it is and what color you chose
    {
        if(e==1)//Black
        {
            if(ImageType[Index-1].equals("Circle"))//Check and set the Image to be black Circle
            {
                image2 = new File("circleBlack.png");
            }
            else if(ImageType[Index-1].equals("Up Triangle"))//Check and set the Image to be black up triangle
            {
                image2 = new File("uptriangleBlack.png");
            }
            else if(ImageType[Index-1].equals("Down Triangle"))//Check and set the Image to be black down triangle
            {
                image2 = new File("downtriangleBlack.png");
            }
            else if(ImageType[Index-1].equals("Square"))//Check and set the Image to be black square
            {
                image2 = new File("squareBlack.jpg");
            }

        }
        else if(e==2)//Blue
        {
            if(ImageType[Index-1].equals("Circle"))//Check and set the Image to be blue Circle
            {
                image2 = new File("circleBlue.png");
            }
            else if(ImageType[Index-1].equals("Up Triangle"))//Check and set the Image to be blue up triangle
            {
                image2 = new File("uptriangleBlue.png");
            }
            else if(ImageType[Index-1].equals("Down Triangle"))//Check and set the Image to be blue down triangle
            {
                image2 = new File("downtriangleBlue.png");
            }
            else if(ImageType[Index-1].equals("Square"))//Check and set the Image to be blue square
            {
                image2 = new File("squareBlue.jpg");
            }

        }
        else if(e==3)//Brown
        {
            if(ImageType[Index-1].equals("Circle"))//Check and set the Image to be brown Circle
            {
                image2 = new File("circleBrown.png");
            }
            else if(ImageType[Index-1].equals("Up Triangle"))//Check and set the Image to be brown up triangle
            {
                image2 = new File("uptriangleBrown.png");
            }
            else if(ImageType[Index-1].equals("Down Triangle"))//Check and set the Image to be brown down triangle
            {
                image2 = new File("downtriangleBrown.png");
            }
            else if(ImageType[Index-1].equals("Square"))//Check and set the Image to be brown square
            {
                image2 = new File("squareBrown.jpg");
            }

        }
        else if(e==4)//Green
        {
            if(ImageType[Index-1].equals("Circle"))//Check and set the Image to be green Circle
            {
                image2 = new File("circleGreen.png");
            }
            else if(ImageType[Index-1].equals("Up Triangle"))//Check and set the Image to be green up triangle
            {
                image2 = new File("uptriangleGreen.png");
            }
            else if(ImageType[Index-1].equals("Down Triangle"))//Check and set the Image to be green down triangle
            {
                image2 = new File("downtriangleGreen.png");
            }
            else if(ImageType[Index-1].equals("Square"))//Check and set the Image to be green square
            {
                image2 = new File("squareGreen.jpg");
            }

        }
        else if(e==5)//Grey
        {
            if(ImageType[Index-1].equals("Circle"))//Check and set the Image to be grey Circle
            {
                image2 = new File("circleGrey.png");
            }
            else if(ImageType[Index-1].equals("Up Triangle"))//Check and set the Image to be grey up triangle
            {
                image2 = new File("uptriangleGrey.png");
            }
            else if(ImageType[Index-1].equals("Down Triangle"))//Check and set the Image to be grey down triangle
            {
                image2 = new File("downtriangleGrey.png");
            }
            else if(ImageType[Index-1].equals("Square"))//Check and set the Image to be grey square
            {
                image2 = new File("squareGrey.jpg");
            }

        }
        else if(e==6)//Orange
        {
            if(ImageType[Index-1].equals("Circle"))//Check and set the Image to be orange Circle
            {
                image2 = new File("circleOrange.png");
            }
            else if(ImageType[Index-1].equals("Up Triangle"))//Check and set the Image to be orange up triangle
            {
                image2 = new File("uptriangleOrange.png");
            }
            else if(ImageType[Index-1].equals("Down Triangle"))//Check and set the Image to be orange down triangle
            {
                image2 = new File("downtriangleOrange.png");
            }
            else if(ImageType[Index-1].equals("Square"))//Check and set the Image to be orange square
            {
                image2 = new File("squareOrange.jpg");
            }

        }
        else if(e==7)//Purple
        {
            if(ImageType[Index-1].equals("Circle"))//Check and set the Image to be purple Circle
            {
                image2 = new File("circlePurple.png");
            }
            else if(ImageType[Index-1].equals("Up Triangle"))//Check and set the Image to be purple up triangle
            {
                image2 = new File("uptrianglePurple.png");
            }
            else if(ImageType[Index-1].equals("Down Triangle"))//Check and set the Image to be purple down triangle
            {
                image2 = new File("downtrianglePurple.png");
            }
            else if(ImageType[Index-1].equals("Square"))//Check and set the Image to be purple square
            {
                image2 = new File("squarePurple.jpg");
            }

        }
        else if(e==8)//Red
        {
            if(ImageType[Index-1].equals("Circle"))//Check and set the Image to be Red Circle
            {
                image2 = new File("circleRed.png");
            }
            else if(ImageType[Index-1].equals("Up Triangle"))//Check and set the Image to be Red up triangle
            {
                image2 = new File("uptriangleRed.png");
            }
            else if(ImageType[Index-1].equals("Down Triangle"))//Check and set the Image to be Red down triangle
            {
                image2 = new File("downtriangleRed.png");
            }
            else if(ImageType[Index-1].equals("Square"))//Check and set the Image to be Red square
            {
                image2 = new File("squareRed.jpg");
            }

        }
        else if(e==9)//Sky
        {
            if(ImageType[Index-1].equals("Circle"))//Check and set the Image to be Sky Circle
            {
                image2 = new File("circleSky.png");
            }
            else if(ImageType[Index-1].equals("Up Triangle"))//Check and set the Image to be Sky up triangle
            {
                image2 = new File("uptriangleSky.png");
            }
            else if(ImageType[Index-1].equals("Down Triangle"))//Check and set the Image to be Sky down triangle
            {
                image2 = new File("downtriangleSky.png");
            }
            else if(ImageType[Index-1].equals("Square"))//Check and set the Image to be Sky square
            {
                image2 = new File("squareSky.jpg");
            }

        }
        else if(e==10)//Yellow
        {
            if(ImageType[Index-1].equals("Circle"))//Check and set the Image to be yellow Circle
            {
                image2 = new File("circleYellow.png");
            }
            else if(ImageType[Index-1].equals("Up Triangle"))//Check and set the Image to be yellow up triangle
            {
                image2 = new File("uptriangleYellow.png");
            }
            else if(ImageType[Index-1].equals("Down Triangle"))//Check and set the Image to be yellow down triangle
            {
                image2 = new File("downtriangleYellow.png");
            }
            else if(ImageType[Index-1].equals("Square"))//Check and set the Image to be yellow square
            {
                image2 = new File("squareYellow.jpg");
            }

        }
        try
        {
            square = ImageIO.read(image2);//set the image to be drawing after the selection 
        }
        catch(IOException en)
        {

        }
        ArrayImage[Index-1]=square;//add the image to the array
        checkImage();//checck and resize to the right size
        repaint();//draw the new image
    }

    public void dragImage(int x,int y)//sets the current location of the mouse to where the image should be 
    {
        ImageLocation[Index-1][0] =ImageLocation[Index-1][0]+x;//get current x
        ImageLocation[Index-1][1] =ImageLocation[Index-1][1]+y;//get current y
        repaint();
    }

    public void changeStyle(int e)// changes the font style
    {
        if(e==0)
        {
            style = Font.BOLD | Font.ITALIC;  //set Font to bold and italic
        }
        else if(e==1)
        {
            style = Font.BOLD;//set it to Bold
        }
        else if(e==2)
        {
            style = Font.ITALIC;//set it to Italic
        }
        else if(e==3)
        {
            style = Font.PLAIN;//set it to normal
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        g.setFont(new Font(font,style,size)); //sets the font to everything you have chosen or the default font
        g.setColor(textColor);//sets the text color to the text color you have chosen or the default color

        for(int i = 0;i<Index;i++)//draws every image at their specific locations
        {
            g.drawImage(ArrayImage[i],ImageLocation[i][0],ImageLocation[i][1],this);
        }
        drawString(g,name,xText,yText,vari/2-xText);//draws the text to what you have chosen it to be and where you want it to be or the default version
    }

    public void delete()//removes the image at the top of the array, the selected image.
    {
        if(Index>0)
        {
            Index--;//decrease the image counter
        }
        repaint();//repain the new number of image
    }

    public void drawString(Graphics g, String s, int x, int y, int width)//wrapping method
    {
        // FontMetrics gives us information about the width,
        // height, etc. of the current Graphics object's Font.
        FontMetrics fm = g.getFontMetrics();

        int lineHeight = fm.getHeight();

        int curX = x;//set the width
        int curY = y;//set the length

        String[] words = s.split(" ");

        for (String word : words)
        {
            // Find out the width of the word.
            int wordWidth = fm.stringWidth(word + " ");

            // If text exceeds the width, then move to next line.
            if (curX + wordWidth >= x + width)
            {
                curY += lineHeight;//next line 
                curX = x;//set it to the beginning location
            }

            g.drawString(word, curX, curY);//draw the string to the screen

            // Move over to the right for next word.
            curX += wordWidth;
        }
    }
}