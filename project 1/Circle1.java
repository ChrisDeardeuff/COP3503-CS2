class Circle1 extends GeometricObject1 {
	protected double radius;

	public Circle1() {

		this(1.0, "white", 1.0);

	}

// Create circle with specified radius

	public Circle1(double radius) {

		super("white", 1.0);

		this.radius = radius;

	}

// Create a circle with specified radius, weight, and color

	public Circle1(double radius, String color, double weight) {

		super(color, weight);

		setRadius(radius);
	}

// Getter method for radius

	public double getRadius() {

		return radius;
	}

// Setter method for radius

	public void setRadius(double radius) {

		this.radius = radius;
	}

// use findArea method here

	public double findArea() {

		double area = Math.PI * Math.pow(radius, 2);
		return area;
	}

// use findArea method here

	public double findPerimeter() {

		return 2 * radius * Math.PI;
	}

// Override the equals() method defined in the Object class

	public boolean equals(Circle1 circle) {

		return this.radius == circle.getRadius();
	}

	@Override

	public String toString() {

		return "A Circle with a radius of " + radius;
	}

	

	public int compareTo(GeometricObject1 o) {

		if (getRadius() > ((Circle1) o).getRadius()) {

			return 1;

		}else if (getRadius() < ((Circle1) o).getRadius()){

		return -1;
	
		}else {
			
			return 0;
		}
	}

	public static Circle1 max(Circle1 o1, Circle1 o2) {

		if (o1.findArea() > o2.findArea()) {

			return o1;

		}else {

			return o2;
		}

	}

	
	
}