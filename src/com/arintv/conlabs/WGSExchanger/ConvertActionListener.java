package com.arintv.conlabs.WGSExchanger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConvertActionListener implements ActionListener {

    JTextField StartLatitude, StartLongitude, EndLatitude, EndLongitude;
    JComboBox getConvertType;
    JFrame UI;

    public ConvertActionListener(JTextField wgs84_start_latitude, JTextField wgs84_start_longitude, JTextField wgs84_end_latitude, JTextField wgs84_end_longitude, JComboBox<String> getConvertType, JFrame UI) {
        StartLatitude = wgs84_start_latitude;
        StartLongitude = wgs84_start_longitude;
        EndLatitude = wgs84_end_latitude;
        EndLongitude = wgs84_end_longitude;
        this.getConvertType = getConvertType;
        this.UI = UI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Action = e.getActionCommand();
        if (Action == "Calculate Distances") {

            try {
                double SLati = Double.parseDouble(StartLatitude.getText());
                double SLongi = Double.parseDouble(StartLongitude.getText());
                double ELati = Double.parseDouble(EndLatitude.getText());
                double ELongi = Double.parseDouble(EndLongitude.getText());
                String ConvertType = getConvertType.getSelectedItem().toString();

                ConvertDialog convertDialog = new ConvertDialog(UI, "Result", true, SLati, SLongi, ELati, ELongi, ConvertType, UI);
                convertDialog.setVisible(true);

            } catch (NumberFormatException ex) {
                ErrDialog errDialog = new ErrDialog(UI, "Error", true);
                errDialog.setVisible(true);
            }
        }
    }

    private class ErrDialog extends JDialog {

        public ErrDialog(Frame owner, String title, boolean modal) {
            super(owner, title, modal);
            setContentPane(MainContainer());

            DialogFrameSetting();
        }

        public void DialogFrameSetting() {
            setSize(240, 80);
            setLocationRelativeTo(UI);
            setResizable(false);

            pack();
        }

        public JPanel MainContainer() {
            JPanel DialogMainContainer = new JPanel();

            JLabel DialogErrMessage = new JLabel("Please input all components!");

            DialogMainContainer.add(DialogErrMessage);

            return DialogMainContainer;
        }
    }
}
