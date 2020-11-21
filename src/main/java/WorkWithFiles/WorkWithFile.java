package WorkWithFiles;


import Contracts.Contract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.lang.Integer.parseInt;

public class WorkWithFile {
    public ArrayList<Contract> readFileCsv(String pathToFile){

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                //use comma as separator
                String[]country = line.split(cvsSplitBy);

                System.out.println("Country[code= " + country[4]+ " , name=" + country[5]+ "]");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void parseLine(String[] elements){
//        format calendar 2000-00-00 (year-month-day)=>
        String[] dateStartContract=elements[0].split("-");
        String[] dateEndContract=elements[1].split("-");
        Calendar dataStart=new GregorianCalendar(parseInt(dateStartContract[0]),parseInt(dateStartContract[1]),parseInt(dateStartContract[2]));
        Calendar dataEnd=new GregorianCalendar(parseInt(dateEndContract[0]),parseInt(dateEndContract[1]),parseInt(dateEndContract[2]));


    }
}
