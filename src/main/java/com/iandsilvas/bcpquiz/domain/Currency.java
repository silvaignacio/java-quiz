package com.iandsilvas.bcpquiz.domain;

import javax.persistence.*;

@Entity
@Table(name = "currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;

    @Column(name = "ISO_CODE", length = 3)
    private String isoCode;

    @Column(name = "name")
    private String name;

    public Currency() {
    }

    public Currency(String isoCode, String name) {
        this.isoCode = isoCode;
        this.name = name;
    }

    public Currency(Integer id, String isoCode, String name) {
        this.id = id;
        this.isoCode = isoCode;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
