package lesson5;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
                broadcastMessage(massageFromClient);
                //System.out.println(massageFromClient);
            } catch (IOException e){
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    private void broadcastMessage(String massageToSend) {
        for (var client: clients.entrySet()) {
            try {
                if (!client.getKey().equals(name)) {
                    client.getValue().bufferedWriter.write(massageToSend);
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
        broadcastMessage("SERVER: "+name+" покинул чат.");
    }

}
