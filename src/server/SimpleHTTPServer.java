package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleHTTPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ...");
        while (true) {
            try (Socket socket = server.accept()){
                Date today = new Date();
                String httpsResponse = "HTTP/1.1 200 ok\r\n\r\n" + today;
                socket.getOutputStream().write(httpsResponse.getBytes("UTF-8"));
            }
        }
    }
}
