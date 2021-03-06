package com.xiaobao.pojo;

import java.util.Date;

public class TbOrder {
    private String orderid;

    private String mobile;

    private String name;

    private Integer ordercnt;

    private Double price;

    private Double amount;

    private String investmentdate;

    private Double bonusalready;

    private Double rewardalready;

    private String address;

    private String remark;

    private Integer rewardmonths;

    private Integer extradays;

    private Integer rewarddays;

    private Integer daysalready;

    private Date createdate;

    private Date updatedate;

    private Byte orderstatus;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getOrdercnt() {
        return ordercnt;
    }

    public void setOrdercnt(Integer ordercnt) {
        this.ordercnt = ordercnt;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getInvestmentdate() {
        return investmentdate;
    }

    public void setInvestmentdate(String investmentdate) {
        this.investmentdate = investmentdate == null ? null : investmentdate.trim();
    }

    public Double getBonusalready() {
        return bonusalready;
    }

    public void setBonusalready(Double bonusalready) {
        this.bonusalready = bonusalready;
    }

    public Double getRewardalready() {
        return rewardalready;
    }

    public void setRewardalready(Double rewardalready) {
        this.rewardalready = rewardalready;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getRewardmonths() {
        return rewardmonths;
    }

    public void setRewardmonths(Integer rewardmonths) {
        this.rewardmonths = rewardmonths;
    }

    public Integer getExtradays() {
        return extradays;
    }

    public void setExtradays(Integer extradays) {
        this.extradays = extradays;
    }

    public Integer getRewarddays() {
        return rewarddays;
    }

    public void setRewarddays(Integer rewarddays) {
        this.rewarddays = rewarddays;
    }

    public Integer getDaysalready() {
        return daysalready;
    }

    public void setDaysalready(Integer daysalready) {
        this.daysalready = daysalready;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Byte getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Byte orderstatus) {
        this.orderstatus = orderstatus;
    }
}