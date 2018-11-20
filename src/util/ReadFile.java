package com.macrosoft.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ReadFile {
	
    public void readFileByLines(String fileName)  { 
    	
        File file = new File(fileName);  
        BufferedReader reader = null;   
        try {  
            reader = new BufferedReader(new FileReader(file)); 
            List<String> lists = new ArrayList<String>();  //存储过滤后单词的列表    
            String tempString = null; //用于临时存放读到的数据
            //每次读一行，直至文件结束
            while ((tempString = reader.readLine()) != null) {  
                System.out.println(tempString);       
                lists.add(tempString);             
            }  
            reader.close();  
            //map结构存储单词 key为英文value为汉语
            Map<String, String> map = new HashMap<String, String>();  
            int times=1;
            String tempstr1="";
            String tempstr2="";
           for (int i=0;i<lists.size();i++) {
        	   //System.out.println(lists.get(i));
        	   if(times%2==0){
        		   tempstr2=lists.get(i);
        		   map.put(tempstr1, tempstr2); 
        	   }
        	   else{
        		   tempstr1=lists.get(i);
        	 } 
        	   times++;
            } 
           
          // System.out.println("1");
           for (String key : map.keySet()) {
        	   //遍历map
        	   //System.out.println("key= "+ key + " and value= " + map.get(key));
        	  }
        
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
	

}
