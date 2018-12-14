package com.arintv.conlabs.rngratiomanipulator;

import javax.swing.*;

public class MainUI extends JFrame {

    MainUIComponents mainComp = new MainUIComponents();

    public MainUI() {
        CreateUI("무작위 난수 조작기");
        setContentPane(mainComp.Components());
    }

    private void CreateUI(String Title) {
        setTitle(Title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(480, 242);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainUI();
            }
        });
    }
}