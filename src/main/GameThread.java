package com.macrosoft.main;

import java.applet.Applet;
import java.awt.Frame;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

import com.macrosoft.object.Bomb;
import com.macrosoft.object.Bombing;
import com.macrosoft.object.Bullet;
import com.macrosoft.object.Fruit;
import com.macrosoft.object.People;
import com.macrosoft.util.CloseWindow;
import com.macrosoft.util.Constant;

/**
 * @ClassName： GameThread
 * @Description:游戏线程
 * @author: lpc
 * @Email： 546750658@qq.com
 * @Date：  2017年6月21日 上午9:43:52
 */
public class GameThread implements Runnable{
	

	private boolean Threadlife = true;
	private boolean SoundFlag = false;
	private int timer = 0;//实习闪烁效果
	
	private int RuleWordNum=0;//生成0-25的随机数，对应26个英文字母
	
	
	public int getTimer() {
		return timer;
	}


	public void setTimer(int timer) {
		this.timer = timer;
	}


	public boolean isThreadlife() {
		return Threadlife;
	}


	public void setThreadlife(boolean threadlife) {
		Threadlife = threadlife;
	}
	private int TimeCount = 0;//定时器计数器
	
	private int SleepTime = 50;//线程睡眠时间
	
	ArrayList<Bomb> Bomblist;//炸弹动态数组
	
	ArrayList<Bullet> Bulletlist;//子弹动态数组
	
	ArrayList<Fruit> Fruitlist;//水果动态数组
	
	People Man;//人
	GameMain frame;
	
	Graphics g;
	
	int flag=0;
	
	/*
	 * 模式二的变量声明
	 * 
	 * */
	String AttackLetter = "";//在一个周期内打中的所有字母
	int RandomSubscript = 0;//周期随机生成的单词转char的记录下标
	int AttackLetterSubscript = 0;//周期内打中的所有字母转char的记录下标
	
	
	
	
	
	
	public int getTimeCount() {
		return TimeCount;
	}


	public void setTimeCount(int timeCount) {
		TimeCount = timeCount;
	}


	public int getSleepTime() {
		return SleepTime;
	}


	public void setSleepTime(int sleepTime) {
		SleepTime = sleepTime;
	}
	
	public GameThread(){
		
	}
	
	/**
	 * @Title: GameThread构造函数
	 * @Description:构造方法，初始便传必要参数
	 * @param bomblist
	 * @param bulletlist
	 * @param fruitlist
	 * @param man:
	 */
	public GameThread(GameMain frame,ArrayList<Bomb> bomblist, ArrayList<Bullet> bulletlist, ArrayList<Fruit> fruitlist, People man) {
		super();
		
		this.frame=frame;
		Bomblist = bomblist;
		Bulletlist = bulletlist;
		Fruitlist = fruitlist;
		Man = man;
		//this.g=g;
	}
	

	
	
	@Override
	public void run() {
		
		while(Threadlife){
					
			try {
				
				Thread.sleep(SleepTime);
				
				TimeCount++;
				timer++;
				if(timer == 10){
					timer = 0;
				}
				
				
				//judgeHit();
			//	if(TimeCount==50)
				//Threadlife=false;
				
//				
//				if(flag==0)
//				{
//					flag=1;
//					frame.paint(g);
//				}
				
				judgeHit();
				if (Constant.BOOMING_FLAG==true||Constant.BOOMING_FLAG1==true) {
					Constant.NUM++;
				//	System.out.println(Constant.NUM);
					SoundFlag = true;
				}
				
				if(Constant.NUM>5){
					Constant.NUM=0;
					Constant.BOOMING_FLAG=false;
					Constant.BOOMING_FLAG1=false;
				}
				if (Constant.FRUIT_FLAG==true) {
					Constant.NUM1++;
					SoundFlag = true;
				}
				
				if (Constant.NUM1>6) {
					Constant.NUM1=0;
					Constant.FRUIT_FLAG=false;
				}
				
				if (Constant.BOOMING_FLAG==true&&SoundFlag) {
				//	frame.audioClip=Applet.newAudioClip(GameMain.class.getResource("/sounds/boom.wav"));
					SoundFlag = false;
					frame.audioClip2.play();
				//	g.drawImage(Constant.BOMBING_IMAGE[Constant.NUM], people.getX(), people.getY()-50, this);
				
				}
				if (Constant.BOOMING_FLAG1==true&&SoundFlag) {
					SoundFlag = false;
					frame.audioClip2.play();
				//g.drawImage(Constant.BOMBING_IMAGE[Constant.NUM],Constant.BOMB_X, Constant.BOMB_Y, this);
				
				}
				if (Constant.FRUIT_FLAG==true&&SoundFlag) {
					SoundFlag = false;
					frame.audioClip2.play();
					
				//	g.drawImage(Constant.FURIT_IMAGE[Constant.NUM1],Constant.BOMB1_X-30, Constant.BOMB1_Y-30, this);
				}
				
				if(Man.getLifeNumber()>0&&(Constant.gameStatus == 3||Constant.gameStatus == 4))//添加对象
				{
					
					if(Constant.gameStatus==4)
					{					
						
					//	if(RuleWordNum==26)
					//		RuleWordNum=0;
						
						frame.setAnlge();
						frame.addBomb();
						frame.addBullet();	
				//		System.out.println("1");
						frame.addFruit1(RuleWordNum);
				//		System.out.println("2");
				//		System.out.println("num:"+RuleWordNum+"\n");
					//	System.out.println();
						RuleWordNum++;
					}
					else{
										
						frame.setAnlge();
						frame.addBomb();
						frame.addBullet();			
						frame.addFruit();
						
					}

					if(TimeCount%4000==0||(RandomSubscript== GameMain.lists.get(Constant.WORD_RANDOM).length()))//
					{
						frame.addWordList();//生成新单词
						AttackLetter = "";// 初始化单位周期内的字母
						RandomSubscript = 0;//初始化周期随机生成的单词转char的记录下标
						AttackLetterSubscript = 0;//初始化周期内打中的所有字母转char的记录下标
						frame.attackRight="";//初始化记录的内容
						
					}

				}
				else if(Man.getLifeNumber()<=0){
					

//					int n = JOptionPane.showConfirmDialog(null, "是否重新开始", "确认框", JOptionPane.YES_NO_OPTION); 
//					 if (n == JOptionPane.YES_OPTION) {  
//						 Man.setLifeNumber(5);
//						 Bomblist.removeAll(Bomblist);
//						 Bulletlist.removeAll(Bulletlist);
//						 Fruitlist.removeAll(Fruitlist);
//						 frame.score = 0;
//					 } else if (n == JOptionPane.NO_OPTION) {  
//						 
	//					 System.out.println("Score:"+frame.score);
					 if(Constant.FLAG){
						 frame.formergameStatus = Constant.gameStatus;
						 Constant.gameStatus = 6;
						 Constant.FLAG = false;
						 Bomblist.removeAll(Bomblist);
						 Bulletlist.removeAll(Bulletlist);
						 Fruitlist.removeAll(Fruitlist);
					 }
						 
					//	 Threadlife=false;
						 
					// }
					
					
				}
				
				
			}
			catch(InterruptedException e){
				
				System.out.println("线程未知错误");
				e.printStackTrace();
				
			}

			
			
				frame.repaint();	//重绘	

		}
	//	 new GameOver(frame.score);
			 //调用退出界面
	};
	
	
	/**
	 * @Title: init方法
	 * @Description: 初始化
	 * @return void 
	 * @throws 
	 */
	public void init(){
		
		Threadlife = true;//线程生命
		
		frame.addWindowListener(new CloseWindow());
		
		run();
		
//		if(Man.getLifeNumber()>0)//如果有生命就初始化
//			run();
//		else//初始化失败
//		{
//			
//		}
		
	}
	
	
	
	
	/**
	 * @Title: BombHitBulle方法
	 * @Description: 子弹与炸弹的碰撞方法
	 * @return void 
	 * @throws 
	 */
	public void BombHitBullet()
	{
		
		
		for(int i = 0;i<Bomblist.size();i++)
		{
			
			if(Bomblist.get(i).isLife())//有生命则进行比较
			{
				
				for(int j = 0;j<Bulletlist.size();j++)
				{
					
					if(Bulletlist.get(j).isLife())
					{
					
						if(Bomblist.get(i).BhitB(Bulletlist.get(j))==1)
						{
							Constant.BOMB_X=Bomblist.get(i).getX();
							Constant.BOMB_Y=Bomblist.get(i).getY();
							Bulletlist.remove(j);
							frame.score-=50;
							Constant.BOOMING_FLAG1=true;
							
						}
					}
					
					else
						Bulletlist.remove(j);//子弹数组移出对象
						
					
				}
				
			}
			else//没生命则移出对象
				Bomblist.remove(i);
			
			
		}
		
	}
	
	/**
	 * @Title: FruitHitBullet方法
	 * @Description: 水果与子弹的碰撞检测
	 * @return void 
	 * @throws 
	 */
	public void FruitHitBullet()
	{
		
		for(int i = 0;i<Fruitlist.size();i++)
		{
			
			if(Fruitlist.get(i).isLife())
			{
				
				for(int j = 0;j<Bulletlist.size();j++)
				{
					
					//System.out.println("asd");
					if(Bulletlist.get(j).isLife())
					{
						//System.out.println("asdjk");
					
						if(Fruitlist.get(i).FhitB(Bulletlist.get(j))==1)	
						{
							voice(Fruitlist.get(i).getStr());
							Constant.BOMB1_X=Fruitlist.get(i).getX();
							Constant.BOMB1_Y=Fruitlist.get(i).getY();
							Constant.FRUIT_FLAG=true;
			//				Constant.LETTER_RANDOM=(int)(Math.random()*26)*2;
							Bulletlist.remove(j);
							frame.score+=20;
							
							if(Constant.gameStatus==4)
							{
								
								AttackLetter += Fruitlist.get(i).getStr();//添加打中的字母
								
								char[] LetterRecord = GameMain.lists.get(Constant.WORD_RANDOM).toCharArray();//用char数组记录产生的随机单词
								
								char[] AttackLetterRecord=AttackLetter.toCharArray();//用char记录打中的字母
								
						//		frame.attackRight=AttackLetter;
//								frame.attackRight=AttackLetter;
//								for(char a :AttackLetterRecord)
//								{
//									System.out.print(a+"");
//								}
//								System.out.println("  ");
							//	System.out.println(frame.attackRight+"");
						//		frame.attackRight += AttackLetter;
								if(AttackLetterRecord[AttackLetterSubscript]=='a')
									System.out.println("达到了：a"+"\n");
								if(LetterRecord[RandomSubscript]==AttackLetterRecord[AttackLetterSubscript])//字母相等
								{

									if(AttackLetterRecord[AttackLetterSubscript]=='a')
										System.out.println("达到了a啊：a"+"\n");
									
									frame.attackRight +=LetterRecord[RandomSubscript];
									
									RandomSubscript +=1;//下标加1

									frame.score+=20;
									
								}
								
								AttackLetterSubscript = AttackLetterRecord.length;//更新下标
								
								if(RandomSubscript==LetterRecord.length)//全部打中
								{
									frame.score+=100;
								}
							}
					
							
						}
					}
					
					else
						Bulletlist.remove(j);//子弹数组移出对象
						
					
				}
				
				
			}
			else
				Fruitlist.remove(i);
			
		}
		
		
	}
	
	/**
	 * @Title: BombHitMan方法
	 * @Description: 判断炸弹与人的相撞
	 * @return void 
	 * @throws 
	 */
	public void BombHitMan()
	{
		
		for(int i = 0;i<Bomblist.size();i++)
		{
			
			if(Bomblist.get(i).isLife())
			{
		
				if(Bomblist.get(i).BhitM(Man)==1)
				{
					System.out.println("is1");
					Man.setLifeNumber(Man.getLifeNumber()-1);
					Constant.BOOMING_FLAG=true;
					
					
				}
			}
			else
				Bomblist.remove(i);
			
		}
		
	}
	public void voice(String word){
		word=word.toUpperCase();
		frame.audioClip=Applet.newAudioClip(GameThread.class.getResource("/sounds/"+word+".wav"));
		frame.audioClip.play();
//		   ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
//		    Dispatch sapo = sap.getObject();
//		    try {
//		        // 音量 0-100
//		        sap.setProperty("Volume", new Variant(100));
//		        // 语音朗读速度 -10 到 +10
//		        sap.setProperty("Rate", new Variant(0));
//		        // 执行朗读
//		        //Dispatch.call(sapo, "Speak", new Variant("Q"));
//		       Dispatch.call(sapo, "Speak", new Variant(word));
//
//		    } catch (Exception e) {
//		        e.printStackTrace();
//		    } finally {
//		        sapo.safeRelease();
//		        sap.safeRelease();
//		    }
	}
	/**
	 * @Title: judgeHit方法
	 * @Description: 判断碰撞方法，以及对对象的生命进行操作
	 * @return void 
	 * @throws 
	 */
	public void  judgeHit()
	{
			
		/*
		 * 方法:judgeHit()
		 * 规则：
		 * 1.子弹能够碰撞水果
		 * 2.子弹能够碰撞炸弹
		 * 3.炸弹能够碰撞人
		 * */
		
		/*
		 * 判断炸弹与子弹是否碰撞
		 * 碰撞则进行积分，并消除对象
		 * */
		
			BombHitBullet();
		/*
		 * 判断水果与子弹是否碰撞
		 * 碰撞则进行积分，并消除对象
		 * */
			FruitHitBullet();
		
		/*
		 * 判断炸弹与人是否碰撞
		 * 碰撞则进行积分，并消除对象
		 * */
			BombHitMan();
		
	}


}
