package com.xiaobao.pojo;

public class TbTeam {
    private Integer teamid;

    private String teamname;

    private String teamleaderid;

    private String leadername;

    private Integer number;

    private String description;

    public Integer getTeamid() {
        return teamid;
    }

    public void setTeamid(Integer teamid) {
        this.teamid = teamid;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname == null ? null : teamname.trim();
    }

    public String getTeamleaderid() {
        return teamleaderid;
    }

    public void setTeamleaderid(String teamleaderid) {
        this.teamleaderid = teamleaderid == null ? null : teamleaderid.trim();
    }

    public String getLeadername() {
        return leadername;
    }

    public void setLeadername(String leadername) {
        this.leadername = leadername == null ? null : leadername.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}