package customervalidation;

import customervalidation.service.CustomerValidation;
import customervalidation.util.JsonReaderUtil;

public class CustomerRecordValidation {

	public static final String FILE_NAME = "data.json";

	public static void main(String[] args) {

		JsonReaderUtil jsonUtil = new JsonReaderUtil();
		CustomerValidation customerValidation = new CustomerValidation();

		customerValidation.printInvalidRecords(jsonUtil.readData(FILE_NAME));

	}

}
