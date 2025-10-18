import java.awt.Font;
import javax.swing.*;
class practice1{
    public static void main(String[]args){
       SwingUtilities.invokeLater(() -> {
            int pos[] = {50,100};
            int flag[] = {0};
            int s[] = {0};
            s[0] = 20;
            JFrame frame = new JFrame("移動");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(450,250);
            frame.setLocation(pos[0],pos[1]);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.setResizable(false);
            JLabel title = new JLabel("");
            title.setFont(new Font("", Font.BOLD, 15));

            title.setBounds(10,30,100,30);

            JButton mover = new JButton("右に移動");
            mover.setBounds(10,100,100,30);
            JButton movel = new JButton("左に移動");
            movel.setBounds(110,100,100,30);
            JButton moveu = new JButton("上に移動");
            moveu.setBounds(210,100,100,30);
            JButton moved = new JButton("下に移動");
            moved.setBounds(310,100,100,30);
            JButton speed = new JButton("早く移動");
            speed.setBounds(150,150,100,30);
            
            JButton[] buttons ={mover,movel,moveu,moved,speed};
            for (JButton b : buttons) frame.add(b);
            frame.add(title);

            mover.addActionListener(e -> new Thread(() -> {
                for (int i = 0; i < 20; i++) {
                    pos[0] += 5;
                    frame.setLocation(pos[0], pos[1]);
                    title.setText("右に移動");
                    frame.setTitle("右に移動");
                    try { Thread.sleep(s[0]); } catch (InterruptedException ex) {}
                    
                }
                frame.setTitle("移動完了！");
                title.setText("移動完了！");
            }).start());

            movel.addActionListener(e -> new Thread(() -> {
                for (int i = 20; i > 0; i--) {
                    pos[0] += -5;
                    frame.setLocation(pos[0], pos[1]);
                    title.setText("左に移動");
                    frame.setTitle("左に移動");
                    try { Thread.sleep(s[0]); } catch (InterruptedException ex) {}
                }
                frame.setTitle("移動完了！");
                title.setText("移動完了！");
            }).start());

            moveu.addActionListener(e -> new Thread(() -> {
                for (int i = 20; i > 0; i--) {
                    pos[1] += -5;
                    frame.setLocation(pos[0], pos[1]);
                    title.setText("上に移動");
                    frame.setTitle("上に移動");
                    try { Thread.sleep(s[0]); } catch (InterruptedException ex) {}
                }
                frame.setTitle("移動完了！");
                title.setText("移動完了！");
            }).start());

            moved.addActionListener(e -> new Thread(() -> {
                for (int i = 0; i < 20; i++) {
                    pos[1] += 5;
                    frame.setLocation(pos[0], pos[1]);
                    title.setText("下に移動");
                    frame.setTitle("下に移動");
                    try { Thread.sleep(s[0]); } catch (InterruptedException ex) {}
                }
                frame.setTitle("移動完了！");
                title.setText("移動完了！");
            }).start());

            speed.addActionListener(e ->{
               if(flag[0] == 0){ 
                     flag[0] = 1;
                     s[0] = 10;
                     frame.setTitle("速度が速くなりました！");
               } else { 
                     flag[0] = 0;
                     s[0] = 20;
                     frame.setTitle("速度が遅くなりました！");
               }
            });

       });
    }
}