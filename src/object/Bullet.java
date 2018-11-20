package com.macrosoft.object;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JFrame;

import com.macrosoft.util.Constant;

public class Bullet extends Stuff{
	private int bulletNum=26;
	private double bulletAngle=0;
	private int speed=35;
	//private int InitialAngle=0;
	//private int CorrectAngle=0;
	private double angleValue;
	//提交用
	private int test;

	/**
	 * @Title: Bullet构造函数
	 * @Description:Bullet有参构造函数
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param image
	 * @param frame:
	 */
	public Bullet(int x,int y,int width, int height,Image image,JFrame jframe){
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.image = image;
			this.life=true;
			this.jframe = jframe;			
	}
	/**
	 * 
	 * @Title: Bullet构造函数
	 * @Description:TODO
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param image
	 * @param jframe:
	 */
	public Bullet(int x,int y,int width, int height,Image image,Frame frame){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
		this.life=true;
		this.frame = frame;
		//this.
		//CorrectAngle=correctAngle(InitialAngle);
		//angleValue=Math.toRadians(InitialAngle))
		//angleValue=Math.cos(bulletAngle);
		
	
}


	@Override
	public void move() {
		
		//子弹移动轨迹，根据当前角度进行移动，分解速度到x轴，y轴;
		x+=(int)(speed*Math.cos(bulletAngle));
		y-=(int)(speed*Math.sin(bulletAngle));
		if(x<0||x>Constant.M_WIDTH||y<0)
			life=false;
		
	}

	@Override
	public boolean hit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void drawMe(Graphics g) {
		// TODO Auto-generated method stub
		if(life){
			g.drawImage(image, x, y, width,height,frame);
			move();
		}
		
	}
	public void reduceBulletNum(){
		bulletNum--;	
		if(bulletNum<0)
			bulletNum=0;
	}
	public void addBulletNum(){
		bulletNum+=5;	
		if(bulletNum>=26)
			bulletNum=26;
	}
	
	
	/* (non-Javadoc)
	* @Title: getRectangle 
	* @Description: 子弹的坐标返回
	* @return 
	* @see com.macrosoft.object.Stuff#getRectangle() 
	 */
	public Rectangle getRectangle(){
		
		return new Rectangle(x,y,width,height);
	}
	
	public void setBulletAngle(double Angle){
		bulletAngle=Angle;
		
	}

}
