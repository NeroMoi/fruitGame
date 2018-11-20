package com.macrosoft.object;

import java.applet.Applet;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

import com.macrosoft.util.Constant;

/**
 * @author 作者MSY E-mail:
 * @date 创建时间：2017年6月21日 下午8:14:10
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class Bombing extends Stuff {
	private Image[] image;

	public Bombing() {

	}

	/**
	 * @Title: Bomb构造函数
	 * @Description:传入爆炸参数
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param image
	 * @param frame
	 */

	public Bombing(int x, int y, int width, int height, Image[] image, JFrame jframe) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
		this.jframe = jframe;

	}

	/**
	 * 
	 * @Title: Bomb构造函数
	 * @Description:TODO
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param image
	 * @param jframe:
	 */
	public Bombing(int x, int y, int width, int height, Image[] image, Frame frame) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
		this.frame = frame;

	}

	/*
	 * @Title: drawMe
	 * 
	 * @Description: 画爆炸图
	 * 
	 * @param g
	 * 
	 * @see com.macrosoft.object.Stuff#drawMe(java.awt.Graphics)
	 */
	@Override
	public void drawMe(Graphics g) {
		
		
/*		if (Constant.BOOMING_FLAG==true) {
			GameStart.audioClip=Applet.newAudioClip(GameStart.class.getResource("/sounds/boom.wav"));
			GameStart.audioClip.play();
			g.drawImage(Constant.BOMBING_IMAGE[Constant.NUM], x, y, this);
		
		}*/
		
		
		for (int i = 0; i < image.length; i++) {
			g.drawImage(image[i], this.x, this.y, this.width, this.height, this.frame);
		}
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hit() {
		// TODO Auto-generated method stub
		return false;
	}

}
