package com.arintv.conlabs.dialogs;

/* 2018.12.08 다이얼로그 상자로 새 창 띄우기
 * 이 예제는 ARINTV ARCHIVE "001. 버튼으로 새 창 띄우기 / Java / Swing / 18.09.27"
 * (https://arintvsecond.tistory.com/14) 글의 예제를 JDialog로 변형한 예제입니다.*/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogActionListener extends JDialog implements ActionListener {

    String Dialogtitle;
    JFrame OriginalFrame;

    public DialogActionListener(JFrame owner, String title, boolean modal) {
        super(owner, title, modal);
        // JDialog를 상속받을 경우에는 super를 입력해 주어야 합니다.
        // Modal(모달)이란?
        // true 값일 경우 모달 다이얼로그라 하며, 다이얼로그 창이 떴을 때 원래 창은 반응하지 않습니다.
        // false 값일 경우 모달리스 다이얼로그라 하며, 다이얼로그 창, 원래 창 둘 다 반응할 수 있습니다.

        Dialogtitle = title;
        OriginalFrame = owner;
    }

    private void CreateDialog() { // JDialog의 경우 JFrame과 동일하게 작동합니다.
        setTitle(Dialogtitle);
        setSize(300, 100);

        add(new JLabel("새 창 띄우기 성공"));

        setLocationRelativeTo(OriginalFrame);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if(button.equals("새 창 띄우기")) {
            CreateDialog();
        }
    }
}
