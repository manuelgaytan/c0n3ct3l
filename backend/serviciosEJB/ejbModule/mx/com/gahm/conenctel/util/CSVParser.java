package mx.com.gahm.conenctel.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CSVParser {

    public static TableModel parse(File f) throws FileNotFoundException {
    	return parse(f, false);
    }
    
    public static TableModel parse(File f, boolean hasHeaders) throws FileNotFoundException {
        ArrayList<String> headers = new ArrayList<String>();
        ArrayList<String> oneDdata = new ArrayList<String>();

        // Get the headers of the table.
        Scanner lineScan = new Scanner(f);
        Scanner s = new Scanner(lineScan.nextLine());
        s.useDelimiter(",");
        while (s.hasNext()) {
            headers.add(s.next().trim());
        }

        // Go through each line of the table and add each cell to the ArrayList
        while (lineScan.hasNextLine()) {
            s = new Scanner(lineScan.nextLine());
            s.useDelimiter(", *");
            while (s.hasNext()) {
                oneDdata.add(s.next().trim());
            }
        }
        Integer sizeReg = oneDdata.size() / headers.size();
        String[][] data = new String[sizeReg][headers
                .size()];

        // Move the data into a vanilla array so it can be put in a table.
        for (int x = 0; x < sizeReg; x++) {
            for (int y = 0; y < data[0].length; y++) {
                data[x][y] = oneDdata.remove(0);
            }
        }

        // Create a table and return it.
        return new DefaultTableModel(data, headers.toArray());

    }

}
