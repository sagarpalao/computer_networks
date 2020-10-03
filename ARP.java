import java.util.*;

public class ARP {

   public static void main(String[] args) {

       String temp;
       int ch;

       String resolution[][]={
           {"192.168.44.1","08:00:69:02:01:FC"},
           {"10.40.108.96","B0:83:FE:73:4B:7E"},
           {"10.40.104.88","A0:74:DE:83:3A:8F"},
           {"192.168.0.144","78:A0:FE:90:AE:9D"},
           {"10.80.96.28","78:A0:FE:73:4B:7E"},
           {"10.80.0.144","02:01:FC:B0:83:FE"},
           {"10.90.68.114","01:FC:B0:73:4B:7E"}};

       int i;
       System.out.println("1.ARP\n2.RARP");
       Scanner ip=new Scanner(System.in);
       System.out.println("Enter your choice");
       ch=ip.nextInt();
       switch(ch)
       {
         case 1:
               System.out.println("Enter an ip Address:");
               temp=ip.next();
               for(i=0;i<7;i++)
               {
                   if((resolution[i][0]).equals(temp))
                   {
                       break;
                   }
               }
               if(i<7)
               {
                   System.out.println("Physical Address:"+resolution[i][1]);
               }
               else
               {
                   System.out.println("Invalid Address");
               }
               break;
           case 2:
               System.out.println("Enter Physical Address:");
               temp=ip.next();
               for(i=0;i<7;i++)
               {
                   if((resolution[i][1]).equals(temp))
                   {
                       break;
                   }
               }
               if(i<7)
               {
                   System.out.println("IP Address:"+resolution[i][0]);
               }
               else
               {
                   System.out.println("Invalid Address");
               }
       }
       }
   }
