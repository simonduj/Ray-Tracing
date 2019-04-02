

import java.util.LinkedList;

/**
 *
 * @author ramin
 */
public class RayTracing {
    private static final int screenWidth=800;
    private static final int screenHeight=600;
    
    private final OutputWindow outputWindow;
    
    private Vector3 pCam,dCam,up;
        
    // List of all objects
    LinkedList<RealObject> objects=new LinkedList<>();
    
    public RayTracing() {
        outputWindow=new OutputWindow(screenWidth,screenHeight);
        
        
              
        // initialize scene
		//......to be completed.......
		//......initialize your scene here......
		//......(create objects and add them to the "objects" list, etc.)......
        this.pCam=new Vector3(0,0,15);
        this.dCam=new Vector3(0,0,-1);
        this.up=new Vector3(0,1,0);
        objects.add(new Sphere(new Vector3(0,2,0),2,new Vector3(56,56,56)));
        objects.add(new Sphere(new Vector3(4,0,2),2,new Vector3(255,0,0)));
        objects.add(new Plane(new Vector3(0,-4,0),new Vector3(0,1,0),new Vector3(0,255,0)));
        
        
    }   

    private ColorRGB traceRay(Vector3 rayPosition,Vector3 rayDirection) {
        // find the closest object hit by the ray (intersectScene)
        //
    	double t_min=Double.MAX_VALUE;
    	RealObject object_min=null;
    	double epsilon=10^(-3);
    	
    	for(RealObject object : objects)
    	{
    		double t_hit=object.testCollision(rayPosition, rayDirection);
    		if(t_hit>epsilon && t_hit<t_min)
    		{
    			t_min=t_hit;
    			object_min=object;
    		}
    	}
        
        // return the color
    	if(object_min==null) return new ColorRGB(new Vector3(0,0,0));
        
    	return new ColorRGB(object_min.color);
    }
    
    private void renderScreen() {  
		// calculate delta_x and delta_y
        //
    	Vector3 right=Vector3.crossProduct(up, dCam);
    	Vector3 delta_x=Vector3.multiply(right,(double) (1/screenWidth));
    	Vector3 delta_y=Vector3.multiply(up,(double) (1/screenHeight));
        
        // go through all points of the image plane
        //..... for
        //.........for
        //............calculate color with traceRay(...)
        //............outputWindow.setPixel(x+screenWidth/2,screenHeight/2-1-y,color);
    	for(int y=-screenHeight/2;y<screenHeight/2;y++)
    	{
    		for(int x=-screenWidth/2;x<screenWidth/2;x++)
    		{
    			Vector3 d=Vector3.normalized(Vector3.add(Vector3.add(dCam, Vector3.multiply(delta_x, x)), Vector3.multiply(delta_y, y)));
    			ColorRGB color=traceRay(pCam,d);
    			outputWindow.setPixel(x+screenWidth/2,screenHeight/2-1-y,color);
    		}
    	}
        
        // show the result
        outputWindow.showResult();
    }
    
    public static void main(String[] args) {
        new RayTracing().renderScreen();               
    }
    
}
