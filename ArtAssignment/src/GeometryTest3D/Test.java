package GeometryTest3D;

import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Test extends Application{
	private Xform world = new Xform();
	private final Camera camera = new PerspectiveCamera(true);
	private Xform cameraXform = new Xform();
	public void start(Stage c) throws Exception {

		world.getChildren().add(cameraXform);
		cameraXform.getChildren().add(camera);
		Rotate rz = new Rotate(180.0, Rotate.Z_AXIS);
		camera.getTransforms().add(rz);
	}
	public static void main(String[] args)
	{
		Test t = new Test();
		Sphere mySphere = new Sphere(4);
		t.camera.s
	}

}
