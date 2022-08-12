package com.duobank.DB;

import com.duobank.utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class HalilDb {

    public static void main(String[] args) {

        DBUtils.createConnection();

        List<List<Object>> result = DBUtils.getQueryResultAsListOfLists("SELECT * FROM tbl_mortagage limit 10;");

        for (List<Object> row : result) {
            System.out.println(row); // it prints first 10 row

        }

        System.out.println(result.get(0).get(6)); //prints down payment

        List<Map<String, Object>> result2 = DBUtils.getQueryResultListOfMaps("SELECT * FROM tbl_mortagage limit 10;");

        for (Map<String, Object> row : result2) {
            System.out.println(row);  //it gives you the result with the name of the columns benefit we can name of the colum
        }

        System.out.println(result2.get(0).get("down_payment")); // benefit of maps no counting, type key object

        System.out.println(DBUtils.getColumnNames("SELECT * FROM tbl_mortagage ;")); // GETS ALL THE COLUMN NAMES

        System.out.println(DBUtils.getRowCount()); // count rows


    }
    }



