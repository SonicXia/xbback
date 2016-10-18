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

    private String investmentdate;

    private Integer rewardmonths;

    private Integer extradays;

    private Integer rewarddays;

    private Integer daysalready;

    private Date createdate;

    private Date updatedate;

    private Integer orderstatus;

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

    public String getInvestmentdate() {
        return investmentdate;
    }

    public void setInvestmentdate(String investmentdate) {
        this.investmentdate = investmentdate == null ? null : investmentdate.trim();
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

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }
}