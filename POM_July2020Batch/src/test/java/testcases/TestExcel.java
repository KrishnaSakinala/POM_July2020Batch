package testcases;

import repo.ExcelApiTest;

public class TestExcel {

	public static void main(String[] args) throws Exception{
		
		ExcelApiTest eat = new ExcelApiTest("/Users/krishnasakinala/git/POM_July2020Batch/POM_July2020Batch/src/main/resources/TestData.xlsx");
		
		String s = eat.getCellData("TestCases", 0, 2);
		System.out.println(s);
		
		String s1 = eat.getCellData("TestCases", "TestCaseName", 2);
		System.out.println(s1);
		
		System.out.println(eat.getRowCount("TestCases"));
		System.out.println(eat.getColumnCount("TestCases"));
		
		System.out.println(eat.setCellData("TestCases", "TestCaseName", 10, "SampleTestCase"));
	}
}