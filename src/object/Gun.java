package com.macrosoft.object;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;

import com.macrosoft.util.RunTrack;

public class Gun extends Stuff{
	
	//子弹角度
	private double gunAngle=0;
	/**
	 * 
	 * @Title: Gun构造函数
	 * @Description:TODO
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param image
	 * @param jframe:
	 */
	public Gun(int x,int y, int width,int height,Image image,JFrame jframe) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
		this.jframe = jframe;
	}
	/**
	 * 
	 * @Title: Gun构造函数
	 * @Description:TODO
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param image
	 * @param frame:
	 */
	public Gun(int x,int y, int width,int height,Image image,Frame frame) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
		this.frame = frame;
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

	@Override
	public void drawMe(Graphics g) {
		
		Graphics2D ga = (Graphics2D)g;
		//旋转枪  ( 旋转角度   旋转点x坐标  旋转点y坐标)
		ga.rotate(-gunAngle,x,y+height/2);
		ga.drawImage(image, x, y, width, height, frame);
	}
	
	public void rotate(){
		
	}
	//设置枪的x坐标
	public void setX(int x) {
		this.x=x;
	}
	//获得枪的x坐标
	public int getX(){
		return x;
	}
	//获得枪的y坐标
	public int getY(){
		return y;
	}
	//设置枪的角度
	public void setgunAngle(double Angle){
		this.gunAngle=Angle;
	}
	//获得枪的角度
	public double getgunAngle(){
		return gunAngle;
	}

}
