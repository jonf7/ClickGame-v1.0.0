package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class MyFrame extends JFrame implements ActionListener{
    JButton clickbutton;
    JButton buy1;
    JButton exitbutton;
    JButton shop;
    JButton mainpage;
    JLabel note;
    JLabel points;
    MyFrame(){
        note = new JLabel();
        points = new JLabel();
        this.add(note);
        points.setBounds(165,50,500,50);
        note.setText("Just Click On The \"Click Me\" Button To Earn Points!");
        exitbutton = new JButton();
        clickbutton = new JButton();
        mainpage = new JButton();
        shop = new JButton();
        this.setLayout(null);
        clickbutton.setBackground(Color.darkGray);
        clickbutton.setForeground(Color.white);
        shop.setBackground(Color.darkGray);
        shop.setForeground(Color.white);
        exitbutton.setBackground(Color.darkGray);
        exitbutton.setForeground(Color.white);
        shop.addActionListener(this);
        mainpage.addActionListener(this);
        clickbutton.setBounds(200, 100, 100, 50);
        shop.setBounds(200, 100, 100, 50);
        mainpage.setBounds(200, 100, 150, 50);
        buy1 = new JButton();
        buy1.setBounds(200, 100, 200, 50);
        clickbutton.addActionListener(this);
        exitbutton.addActionListener(this);
        buy1.addActionListener(this);
        this.setSize(350,400);
        this.setTitle("Click Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
        buy1.setLocation(180,20);
        buy1.setText("level 2 (10 points)");
        exitbutton.setBounds(200,100,100,50);
        exitbutton.setLocation(215,300);
        exitbutton.setText("Exit!");
        shop.setText("Shop!");
        clickbutton.setText("Click me");
        mainpage.setText("Back From Shop");
        shop.setLocation(20,300);
        buy1.setLocation(65,50);
        mainpage.setLocation(20,300);
        clickbutton.setLocation(120,150);
        note.setBounds(25, 20 , 500 ,50);
        clickbutton.setFocusPainted(false);
        exitbutton.setFocusPainted(false);
        shop.setFocusPainted(false);
        this.add(shop);
        this.add(exitbutton);
        this.add(clickbutton);
        this.add(points);
    }
    long clicks = 0;
    byte level = 1;
    boolean l1b = false;
    boolean bf1 = false;
    boolean firstshow = true;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clickbutton) {
            for(byte i = 1; i <= level; i++)
                clicks++;
            points.setText(String.valueOf(clicks));
            if(clicks !=0 && firstshow == true){
                Font pointsr = new Font("SansSerif", Font.BOLD, 20);
                points.setFont(pointsr);
                points.setBounds(165,50,500,50);
                firstshow = false;
                remove(note);
                repaint();
            }
        }else if(e.getSource()==buy1 && clicks >= 10 && l1b == false){
            clicks -= 10;
            level = 2;
            buy1.setText("Bought");
            l1b = true;
            buy1.setEnabled(false);
            repaint();
        }else if(e.getSource()==exitbutton){
            System.exit(0);
        }else if(e.getSource()==shop){
            getContentPane().removeAll();
            mainpage.setBackground(Color.darkGray);
            mainpage.setForeground(Color.white);
            buy1.setBackground(Color.darkGray);
            buy1.setForeground(Color.white);
            buy1.setFocusPainted(false);
            mainpage. setFocusPainted(false);
            this.add(buy1);
            this.add(mainpage);
            repaint();
        }else if(e.getSource()==mainpage){
            getContentPane().removeAll();
            this.add(clickbutton);
            this.add(shop);
            this.add(exitbutton);
            this.add(points);
            repaint();
        }
        if (clicks == 10 && bf1 == false) {
            this.add(note);
            note.setBounds(110 ,200, 300, 50);
            note.setText("Nice u have " + clicks + " points!");
            Timer timer = new Timer();
            TimerTask messagetask = new TimerTask() {
                public void run() {
                    remove(note);
                    repaint();
                    bf1 = true;
                }
            };
            timer.scheduleAtFixedRate(messagetask, 4000, 4000);
        }
    }
    }
