package com.arintv.conlabs.dialogs;

/* 2018.12.08 다이얼로그 상자로 새 창 띄우기
 * 이 예제는 ARINTV ARCHIVE "001. 버튼으로 새 창 띄우기 / Java / Swing / 18.09.27"
 * (https://arintvsecond.tistory.com/14) 글의 예제를 JDialog로 변형한 예제입니다.*/

import javax.swing.*;
import java.awt.*;

public class DialogComponents extends JFrame {

    final String dialogTitle = "다이얼로그 새 창";

    public JPanel MainComponent() {
        JPanel MainContainer = new JPanel();
        MainContainer.setLayout(new FlowLayout());

        JButton callDialog = new JButton("새 창 띄우기");
        MainContainer.add(callDialog);

        callDialog.addActionListener(new DialogActionListener(this, dialogTitle, false));
        // 액션리스너로 다이얼로그 상자를 불러냅니다.
        // 다이얼로그를 상속받은 리스너는 생성자의 구성요소로 (JFrame, modal)을 기본적으로 가집니다.
        // 이 예제에서는 JFrame과 String(창 제목), Boolean(모달 여부)를 매개변수로 합니다.
        return MainContainer;
    }
}
