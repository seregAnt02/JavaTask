package task_4_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/*
Создать окно клиента чата. Окно должно содержать JtextField для ввода логина, пароля, IP-адреса сервера,
порта подключения к серверу, область ввода сообщений, JTextArea область просмотра сообщений чата и JButton подключения к серверу
и отправки сообщения в чат. Желательно сразу сгруппировать компоненты, относящиеся
к серверу сгруппировать на JPanel сверху экрана, а компоненты, относящиеся к отправке сообщения – на JPanel снизу
 */
public class ClientChat extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 500;
    private static final int WINDOW_POSY = 100;
    JPanel panel = new JPanel(new GridLayout(1, 2));
    JLabel jlb1 = new JLabel("Введите логин: ");
    JTextField jtf1 = new JTextField();

    JPanel panel2 = new JPanel(new GridLayout(1, 2));
    JLabel jlb2 = new JLabel("Введите пароль: ");
    JTextField jtf2 = new JTextField();

    JPanel panel3 = new JPanel(new GridLayout(1, 2));
    JLabel jlb3 = new JLabel("Введите IP адрес сервера: ");
    JTextField jtf3 = new JTextField();

    JPanel panel4 = new JPanel(new GridLayout(1, 2));
    JLabel jlb4 = new JLabel("Введите номер порта: ");
    JTextField jtf4 = new JTextField();

    JButton btnLogin = new JButton("Подключиться");
    JTextArea textChat = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(textChat);
    JPanel panelMain = new JPanel(new GridLayout(10, 1));

    JLabel jlb6 = new JLabel("Введите ваше сообщение: ");
    JTextArea chatMessage = new JTextArea();
    JButton pushMsg = new JButton("Отправить сообщение.");
//    String logChat = "";
//    char[] bufferLog;

    public ClientChat(ServerChat serverChat) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("ChatClient");
        setResizable(true);

        setLayout(new GridLayout(1, 1));
        panel.add(jlb1);
        panel.add(jtf1);
        panel2.add(jlb2);
        panel2.add(jtf2);
        panel3.add(jlb3);
        panel3.add(jtf3);
        panel4.add(jlb4);
        panel4.add(jtf4);
        panelMain.add(panel);
        panelMain.add(panel2);
        panelMain.add(panel3);
        panelMain.add(panel4);

        panelMain.add(btnLogin);
        textChat.setEditable(false);
        panelMain.add(scrollPane);

        panelMain.add(jlb6);
        panelMain.add(chatMessage);
        panelMain.add(pushMsg);
        add(panelMain);

        pushMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(serverChat.isServerWorking()) {
                    writeData();
                    System.out.println("Сообщение отправлено!");
                }
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textChat.setText(null);
                chatMessage.setText(null);
                if(serverChat.isServerWorking()){
                    textChat.append("Подключение установленно!");
                    loadData();
                    System.out.println("Connect server...");
                } else {
                    textChat.append("Пожайлуста, подключитесь к серверу!");
                    System.out.println("Please connect to server...");
                }
            }
        });

        setVisible(true);
    }
    void writeData(){
        try(FileWriter fw = new FileWriter("chat.txt", false))
        {
            // запись всей строки
            fw.write(chatMessage.getText());
            // запись по символам
            fw.append('\n');

            fw.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    void loadData(){
        try {
            FileInputStream fr = new FileInputStream("chat.txt");
            int b;
            while ((b = fr.read()) != -1) {
                chatMessage.append(Character.valueOf((char) b).toString());
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
