package shabd.yoga.beans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class FileReadPronun {
	private static Map<String,String> pronunMap, bigHindiMap, urduMap, englishMap, similarMap;
	private static FileInputStream pronunFis, bigHindiFis, urduFis, englishFis, similarFis;
	private static BufferedReader pronunBr, bigHindiBr, urduBr, EnglishBr, similarBr;
	private FileReadPronun() {
		
	}
	
	
	public static Map getPronunMap(String path){
		if(pronunMap==null){
			String filePath=path+"/WEB-INF/pronun.txt";
			try{
				pronunFis=new FileInputStream(filePath);
				pronunBr=new BufferedReader(new InputStreamReader(pronunFis,"UTF-8"));
				pronunMap=new TreeMap<String,String>();
				String string;
				while((string=pronunBr.readLine())!=null){
					String stringSeperated[]=string.split(":::");
					pronunMap.put(stringSeperated[0].toLowerCase().trim(), stringSeperated[1].toLowerCase().trim());
				}
			
			}catch(FileNotFoundException fnfe){
				fnfe.printStackTrace();
			}
			catch(UnsupportedEncodingException uee){
				uee.printStackTrace();
	
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
			finally{
				try {
					pronunBr.close();
					pronunFis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return pronunMap;
					
		}
		else{
			return pronunMap;
		}
	}
	public static Map getSimilarMap(String path){
		if(similarMap==null){
			String filePath=path+"/WEB-INF/similars.txt";
			try{
				similarFis=new FileInputStream(filePath);
				similarBr=new BufferedReader(new InputStreamReader(similarFis,"UTF-8"));
				similarMap=new TreeMap<String,String>();
				String string;
				CharSequence cs=",";
				while((string=similarBr.readLine())!=null){
					if(string.contains(cs)){
						String stringSeperated[]=string.split(",");
						String key=stringSeperated[0];
						String value="";
						if(stringSeperated.length>1){
							for(int i=1;i<stringSeperated.length;i++){
								value=value+","+stringSeperated[i];
								if(i==53){
									break;
								}
							}
						}
						similarMap.put(key, value);
					}
				}			
			}catch(FileNotFoundException nfe){
				nfe.printStackTrace();
			}catch(UnsupportedEncodingException uee){
				uee.printStackTrace();			
			}catch(IOException ioe){
				ioe.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				try{
					similarBr.close();
					similarFis.close();
				}catch(IOException ioec){
					ioec.printStackTrace();
				}
				
			}
			return similarMap;
		}
		else{
			return similarMap;
		}
	}
	public static Map getEnglishMap(String path){
		if(englishMap==null){
			String filePath=path+"/WEB-INF/EnglishEnglishWords.txt";
			try{
				englishFis=new FileInputStream(filePath);
				EnglishBr=new BufferedReader(new InputStreamReader(englishFis,"UTF-8"));
				englishMap=new TreeMap<String,String>();
				String string;
				while((string=EnglishBr.readLine())!=null){
					String seperated[]=string.split("::");
					
						englishMap.put(seperated[0].toLowerCase().trim(), seperated[1]);
					
				}
				
			}catch(FileNotFoundException nfe){
				nfe.printStackTrace();
			}catch(UnsupportedEncodingException uee){
				uee.printStackTrace();
			}
			catch(IOException ioe){
				ioe.printStackTrace();
			}
			finally{
				try{
					EnglishBr.close();
					englishFis.close();
				}catch(IOException ioec){
					ioec.printStackTrace();
				}
			}
			return englishMap;
		}
		
		else{
			return englishMap;
		}
	}
	public static Map getbigHindiMap(String path){
		if(bigHindiMap==null){
			String filePath=path+"/WEB-INF/EnglishHindiSeperated.txt";
			try{
				bigHindiFis=new FileInputStream(filePath);
				bigHindiBr=new BufferedReader(new InputStreamReader(bigHindiFis, "UTF-8"));
				bigHindiMap=new TreeMap<String,String>();
				String string;
				int counter=0;
				while((string=bigHindiBr.readLine())!=null){
					String stringSeperated[]=string.split(":");
					if(counter==0){
						bigHindiMap.put(stringSeperated[0].toLowerCase().trim(),stringSeperated[1]);
					}
					else{
						String keyValue=bigHindiMap.get(stringSeperated[0].toLowerCase().trim());
						if(keyValue!=null){
							keyValue=keyValue+"#@#"+stringSeperated[1];
							bigHindiMap.put(stringSeperated[0].toLowerCase().trim(), keyValue);
						}
						else{
							bigHindiMap.put(stringSeperated[0].toLowerCase().trim(), stringSeperated[1]);
						}
					}
					counter++;
				}
				
			}catch(FileNotFoundException nfe){
				nfe.printStackTrace();
			}catch(UnsupportedEncodingException uee){
				uee.printStackTrace();
			} catch(IOException ioe){
				ioe.printStackTrace();
			}finally{
				try{
					bigHindiBr.close();
					bigHindiFis.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			return bigHindiMap;
		}
		else{
			return bigHindiMap;
		}
	}
	public static Map getUrduMap(String path){
		if(urduMap==null){
			String filePath=path+"/WEB-INF/EnglishUrdu.txt";
			try{
				urduFis=new FileInputStream(filePath);
				urduBr=new BufferedReader(new InputStreamReader(urduFis,"UTF-8"));
				urduMap=new TreeMap<String,String>();
				String string;
				String keys="";
				urduMap.put("nidarshan","urdulabz!");
				while((string=urduBr.readLine())!=null){
					CharSequence cs=":";
					CharSequence cst="##";
					if(string.contains(cs)){
						String stringSeperated[]=string.split(":");
						if(!keys.equals(stringSeperated[0].toLowerCase().trim())){
							keys=stringSeperated[0].toLowerCase().trim();
							urduMap.put(stringSeperated[0].toLowerCase().trim(), stringSeperated[1].toLowerCase().trim());
							//System.out.println("$$$"+keys);
						}
						else{
							keys=stringSeperated[0].toLowerCase().trim();
							String values=urduMap.get(keys);
							String finalValue=values+"@@"+stringSeperated[1];
							urduMap.put(stringSeperated[0].toLowerCase().trim(), finalValue);
							//System.out.println("***"+keys);
						}
					}
					else{
						if(urduMap!=null){
							//Set set=new TreeSet<String>();
							//SortedSet<String> set=(SortedSet<String>) urduMap.keySet();
							
							//String key=set.last();
							
							if(string.contains(cst)){
								String value=urduMap.get(keys);
								//System.out.println(keys);
								value=value+"@@"+string.toLowerCase().trim();
								//System.out.println(key+":"+value);
								urduMap.put(keys, value);
								
							}
							else{
								String value=urduMap.get(keys);
								//System.out.println("start:"+keys);
								value=value+string.toLowerCase().trim();
								//System.out.println(key+"="+value);
								urduMap.put(keys, value);
							}
						}
						
					}
				}
			
			}catch(FileNotFoundException fnfe){
				fnfe.printStackTrace();
			}
			catch(UnsupportedEncodingException uee){
				uee.printStackTrace();
	
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
			finally{
				try {
					urduBr.close();
					urduFis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return urduMap;
		}
		else{
			return urduMap;
		}
	}
}
