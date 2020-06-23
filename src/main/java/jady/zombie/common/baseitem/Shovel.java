package jady.zombie.common.baseitem;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

import static jady.zombie.utils.ImageUtil.loadImage;

public class Shovel {
	
	// 铲子

	private static BufferedImage image;
	static {
		image = loadImage("shovel.png");
	}
	
	// 获取图片
	public BufferedImage getImage() {
		if(state==WAIT ||state==MOVE) {
			return image;
		}else {
			return null;
		}
	}
	
	// 画图片
	public void paintObject(Graphics g) {
		g.drawImage(getImage(),x,y,null); 
	}
	
	// 基本属性
	private int x;
	private int y;
	private int width;
	private int height;
	
	// 构造方法
	public Shovel() {
		this.x = 90;
		this.y = 0;
		this.width = 76;
		this.height = 34;
	}
	
	// 获取x,y,宽高
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	
	// 铲子的状态
	public static final int WAIT = 0;
	public static final int MOVE = 1;
	public static final int REMOVE = 2;
	public int state = WAIT;
	
	// 判断铲子状态
	public boolean isWait() {
		return state==WAIT;
	}
	public boolean isMove() {
		return state==MOVE;
	}
	public boolean isRemove() {
		return state==REMOVE;
	}
	
	// 改变铲子状态
	public void goMove() {
		state = MOVE;
	}
	public void goRemove() {
		state = REMOVE;
	}
	
	// 铲子的移动
	public void moveTo(int x,int y) {
		this.x = x-this.width/2;
		this.y = y-this.height/2;
	}
	
}
