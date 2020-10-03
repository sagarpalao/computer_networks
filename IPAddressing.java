import java.util.*;
import java.io.*;

public class IPAddressing {

    public static void main(String[] args) {
        Scanner scr=new Scanner(System.in);
        int i;
        System.out.println("Enter IP Address: ");
        String ipaddress=scr.nextLine();
        System.out.println("\n\n");
        String ipstr[]=ipaddress.split("\\.");
        
        int ip[]=new int[4];
        int dmask[]=new int[4];
        int start[]=new int[4];
        int end[]=new int[4];
        int cdmask[]=new int[4];
        
        if(ipstr.length==4){
            for(i=0;i<4;i++){
                ip[i]=Integer.parseInt(ipstr[i]);
                dmask[i]=0;
            }
        }
        
        if(ip[0]>255 || ip[1]>255 || ip[2]>255 || ip[3]>255 || ipstr.length!=4){
            System.out.println("Invalid IP Address");
        }
        else{
            
            if(ip[0]>=0 && ip[0]<=127){
                
                System.out.println("Class: A");
                dmask[0]=255;
                System.out.print("Default Mask: ");
                for(i=0;i<4;i++){
                    System.out.print(dmask[i]);
                    if(i!=3){
                        System.out.print(".");
                    }
                }
                System.out.println();
                System.out.print("Start block: ");
                for(i=0;i<4;i++){
                    start[i]=(ip[i]&dmask[i]);
                    System.out.print(start[i]);
                    if(i!=3){
                        System.out.print(".");
                    }
                }
                System.out.println();
                System.out.print("End block: ");
                for(i=0;i<4;i++){
                    if(dmask[i]==255){
                        cdmask[i]=0;
                    }
                    else{
                        cdmask[i]=255;
                    }
                }
                for(i=0;i<4;i++){
                    end[i]=(ip[i]|cdmask[i]);
                    System.out.print(end[i]);
                    if(i!=3){
                        System.out.print(".");
                    }
                }
                System.out.println();
            }
            else if(ip[0]>=128 && ip[0]<=191){
                System.out.println("Class: B");
                dmask[0]=255;
                dmask[1]=255;
                System.out.print("Default Mask: ");
                for(i=0;i<4;i++){
                    System.out.print(dmask[i]);
                    if(i!=3){
                        System.out.print(".");
                    }
                }
                System.out.println();

                System.out.print("Start block: ");
                for(i=0;i<4;i++){
                    start[i]=(ip[i]&dmask[i]);
                    System.out.print(start[i]);
                    if(i!=3){
                        System.out.print(".");
                    }
                }
                System.out.println();

                System.out.print("End block: ");
                for(i=0;i<4;i++){
                    if(dmask[i]==255){
                        cdmask[i]=0;
                    }
                    else{
                        cdmask[i]=255;
                    }
                }
                for(i=0;i<4;i++){
                    end[i]=(ip[i]|cdmask[i]);
                    System.out.print(end[i]);
                    if(i!=3){
                        System.out.print(".");
                    }
                }
                
            }
            else if(ip[0]>=192 && ip[0]<=223){
                System.out.println("Class: C");
                dmask[0]=255;
                dmask[1]=255;
                dmask[2]=255;
                System.out.print("Default Mask: ");
                for(i=0;i<4;i++){
                    System.out.print(dmask[i]);
                    if(i!=3){
                        System.out.print(".");
                    }
                }
                System.out.println();
               
                System.out.print("Start block: ");
                for(i=0;i<4;i++){
                    start[i]=(ip[i]&dmask[i]);
                    System.out.print(start[i]);
                    if(i!=3){
                        System.out.print(".");
                    }
                }
                System.out.println();
               
                System.out.print("End block: ");
                for(i=0;i<4;i++){
                    if(dmask[i]==255){
                        cdmask[i]=0;
                    }
                    else{
                        cdmask[i]=255;
                    }
                }
                for(i=0;i<4;i++){
                    end[i]=(ip[i]|cdmask[i]);
                    System.out.print(end[i]);
                    if(i!=3){
                        System.out.print(".");
                    }
                }
                
            }
            else if(ip[0]>=224 && ip[1]<=239){
                System.out.println("Class: D");
            }
            else if(ip[0]>=240 && ip[0]<=255){
                System.out.println("Class: E");
            }
        }
    }
    
}
