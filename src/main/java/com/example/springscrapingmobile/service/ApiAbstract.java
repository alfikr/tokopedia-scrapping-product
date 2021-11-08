package com.example.springscrapingmobile.service;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

public abstract class ApiAbstract {
    protected CsvParser getCsvParser(){
        CsvParserSettings settings = new CsvParserSettings();
        settings.setLineSeparatorDetectionEnabled(true);
        CsvParser parser=new CsvParser(settings);
        return parser;
    }
    public abstract Object getData();
}

