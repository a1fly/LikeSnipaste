package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFrame extends JFrame implements MouseListener {

    picSquare ps; // 截图窗口对象


    public MyFrame()
    {
        addMouseListener(this);
    }


    //创建窗口

    public void CreateFrame(String title)
    {

        this.setTitle(title);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 1));

        // 设置内容窗格的背景色为透明
        Container container = this.getContentPane();
        container.setBackground(new Color(0, 0, 0, 0));

        // 获取屏幕尺寸
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int w=screenSize.width;
        int h=screenSize.height;
        this.setSize(w,h-60);
        this.setVisible(true);

        // 设置窗口关闭操作
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    @Override
    public void mouseClicked(MouseEvent e) {
//        int c = e.getButton();// 得到按下的鼠标键
//        if (c==MouseEvent.BUTTON1)
//        {
//            System.out.println("点击了左键！！！");
//
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

        int x=e.getX();
        int y=e.getY();
        this.ps=new picSquare();
        System.out.println("按下鼠标时x的坐标为："+x+" , y的坐标为："+y);
        ps.SetStartXY(x,y);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int x=e.getX();
        int y=e.getY();
        System.out.println("松开鼠标时x的坐标为："+x+" , y的坐标为："+y);
        ps.SetEndXY(x,y);
        try {
            ps.cutpic();
        } catch (AWTException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
