package com.daelim.icc.vctserver.origin.response;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="lists")
@Data
public class VegetableList {
    @XmlElement(name="list_total_count")
    public int totalCount;

    @XmlElement(name = "list")
    public List<Vegetable> list;
}
