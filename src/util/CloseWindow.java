package com.macrosoft.util;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * 
 * @ClassName： CloseWindow
 * @Description: 关闭窗口
 * @author: jiahao zhang
 * @Email： jiahaozhang@csus.edu
 * @Date：  Jun 20, 2017 10:21:12 AM
 */
public class CloseWindow extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	

}
