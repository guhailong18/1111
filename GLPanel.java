package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GLPanel extends JPanel{
    JLabel jl =new JLabel("请输入要查阅的图书编号：");
    JLabel jl1 = new JLabel("查询结果：");
    JButton jb = new JButton("查询");
    JTextField jTextField;
    JTextArea textshow;
    JPanel jp1,jp2,jp3;
    PoliceListen listen=new PoliceListen();//添加监视器
    GLPanel() {
        Toolkit kit  = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width-300)/2;
        int y = (height - 200)/2;
        jTextField = new JTextField(12);  //创建文本框组件
        textshow = new JTextArea(12,24);
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp1.add(jl);
        jp1.add(jTextField);
        jp3.add(jb);
        jp2.add(jl1);
        jp2.add(textshow);
        add(jp1);
        add(jp2);
        add(jp3);
        String str = listen.图书浏览();
        textshow.append(str);
        add(new JScrollPane(textshow));
        //对查询按钮添加监视事件
        jb.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(new String(jTextField.getText()).length()>6){

                    JOptionPane.showMessageDialog(null,"查询成功");
                    new Reader(); //进入到读者窗口
                }else {
                    JOptionPane.showMessageDialog(null,"学号或姓名错误");
                }
            }
        });
    }
}
