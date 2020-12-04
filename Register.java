package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.* ;

public class Register extends JFrame{
    JTextField jTextField,jTF1,jTF2;//姓名，学号，借阅证号
    JPasswordField jPF1,jPF2;
    JLabel jl1,jl2,jl3,jl4,jl5;
    JPanel jp1,jp2,jp3,jp4,jp5,jp6;
    JButton jb1,jb2;  //创建按钮
    PoliceListen listen=new PoliceListen();//添加监视器
    public Register() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - 300) / 2;
        int y = (height - 200) / 2;
        jTextField = new JTextField(12);  //创建文本框组件
        jTF1 = new JTextField(12);
        jTF2 = new JTextField(12);
        jPF1 = new JPasswordField(13);  //创建密码框组件
        jPF2 = new JPasswordField(13);
        jl1 = new JLabel("姓名");
        jl2 = new JLabel("借阅证号");
        jl3 = new JLabel("输入密码");
        jl4 = new JLabel("确认密码");
        jl5 = new JLabel("学号");
        jb1 = new JButton("确认");
        jb2 = new JButton("返回");
        //设置布局
        setLayout(new GridLayout(3,1));
        jp1.add(jl1);
        jp1.add(jTextField);
        jp2.add(jl2);
        jp2.add(jTF1);
        jp3.add(jl3);
        jp3.add(jPF1);
        jp4.add(jl4);
        jp4.add(jPF2);
        jp5.add(jl5);
        jp5.add(jTF2);
        jp6.add(jb1);
        jp6.add(jb2);
        add(jp1);
        add(jp2);
        add(jp3);
        add(jp4);
        add(jp5);
        setSize(300,200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setTitle("注册");
        setLocation(x,y);
        //对确定按钮添加监视事件
        jb1.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent arg0) {
                boolean a = listen.用户注册(jTextField.getText(),jTF1.getText(),jTF2.getText(),jPF1.getText());
                if(a&&new String(jPF1.getPassword()).equals("123456")){  //修改成数据库返回的信息
                    JOptionPane.showMessageDialog(null,"注册成功");
                    dispose();
                    new Reader(); //进入到读者窗口
                }else {
                    JOptionPane.showMessageDialog(null,"登录失败，请检查姓名和学生号！");
                }
            }
        });
        //对返回按钮添加监视事件
        jb2.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                new Login();
            }
        });
    }
}