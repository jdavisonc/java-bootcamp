package proxy;
import java.util.ArrayList;


public class Database implements DataRequest {

	ArrayList<String> content;

	// Strings are used to simulate the contents of a database

	public Database() {
		content = new ArrayList<String>();
		content.add("data1");
		content.add("data2");
		content.add("Sensitive data");
	}

	/*
	 * Just to simplify this example and avoid more complex structures, requests to
	 * the database are made by comparing strings
	 */

	@Override
	public String showData(String request) {
		int index = content.indexOf(request);
		return this.content.get(index) + ": random content";
	}

	@Override
	public String deleteData(String request) {
		int index = content.indexOf(request);
		content.remove(index);
		return "Data deleted successfully";
	}

	@Override
	public String modifyData(String oldData, String newData) {
		int index = content.indexOf(oldData);
		content.set(index, newData);
		return "Data modified successfully";
	}
}