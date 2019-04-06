 package com.dh.guangfu.server;
import java.net.*;
import java.io.*;
public class Server2 extends Thread
{
    private Socket socket;
    public void run()
    {
        try
        {
            InputStreamReader isr = new InputStreamReader(socket
                            .getInputStream());
            BufferedReader br = new BufferedReader(isr);
            OutputStreamWriter osw = new OutputStreamWriter(socket
                            .getOutputStream());
            String s = "";
            while (!(s = br.readLine()).equals("null")){
            	System.out.println("收到消息是"+s);
            }
            osw.write("HTTP/1.1 200 OK\r\n\r\n");
            
            osw.write("接收消息");
            osw.flush();
            socket.close();
        }
        catch (Exception e)
        {
        	
        }
    }
    public Server2(Socket socket)
    {
        this.socket = socket;
    }
    public static void main(String[] args) throws Exception
    {
        ServerSocket serverSocket = new ServerSocket(1720);
        System.out.println("服务器已经启动，端口：1720");
        while (true)
        {
            Socket socket = serverSocket.accept();
            new Server2(socket).start();
        }
    }
}