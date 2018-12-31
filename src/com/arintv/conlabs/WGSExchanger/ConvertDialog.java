package com.arintv.conlabs.WGSExchanger;

import javax.swing.*;
import java.awt.*;

import static com.arintv.conlabs.WGSExchanger.WGStoKM.Distance;

public class ConvertDialog extends JDialog {

    double SLati, SLongi, ELati, ELongi;
    String ConvertType;
    JFrame UI;

    public ConvertDialog(Frame owner, String title, boolean modal, double SLati, double SLongi, double ELati, double ELongi, String ConvertType, JFrame UI) {
        super(owner, title, modal);
        this.SLati = SLati;
        this.SLongi = SLongi;
        this.ELati = ELati;
        this.ELongi = ELongi;
        this.ConvertType = ConvertType;
        this.UI = UI;

        DialogFrameSetting();

    }

    public void DialogFrameSetting() {
        setSize(240, 80);
        setContentPane(DialogComponents());

        DialogComponents();

        pack();
        setLocationRelativeTo(UI);
        setResizable(false);
    }

    public JPanel DialogComponents() {
        JPanel DialogMainComponets = new JPanel();

        JLabel ConvertResult = new JLabel();

        double result = Distance(SLati, SLongi, ELati, ELongi, ConvertType);

        ConvertResult.setText("Result: " + result + " " + ConvertType);

        DialogMainComponets.add(ConvertResult);

        return DialogMainComponets;
    }
}
