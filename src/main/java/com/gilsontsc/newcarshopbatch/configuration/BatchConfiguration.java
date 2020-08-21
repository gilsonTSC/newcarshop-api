package com.gilsontsc.newcarshopbatch.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	private JobBuilderFactory jobBuildFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job job() {
		return this.jobBuildFactory.get("carrosJob")
				.start(carroValidadeTaskStep())
				.next(carroEnriquecimentoChunckletStep(carroItemReader(),
													   carroItemProcessor(),
													   carroItemWriter()
													))
				.build();
	}

	@Bean
	private Step carroValidadeTaskStep() {
		return this.stepBuilderFactory.get("carroValidadetaskletStep")
				.tasklet(new CarroValidadeTasklet("Carros-import"))
				.build();
	}
	
	@Bean
	public Step carroEnriquecimentoChunckletStep(ItemReader<CarroDto> carroItemReader,
												 ItemProcessor<CarroDto, Carro> carroItemProcessor
												 ItemWriter<Carro> carroItemWriter
			) {
		return this.stepBuilderFactory.get("carroEnriquecimentoChunckletStep")
				.<CarroDto, Carro>chunk(5)
				.reader(carroItemReader)
				.processor(carroItemProcessor)
				.writer(carroItemWriter)
				.build();
	}
	
	@Bean
	public ItemReader<CarroDto> carroItemReader(){
		return new CarroItemReader();
	}
	
	@Bean
	public ItemProcessor<CarroDto, Carro> carroItemProcessor(){
		return new CarroItemProcessor();
	}
	
	@Bean
	public ItemWriter<CarroDto> carroItemWriter(){
		return new CarroItemWriter();
	}
	
}