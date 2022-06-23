package com.dreamteam.crm.democrm.util;



// специальный класс, куда можно добавлять любые статичные методы для вывода логов

import lombok.extern.java.Log;

@Log
public class MyLogger {

    public static void debugMethodName(String text){
        System.out.println();
        System.out.println();
        // log.log(Level.INFO, text);
        log.info(text); // аналогичная запись но более короткая

    }

}
