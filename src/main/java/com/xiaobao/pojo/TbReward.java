package com.xiaobao.pojo;

import java.util.Date;

public class TbReward {
    private String name;

    private String mobile;

    private Double reward;

    private Double bonus;

    private Date releasedate;

    private Boolean isrelease;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Double getReward() {
        return reward;
    }

    public void setReward(Double reward) {
        this.reward = reward;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public Boolean getIsrelease() {
        return isrelease;
    }

    public void setIsrelease(Boolean isrelease) {
        this.isrelease = isrelease;
    }
}