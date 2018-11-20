package com.macrosoft.object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JFrame;

import com.macrosoft.util.Constant;
import com.macrosoft.util.RunTrack;

public class Fruit extends Stuff{
	
	private String str;
	String [] s={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}


	private int Model=0;
	/**
	 * 
	 * @Title: Fruit构造函数
	 * @Description:Fruit有参构造函数
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param image
	 * @param frame:
	 */
	public Fruit(int x,int y,int width, int height,Image image,JFrame jframe){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
		this.life=true;
		this.jframe = jframe;
		craetLetter();
	}
	/**
	 * 
	 * @Title: Fruit构造函数
	 * @Description:TODO
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param image
	 * @param jframe:
	 */
	public Fruit(int x,int y,int width, int height,Image image,Frame frame){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
		this.life=true;
		this.frame = frame;
		craetLetter();
	}
	public Fruit(int x,int y,int width, int height,Image image,Frame frame,int order){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
		this.life=true;
		this.jframe = jframe;
		//craetLetter();
		str=s[order];
	}

	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	private RunTrack runtrack=new RunTrack();

	public RunTrack getRuntrack() {
		return runtrack;
	}

	//public void setRuntrack(RunTrack runtrack) {
	//	this.runtrack = runtrack;
	//}
	
	
	public void drawLetter(Graphics g){
		
	}
	public void drawWord(Graphics g){
		
	}





	/* (non-Javadoc)
	* @Title: drawMe 
	* @Description: TODO
	* @param g 
	* @see com.macrosoft.object.Stuff#drawMe(java.awt.Graphics) 
	 */
	@Override
	public void drawMe(Graphics g){
		if(life){
				
/*			switch (Model) {
			case 0:
				
				break;

			default:
				break;
			}*/
			
			//绘制水果图案
			g.drawImage(image, x, y, width,height,frame);
			//绘制水果图案矩形框(用于测试!!!)
			//g.drawRect(x, y, width, height);
			//设置字体属性
			g.setFont(new Font("Hannotate SC", Font.BOLD, 40));
			//设置画笔颜色
			g.setColor(Color.WHITE);
			//绘制字母
			g.drawString(str, x+width/2-15, y+height/2+15);
			move();
		}
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		runtrack.run();
		x=runtrack.getX();
		y=runtrack.getY();
		if(x<Constant.M_ZERO||x>Constant.M_WIDTH||y>Constant.FRUIT_HEIGHT)
			life=false;
	}

	@Override
	public boolean hit() {
		// TODO Auto-generated method stub
		return false;
	}
	

	/**
	 * @Title: craetLetter方法
	 * @Description:随机产生26个英文字母(区分大小写)
	 * @return void 
	 * @throws 
	 */
	public void craetLetter(){
		char c;//临时字符变量
		Random random=new Random();
		//随机数控制产生字母大小写
		int x=random.nextInt();
		if(x%2==0)
			c=(char)(int)(Math.random()*26+'A');
		else
			c=(char)(int)(Math.random()*26+'a');
		//产生的随机字符转为字符串
		 str = String.valueOf(c);
	}
	
	
	public int FhitB(Bullet bullet ){
		
		if(getRectangle().intersects(bullet.getRectangle())){
			
			life =false;
			return 1;
		}
		return 0;
			
	}
	
	/* (non-Javadoc)
	* @Title: getRectangle 
	* @Description: 水果的坐标返会
	* @return 
	* @see com.macrosoft.object.Stuff#getRectangle() 
	 */
	public Rectangle getRectangle(){
		
		return new Rectangle(x,y,width,height);
	}
}
