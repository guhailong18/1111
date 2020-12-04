package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Dreader extends JFrame {
    JTextField jTextField;
    JLabel jl1;
    JPanel jp1, jp2;
    JButton jb1, jb2;  //创建按钮
    PoliceListen listen=new PoliceListen();//添加监视器
    public Dreader() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - 300) / 2;
        int y = (height - 200) / 2;
        jTextField = new JTextField(12);  //创建文本框组件

        jl1 = new JLabel("借阅证号");
        jb1 = new JButton("确认");
        jb2 = new JButton("返回");
        jp1 = new JPanel();
        jp2 = new JPanel();
        //设置布局
        setLayout(new GridLayout(3, 1));
        jp1.add(jl1);
        jp1.add(jTextField);
        jp2.add(jb1);
        jp2.add(jb2);
        add(jp1);
        add(jp2);
        setSize(320, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setTitle("删除成员");
        setLocation(x, y);
        //对确定按钮添加监视事件
        jb1.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String str1=jTextField.getText();
                boolean a = listen.借书(str1);
                if (a&&str1 != null && str1.length() != 0) {  //修改成数据库返回的信息
                    JOptionPane.showMessageDialog(null, "添加成功");
                    dispose();
                  //  new Admin(); //进入到管理员窗口
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
