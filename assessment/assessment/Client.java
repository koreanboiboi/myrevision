package assessment;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client 
{
    public static void main( String[] args ) throws IOException {
        String host = "localhost";
        int port = 3000;
        if (args.length >= 2) {
            host = args[0];
            port = Integer.parseInt(args[1]);
        } else if (args.length == 1) 
            port = Integer.parseInt(args[0]);
            
            Socket sock = new Socket(host,port);
            System.out.println("Connected to server");

            OutputStream clientOutput = sock.getOutputStream();
            clientOutput.write("HTTP/1.1 200 OK\r\n" .getBytes());
            clientOutput.write("\r\n" .getBytes());
            clientOutput.write("<b> Hello world!</b>".getBytes());
            clientOutput.write("\r\n\r\n".getBytes());
            clientOutput.flush();
            clientOutput.close();

            
    }
}
