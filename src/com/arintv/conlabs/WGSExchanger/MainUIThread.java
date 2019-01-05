package com.arintv.conlabs.WGSExchanger;

import javax.swing.*;

public class MainUIThread extends JFrame {

    private void MainUIStart(String title) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainComponents mainComponents = new MainComponents();
        setContentPane(mainComponents.MainComponent());

        setJMenuBar(mainComponents.ProgramMenu());

        setSize(320, 200);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainUIThread().MainUIStart("WGS84 Exchanger");
        });
    }
}
