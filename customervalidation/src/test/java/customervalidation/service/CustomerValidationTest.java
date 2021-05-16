package customervalidation.service;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import customervalidation.model.Customer;
import customervalidation.util.JsonReaderUtil;

class CustomerValidationTest {

	@Test
	void testGetInvalidRecords() {
		List<String> expected = new ArrayList<String>();
		expected.add("ea0c4");
		JsonReaderUtil jsonReader = new JsonReaderUtil();
		List<Customer> data = jsonReader.readData("readDataTest.json");
		CustomerValidation validateRecords = new CustomerValidation();
		List<String> actual = validateRecords.getInvalidRecords(data);
		assertIterableEquals(expected, actual);
	}

}
