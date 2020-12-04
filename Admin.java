package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.* ;
public class Admin extends JFrame{
    JTabbedPane p;
    PoliceListen listen=new PoliceListen();//添加监视器
    public Admin() {
        Toolkit kit  = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width-300)/2;
        int y = (height - 200)/2;
        setBounds(x,y,800,600);
        setVisible(true);
        p=new JTabbedPane(JTabbedPane.LEFT);
        p.add("图书管理",new FLPanel3());
        p.add("图书列表",new GLPanel());
        p.add("成员管理",new FLPanel4());
        p.add("图书借阅",new FLPanel1());
        p.add("账户设置",new FLPanel2());
        p.validate();
        add(p,BorderLayout.CENTER);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //添加图标
        ImageIcon imageIcon=new ImageIcon("image/1.png");
        setIconImage(imageIcon.getImage());
    }
}
