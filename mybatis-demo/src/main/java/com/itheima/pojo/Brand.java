package com.itheima.pojo;

public class Brand {
    private Integer id;
    private String brandname;
    private String companyname;
    private Integer ordered;
    private String description;
    private Integer statu;

    public Brand() {
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandname='" + brandname + '\'' +
                ", companyname='" + companyname + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", statu=" + statu +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public Brand(Integer id, String brandname, String companyname, Integer ordered, String description, Integer statu) {
        this.id = id;
        this.brandname = brandname;
        this.companyname = companyname;
        this.ordered = ordered;
        this.description = description;
        this.statu = statu;
    }
}
