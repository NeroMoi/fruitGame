package com.macrosoft.util;

import java.util.Random;

import javax.sql.rowset.Predicate;

/**
 * @ClassName： RunTrack
 * @Description: 轨迹类
 * @author: lpc
 * @Email： 546750658@qq.com
 * @Date：  2017年6月19日 下午7:02:06
 */
public class RunTrack {
	
	/*
	 * 1.ֱ直线
	 * 2.斜线
	 * 3.抛物线
	 * 4.正弦曲线
	 * 5.x*x=2py, y=Asin(Wx)+k;,y=kx+b,x=..;
	 * */
	

	
	private int speed=4;//坐标改变的速度	
	private int x;//x坐标
	private int y;//y坐标
	
	private int x1;//x初始坐标
	private int y1;//y初始坐标
	
	private int p;		//抛物线参数
	private int p_flag;//0：抛物线向左:1：抛物线向右
	
	private double pi = 3.14;
	
	private int A;//振幅
	private double W;//角速度
	private double T;//周期
	private int A_flag;//0:正弦向左，1：正弦向右
	
	private int k;//斜率
	private int b;//直线初始B
	private int k_flag;//方法二直接取数
	
	
	private int flag;//功能标志位־
	
	private int mGameWidth;//轨迹最大宽度
	
	private int mGameheight;//轨迹最大高度
	
	Constant constant1;
	
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
	public  RunTrack(){
		
	}
	
	
	/**
	 * @Title: Run_Track_init方法
	 * @Description: TODO
	 * @param x
	 * @param y
	 * @param flag: TODO
	 * @return void 
	 * @throws 
	 */
	public void Run_Track_init(int x,int y ,int flag){
		
		this.x = x;
		this.x1 = x;
		this.y = y;
		this.y1 =y;
		this.flag = flag;
		
		this.mGameheight = constant1.FRUIT_HEIGHT;
		this.mGameWidth = constant1.M_WIDTH;
	//	this.mGameheight = 800;//constant1.fruitHeight;
	//	this.mGameWidth = 1000;//constant1.screenWidth;
		
		choice_Pattern(flag);
		
	
				
	}
	
	/**
	 * @Title: choice_Pattern方法
	 * @Description: 运动轨迹初始化选择
	 * @param flag: TODO
	 * @return void 
	 * @throws 
	 */
	public void choice_Pattern( int flag)
	{
		switch(flag){
		
			case 1:init_Straight();break;//初始化直线参数
			case 2:init_Bias();;break;//初始化斜线参数
			case 3:init_Parabola();break;//初始化抛物线参数
			case 4:init_Sinusoid();//初始化正弦曲线参数
			default:
				
		}
		
		
	}
	
	/**
	 * @Title: run方法
	 * @Description: 调用运动方法
	 * @return void 
	 * @throws 
	 */
	public void run(){
		
		switch(flag){
		
		case 1: run_Straight_Line();break;
		case 2: run_Bias();break;
		case 3: run_Parabola();break;
		case 4: run_Sinusoid();break;
		default:break;
		
		}
		
	}
	
	
	

	/**
	 * @Title: init_Straight方法
	 * @Description: 初始化直线
	 * @return void 
	 * @throws 
	 */
	public void init_Straight()
	{
		this.flag=1;
	
	
		
	}
	
	

	/**
	 * @Title: init_Bias方法
	 * @Description: 初始化斜线
	 * @return void 
	 * @throws 
	 */
	public void init_Bias()
	{
		
		/*
		 * 方法一，直接等比例加减
		 * 数据：
		 * 1：x+=3,y+=3;
		 * 2: x+=3,y+=4;
		 * 3. x+=4,y+=4;
		 * 
		 * 4. x-=3,y+=3;
		 * 5. x-=3,y+=4;
		 * 6. x-=4,y+=4；
		 * */
	 
		
		if(x>mGameWidth*0.8)
		{
			k_flag = 6;
		}
		else if(x<mGameWidth*0.2)	
		{
			k_flag = 3;
		}
		
		else {
			
			Random random = new Random();
			this.k_flag = random.nextInt(6)%(6-1+1)+1;//1-6的随机数
		}
	
			
	
		
		
/*
 * 直接运用表达式的方法
 * 不适用斜率存在正无穷或负无穷的情况
 * 
 * */		
//		this.flag=2;
//		int kmax,kmin,bmax,bmin;
//		
//		kmax=3;
//		kmin=-1;
//	//	kmax=(int)((this.y-0)/(this.x-0));//正斜率
//	//	kmin=(int)((this.y-0)/(this.x-this.mGameWidth));//负斜率
//		
//		Random random = new Random();
//		this.k=kmin+(random.nextInt(kmax-kmin));//产生负数到正数的随机数k
//		
//		
//		if(k>0)
//		{
//			bmax=0;
//			bmin=-(mGameWidth*5);
//			Random random1 = new Random();
//			this.b=(-1)*random1.nextInt((-1*bmin));//b的随机数-4000-0
//			
//		}
//		else if(k<0)
//		{
//			bmin=mGameWidth+mGameheight;
//			bmax=mGameWidth*5+mGameheight;
//			
//			Random random1 = new Random();
//			this.b=random1.nextInt(bmax)%(bmax-bmin+1)+bmin;;//b的随机数1400-4600
//			
//		}
//		else {
//			
//		}

	//	bmax=this.y-this.k*this.x;
	
	//	Random random1 = new Random();
	//	this.b=random1.nextInt(bmax);//b的随机数
		
		
		
	}
	
	

	/**
	 * @Title: init_Sinusoid方法
	 * @Description: 初始化正弦参数
	 * @return void 
	 * @throws 
	 */
	public void init_Sinusoid()
	{
		
		this.flag=4;
		
		Random random = new Random();
		A = random.nextInt(100)%(100-20+1)+20;//振幅20-100
		k=y1;//初始高度（原点）
		Random random1 = new Random();
		T = random1.nextInt(3)%(3-2+1)+2;//2-3个周期
		T = mGameWidth/T;
		W=(2*pi)/T;
		
		if(x1<mGameWidth*0.2)
		{
			A_flag=1;//向右
		}
		else if(x1>mGameWidth*0.8)
		{
			A_flag=0;//向左
		}
		else
		{
			Random random2 = new Random();
			A_flag = random2.nextInt(2);//随机生成飘向方向
		}
		
		
		
		
		
	}
	

	/**
	 * @Title: init_Parabola方法
	 * @Description: 初始化抛物线参数
	 * @return void 
	 * @throws 
	 */
	public void init_Parabola()
	{
		this.flag=3;
		
		int pmax,pmin;
		pmax=(int)((mGameWidth-x1)*(mGameWidth-x1)/(2*(mGameheight-y1)));
		pmin=(int)(((mGameWidth-x1)*0.25+x1-x1)*((mGameWidth-x1)*0.25+x1-x1))/(2*(mGameheight-y1));

		Random random = new Random();
		p = random.nextInt(pmax)%(pmax-pmin+1)+pmin;
		
		if(x1>mGameWidth*0.8)
		{
			p_flag = 0;
		}
		else if(x1<mGameWidth*0.2)
		{
			p_flag = 1;
		}
		else {
			
			Random random1 = new Random();
			p_flag = random1.nextInt(2);
		}		
		
	}

	/**
	 * @Title: run_Straight_Line方法
	 * @Description: 直线运动
	 * @return void 
	 * @throws 
	 */
	public void run_Straight_Line(){
		
		y+=speed;
	
	}
	

	/**
	 * @Title: run_Parabola方法
	 * @Description: 抛物线运动
	 * @return void 
	 * @throws 
	 */
	public void run_Parabola(){
		
		if(p_flag>0)
		{
			x+=speed;		
			y=(int)(((x-x1)*(x-x1)+2*p*y1)/(2*p));
			
		}
		else
		{
			try{
				if(p==0)
				{
					p=1;
				}
				x-=speed;		
				y=(int)(((x-x1)*(x-x1)+2*p*y1)/(2*p));
			
			}
			catch(Exception e)
			{
				
				System.out.println("x:"+x);
				System.out.println("y:"+y);
				System.out.println("p:"+p);
			}
		}
		
	}
	
	

	/**
	 * @Title: run_Sinusoid方法
	 * @Description: 正弦曲线运动
	 * @return void 
	 * @throws 
	 */
	public void run_Sinusoid(){
		
		if(A_flag>0)
		{
			x+=speed;
			y=(int)(A*Math.sin(W*x)+k);
		}
		else {
			x-=speed;
			y=(int)(A*Math.sin(W*x)+k);
		}
		
		
	}
	
	

	/**
	 * @Title: run_Bias方法
	 * @Description: 斜线运动
	 * @return void 
	 * @throws 
	 */
	public void run_Bias(){
		
		/*
		 * 方法一，直接等比例加减
		 * 数据：
		 * 1：x+=3,y+=3;
		 * 2: x+=3,y+=4;
		 * 3. x+=4,y+=4;
		 * 
		 * 4. x-=3,y+=3;
		 * 5. x-=3,y+=4;
		 * 6. x-=4,y+=4；
		 * */
		
		
	switch(k_flag){
	
		case 1:x+=(speed-1);y+=3;break;
		case 2:x+=(speed-1);y+=speed;break;
		case 3:x+=speed;y+=speed;break;
		case 4:x-=(speed-1);y+=(speed-1);break;
		case 5:x-=(speed-1);y+=speed;break;
		case 6:x-=speed;y+=speed;break;
		default:y+=speed;break;
	
	}
		
		
		
	/*	
	 * 此画布不适合此种方法二-》直接取斜率
	 * 
	 * if(this.k>0)
		{
			y+=4;
			x=(int)((y-b)/k);
		}
		else if(this.k<0)
		{
			y+=4;
			x=(int)((y-b)/k);
		}
		else
		{
			y+=4;
		}*/
		
	}
	
		
}
