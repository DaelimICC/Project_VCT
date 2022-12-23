package com.daelim.icc.vctserver.origin.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "list")
@XmlAccessorType(XmlAccessType.FIELD)
public class VegetableDTO {
    @XmlElement(name = "PUM_NM_A")
    private String vegetableName;

    @XmlElement(name = "U_NAME")
    private String unitName;

    @XmlElement(name = "AV_P_A")
    private String averagePrice;
}
