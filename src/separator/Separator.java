/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package separator;

import java.io.IOException;

/**
 *
 * @author Ryan Brand
 */
public class Separator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        String fileName = "data1.tsv";
        String path = "C:\\Users\\Ryan Brand\\Desktop\\data\\";
        boolean multivalued = true;
        int[] cols = {9, 1};
        
        HandleFiles file = new HandleFiles(fileName, path);
        
        FieldSeparator fs = new FieldSeparator(file.convertFile());
        file.generateNewCSV(fs.separate(multivalued, cols));
    }
    
}
