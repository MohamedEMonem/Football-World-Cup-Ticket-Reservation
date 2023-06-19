public class City {
    private final String cityName;
    private final String stadiumName;

    public City(String cityName, String stadiumName) {
        this.cityName = cityName;
        this.stadiumName = stadiumName;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    @Override
    public String toString() {
        return "City [cityName=" + cityName + ", stadiumName=" + stadiumName + "]";
    }
    
}
