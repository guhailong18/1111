package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.* ;

public class Login extends JFrame {
    JTextField jTextField;
    JPasswordField jPasswordField;
    JLabel jl1,jl2;
    JPanel jp1,jp2,jp3;
    JButton jb1,jb2,jb3,jb4;  //创建按钮
    PoliceListen listen=new PoliceListen();//添加监视器
    public Login(){
        Toolkit kit  = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width-300)/2;
        int y = (height - 200)/2;
        jTextField = new JTextField(12);  //创建文本框组件
        jPasswordField = new JPasswordField(13);  //创建密码框组件
        jl1 = new JLabel("借阅证");
        jl2 = new JLabel("密  码");
        jb1 = new JButton("确认");
        jb2 = new JButton("注册");
        jb3 = new JButton("忘记密码");
        jb4 = new JButton("管理员登录");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        //设置布局
        setLayout(new GridLayout(3,1));
        jp1.add(jl1);
        jp1.add(jTextField);
        jp2.add(jl2);
        jp2.add(jPasswordField);
        jp3.add(jb1);
        jp3.add(jb2);
        jp3.add(jb3);
        jp3.add(jb4);
        add(jp1);
        add(jp2);
        add(jp3);
        setSize(320,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("登录");
        setLocation(x,y);
        //添加图标
        ImageIcon imageIcon=new ImageIcon("P:/java-train/1/src/image/1.png");
        setIconImage(imageIcon.getImage());
        //对确定按钮添加监视事件
        jb1.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent arg0) {
                boolean a = listen.用户登录(jTextField.getText(),jPasswordField.getText());
                if(a&&jTextField.getText().trim().equals("mk")&&new String(jPasswordField.getPassword()).equals("123456")){  //修改成数据库返回的信息
                    JOptionPane.showMessageDialog(null,"登录成功");
                    dispose();
                    new Reader(); //进入到读者窗口
                }else {
                    JOptionPane.showMessageDialog(null,"登录失败，请检查借阅证和密码！");
                }
            }
        });
        //对注册按钮添加监视事件
        jb2.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                new Register();
            }
        });
        //对忘记密码按钮添加监视事件
        jb3.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                new Forget();
            }
        });
        //对管理员登录按钮添加监视事件
        jb4.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent arg0) {
                boolean a = listen.管理员登录(jTextField.getText(),jPasswordField.getText());
                if(jTextField.getText().trim().equals("admin")&&new String(jPasswordField.getPassword()).equals("abcdef")){  //修改成数据库返回的信息
                    JOptionPane.showMessageDialog(null,"登录成功");
                    dispose();
                    new Admin(); //进入到管理员窗口
                }else {
                    JOptionPane.showMessageDialog(null,"登录失败，请检查借阅证和密码！");
                }

            }
        });
    }
}
