import java.io.*;
import java.util.*;

public class BitByteStuffing {

    public static void main(String[] args) {
        
        int data[][]=new int[20][8];
        int data2[]=new int[30];
        int frame2[]=new int[50];
        int frame[][]=new int[20][8];
        int i,n,j,x,ch;
        int flag[]={0,1,1,1,1,1,1,0};
        int escape[]={1,1,1,1,1,1,1,1};
        int cnt;
        
        System.out.print("Escape: ");
        for(i=0;i<8;i++){
            System.out.print(escape[i]);
        }
        System.out.print("\nFlag: ");
        for(i=0;i<8;i++){
            System.out.print(flag[i]);
        }     
        System.out.println("\n-----------------Sender-------------------------");
        Scanner scr=new Scanner(System.in); 
        System.out.println("Enter Framing Method:\n1.Byte Stuffing\n2.Bit Stuffing ");
        ch=scr.nextInt();
        
        switch(ch){
            
            case 1:
                System.out.println("Enter no. of characters: ");
                n=scr.nextInt();
                System.out.println("Enter Data to send in a frame: ");
        
                for(i=0;i<n;i++){
                    for(j=0;j<8;j++){
                        data[i][j]=scr.nextInt();
                    }
                }

                cnt=0;
                for(i=0;i<8;i++){
                    frame[cnt][i]=flag[i];
                }
                cnt++;
                for(i=0;i<n;i++){
                    
                    for(j=0;j<8;j++){
                        if(data[i][j]!=flag[j]){
                            break;
                        }
                    }
                    if(j==8){
                        for(x=0;x<8;x++){
                            frame[cnt][x]=escape[x];
                        }
                        cnt++;
                        for(x=0;x<8;x++){
                            frame[cnt][x]=data[i][x];
                        }
                        cnt++;
                    }
                    else{
                        for(j=0;j<8;j++){
                            if(data[i][j]!=escape[j]){
                                break;
                            }
                        }
                        if(j==8){
                            for(x=0;x<8;x++){
                                frame[cnt][x]=escape[x];
                            }
                            cnt++;
                            for(x=0;x<8;x++){
                                frame[cnt][x]=data[i][x];
                            }
                            cnt++;
                        }
                        else{
                            for(x=0;x<8;x++){
                                frame[cnt][x]=data[i][x];
                            }
                            cnt++;
                        }
                    }
                }

                for(i=0;i<8;i++){
                    frame[cnt][i]=flag[i];
                }
                cnt++;       
                System.out.println("\nSender Generated Frame (after byte stuffing):");
                for(i=0;i<cnt;i++){
                    for(j=0;j<8;j++){
                        System.out.print(frame[i][j]);
                    }
                    System.out.print("\t");
                }
                System.out.println("\n\n-----------------Receiver-------------------------\n");
                System.out.println("Receiver received frame (with byte stuffing):");
                for(i=0;i<cnt;i++){
                    for(j=0;j<8;j++){
                        System.out.print(frame[i][j]);
                    }
                    System.out.print("\t");
                }
                System.out.println("\n\nReciver interpreted data (by eliminating flags and stuffing):");
                for(i=0;i<n;i++){
                    for(j=0;j<8;j++){
                        System.out.print(data[i][j]);
                    }
                    System.out.print("\t");
                }
                System.out.println();
            break;

            case 2:
               System.out.println("Enter length of bit stream: ");
               n=scr.nextInt();
               System.out.println("Enter data to send as a bit stream: ");
               for(i=0;i<n;i++){
                   data2[i]=scr.nextInt();
               }
               
               cnt=0;
               for(i=0;i<8;i++){
                    frame2[cnt]=flag[i];
                    cnt++;
               }
               
               int q=0;
               for(i=0;i<n;i++){
                   if(data2[i]==1){
                       q++;
                       frame2[cnt]=data2[i];
                       cnt++;
                   }
                   else{
                       q=0;
                       frame2[cnt]=data2[i];
                       cnt++;
                   }
                   if(q==5){
                       frame2[cnt]=0;
                       cnt++;
                       q=0;
                   }
               
               }
               for(i=0;i<8;i++){
                    frame2[cnt]=flag[i];
                    cnt++;
               }
               System.out.println("\nSender Generated Frame (after bit stuffing):");
               for(i=0;i<cnt;i++){
                   if(i==8){
                       System.out.print(" ");
                   }
                   if(i==cnt-8){
                       System.out.print(" ");
                   }
                   System.out.print(frame2[i]);
               }
               System.out.println("\n\n-----------------Receiver-------------------------\n");
               System.out.println("Receiver received frame (with bit stuffing):");
                for(i=0;i<cnt;i++){
                    if(i==8){
                       System.out.print(" ");
                   }
                   if(i==cnt-8){
                       System.out.print(" ");
                   }
                    System.out.print(frame2[i]);
                }
                System.out.println("\n\nReciver interpreted data (by eliminating flags and stuffing):");
                
                for(i=0;i<n;i++){
                    System.out.print(data2[i]);
                }
                System.out.println();
            break;
        }
        
    }
}
