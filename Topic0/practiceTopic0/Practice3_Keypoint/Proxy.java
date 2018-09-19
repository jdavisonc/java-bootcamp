package practiceTopic0.Practice3_Keypoint;
import java.util.Date;

public class Proxy {

		DBAccesor accessor;

		public Proxy() {
			System.out.println("Creating proxy at " + new Date());
		}

		public void access() {
			if (accessor == null) {
				accessor = new Accesor1();
			}
			accessor.access();
		}

}

