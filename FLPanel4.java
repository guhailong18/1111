package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//成员管理
public class FLPanel4 extends JPanel{
    JButton jb1,jb2;  //创建按钮
    PoliceListen listen=new PoliceListen();//添加监视器
    FLPanel4(){
        jb1 = new JButton("添加成员");
        jb2 = new JButton("删除成员");
        add(jb1);
        add(jb2);
        Toolkit kit  = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width-300)/2;
        int y = (height - 200)/2;
        setSize(300,200);
        setLocation(x,y);
        //对添加成员按钮添加监视事件
        jb1.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new Addreader();
            }
        });
        //对删除成员按钮添加监视事件
        jb2.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new Dreader();
            }
        });
    }
}