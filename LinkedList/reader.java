



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class reader {
public   String orginal[];
public  String charSort[];




    public reader(String input_file) throws FileNotFoundException{
        // file not able to found throws FileNotFoundException
            BufferedReader reader = new BufferedReader(new FileReader(input_file));
            String s;
            String orginalStringarr = new String();
           
        
            
            try { // file not able to read throw IO exception;
                while((s = reader.readLine()) != null){
                    orginalStringarr = orginalStringarr.concat(s).concat(" ");
                   
            }
            this.orginal = orginalStringarr.split(" ");
            Arrays.sort(orginal);
            
            
            
            
            reader.close();}
            catch (IOException e) {
        
                e.printStackTrace();
            }
            }






}
