import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.net.*;

public class ClientFT {
  public static void main(String[] argv) throws Exception {
    Socket sock = new Socket(InetAddress.getLocalHost(), 1234);
    byte[] mybytearray = new byte[1024];
	int bytesRead;
    InputStream is = sock.getInputStream();
    FileOutputStream fos = new FileOutputStream("s2.txt");
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    while ((bytesRead = is.read(mybytearray, 0, mybytearray.length)) != -1){
		bos.write(mybytearray, 0, bytesRead);
	}
    bos.close();
    sock.close();
	System.out.println("File Received...");
  }
}
