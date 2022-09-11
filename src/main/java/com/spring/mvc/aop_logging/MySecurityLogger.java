package com.spring.mvc.aop_logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
@Aspect
public class MySecurityLogger {
    private static void loggingMethod(String info) {
        try (BufferedWriter loggingAddingDeletingLabor = new BufferedWriter(
                                        new FileWriter("c:/loggingAddingDeletingLabor.txt", true)))
        {
            try {
                LocalDateTime currentTime = LocalDateTime.now();
                loggingAddingDeletingLabor.write(info + currentTime + "\n");
            } catch (IOException e) {
                System.out.println("ошибка записи файла logging*");
                e.printStackTrace();
            }
        } catch (IOException e){
            System.out.println("ошибка FileWriter");
            e.printStackTrace();
        }
    }

    @After("execution(* com.spring.mvc.dao.LaborDAOImpl.saveLabor(..))")
    private void afterAddLaborAdvice () {
        System.out.println("AOP Security Alert! Logging...Someone has just added a new labor");
        String info = "New Labor has just been added in ";
        loggingMethod(info);
    }

    @After("execution(* com.spring.mvc.dao.LaborDAOImpl.deleteLabor(..))")
    private void afterDeleteLaborAdvice () {
        System.out.println("AOP Security Alert! Logging...Someone has just deleted a new labor");
        String info = "Labor has just been deleted in ";
        loggingMethod(info);
    }
}