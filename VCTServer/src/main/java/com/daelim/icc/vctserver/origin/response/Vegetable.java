package com.daelim.icc.vctserver.origin.response;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Vegetable {

    @XmlElement(name = "PUM_NM_A")
    public String name;

    @XmlElement(name = "PUM_CD")
    public String code;

    @XmlElement(name = "G_NAME_A")
    public String grade;

    @XmlElement(name = "UNIT_QTY")
    public String tradeQuantity;

    @XmlElement(name = "U_NAME")
    public String tradeUnitQuantity;

    @XmlElement(name = "AV_P_A")
    public String avgPrice;

    @XmlElement(name = "PAV_P_A")
    public String preAvgPrice;

    @XmlElement(name = "PAV_PY_A")
    public String preYearPrice;

    @XmlElement(name = "A_B")
    public String fluctuationRate;

    @XmlElement(name = "E_NAME")
    public String entityGrade;

    @XmlElement(name = "F_NAME")
    public String tradeUnit;

    @XmlElement(name = "GRADE_CD")
    public String gradeCode;

    @XmlElement(name = "UNIT_CD")
    public String unitCode;
}
