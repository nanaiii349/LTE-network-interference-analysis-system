package com.example.commonutils;


import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

public class LoggerFormatter extends Formatter{

    @Override
    public String format(LogRecord record) {
        return "[" + new Date() + "]" + " [" + record.getLevel() + "] "
                + record.getClass() +" "+ record.getMessage() + "\n";
    }
}
