package com.xiaobao.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbOrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOrderidIsNull() {
            addCriterion("orderId is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(String value) {
            addCriterion("orderId =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(String value) {
            addCriterion("orderId <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(String value) {
            addCriterion("orderId >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(String value) {
            addCriterion("orderId >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(String value) {
            addCriterion("orderId <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(String value) {
            addCriterion("orderId <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLike(String value) {
            addCriterion("orderId like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotLike(String value) {
            addCriterion("orderId not like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<String> values) {
            addCriterion("orderId in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<String> values) {
            addCriterion("orderId not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(String value1, String value2) {
            addCriterion("orderId between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(String value1, String value2) {
            addCriterion("orderId not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andCardidIsNull() {
            addCriterion("cardId is null");
            return (Criteria) this;
        }

        public Criteria andCardidIsNotNull() {
            addCriterion("cardId is not null");
            return (Criteria) this;
        }

        public Criteria andCardidEqualTo(String value) {
            addCriterion("cardId =", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidNotEqualTo(String value) {
            addCriterion("cardId <>", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidGreaterThan(String value) {
            addCriterion("cardId >", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidGreaterThanOrEqualTo(String value) {
            addCriterion("cardId >=", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidLessThan(String value) {
            addCriterion("cardId <", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidLessThanOrEqualTo(String value) {
            addCriterion("cardId <=", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidLike(String value) {
            addCriterion("cardId like", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidNotLike(String value) {
            addCriterion("cardId not like", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidIn(List<String> values) {
            addCriterion("cardId in", values, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidNotIn(List<String> values) {
            addCriterion("cardId not in", values, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidBetween(String value1, String value2) {
            addCriterion("cardId between", value1, value2, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidNotBetween(String value1, String value2) {
            addCriterion("cardId not between", value1, value2, "cardid");
            return (Criteria) this;
        }

        public Criteria andOrdercntIsNull() {
            addCriterion("orderCnt is null");
            return (Criteria) this;
        }

        public Criteria andOrdercntIsNotNull() {
            addCriterion("orderCnt is not null");
            return (Criteria) this;
        }

        public Criteria andOrdercntEqualTo(Integer value) {
            addCriterion("orderCnt =", value, "ordercnt");
            return (Criteria) this;
        }

        public Criteria andOrdercntNotEqualTo(Integer value) {
            addCriterion("orderCnt <>", value, "ordercnt");
            return (Criteria) this;
        }

        public Criteria andOrdercntGreaterThan(Integer value) {
            addCriterion("orderCnt >", value, "ordercnt");
            return (Criteria) this;
        }

        public Criteria andOrdercntGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderCnt >=", value, "ordercnt");
            return (Criteria) this;
        }

        public Criteria andOrdercntLessThan(Integer value) {
            addCriterion("orderCnt <", value, "ordercnt");
            return (Criteria) this;
        }

        public Criteria andOrdercntLessThanOrEqualTo(Integer value) {
            addCriterion("orderCnt <=", value, "ordercnt");
            return (Criteria) this;
        }

        public Criteria andOrdercntIn(List<Integer> values) {
            addCriterion("orderCnt in", values, "ordercnt");
            return (Criteria) this;
        }

        public Criteria andOrdercntNotIn(List<Integer> values) {
            addCriterion("orderCnt not in", values, "ordercnt");
            return (Criteria) this;
        }

        public Criteria andOrdercntBetween(Integer value1, Integer value2) {
            addCriterion("orderCnt between", value1, value2, "ordercnt");
            return (Criteria) this;
        }

        public Criteria andOrdercntNotBetween(Integer value1, Integer value2) {
            addCriterion("orderCnt not between", value1, value2, "ordercnt");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAmontIsNull() {
            addCriterion("amont is null");
            return (Criteria) this;
        }

        public Criteria andAmontIsNotNull() {
            addCriterion("amont is not null");
            return (Criteria) this;
        }

        public Criteria andAmontEqualTo(Double value) {
            addCriterion("amont =", value, "amont");
            return (Criteria) this;
        }

        public Criteria andAmontNotEqualTo(Double value) {
            addCriterion("amont <>", value, "amont");
            return (Criteria) this;
        }

        public Criteria andAmontGreaterThan(Double value) {
            addCriterion("amont >", value, "amont");
            return (Criteria) this;
        }

        public Criteria andAmontGreaterThanOrEqualTo(Double value) {
            addCriterion("amont >=", value, "amont");
            return (Criteria) this;
        }

        public Criteria andAmontLessThan(Double value) {
            addCriterion("amont <", value, "amont");
            return (Criteria) this;
        }

        public Criteria andAmontLessThanOrEqualTo(Double value) {
            addCriterion("amont <=", value, "amont");
            return (Criteria) this;
        }

        public Criteria andAmontIn(List<Double> values) {
            addCriterion("amont in", values, "amont");
            return (Criteria) this;
        }

        public Criteria andAmontNotIn(List<Double> values) {
            addCriterion("amont not in", values, "amont");
            return (Criteria) this;
        }

        public Criteria andAmontBetween(Double value1, Double value2) {
            addCriterion("amont between", value1, value2, "amont");
            return (Criteria) this;
        }

        public Criteria andAmontNotBetween(Double value1, Double value2) {
            addCriterion("amont not between", value1, value2, "amont");
            return (Criteria) this;
        }

        public Criteria andBonusIsNull() {
            addCriterion("bonus is null");
            return (Criteria) this;
        }

        public Criteria andBonusIsNotNull() {
            addCriterion("bonus is not null");
            return (Criteria) this;
        }

        public Criteria andBonusEqualTo(Double value) {
            addCriterion("bonus =", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusNotEqualTo(Double value) {
            addCriterion("bonus <>", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusGreaterThan(Double value) {
            addCriterion("bonus >", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusGreaterThanOrEqualTo(Double value) {
            addCriterion("bonus >=", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusLessThan(Double value) {
            addCriterion("bonus <", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusLessThanOrEqualTo(Double value) {
            addCriterion("bonus <=", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusIn(List<Double> values) {
            addCriterion("bonus in", values, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusNotIn(List<Double> values) {
            addCriterion("bonus not in", values, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusBetween(Double value1, Double value2) {
            addCriterion("bonus between", value1, value2, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusNotBetween(Double value1, Double value2) {
            addCriterion("bonus not between", value1, value2, "bonus");
            return (Criteria) this;
        }

        public Criteria andRewardIsNull() {
            addCriterion("reward is null");
            return (Criteria) this;
        }

        public Criteria andRewardIsNotNull() {
            addCriterion("reward is not null");
            return (Criteria) this;
        }

        public Criteria andRewardEqualTo(Double value) {
            addCriterion("reward =", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotEqualTo(Double value) {
            addCriterion("reward <>", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardGreaterThan(Double value) {
            addCriterion("reward >", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardGreaterThanOrEqualTo(Double value) {
            addCriterion("reward >=", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardLessThan(Double value) {
            addCriterion("reward <", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardLessThanOrEqualTo(Double value) {
            addCriterion("reward <=", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardIn(List<Double> values) {
            addCriterion("reward in", values, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotIn(List<Double> values) {
            addCriterion("reward not in", values, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardBetween(Double value1, Double value2) {
            addCriterion("reward between", value1, value2, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotBetween(Double value1, Double value2) {
            addCriterion("reward not between", value1, value2, "reward");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andInvestmentdateIsNull() {
            addCriterion("investmentDate is null");
            return (Criteria) this;
        }

        public Criteria andInvestmentdateIsNotNull() {
            addCriterion("investmentDate is not null");
            return (Criteria) this;
        }

        public Criteria andInvestmentdateEqualTo(String value) {
            addCriterion("investmentDate =", value, "investmentdate");
            return (Criteria) this;
        }

        public Criteria andInvestmentdateNotEqualTo(String value) {
            addCriterion("investmentDate <>", value, "investmentdate");
            return (Criteria) this;
        }

        public Criteria andInvestmentdateGreaterThan(String value) {
            addCriterion("investmentDate >", value, "investmentdate");
            return (Criteria) this;
        }

        public Criteria andInvestmentdateGreaterThanOrEqualTo(String value) {
            addCriterion("investmentDate >=", value, "investmentdate");
            return (Criteria) this;
        }

        public Criteria andInvestmentdateLessThan(String value) {
            addCriterion("investmentDate <", value, "investmentdate");
            return (Criteria) this;
        }

        public Criteria andInvestmentdateLessThanOrEqualTo(String value) {
            addCriterion("investmentDate <=", value, "investmentdate");
            return (Criteria) this;
        }

        public Criteria andInvestmentdateLike(String value) {
            addCriterion("investmentDate like", value, "investmentdate");
            return (Criteria) this;
        }

        public Criteria andInvestmentdateNotLike(String value) {
            addCriterion("investmentDate not like", value, "investmentdate");
            return (Criteria) this;
        }

        public Criteria andInvestmentdateIn(List<String> values) {
            addCriterion("investmentDate in", values, "investmentdate");
            return (Criteria) this;
        }

        public Criteria andInvestmentdateNotIn(List<String> values) {
            addCriterion("investmentDate not in", values, "investmentdate");
            return (Criteria) this;
        }

        public Criteria andInvestmentdateBetween(String value1, String value2) {
            addCriterion("investmentDate between", value1, value2, "investmentdate");
            return (Criteria) this;
        }

        public Criteria andInvestmentdateNotBetween(String value1, String value2) {
            addCriterion("investmentDate not between", value1, value2, "investmentdate");
            return (Criteria) this;
        }

        public Criteria andRewardmonthsIsNull() {
            addCriterion("rewardMonths is null");
            return (Criteria) this;
        }

        public Criteria andRewardmonthsIsNotNull() {
            addCriterion("rewardMonths is not null");
            return (Criteria) this;
        }

        public Criteria andRewardmonthsEqualTo(Integer value) {
            addCriterion("rewardMonths =", value, "rewardmonths");
            return (Criteria) this;
        }

        public Criteria andRewardmonthsNotEqualTo(Integer value) {
            addCriterion("rewardMonths <>", value, "rewardmonths");
            return (Criteria) this;
        }

        public Criteria andRewardmonthsGreaterThan(Integer value) {
            addCriterion("rewardMonths >", value, "rewardmonths");
            return (Criteria) this;
        }

        public Criteria andRewardmonthsGreaterThanOrEqualTo(Integer value) {
            addCriterion("rewardMonths >=", value, "rewardmonths");
            return (Criteria) this;
        }

        public Criteria andRewardmonthsLessThan(Integer value) {
            addCriterion("rewardMonths <", value, "rewardmonths");
            return (Criteria) this;
        }

        public Criteria andRewardmonthsLessThanOrEqualTo(Integer value) {
            addCriterion("rewardMonths <=", value, "rewardmonths");
            return (Criteria) this;
        }

        public Criteria andRewardmonthsIn(List<Integer> values) {
            addCriterion("rewardMonths in", values, "rewardmonths");
            return (Criteria) this;
        }

        public Criteria andRewardmonthsNotIn(List<Integer> values) {
            addCriterion("rewardMonths not in", values, "rewardmonths");
            return (Criteria) this;
        }

        public Criteria andRewardmonthsBetween(Integer value1, Integer value2) {
            addCriterion("rewardMonths between", value1, value2, "rewardmonths");
            return (Criteria) this;
        }

        public Criteria andRewardmonthsNotBetween(Integer value1, Integer value2) {
            addCriterion("rewardMonths not between", value1, value2, "rewardmonths");
            return (Criteria) this;
        }

        public Criteria andExtradaysIsNull() {
            addCriterion("extraDays is null");
            return (Criteria) this;
        }

        public Criteria andExtradaysIsNotNull() {
            addCriterion("extraDays is not null");
            return (Criteria) this;
        }

        public Criteria andExtradaysEqualTo(Integer value) {
            addCriterion("extraDays =", value, "extradays");
            return (Criteria) this;
        }

        public Criteria andExtradaysNotEqualTo(Integer value) {
            addCriterion("extraDays <>", value, "extradays");
            return (Criteria) this;
        }

        public Criteria andExtradaysGreaterThan(Integer value) {
            addCriterion("extraDays >", value, "extradays");
            return (Criteria) this;
        }

        public Criteria andExtradaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("extraDays >=", value, "extradays");
            return (Criteria) this;
        }

        public Criteria andExtradaysLessThan(Integer value) {
            addCriterion("extraDays <", value, "extradays");
            return (Criteria) this;
        }

        public Criteria andExtradaysLessThanOrEqualTo(Integer value) {
            addCriterion("extraDays <=", value, "extradays");
            return (Criteria) this;
        }

        public Criteria andExtradaysIn(List<Integer> values) {
            addCriterion("extraDays in", values, "extradays");
            return (Criteria) this;
        }

        public Criteria andExtradaysNotIn(List<Integer> values) {
            addCriterion("extraDays not in", values, "extradays");
            return (Criteria) this;
        }

        public Criteria andExtradaysBetween(Integer value1, Integer value2) {
            addCriterion("extraDays between", value1, value2, "extradays");
            return (Criteria) this;
        }

        public Criteria andExtradaysNotBetween(Integer value1, Integer value2) {
            addCriterion("extraDays not between", value1, value2, "extradays");
            return (Criteria) this;
        }

        public Criteria andRewarddaysIsNull() {
            addCriterion("rewardDays is null");
            return (Criteria) this;
        }

        public Criteria andRewarddaysIsNotNull() {
            addCriterion("rewardDays is not null");
            return (Criteria) this;
        }

        public Criteria andRewarddaysEqualTo(Integer value) {
            addCriterion("rewardDays =", value, "rewarddays");
            return (Criteria) this;
        }

        public Criteria andRewarddaysNotEqualTo(Integer value) {
            addCriterion("rewardDays <>", value, "rewarddays");
            return (Criteria) this;
        }

        public Criteria andRewarddaysGreaterThan(Integer value) {
            addCriterion("rewardDays >", value, "rewarddays");
            return (Criteria) this;
        }

        public Criteria andRewarddaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("rewardDays >=", value, "rewarddays");
            return (Criteria) this;
        }

        public Criteria andRewarddaysLessThan(Integer value) {
            addCriterion("rewardDays <", value, "rewarddays");
            return (Criteria) this;
        }

        public Criteria andRewarddaysLessThanOrEqualTo(Integer value) {
            addCriterion("rewardDays <=", value, "rewarddays");
            return (Criteria) this;
        }

        public Criteria andRewarddaysIn(List<Integer> values) {
            addCriterion("rewardDays in", values, "rewarddays");
            return (Criteria) this;
        }

        public Criteria andRewarddaysNotIn(List<Integer> values) {
            addCriterion("rewardDays not in", values, "rewarddays");
            return (Criteria) this;
        }

        public Criteria andRewarddaysBetween(Integer value1, Integer value2) {
            addCriterion("rewardDays between", value1, value2, "rewarddays");
            return (Criteria) this;
        }

        public Criteria andRewarddaysNotBetween(Integer value1, Integer value2) {
            addCriterion("rewardDays not between", value1, value2, "rewarddays");
            return (Criteria) this;
        }

        public Criteria andDaysalreadyIsNull() {
            addCriterion("daysAlready is null");
            return (Criteria) this;
        }

        public Criteria andDaysalreadyIsNotNull() {
            addCriterion("daysAlready is not null");
            return (Criteria) this;
        }

        public Criteria andDaysalreadyEqualTo(Integer value) {
            addCriterion("daysAlready =", value, "daysalready");
            return (Criteria) this;
        }

        public Criteria andDaysalreadyNotEqualTo(Integer value) {
            addCriterion("daysAlready <>", value, "daysalready");
            return (Criteria) this;
        }

        public Criteria andDaysalreadyGreaterThan(Integer value) {
            addCriterion("daysAlready >", value, "daysalready");
            return (Criteria) this;
        }

        public Criteria andDaysalreadyGreaterThanOrEqualTo(Integer value) {
            addCriterion("daysAlready >=", value, "daysalready");
            return (Criteria) this;
        }

        public Criteria andDaysalreadyLessThan(Integer value) {
            addCriterion("daysAlready <", value, "daysalready");
            return (Criteria) this;
        }

        public Criteria andDaysalreadyLessThanOrEqualTo(Integer value) {
            addCriterion("daysAlready <=", value, "daysalready");
            return (Criteria) this;
        }

        public Criteria andDaysalreadyIn(List<Integer> values) {
            addCriterion("daysAlready in", values, "daysalready");
            return (Criteria) this;
        }

        public Criteria andDaysalreadyNotIn(List<Integer> values) {
            addCriterion("daysAlready not in", values, "daysalready");
            return (Criteria) this;
        }

        public Criteria andDaysalreadyBetween(Integer value1, Integer value2) {
            addCriterion("daysAlready between", value1, value2, "daysalready");
            return (Criteria) this;
        }

        public Criteria andDaysalreadyNotBetween(Integer value1, Integer value2) {
            addCriterion("daysAlready not between", value1, value2, "daysalready");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("createDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("createDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("createDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("createDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("createDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("createDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("createDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("createDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("createDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("createDate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIsNull() {
            addCriterion("updateDate is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIsNotNull() {
            addCriterion("updateDate is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedateEqualTo(Date value) {
            addCriterion("updateDate =", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotEqualTo(Date value) {
            addCriterion("updateDate <>", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateGreaterThan(Date value) {
            addCriterion("updateDate >", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("updateDate >=", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLessThan(Date value) {
            addCriterion("updateDate <", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLessThanOrEqualTo(Date value) {
            addCriterion("updateDate <=", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIn(List<Date> values) {
            addCriterion("updateDate in", values, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotIn(List<Date> values) {
            addCriterion("updateDate not in", values, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateBetween(Date value1, Date value2) {
            addCriterion("updateDate between", value1, value2, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotBetween(Date value1, Date value2) {
            addCriterion("updateDate not between", value1, value2, "updatedate");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIsNull() {
            addCriterion("orderStatus is null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIsNotNull() {
            addCriterion("orderStatus is not null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusEqualTo(Integer value) {
            addCriterion("orderStatus =", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotEqualTo(Integer value) {
            addCriterion("orderStatus <>", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusGreaterThan(Integer value) {
            addCriterion("orderStatus >", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderStatus >=", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLessThan(Integer value) {
            addCriterion("orderStatus <", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLessThanOrEqualTo(Integer value) {
            addCriterion("orderStatus <=", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIn(List<Integer> values) {
            addCriterion("orderStatus in", values, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotIn(List<Integer> values) {
            addCriterion("orderStatus not in", values, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusBetween(Integer value1, Integer value2) {
            addCriterion("orderStatus between", value1, value2, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("orderStatus not between", value1, value2, "orderstatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}