package com.macrosoft.object;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.macrosoft.util.Constant;

public class Background extends Stuff{

	private JPanel jPanel;
	public Background() {
		//空构造函数
	} 
	/**
	 * @Title: Background构造函数
	 * @Description:传入背景参数
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param image
	 * @param frame:
	 */
//	public Background(int x,int y,int width,int height,Image image,JFrame jframe) {
//		this.x=x;
//		this.y=y;
//		this.width=width;
//		this.height=height;
//		this.image=image;
//		this.jframe=jframe;
//	}
	/**
	 * 
	 * @Title: Background构造函数
	 * @Description:TODO
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param image
	 * @param jframe:
	 */
	public Background(int x,int y,int width,int height,Image image,Frame frame) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.image=image;
		this.frame=frame;
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

	/* 
	* @Title: drawMe 
	* @Description: 画出背景
	* @param g 
	* @see com.macrosoft.object.Stuff#drawMe(java.awt.Graphics) 
	 */
	@Override
	public void drawMe(Graphics g) {
		g.drawImage(image, this.x, this.y, this.width, this.height, this.frame);
	}
	
	
	

}
