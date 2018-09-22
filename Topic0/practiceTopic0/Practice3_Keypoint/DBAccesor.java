package practiceTopic0.Practice3_Keypoint;
//Create a proxy example for database accessor classes

import java.util.Date;

public abstract class DBAccesor {
	public void access() {
		System.out.println(this.getClass().getSimpleName() + " accessing data at " + new Date());
	}
}
