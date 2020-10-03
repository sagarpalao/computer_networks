import java.util.Scanner;

public class CheckSum {

    public static void main(String...args){

        int data[][]=new int[10][7];
        int rdata[][]=new int[10][7];
        int sum[]=new int[7];
        int temp[]=new int[7];
        int n,i,x,j,carry;
        
        Scanner src=new Scanner(System.in);
        
        System.out.println("--------------------SENDER'S SIDE--------------------\n");
        System.out.print("Enter no. of datawords to send: ");
        n=src.nextInt();
        
        System.out.println("Enter data words:");
        for(i=0;i<n;i++){
            for(j=3;j>=0;j--){
                data[i][j]=src.nextInt();
            }
            
        }
        
        for(i=0;i<7;i++)
            sum[i]=data[0][i];
        
        for(i=1;i<n;i++){
            carry=0;
            for(j=0;j<7;j++){
                x=(sum[j]+data[i][j]+carry);
                
                if(x >= 2){
                    carry=1;
                    sum[j]=x%2;
                }
                else{
                    carry=0;
                    sum[j]=x%2;
                }
            }
        
        }
      
        while(true){
            for(i=6;i>=4;i--){
                if(sum[i]==1){
                    break;
                }
            }
            if(i==3){
                break;
            }
            
            
            for(i=0,j=4;i<=3&&j<=6;i++,j++){
                temp[i]=sum[j];
                sum[j]=0;
            }
            for(i=3;i<7;i++){
                temp[i]=0;
            }
           
            carry=0;
            for(j=0;j<7;j++){
                x=(sum[j]+temp[j]+carry);
                
                if(x >= 2){
                    carry=1;
                    sum[j]=x%2;
                }
                else{
                    carry=0;
                    sum[j]=x%2;
                }
            }
            
        }
        for(i=0;i<7;i++){
            if(sum[i]==0)
                sum[i]=1;
            else
                sum[i]=0;
        }
        
        System.out.println("\nComputed Checksum: ");
        for(i=3;i>=0;i--){
            System.out.print(sum[i]+" ");
        }
        
        
        System.out.println("\n\n--------------------RECEIVERS'S SIDE--------------------\n");
        
        System.out.println("Enter data words received: ");
        for(i=0;i<n+1;i++){
            for(j=3;j>=0;j--){
                rdata[i][j]=src.nextInt();
            }
        }
        
        for(i=0;i<7;i++)
            sum[i]=rdata[0][i];
        
        for(i=1;i<n+1;i++){
            carry=0;
            for(j=0;j<7;j++){
                x=(sum[j]+rdata[i][j]+carry);
                
                if(x >= 2){
                    carry=1;
                    sum[j]=x%2;
                }
                else{
                    carry=0;
                    sum[j]=x%2;
                }
            }
        
        }
        
        while(true){
            for(i=6;i>=4;i--){
                if(sum[i]==1){
                    break;
                }
            }
            if(i==3){
                break;
            }
            
            
            for(i=0,j=4;i<=3&&j<=6;i++,j++){
                temp[i]=sum[j];
                sum[j]=0;
            }
            for(i=3;i<7;i++){
                temp[i]=0;
            }
             
            carry=0;
            for(j=0;j<7;j++){
                x=(sum[j]+temp[j]+carry);
                
                if(x >= 2){
                    carry=1;
                    sum[j]=x%2;
                }
                else{
                    carry=0;
                    sum[j]=x%2;
                }
            }
            
        }
  
        for(i=0;i<7;i++){
            if(sum[i]==0)
                sum[i]=1;
            else
                sum[i]=0;
        }
        
        System.out.println("\nReceiver Computed Syndrome:");
        for(i=3;i>=0;i--){
            System.out.print(sum[i]+" ");
        }
        
        if(sum[0]==0 && sum[1]==0 && sum[2]==0 && sum[3]==0){
            System.out.println("\n\nNo Error Detected !");
        }
        else{
            System.out.println("\n\nData Received is Errant !");
        }
    }
}
