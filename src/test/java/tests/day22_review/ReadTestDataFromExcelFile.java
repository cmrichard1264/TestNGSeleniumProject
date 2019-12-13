package tests.day22_review;

import org.testng.annotations.Test;
import utils.ExcelUtil;

import java.util.HashMap;
import java.util.Map;

public class ReadTestDataFromExcelFile {

    @Test
    public void test1(){
        ExcelUtil cars = new ExcelUtil("cars.xlsx", "cars");
        System.out.println(cars.getDataList());
        String color = cars.getDataList().get(0).get("Color");
        String driverName = cars.getDataList().get(0).get("Driver");
        System.out.println(driverName);
        System.out.println(color);

        Map<String, String> row = new HashMap<>();
        row.put("Licence Plate", "777");
        row.put("Driver", "SDET Driver");
        System.out.println(row.get("Driver"));

        Map<Integer, String> values = new HashMap<>();
        values.put(1, "apple");

        Map<String, String> countryCodes = new HashMap<>();
        countryCodes.put("USA", "+1");
        countryCodes.put("Italy", "+34");
        countryCodes.put("Kazakhstan", "+7");
        countryCodes.put("Uzbekistan", "+998");

        System.out.println(countryCodes.get("Italy"));




    }
}
