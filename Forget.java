package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Forget extends JFrame{
    JTextField jTextField;
    JPasswordField jPasswordField;
    JTextArea textshow;
    JLabel jl1,jl2,jl3;
    JPanel jp1,jp2,jp3,jp4;
    JButton jb1,jb2;  //创建按钮
    PoliceListen listen=new PoliceListen();//添加监视器
    public Forget(){
        Toolkit kit  = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width-300)/2;
        int y = (height - 200)/2;
        jTextField = new JTextField(12);  //创建文本框组件
        jPasswordField = new JPasswordField(13);
        jl1 = new JLabel("姓名:");
        jl2 = new JLabel("学号:");
        jl3 = new JLabel("密码");
        jb1 = new JButton("确认");
        jb2 = new JButton("返回");
        //添加图标
        ImageIcon imageIcon=new ImageIcon("image/1.png");
        setIconImage(imageIcon.getImage());
        textshow = new JTextArea(1,12);
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        //设置布局
        this.setLayout(new GridLayout(3,1));
        jp1.add(jl1);
        jp1.add(jTextField);
        jp2.add(jl2);
        jp2.add(jPasswordField);
        jp3.add(jl3);
        jp3.add(textshow);
        jp4.add(jb1);
        jp4.add(jb2);
        add(jp1);
        add(jp2);
        add(jp3);
        add(jp4);
        add(new JScrollPane(textshow));
        setSize(300,200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setTitle("忘记密码");
        setLocation(x,y);
        //对确定按钮添加监视事件
        jb1.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String str = listen.用户忘记密码(jTextField.getText(),jPasswordField.getText());
                textshow.append(str);
                if(new String(jPasswordField.getPassword()).length()>6){
                    JOptionPane.showMessageDialog(null,"查询成功");
                    dispose();
                    new Reader(); //进入到读者窗口
                }else {
                    JOptionPane.showMessageDialog(null,"学号或姓名错误");
                }
            }
        });
        //对返回首页按钮添加监视事件
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
