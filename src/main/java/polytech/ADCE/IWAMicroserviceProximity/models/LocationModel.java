
package polytech.ADCE.IWAMicroserviceProximity.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity(name="geolocation")
@IdClass(LocationId.class)
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LocationModel {

    @Id
    private String username;
    @Id
    private Date geolocation_timestamp;
    private double latitude;
    private double longitude;

    public LocationModel() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Date getGeolocation_timestamp() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(geolocation_timestamp);
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        return calendar.getTime();
    }

    public void setGeolocation_timestamp(Date geolocation_timestamp) {
        this.geolocation_timestamp = geolocation_timestamp;
    }

    public String toString() {
        return "User : " + this.username + " Lat : " + this.latitude + " Long : " + this.longitude + " timestamp : " + this.getGeolocation_timestamp();
    }
}