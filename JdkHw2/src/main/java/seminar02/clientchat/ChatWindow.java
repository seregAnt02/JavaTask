package seminar02.clientchat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChatWindow extends JFrame implements Listenerable {
    private static final int WINDOW_HEIGHT = 300;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 500;
    private static final int WINDOW_POSY = 100;
    Server server;

    final JTextArea log = new JTextArea();
    private final JPanel panelTop = new JPanel(new GridLayout(3, 2));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JTextField tfLogin = new JTextField("you_login");
    private final JPasswordField tfPassword = new JPasswordField("password");
    private final JButton btnLogin = new JButton("Login");
    private final JButton btnLogout = new JButton("Logout");

    private final JPanel panelBottom = new JPanel(new GridLayout(1, 2));
    private final JTextField ftMessage = new JTextField("Enter your message");
    private final JButton btnSend = new JButton("Send");

    public ChatWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat Client");
        setResizable(true);

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.login(tfLogin.getText(), tfPassword.getText());
                System.out.println(tfLogin.getText() + "    " + tfPassword.getText());
            }
        });
        panelTop.add(btnLogin);
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.disconnect();
            }
        });
        panelTop.add(btnLogout);
        add(panelTop, BorderLayout.NORTH);

        panelBottom.add(ftMessage);
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.sendMessage(ftMessage.getText());
            }
        });
        panelBottom.add(btnSend);
        add(panelBottom, BorderLayout.SOUTH);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);

        setVisible(true);

        server = new Server(this);

    }

    @Override
    public void buttonAction(String str) {
        log.append(str);
    }
}
