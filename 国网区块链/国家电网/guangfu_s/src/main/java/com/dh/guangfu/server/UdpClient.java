package com.dh.guangfu.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;  
  
    public class UdpClient{  
          
         public static void main(String args[])throws Exception{  
           
             new UdpClient().lanchApp();  
         }  
           
         private void lanchApp(){  
             receiveThread th=new receiveThread();  
                th.start();  
            }  
           
         private class receiveThread extends Thread{  
             @Override  
                public void run() {  
                    while(true){  
                        try {  
                            Thread.sleep(1000);  
                        } catch (InterruptedException e) {  
                            e.printStackTrace();  
                        }  
                        try {  
                            receiveIP();  
                        } catch (Exception e) {  
                            e.printStackTrace();  
                        }  
                    }  
             }  
               
            private void receiveIP() throws Exception{  
                 DatagramSocket dgSocket=new DatagramSocket(1725);  
                  byte[] by=new byte[1024];  
                  DatagramPacket packet=new DatagramPacket(by,by.length);  
                  dgSocket.receive(packet);  
                    
                  String str=new String(packet.getData(),0,packet.getLength());  
                    
                  System.out.println("接收到数据大小:"+str.length());  
                  System.out.println("接收到的数据为："+str);  
                  dgSocket.close();  
                  System.out.println("recevied message is ok.");  
             }  
         }  
  
               
    }  