package com.macrosoft.object;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import com.macrosoft.util.Constant;

public class People extends Stuff{
	
	MediaTracker mt;
	protected Image[] image;//对象到图片
	//人物朝向标志 1为向右,2为向左
	private int turnFlag=1;//默认向右
	//设置人物朝向
	public void setTuenFlag(int i){
		turnFlag=i;
	}

	//左移次数
	private int leftmovenum=0;
	//右移次数
	private int rightmovenum=0;
	
	//人物生命
	private int lifeNumber;
	//获得人物生命
	public int getLifeNumber() {
		return lifeNumber;
	}
	//设置人物生命
	public void setLifeNumber(int lifeNumber) {
		this.lifeNumber = lifeNumber;
	}
	

	public Gun gun;
	/**
	 * 
	 * @Title: People构造函数
	 * @Description:TODO
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param image
	 * @param frame
	 * @param lifeNumber:
	 */
	public People(int x,int y,int width,int height,Image[] image,JFrame jframe,int lifeNumber) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
		this.jframe = jframe;
		this.lifeNumber = lifeNumber;
	}
	/**
	 * 
	 * @Title: People构造函数
	 * @Description:TODO
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param image
	 * @param frame
	 * @param lifeNumber:
	 */
	public People(int x,int y,int width,int height,Image[] image,Frame frame,int lifeNumber) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
		this.frame = frame;
		this.lifeNumber = lifeNumber;
		gun=new Gun(x+9,y+50, Constant.GUN_WIDTH, Constant.GUN_HEIGHT, Constant.GUN_IMAGE, frame);
		mt=new MediaTracker(this.frame);
		int i;
		for(i=0;i<Constant.BIRD_IMAGE.length;i++)
		{
			mt.addImage(Constant.BIRD_IMAGE[i], 1);
		}
		
		try {
			mt.waitForID(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
	
	
	public void move(KeyEvent e) {
		int keyCode = e.getKeyCode();//用于保存用户按下的键值
		int movement = 20;
		switch (keyCode) {
		case KeyEvent.VK_A:
			leftmovenum++;
			if(x-movement>=0){
				x-=movement;
			}
			
			break;
		case KeyEvent.VK_D:
			rightmovenum++;
			if(x+width+movement<=800){
				x+=movement;
			}
			;
			break;
		default:
			break;
		}
	}

	@Override
	public boolean hit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void drawMe(Graphics g) {
		
		
		if(turnFlag==1){
				int i=rightmovenum%5;//0-4右移动态图
				g.drawImage(image[i], x, y, width, height, frame);
				gun.setX(x+9);
		}else if(turnFlag==2){
				int i=leftmovenum%5+5;//5-9左移动态图
				g.drawImage(image[i], x, y, width, height, frame);	
				gun.setX(x+55);
		}
	}
	
	
	public void drawMe(Graphics g,int x,int y,int width,int height){
		g.drawImage(image[0], x, y, width,height,frame);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	/* (non-Javadoc)
	* @Title: getRectangle 
	* @Description: 人的坐标参数返回
	* @return 
	* @see com.macrosoft.object.Stuff#getRectangle() 
	 */
	public Rectangle getRectangle(){
		
		return new Rectangle(x,y,width,height);
	}

}
