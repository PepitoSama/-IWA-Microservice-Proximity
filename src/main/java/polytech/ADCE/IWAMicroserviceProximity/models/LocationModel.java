
package polytech.ADCE.IWAMicroserviceProximity.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="geolocation")
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LocationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private long latitude;
    private long longitude;
    private Date geolocation_timestamp;

    public LocationModel() {}

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public Date getGeolocation_timestamp() {
        return geolocation_timestamp;
    }

    public void setGeolocation_timestamp(Date geolocation_timestamp) {
        this.geolocation_timestamp = geolocation_timestamp;
    }

    public String toString() {
        return "User : " + this.user_id + " Lat : " + this.latitude + " Long : " + this.longitude + " timestamp : " + this.getGeolocation_timestamp();
    }
}