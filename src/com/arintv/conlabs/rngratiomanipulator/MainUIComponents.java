package com.arintv.conlabs.rngratiomanipulator;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class MainUIComponents extends JFrame {

    JComboBox<Integer> RNGCount, RNGRatio;
    int yPos[] = {90, 120};

    public JPanel Components() {
        // MainContainer 세팅 영역 ///////////////////
        JPanel MainContainer = new JPanel();
        MainContainer.setLayout(new BorderLayout());
        //////////////////////////////////////////////

        // MainContainer 부착 판넬 구성 //////////////
        JPanel LeftPanel = new JPanel();
        LeftPanel.setLayout(new BorderLayout());
        JPanel CenterPanel = new JPanel();
        CenterPanel.setLayout(null);
        //////////////////////////////////////////////

        // LeftPanel 구성요소 생성 //
        JLabel ShowLabel = new JLabel("난수 생성 결과표"); // 난수 생성 결과 라벨
        ShowLabel.setHorizontalAlignment(CenterPanel.getWidth()/2);
        JTextArea ShowRNG = new JTextArea(5, 20); // 난수 생성 결과 표기
        JScrollPane TextPanel = new JScrollPane(ShowRNG);

        // CenterPanel 구성요소 생성 //
        JLabel RNGCounterSetLabel = new JLabel("난수 생성 개수");
        RNGCounterSetLabel.setSize(100, 30);
        RNGCounterSetLabel.setLocation(10, 10);

        JLabel RNGRatioLabel = new JLabel("난수 1 생성확률");
        RNGRatioLabel.setSize(100, 30);
        RNGRatioLabel.setLocation(10, 50);

        // 난수 1, 난수 2의 무작위 정도 결과 표기
        JLabel[] RNGCntLabel = new JLabel[2];
        for(int i = 0; i < RNGCntLabel.length; i++) {
            RNGCntLabel[i] = new JLabel();
            RNGCntLabel[i].setLocation(10, yPos[i]);
            RNGCntLabel[i].setSize(150, 30);
            CenterPanel.add(RNGCntLabel[i]);
        }

        RNGCntLabel[0].setText("난수 1 생성횟수: 00");
        RNGCntLabel[1].setText("난수 2 생성횟수: 00");



        // 판넬에 구성요소 부착
        // LeftPanel
        LeftPanel.add(ShowLabel, BorderLayout.NORTH);
        LeftPanel.add(TextPanel, BorderLayout.CENTER);
        // CenterPanel
        CenterPanel.add(RNGCounterSetLabel);
        CenterPanel.add(RNGRatioLabel);
        CenterPanel.add(setCountList(100));
        CenterPanel.add(setRatioList(10));

        // MainContainer.SOUTH 부착 버튼 생성
        JButton RNGStart = new JButton("난수 생성하기");
        RNGStart.addActionListener(new RNGMaker(RNGCntLabel[0], RNGCntLabel[1], RNGCount, RNGRatio, ShowRNG));

        // 컨테이너에 부착
        MainContainer.add(LeftPanel, BorderLayout.WEST);
        MainContainer.add(CenterPanel, BorderLayout.CENTER);
        MainContainer.add(RNGStart, BorderLayout.SOUTH);

        return MainContainer;
    }

    // CenterPanel 구성요소 setCountList: 난수 발생 개수 설정
    public JComboBox<Integer> setCountList(int length) {

        Vector<Integer> List = new Vector<Integer>();
        for(int i = 1; i<= length; i++) {
            List.add(i);
        }

        RNGCount = new JComboBox<>(List);
        RNGCount.setSize(80, 30);
        RNGCount.setLocation(120, 10);

        return RNGCount;
    }

    public JComboBox<Integer> setRatioList(int length) {

        Vector<Integer> List = new Vector<Integer>();
        for(int i = 1; i<= length; i++) {
            List.add(i);
        }

        RNGRatio = new JComboBox<>(List);
        RNGRatio.setSize(80, 30);
        RNGRatio.setLocation(120, 50);

        return RNGRatio;
    }

}