import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.*;

public class ClientFTUDP {
  public static void main(String[] args) throws IOException {
    DatagramSocket servsock = new DatagramSocket(12345);
    File myFile = new File("s.txt");		
      byte[] mybytearray = new byte[(int) myFile.length()];
      BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
      bis.read(mybytearray, 0, mybytearray.length);
	  int sendlength=0;
	  DatagramPacket p1; 
	  System.out.println(mybytearray.length);
      while(sendlength<(mybytearray.length)){
		  p1=new DatagramPacket(mybytearray,sendlength,mybytearray.length,InetAddress.getLocalHost(),12346);
		  sendlength+=1023;
		  servsock.send(p1);
	  }
	  String msg="done\n";
	  mybytearray=msg.getBytes();
	  p1=new DatagramPacket(mybytearray,0,mybytearray.length,InetAddress.getLocalHost(),12346);
	  servsock.send(p1);

	  System.out.println("File Sent...");
	  
  }
}
