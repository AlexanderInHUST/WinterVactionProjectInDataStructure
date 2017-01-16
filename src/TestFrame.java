import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by tangyifeng on 17/1/16.
 * Email: yifengtang@uniquestudio.com
 */

public class TestFrame extends JFrame {

    private int counter = 0;

    public TestFrame() {
        /* 使用匿名类添加一个窗口监听器 */
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Exit when Closed event");
                    //退出应用程序
                    System.exit(0);
                }

                public void windowActivated(WindowEvent e) {
                    // 改变窗口标题
                    setTitle("Test Frame " + counter++);
                }
            });

            // 设置窗口为固定大小
            setResizable(true);
            setSize(200, 150);
        }

        public static void main(String[] args) {
            TestFrame tf = new TestFrame();
            tf.setVisible(true);
        }

    }

