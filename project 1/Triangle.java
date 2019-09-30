class Triangle extends GeometricObject {
     
	double side1;
	double side2;
	double side3;
	
	public Triangle() {
		super();
		side1 = 1.0;
		side2= 1.0;
		side3 =1.0;
	}
	public Triangle(double side1, double side2, double side3) {
		super();
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		
	}
	public double getside1() {
		
		return side1;
		
	}
	public void setside1(double side1) {
		this.side1 = side1;
	}
	public double getside2() {
		
		return side2;
		
	}
	public void setside2( double side2) {
		this.side2= side2;
	}
	public double getside3() {
		return side3;
		}
	public void setside3(double side3) {
		this.side3 =side3;
	}
	public double getArea() {
		//area is (Height*Base)/2
		//to find height, take half of base and the side2. use A^2+B^2 = c^2
	double Area;
	double base = side1;
	double height= Math.pow(base/2, 2)+Math.pow(side2, 2);
	height = Math.pow(height, 2);
	
	Area = (height*base)/2;
	
	return Area;
		
	}
	public double getPerimeter() {
		
		double perimeter = side1+side2+side3;
		
		return perimeter;
	}
	public String toString() {
		
		return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
		
	}
	
	
	
}