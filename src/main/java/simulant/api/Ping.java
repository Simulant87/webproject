package simulant.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * A simple Ping Service to test if the Server is online.
 * 
 * @author Simulant
 *
 */
@Controller
public class Ping {

	/**
	 * Simple GET of String to test if the Server is online.
	 *
	 * @return The String: {"ping": pong}
	 */
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody String getPing() {
		return "{\"ping\": \"pong\"}";
	}

	@RequestMapping(value = "/pong", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody String postPong(@RequestBody String pong) {
		return pong;
	}
}
