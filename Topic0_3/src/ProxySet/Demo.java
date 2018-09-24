package ProxySet;

public class Demo {
	public static void main(String[] args) {

		Proxy proxy = new Proxy();

		FastConnection fastConnection = new FastConnection();
		fastConnection.connect();

		proxy.connect();

	}

}