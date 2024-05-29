import java.io.*; //FileReader,Scanner classes
import java.lang.Math; //Math class
import java.util.ArrayList;
import java.util.Scanner;//scanner class
import java.util.Collections; //Collections class

 public class MathAndStats{

    static double calcAvarage( ArrayList<Double> ints){
        double sum=0.0;
        double average=0.0;
        int inputSize=ints.size();
        for(int i=0;i<inputSize;i++){
            sum+=ints.get(i);
        }
        average=sum/(double)inputSize;
        //System.out.println(average);
        return average;
        }
   
    static int calcMedian(ArrayList<Double> ints){
        int inputSize=ints.size(),median=0;
        Collections.sort(ints);
        if (inputSize%2==1){
              median=(int)Math.round(ints.get(inputSize/2));
             return median; 
        }else{
            median=(int)Math.round((ints.get(inputSize/2)+ ints.get(inputSize/2-1))/2);
          return median;
            
        }
        
    }
    static double calcVariance(ArrayList<Double> ints,double average){
        double deviation=0.0,variance=0.0;
        int inputSize=ints.size();
        for(Double i:ints){
             deviation+=Math.pow((i-average),2);
             }
             variance=deviation/(double)inputSize;
             
      return variance;
    }
    static int calcStandardDeviation(ArrayList<Double> ints, double variance){ 
        int standardDeviation=0;
        standardDeviation=(int)Math.round(Math.sqrt(variance));
        return standardDeviation;
    }

    

    //main method
    public static void main(String[] args)throws Exception{      
     if (args.length==0){
            System.out.println("No arguments provided");
        }else if (args.length>1) {
            System.out.println("Many arguments provided");
        }else{
            String file=args[0];
            int ext=file.lastIndexOf(".");
           if (file.lastIndexOf(".")!=-1){
              String extension =file.substring(ext);
              if (extension.equals(".txt")){
                  ArrayList<Double> fileContent=new ArrayList<>();
                  try{
                   Scanner s = new Scanner(new FileReader(file));
                   while(s.hasNext()){
                          fileContent.add(s.nextDouble());
                    }
                   s.close();
                 //  System.out.println(fileContent);
                  }catch (Exception e){
                     System.out.println("Problem reading the file");
                     return;
                   }
                   double average=calcAvarage(fileContent);
                   double variance=calcVariance(fileContent,average);
                   System.out.printf("Average: %d\n",Math.round(average));
                   System.out.printf("Median: %d\n",calcMedian(fileContent));
                   System.out.printf("Variance: %d\n",Math.round(variance));
                   System.out.printf("Standard Deviation: %d\n",calcStandardDeviation(fileContent,variance));    
      
               }else{
                System.out.println("Files should be of .txt extension");
                return;  
               
              }   
                }else{
                    System.out.println("include file extension");
                }
               
             }
            }
            
    }
    

 