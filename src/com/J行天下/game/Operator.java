package com.J行天下.game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Operator {
	public static BufferedWriter bw;
	public static String strs;
	
	public Operator(){
		try {
			bw = new BufferedWriter(new FileWriter(("info//infomation.txt"),true));
		} catch (IOException e) {
			System.out.println("false");
			e.printStackTrace();
		}	
	}

	public static void close(){
		if(bw != null){
			try {
				bw.close();
				bw = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean insert(String s){
		try {
			FileOutputStream f = new FileOutputStream("info//infomation.txt");
			f.write(s.getBytes());
			close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		close();
		return false;
	}
	
	public static boolean insert(User u){
		boolean flag = true;
		String str = u.getName() + ","  + u.getPwd() + "," + 0 + "\n";
		
		ArrayList<String> lines = new ArrayList<String>();		//存储读取后的String列表
    	ArrayList<String> strs = new ArrayList<String>();
    	ArrayList<String> name = new ArrayList<String>();
    	ArrayList<String> pwd = new ArrayList<String>();
    	ArrayList<Integer> score = new ArrayList<Integer>();
    	lines = readFileLines();
    	for (String string : lines) {
    		for (String s : string.split(",")) {
    			strs.add(s);
    		}
		}

    	for(int i=0;i<strs.size()/3;i++){
    		name.add(strs.get(i*3));
    		pwd.add(strs.get(i*3 + 1));
    		score.add(Integer.parseInt(strs.get(i*3 + 2)));
    	}
    	
		try {
			for (String  sname : name) {
				if(sname.equals(u.getName())){
					flag = false;
					break;
				}
			}
			if(flag){
				FileOutputStream f = new FileOutputStream("info//infomation.txt",true);
				f.write(str.getBytes());
				close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		close();
		return flag;
	}

    // 返回文件所有行
    public static ArrayList<String> readFileLines(){
    	ArrayList<String> lines = new ArrayList<String>();		//存储读取后的String列表
        FileInputStream inputStream = null;
        InputStreamReader streamReader = null;
        BufferedReader reader = null;
        try {
			inputStream = new FileInputStream("info//infomation.txt");
            streamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(streamReader);
            String line = "";
			while ((line = reader.readLine()) != null) {
			    lines.add(line);
			}
        } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} finally {
            if (reader != null) {
                try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            if (streamReader != null) {
                try {
					streamReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            if (inputStream != null) {
                try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
		close();
        return lines;
    }
	
	 // 查找行
    public static String query(String keywords){
        ArrayList<String> lines = readFileLines();
        for(String line : lines) {
            if (line.contains(keywords)) {
            	return line;
            }
        }
		close();
        return "";
    }
    
    // 选择分数
    public static int selectScore(String name){
    	//通过字符串特征，取最后一个逗号索引
    	int index = query(name).lastIndexOf(",");
    	String str = query(name).substring(index+1);
    	int score = Integer.parseInt(str);
    	close();
    	return score;
    }
     
    // 更新分数
    public static int updateScore(String name, int score){
        int index=0;
        String stemp;
        ArrayList<String> lines = readFileLines();
    	ArrayList<String> strs = new ArrayList<String>();
    	ArrayList<String> names = new ArrayList<String>();
    	ArrayList<Integer> scores = new ArrayList<Integer>();
    	
    	lines = readFileLines();
        String str = ""; 
        
    	for (String string : lines) {
    		for (String s : string.split(",")) {
    			strs.add(s);
    		}
		}

    	for(int i=0;i<strs.size()/3;i++){
    	//	System.out.println(i);
    		names.add(strs.get(i*3));
    		scores.add(Integer.parseInt(strs.get(i*3 + 2)));
    	}
    	
    	for (int i = 0;i<names.size();i++) {
        	if(name.equals(names.get(i)))	
        		{
        			index = i;
        		}
		}
		for (String string : lines) {
			if(string.contains(name) && name.length()==names.get(index).length()){
			    index = string.lastIndexOf(",") + 1;
			    System.out.println(index);
				String temp = string.substring(index);
				stemp = string.replace(temp, score + "");
				str = stemp + "\n" + str;
			}
			else {
				str = string + "\n" + str;
			}
		}
		
		new Operator().insert(str);
    	close();
    	return 0;
    }
    
    // 判断User是否存在
    public static boolean query(User u){
        ArrayList<String> lines = readFileLines();
        for(String line : lines) {
            if (line.contains(u.getName() + "," +  u.getPwd())) {
            	return true;
            }
        }
		close();
        return false;
    }
    
 // 以Score排序
    public static String queryOrderScore(){
    	ArrayList<String> lines = new ArrayList<String>();		//存储读取后的String列表
    	ArrayList<String> strs = new ArrayList<String>();
    	ArrayList<String> name = new ArrayList<String>();
    	ArrayList<Integer> score = new ArrayList<Integer>();
    	lines = readFileLines();
    	for (String string : lines) {
    		for (String str : string.split(",")) {
    			strs.add(str);
    		}
		}

    	for(int i=0;i<strs.size()/3;i++){
    		name.add(strs.get(i*3));
    		score.add(Integer.parseInt(strs.get(i*3 + 2)));
    	}
    	
    	//冒泡排序：从大到小
    	for(int i=0;i<score.size()-1;i++){
    		for(int j=0;j<score.size()-1-i;j++){
    			if(score.get(j) < score.get(j+1)){
    				int temp = score.get(j);
    				score.set(j, score.get(j+1));
    				score.set(j+1, temp);

    				String stemp = name.get(j);
    				name.set(j, name.get(j+1));
    				name.set(j+1, stemp);
    			}
    		}
    	}
    	
    	String result = "";
    	if(name.size()>3)
	    	for(int i=0;i<3;i++){
	    		User user = new User(name.get(i),score.get(i));
	    		result = result + user.toString();
	    	}
    	else {
    		for(int i=0;i<name.size();i++){
	    		User user = new User(name.get(i),score.get(i));
	    		result = result + user.toString();
	    	}
    	}
		close();
    	return result;
    }
}
