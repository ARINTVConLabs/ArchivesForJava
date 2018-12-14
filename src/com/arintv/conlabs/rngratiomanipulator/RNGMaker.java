package com.arintv.conlabs.rngratiomanipulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class RNGMaker implements ActionListener {

    JLabel RNGLabel1;
    JLabel RNGLabel2;
    JComboBox<Integer> RNGCounter;
    JComboBox<Integer> RNGRatio;
    JTextArea RNGShowText;


    public RNGMaker(JLabel RNGLabel1, JLabel RNGLabel2, JComboBox<Integer> RNGCounter, JComboBox<Integer> RNGRatio, JTextArea RNGShowText) {
        this.RNGLabel1 = RNGLabel1;
        this.RNGLabel2 = RNGLabel2;
        this.RNGCounter = RNGCounter;
        this.RNGRatio = RNGRatio;
        this.RNGShowText = RNGShowText;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Random rd = new Random();
        int one_counter = 0;
        int zero_counter = 0;
        StringBuffer sbuffer = new StringBuffer();

        String Create = (String)e.getActionCommand();
        if(Create == "난수 생성하기") {
            String a[] = new String[Integer.parseInt(RNGCounter.getSelectedItem().toString())];

            for(int i = 0; i<Integer.parseInt(RNGCounter.getSelectedItem().toString()); i++) {
                int randomseed = rd.nextInt(2)%Integer.parseInt(RNGRatio.getSelectedItem().toString());
                a[i] = Integer.toString(randomseed);

                sbuffer.append(i+1 + "번째 난수: " + a[i] + "\n");

                one_counter += Integer.parseInt(a[i]);
            }

            zero_counter = Integer.parseInt(RNGCounter.getSelectedItem().toString()) - one_counter;

            RNGLabel1.setText("난수 1 생성횟수: " + one_counter);
            RNGLabel2.setText("난수 2 생성횟수: " + zero_counter);

            RNGShowText.setText(sbuffer.toString());

        }

    }

}