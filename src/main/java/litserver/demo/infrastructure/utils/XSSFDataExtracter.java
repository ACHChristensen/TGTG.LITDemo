package litserver.demo.infrastructure.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class XSSFDataExtracter {

    public static HashMap<Integer,Object> getData(String filepath, String header, Object datatype) throws IOException {

        //obtaining input bytes from a file
        FileInputStream fileWithFirstNames = new FileInputStream(
                new File(filepath));
        //creating workbook instance that refers to .xls file
        XSSFWorkbook wb=new XSSFWorkbook(fileWithFirstNames);
        //creating a Sheet object to retrieve the object
        XSSFSheet sheet=wb.getSheetAt(0);
        //evaluating cell type
        FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();

        Row firstRow = sheet.rowIterator().next();
        int countColumnIndex = 0;
        for(Cell cell: firstRow){
            if (cell.getStringCellValue().equals(header)) {
                break;
            }
            countColumnIndex ++;
        }

        HashMap<Integer,Object> data = new HashMap<>();
        int countData = 0;
        for(Row row: sheet)
        {
            Cell cell = row.getCell(countColumnIndex);

            //Validating data from cell
            switch(formulaEvaluator.evaluateInCell(cell).getCellType())
            {
                case Cell.CELL_TYPE_NUMERIC:
                    if(datatype.getClass() == Integer.class){
                        countData++;
                        data.put(countData, cell.getNumericCellValue());
                    }
                case Cell.CELL_TYPE_STRING:
                    if(datatype.getClass() == String.class) {
                        countData++;
                        data.put(countData, cell.getStringCellValue());
                    }
                case Cell.CELL_TYPE_BLANK:
                    countData++;
            }
        }
        return data;
    }
}
