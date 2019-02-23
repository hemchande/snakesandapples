//Eisha Hemchand
//BEGINNING JAVA- SUAREZ
//SNAKES AND APPLES GAME


import javax.swing.*;
import javax.swing.plaf.ActionMapUIResource;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;//this will help make the shape move
import java.awt.event.KeyEvent;//this package helps record the stroke of the key
import java.awt.event.KeyListener;//this package is for taking teh key stroke

 //using a subclass of JFrame from swing
public class snake extends JFrame {
    private String game = "SNAKE AND APPLE GAME";
// this package creates a window which is where the graphics would be displayed

    int BOARD_WIDTH = 500;//initializes the dimensions of the board
    int BOARD_HEIGHT = 600;//also initializes
    int DELAY = 100;      //Action listener called every 100ms- needed for refreshing the screen with a repaint
    //setting an array for the coordinates for the snake- store in 1D value
    int score; //keeps tab of the score

    private void SetScore ( int number)
    {
        score = number;
    }

    private int GetScore ()
    {
        return score;
    }

    int  x = 100;
    int  y = 100;



    //setting the coordinates for the apple as 1 point
    int a_x = 50;
    int a_y = 50;

    //Need KeyListener and Action Listener as part of JPanel to accept keystrokes
   public class Board extends JPanel implements KeyListener, ActionListener {
        //   public class Board extends JPanel implements KeyListener {
        Board() {
            setBackground(Color.black);
        }

        //Call for Graphics to draw the snake and apple and place them in the board
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //if (inGame) {
            g.setColor(Color.red);
            g.fillRect(a_x, a_y, 10, 10);
            g.drawString("Score=" + score, 10, 10);

            //For loop to make the snake size bigger
            for (int j = 0; j < 1; j++) {
                g.setColor(Color.GREEN);
                g.fillRect(x + 10, y + 10, 10 + j, 10 + j);
            }
        }

        //Need Action Listener to be set for every keylistener otherwise the program will error
        public void actionPerformed(ActionEvent e) {
            // g.setColor(Color.GREEN);


            check_score();

            //g.fillRect(x, y, 10, 10);
            repaint();
        }

        //When calling the Keylistener, need to override all the KeyTyped, keyreleased CALLS
        @Override
        public void keyReleased(KeyEvent e) {
        }

        //if you don't declare "key released" or "keytap" you will get not abstract and does not overide the error
        @Override
        public void keyTyped(KeyEvent e) {
        }

        //Based on the key stroke, the x and y coordinates of the snake are incremented and replaced
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                x = x - 10;

            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                y = y - 10;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                x = x + 10;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                y = y + 10;
            }
            repaint();
            if (x - a_x < 10) {
            }
            score++;
        }

        public void check_score() {
            if (x == 50) {
                score = score + 10;

            }
        }
    }
   
   //Main Program to draw the board and add the apple and set the timer

       public snake() {
           //setDefaultCloseOperation();

           setSize(BOARD_WIDTH, BOARD_HEIGHT);
           setTitle("Snake and Apple Game");
           setDefaultCloseOperation(EXIT_ON_CLOSE);//syntax to close the panel
           setResizable(false); //user cannot adjust the parameters
           //setLocation(50, 50);
           Board b = new Board();
           //setDefaultCloseOperation(EXIT_ON_CLOSE);
           addKeyListener (b);
           add(b);//thsi helps add the board in order for it to display
           //Timer t = new Timer (DELAY, b) ;
           //Board b = new Board();
           setVisible(true);
       }

       public static void main(String[] args) {
           snake s = new snake();
       }

   }







 






