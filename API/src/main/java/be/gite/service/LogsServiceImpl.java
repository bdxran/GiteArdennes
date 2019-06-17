package be.gite.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.gite.entity.Logs;
import be.gite.repository.LogsRepository;

@Service
public class LogsServiceImpl implements LogsService {

	@Autowired
	private LogsRepository repository;

	public Iterable<Logs> getLogs() {
		return repository.findAll();
	}
	
	public Iterable<Logs> getLogsByDate(Date date) {
		return repository.getLogsByDate(date);
	}
}
