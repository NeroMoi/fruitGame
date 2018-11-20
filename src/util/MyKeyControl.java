package com.macrosoft.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.macrosoft.object.People;

public class MyKeyControl extends KeyAdapter{
	
	People people;
	/**
	 * 
	 * @Title: MyKeyControl构造函数
	 * @Description:TODO:
	 */
	public MyKeyControl() {
		// TODO Auto-generated constructor stub
	}
	
	public MyKeyControl(People people){
		this.people = people;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		people.move(e);
		
	}
	

}
