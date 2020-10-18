
public class UniversityA implements University {
	public String calculatePoint(float point) {
		if (point > 8.5) {
			return "A";
		} else if (point > 7.5) {
			return "B";
		} else if(point > 6.5) {
			return "C";
		} else {
			return "D";
		}
	}
}
