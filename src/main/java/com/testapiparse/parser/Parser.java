package com.testapiparse.parser;

import lombok.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.util.List;
import java.util.Arrays;

public class Parser {
    @SneakyThrows
    public static void main(String[] args) {

        List<String> validCurrencies = Arrays.asList("usd", "eur", "rub", "kzt");

        try {
            Document document = Jsoup.connect("https://valuta.kg/").get();

            Elements banks = document.select("div.td-member__info h4"); // название банков
            Elements rates = document.select(".td-rate");  // курсы

            int numBanks = banks.size();
            int numRates = rates.size();
            int pairsPerRow = 4;  // Число валютных пар в каждой строке

            if (numBanks * pairsPerRow != numRates) {
                System.out.println("Недостаточное количество данных на странице.");
                return;
            }

            for (int bankIndex = 0; bankIndex < numBanks; bankIndex++) {
                StringBuilder bankCurrencyString = new StringBuilder();
                String bankName = banks.get(bankIndex).text();

                for (int row = 0; row < pairsPerRow; row++) {
                    int pairIndex = bankIndex * pairsPerRow + row;
                    String currencyName = validCurrencies.get(row);
                    String currencyPair = rates.get(pairIndex * 2).text() + " / " + rates.get(pairIndex * 2 + 1).text();
                    bankCurrencyString.append(currencyName + ": " + currencyPair);

                    if (row < pairsPerRow - 1) {
                        bankCurrencyString.append(", ");
                    }
                }

                System.out.println(bankName + ": " + bankCurrencyString.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
