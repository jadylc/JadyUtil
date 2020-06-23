package jady.zombie.common;

import javax.sound.sampled.*;
import java.io.File;
import java.util.Objects;

public class zombieAubio implements Runnable{
	
	// 读音频WAV格式专用线程
	private String filename;
	public zombieAubio(String wavfile){
	    filename=wavfile;
	}
	public void run(){
	    File soundFile = new File(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("sound/" + filename)).getPath());
	    //调用音频流
	    AudioInputStream ais=null;

	    try {
	        ais=AudioSystem.getAudioInputStream(soundFile);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return;
	     }
	    AudioFormat format=ais.getFormat();
	    SourceDataLine auline=null;
	    DataLine.Info info=new DataLine.Info(SourceDataLine.class, format);
	    try{
	        auline=(SourceDataLine) AudioSystem.getLine(info);
	        auline.open(format);
	    }catch(Exception e){
	        e.printStackTrace();
	        return;
	    }

	    auline.start();
	    int nBytesRead=0;
	    //缓冲
	    byte[] abData=new byte[1024];

	    try{
	        while(nBytesRead!=-1){
	            nBytesRead=ais.read(abData,0,abData.length);
	            if(nBytesRead>=0)
	                auline.write(abData, 0, nBytesRead);
	        }
	    }catch(Exception e){
	        e.printStackTrace();
	        return;
	    }finally{
	        auline.drain();
	        auline.close();
	    }
	}       
}