package com.gilsontsc.newcarshopbatch.configuration.chuncklet;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;

import com.gilsontsc.newcarshopbatch.dto.CarroDto;

public class CarroItemReader implements ItemReader<CarroDto>, StepExecutionListener{

	private static final Logger LOGGER = LoggerFactory.getLogger(CarroItemReader.class);
	private Iterator<CarroDto> carroInterator;
	
	@SuppressWarnings("unchecked")
	@Override
	public void beforeStep(StepExecution stepExecution) {
		ExecutionContext ec = stepExecution.getJobExecution().getExecutionContext();
		List<CarroDto> carroDtoList = (List<CarroDto>) ec.get("carroInList");
		this.carroInterator = carroDtoList.iterator();
		LOGGER.info("Iniciando o READER...");
	}
	
	@Override
	public CarroDto read() {
		if(this.carroInterator != null && this.carroInterator.hasNext()) {
			return this.carroInterator.next();
		}
		return null;
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		LOGGER.info("Finalizando o READER...");
		return ExitStatus.COMPLETED;
	}

}