package frame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.UUID;

public class  picSquare {
    // 开始坐标
    private int[] start = new int[2];
    // 结束坐标
    private int[] end = new int[2];

    public picSquare(){

    }

    public void SetStartX(int x)
    {
        this.start[0]=x;
    }

    public void SetStartY(int y)
    {
        this.start[1]=y;
    }

    public void SetEndX(int x)
    {
        this.end[0]=x;
    }

    public void SetEndY(int y)
    {
        this.end[1]=y;
    }

    public void SetEndXY(int x,int y)
    {
        this.end[0]=x;
        this.end[1]=y;
    }

    public void SetStartXY(int x,int y)
    {
        this.start[0]=x;
        this.start[1]=y;
    }


    public void cutpic() throws AWTException {
        String fileName = "MainCode/image";
        Rectangle screenRectangle = new Rectangle(this.start[0],this.start[1],Math.abs(this.start[0]-this.end[0]),Math.abs(this.start[1]-this.end[1]));//根据屏幕大小创建一个矩形
        String randomName = UUID.randomUUID().toString().replace("-", "");
        String name = randomName + ".png";//jpg等也可
        // 截图保存的路径
        File screenFile = new File(fileName);
        if (!screenFile.exists()) {
            screenFile.mkdirs();//创建文件路径
        }
        Robot robot;
        boolean b = false;
        try {
            robot = new Robot();
            BufferedImage image = robot.createScreenCapture(screenRectangle);//使用Robot类提供的截屏方法，
            File f = new File(screenFile, name);
            b = ImageIO.write(image, "png", f);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
