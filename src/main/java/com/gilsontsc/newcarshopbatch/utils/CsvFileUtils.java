package com.gilsontsc.newcarshopbatch.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.gilsontsc.newcarshopbatch.dto.CarroDto;
import com.gilsontsc.newcarshopbatch.model.Carro;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CsvFileUtils {

    private static final String PATH_INPUT_FILE = "csv/fileInput/";
    private static final String PATH_OUTPUT_FILE = "src/main/resources/csv/fileOutput/";
    private CSVReader csvReader;
    private CSVWriter csvWriter;
    private String fileName;
    private File file;
    private FileReader fileReader;
    private FileWriter fileWriter;

    public CsvFileUtils(String fileName, boolean isInput) {

        if(isInput){
            this.fileName = PATH_INPUT_FILE + fileName + ".csv";
        }else {
            this.fileName = PATH_OUTPUT_FILE + fileName + "-" + DateUtils.getNow() + "-.csv";
        }
    }

    public CarroDto read() throws IOException {

        if(this.csvReader == null){
            getFileToRead();
            getFileReader();
            getCSVReader();
        }

        String[] fields = this.csvReader.readNext();

        if(fields == null){
            return null;
        }

        List<String> list = Arrays.asList(fields);

        if(list.size() >= 6){
            return new CarroDto(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));
        }

        return new CarroDto(list.toString());
    }

    private void getFileToRead() {

        ClassLoader classLoader = this.getClass().getClassLoader();

        if(this.file == null){
            String filePath = classLoader.getResource(this.fileName).getFile();
            this.file = new File(filePath);
        }
    }

    private void getFileReader() throws FileNotFoundException {
        if(this.fileReader == null){
            this.fileReader = new FileReader(this.file);
        }
    }

    private void getCSVReader() {
        if(this.csvReader == null){
            this.csvReader = new CSVReader(this.fileReader);
        }
    }

    public void closeReader() throws IOException {
        this.csvReader.close();
        this.fileReader.close();
    }

    public void writer(Carro carro) throws IOException {

        if(this.csvWriter == null){
            getFileToWrite();
            getFileWriter();
            getCSVWriter();
        }

        List<String> carroList = new ArrayList<>();
        carroList.add(carro.getId().toString());
        carroList.add(carro.getRenavam());
        carroList.add(carro.getMarca());
        carroList.add(carro.getModelo());

        if(carro.getAnoFabricacao() != null){
            carroList.add(carro.getAnoFabricacao().toString());
        }

        if(carro.getAnoModelo() != null){
            carroList.add(carro.getAnoModelo().toString());
        }

        if(carro.getValorCompra() != null){
            carroList.add(carro.getValorCompra().toString());
        }

        if(carro.getValorVenda() != null){
            carroList.add(carro.getValorVenda().toString());
        }

        if(carro.getPercentalMaxDesconto() != null){
            carroList.add(carro.getPercentalMaxDesconto().toString());
        }

        if(carro.getLoja() != null){
            carroList.add(carro.getLoja().toString());
        }

        carroList.add(DateUtils.getNow());

        this.csvWriter.writeNext(carroList.stream().toArray(String[]::new));
    }


    public void writerError(String[] carroError) throws IOException {

        if(this.csvWriter == null){
            getFileToWrite();
            getFileWriter();
            getCSVWriter();
        }

        this.csvWriter.writeNext(carroError);
    }

    private void getFileToWrite() throws IOException {
        if(this.file == null){
            this.file = new File(this.fileName);
            this.file.createNewFile();
        }
    }

    private void getFileWriter() throws IOException {
        if(this.fileWriter == null){
            this.fileWriter = new FileWriter(this.file, true);
        }
    }

    private void getCSVWriter() {
        if (this.csvWriter == null){
            this.csvWriter = new CSVWriter(this.fileWriter);
        }
    }

    public void closeWriter() throws IOException {
        this.csvWriter.close();
    }

}