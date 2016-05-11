package mobile.tiy.chatclientandroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Godfather on 5/11/2016.
 */
public class AndroidChatClient {

    String serverResponse;

    String sendMessage(String incomingString) {

        try {

            Socket clientSocket = new Socket("172.168.4.13", 8005);

            // send out to server
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            // receive in from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // send to server
            out.println(incomingString);

            String serverResponse;
            while (true) {
                serverResponse = in.readLine();

                if (serverResponse != null && serverResponse.equalsIgnoreCase("end-transmission")) {
                    break;
                }
                System.out.println(serverResponse);
                return serverResponse;
            }

        } catch (IOException ioException) {

        }
        return null;
    }
}
