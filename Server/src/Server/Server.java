package Server;

import java.io.*;  
import java.net.*;  
public class Server {  
	
	public static void shutdown() throws RuntimeException, IOException {
	    String shutdownCommand;
	    String operatingSystem = System.getProperty("os.name");

	    if ("Linux".equals(operatingSystem) || "Mac OS X".equals(operatingSystem)) {
	        shutdownCommand = "shutdown -h now";
	    }
	    // This will work on any version of windows including version 11 
	    else if (operatingSystem.contains("Windows")) {
	        shutdownCommand = "shutdown.exe -s -t 0";
	    }
	    else {
	        throw new RuntimeException("Unsupported operating system.");
	    }

	    Runtime.getRuntime().exec(shutdownCommand);
	    System.exit(0);
	}
	
	public static void main(String[] args){  
		try{  
			ServerSocket ss=new ServerSocket(6666);  
			Socket s=ss.accept();//establishes connection   
			DataInputStream dis=new DataInputStream(s.getInputStream());  
			String  str=(String)dis.readUTF();  
			System.out.println("message= "+str);  
			if (str.equals("shutdown")) 
				{
					System.out.println("Received message");
					shutdown();
				}
			ss.close();  
		}catch(Exception e){System.out.println(e);}  
	}  
}