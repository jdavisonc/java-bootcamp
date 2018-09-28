package proxy;

public interface DataRequest {
	
	String showData(String request);

	String deleteData(String request);

	String modifyData(String oldData, String newData);

}