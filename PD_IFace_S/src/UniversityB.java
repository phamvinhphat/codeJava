
public class UniversityB implements University{
	public String calculatePoint(float point) {
		return new Integer(Math.round( point / 2 ) ).toString();
	}
}
