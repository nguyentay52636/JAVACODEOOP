package HandleList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import handleMaganement.ObjCustomer.Customer;

public class ListCustomer {
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private static final String FILE_PATH = "/home/huy/Documents/Java/projectOOP/src/data/KhachHang.txt";

	public ListCustomer() {
		initializeCustomers();
	}

	private void initializeCustomers() {
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
			String line;
			Customer currentCustomer = null;

			while ((line = br.readLine()) != null) {
				// If the line is empty, it means a new customer is starting
				if (line.trim().isEmpty()) {
					// Check if we have an existing customer to add
					if (currentCustomer != null) {
						customers.add(currentCustomer);
					}
					// Create a new Customer object for the next customer
					currentCustomer = new Customer();
				} else {
					// Split the line into key and value
					String[] customerData = line.split(": ");
					if (customerData.length == 2) {
						String key = customerData[0].trim();
						String value = customerData[1].trim();

						// Check if currentCustomer is not null before calling its methods
						if (currentCustomer != null) {
							switch (key) {
							case "Name":
								currentCustomer.setName(value);
								break;
							case "Telephone Number":
								currentCustomer.setTelephoneNumber(value);
								break;
							case "Age":
								currentCustomer.setAge(Integer.parseInt(value));
								break;
							case "Address":
								currentCustomer.setAddress(value);
								break;
							case "Gender":
								currentCustomer.setGender(value);
								break;
							case "Is Member":
								currentCustomer.setMember(Boolean.parseBoolean(value));
								break;
							case "Birth Month":
								currentCustomer.setBirthMonth(Integer.parseInt(value));
								break;
							case "Discount":
								currentCustomer.setDiscount(Double.parseDouble(value));
								break;
							// Add more cases for other attributes
							// ...
							default:
								// Handle unknown key or ignore
								break;
							}
						} else {
							System.out.println("Error: currentCustomer is null");
						}
					}
				}
			}

			// Add the last customer (if any)
			if (currentCustomer != null) {
				customers.add(currentCustomer);
			}
		} catch (Exception e) {
			e.printStackTrace(); // Handle exception properly in a real application
		}
	}

	public void editCustomer(String customerIdentifier, String[] newValues) {
		try {
			ArrayList<String> lines = new ArrayList<>();
			try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
				String line;
				while ((line = br.readLine()) != null) {
					lines.add(line);
				}
			}

			int customerStartIndex = -1;
			for (int i = 0; i < lines.size(); i++) {
				if (lines.get(i).startsWith(customerIdentifier)) {
					customerStartIndex = i;
					break;
				}
			}

			if (customerStartIndex != -1) {
				String[] attributes = lines.get(customerStartIndex + 1).split(": ");
				for (int i = 0; i < attributes.length; i++) {
					// Replace the existing value in the attribute line with the new value
					if (i < newValues.length) {
						attributes[i] = newValues[i];
					}
				}

				// Reconstruct the updated attribute line
				String updatedAttributeLine = String.join(": ", attributes);
				lines.set(customerStartIndex + 1, updatedAttributeLine);

				try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
					for (String line : lines) {
						bw.write(line);
						bw.newLine();
					}
				}

				System.out.println("Customer information updated successfully.");
				// Reinitialize customers after editing
				initializeCustomers();
			} else {
				System.out.println("Customer not found.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void displayCustomerInformation() {
		for (Customer customer : customers) {
			System.out.println("Customer Information:");
			System.out.println("Name: " + customer.getName());
			System.out.println("Telephone Number: " + customer.getTelephoneNumber());
			System.out.println("Age: " + customer.getAge());
			System.out.println("Address: " + customer.getAddress());
			System.out.println("Gender: " + customer.getGender());
			System.out.println("Is Member: " + customer.isMember());
			System.out.println("Birth Month: " + customer.getBirthMonth());
			System.out.println("Discount: " + customer.getDiscount());
			System.out.println();
		}
	}

	public static void main(String[] args) {
		ListCustomer listCustomer = new ListCustomer();

		// Example of editing a customer's age
		listCustomer.editCustomer("# Customer 1",
				new String[] { "John Doe", "987654321", "28", "1473 Oak St", "Female", "false", "8", "0.1" });
		listCustomer.displayCustomerInformation();
	}

}
