package com.alfadev1.SpringBootRest.mapper;

import org.springframework.stereotype.Component;

@Component
public interface Imapper <I, O>{
    public O map(I in);
}
