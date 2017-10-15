/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package separator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Ryan Brand
 */
public class FieldSeparator {

    private String data;

    public FieldSeparator(String data) {
        this.data = data;
    }

    // Separate and order columns
    public String separate(boolean multivalued, int... colOrder) {

        StringBuilder sb = new StringBuilder();

        // Individual lines
        String[] lines = data.split("\n");
        
        for (String line : lines) {
            // Get each piece of data
            String[] individualCols = line.split("\t");

            String[] truncated = new String[colOrder.length];

            // Order data
            for (int i = 0; i < colOrder.length; i++) {
                truncated[i] = individualCols[colOrder[i] - 1];
            }

            if (multivalued) {
                split(truncated, sb, 0);
            } else {
                sb.append(mergeCols(truncated) + "\n");
            }
        }

        return sb.toString();
    }

    // Split multivalued data into individual 
    public void split(String[] cols, StringBuilder sb, int multivaluedCol) {

        String col = cols[multivaluedCol].replaceAll("\"", "");
        String[] values = col.split(",");
        String merged = mergeCols(Arrays.copyOfRange(cols, multivaluedCol + 1, cols.length));

        // Iterate over each split multivalued attr
        for (String value : values) {
            if (value.equals("\\n") || value.equals("\\N")) {
                sb.append("NONE" + "\t" + merged + "\n");
            } else {
                sb.append(value + "\t" + merged + "\n");
            }
        }
    }

    // Take remaining cols not multivalued and combine them for combination with
    // each value of the multivalued col
    public String mergeCols(String[] remainingCols) {

        StringBuilder sb = new StringBuilder();

        for (String col : remainingCols) {
            sb.append(col + "\t");
        }
        sb.delete(sb.length() - 1, sb.length() - 1);

        return sb.toString();
    }

}
