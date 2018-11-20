package com.macrosoft.object;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.JFrame;


public abstract class Stuff {
	protected Image image;//对象到图片
	protected int width;//图片宽度
	protected int height;//图片长度
	protected int x;//x坐标
	protected int y;//y坐标
	protected boolean life = true;//生命值
	public boolean isLife() {
		return life;
	}
	public void setLife(boolean life) {
		this.life = life;
	}
	protected int speed=5;
	protected JFrame jframe;
	protected Frame frame;
	
	
	public abstract void move();
	public abstract boolean hit();
	public abstract void drawMe(Graphics g);
	/**
	 * 
	 * @Title: getRectangle方法
	 * @Description: 获取矩形
	 * @return: 矩形
	 * @return Rectangle 
	 * @throws
	 */
	public Rectangle getRectangle(){
		return new Rectangle(x, y, width, height);
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	
	

}
