package com.dh.guangfu.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;  
  
  
public class UdpServer {  
  
    public static void main(String args[]) {  
        new UdpServer().lanchApp();  
     }  
      
    private void lanchApp(){  
        SendThread th=new SendThread();  
        th.start();  
    }  
      
      
    private class SendThread extends Thread{  
        @Override  
        public void run() {  
            while(true){  
                try {  
                    Thread.sleep(1000);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
                try {  
                    BroadcastIP();  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
          
        private void BroadcastIP()throws Exception{  
             DatagramSocket dgSocket=new DatagramSocket();  
              byte b[]="小哥，收到没？？？？？？".getBytes();  
              DatagramPacket dgPacket=new DatagramPacket(b,b.length,InetAddress.getByName("192.168.1.255"),1721);  
              dgSocket.send(dgPacket);  
              dgSocket.close();  
              System.out.println("send message is ok.");  
        }  
    }  
      
}  