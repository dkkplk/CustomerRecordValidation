package customervalidation.util;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import customervalidation.model.Customer;

public class JsonReaderUtil {

	// file reader
	Function<String, File> fileReader = fname -> new File(getClass().getClassLoader().getResource(fname).getFile());

	// keymapper
	Function<JSONObject, String> idData = id -> (String) id.get("id");

	// value mapper
	Function<JSONObject, Customer> fetchCustomerRecords = json -> {
		Customer customer = new Customer();
		customer.setId((String) json.get("id"));
		customer.setName((String) json.get("name"));
		customer.setAddress((String) json.get("address"));
		customer.setZip((String) json.get("zip"));
		return customer;
	};

	public List<Customer> readData(String fileName) {
		File file = fileReader.apply(fileName);
		JSONParser parser = new JSONParser();
		List<Customer> customers = null;

		try (Reader reader = new FileReader(file)) {
			JSONArray jArray = (JSONArray) parser.parse(reader);
			customers = (List<Customer>) jArray.stream().map(fetchCustomerRecords).collect(Collectors.toList());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return customers;

	}

}
