package com.jk.model;

public class OtherBean {

    private Integer page;
    private Integer rows;

    private Integer id;
    private String img;
    private String price;   //价格
    private Integer sales;  //销量
    private String othertype;
    /**
     * 店铺id
     */
    private Integer  storeId;

    private String   point; //发货地

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getOthertype() {
        return othertype;
    }

    public void setOthertype(String othertype) {
        this.othertype = othertype;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "OtherBean{" +
                "page=" + page +
                ", rows=" + rows +
                ", id=" + id +
                ", img='" + img + '\'' +
                ", price='" + price + '\'' +
                ", sales=" + sales +
                ", othertype='" + othertype + '\'' +
                ", storeId=" + storeId +
                ", point='" + point + '\'' +
                '}';
    }
}
