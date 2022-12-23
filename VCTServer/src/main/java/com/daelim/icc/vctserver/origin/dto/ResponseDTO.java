package com.daelim.icc.vctserver.origin.dto;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "lists")
public class ResponseDTO {
    private VegetableDTO vegetableDTO;

    @XmlElementWrapper(name = "list")
    public VegetableDTO getVegetableDTO() {
        return vegetableDTO;
    }
}