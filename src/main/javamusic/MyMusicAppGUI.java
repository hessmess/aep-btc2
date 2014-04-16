package javamusic;

/**
 * Created by prabha on 2/21/14.
 */
import javax.swing.*;
import java.awt.event.*;


public class MyMusicAppGUI implements ActionListener{
    JButton button;

    public static void main(String [] args){
        MyMusicAppGUI mini = new MyMusicAppGUI();
        mini.play();
    }

    public void play(){

        JFrame frame = new JFrame();
        button = new JButton("Click me");
        button.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.setSize(300, 300);
        frame.setVisible(true);

    }     //close play

    public void actionPerformed(ActionEvent event){
        button.setText("I've been clicked!");

    }     //close actionPerformed
}  //close class
