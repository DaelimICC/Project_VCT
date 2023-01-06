package com.daelim.icc.vctserver.origin.response;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@Document("vegetable")
public class Vegetable {

    @XmlElement(name = "PUM_NM_A")
    public String name;

    @Id
    @XmlElement(name = "PUM_CD")
    public Integer code;

    @XmlElement(name = "G_NAME_A")
    public String grade;

    @XmlElement(name = "UNIT_QTY")
    public String tradeQuantity;

    @XmlElement(name = "U_NAME")
    public String tradeUnitQuantity;

    @XmlElement(name = "AV_P_A")
    public Double avgPrice;

    @XmlElement(name = "PAV_P_A")
    public Double preAvgPrice;

//    @XmlElement(name = "PAV_PY_A")
//    public String preYearPrice;

    @XmlElement(name = "A_B")
    public Double fluctuationRate;

//    @XmlElement(name = "E_NAME")
//    public String entityGrade;
//
//    @XmlElement(name = "F_NAME")
//    public String tradeUnit;
//
//    @XmlElement(name = "GRADE_CD")
//    public String gradeCode;
//
//    @XmlElement(name = "UNIT_CD")
//    public String unitCode;
}
