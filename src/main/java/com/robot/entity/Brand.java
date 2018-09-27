package com.robot.entity;

/**
 * 品牌
 * @author asce
 * @date 2018/9/21
 */
public class Brand {

    private Integer id;
    private String name;
    private int brandCount;

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

    public int getBrandCount() {
        return brandCount;
    }

    public void setBrandCount(int brandCount) {
        this.brandCount = brandCount;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + brandCount +
                '}';
    }
}
