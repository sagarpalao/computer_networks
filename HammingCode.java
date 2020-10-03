import java.io.*;
import java.util.*;

class HammingCode{
	
	public static void main(String ... args){
		
		Scanner src=new Scanner(System.in);
		
		System.out.println("Enter Data Word: ");
		
		int i,j;
		int a[]=new int[4];
		int r[]=new int[3];
		int c[]=new int[7];
		int s[]=new int[3];
		int b[]=new int[7];
		
		for(i=0;i<4;i++){
			a[i]=Integer.parseInt(src.next());
		}
		
		r[2]=(a[3]+a[2]+a[1])%2;
		r[1]=(a[0]+a[1]+a[2])%2;
		r[0]=(a[0]+a[2]+a[3])%2;
		
		for(i=0;i<4;i++){
			c[i]=a[i];
		}
		for(i=4,j=0;i<7 && j<3;i++,j++){
			c[i]=r[j];
		}
		
		System.out.println("\n\nSender Generated Codeword: ");
		System.out.println("\n a3\ta2\ta1\ta0\tr2\tr1\tr0\n");
		for(i=0;i<7;i++){
			System.out.print(c[i]+"\t");
		}
		
		System.out.println("\n\nEnter Received Word: ");
		for(i=0;i<7;i++){
			b[i]=Integer.parseInt(src.next());
		}
		
		s[2]=(b[1]+b[2]+b[3]+b[6])%2;
		s[1]=(b[0]+b[1]+b[2]+b[5])%2;
		s[0]=(b[2]+b[3]+b[0]+b[4])%2;
		
		System.out.println("\n\nSyndrome Computed:");
		System.out.println("\ns2\ts1\ts0\t");
		for(i=0;i<3;i++){
			System.out.print(s[i]+"\t");
		}
		
		System.out.println("\n\n");
		if(s[0]==0&&s[1]==0&&s[2]==0)
			System.out.println("No Error");
		else if(s[0]==0&&s[1]==0&&s[2]==1)
			System.out.println("Error bit : q0");
		else if(s[0]==0&&s[1]==1&&s[2]==0)
			System.out.println("Error bit : q1");
		else if(s[0]==0&&s[1]==1&&s[2]==1)
			System.out.println("Error bit : b2");
		else if(s[0]==1&&s[1]==0&&s[2]==0)
			System.out.println("Error bit : q2");
		else if(s[0]==1&&s[1]==0&&s[2]==1)
			System.out.println("Error bit : b0");
		else if(s[0]==1&&s[1]==1&&s[2]==0)
			System.out.println("Error bit : b3");
		else if(s[0]==1&&s[1]==1&&s[2]==1)
			System.out.println("Error bit : b1");
	}
}