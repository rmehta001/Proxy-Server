import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class HW1Client 
{
    public static void main(String[] args) throws IOException {
        
        if (args.length != 2) {
            System.err.println(
                "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try (
            Socket echoSocket = new Socket(hostName, portNumber);
            
        		PrintWriter out =
                new PrintWriter(echoSocket.getOutputStream(), true);
        		
        		
            BufferedReader stdIn =
                new BufferedReader(
                    new InputStreamReader(System.in))
					
        ) 
        {
        	System.out.println(echoSocket);
        	System.out.println(out);
        	System.out.println("Type the target file URL: ");
            String userInput;
            while ((userInput = stdIn.readLine()) != null) 
            {
            	if(userInput.isEmpty()) 
            	{
            		System.exit(0);
            	}
            	System.out.println(userInput);
                out.println(userInput);
                File file2 = new File("localFile.html");
                file2.createNewFile();
                FileWriter fileW2 = new FileWriter(file2);            
                String line2;
                //while ((line2 = in.readLine()) != null)
                //
                System.out.println(echoSocket);
                BufferedReader in =
                        new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
                System.out.println(echoSocket.getInputStream()+"RAJ MEHTA");
                //in.readLine()
                    line2 = in.readLine();
                    //System.out.println(line2);
                    while ((line2 = in.readLine()) != null)
                    {
                    System.out.println(line2);
                    //System.out.println("rajmehta001");
                	System.out.println(line2);
                    fileW2.write(line2);
                    
                    }
                fileW2.flush();
                fileW2.close();
           }
          
           /* static JFrame f; 

        	static JProgressBar b; 

        	public static void main(String args[]) 
        	{ 

        		 
        		f = new JFrame("Hi this is the progress bar for downloading the file"); 

        		 
        		JPanel p = new JPanel(); 
        		System.out.println("starting the progress bar"); 
        		b = new JProgressBar(); 
        		b.setValue(0); 
        		b.setStringPainted(true); 
        		p.add(b); 
        		f.add(p);  
        		f.setSize(500, 500); 
        		f.setVisible(true); 
        		fill(); 
        	} 

        	 
        	public static void fill() 
        	{ 
        		int i = 0; 
        		try { 
        			while (i <= 100) { 
        				 
        				b.setValue(i + 10); 

        				// delay the thread 
        				Thread.sleep(1000); 
        				i += 20; 
        			} 
        		} 
        		catch (Exception e) { 
        		} 
        	} 
        }*/
                    }  
         catch (UnknownHostException e) {
	            System.err.println("Don't know about host " + hostName);
	            System.exit(1);
	        } catch (IOException e) {
	            System.err.println("Couldn't get I/O for the connection to " +
	                hostName);
	            System.exit(1);
        } 
    }
}