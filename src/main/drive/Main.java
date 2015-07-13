package drive;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jwm.j3dfw.controller.ControllerFactory;
import com.jwm.j3dfw.geometry.Geometry;
import com.jwm.j3dfw.geometry.GeometryList;
import com.jwm.j3dfw.production.Camera;
import com.jwm.j3dfw.util.MainFrame;

import drive.controller.DriveControllerFactory;
import drive.geometry.objects.Car;
import drive.geometry.objects.DomainFactory;

public class Main {

	private static Logger log = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		log.info("Starting application");
		GeometryList parts = DomainFactory.getCarOnGranularRoad();
		ControllerFactory cf = new DriveControllerFactory();
		Camera cam = null;

		// TODO: something better than this
		for (Geometry p : parts) {
			if (p instanceof Car) {
				cam = p.getCamera();
			} 
		}
		if (cam == null) {
			throw new RuntimeException("Camera not found!");
		}

		MainFrame frame = new MainFrame(parts, cf, cam);
	}
}
