package assessment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        int port = 3000; //default port 3000

        if(args.length > 0){
            port=Integer.parseInt(args[0]);
        }

        System.out.printf("Starting server on port %d\n",port);
        ServerSocket server = new ServerSocket(port);

        while(true){
        Socket sock = server.accept();
        System.out.println("Connection accepted");

        BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        String s;
        while((s= br.readLine())!=null){
            System.out.println(s);
            if(s.isEmpty()){
                break;
            }
         }

         OutputStream clientOutput = sock.getOutputStream();
            clientOutput.write("HTTP/1.1 200 OK\r\n" .getBytes());
            clientOutput.write("\r\n" .getBytes());
            clientOutput.write("<b> Hello world!</b>".getBytes());
            clientOutput.write("\r\n\r\n".getBytes());
            clientOutput.flush();
            clientOutput.close();
        }

        
      

        
    }
    
}
