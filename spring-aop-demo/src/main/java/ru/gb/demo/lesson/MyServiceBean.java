package ru.gb.demo.lesson;

import org.springframework.stereotype.Component;

@Component
public class MyServiceBean {

    public String Method1(String args){
        //что-то делаем
        return "Result: [" + args + "]";
    }

    public String Method2(String args){
        //что-то делаем
        return "Result: [" + args + "]";
    }
}
