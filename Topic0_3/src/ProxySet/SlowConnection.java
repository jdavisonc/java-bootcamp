package ProxySet;

public class SlowConnection extends Connect{

	public SlowConnection() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		  }
	}
}
