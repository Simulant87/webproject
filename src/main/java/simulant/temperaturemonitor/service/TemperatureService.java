package simulant.temperaturemonitor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simulant.temperaturemonitor.persistence.TemperatureMeasurementRepository;
import simulant.temperaturemonitor.persistence.model.TemperatureMeasurement;

import java.util.Date;
import java.util.List;

/**
 * Created by Nils on 09.04.2017.
 */
@Service
public class TemperatureService {

    @Autowired
    private TemperatureMeasurementRepository temperatureMeasurementRepository;


    /**
     * Gets all temperature measurements between the given dates from the database.
     * The first date must be smaller as the second date to get a filled list.
     * @param fromDate the lower date from where to select, null for an unbound range.
     * @param toDate the greater date where to select, null for the current date.
     * @return a List of measurements.
     */
    public List<TemperatureMeasurement> getTemperatureList(Date fromDate, Date toDate) {
        if(fromDate == null) {
            fromDate = new Date(0L);
        }
        if(toDate == null) {
            toDate = new Date();
        } else {
            //include the specified date, by setting the time on the end of the day
            toDate.setHours(23);
            toDate.setMinutes(59);
            toDate.setSeconds(59);
        }
        List<TemperatureMeasurement> temperatureMeasurements = temperatureMeasurementRepository
                .findByDateBetweenOrderByDateAsc(fromDate, toDate);
        return temperatureMeasurements;
    }


    /**
     * stores a new temperatureMeasurement into the database.
     * @param temperatureMeasurement
     */
    public void save(TemperatureMeasurement temperatureMeasurement) {
        temperatureMeasurementRepository.save(temperatureMeasurement);
    }
}
