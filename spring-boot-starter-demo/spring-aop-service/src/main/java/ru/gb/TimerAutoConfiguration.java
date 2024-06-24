package ru.gb;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import ru.gb.aspect.TimerAspect;
import ru.gb.http.aop.AopFilter;

/**
 * Класс-конфигурация бина стартера. Нужен для того, чтобы Spring нашел бин стартера независимо от
 * названия пакетов. Чтобы Spring нашел данную конфигурацию, нужно прописать путь к классу в файле
 * resources/META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports
 * (начиная с версии 2.7)
 */
@Configuration
//@EnableConfigurationProperties()
public class TimerAutoConfiguration {

  @Bean
  AopFilter timerAspect() {

    return new AopFilter();
  }
}
