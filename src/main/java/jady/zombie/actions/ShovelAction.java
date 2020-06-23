package jady.zombie.actions;

import jady.zombie.common.baseitem.Shovel;

import java.util.List;

/**
 * @author liuhan
 * @date 2020/03/27
 */
public class ShovelAction {

    // 铲子入場
    public static void addShovel(List<Shovel> shovels) {
        //场面上只能有一把铲子
        if(shovels.size() == 0) {
            shovels.add(new Shovel());
        }
    }
}
