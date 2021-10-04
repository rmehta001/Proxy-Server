/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

import java.net.*;
import java.io.*;

public class HW1Server {
    public static void main(String[] args) throws IOException {
        
        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }
        System.out.println("Server Port number is:-- " +args[0]);
        int portNumber = Integer.parseInt(args[0]);
        System.out.println("Ready to accept connection from client");
        try{
            ServerSocket serverSocket =
                new ServerSocket(portNumber);
            //System.out.println("Connect");

	    while(true){
              Socket clientSocket = serverSocket.accept();     
              ClientWorker w=new ClientWorker(clientSocket);
              Thread t=new Thread(w);
              t.start();
              System.out.println("Thread Assigned to current client");
	    }
        
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}

class ClientWorker implements Runnable {
  private Socket client;

//Constructor
  ClientWorker(Socket client) {
    this.client = client;
  }

  public void run(){
	  System.out.println("Thread Started");
    String line;
    BufferedReader in = null;
    PrintWriter out = null;
    try{
      in = new BufferedReader(new 
        InputStreamReader(client.getInputStream()));
      out = new 
        PrintWriter(client.getOutputStream(), true);
		//System.out.println("Replying to client");
    } catch (IOException e) {
      System.out.println("in or out failed");
      System.exit(-1);
    }

    while(true){
      try{
        line = in.readLine();
        line=line.substring(4,line.length());
        System.out.println(line);
        line = "http://"+line;
        //URL url = new URL(line);
        //String[] lineArr = line.split("/");
        //System.out.println("The url provided by the client is "+lineArr[0]);
        //System.out.println("The file requested is "+lineArr[1]);
        //String host = lineArr[0]+"/"+lineArr[1]+"/"+lineArr[2];
        //String host="";
        //String fileName="";
        /*System.out.println(lineArr.length+"hey there");
        for(int i=0;i<(lineArr.length)-1;i++)
        {
        	System.out.println(lineArr[i]+"hiiii");
        host=host+lineArr[i]+"/";
        
        }*/
        //System.out.println(host);
        //host=host.substring(0, host.length()-1);
        //fileName = lineArr[(lineArr.length)-1];
       // fileName ="Summary.html";
        //host = "info.cern.ch";
         //= lineArr[0];
        //String fileName = lineArr[1];
        //System.out.println("The url provided by the client is "+host);
        //System.out.println("The file requested is "+fileName);
URL url = new URL(line);
//url.setURLStreamHandlerFactory(fac);
        try  {
        	  // open the url stream, wrap it an a few "readers"
        	    
        	    String[] lineArr = line.split("/");
        	    System.out.println("hi 1");
        	    File file1 = new File("proxy-"+lineArr[(lineArr.length)-1]);
        	    file1.createNewFile();
        	    System.out.println("hi 2");
        	    FileWriter fileW = new FileWriter(file1);
        	    // write the output to stdout
        	    System.out.println("hi 3");
        	    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        	    System.out.println(reader);
        	    out.println("raj mehta");
        	    String line1;
        	    
        	    while ((line1 = reader.readLine()) != null)
        	    {
        	      System.out.println(line1);
        		  	out.println(line1);
        		    
        		  	//Socket proxySocket = new Socket();
        		  	//PrintWriter out1 = null;
            	    //out1 = new PrintWriter(proxySocket.getOutputStream(),true);
            	    //out1.println(line1);
        		  	fileW.write(line1);
        	    }
        	    
        	    
        	    fileW.flush();
        	    fileW.close();
        	   // proxySocket.close();
        	    // close our reader
        	   
        	    reader.close();	

//try  {
  // open the url stream, wrap it an a few "readers"
    //BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

    // write the output to stdout
    //String line1;
	//InetAddress adr;
	//Socket proxySocket = new Socket();
    //InetSocketAddress is;
	//proxySocket.connect(new InetSocketAddress(host,80),10000);
    ///PrintWriter out1 = null;
   /// out1 = new PrintWriter(proxySocket.getOutputStream(),true);
    //out1.println("GET "+fileName+" HTTP/1.0"); 
//	BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(proxySocket.getOutputStream(), "UTF8"));
//	wr.write("GET "+"/index.html"+" HTTP/1.0rn");
//	wr.write("Content-Type: text/htmlrn");
//	wr.write("Content-Type: text/htmlrn");
    //out1.println("Host: "+host);
    //out1.println("Connection: Close");
    //out1.println("");
    
   // System.out.println("Request Sent\n");
    //File file1 = new File("proxy-"+fileName);
   // file1.createNewFile();
    //FileWriter fileW = new FileWriter(file1);
    
//    BufferedReader in1 = new BufferedReader(new InputStreamReader(proxySocket.getInputStream()));
	//String remoteServerLine="";
	
    //while ((remoteServerLine = in1.readLine()) != null)
   // {
     // System.out.println(remoteServerLine);
      //fileW.write(remoteServerLine);
         
      //fileW.flush(); 
    ///}
    //fileW.flush();
    //fileW.close();  
    // close our reader
    
//    out1.close();
    //in1.close();
    //out.close();
    //in.close();
    //proxySocket.close();
    //client.close();
}

 catch (IOException e) {
    // handles IO exceptions
	System.out.println("Html I/O error!! "+e);
      
}
       }catch (IOException e1) {
        System.out.println("Read failed"+e1);
        System.exit(-1);
       }
    }
  }
}