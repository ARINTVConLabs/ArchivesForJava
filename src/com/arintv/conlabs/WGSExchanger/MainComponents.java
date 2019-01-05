package com.arintv.conlabs.WGSExchanger;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class MainComponents extends JFrame {

    JTextField WGS84_Start_Latitude;
    JTextField WGS84_Start_Longitude;
    JTextField WGS84_End_Latitude;
    JTextField WGS84_End_Longitude;
    JComboBox<String> getConvertType;
    JButton Convert;

    public JPanel MainComponent() {
        JPanel ContentPanel = new JPanel();
        ContentPanel.setLayout(new BorderLayout());

        ContentPanel.add(CenterPanel(), BorderLayout.CENTER);
        ContentPanel.add(SouthPanel(), BorderLayout.SOUTH);

        return ContentPanel;
    }

    public JMenuBar ProgramMenu() {
        JMenuBar ProgramMenuBar = new JMenuBar();

        ProgramMenuBar.add(Files());
        ProgramMenuBar.add(Actions());

        return ProgramMenuBar;
    }

    public JMenu Files() {
        JMenu FilesMenu = new JMenu("File");

        String Exit = "Exit";
        JMenuItem FilesItem = new JMenuItem(Exit);
        FilesMenu.add(FilesItem);
        FilesItem.addActionListener((e) -> {
            if(e.getActionCommand().equals("Exit")) {
                System.exit(0);
            }
        });

        return FilesMenu;
    }

    public JMenu Actions() {
        JMenu ActionsMenu = new JMenu("Action");

        String[] ActionsName = {"Calculate", "Clear Components"};
        for(int i = 0; i<ActionsName.length; i++) {
            JMenuItem ActionsItem = new JMenuItem(ActionsName[i]);
            ActionsMenu.add(ActionsItem);
            ActionsItem.addActionListener((e) -> {
                String Action = e.getActionCommand();

                switch (Action) {
                    case "Calculate":
                        Convert.doClick();
                        break;
                    case "Clear Components":
                        WGS84_Start_Longitude.setText("");
                        WGS84_Start_Latitude.setText("");
                        WGS84_End_Latitude.setText("");
                        WGS84_End_Longitude.setText("");
                        getConvertType.setSelectedIndex(0);
                        break;
                }
            });
        }
        return ActionsMenu;
    }


    private JPanel CenterPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel WGS84_Start = new JLabel("WGS84 Start Point");
        JLabel WGS84_End = new JLabel("WGS84 End Point");
        JLabel WGS84_SetType = new JLabel("Convert Type");

        WGS84_Start_Latitude = new JTextField(10);
        WGS84_Start_Longitude = new JTextField(10);
        WGS84_End_Latitude = new JTextField(10);
        WGS84_End_Longitude = new JTextField(10);

        WGS84_Start_Latitude.setSize(60, 20);
        WGS84_Start_Longitude.setSize(60, 20);
        WGS84_End_Latitude.setSize(60, 20);
        WGS84_End_Longitude.setSize(60, 20);

        WGS84_Start.setSize(110, 20);
        WGS84_End.setSize(100, 20);
        WGS84_SetType.setSize(110, 20);

        WGS84_Start_Latitude.setLocation(140, 20);
        WGS84_Start_Longitude.setLocation(210, 20);
        WGS84_End_Latitude.setLocation(140, 50);
        WGS84_End_Longitude.setLocation(210, 50);

        WGS84_Start.setLocation(20, 20);
        WGS84_End.setLocation(20, 50);
        WGS84_SetType.setLocation(20, 80);

        Vector<String> TypeData = new Vector<>();
        getConvertType = new JComboBox<>(TypeData);

        TypeData.add("Meter");
        TypeData.add("Kilometer");
        TypeData.add("Miles");
        TypeData.add("Nautical Miles");

        getConvertType.setSize(130, 20);
        getConvertType.setLocation(140, 80);

        getConvertType.setSelectedIndex(0);

        panel.add(WGS84_Start);
        panel.add(WGS84_End);
        panel.add(WGS84_SetType);

        panel.add(WGS84_Start_Latitude);
        panel.add(WGS84_Start_Longitude);
        panel.add(WGS84_End_Latitude);
        panel.add(WGS84_End_Longitude);
        panel.add(getConvertType);

        return panel;
    }

    private JPanel SouthPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        Convert = new JButton("Calculate Distances");

        Convert.addActionListener(new ConvertActionListener(WGS84_Start_Latitude, WGS84_Start_Longitude,
                WGS84_End_Latitude, WGS84_End_Longitude, getConvertType, this));

        panel.add(Convert, BorderLayout.CENTER);

        return panel;
    }
}
