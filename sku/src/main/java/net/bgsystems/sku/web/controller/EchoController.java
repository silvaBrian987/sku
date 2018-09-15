package net.bgsystems.sku.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.bgsystems.sku.business.entity.Echo;
import net.bgsystems.sku.business.entity.Type;

@RestController
@RequestMapping("echo")
public class EchoController {
	private static final Logger LOGGER = LogManager.getLogger(EchoController.class);

	@RequestMapping("hello")
	public ResponseEntity<String> hello(@RequestBody Echo echo) throws Throwable {
		LOGGER.info(echo);
		String echoResponse = "Hello " + echo.getName() + " with type " + echo.getType();
		LOGGER.info(echoResponse);
		return ResponseEntity.ok(echoResponse);
	}

	@RequestMapping(path = "types", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public @ResponseBody Type[] getType() {
		return Type.values();
	}
}
