package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//账户设置
public class FLPanel2 extends JPanel{
    JButton jb1,jb2;  //创建按钮
    PoliceListen listen=new PoliceListen();//添加监视器
    FLPanel2(){
        jb1 = new JButton("修改密码");
        jb2 = new JButton("退出登录");
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
        //对修改密码按钮添加监视事件
        jb1.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new Change();
            }
        });
        //对退出登录按钮添加监视事件
        jb2.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new Login();
            }
        });
    }
}
