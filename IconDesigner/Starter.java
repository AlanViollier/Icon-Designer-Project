import javax.swing.JPanel;
import java.awt.GridLayout;
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
public class Starter
{
    public static void main(String[] args)
    {
        //All the layout and oranization of components
        int vari = 1600;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        JFrame frame = new JFrame();
        frame.setSize(vari,vari*5/8);//set the frame
        final JPanel Master = new JPanel(new GridLayout(1,2));//main Panel

        JPanelOne LeftMasterPanel = new JPanelOne();//left Panel
        LeftMasterPanel.getVari(vari);
        final JPanel RightMasterPanel = new JPanel(new GridLayout(1,2));//right master panel
        Master.add(LeftMasterPanel);//add the panel to the main panel
        Master.add(RightMasterPanel);//add the right to the main panel

        final JPanel LeftRightPanel = new JPanel(new GridLayout(3,1));//left right panel
        RightMasterPanel.add(LeftRightPanel);//add to the rigt master pane

        final JPanel RightRightPanel = new JPanel(new GridLayout(1,1));//right panel
        RightMasterPanel.add(RightRightPanel);

        final JPanel Instructions = new JPanel(new GridLayout(1,1));//instruction panel
        TitledBorder In = BorderFactory.createTitledBorder("Instructions");//create a border
        Instructions.setBorder(In);//set the border
        final JTextArea I = new JTextArea("Welcom to Alan's Icon Designer!\nHere you will be able to create a logo with\ndifferent shapes and colors\nand a text with differentcolors and sizes.\nIf you want to move the text press the\nbutton at the bottom right of the screen,\notherwise just use your mouse to move\nand select the shapes you put on your icon");
        I.setEditable(false);//no edit for the instruction
        Instructions.add(I);//add the text area to the panel
        LeftRightPanel.add(Instructions);//add the instruction to panel

        GridLayout d = new GridLayout(5,1);//st the layout 
        d.setVgap(6);//gap to make it pretty
        final JPanel Add = new JPanel(d);//add panel 

        TitledBorder TextConfig = BorderFactory.createTitledBorder("Text Settings");//border for the setting
        Add.setBorder(TextConfig);//set border for add panel
        final JTextField logoText = new JTextField("Add Logo Name Here");//add textfield for typing
        Add.add(logoText);//add to the penal
        final JButton C = new JButton("Color");//set the button for color
        C.setPreferredSize(new Dimension(vari*2/14,vari*50/1400+20));//set the size
        Add.add(C);//add the color button to panel
        String [] ggfonts = ge.getAvailableFontFamilyNames();//creates an array with all the available fonts on the computer
        final JComboBox textFont = new JComboBox(ggfonts);//creates a combo box for text fonts
        Add.add(textFont);//add the combo box to the add Jpanel
        final JPanel BoldOrItalic = new JPanel();//creates a new panel for bold or italic
        TitledBorder BrI = BorderFactory.createTitledBorder("Style");//Creates a border called BrI
        BoldOrItalic.setBorder(BrI);//sets the border of the Bold or italic panel to BrI
        final JCheckBox Bold = new JCheckBox("Bold");//creates a checkbox for bold
        final JCheckBox Italic = new JCheckBox("Italic");//creates a checkbox for italic
        BoldOrItalic.add(Bold);//adds the bold checkbox to the bold or italic panel
        BoldOrItalic.add(Italic);//Adds the italic checkbox to the bold or italic panel
        Add.add(BoldOrItalic);//adds the bold or italic panel to the add panel
        final JPanel textSize = new JPanel();//creates a new panel for text size
        TitledBorder Size = BorderFactory.createTitledBorder("Size");//Creates a border called Size
        textSize.setBorder(Size);//sets the text size panel border to Size
        final JButton Bigger = new JButton("Bigger");//creates a new button called bigger
        final JButton Smaller = new JButton("Smaller");//creates a new button called smaller
        textSize.add(Bigger);//adds bigger to text size
        textSize.add(Smaller);//adds smaller to text size
        Add.add(textSize);//adds textsize to the add panel

        LeftRightPanel.add(Add);//adds add panel to the leftright panel

        final JPanel IconSettings = new JPanel(new GridLayout(2,1));//Creates the icon settings panel
        TitledBorder IconConfig = BorderFactory.createTitledBorder("Icon Settings");//creates a border called iconConfig
        IconSettings.setBorder(IconConfig);//sets the icon setting panel's border to iconConfig
        GridLayout so = new GridLayout(1,2);//creates a new grid layout callde so
        so.setVgap(10);//set the vertical gap of the grid to 10 pixels
        so.setHgap(10);//sets the horizontal gap of the gid to 10 pixels
        final JPanel IconSize = new JPanel(so);// creates a panel called iconsize
        final JButton IBigger = new JButton("Bigger");//creates a new button called bigger
        final JButton ISmaller = new JButton("Smaller");//creates a new button called smaller
        IconSize.add(IBigger);//adds bigger to iconsize
        IconSize.add(ISmaller);//adds smaller to iconsize
        IconSettings.add(IconSize);//adds iconsize to iconsettings
        GridLayout co = new GridLayout(5,2);//creates a new grid layout
        co.setVgap(10);//set the vertical gap of the grid to 10 pixels
        co.setHgap(10);//sets the horizontal gap of the gid to 10 pixels
        final JPanel IconColor = new JPanel(co);//creates a new panel called iconcolor
        final JButton C1 = new JButton("Black");//creates a new button for black
        final JButton C2 = new JButton("Blue");//creates a new button for blue
        final JButton C3 = new JButton("Brown");//creates a new button for brown
        final JButton C4 = new JButton("Green");//creates a new button for green
        final  JButton C5 = new JButton("Grey");//creates a new button for grey
        final JButton C6 = new JButton("Orange");//creates a new button for orange
        final JButton C7 = new JButton("Purple");//creates a new button for purple
        final JButton C8 = new JButton("Red");//creates a new button for red
        final JButton C9 = new JButton("Sky");//creates a new button for sky
        final JButton C10 = new JButton("Yellow");//creates a new button for yellow
        IconColor.add(C1);//add the first button to iconcolor
        IconColor.add(C2);//add the second button to iconcolor 
        IconColor.add(C3);//add the third button to iconcolor
        IconColor.add(C4);//add the fourth button to iconcolor
        IconColor.add(C5);//add the fifth button to iconcolor
        IconColor.add(C6);//add the sixth button to iconcolor
        IconColor.add(C7);//add the seventh button to iconcolor
        IconColor.add(C8);//add the eight button to iconcolor
        IconColor.add(C9);//add the ninth button to iconcolor
        IconColor.add(C10);//add the tenth button to iconcolor
        IconSettings.add(IconColor);//adds iconcolor to iconsettings

        LeftRightPanel.add(IconSettings);//adds iconsettings to leftrightpanel

        GridLayout d1 = new GridLayout(8, 1);//creates a new grid layout
        d1.setVgap(50);//sets the vertical gap of the grid to 50 pixels
        final JPanel Icons = new JPanel(d1);//creates a new panel called icons
        TitledBorder Ic = BorderFactory.createTitledBorder("Icons");//creates a new border called Ic
        Icons.setBorder(Ic);//set the border of Icons to Ic
        RightRightPanel.add(Icons);//adds icons to RightRightPanel
        final JButton I1 = new JButton("Circle");//creates a new buttons for circle
        final JButton I2 = new JButton("Up Triangle");//creates a new buttons for up triangle
        final JButton I3 = new JButton("Down Triangle");//creates a new buttons for down triangle
        final JButton I4 = new JButton("Square");//creates a new buttons for square
        final JButton delete = new JButton("!!! DELETE selected Icon !!!");//creates a new buttons for delete
        final JButton copy = new JButton("!!! Make another copy of selected Icon !!!");//creates a new buttons for copy
        final JButton move = new JButton("!!!Click here to use arrowkeys to move the text!!!");//creates a new buttons for move 
        Icons.add(I1);//adds I1 to Icons
        Icons.add(I2);//adds I2 to Icons
        Icons.add(I3);//adds I3 to Icons
        Icons.add(I4);//adds I4 to Icons
        Icons.add(delete);//adds delete to Icons
        Icons.add(copy);//adds copy to Icons
        Icons.add(move);//adds move to Icons

        class LogoListener implements ActionListener 
        {
            public void actionPerformed(ActionEvent e)//ActionListener for all the buttons, radio buttons and chexk boxes.
            {
                Color textCol = new Color(0,0,0);//creates a new default color called textcol.
                if(e.getSource() == C) //whatever getsource is equals to, which is the button you pressed, it will perform different tasks
                {
                    textCol = JColorChooser.showDialog(LeftRightPanel, "Color Selector", textCol);//get color 
                    LeftMasterPanel.changeColor(textCol);//sets the color of the icon selected
                }
                if(e.getSource() == textFont)
                {
                    String CurFont = (String) textFont.getSelectedItem();//get the current font selected
                    LeftMasterPanel.changeFont(CurFont);//sets the texts font to the font selected
                }
                if(e.getSource() == Bold||e.getSource() == Italic)//if the source comes from the bold or italic checkbox then...
                {
                    if(Bold.isSelected())
                    {
                        if(Italic.isSelected())//if bold and italic are selected
                        {
                            LeftMasterPanel.changeStyle(0);//sets the style to bold and italic
                        }
                        else//if bold is selected
                        {
                            LeftMasterPanel.changeStyle(1);//sets the style to bold
                        }
                    }
                    else if(Italic.isSelected())//if italic is selected
                    {
                        LeftMasterPanel.changeStyle(2);//sets the style to italic
                    }
                    else//if no style is selected
                    {
                        LeftMasterPanel.changeStyle(3);//sets the style default
                    }
                }
                if(e.getSource()==Bigger)//if bigger button is pressed
                {
                    LeftMasterPanel.incSize();//increase the text size
                }
                if(e.getSource()==Smaller)//if smaller button is pressed
                {
                    LeftMasterPanel.decSize();//decreases the text size
                }
                if(e.getSource()==I1)//if the I1 button is pressed
                {
                    LeftMasterPanel.addImage(1);//adds a circle to the screen
                }
                if(e.getSource()==I2)//if the I2 button is pressed
                {
                    LeftMasterPanel.addImage(2);//adds a up triangle to the screen
                }
                if(e.getSource()==I3)//if the I3 button is pressed
                {
                    LeftMasterPanel.addImage(3);//adds a down triangle to the screen
                }
                if(e.getSource()==I4)//if the I4 button is pressed
                {
                    LeftMasterPanel.addImage(4);//adds a square to the screen
                }
                if(e.getSource()==C1)//if the C1 button is pressed
                {
                    LeftMasterPanel.changeColor(1);//changes the color of the selected icon to black
                }
                if(e.getSource()==C2)//if the C2 button is pressed
                {
                    LeftMasterPanel.changeColor(2);//changes the color of the selected icon to blue
                }
                if(e.getSource()==C3)//if the C3 button is pressed
                {
                    LeftMasterPanel.changeColor(3);//changes the color of the selected icon to brown
                }
                if(e.getSource()==C4)//if the C4 button is pressed
                {
                    LeftMasterPanel.changeColor(4);//changes the color of the selected icon to green
                }
                if(e.getSource()==C5)//if the C5 button is pressed
                {
                    LeftMasterPanel.changeColor(5);//changes the color of the selected icon to grey
                }
                if(e.getSource()==C6)//if the C6 button is pressed
                {
                    LeftMasterPanel.changeColor(6);//changes the color of the selected icon to orange
                }
                if(e.getSource()==C7)//if the C7 button is pressed
                {
                    LeftMasterPanel.changeColor(7);//changes the color of the selected icon to purple
                }
                if(e.getSource()==C8)//if the C8 button is pressed
                {
                    LeftMasterPanel.changeColor(8);//changes the color of the selected icon to red
                }
                if(e.getSource()==C9)//if the C9 button is pressed
                {
                    LeftMasterPanel.changeColor(9);//changes the color of the selected icon to sky
                }
                if(e.getSource()==C10)//if the C10 button is pressed
                {
                    LeftMasterPanel.changeColor(10);//changes the color of the selected icon to yellow
                }
                if(e.getSource()==IBigger)//if the IBigger button is pressed
                {
                    LeftMasterPanel.IncImageSize();// increases the selected image size
                }
                if(e.getSource()==ISmaller)//if the ISmallerr button is pressed
                {
                    LeftMasterPanel.DecImageSize();//decreases the size of the selected image
                }
                if(e.getSource()==delete)//if the delete button is pressed
                {
                    LeftMasterPanel.delete();// deletes the selected image
                }
                if(e.getSource()==copy)//if the copy button is pressed
                {
                    LeftMasterPanel.copy();// makes a copy of the selected image
                }
            }
        }

        class mouseEvent implements MouseListener, MouseMotionListener// mouse listener for clicking and dragging
        {

            int x;//creates an int for the x coordinate
            int y;//creates an int for the y coordinate
            public void mousePressed(MouseEvent e) //whevener there is a click is will get the coordinates and send them to the other class's methods
            {
                x = e.getX();// sets x to the x coordinate of your mouse
                y = e.getY();//sets y to the y coordinate of your mouse
                LeftMasterPanel.moveImage(x,y);// moves the image to the mouse's values
            }

            public void mouseReleased(MouseEvent e) 
            {

            }

            public void mouseEntered(MouseEvent e) 
            {

            }

            public void mouseExited(MouseEvent e)
            {

            }

            public void mouseClicked(MouseEvent e) 
            {

            }

            public void mouseMoved(MouseEvent e)
            {

            }

            public void mouseDragged(MouseEvent e)//whevener the mouse is clicked and dragged
            {

                int currentx=e.getX();//gets the current x coordniate of the mouse
                int currenty=e.getY();//gets the current y coordniate of the mouse
                LeftMasterPanel.dragImage(currentx-x,currenty-y);//current x and y allow you to drag images form different spots on the image.
                x=currentx;//adjust the x value to the current x value
                y=currenty;//adjust the y value to the current y value
            }

        }
        LogoListener l = new LogoListener();//create the action listener
        mouseEvent m = new mouseEvent();//creates the mouse listener
        C.addActionListener(l);// add the action listener to this button
        textFont.addActionListener(l);// add the action listener to this button
        Bold.addActionListener(l);// add the action listener to this button
        Italic.addActionListener(l);// add the action listener to this button
        Bigger.addActionListener(l);// add the action listener to this button
        Smaller.addActionListener(l);// add the action listener to this button
        I1.addActionListener(l);// add the action listener to this button
        I2.addActionListener(l);// add the action listener to this button
        I3.addActionListener(l);// add the action listener to this button
        I4.addActionListener(l);// add the action listener to this button
        delete.addActionListener(l);// add the action listener to this button
        copy.addActionListener(l);// add the action listener to this button
        C1.addActionListener(l);// add the action listener to this button
        C2.addActionListener(l);// add the action listener to this button
        C3.addActionListener(l);// add the action listener to this button
        C4.addActionListener(l);// add the action listener to this button
        C5.addActionListener(l);// add the action listener to this button
        C6.addActionListener(l);// add the action listener to this button
        C7.addActionListener(l);// add the action listener to this button
        C8.addActionListener(l);// add the action listener to this button
        C9.addActionListener(l);// add the action listener to this button
        C10.addActionListener(l);// add the action listener to this button
        IBigger.addActionListener(l);// add the action listener to this button
        ISmaller.addActionListener(l);// add the action listener to this button
        move.addKeyListener(new KeyAdapter()//creates a key listener for the move button
            {
                public void keyReleased(KeyEvent ke)
                {

                }

                public void keyPressed(KeyEvent e)//if ever a key is help down, e will be equals to that key.
                {
                    if(e.getKeyCode()==KeyEvent.VK_UP)//if the up key is pressed
                    {
                        LeftMasterPanel.move("up");//move the text up
                    }
                    if(e.getKeyCode()==KeyEvent.VK_DOWN)//if the down key is pressed
                    {
                        LeftMasterPanel.move("down");//move the text down
                    }
                    if(e.getKeyCode()==KeyEvent.VK_LEFT)//if the left key is pressed
                    {
                        LeftMasterPanel.move("left");//move the text left
                    }
                    if(e.getKeyCode()==KeyEvent.VK_RIGHT)//if the right key is pressed
                    {
                        LeftMasterPanel.move("right");//move the text right
                    }
                }

                public void keyTyped(KeyEvent e)// if ever a key to pushed down, e will be equals to that key.
                {
                    if(e.getKeyCode()==KeyEvent.VK_UP)//if the up key is pressed
                    {
                        LeftMasterPanel.move("up");  //move the text up
                    }
                    if(e.getKeyCode()==KeyEvent.VK_DOWN)//if the down key is pressed
                    {
                        LeftMasterPanel.move("down");//move the text down
                    }
                    if(e.getKeyCode()==KeyEvent.VK_LEFT)//if the left key is pressed
                    {
                        LeftMasterPanel.move("left");//move the text left
                    }
                    if(e.getKeyCode()==KeyEvent.VK_RIGHT)//if the right key is pressed
                    {
                        LeftMasterPanel.move("right");//move the text right
                    }

                }
            });
        logoText.addKeyListener(new KeyAdapter()//creates a key listener for the logo text
            {
                public void keyReleased(KeyEvent ke)//whever a key is released it will refresh The text on your logo
                {
                    String CurName = logoText.getText();//gets the current text in the text feild
                    LeftMasterPanel.changeName(CurName);//changes the text to the current text
                }

                public void keyPressed(KeyEvent e)
                {

                }

                public void keyTyped(KeyEvent e)
                {

                }
            });
        LeftMasterPanel.addMouseListener(m);//add mouse listeners to the logo area
        LeftMasterPanel.addMouseMotionListener(m);
        frame.add(Master);//add the panels to the frame
        frame.setVisible(true);//set the frame visible
    }

}
