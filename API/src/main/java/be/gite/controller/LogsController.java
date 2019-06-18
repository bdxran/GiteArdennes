package be.gite.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import be.gite.entity.Logs;
import be.gite.service.LogsService;

@RestController
@RequestMapping(path = "/logs")
public class LogsController {

	@Autowired
	private LogsService service;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Iterable<Logs> getLogs() {
		return service.getLogs();
	}
	
	@GetMapping(value = "{date}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Iterable<Logs> getLogsByDate(@PathVariable Date date) {
		return service.getLogsByDate(date);
	}
}
