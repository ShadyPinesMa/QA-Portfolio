package com.sweetshop.tests.utils;

import com.opencsv.CSVReader;
import com.opencsv.*;
import com.sweetshop.pages.CheckoutData;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

    public static Object[][] getCsvData(String fileName) throws Exception {
        InputStream inputStream = CsvUtils.class.getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new RuntimeException("CSV file not found" + fileName);
        }

        CSVReader reader = new CSVReader(new InputStreamReader(inputStream));
        List<String[]> csvData = reader.readAll();
        reader.close();

        List<Object[]> data = new ArrayList<>();

        for (int i = 1; i < csvData.size(); i++) {
            String[] row = csvData.get(i);
            if (row.length < 12) {
                System.out.println("Skipping invalid row");
                continue;
            }
            for (String value : row) {
                System.out.println(value);
            }
            CheckoutData checkoutData = new CheckoutData(
                            row[0].trim(),//first name
                            row[1].trim(),//last name
                            row[2].trim(),//email
                            row[3].trim(),//address 1
                            row[4].trim(),//address 2
                            row[5].trim(),//country
                            row[6].trim(),//city
                            row[7].trim(),//zip
                            row[8].trim(),//card name
                            row[9].trim(),//card num
                            row[10].trim(),//exp date
                            row[11].trim()//cvv
            );
            data.add(new Object[]{ checkoutData });
        }
        System.out.println(
                "Total datasets loaded: " + data.size());
        return data.toArray(new Object[0][]);
    }
}
