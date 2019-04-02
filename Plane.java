import java.lang.Math;

public class Plane extends RealObject{

	private Vector3 position, normal;
	
	public Plane(Vector3 p, Vector3 n, Vector3 color) {
		super(color);
		this.position=p;
		this.normal=n;
	}

	@Override
	public double testCollision(Vector3 rayPosition, Vector3 rayDirection) {
		double epsilon=10^(-3);
		double d=Vector3.dotProduct(rayDirection, normal);
		
		if(Math.abs(d)<=epsilon) return -1;
		
		return Vector3.dotProduct(Vector3.subst(position, rayPosition), normal)/d;
	}

}
