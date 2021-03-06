package com.deepak.training.spring3.config.daythree;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.deepak.training.spring3.daythree.ActorArtist;
import com.deepak.training.spring3.daythree.Artist;
import com.deepak.training.spring3.daythree.AspectjAudience;
import com.deepak.training.spring3.daythree.Audience;
import com.deepak.training.spring3.daythree.Dancer;
import com.deepak.training.spring3.daythree.Instrumentalist;
import com.deepak.training.spring3.daythree.Singer;

@Configuration
@EnableAspectJAutoProxy
public class DayThreeConfig {

    @Bean
    public Audience audience() {
        return new Audience();
    }
    
    @Bean 
    public Instrumentalist instrumentalist() {
        Instrumentalist instrumentalist = new Instrumentalist();
        instrumentalist.setSong("twinkle twinkle");
        
        return instrumentalist;
    }
    
    @Bean 
    public Artist actor() {
        return new ActorArtist();
    }
    
    @Bean 
    public Dancer dancer() {
        return new Dancer();
    }
    
    @Bean
    public AspectjAudience aspectjAudience() {
        return new AspectjAudience();
    }
    
    @Bean 
    public Singer singer() {
        return new Singer();
    }
}
