import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.net.*;

public class ServerFTUDP {
  public static void main(String[] argv) throws Exception {
    DatagramSocket sock = new DatagramSocket(12346);
    
	byte[] mybytearray = new byte[1024];
	int bytesRead;
    FileOutputStream fos = new FileOutputStream("s2.txt");
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    while(true){
		DatagramPacket p1=new DatagramPacket(mybytearray,0,mybytearray.length);
		sock.receive(p1);
		if(new String(p1.getData(),0,p1.getLength()).trim().equals("done"))
			break;
		bos.write(p1.getData(), 0, p1.getLength());
	}
    bos.close();
	System.out.println("File Received...");
  }
}
