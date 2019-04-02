

//public class ColorRGB {
//    
//	private double red,green,blue;
//	
//	public ColorRGB(Vector3 vector)
//	{
//		this.red=vector.x;
//		this.green=vector.y;
//		this.blue=vector.z;
//	}
//}


public class ColorRGB {
    
	public double r,g,b;
	
	public ColorRGB(Vector3 vector)
	{
		this.r=vector.x/255;
		this.g=vector.y/255;
		this.b=vector.z/255;
	}
}
