package litserver.demo.infrastructure.utils;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class XSSFDataExtracter {

    //@Value(value = "${foodkeeper_data_path}")
    private static String foodKeeperDataPath = ".\\FoodKeeper-Data.xls";

    public HashMap<Integer,Object> getData(String header, Object datatype, int sheetIndex) throws IOException {

        //obtaining input bytes from a file
        FileInputStream fileInputStream = new FileInputStream (this.foodKeeperDataPath);
        //creating workbook instance that refers to .xls file
        HSSFWorkbook wb=new HSSFWorkbook(fileInputStream);
        //creating a Sheet object to retrieve the object
        HSSFSheet sheet=wb.getSheetAt(sheetIndex);
        //evaluating cell type
        FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();

        Row firstRow = sheet.getRow(0);
        int countColumnIndex = 0;
        for(Cell cell: firstRow){
            if (cell.getStringCellValue().equals(header)) {
                break;
            }
            countColumnIndex ++;
        }
        HashMap<Integer,Object> data = new HashMap<>();
        int countData = 0;
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

            Cell cell = sheet.getRow(i).getCell(countColumnIndex);

            //Validating data from cell
            if (cell == null) {
                countData++;
                data.put(countData, "");
            } else {


                if (datatype.getClass() == Integer.class) {
                    int noDecimalNumber = Integer.parseInt((cell.getNumericCellValue() +"").replace(".0", ""));
                    countData++;
                    data.put(countData, noDecimalNumber);
                }

                if (datatype.getClass() == String.class) {
                    countData++;
                    data.put(countData, cell.getStringCellValue());
                }
            }
        }
        return data;
    }
}
