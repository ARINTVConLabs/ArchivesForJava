package com.arintv.conlabs.dialogs;

/* 2018.12.08 다이얼로그 상자로 새 창 띄우기
 * 이 예제는 ARINTV ARCHIVE "001. 버튼으로 새 창 띄우기 / Java / Swing / 18.09.27"
 * (https://arintvsecond.tistory.com/14) 글의 예제를 JDialog로 변형한 예제입니다.*/

import javax.swing.*;

public class DialogMainUI extends JFrame{

    DialogComponents dialogComponents = new DialogComponents();

    public DialogMainUI() {
        MainFrameConfigs("다이얼로그 창 띄우기");
        setContentPane(dialogComponents.MainComponent());
    }

    protected void MainFrameConfigs(String title) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);
        setSize(300, 100); // 창의 크기는 300, 100
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { new DialogMainUI(); });
    }
    // 이 식은 Java 1.8 이후부터 지원하는 람다 식 (lambda Expression)으로 인터페이스를 간단하게 표현할 수 있습니다.
    // 이 식의 원본은 아래와 같습니다.
    /* SwingUtilities.invokeLater(new Runnable() {
           @Override
           public void run() {
               new DialogMainUI();
           }
       });
     */
}
