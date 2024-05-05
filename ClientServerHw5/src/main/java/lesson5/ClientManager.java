package lesson5;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ClientManager implements Runnable{
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String name;
    //public static ArrayList<ClientManager> clients = new ArrayList<>();
    public static Map<String, ClientManager> clients = new HashMap<>();

    public ClientManager(Socket socket) throws IOException {
        this.socket = socket;
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        name = bufferedReader.readLine();
        clients.put(name, this);

    }

    @Override
    public void run() {
        String massageFromClient;

        while (socket.isConnected()){
            try {
                massageFromClient = bufferedReader.readLine();
                String[] nameMessage = parsMessage(massageFromClient);
                if(nameMessage[2].equals("all")) sendMessageToAll(nameMessage);
                else sendMessageToClient(nameMessage);
            } catch (IOException e){
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    private String[] parsMessage(String massageToSend){
        String[] mas = massageToSend.split(":");
        return mas;
    }

    private void sendMessageToClient(String[] nameMessage){
        for (var client: clients.entrySet()) {
            try {
                if (client.getKey().equals(nameMessage[2]) && !nameMessage[2].equals(name)) {
                    client.getValue().bufferedWriter.write("от: " + name + " кому: " + nameMessage[2] +
                            ", сообщение: " + nameMessage[1]);
                    client.getValue().bufferedWriter.newLine();
                    client.getValue().bufferedWriter.flush();
                }
            } catch (IOException e){
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }
    private void sendMessageToAll(String[] nameMessage) {
        for (var client: clients.entrySet()) {
            try {
                if (!client.getKey().equals(name)) {
                    client.getValue().bufferedWriter.write("от: " + name + " кому: " + nameMessage[2] +
                            ", сообщение: " + nameMessage[1]);
                    client.getValue().bufferedWriter.newLine();
                    client.getValue().bufferedWriter.flush();
                }
            } catch (IOException e){
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    private void closeEverything(Socket socket, BufferedReader bufferedReader,
                                BufferedWriter bufferedWriter) {
        removeClient();
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void removeClient(){
        clients.remove(this);
        sendMessageToAll(new String[]{this.name , "SERVER: " + name +" покинул чат.", "all"});
    }

}
