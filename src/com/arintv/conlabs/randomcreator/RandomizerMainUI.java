/* 무작위 난수 생성기, Java Swing 프로그램
 *
 * 2018.11.14, Created by MintArin
 * (C) 2018 ARINTV Contents Creation Labs.
 *
 * 본 프로그램의 소스는 MIT 허가서(MIT License)를 적용해 오픈소스로 공개합니다.
 * 이 소스의 전문은 https://github.com/ARINTVConLabs/RandomCreator 에서 확인할 수 있습니다. */

package com.arintv.conlabs.randomcreator;

import javax.swing.*;

public class RandomizerMainUI extends JFrame {

	// Swing 구성요소를 담고 있는 클래스
	MainUIComponents comp = new MainUIComponents();

	public RandomizerMainUI() {
		CreateUI("무작위 난수 생성기"); // 메인프레임 생성
		setContentPane(comp.MainUI());
		// 메인프레임의 주 콘텐트판을 MainUIComponents 클래스의 MainUI() 메서드의 값으로 설정합니다.
	}

	public void CreateUI(String Title) {
		setTitle(Title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(480, 242); // 16:9 기본 해상도
		setResizable(false);
		setLocationRelativeTo(null); // 시작시 화면 중앙에 프로그램 표시
		setVisible(true);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new RandomizerMainUI();
			}
		});
	}
}