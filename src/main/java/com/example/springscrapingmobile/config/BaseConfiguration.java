package com.example.springscrapingmobile.config;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.springscrapingmobile.component")
public class BaseConfiguration {
    @Bean
    public WebDriver webDriver(){
        return new HtmlUnitDriver(BrowserVersion.CHROME,true){
            @Override
            protected WebClient modifyWebClient(WebClient client) {
                final  WebClient webClient = super.modifyWebClient(client);
                return webClient;
            }
        };
    }
}
