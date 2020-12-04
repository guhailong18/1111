package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//图书借阅
public class FLPanel1 extends JPanel{
    JButton jb1,jb2;  //创建按钮
    FLPanel1(){
        jb1 = new JButton("借书");
        jb2 = new JButton("还书");
        PoliceListen listen=new PoliceListen();//添加监视器
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
        //对借书按钮添加监视事件
        jb1.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new Bbook();
            }
        });
        //对还书按钮添加监视事件
        jb2.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new Rbook();
            }
        });
    }
}
