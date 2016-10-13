package com.xiaobao.pojo;

import java.util.Date;

public class TbOrder {
    private String orderid;

    private String cardid;

    private Integer ordercnt;

    private String address;

    private Double amont;

    private Double bonus;

    private Double reward;

    private String remark;

    private Integer days;

    private Integer daysalready;

    private Date createdate;

    private Date updatedate;

    private Boolean orderstatus;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid == null ? null : cardid.trim();
    }

    public Integer getOrdercnt() {
        return ordercnt;
    }

    public void setOrdercnt(Integer ordercnt) {
        this.ordercnt = ordercnt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Double getAmont() {
        return amont;
    }

    public void setAmont(Double amont) {
        this.amont = amont;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Double getReward() {
        return reward;
    }

    public void setReward(Double reward) {
        this.reward = reward;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
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

    public Boolean getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Boolean orderstatus) {
        this.orderstatus = orderstatus;
    }
}