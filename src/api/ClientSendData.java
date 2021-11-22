package api;
import java.net.*;
import java.io.*;

public class ClientSendData {
	  // initialize socket and input output streams
    private Socket socket            = null;
    OutputStreamWriter osw;
    // constructor to put ip address and port
    public ClientSendData(String address, int port, String msg)
    {
        // establish a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");
 
            OutputStream outputStream = socket.getOutputStream();
            // create a data output stream from the output stream so we can send data through it
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            System.out.println("Sending string to the ServerSocket");

            // write the message we want to send
            dataOutputStream.writeUTF(msg);
            dataOutputStream.flush(); // send the message
            dataOutputStream.close(); // close the output stream when we're done.
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
 
        // close the connection
        try
        {
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
 
    public static void main(String args[])
    {
        ClientSendData client = new ClientSendData("127.0.0.1", 5000, "Hi");
    }
}
