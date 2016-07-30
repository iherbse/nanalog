package kr.co.nanalog.api.web.util.model.request;

/**
 * Created by Leegain on 2016-07-30.
 */
public class WeatherRequest {

    private String city;
    private String country;
    private String village;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }


    @Override
    public String toString() {
        return "WeatherParam{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", village='" + village +
                '}';
    }
}
