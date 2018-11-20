package com.macrosoft.object;

import java.applet.Applet;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;

import javax.swing.JFrame;

import com.macrosoft.util.Constant;
import com.macrosoft.util.RunTrack;

public class Bomb extends Stuff {
	private Image image;
	public RunTrack runtrack=new RunTrack();
	public Bomb() {
		
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

	public Bomb(int x, int y, int width, int height, Image image,JFrame jframe) {

		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.image=image;
		this.jframe=jframe;
		
	}
	
	//MediaTracker mt;
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
	public Bomb(int x, int y, int width, int height, Image image,Frame frame) {

		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.image=image;
		this.frame=frame;
		
		
//		mt=new MediaTracker(frame);
//		int i;
//		for(i=0;i<Constant.BOMBING_IMAGE.length;i++)
//		{
//			mt.addImage(Constant.BOMBING_IMAGE[i], 0);
//		}
//		
//		try {
//			mt.waitForID(0);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}

	@Override
	public boolean hit() {	
		return false;
	}

	/* 
	* @Title: drawMe 
	* @Description: 画爆炸图
	* @param g 
	* @see com.macrosoft.object.Stuff#drawMe(java.awt.Graphics) 
	 */
	@Override
	public void drawMe(Graphics g) {
		
		
//		if (Constant.BOOMING_FLAG==true) {
//			//GameStart.audioClip=Applet.newAudioClip(GameStart.class.getResource("/sounds/boom.wav"));
//			//GameStart.audioClip.play();
//			int q=0;
//			for(int i=0;i<Constant.BOMBING_IMAGE.length;i++)
//			{
//				q+=5;
//				for(int k=0;k<255;k++);
//				g.drawImage(Constant.BOMBING_IMAGE[i], x, y+q, frame);
//			}
//			Constant.BOOMING_FLAG=false;
//		}
//		else{
//		
			g.drawImage(image, this.x, this.y, this.width, this.height, this.frame);
			move();
//		}
	}
	
	
	public void move() {
		// TODO Auto-generated method stub
		runtrack.run();
		x=runtrack.getX();
		y=runtrack.getY();
		if(x<Constant.M_ZERO||x>Constant.M_WIDTH||y>Constant.FRUIT_HEIGHT)
			life=false;
	}
	
	/**
	 * @Title: BhitB方法
	 * @Description: 炸弹与子弹的碰撞方法
	 * @param bullet
	 * @return: TODO
	 * @return int 
	 * @throws 
	 */
	public int BhitB(Bullet bullet ){
		
		if(getRectangle().intersects(bullet.getRectangle())){
			
			life =false;
			return 1;
		}
		return 0;
			
	}
	
	
		/**
		 * @Title: BhitM方法
		 * @Description: 炸弹与人的碰撞
		 * @param man
		 * @return: TODO
		 * @return int 
		 * @throws 
		 */
		public int BhitM(People man ){
		
		if(getRectangle().intersects(man.getRectangle())){
			
			life =false;
			return 1;
		}
		return 0;
			
	}
	
		public int getX(){
			return x;
		}
		public int getY(){
			return y;
		}
	/* (non-Javadoc)
	* @Title: getRectangle 
	* @Description: 炸弹的坐标返回
	* @return 
	* @see com.macrosoft.object.Stuff#getRectangle() 
	 */
	public Rectangle getRectangle(){
		
		return new Rectangle(x,y,width,height);
	}

}
