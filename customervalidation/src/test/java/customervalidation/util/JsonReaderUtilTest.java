package customervalidation.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import customervalidation.model.Customer;

class JsonReaderUtilTest {

	@Test
	void testReadData() {
		JsonReaderUtil jsonReader = new JsonReaderUtil();
		List<Customer> actual = new ArrayList<Customer>();
		Customer c1 = new Customer("Viennia Sturm", "", "17565", "ea0c4");
		Customer c2 = new Customer("Amerah Lang", "5037 Providence Bouled", "44109", "8d322");
		actual.add(c1);
		actual.add(c2);
		List<Customer> expected = jsonReader.readData("readDataTest.json");
		assertEquals(expected, actual, "Read method should parsh json  data properly ");
	}

}
