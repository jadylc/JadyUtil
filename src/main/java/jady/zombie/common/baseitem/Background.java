package jady.zombie.common.baseitem;

import jady.zombie.common.constants.Config;
import jady.zombie.launch.GameLauncher;

import java.awt.*;
import java.awt.image.BufferedImage;

import static jady.zombie.utils.ImageUtil.loadImage;

public class Background {
	
	// 背景图
	// 基本属性
	private int x;
	private int y;
	private int width;
	private int height;
	
	// 构造器
	public Background(int width,int height,int x,int y) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}
	

	private static BufferedImage[] image;
	static {
		image = new BufferedImage[3];
		image[0] = loadImage("bg0.jpg");
		image[1] = loadImage("bg1.jpg");
		image[2] = loadImage("bg2.jpg");
	}
	
	// 获取图片
	public BufferedImage getImage() {
		if(GameLauncher.state==Config.START) {
			return image[0];
		}else if(GameLauncher.state== Config.RUNNING) {
			return image[1];
		}else if(GameLauncher.state==Config.GAME_OVER) {
			return image[2];
		}
		return null;
	}
	
	// 画图片
	public void paintObject(Graphics g) {
		g.drawImage(getImage(),x,y,null); 
	}

}
