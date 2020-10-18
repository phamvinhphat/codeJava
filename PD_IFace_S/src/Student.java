
public class Student {

	private String name;
	private float Point;
	private University university;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPoint() {
		return Point;
	}
	public void setPoint(float point) {
		Point = point;
	}
	public University getUniversity() {
		return university;
	}
	public void setUniversity(University university) {
		this.university = university;
	}
	
	public void displayName() {
		System.out.println(name + " gets " + university.calculatePoint(Point) );
	}
	
	public static void main(String args[]) {
		Student s1 = new Student();
		s1.setName("Long");
		s1.setPoint(7f);
		s1.setUniversity(new UniversityB());
		s1.displayName();
	}
}
