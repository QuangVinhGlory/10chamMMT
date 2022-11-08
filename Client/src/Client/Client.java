package Client;

import java.io.*;  
import java.net.*;
import java.util.Scanner;  
public class Client {  
	public static void main(String[] args) {  
		try{      
			Socket s=new Socket("localhost",6666);  
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
			Scanner input = new Scanner(System.in);
			String cmd = input.nextLine();
			dout.writeUTF(cmd);  
			dout.flush();  
			input.close();
			dout.close();  
			s.close();  
		}catch(Exception e){System.out.println(e);}  
	}  
}  