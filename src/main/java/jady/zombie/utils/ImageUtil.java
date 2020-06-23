package jady.zombie.utils;

import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Objects;

/**
 * @author liuhan
 * @date 2020/03/27
 */
@Slf4j
public class ImageUtil {

    /**
     * 加载图片
     * @param fileName
     * @return
     */
    public static BufferedImage loadImage(String fileName) {
        try {
            return ImageIO.read(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("image/" + fileName)));
        }catch(Exception e) {
            log.error("图片{}加载失败",fileName,e);
            throw new RuntimeException();
        }
    }
}
