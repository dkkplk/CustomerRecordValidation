package customervalidation.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import customervalidation.model.Customer;

public class CustomerValidation {

	// name validation
	Predicate<Customer> isValidName = c -> (c.getName() == null || c.getName().equals(""));

	// address validation
	Predicate<Customer> isValidAddress = c -> (c.getAddress() == null || c.getAddress().equals(""));

	// pin validation
	Predicate<Customer> isValidZip = (c -> (c.getZip() == null || c.getZip().equals("") || c.getZip().length() != 5));

	// temp record holder
	Set<Customer> dataSet = new HashSet<Customer>();

	// print invalid records id
	Consumer<List<Customer>> invalidRecords = customers -> {

		for (Customer customer : customers) {

			if (!dataSet.add(customer) || isValidName.test(customer) || isValidAddress.test(customer)
					|| isValidZip.test(customer)) {
				System.out.println(customer.getId());
			}

		}

	};

	// print invalid records id
	Function<List<Customer>, List<String>> invalidRecordsFunction = customers -> {

		List<String> invalidRecords = new ArrayList<String>();

		for (Customer customer : customers) {

			if (!dataSet.add(customer) || isValidName.test(customer) || isValidAddress.test(customer)
					|| isValidZip.test(customer)) {
				invalidRecords.add(customer.getId());
			}

		}
		return invalidRecords;

	};

	public void printInvalidRecords(List<Customer> data) {
		invalidRecords.accept(data);
	}

	public List<String> getInvalidRecords(List<Customer> data) {
		return invalidRecordsFunction.apply(data);
	}

}
