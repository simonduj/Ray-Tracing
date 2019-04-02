import java.lang.Math;

public class Vector3 {
    
    public final double x,y,z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }    

    public static Vector3 add(Vector3 v1, Vector3 v2) {
        return new Vector3(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    }
    
    public static Vector3 subst(Vector3 v1, Vector3 v2) {
        return new Vector3(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
    }

    public static Vector3 multiply(Vector3 vector, double factor) {
        return new Vector3(vector.x * factor, vector.y * factor, vector.z * factor);
    }
    
    public static double length(Vector3 vector)
    {
    	return Math.sqrt(vector.x*vector.x+vector.y*vector.y+vector.z*vector.z);
    }
    
    public static Vector3 normalized(Vector3 vector)
    {
    	double fact=1/Vector3.length(vector);
    	return new Vector3(vector.x*fact,vector.y*fact,vector.z*fact);
    }
    
    public static double dotProduct(Vector3 v1, Vector3 v2)
    {
    	return v1.x*v2.x+v1.y*v2.y+v1.z*v2.z;
    }
    
    public static Vector3 crossProduct(Vector3 v1, Vector3 v2)
    {
    	double x=v1.y*v2.z-v1.z*v2.y;
    	double y=v1.z*v2.x-v1.x*v2.z;
    	double z=v1.x*v2.y-v1.y*v2.x;
    	return new Vector3(x,y,z);
    }
    
    
    //......to be completed.......
}
