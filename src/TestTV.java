class Circle{
double radius;
Circle(){
   radius = 1;
}
Circle(double newRadius){
   radius = newRadius;
}
double getArea(){
   return radius * radius * Math.PI;
}
double getPerimeter(){
   return 2 * radius * Math.PI;
}

public class TestCircle{
public static void main(String[] args){
//Create Circle with radius 1
	Circle myCircle = new Circle();
	myCircle.radius = 1;
	
	

//Display the radius, area and perimeter
	System.out.println(myCircle.radius);
	System.out.println(myCircle.getArea());
	System.out.println(myCircle.getPerimeter());

//Create Circle with radius 25
	myCircle.radius = 25;

//Display the radius, area and perimeter
	System.out.println(myCircle.radius);
	System.out.println(myCircle.getArea());
	System.out.println(myCircle.getPerimeter());

	
//Create Circle with radius 125
	myCircle.radius = 125;
	
//Display the radius, area and perimeter
	System.out.println(myCircle.radius);
	System.out.println(myCircle.getArea());
	System.out.println(myCircle.getPerimeter());
}

}

}