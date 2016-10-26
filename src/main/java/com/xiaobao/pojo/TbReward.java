package com.xiaobao.pojo;

public class TbReward {
    private String mobile;

    private String name;

    private Double reward;

    private Double bonus;

    private String releasedate;

    private Boolean isrewardrelease;

    private Boolean isbonusrelease;

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

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate == null ? null : releasedate.trim();
    }

    public Boolean getIsrewardrelease() {
        return isrewardrelease;
    }

    public void setIsrewardrelease(Boolean isrewardrelease) {
        this.isrewardrelease = isrewardrelease;
    }

    public Boolean getIsbonusrelease() {
        return isbonusrelease;
    }

    public void setIsbonusrelease(Boolean isbonusrelease) {
        this.isbonusrelease = isbonusrelease;
    }
}