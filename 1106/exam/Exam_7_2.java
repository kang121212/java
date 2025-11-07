package generic;

import java.util.ArrayList;
import java.util.Scanner;

class Location1 {
    private String city;
    private double latitude;
    private double longitude;

    public Location1(String city, double latitude, double longitude) {
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String toString() {
        return city + " (" + latitude + ", " + longitude + ")";
    }
}

public class Exam_7_2 {
    private ArrayList<Location1> locationList = new ArrayList<>();

    public void inputLocations() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("도시 이름, 위도, 경도를 입력하세요");

        for (int i = 0; i < 4; i++) {
            System.out.print("도시 이름 : ");
            String city = scanner.nextLine();

            System.out.print("위도: ");
            double lat = Double.parseDouble(scanner.nextLine());

            System.out.print("경도: ");
            double lon = Double.parseDouble(scanner.nextLine());

            locationList.add(new Location1(city, lat, lon));
        }
        scanner.close();
    }

    public void searchLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n도시 이름으로 위치를 검색합니다.");

        while (true) {
            System.out.print("도시이름: ");
            String city = scanner.nextLine();
            if (city.equals("그만")) break;

            boolean found = false;
            for (Location1 loc : locationList) {
                if (loc.getCity().equals(city)) {
                    System.out.println(loc);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("해당 도시 정보가 없습니다.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Exam_7_2 manager = new Exam_7_2();
        manager.inputLocations();
        manager.searchLocation();
    }
}