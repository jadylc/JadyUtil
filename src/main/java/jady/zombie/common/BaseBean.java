package jady.zombie.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author liuhan
 * @date 2020/03/27
 */
@Data
public abstract class BaseBean {
    private int width;
    private int height;
    private int x;
    private int y;
}
