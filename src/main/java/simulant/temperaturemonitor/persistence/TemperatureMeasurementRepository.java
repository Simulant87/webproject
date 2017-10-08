package simulant.temperaturemonitor.persistence;

import org.springframework.data.repository.CrudRepository;
import simulant.temperaturemonitor.persistence.model.TemperatureMeasurement;

import java.util.Date;
import java.util.List;

/**
 * Created by Nils on 18.03.2017.
 */
public interface TemperatureMeasurementRepository extends CrudRepository<TemperatureMeasurement, Long> {

    /**
     * returns all measurements with valid values within the given dates.
     *
     * @return all measurements with complete values.
     */
    List<TemperatureMeasurement> findByDateBetweenOrderByDateAsc(Date start, Date end);

}
