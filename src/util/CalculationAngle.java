package com.macrosoft.util;


public class CalculationAngle {
	/**
	 * @Title: calculationAngle方法
	 * @Description: 计算人物与鼠标角度
	 * @param x
	 * @param y
	 * @param mousex
	 * @param mousey
	 * @return: TODO
	 * @return double 
	 * @throws 
	 */
	public  double calculationAngle(int x,int y,int mousex,int mousey){		
		int xend=x+10;
		int yend=y;
		//长
		//double a=Math.abs(mousex-x);
		double a=10;
		//if(a==0){
		//	return Math.toRadians(90);
		//}
		//System.out.println(a);
		//高
		double b=Math.sqrt((xend-mousex)*(xend-mousex)+(yend-mousey)*(yend-mousey));
		//System.out.println(b);
		//斜边
		double c=Math.sqrt((x-mousex)*(x-mousex)+(y-mousey)*(y-mousey));
		//System.out.println(c);
		
		//余弦公式计算角度
		double B = Math.acos((a*a + c*c - b*b)/(2.0*a*c));   
		//转为角度
		//double A = Math.toDegrees(B);
		//System.out.println(A);
		return B;
	}
}
