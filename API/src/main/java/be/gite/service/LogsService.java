package be.gite.service;

import java.util.Date;

import be.gite.entity.Logs;

public interface LogsService {

	Iterable<Logs> getLogs();
	
	Iterable<Logs> getLogsByDate(Date date);
}
