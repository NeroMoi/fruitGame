package com.macrosoft.util;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;



public class Constant {
	
	public static int gameStatus = 0;
	public static int WORD_RANDOM=(int)(Math.random()*16)*2;
	public static int LETTER_RANDOM=(int)(Math.random()*26)*2;
	public static int NUM=0;
	public static boolean BOOMING_FLAG=false;
	public static boolean BOOMING_FLAG1=false;
	public static boolean FRUIT_FLAG=false;
	public static int NUM1=0;
	public static int BOMB_X=0;
	public static int BOMB_Y=0;
	public static int BOMB1_X=0;
	public static int BOMB1_Y=0;
	public static final Toolkit TOOLKIT = Toolkit.getDefaultToolkit();
	public static final int M_ZERO = 0;
	public static final int M_WIDTH = 800;
	public static final int M_HEIGHT = 600;
	public static final int FRUIT_HEIGHT = 450;
	public static final String TITLT = "水果大作战";
	public static final int B_WIDTH = 252;
	public static final int B_HEIGHT = 253;
	public static final int C_WIDTH = 330;
	public static final int C_HEIGHT = 93;
	public static final int HELP_X = 15;
	public static final int HELP_Y = 325;
	public static final int START_X = 278;
	public static final int START_Y = 275;
	public static final int QUIT_X = 535;
	public static final int QUIT_Y = 325;
	public static final int LETTER_X = 220;
	public static final int LETTER_Y = 160;
	public static final int WORD_X = 220;
	public static final int WORD_Y = 270;
	public static final int PHRASE_X = 220;
	public static final int PHRASE_Y = 380;
	public static final int BACK_X = 50;
	public static final int BACK_Y = 465;
	public static final int BACK_WIDTH = 105;
	public static final int BACK_HEIGHT = 86;
	public static final int PEOPLE_WIDTH = 70;
	public static final int PEOPLE_HEIGHT = 80;
	public static final int GUN_WIDTH = 36;
	public static final int GUN_HEIGHT = 17;
	
	public static final double ZEROL = -0.00000001;
	public static final double ZEROR = 0.00000001;
	
	public static final Image M_IMAGE = TOOLKIT.getImage(Constant.class.getResource("/images/main.png"));

	public static final Image OVER_IMAGE = TOOLKIT.getImage(Constant.class.getResource("/images/Over.png"));
	public static final Image CHOOSE_IMAGE = TOOLKIT.getImage(Constant.class.getResource("/images/ChooseImage.png"));
	public static final Image HELP_BACKGROUND_IMAGE = TOOLKIT.getImage(Constant.class.getResource("/images/HelpBackground.png"));
	public static final Image DEFAULT_MOUSE = TOOLKIT.getImage(Constant.class.getResource("/images/default_mouse.png"));
	public static final Image STAR_MOUSE = TOOLKIT.getImage(Constant.class.getResource("/images/star_mouse.png"));
	public static final Image BOMB_IMAGE = TOOLKIT.getImage(Constant.class.getResource("/images/bomb.png"));
	public static final Image PEOPLE_IMAGE = TOOLKIT.getImage(Constant.class.getResource("/images/peopler.png"));
	public static final Image ICON_IMAGE = TOOLKIT.getImage(Constant.class.getResource("/images/icon.png"));
	public static final Image BOARD_IMAGE = TOOLKIT.getImage(Constant.class.getResource("/images/BlackBoard.png"));
	public static final Image CONTINUE_IMAGE = TOOLKIT.getImage(Constant.class.getResource("/images/continue1.png"));
	public static final Image CONTINUE_IMAGE1 = TOOLKIT.getImage(Constant.class.getResource("/images/continue2.png"));

	public static boolean FLAG = true;

	public static final Image[]  BOMBING_IMAGE = {
			TOOLKIT.getImage(Constant.class.getResource("/images/booming_1.png")),
			TOOLKIT.getImage(Constant.class.getResource("/images/booming_2.png")),
			TOOLKIT.getImage(Constant.class.getResource("/images/booming_3.png")),
			TOOLKIT.getImage(Constant.class.getResource("/images/booming_4.png")),
			TOOLKIT.getImage(Constant.class.getResource("/images/booming_5.png")),
			TOOLKIT.getImage(Constant.class.getResource("/images/booming_6.png")),
		
			
	};
	public static final Image[]  FURIT_IMAGE = {
			TOOLKIT.getImage(Constant.class.getResource("/images/fruit0.png")),
			TOOLKIT.getImage(Constant.class.getResource("/images/fruit1.png")),
			TOOLKIT.getImage(Constant.class.getResource("/images/fruit2.png")),
			TOOLKIT.getImage(Constant.class.getResource("/images/fruit3.png")),
			TOOLKIT.getImage(Constant.class.getResource("/images/fruit4.png")),
			TOOLKIT.getImage(Constant.class.getResource("/images/fruit5.png")),
			TOOLKIT.getImage(Constant.class.getResource("/images/fruit6.png")),
	};

	
	public static final Image GUN_IMAGE = TOOLKIT.getImage(Constant.class.getResource("/images/gun.png"));
	public static final Image BULLET_IMAGE = TOOLKIT.getImage(Constant.class.getResource("/images/bullet.png"));

	public static final Image TREES_IMAGE = TOOLKIT.getImage(Constant.class.getResource("/images/trees.png"));

	public static final Image LETTER_IMAGE = TOOLKIT.getImage(Constant.class.getResource("/images/Letter.png"));
	public static final Image WORD_IMAGE = TOOLKIT.getImage(Constant.class.getResource("/images/Word.png"));
	public static final Image PHRASE_IMAGE =TOOLKIT.getImage(Constant.class.getResource("/images/Phrase.png"));
	public static final Image HELP_IMAGE = TOOLKIT.getImage(Constant.class.getResource("/images/help.png"));
	public static final Image START_IAMGE = TOOLKIT.getImage(Constant.class.getResource("/images/start.png"));
	public static final Image QUIT_IMAGE = TOOLKIT.getImage(Constant.class.getResource("/images/quit.png"));
	public static final Image BACK_IMAGE = TOOLKIT.getImage(Constant.class.getResource("/images/Back.png"));
	public static final Image BACK_MOVE = TOOLKIT.getImage(Constant.class.getResource("/images/Back2.png"));
//	public static final Image BACK_IMAGE_CHANGE = TOOLKIT.getImage(Constant.class.getResource("/images/Back2.png"));
	public static final Image HELP_SHUT = TOOLKIT.getImage(Constant.class.getResource("/images/help_shut.png"));
	public static final Image QUIT_SHUT = TOOLKIT.getImage(Constant.class.getResource("/images/quit_shut.png"));
	public static final Image STAR_OPEN = TOOLKIT.getImage(Constant.class.getResource("/images/start_open.png"));
	public static final Image BACKTOMAIN_IMAGE = TOOLKIT.getImage(Constant.class.getResource("/images/BacktoMain.png"));
	public static final Image BACKTOMAIN_IAMGE_CHANGE = TOOLKIT.getImage(Constant.class.getResource("/images/BacktoMain2.png"));
	public static final Image SCORE_IMAGE = TOOLKIT.getImage(Constant.class.getResource("/images/Score.png"));
	public static final Image GLASS_MOUSE = TOOLKIT.getImage(Constant.class.getResource("/images/glass.png"));
	public static final Image RESTART_IMAGE = TOOLKIT.getImage(Constant.class.getResource("/images/restart.png"));
	public static final Image RESTART_IMAGE_CHANGE = TOOLKIT.getImage(Constant.class.getResource("/images/restart_change.png"));
	public static final Image[] IMAGE_ARRAY = new Image[8];
	public static void init(){
		IMAGE_ARRAY[0] = TOOLKIT.getImage(Constant.class.getResource("/images/blueberry.png"));
		IMAGE_ARRAY[1] = TOOLKIT.getImage(Constant.class.getResource("/images/cherry.png"));
		IMAGE_ARRAY[2] = TOOLKIT.getImage(Constant.class.getResource("/images/grape.png"));
		IMAGE_ARRAY[3] = TOOLKIT.getImage(Constant.class.getResource("/images/guava.png"));
		IMAGE_ARRAY[4] = TOOLKIT.getImage(Constant.class.getResource("/images/peach.png"));
		IMAGE_ARRAY[5] = TOOLKIT.getImage(Constant.class.getResource("/images/pear.png"));
		IMAGE_ARRAY[6] = TOOLKIT.getImage(Constant.class.getResource("/images/plum.png"));
		IMAGE_ARRAY[7] = TOOLKIT.getImage(Constant.class.getResource("/images/red_grape.png"));
	}
	
	
	
	public static final Image [] BIRD_IMAGE={
			TOOLKIT.getImage(Constant.class.getResource("/images/birdright.png")),
			TOOLKIT.getImage(Constant.class.getResource("/images/birdright1.png")),
			TOOLKIT.getImage(Constant.class.getResource("/images/birdright2.png")),
			TOOLKIT.getImage(Constant.class.getResource("/images/birdright3.png")),
			TOOLKIT.getImage(Constant.class.getResource("/images/birdright4.png")),
			TOOLKIT.getImage(Constant.class.getResource("/images/birdleft.png")),
			TOOLKIT.getImage(Constant.class.getResource("/images/birdleft1.png")),
			TOOLKIT.getImage(Constant.class.getResource("/images/birdleft2.png")),
			TOOLKIT.getImage(Constant.class.getResource("/images/birdleft3.png")),
			TOOLKIT.getImage(Constant.class.getResource("/images/birdleft4.png"))
		//BIRD_IMAGE[0]=	TOOLKIT.getImage(Constant.class.getResource("/images/birdleft5.png"));
	};
	/*
	
	public static final Image [] BIRD_IMAGE=new Image[10];
	public static void initBira(){
		BIRD_IMAGE[0]=	TOOLKIT.getImage(Constant.class.getResource("/images/birdright.png"));
		BIRD_IMAGE[1]=	TOOLKIT.getImage(Constant.class.getResource("/images/birdright1.png"));
		BIRD_IMAGE[2]=	TOOLKIT.getImage(Constant.class.getResource("/images/birdright2.png"));
		BIRD_IMAGE[3]=	TOOLKIT.getImage(Constant.class.getResource("/images/birdright3.png"));
		BIRD_IMAGE[4]=	TOOLKIT.getImage(Constant.class.getResource("/images/birdright4.png"));
		BIRD_IMAGE[5]=	TOOLKIT.getImage(Constant.class.getResource("/images/birdleft.png"));
		BIRD_IMAGE[6]=	TOOLKIT.getImage(Constant.class.getResource("/images/birdleft1.png"));
		BIRD_IMAGE[7]=	TOOLKIT.getImage(Constant.class.getResource("/images/birdleft2.png"));
		BIRD_IMAGE[8]=	TOOLKIT.getImage(Constant.class.getResource("/images/birdleft3.png"));
		BIRD_IMAGE[9]=	TOOLKIT.getImage(Constant.class.getResource("/images/birdleft4.png"));
		//BIRD_IMAGE[0]=	TOOLKIT.getImage(Constant.class.getResource("/images/birdleft5.png"));
	};
	*/

}
