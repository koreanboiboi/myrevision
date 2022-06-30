package workshop4.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        String serverPort = args[0];
        String cookieFilePath = args[1];
        
        try{
            System.out.printf("Cookie Server started at %s\n", serverPort);

            ServerSocket server = new ServerSocket(Integer.parseInt(serverPort));
            Socket sock = server.accept();
            InputStream is = sock.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            OutputStream os = sock.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            String requestFromClient = dis.readUTF();
            System.out.printf("Received request from client : %s\n", requestFromClient);

            if(requestFromClient.equals("get-cookie")){
                System.out.printf("file -> %s\n", cookieFilePath);
                String randomCookie = Cookie.getRandomCookie(cookieFilePath);
                System.out.println(randomCookie);
                dos.writeUTF("cookie-text "+randomCookie);
            } else{
                dos.writeUTF("Invalid command !");
            }
            is.close();
            os.close();
            sock.close();

        }catch(NumberFormatException e){
            e.printStackTrace();

        }catch(IOException e){
            e.printStackTrace();
        }
   
    }

    
}
