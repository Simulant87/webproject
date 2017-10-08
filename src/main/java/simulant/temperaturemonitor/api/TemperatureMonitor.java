package simulant.temperaturemonitor.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import simulant.temperaturemonitor.persistence.model.TemperatureMeasurement;
import simulant.temperaturemonitor.service.TemperatureService;

import java.util.Date;
import java.util.List;

/**
 * Created by Nils on 18.03.2017.
 */
@CrossOrigin
@Controller
public class TemperatureMonitor {

    @Autowired
    TemperatureService temperatureService;

    @RequestMapping(value = "/temperature", method = RequestMethod.GET)
    @ResponseBody
    public List<TemperatureMeasurement> getTemperatureList(
            @RequestParam(value="fromDate", required = false) @DateTimeFormat(pattern="dd-MM-yyyy") Date fromDate,
            @RequestParam(value="toDate", required = false) @DateTimeFormat(pattern="dd-MM-yyyy") Date toDate) {

        List<TemperatureMeasurement> measurements = temperatureService.getTemperatureList(fromDate, toDate);
        return measurements;
    }

    @RequestMapping(value = "/temperature", method = RequestMethod.POST)
    @ResponseBody
    public String postTemperature(@RequestBody TemperatureMeasurement temperatureMeasurement) {
        temperatureService.save(temperatureMeasurement);
        return null;
    }

}
