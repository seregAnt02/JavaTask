/**
 * 1. Досдать долги
 * 2. Разобраться с кодом, сформулировать и задать вопросы.
 * 3. Если вопросов нет - ДЗ засчитано автоматом.
 *
 * Необязательные задания "для себя"
 * 1. Исправить проблему отправки сообщения самому себе (запретить это делать)
 * 2.** Придумать формат сообщения и использовать его (json, serializable map, ...)
 * 3.**** Синхронизовать 2 потока чтение\запись на клиенте, чтобы при exit оба потока останавливались.
 * Для этого, можно завести 2 класса-обертки вокруг Thread и держать ссылки друг на друга:
 * в каждом из них следить на неким "флажком", определяющим, что клиент сделал exit.
 */


package lesson5;

import java.io.IOException;
import java.net.ServerSocket;

public class RunServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(1300);
        Server server = new Server(serverSocket);
        server.runServer();
    }
}
