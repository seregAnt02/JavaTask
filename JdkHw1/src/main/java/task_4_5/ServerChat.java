package task_4_5;/*Создать простейшее окно управления сервером
        (по сути, любым), содержащее две кнопки (JButton) –
        запустить сервер и остановить сервер. Кнопки должны
        просто логировать нажатие (имитировать запуск и остановку
        сервера, соответственно) и выставлять внутри интерфейса
        соответствующее булево isServerWorking.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ServerChat extends JFrame {
    private static final int WINDOW_HEIGHT = 300;
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_POSX = 550;
    private static final int WINDOW_POSY = 500;

    private static JButton btStart = new JButton("Start");
    private static JButton btStop = new JButton("Stop");

    private static JTextArea log = new JTextArea();
    private static JPanel panel = new JPanel(new GridLayout(1, 2));

    private boolean isServerWorking;
    public ServerChat(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(WINDOW_POSX, WINDOW_POSY, WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setTitle("ChatServer");
        setAlwaysOnTop(true);
        log.setBackground(Color.BLACK);
        panel.add(btStart);
        panel.add(btStop);
        add(panel, BorderLayout.SOUTH);
        add(log);

        btStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorking = true;
                System.out.println("Server started "  + isServerWorking + "\n");
            }
        });

        btStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorking = false;
                System.out.println("Server stopped " + isServerWorking + "\n");
            }
        });

        setVisible(true);
    }

    public boolean isServerWorking() {
        return isServerWorking;
    }
}
