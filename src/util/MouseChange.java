package com.macrosoft.util;

import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * @ClassName： MouseChange
 * @Description: 更换鼠标背景
 * @author: lpc
 * @Email： 546750658@qq.com
 * @Date：  2017年6月20日 下午4:45:05
 */
public class MouseChange {
	
	
	Frame frame;
	
	 
	// private Toolkit kit1 = Toolkit.getDefaultToolkit();//工具类
//     private  Image img;//=kit1.getImage("src/images/mouse.png");//图片路径
   
	//private Cursor cu=Constant.TOOLKIT.createCustomCursor(img,new Point(20,5),"stick");//定义鼠标手势
     
	
		
		
		
     
     /**
     * @Title: MouseChange构造函数
     * @Description:无参构造
     * @param frame:
     */
    public MouseChange(Frame frame) {
 		super();
 		this.frame = frame;
 	}
     
     /**
     * @Title: MouseChange构造函数
     * @Description:有参构造
     * @param mouseImage
     * @param frame:
     */
//    public MouseChange(Image mouseImage,JFrame frame) {
//  		super();
//  		this.frame = frame;
//  		this.img=mouseImage;
//  		cu=kit1.createCustomCursor(img,new Point(20,5),"stick");//定义鼠标手势
//  	     
//  	}
     
    
     /**
     * @Title: change方法
     * @Description:更换方法
     * @return void 
     * @throws 
     */
    public void change(Image img){
    	
    	Cursor cu=Constant.TOOLKIT.createCustomCursor(img,new Point(20,5),"stick");//定义鼠标手势
    	 frame.setCursor(cu);//设置自己鼠标的图标
    	 
     }


}
