package com.testapiparse.parser;

import lombok.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class Parser {
    @SneakyThrows
    public static void main(String[] args) {
        try {
            Document document = Jsoup.connect("https://valuta.kg/").get();
            var titleElements = document.select("h4");
            for (var element: titleElements) {
                System.out.println(element.text());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}