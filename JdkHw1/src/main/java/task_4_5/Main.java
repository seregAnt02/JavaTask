
/*Выполнить все задания семинара, если они не были решены,
        без ограничений по времени;
        Отправлять сообщения из текстового поля сообщения в лог
        по нажатию кнопки или по нажатию клавиши Enter на поле ввода сообщения;
        Продублировать импровизированный лог (историю) чата в файле;
        При запуске клиента чата заполнять поле истории из файла, если он существует. Обратите внимание,
        что чаще всего история сообщений хранится на сервере
        и заполнение истории чата лучше делать при соединении с сервером, а не при открытии окна клиента.*/

package task_4_5;

public class Main {
    public static void main(String[] args)
    {
        ServerChat server = new ServerChat();
        new ClientChat(server);
    }
}
