import java.util.*;
public class s3b017015_1022_HW_01 {
    public static void main(String[] args) {
        double[] date={15.5,30,105,75.5,60,45,30,90.5,30,68.5,60,30};
        double MaxNum = date[0],MinNum = date[0];
        double median;
        double maxValue = -1.0d;
        int maxCount = 0;
        Arrays.sort(date);
        int t=date.length;
        Scanner sc= new Scanner(System.in);
        System.out.println("plz neter what you want ?");
        System.out.println("1---is Maximum number   2---is Miniumu number  3---is median");
        System.out.println("4---is mode             5---is The average     6---is standard deviation");
        System.out.println("7---Quartile            8---IQR                9---All");
        double A;
        A = sc.nextInt();
        for(double j:date){
            if(j>MaxNum)
            MaxNum=j;
        }
        for(double i:date){
            if(i<MinNum)
            MinNum=i;
        }
        if (date.length % 2 == 0){
            median = ((double)date[date.length/2] + (double)date[date.length/2 - 1])/2;
        } else {
            median = (double)date[(date.length)/2];
        }
        for(int i=0;i<date.length; ++i) {
            double currentValue = date[i];
            int currentCount = 1;
            for (int j = i + 1; j < date.length; ++j) {
                int epsilon=12;
                if (Math.abs(date[j] - currentValue) <epsilon) {
                    ++currentCount;
                }
            }
            if (currentCount > maxCount){
                maxCount = currentCount;
                maxValue = currentValue;
            } else if (currentCount == maxCount) {
                maxValue = Double.NaN;
            }
        }
        double total = 0;
        for(int i=0; i<date.length; i++){
        	total = total + date[i];
        }
        double average = total / date.length;
        double n=5,sum=0,mean;
        for(int i=0;i<n;i++) {
            sum=sum+date[i];
        }
        mean=sum/n;
        sum=0;  
        for(int i=0;i<n;i++) {
            sum+=Math.pow((date[i]-mean),2);
        }
        mean=sum/(n-1);
        double deviation=Math.sqrt(mean);
        double Q1=date[(t/2/2)],Q3=date[(t/2)+(t/2/2)];
        if(A==1){
            System.out.println("Maximum number="+MaxNum);
        }
        else if(A==2){
            System.out.println("Miniumu number="+MinNum);
        }
        else if(A==3){
            System.out.println("median="+median);
        }
        else if(A==4){
            System.out.println("mode: " + maxValue);
        }
        else if(A==5){
            System.out.format("The average is: %.3f"+"\n", average);
        }
        else if(A==6){
            System.out.println("standard deviation :"+deviation);
        }
        else if(A==7){
            System.out.println("Quartile"+"  Q1="+Q1+"  Q2=" +median+ "  Q3=" +Q3);
        }
        else if(A==8){
            System.out.println("IQR is= "+(Q3-Q1));
        }
        else if(A==9){
            System.out.println("Maximum number="+MaxNum);
            System.out.println("Miniumu number="+MinNum);
            System.out.println("median="+median);
            System.out.println("mode: " + maxValue);
            System.out.format("The average is: %.3f"+"\n", average);
            System.out.println("standard deviation :"+deviation);
            System.out.println("Quartile"+"  Q1="+Q1+"  Q2=" +median+ "  Q3=" +Q3);
            System.out.println("IQR is= "+(Q3-Q1));
        }
    }
}
