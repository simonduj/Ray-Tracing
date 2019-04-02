import java.lang.Math;

public class Sphere extends RealObject {

	private Vector3 center;
	private double radius; 
	
	public Sphere(Vector3 c, double r, Vector3 color) {
		super(color);
		this.center=c;
		this.radius=r;
	}

	@Override
	public double testCollision(Vector3 rayPosition, Vector3 rayDirection) {
		Vector3 f=Vector3.subst(rayPosition, center);
		double a=Vector3.dotProduct(f, rayDirection);
		
		if(a>0) return -1;
		
		double b=Vector3.dotProduct(f, f)-radius*radius;
		double delta=a*a-b;
		
		if(delta<0) return -1;
		
		return -a-Math.sqrt(delta);
	}

}
