import java.io.*; //FileReader,Scanner classes
import java.lang.*; //Math class
import java.util.*; //Collections class

 public class MathAndStats{

    static int calcAvarage( ArrayList<Float> ints){
        Float sum;
        int average=0;
        int inputSize=ints.size();
        for(int i=0;i<inputSize;i++){
            sum=sum+i;
        }
        average=Math.round(sum/(float)inputSize);
        return average;
    }
    static int calcMedian(ArrayList<Float> ints){
        int inputSize=ints.size(),median=0;
        Collections.sort(ints);
        if (inputSize%2==1){
              median=Math.round(ints.get(inputSize/2));
             return median; 
        }else{
            median=Math.round((ints.get(inputSize/2)+ ints.get(inputSize/2-1))/2);
          return median;
            
        }
        
    }
    static int calcVariance(ArrayList<Float> ints){
        int deviation=0,variance=0;
        int average=calcAvarage(ints);
        for(Float i:ints){
             deviation+=Math.round((Math.pow(Math.round(i)-average,2)));
             }
             variance=deviation/ints.size();
             
      return variance;
    }
    static int calcStandardDeviation(ArrayList<Float> ints){ 
        int standardDeviation=0;
        int variance=calcVariance(ints);
        standardDeviation=Math.sqrt(variance);
        return standardDeviation;
    }
    

    //main method
    public static void main(String[] args)throws Exception{      
     if (args.length<0){
            System.out.println("No arguments provided");
        }else if (args.length>1) {
            System.out.println("Many arguments provided");
        }else{
            String file=args[0];
            ArrayList<Float> fileContent=new ArrayList<>();
     
            try{
             Scanner s = new Scanner(new FileReader(file));
             while(s.hasNext()){
              fileContent.add(s.nextFloat());
              }
             System.out.println("File read succesfully");
             s.close();
            }catch (Exception e){
               System.out.println("Problem reading the file");
             }
    
          calcAvarage(fileContent);
          calcMedian(fileContent);
          calcVariance(fileContent);
          calcStandardDeviation(fileContent);

        }     
    }
}
 