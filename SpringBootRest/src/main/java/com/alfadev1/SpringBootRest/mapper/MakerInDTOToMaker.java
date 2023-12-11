/*package com.alfadev1.SpringBootRest.mapper;

import com.alfadev1.SpringBootRest.persistence.entity.Maker;
import com.alfadev1.SpringBootRest.persistence.entity.Product;
import com.alfadev1.SpringBootRest.service.dto.MakerInDTO;
import com.alfadev1.SpringBootRest.service.dto.ProductInDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MakerInDTOToMaker implements Imapper <MakerInDTO, Maker> {

    @Override
    public Maker map(MakerInDTO in) {
        Maker maker = new Maker();
        maker.setName(in.getName());
        maker.setProductList(in.getProductList());
        return maker;
    }


}*/
