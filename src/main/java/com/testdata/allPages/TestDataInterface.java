package com.testdata.allPages;

public interface TestDataInterface {

	interface Dashboard {
		String userName_passCase = "//span[contains(text(),'Test Admin')]";
		String userName_failCase = "//span[contains(text(),'Hello')]";
		String ViewItem_passCase="//p[text()=' View Item']";
		String ViewItem_failCase="//p[text()=' Edit Item']";
		
	}
	

}
