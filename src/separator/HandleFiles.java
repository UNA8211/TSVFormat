/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package separator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Ryan Brand
 */
public class HandleFiles {

    private BufferedReader br = null;
    private FileReader fr = null;
    private BufferedWriter bw = null;
    private FileWriter fw = null;

    private boolean trimmed;
    private int trimAmount = 20000;

    private String path;
    private String file;

    public HandleFiles(String file, String path, boolean trimmed) throws IOException {
        this.file = file;
        this.path = path;
        this.trimmed = trimmed;

        fr = new FileReader(new File(path + file));
        br = new BufferedReader(fr);
    }

    // Input file
    public String convertFile() throws IOException {
        StringBuilder output = new StringBuilder();

        String currentLine;

        // Convert file to string
        if (trimmed) {
            int i = 0;
            while (((currentLine = br.readLine()) != null) && (i != trimAmount)) {
                output.append(currentLine);
                output.append("\n");
                i++;
            }
        } else {
            while ((currentLine = br.readLine()) != null) {
                output.append(currentLine);
                output.append("\n");
            }
        }
        return output.toString();
    }

    // Output file
    public void generateNewCSV(String convert) throws IOException {
        try {
            fw = new FileWriter(path + "formatted_" + file);
            bw = new BufferedWriter(fw);
            bw.write(convert);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                bw.close();
            }

            if (fw != null) {
                fw.close();
            }

        }
    }
}
