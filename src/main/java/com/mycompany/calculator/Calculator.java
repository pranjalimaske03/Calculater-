/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculator;

/**
 *
 * @author PRIYA
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textfield;
    JButton[] numberButton = new JButton[10];   //we need 10buttons 0 to 9 
    JButton[] functionButton = new JButton[9];  // we need 9 funtion button +,-,*,/,delete so on
    JButton addButton,subButton,mulButton,divButton;  // declare those buttons
    JButton decButton,equButton,delButton,clrButton,negButton;
    JPanel panel;    //panel we need
    
    Font myFont = new Font("San Serif",Font.BOLD,30);  //the results font
    double num1=0,num2=0,result=0;  //whatever the two number you manipulate with  
    char operator;   
    
    
    Calculator(){ //make constructor to initialiize things
        frame=new JFrame("Calculator");//title of calculator
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //i want my calculator to close when i click exit button
        frame.setSize(420,550);  //set frame size
        frame.setLayout(null);
        frame.setBackground(Color.black);
        frame.setForeground(Color.black);
        
        
        textfield = new JTextField();
        textfield.setEditable(false);
        textfield.setFont(myFont);
        textfield.setBounds(50,25,300,50);
        textfield.setBackground(Color.PINK);
        
        subButton = new JButton("-");
        addButton = new JButton("+");
        divButton = new JButton("/");
        mulButton = new JButton("*");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("del");
        clrButton = new JButton("clr");
        negButton = new JButton("(-)");
        
        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = decButton;
        functionButton[5] = equButton;
        functionButton[6] = delButton;
        functionButton[7] = clrButton;
        functionButton[8] = negButton;
        
        for(int i=0;i<9;i++){
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
            functionButton[i].setBackground(Color.pink);
        }
        
        for(int i=0;i<10;i++){
            numberButton[i]=new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myFont);
            numberButton[i].setFocusable(false);
            numberButton[i].setBackground(Color.PINK);
        }
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);
        
        panel=new JPanel();
        panel.setBackground(Color.black);
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        
        
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButton[0]);
        panel.add(equButton);
        panel.add(divButton);
        
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //ToDO 
        Calculator calci=new Calculator();
    }
    
    @Override 
    public void actionPerformed(ActionEvent e){
        for(int i=0;i<10;i++){
            if(e.getSource()==numberButton[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton){
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource()==addButton){
            num1=Double.parseDouble(textfield.getText());
            operator='+';
            textfield.setText("");
        }
        if(e.getSource()==subButton){
            num1=Double.parseDouble(textfield.getText());
            operator='-';
            textfield.setText("");
        }
        if(e.getSource()==mulButton){
            num1=Double.parseDouble(textfield.getText());
            operator='*';
            textfield.setText("");
        }
        if(e.getSource()==divButton){
            num1=Double.parseDouble(textfield.getText());
            operator='/';
            textfield.setText("");
        }
        if(e.getSource() == negButton) {
			textfield.setText(textfield.getText().concat("-"));
		}
        if(e.getSource()==equButton){
            num2=Double.parseDouble(textfield.getText());
            
            switch (operator){
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    result=num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()==clrButton){
            textfield.setText("");
        }
        if(e.getSource()==delButton){
            String temp=textfield.getText();
            textfield.setText("");
            for(int i=0;i<temp.length()-1;i++){
                textfield.setText(textfield.getText()+temp.charAt(i));
            }
        }
        if(e.getSource()==negButton){
            double temp=Double.parseDouble(textfield.getText());
            temp*=-1;
            textfield.setText(String.valueOf(temp));
        }
    }
}
