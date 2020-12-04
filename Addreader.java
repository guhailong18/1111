package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Addreader extends JFrame {
    JTextField jTextField,jTF1,jTF2;
    JPasswordField jPasswordField;
    JLabel jl1, jl2,jl3,jl4;
    JPanel jp1, jp2, jp3,jp4,jp5;
    JButton jb1, jb2;  //创建按钮
    PoliceListen listen=new PoliceListen();//添加监视器

    public Addreader() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - 300) / 2;
        int y = (height - 200) / 2;
        jTextField = new JTextField(12);  //创建文本框组件
        jTF1 = new JTextField(12);
        jTF2 = new JTextField(12);
        jPasswordField = new JPasswordField(13);  //创建密码框组件
        jl1 = new JLabel("借阅证号");
        jl2 = new JLabel("初始密码");
        jl3 = new JLabel("姓名");
        jl4 = new JLabel("学号");
        jb1 = new JButton("确认");
        jb2 = new JButton("返回");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        //设置布局
        setLayout(new GridLayout(3, 1));
        jp1.add(jl1);
        jp1.add(jTextField);
        jp2.add(jl2);
        jp2.add(jPasswordField);
        jp3.add(jl3);
        jp3.add(jTF1);
        jp4.add(jl4);
        jp4.add(jTF2);
        jp5.add(jb1);
        jp5.add(jb2);
        add(jp1);
        add(jp2);
        add(jp3);
        add(jp4);
        add(jp5);
        setSize(320, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setTitle("添加成员");
        setLocation(x, y);
        //添加图标
        ImageIcon imageIcon=new ImageIcon("image/1.png");
        setIconImage(imageIcon.getImage());
        //对确定按钮添加监视事件
        jb1.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent arg0) {
                boolean a = listen.用户注册(jTextField.getText(),jPasswordField.getText(),jTF1.getText(),jTF2.getText());
                if (a&&new String(jPasswordField.getPassword()).length() > 6) {  //修改成数据库返回的信息
                    JOptionPane.showMessageDialog(null, "添加成功");
                    dispose();
                   // new Admin(); //进入到管理员窗口
                } else {
                    JOptionPane.showMessageDialog(null, "添加失败，请检查密码是否少于6位！");
                }
            }
        });
        //对返回按钮添加监视事件
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
