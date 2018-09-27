package builder;

public class MysqlDatabase {
	String name;
	String port;
	String address;

	public MysqlDatabase(String name, String address, String port) {
		this.setName(name);
		this.setAddress(address);
		this.setPort(port);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}

	@Override
	public String toString() {
		return "Connected to: " + this.getName() + " " + "Port: " + this.getPort() + "  address: "
				+ this.getAddress();
	}
}