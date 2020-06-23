package jady.zombie.actions;

import jady.zombie.common.baseitem.Glass;

import java.util.List;

/**
 * @author liuhan
 * @date 2020/03/27
 */
public class GrassAction {
    /**
     * 草坐标基点
     */
    private static final int grassX = 260;
    private static final int grassY = 80;
    /**
     * 草地入场
     */

    public static void addGrass(List<Glass> grasses) {
        for(int i=0;i<9;i++) {
            int x = grassX + i * Glass.WIDTH;
            for(int j=0;j<5;j++) {
                int y = grassY + j * Glass.HEIGHT;
                grasses.add(new Glass(x,y));
            }
        }
    }
}
