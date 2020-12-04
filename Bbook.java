package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bbook extends JFrame{
    public Bbook(){
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    void init() {
        PoliceListen listen=new PoliceListen();//添加监视器
        JTextField text1;//图书名，图书编号，作者，图书数量
        JLabel jl1;
        JPanel jp1,jp2;
        JButton jb1,jb2;  //创建按钮
        Toolkit kit  = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width-300)/2;
        int y = (height - 200)/2;
        setSize(300,200);
        setLocation(x,y);
        text1 = new JTextField(12);  //创建文本框组件
        jl1 = new JLabel("请输入所借书编号:");
        jb1 = new JButton("确认");
        jb2 = new JButton("返回");
        jp1 = new JPanel();
        jp2 = new JPanel();
        //设置布局
        setLayout(new GridLayout(3,1));
        jp1.add(jl1);
        jp1.add(text1);
        jp2.add(jb1);
        jp2.add(jb2);
        add(jp1);
        add(jp2);
        //添加图标
        ImageIcon imageIcon=new ImageIcon("image/1.png");
        setIconImage(imageIcon.getImage());
        //确认按钮添加监视事件
        jb1.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String str1=text1.getText();
                boolean a = listen.借书(str1);
                if(a&&str1 != null && str1.length() != 0){  //修改成数据库返回的信息
                    JOptionPane.showMessageDialog(null,"借书成功");
                    dispose();
                //    new Reader(); //进入到读者窗口
                }else {
                    JOptionPane.showMessageDialog(null,"借书失败，请检查编号是否正确！");
                }
            }
        });
        //返回按钮添加监视事件
        jb2.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
              //  new Reader();
            }
        });
    }
}
