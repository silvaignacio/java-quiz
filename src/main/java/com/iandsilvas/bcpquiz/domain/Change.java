package com.iandsilvas.bcpquiz.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "change")
public class Change {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;

    @Column(name= "name")
    private String name;

    @Column(name = "value")
    private BigDecimal value;

    public Change() {
    }

    public Change(String name, BigDecimal value) {
        this.name = name;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
