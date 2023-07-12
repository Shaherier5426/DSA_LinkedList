






import java.util.Arrays;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class Assign2 {
    private  static long time;
   public static void  main(String[] args) throws FileNotFoundException  {
       // Importing the files strings and making an array.
       String inputfile =  args[0];

       long startime= System.currentTimeMillis();

        reader data = new reader(inputfile);


        String array1 []= Arrays.copyOf(data.orginal, data.orginal.length);
        String arr[] = array1;
        // intilize the array for linklist to the size of the array(max possible size) 
        linklist1[] linklist_array = new linklist1[data.orginal.length];
        // count the Binsert items;

        int k = 0;
        for(int i = 0; i < array1.length; i++){
            

            if(array1[i] != null){ 

            linklist_array[k] = new linklist1();
            for(int j = 0; j < arr.length; j++){

                if( arr[j]== null){
                    continue;
                }

                else if(array1[i] == arr[j] && array1[i] != null){
                    linklist_array[k].Binsert(array1[i]);
            
                }
               

                else if(sortString(array1[i]).equals(sortString(arr[j])) && array1[i].length() == arr[j].length()){
                    linklist_array[k].Einsert(arr[j]);
                    arr[j] = null;
                }
                else{
                    continue;
                }
            
            }
            k++;
            time = (System.currentTimeMillis() - startime)/1000;
        }

    } 




// Sorting

    for(int b = 0; b < k; b++){
 linklist_array[b].insertionSort();
    }

quickSort(linklist_array,0,k-1);
    
    
    
    
    
    
    StringBuilder T  = new StringBuilder();
               for(int a = 0; a < k; a++){
                Node  cur = linklist_array[a].head; 
               
                while(cur!=null){
                   T= T.append(cur.data + " ");
                    
                    cur = cur.next;
                }
               T= T.append("\n"); 
            }     
                try{String outputfile = args[1] ;
                        FileWriter writer = new FileWriter(outputfile);
                        writer.write("THE LIST OF ANAGRAM \n");
                        writer.write(String.valueOf(T));
                        
                    writer.write("\n");
                    writer.close(); 
                }
                
                catch(IOException e){
                    e.printStackTrace();
                }   
    // for(int i = 0 ;i<k; i++){
    // linklist_array[i].printList();}
                
            System.out.println("The time in seconds: "+ getTime());
                }
            
    public static long getTime(){
        return time;
    }
     









public static  String sortString(String word) {
    char word1[] = word.toCharArray();
    Arrays.sort(word1);
    
return new String(word1);
}




public static int ascii (String num ){
    int sb =0;
    if(num == null){
        return 0;
    }
    for (char c : num.toCharArray()){
        sb = sb + ((int)c);}
    return sb;
   

}
public static int partition(linklist1 array[], int lb, int ub){
    String pivot = array[lb].head.data;
    int start = lb;
    int end = ub;
    while(start <end){
        while(array[start].head.data.compareTo(pivot)<=0 && array[start]!=null){
            start++;
        }
        while(array[end].head.data.compareTo(pivot)>0 && array[end]!= null){
            end--;
        }
        if(start < end){
            linklist1 temp = array[start];
            array[start] = array[end];
            array[end] = temp; 
        }
            else{
                continue;
            }
        
    }
    linklist1 temp = array[lb];
            array[lb] = array[end];
            array[end] = temp; 
    
    return end;
    }



    public static void quickSort(linklist1[] array,int lb,int ub){
        if(lb <ub){
        int loc = partition(array, lb, ub); 
        quickSort(array,lb, loc-1);
        quickSort(array,loc+1,ub);
    
        }
    }
}