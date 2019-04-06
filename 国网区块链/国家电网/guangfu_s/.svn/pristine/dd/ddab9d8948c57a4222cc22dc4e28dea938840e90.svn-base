package com.dh.guangfu.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.alibaba.fastjson.JSON;
import com.dh.utils.HttpRequest;

public class Server {
    private int port = 1720;
    private ServerSocket serverSocket;
    private ExecutorService executorService;
    private final int POOL_SIZE = 10;
    
    public Server() throws IOException {
        serverSocket = new ServerSocket(port);
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime()
                .availableProcessors() * POOL_SIZE);
        System.out.println("服务已启动");
    }

    public void service() {
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                executorService.execute(new Handler(socket));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Server().service();
    }

}
class Handler implements Runnable {
    
    public static final String CHARCODE = "utf-8";
    
    private  Socket socket;
    
    

    public Handler(Socket socket) {
        this.socket = socket;
    }

//    private PrintWriter getWriter(Socket socket) throws IOException {
//        OutputStream socketOut = socket.getOutputStream();
//        return new PrintWriter(socketOut, true);
//    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream socketIn = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(socketIn));
    }

    public void run() {
        BufferedReader br = null;
        OutputStreamWriter osw = null;
        HttpRequest h = new HttpRequest();
        String head = "HTTP/1.1 200 OK";
        String body = "";
        try {
            br = getReader(socket);
            osw = new OutputStreamWriter(socket.getOutputStream());
            String str = null;
            String msg = null;
            while (!(msg = br.readLine()).equals("null")) {
            	str += msg;
                System.out.println(this.hashCode()+":s1:" + msg);
            }
            System.out.println("Str+++"+str);
            String result = str.substring(str.indexOf("{"));
//            String result = "";
            Map maps = (Map)JSON.parse(result);
            if((Integer)maps.get("datatype") == 1){
            	String aa = maps.get("data").toString();
                String a = aa.substring(aa.indexOf("{"), aa.indexOf("]"));
                h.sendPost("http://127.0.0.1/ServerData/save", a);
                
                body+="\r\n";
                body+="\r\n{";
                body+="\r\n    \"result\":{";
                body+="\r\n    },";
                body+="\r\n    \"error\":null";
                body+="\r\n}";
                
                head+="\r\nDate: Tue, 14 Sep 1999 02:19:57 GMT";
                head+="\r\nServer: Apache/1.2.6";
                head+="\r\nConnection: close";
                head+="\r\nContent-Type: text/html";
                head+="\r\ncontent-length:"+body.length();
                head+="\r\n";
                head+="\r\n{";
                head+="\r\n    \"result\":{";
                head+="\r\n    },";
                head+="\r\n    \"error\":null";
                head+="\r\n}";
            	osw.write(head);
            	osw.flush();
            }else if((Integer)maps.get("datatype") == 2){
            	double ab = 0;
            	String s = maps.get("data").toString();
            	Map m = (Map)JSON.parse(s.substring(s.indexOf("{"), s.indexOf("]")));
            	String add = (String)m.get("address");
            	System.out.println("add+++++++++++++"+"{\"address\":\""+add+"\"}");
            	String string = h.sendPost("http://127.0.0.1/electricity/findByAddress","{\"buyAddress\":\""+add+"\"}");
            	Map back = (Map)JSON.parse(string);
            	if(200==(Integer)back.get("status")){
            		if(back.get("electricity")!=null&&back.get("electricity")!=""){
            			Map electricity = (Map)JSON.parse(back.get("electricity").toString());
            			ab = (Double)electricity.get("electricity");
            			if(2==(Integer)electricity.get("state")){
            				h.sendPost("http://127.0.0.1/electricity/save","{\"id\":"+electricity.get("id")+","+"\"state\":"+3+"}");
            			}else{
            				h.sendPost("http://127.0.0.1/electricity/save","{\"id\":"+electricity.get("id")+","+"\"state\":"+2+"}");
            			}
            		}
            	}

            	body+="\r\n";
            	body+="\r\n{";
            	body+="\r\n    \"result\":{";
            	body+="\r\n        \"value\":"+ab;
            	body+="\r\n    },";
            	body+="\r\n    \"error\":null";
            	body+="\r\n}";
            	body+="\r\n";
            	 head+="\r\nDate: Tue, 14 Sep 1999 02:19:57 GMT";
                 head+="\r\nServer: Apache/1.2.6";
                 head+="\r\nConnection: close";
                 head+="\r\nContent-Type: text/html";
                 head+="\r\ncontent-length:"+body.length();
                 head+="\r\n";
                 head+="\r\n{";
                 head+="\r\n    \"result\":{";
                 head+="\r\n        \"value\":"+ab;
                 head+="\r\n    },";
                 head+="\r\n    \"error\":null";
                 head+="\r\n}";
                 head+="\r\n";
                 
            	osw.write(head);
            	osw.flush();
            }
            
            System.out.println("客户端回复：" + maps);
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (osw != null) {
            	try {
					osw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        }
    }

    
}