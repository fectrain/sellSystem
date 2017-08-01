package com.homework.sellSystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Timestamp;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {
    private Integer productId; //产品id
    private String title; //标题
    private String image;//图片
    private Float price;//价格
    private Integer isBuy;//当前用户是否已经购买
    private Integer isSell;//是否已经卖出
    private String summary;//摘要
    private String detail;//全文
    private Float buyPrice;//购买时的价格
    private Integer buyNum;//购买数量
    private Timestamp buyTime;//购买时间13位时间戳
    private Integer sellNum;//销售数量

    public Integer getBuyNum() {
        return buyNum;
    }

    public Float getBuyPrice() {
        return buyPrice;
    }

    public Timestamp getBuyTime() {
        return buyTime;
    }

    public String getDetail() {
        return detail;
    }

    public String getImage() {
        return image;
    }

    public Integer getIsBuy() {
        return isBuy;
    }

    public Integer getIsSell() {
        return isSell;
    }

    public Integer getProductId() {
        return productId;
    }

    public Float getPrice() {
        return price;
    }

    public Integer getSellNum() {
        return sellNum;
    }

    public String getSummary() {
        return summary;
    }

    public String getTitle() {
        return title;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public void setBuyPrice(Float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public void setBuyTime(Timestamp buyTime) {
        this.buyTime = buyTime;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setIsBuy(Integer isBuy) {
        this.isBuy = isBuy;
    }




    public void setIsSell(Integer isSell) {
        this.isSell = isSell;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setSellNum(Integer sellNum) {
        this.sellNum = sellNum;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ProductDO{" +
                "productId=" + productId +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", isBuy=" + isBuy +
                ", isSell=" + isSell +
                ", summary='" + summary + '\'' +
                ", detail='" + detail + '\'' +
                ", buyPrice=" + buyPrice +
                ", buyNum=" + buyNum +
                ", sellNum=" + sellNum +
                '}';
    }
}
