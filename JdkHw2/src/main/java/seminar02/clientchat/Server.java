package seminar02.clientchat;

import java.io.*;

/*
На предыдущем семинаре было описано окно сервера приложения, содержащее две кнопки (старт и стоп) и текстовое поле журнала.
Необходимо вынести логику работы сервера
в класс ChatServer, а в обработчиках кнопок оставить только логику нажатия кнопки и
журналирования сообщений от сервера.
Для достижения цели необходимо описать интерфейс «слушатель сервера», с методом
«получить сообщение», вызывать его с одной стороны, и реализовать с другой. Вариант
решения
 */
public class Server implements Clickable {
    boolean isConnect;
    Listenerable action;
    StringBuilder textLog;
    private static final String fileName = "./src/main/java/seminar02/clientchat/log_chat.txt";


    public Server(Listenerable action) {
        this.isConnect = false;
        this.action = action;
    }

    @Override
    public void sendMessage(String textMsg) {
        textLog.append("- ").append(textMsg).append("\n");
        action.buttonAction(textLog.toString());
    }

    @Override
    public void login(String login, String password) {
        textLog = new StringBuilder("Login is correct!").append("\n\n");
        try (BufferedReader br = new BufferedReader(
                new FileReader(Server.fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                textLog.append(line).append("\n");
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        action.buttonAction(textLog.toString());
    }

    @Override
    public void disconnect() {
        try (FileWriter fw = new FileWriter(Server.fileName, false)) {
            fw.write(textLog.toString());
            fw.flush();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
