package com.gilsontsc.newcarshopbatch.configuration.tasklet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.gilsontsc.newcarshopbatch.dto.CarroDto;
import com.gilsontsc.newcarshopbatch.utils.CsvFileUtils;
import com.gilsontsc.newcarshopbatch.validate.CarroValidate;

public class CarroValidateTasklet implements Tasklet, StepExecutionListener {

	private List<CarroDto> carroDtoList;
	private String fileName;
	
	public CarroValidateTasklet() {}
	
	public CarroValidateTasklet(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void beforeStep(StepExecution stepExecution) {
		this.carroDtoList = new ArrayList<>();
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		stepExecution.getJobExecution()
					 .getExecutionContext()
					 .put("carroInList", this.carroDtoList);
		return ExitStatus.COMPLETED;
	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		CsvFileUtils csvIn = new CsvFileUtils(this.fileName, true);
		
		CarroDto carroDto = csvIn.read();
		
		while(carroDto != null) {
			this.carroDtoList.add(carroDto);
			carroDto = csvIn.read();
		}
		
		csvIn.closeReader();
		
		this.carroDtoList = CarroValidate.validate(this.carroDtoList);
		
		if(this.carroDtoList.isEmpty()) {
			throw new RuntimeException("A lista de carros validos está vazia!");
		}
		
		return RepeatStatus.FINISHED;
	}

}