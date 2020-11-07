package polytech.ADCE.IWAMicroserviceProximity.repositories;

import polytech.ADCE.IWAMicroserviceProximity.models.InfectedModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfectedRepository extends JpaRepository<InfectedModel,Long> {

}