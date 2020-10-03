import java.io.*;
import java.util.Scanner;

public class CyclicRedundancyCheck {
    
    public static void main(String...args){

        int data[]=new int[7];
        int rdata[]=new int[7];
        int div[]={1,0,1,1};
        int par[]=new int[4];
        Scanner src=new Scanner(System.in);
        int i,j,x;
        
        System.out.println("--------------------SENDER'S SIDE--------------------\n");
        System.out.println("\nEnter Data To Send: ");
        for(i=0;i<4;i++){
            data[i]=src.nextInt();    
        }
        for(i=4;i<7;i++){
            data[i]=0;
        }
        
        for(i=0;i<4;i++)
            par[i]=data[i];
        
        for(i=0;i<4;i++){
            if(par[0]==1){
                for(j=0;j<4;j++){
                    par[j]=par[j]^div[j];
                }
                for(j=0;j<3;j++)
                    par[j]=par[j+1];
                
                if(i<=2)
                    par[3]=data[i+4];
            }
            else{
                for(j=0;j<3;j++)
                    par[j]=par[j+1];
                
                if(i<=2)
                    par[3]=data[i+4];
            }
           
        }
        
        for(i=0,j=4;i<3&&j<7;i++,j++){
            data[j]=par[i];
        }
        
        System.out.println("\n\nSender Generated Codeword: ");
        for(i=0;i<7;i++){
            System.out.print(data[i]+" ");
        }
        
        System.out.println("\n\n--------------------RECEIVERS'S SIDE--------------------\n");
        
        System.out.println("\nEnter Received Data: ");
         for(i=0;i<7;i++){
            rdata[i]=src.nextInt();    
        }
        
        for(i=0;i<4;i++)
            par[i]=rdata[i];
        
        for(i=0;i<4;i++){
            if(par[0]==1){
                for(j=0;j<4;j++){
                    par[j]=par[j]^div[j];
                }
                for(j=0;j<3;j++)
                    par[j]=par[j+1];
                
                if(i<=2)
                    par[3]=rdata[i+4];
            }
            else{
                for(j=0;j<3;j++)
                    par[j]=par[j+1];
                
                if(i<=2)
                    par[3]=rdata[i+4];
            }
        } 
        
        System.out.println("\nSyndrome Computed:");
        System.out.println(par[0]+" "+par[1]+" "+par[2]);
                
        if(par[0]==0 && par[1]==0 && par[2]==0){
            System.out.println("\nReceived Data is not Errant !");
        }
        else{
            System.out.println("\nReceived Word is Errant !");
        }
    }
    
}
