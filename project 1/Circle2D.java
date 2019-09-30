class Circle2D {
	private double x, y;
	private double radius;

	public Circle2D() {
		x = 0;
		y = 0;
		radius = 1;
	}

	public Circle2D(double x, double y, double radius) {

		this.x = x;
		this.y = y;
		this.radius = radius;

	}

	public double getX() {

		return x;
	}

	public void setX(double x) {

		this.x = x;

	}

	public double getY() {

		return y;

	}

	public void setY(double y) {

		this.y = y;
	}

	public double getRadius() {

		return radius;

	}

	public void setRadius(double radius) {

		this.radius = radius;

	}

	public double getPerimeter() {

		return 2 * Math.PI * radius;

	}

	public double getArea() {

		return Math.PI * radius * radius;

	}

	public boolean contains(double x, double y) {

	
	double d= distance(this.x,this.y,x,y);
	
	
		
	if(radius >= d) {
		return true;
		
	}else{
		return false;
	}
		
}

	public boolean contains(Circle2D circle) 
	{
	double bigCircleX = this.x;
	double bigCircleY = this.y;
	double smallCircleX = circle.getX();
	double smallCircleY = circle.getY();
	double smallRadius = circle.getRadius();

	
	//see if center point is within big circle. If yes, subtract the distance of the small 
	//center point from big center point from the radius of the big circle 
	//and see if its larger than small circle
	
		if(bigCircleX > smallCircleX){
			if(bigCircleY > smallCircleY){
					double inside = radius - distance(this.x, this.y, circle.getX(), circle.getY());
						if(inside >= smallRadius) {
							return true;
						}
				}	
		}			
		return false;
	}

	public boolean overlaps(Circle2D circle) {
		// distance of centers from each other
		// radius's added together
		// if radius's is larger than distance then overlap
		
		double centerDistance = distance(this.x, this.y, circle.getX(), circle.getY());
		
		double rAddedTogether = circle.getRadius() + this.radius;
		
		if(rAddedTogether >= centerDistance) {
			return true;
		}else {
			return false;
		}
		
	}

	private static double distance(double x1, double y1, double x2, double y2) {
		
		return Math.sqrt(Math.pow((x2-x1), 2)+ Math.pow((y2-y1), 2));
		
	}
}
