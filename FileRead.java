/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileread;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
        

/**
 *
 * @author kendellprather
 */
public class FileRead {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws FileNotFoundException
	{
            //all used to read in file and created matrix of labels and weights
		int[][] matrix = null;
		String[] labels = null;
                int count = 0;
                String csvFile = "matrix.txt";
                BufferedReader br = null;
                String line = "";
                String cvsSplitBy = ",";
		
        try {

            br = new BufferedReader(new FileReader(csvFile));
            line = br.readLine();
            labels = line.split(cvsSplitBy); // use comma as separator
            matrix = new int[labels.length][labels.length];
            while((line = br.readLine()) != null){
                String[] tmpMatrix = null;
                tmpMatrix = new String[labels.length];
                tmpMatrix = line.split(cvsSplitBy);
                for(int i = 0; i < labels.length; i++){
                 matrix[count][i] = Integer.parseInt(tmpMatrix[i]);
                }
                count++; //count is used to keep track of x value when populating matrix
            }
            

            
        //catches file not found exceptions
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
     }
}

    

