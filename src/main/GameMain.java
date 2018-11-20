package com.macrosoft.main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.macrosoft.object.Background;
import com.macrosoft.object.Bomb;
import com.macrosoft.object.Bombing;
import com.macrosoft.object.Bullet;
import com.macrosoft.object.Fruit;
import com.macrosoft.object.People;
import com.macrosoft.util.CalculationAngle;
import com.macrosoft.util.CloseWindow;
import com.macrosoft.util.Constant;
import com.macrosoft.util.MouseChange;
import com.macrosoft.util.MyKeyControl;



public class GameMain extends Frame {
	
	private Background background = new Background(0, 0, Constant.M_WIDTH, Constant.M_HEIGHT, Constant.M_IMAGE, this);
	private Background B_help = new Background(Constant.HELP_X, Constant.HELP_Y, Constant.B_WIDTH, Constant.B_HEIGHT,Constant.HELP_IMAGE, this);
	private Background B_start = new Background(Constant.START_X,Constant.START_Y,Constant.B_WIDTH,Constant.B_HEIGHT,Constant.START_IAMGE,this);
	private Background B_quit = new Background(Constant.QUIT_X,Constant.QUIT_Y,Constant.B_WIDTH,Constant.B_HEIGHT,Constant.QUIT_IMAGE,this);
	private Background B_back = new Background(Constant.BACK_X, Constant.BACK_Y, Constant.BACK_WIDTH, Constant.BACK_HEIGHT, Constant.BACK_IMAGE, this);
	private Background B_letter = new Background(Constant.LETTER_X, Constant.LETTER_Y, Constant.C_WIDTH, Constant.C_HEIGHT, Constant.LETTER_IMAGE, this);
	private Background B_word = new Background(Constant.WORD_X, Constant.WORD_Y, Constant.C_WIDTH, Constant.C_HEIGHT, Constant.WORD_IMAGE, this);
	private Background B_phrase = new Background(Constant.PHRASE_X, Constant.PHRASE_Y, Constant.C_WIDTH, Constant.C_HEIGHT, Constant.PHRASE_IMAGE, this);
	private Background B_backtomain = new Background(Constant.HELP_X, Constant.HELP_Y, Constant.B_WIDTH, Constant.B_HEIGHT, Constant.BACKTOMAIN_IMAGE, this);
	private Background B_score = new Background(Constant.START_X, Constant.START_Y, Constant.B_WIDTH, Constant.B_HEIGHT, Constant.SCORE_IMAGE, this);
	private Background B_restart = new Background(Constant.QUIT_X, Constant.QUIT_Y, Constant.B_WIDTH, Constant.B_HEIGHT, Constant.RESTART_IMAGE, this);
	private MouseChange mouseChange = new MouseChange(this);
	private int mouseX = 0;
	private int mouseY = 0;
	public String attackRight = "";
	private int amount = 1;
	public int formergameStatus;
	private People people=new People((Constant.M_WIDTH/2),Constant.M_HEIGHT-Constant.PEOPLE_HEIGHT, Constant.PEOPLE_WIDTH, Constant.PEOPLE_HEIGHT,Constant.BIRD_IMAGE, this,5);
	private GameThread thread;
	private Image myBackground;
	public AudioClip audioClip2 = Applet.newAudioClip(GameMain.class.getResource("/sounds/boom.wav"));
	AudioClip ding = Applet.newAudioClip(GameMain.class.getResource("/sounds/launch.wav"));
	AudioClip choose = Applet.newAudioClip(GameMain.class.getResource("/sounds/BGM2.wav"));
	AudioClip game = Applet.newAudioClip(GameMain.class.getResource("/sounds/BGM3.wav"));
	public int score;
	private Bombing bombing=new Bombing();
	private ArrayList<Bomb> bomblist = new ArrayList<Bomb>();
	private ArrayList<Bullet> bulletlist = new ArrayList<Bullet>();
	private ArrayList<Fruit> fruitlist = new ArrayList<Fruit>();
	private List<String> Letterlists = new ArrayList<String>(); 
	public static List<String> lists = new ArrayList<String>();
	public static AudioClip  audioClip;
	MediaTracker mt;
	//产生子弹标志
	private boolean BulletFlag=false;
	
	private int RuleWordNum=0;//生成0-25的随机数，对应26个英文字母
	
	CalculationAngle calculationAngle=new CalculationAngle();
	/**
	 * 
	 * @Title: GameMain构造函数
	 * @Description:TODO:
	 */
	public GameMain() {
		// TODO Auto-generated constructor stub
		Constant.init();
		readFile("src/Word/word.txt");
		this.setTitle(Constant.TITLT);
		this.setSize(Constant.M_WIDTH, Constant.M_HEIGHT);
		this.setLocationRelativeTo(null);
		this.addWindowListener(new CloseWindow());
		this.setVisible(true);
		this.setResizable(false);
		this.setIconImage(Constant.ICON_IMAGE);
		mouseChange.change(Constant.DEFAULT_MOUSE);
		audioClip=Applet.newAudioClip(GameMain.class.getResource("/sounds/BGM3.wav"));
		audioClip.loop();
		mt=new MediaTracker(this);
		int i;
		for(i=0;i<Constant.BOMBING_IMAGE.length;i++)
		{
			mt.addImage(Constant.BOMBING_IMAGE[i], 0);
		}
		for(i=0;i<Constant.FURIT_IMAGE.length;i++)
		{
			mt.addImage(Constant.FURIT_IMAGE[i], 1);
		}
		
		try {
			mt.waitForID(0);
			mt.waitForID(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.addKeyListener(new MyKeyControl(people));
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				switch(Constant.gameStatus)
				{
				case 0:
					
						if(mouseX>=Constant.HELP_X&&mouseX<=Constant.HELP_X+Constant.B_WIDTH&&mouseY>=Constant.HELP_Y&&mouseY<=Constant.HELP_Y+Constant.B_HEIGHT){
							background.setImage(Constant.HELP_BACKGROUND_IMAGE);
							Constant.gameStatus = 1;
						}
						
						if(mouseX>=Constant.START_X&&mouseX<=Constant.START_X+Constant.B_WIDTH&&mouseY>=Constant.START_Y&&mouseY<=Constant.START_Y+Constant.B_HEIGHT){
							background.setImage(Constant.CHOOSE_IMAGE);
							Constant.gameStatus = 2;
						
						}
						if(mouseX>=Constant.QUIT_X&&mouseX<=Constant.QUIT_X+Constant.B_WIDTH&&mouseY>=Constant.QUIT_Y&&mouseY<=Constant.QUIT_Y+Constant.B_HEIGHT){
							System.exit(0);
						}
					break;
				case 1:
					if(mouseX>=Constant.BACK_X&&mouseX<=Constant.BACK_X+Constant.BACK_WIDTH&&mouseY>=Constant.BACK_Y&&mouseY<=Constant.BACK_Y+Constant.BACK_HEIGHT){
						background.setImage(Constant.M_IMAGE);
						Constant.gameStatus = 0;
					}
					break;
				case 2:
					
						if(mouseX>=Constant.LETTER_X&&mouseX<=Constant.LETTER_X+Constant.C_WIDTH&&mouseY>=Constant.LETTER_Y&&mouseY<=Constant.LETTER_Y+Constant.C_HEIGHT){
							background.setImage(Constant.TREES_IMAGE);
							Constant.gameStatus = 3;
						
						}
						if(mouseX>=Constant.WORD_X&&mouseX<=Constant.WORD_X+Constant.C_WIDTH&&mouseY>=Constant.WORD_Y&&mouseY<=Constant.WORD_Y+Constant.C_HEIGHT){
							background.setImage(Constant.TREES_IMAGE);
							Constant.gameStatus = 4;
					
						}
						if(mouseX>=Constant.PHRASE_X&&mouseX<=Constant.PHRASE_X+Constant.C_WIDTH&&mouseY>=Constant.PHRASE_Y&&mouseY<=Constant.PHRASE_Y+Constant.C_HEIGHT){
							Constant.gameStatus = 5;
							
						}
						if(mouseX>=Constant.BACK_X&&mouseX<=Constant.BACK_X+Constant.BACK_WIDTH&&mouseY>=Constant.BACK_Y&&mouseY<=Constant.BACK_Y+Constant.BACK_HEIGHT){
							background.setImage(Constant.M_IMAGE);
							Constant.gameStatus = 0;
						
						}

					break;
				case 3:
					if(e.getY()<people.gun.getY()+Constant.GUN_HEIGHT/2){
						BulletFlag=true;
					}	
					break;
				case 4:
					if(e.getY()<people.gun.getY()+Constant.GUN_HEIGHT/2){
						BulletFlag=true;
					}	
					break;
				case 5:
					if(mouseX>=Constant.BACK_X&&mouseX<=Constant.BACK_X+Constant.BACK_WIDTH&&mouseY>=Constant.BACK_Y&&mouseY<=Constant.BACK_Y+Constant.BACK_HEIGHT){
						background.setImage(Constant.CHOOSE_IMAGE);
						Constant.gameStatus = 2;
					}
					break;
				case 6:
						if(mouseX>=Constant.HELP_X&&mouseX<=Constant.HELP_X+Constant.B_WIDTH&&mouseY>=Constant.HELP_Y&&mouseY<=Constant.HELP_Y+Constant.B_HEIGHT){
							Constant.gameStatus = 0;
							background.setImage(Constant.M_IMAGE);
							score = 0;
							people.setLifeNumber(5);
							Constant.FLAG = true;
						}
						if(mouseX>=Constant.QUIT_X&&mouseX<=Constant.QUIT_X+Constant.B_WIDTH&&mouseY>=Constant.QUIT_Y&&mouseY<=Constant.QUIT_Y+Constant.B_HEIGHT){
							Constant.gameStatus = formergameStatus;
							background.setImage(Constant.TREES_IMAGE);
							score = 0;
							people.setLifeNumber(5);
							Constant.FLAG = true;
						}
					break;
					default:
						break;
				}

//				if(Constant.gameStatus == 1||Constant.gameStatus == 2){//返回判断
//					if(mouseX>=Constant.BACK_X&&mouseX<=Constant.BACK_X+Constant.BACK_WIDTH&&mouseY>=Constant.BACK_Y&&mouseY<=Constant.BACK_Y+Constant.BACK_HEIGHT){
//						background.setImage(Constant.M_IMAGE);
//						Constant.gameStatus = 0;
//					}
//				}
				
//				if(Constant.gameStatus == 3||Constant.gameStatus == 4){
//					if(e.getY()<people.gun.getY()+Constant.GUN_HEIGHT/2){
//						BulletFlag=true;
//					}	
//				}
				
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
//				if(Constant.gameStatus == 0){
//					if(mouseX>=Constant.HELP_X&&mouseX<=Constant.HELP_X+Constant.B_WIDTH&&mouseY>=Constant.HELP_Y&&mouseY<=Constant.HELP_Y+Constant.B_HEIGHT){
//						background.setImage(Constant.HELP_BACKGROUND_IMAGE);
//						Constant.gameStatus = 1;
//					}
//					
//					if(mouseX>=Constant.START_X&&mouseX<=Constant.START_X+Constant.B_WIDTH&&mouseY>=Constant.START_Y&&mouseY<=Constant.START_Y+Constant.B_HEIGHT){
//						background.setImage(Constant.CHOOSE_IMAGE);
//						Constant.gameStatus = 2;
//					}
//					if(mouseX>=Constant.QUIT_X&&mouseX<=Constant.QUIT_X+Constant.B_WIDTH&&mouseY>=Constant.QUIT_Y&&mouseY<=Constant.QUIT_Y+Constant.B_HEIGHT){
//						System.exit(0);
//					}
//				}
//				if(Constant.gameStatus == 1||Constant.gameStatus == 2){
//					if(mouseX>=Constant.BACK_X&&mouseX<=Constant.BACK_X+Constant.BACK_WIDTH&&mouseY>=Constant.BACK_Y&&mouseY<=Constant.BACK_Y+Constant.BACK_HEIGHT){
//						background.setImage(Constant.M_IMAGE);
//						Constant.gameStatus = 0;
//					}
//				}
//				if(Constant.gameStatus == 2){
//					if(mouseX>=Constant.LETTER_X&&mouseX<=Constant.LETTER_X+Constant.C_WIDTH&&mouseY>=Constant.LETTER_Y&&mouseY<=Constant.LETTER_Y+Constant.C_HEIGHT){
//						background.setImage(Constant.TREES_IMAGE);
//						Constant.gameStatus = 3;
//					}
//				}
//				if(Constant.gameStatus == 3){
//					if(e.getY()<people.gun.getY()+Constant.GUN_HEIGHT/2){
//						BulletFlag=true;
//					}	
//				}
//				if(mouseX>=Constant.HELP_X&&mouseX<=Constant.HELP_X+Constant.B_WIDTH&&mouseY>=Constant.HELP_Y&&mouseY<=Constant.HELP_Y+Constant.B_HEIGHT){
//					Constant.gameStatus = 0;
//					background.setImage(Constant.M_IMAGE);
//				}
//				if(mouseX>=Constant.QUIT_X&&mouseX<=Constant.QUIT_X+Constant.B_WIDTH&&mouseY>=Constant.QUIT_Y&&mouseY<=Constant.QUIT_Y+Constant.B_HEIGHT){
//					Constant.gameStatus = formergameStatus;
//					background.setImage(Constant.TREES_IMAGE);
//					score = 0;
//					people.setLifeNumber(5);
//					
//				}
			}
		});
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				mouseX = e.getX();
				mouseY = e.getY();
				if(Constant.gameStatus == 3||Constant.gameStatus == 4||Constant.gameStatus == 5){
					mouseChange.change(Constant.GLASS_MOUSE);
				}else{
					mouseChange.change(Constant.DEFAULT_MOUSE);
				}
				
				if(Constant.gameStatus == 0){
					if(mouseX>=Constant.HELP_X&&mouseX<=Constant.HELP_X+Constant.B_WIDTH&&mouseY>=Constant.HELP_Y&&mouseY<=Constant.HELP_Y+Constant.B_HEIGHT){
						mouseChange.change(Constant.STAR_MOUSE);
						B_help.setImage(Constant.HELP_SHUT);
					}else if(!(mouseX>=Constant.HELP_X&&mouseX<=Constant.HELP_X+Constant.B_WIDTH&&mouseY>=Constant.HELP_Y&&mouseY<=Constant.HELP_Y+Constant.B_HEIGHT)){
						B_help.setImage(Constant.HELP_IMAGE);	
					}
					if(mouseX>=Constant.START_X&&mouseX<=Constant.START_X+Constant.B_WIDTH&&mouseY>=Constant.START_Y&&mouseY<=Constant.START_Y+Constant.B_HEIGHT){
						B_start.setImage(Constant.STAR_OPEN);
						mouseChange.change(Constant.STAR_MOUSE);
					}else if(!(mouseX>=Constant.START_X&&mouseX<=Constant.START_X+Constant.B_WIDTH&&mouseY>=Constant.START_Y&&mouseY<=Constant.START_Y+Constant.B_HEIGHT)){
						B_start.setImage(Constant.START_IAMGE);
					}
					if(mouseX>=Constant.QUIT_X&&mouseX<=Constant.QUIT_X+Constant.B_WIDTH&&mouseY>=Constant.QUIT_Y&&mouseY<=Constant.QUIT_Y+Constant.B_HEIGHT){
						B_quit.setImage(Constant.QUIT_SHUT);
						mouseChange.change(Constant.STAR_MOUSE);
					}else if(!(mouseX>=Constant.QUIT_X&&mouseX<=Constant.QUIT_X+Constant.B_WIDTH&&mouseY>=Constant.QUIT_Y&&mouseY<=Constant.QUIT_Y+Constant.B_HEIGHT)){
						B_quit.setImage(Constant.QUIT_IMAGE);
					}
				}
				if(Constant.gameStatus == 1||Constant.gameStatus == 2||Constant.gameStatus == 5){
					if(mouseX>=Constant.BACK_X&&mouseX<=Constant.BACK_X+Constant.BACK_WIDTH&&mouseY>=Constant.BACK_Y&&mouseY<=Constant.BACK_Y+Constant.BACK_HEIGHT){
						B_back.setImage(Constant.BACK_MOVE);
						mouseChange.change(Constant.STAR_MOUSE);
					}else if(!(mouseX>=Constant.BACK_X&&mouseX<=Constant.BACK_X+Constant.BACK_WIDTH&&mouseY>=Constant.BACK_Y&&mouseY<=Constant.BACK_Y+Constant.BACK_HEIGHT)){
						B_back.setImage(Constant.BACK_IMAGE);
					}
				}
				if(Constant.gameStatus == 2){
					if(mouseX>=Constant.WORD_X&&mouseX<=Constant.WORD_X+Constant.C_WIDTH&&mouseY>=Constant.WORD_Y&&mouseY<=Constant.WORD_Y+Constant.C_HEIGHT){
						mouseChange.change(Constant.STAR_MOUSE);
					}
					if(mouseX>=Constant.LETTER_X&&mouseX<=Constant.LETTER_X+Constant.C_WIDTH&&mouseY>=Constant.LETTER_Y&&mouseY<=Constant.LETTER_Y+Constant.C_HEIGHT){
						mouseChange.change(Constant.STAR_MOUSE);
					}
					if(mouseX>=Constant.PHRASE_X&&mouseX<=Constant.PHRASE_X+Constant.C_WIDTH&&mouseY>=Constant.PHRASE_Y&&mouseY<=Constant.PHRASE_Y+Constant.C_HEIGHT){
						mouseChange.change(Constant.STAR_MOUSE);
					}
				}
				
				if(Constant.gameStatus == 6){
					if(mouseX>=Constant.HELP_X&&mouseX<=Constant.HELP_X+Constant.B_WIDTH&&mouseY>=Constant.HELP_Y&&mouseY<=Constant.HELP_Y+Constant.B_HEIGHT){
						mouseChange.change(Constant.STAR_MOUSE);
						B_backtomain.setImage(Constant.BACKTOMAIN_IAMGE_CHANGE);
					}else if(!(mouseX>=Constant.HELP_X&&mouseX<=Constant.HELP_X+Constant.B_WIDTH&&mouseY>=Constant.HELP_Y&&mouseY<=Constant.HELP_Y+Constant.B_HEIGHT)){
						B_backtomain.setImage(Constant.BACKTOMAIN_IMAGE);	
					}
					if(mouseX>=Constant.QUIT_X&&mouseX<=Constant.QUIT_X+Constant.B_WIDTH&&mouseY>=Constant.QUIT_Y&&mouseY<=Constant.QUIT_Y+Constant.B_HEIGHT){
						B_restart.setImage(Constant.RESTART_IMAGE_CHANGE);
						mouseChange.change(Constant.STAR_MOUSE);
					}else if(!(mouseX>=Constant.QUIT_X&&mouseX<=Constant.QUIT_X+Constant.B_WIDTH&&mouseY>=Constant.QUIT_Y&&mouseY<=Constant.QUIT_Y+Constant.B_HEIGHT)){
						B_restart.setImage(Constant.RESTART_IMAGE);
					}
				}
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		thread = new GameThread(this, bomblist, bulletlist, fruitlist, people);
		thread.init();
	}
	@Override
	public void paint(Graphics g) {
		if(Constant.gameStatus == 6){
			background.setImage(Constant.OVER_IMAGE);
		}
		background.drawMe(g);
		switch (Constant.gameStatus) {
		case 0:
			B_help.drawMe(g);
			B_start.drawMe(g);
			B_quit.drawMe(g);
			break;
		case 1:
			B_back.drawMe(g);
			break;
		case 2:
			B_back.drawMe(g);
			B_letter.drawMe(g);
			B_word.drawMe(g);
			B_phrase.drawMe(g);
		
			break;
		case 3:
			people.drawMe(g);
			if (Constant.BOOMING_FLAG==true) {
//				audioClip=Applet.newAudioClip(GameMain.class.getResource("/sounds/boom.wav"));
//				audioClip.play();
				g.drawImage(Constant.BOMBING_IMAGE[Constant.NUM], people.getX(), people.getY()-50, this);
			
			}
			if (Constant.BOOMING_FLAG1==true) {
				
				g.drawImage(Constant.BOMBING_IMAGE[Constant.NUM],Constant.BOMB_X, Constant.BOMB_Y, this);
			
			}
			if (Constant.FRUIT_FLAG==true) {
				
				g.drawImage(Constant.FURIT_IMAGE[Constant.NUM1],Constant.BOMB1_X-30, Constant.BOMB1_Y-30, this);
			}
			//bomb
			g.setColor(Color.RED);
			g.setFont(new Font("Calibri", Font.BOLD, 50));
			
			g.setFont(new Font("Hannotate SC", Font.BOLD, 30));
			for(int i = 0;i<people.getLifeNumber();i++){
				people.drawMe(g,565+i*40,65,25,40);
			}
			g.drawString(String.valueOf(score), 560, 155);
			for(int i = 0;i<bomblist.size();i++){
		//		bomblist.get(i).runtrack.setSpeed(bomblist.get(i).runtrack.getSpeed()+1);
				bomblist.get(i).drawMe(g);
			}
			for(int i = 0;i<fruitlist.size();i++){
				fruitlist.get(i).drawMe(g);
			}
			for(int i = 0;i<bulletlist.size();i++){
				
				bulletlist.get(i).drawMe(g);
				
			}
			people.gun.drawMe(g);
			break;
		case 4:
			
			people.drawMe(g);
			g.setColor(Color.white);
			g.setFont(new Font("Hannotate SC", Font.BOLD, 40));
			if(Constant.WORD_RANDOM==0)
				Constant.WORD_RANDOM=2;
			g.drawImage(Constant.BOARD_IMAGE, 60, 200, this);
			g.drawString(lists.get(Constant.WORD_RANDOM), 80, 300);
			g.drawString(lists.get(Constant.WORD_RANDOM+1), 80, 350);
			g.setColor(Color.red);
			g.setFont(new Font("Hannotate SC", Font.BOLD, 40));
			g.drawString(attackRight, 80, 300);
			if (Constant.BOOMING_FLAG==true) {
//				audioClip=Applet.newAudioClip(GameMain.class.getResource("/sounds/boom.wav"));
//				audioClip.play();
				g.drawImage(Constant.BOMBING_IMAGE[Constant.NUM], people.getX(), people.getY()-50, this);
			
			}
			if (Constant.BOOMING_FLAG1==true) {
//				audioClip=Applet.newAudioClip(GameMain.class.getResource("/sounds/boom.wav"));
//				audioClip.play();
				g.drawImage(Constant.BOMBING_IMAGE[Constant.NUM],Constant.BOMB_X, Constant.BOMB_Y, this);
			
			}
			if (Constant.FRUIT_FLAG==true) {
//				audioClip=Applet.newAudioClip(GameMain.class.getResource("/sounds/boom.wav"));
//				GameMain.audioClip.play();
				g.drawImage(Constant.FURIT_IMAGE[Constant.NUM1],Constant.BOMB1_X-30, Constant.BOMB1_Y-30, this);
			}
			//bomb
			
//			g.setFont(new Font("Hannotate SC", Font.BOLD, 30));
			for(int i = 0;i<people.getLifeNumber();i++){
				people.drawMe(g,565+i*40,55,25,40);
			}
			
			g.drawString(String.valueOf(score), 560, 145);
			for(int i = 0;i<bomblist.size();i++){
				
				bomblist.get(i).drawMe(g);
			}
			for(int i = 0;i<fruitlist.size();i++){
				fruitlist.get(i).drawMe(g);
			}
			for(int i = 0;i<bulletlist.size();i++){
				
				bulletlist.get(i).drawMe(g);
				
			}
			people.gun.drawMe(g);
			break;
		case 5:
			B_back.drawMe(g);
			if(thread.getTimer()<5){
				background.setImage(Constant.CONTINUE_IMAGE);
			}else{
				background.setImage(Constant.CONTINUE_IMAGE1);
			}
			break;
		case 6:
			B_backtomain.drawMe(g);
			B_score.drawMe(g);
			B_restart.drawMe(g);
			g.setColor(Color.RED);
			g.setFont(new Font("Hannotate SC", Font.BOLD, 80));
			g.drawString(String.valueOf(score), Constant.START_X+85, Constant.START_Y+150);
			break;
		default:
			break;
		}
	}
	public void readFile(String fileName) {
		  File file = new File(fileName);  
	        BufferedReader reader = null;   
	        try {  
	            reader = new BufferedReader(new FileReader(file)); 
	           // List<String> lists = new ArrayList<String>();  //存储过滤后单词的列表    
	            String tempString = ""; //用于临时存放读到的数据
	            //每次读一行，直至文件结束
	            while ((tempString = reader.readLine()) != null) {  
	                //System.out.println(tempString);       
	                lists.add(tempString);             
	            }  
	            reader.close();  
	
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } finally {  
	            if (reader != null) {  
	                try {  
	                    reader.close();  
	                } catch (IOException e1) {  
	                }  
	            }  
	        }
	}
	/**
	 * 
	 * @Title: setAnlge方法
	 * @Description: TODO: TODO
	 * @return void 
	 * @throws
	 */
	public void setAnlge(){
		
		if(mouseY<people.gun.getY()+Constant.GUN_HEIGHT/2){
			double angle=calculationAngle.calculationAngle(people.gun.getX()+Constant.GUN_WIDTH/2, people.gun.getY()+Constant.GUN_HEIGHT/2, mouseX, mouseY);
			if(angle>0&&angle<3.14/2){
				people.setTuenFlag(1);
				
			}
			else if(angle>3.14/2&&angle<3.14){
				people.setTuenFlag(2);
			}
			people.gun.setgunAngle(angle);
			//people.gun.setgunAngle(calculationAngle.calculationAngle(people.gun.getX(), people.gun.getY(), e.getX(), e.getY()));
		}
		
	}

	@Override
	public void update(Graphics g) {
		if(myBackground == null){//如果背景为空，则创建
			myBackground = createImage(Constant.M_WIDTH,Constant.M_HEIGHT);
		}
		//所以要得到该图片上的画笔
		Graphics graphics = myBackground.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, Constant.M_WIDTH, Constant.M_HEIGHT);
		//把图形画在屏幕背后的图片上
		paint(graphics);
		g.drawImage(myBackground, 0, 0, this);
		
	}
	
	/**
	 * @Title: addWroldList方法
	 * @Description: 定时器定时产生新的随机单词的数字
	 * @return void 
	 * @throws 
	 */
	public void addWordList(){
		
		Constant.WORD_RANDOM=(int)(Math.random()*15)*2;
		
	}
	
	/**
	 * 
	 * @Title: addBomb方法
	 * @Description: TODO: TODO
	 * @return void 
	 * @throws
	 */
	public void addBomb(){
		int bombX = 0;
		int bombY = 0;
		if(thread.getTimeCount()%(50-amount)==0){
			Random random = new Random();
			bombX = random.nextInt(736);
			Bomb bomb = new Bomb(bombX, bombY, 66, 78, Constant.BOMB_IMAGE, this);
			bomb.runtrack.Run_Track_init(bombX, bombY, 1);
			bomblist.add(bomb);
			if(thread.getTimeCount()%97==0){
				amount++;
			}
			if(amount >= 50){
				amount = 40;
			}
		}
		
	}
	/**
	 * 
	 * @Title: addFruit方法
	 * @Description: TODO: TODO
	 * @return void 
	 * @throws
	 */
	public void addFruit(){
		int FruitX = 0;
		int FruitY = 0;
	//	System.out.println("执行了");
		
		if(thread.getTimeCount()%40==0){
		
			Random random = new Random();
			FruitX = random.nextInt(736);
			int kind = random.nextInt(8);
			int slot = random.nextInt(4)+1;
			if(slot == 4){
				FruitY = 100;
			}
			Fruit fruit = new Fruit(FruitX, FruitY, 60, 65, Constant.IMAGE_ARRAY[kind],this);
			fruit.getRuntrack().Run_Track_init(FruitX, FruitY, slot);
			fruitlist.add(fruit);
		//	System.out.println("执行了if");
		}
		
	}
	
	public void addFruit1(int num){
		int FruitX = 0;
		int FruitY = 0;
			
		if(thread.getTimeCount()%20==0){
			
			RuleWordNum++;
			if(RuleWordNum==26)
				RuleWordNum=0;		
			Random random = new Random();
			FruitX = random.nextInt(736);
			int kind = random.nextInt(8);
			int slot = random.nextInt(4)+1;
			if(slot == 4){
				FruitY = 100;
			}

			Fruit fruit = new Fruit(FruitX, FruitY, 60, 65, Constant.IMAGE_ARRAY[kind],this,RuleWordNum);

			fruit.getRuntrack().Run_Track_init(FruitX, FruitY, slot);


			fruitlist.add(fruit);
		//	System.out.println("执行了if");
		}
		
	}
	/**
	 * 
	 * @Title: addBullet方法
	 * @Description: TODO: TODO
	 * @return void 
	 * @throws
	 */
	public void addBullet(){
		//int BulletX = 0;
		//int BulletY = 0;
		if(BulletFlag){
			if(bulletlist.size()<1){
				//子弹添加条件需要改变
					//Random random = new Random();
					//BulletX = random.nextInt(736);//坐标需要改变
						
						ding.play();
						double angle=Math.toDegrees(people.gun.getgunAngle());
						if(angle>=0&&angle<=180){
						double leng=Math.sqrt(Constant.GUN_WIDTH/2);
						//int x=(int)(people.gun.getX()+(Constant.GUN_WIDTH)*Math.cos(people.gun.getgunAngle()));
						//int y=(int)(people.gun.getY()+(Constant.GUN_WIDTH)*Math.sin(people.gun.getgunAngle()));
						int x=(int)(people.gun.getX());
						int y=(int)(people.gun.getY());
						Bullet bullet = new Bullet(x,y, 10, 10, Constant.BULLET_IMAGE, this);
						bullet.setBulletAngle(people.gun.getgunAngle());
						//BulletFlag=false;
						bulletlist.add(bullet);
					}
					BulletFlag=false;
				}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameMain();
	}

}
