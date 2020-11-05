package polytech.ADCE.IWAMicroserviceProximity.repositories;

import polytech.ADCE.IWAMicroserviceProximity.models.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationModel,Long> {

}