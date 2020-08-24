package com.gilsontsc.newcarshopbatch.utils;

import java.math.BigDecimal;

import com.gilsontsc.newcarshopbatch.enums.LojaEnum;
import com.gilsontsc.newcarshopbatch.enums.PercentEnum;

public class CarroUtils {

    private static final BigDecimal _99_H = new BigDecimal("99999.99");
    private static final BigDecimal _149_H = new BigDecimal("149999.99");

    public static LojaEnum chooseStore(String price) {

        BigDecimal valor = convertToBigDecimal(price);

        if(valor == null){
            return null;
        }

        if(isLojaPaulista(valor)){
            return LojaEnum.LOJA_AV_PAULISTA;
        }

        if(isLojaIbirapuera(valor)){
            return LojaEnum.LOJA_IBIRAPUERA;
        }

        if(isLojaJardins(valor)){
            return LojaEnum.LOJA_JARDINS;
        }

        return null;
    }

    public static BigDecimal calculateDiscount(String valorVenda) {

        BigDecimal valor = convertToBigDecimal(valorVenda);

        if(valor == null){
            return null;
        }

        if(isLojaPaulista(valor)){
            return new BigDecimal(PercentEnum.P_10.getPercent());
        }

        if(isLojaIbirapuera(valor)){
            return new BigDecimal(PercentEnum.P_05.getPercent());
        }

        if(isLojaJardins(valor)){
            return new BigDecimal(PercentEnum.P_02.getPercent());
        }

        return null;
    }

    public static BigDecimal calculatePrice(String valorCompra) {

        BigDecimal valor = convertToBigDecimal(valorCompra);

        if(valor == null){
            return null;
        }

        if(isLojaPaulista(valor)){
            return valor.add(valor.multiply(new BigDecimal(PercentEnum.P_25.getPercent())));
        }

        if(isLojaIbirapuera(valor)){
            return valor.add(valor.multiply(new BigDecimal(PercentEnum.P_15.getPercent())));
        }

        if(isLojaJardins(valor)){
            return valor.add(valor.multiply(new BigDecimal(PercentEnum.P_05.getPercent())));
        }

        return null;
    }

    private static BigDecimal calculateAddPercent(BigDecimal valorOriginal, PercentEnum percentEnum) {
        return valorOriginal.add(calculatePercent(valorOriginal, percentEnum));
    }

    private static BigDecimal calculateSubtractPercent(BigDecimal valorOriginal, PercentEnum percentEnum) {
        return valorOriginal.subtract(calculatePercent(valorOriginal, percentEnum));
    }

    private static BigDecimal calculatePercent(BigDecimal valorOriginal, PercentEnum percentEnum) {
        return valorOriginal.multiply(new BigDecimal(percentEnum.getPercent()));
    }

    private static boolean isLojaJardins(BigDecimal valor) {
        return valor.compareTo(_149_H) == 1;
    }

    private static boolean isLojaIbirapuera(BigDecimal valor) {
        return ((valor.compareTo(_149_H) == 0) || (valor.compareTo(_99_H) == 1) && (valor.compareTo(_149_H) == -1));
    }

    private static boolean isLojaPaulista(BigDecimal valor) {
        return (valor.compareTo(_99_H) <= 0) && (valor.compareTo(_99_H) <= 0);
    }

    public static BigDecimal convertToBigDecimal(String valor) {
        try {
            return new BigDecimal(valor);
        }catch(Exception e){
            return null;
        }
    }

    public static Integer convertToInteger(String ano) {
        try {
            return Integer.parseInt(ano);
        }catch(Exception e){
            return null;
        }
    }

//    public static void main(String[] args) {
//
//        System.out.println("ano: " + convertToInteger("2017"));
//
//        System.out.println("40: " + chooseStore("40000.00"));
//        System.out.println("98: " + chooseStore("98000.00"));
//        System.out.println("99: " + chooseStore("99999.99"));
//        System.out.println("100: " + chooseStore("100000.00"));
//        System.out.println("148: " + chooseStore("148000.00"));
//        System.out.println("149: " + chooseStore("149999.99"));
//        System.out.println("150: " + chooseStore("150000.00"));
//        System.out.println("299: " + chooseStore("299000.00"));
//    }

}