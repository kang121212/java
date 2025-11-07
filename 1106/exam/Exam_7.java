/*
 * 실습문제 7
 * 도시이름, 위도, 경도 정보를 가진 Location 클래스를 작성하고 다음 문제를 풀어라.
 * 1) 도시 이름을 '키'로 하는 HashMap<String, Location> 컬랙션을 만들고,
 * 사용자로부터 입력 받아 4개의 도시를 저장하라. 그리고 도시 이름으로 검색하는 LocationManager
 * 클래스를 작성하라.
 */

package generic;

import java.util.HashMap;
import java.util.Scanner;

class Location{
	private String city;
	private double latitude;
	private double longitude;
	
	public Location(String city, double latitude, double longitude) {
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public String getCity() {
		return city;
	}
	public double geteLatitude() {
		return latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public String toString() {
		return city + " (" + latitude + ", " + longitude + ")";
	}
}

public class Exam_7 {
	private HashMap<String, Location> locationMap = new HashMap<>();
	public void inputLocations() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("도시이름 : ");
		
		for(int i=0; i<4; i++) {
			String city = scanner.nextLine();
			
			System.out.print("위도: ");
			double lat = Double.parseDouble(scanner.nextLine());
			
			System.out.print("경도: ");
			double lon = Double.parseDouble(scanner.nextLine());
			
			locationMap.put(city, new Location(city, lat, lon));
	
		}
		scanner.close();
	}
	
	public void searchLocation() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n도시 이름으로 위치를 검색");
		
		while(true) {
			System.out.print("도시 이름: ");
			String city = scanner.nextLine();
			if(city.equals("그만")) break;
			
			Location loc = locationMap.get(city);
			if(loc != null) 
				System.out.println(loc);
			else
				System.out.println("해당 도시 정보가 없습니다.");
		}
		scanner.close();
		
	}
	public static void main(String[] args) {
		Exam_7 manager = new Exam_7();
		manager.inputLocations();
		manager.searchLocation();
		
		
	}
}















