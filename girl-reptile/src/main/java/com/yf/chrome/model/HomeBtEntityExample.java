package com.yf.chrome.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeBtEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public HomeBtEntityExample() {
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
        rows = null;
        offset = null;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getRows() {
        return this.rows;
    }

    public HomeBtEntityExample limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    public HomeBtEntityExample limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    public HomeBtEntityExample page(Integer page, Integer pageSize) {
        this.offset = page * pageSize;
        this.rows = pageSize;
        return this;
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

        public Criteria andBtIdIsNull() {
            addCriterion("bt_id is null");
            return (Criteria) this;
        }

        public Criteria andBtIdIsNotNull() {
            addCriterion("bt_id is not null");
            return (Criteria) this;
        }

        public Criteria andBtIdEqualTo(Long value) {
            addCriterion("bt_id =", value, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdNotEqualTo(Long value) {
            addCriterion("bt_id <>", value, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdGreaterThan(Long value) {
            addCriterion("bt_id >", value, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bt_id >=", value, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdLessThan(Long value) {
            addCriterion("bt_id <", value, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdLessThanOrEqualTo(Long value) {
            addCriterion("bt_id <=", value, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdIn(List<Long> values) {
            addCriterion("bt_id in", values, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdNotIn(List<Long> values) {
            addCriterion("bt_id not in", values, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdBetween(Long value1, Long value2) {
            addCriterion("bt_id between", value1, value2, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdNotBetween(Long value1, Long value2) {
            addCriterion("bt_id not between", value1, value2, "btId");
            return (Criteria) this;
        }

        public Criteria andBtNameIsNull() {
            addCriterion("bt_name is null");
            return (Criteria) this;
        }

        public Criteria andBtNameIsNotNull() {
            addCriterion("bt_name is not null");
            return (Criteria) this;
        }

        public Criteria andBtNameEqualTo(String value) {
            addCriterion("bt_name =", value, "btName");
            return (Criteria) this;
        }

        public Criteria andBtNameNotEqualTo(String value) {
            addCriterion("bt_name <>", value, "btName");
            return (Criteria) this;
        }

        public Criteria andBtNameGreaterThan(String value) {
            addCriterion("bt_name >", value, "btName");
            return (Criteria) this;
        }

        public Criteria andBtNameGreaterThanOrEqualTo(String value) {
            addCriterion("bt_name >=", value, "btName");
            return (Criteria) this;
        }

        public Criteria andBtNameLessThan(String value) {
            addCriterion("bt_name <", value, "btName");
            return (Criteria) this;
        }

        public Criteria andBtNameLessThanOrEqualTo(String value) {
            addCriterion("bt_name <=", value, "btName");
            return (Criteria) this;
        }

        public Criteria andBtNameLike(String value) {
            addCriterion("bt_name like", value, "btName");
            return (Criteria) this;
        }

        public Criteria andBtNameNotLike(String value) {
            addCriterion("bt_name not like", value, "btName");
            return (Criteria) this;
        }

        public Criteria andBtNameIn(List<String> values) {
            addCriterion("bt_name in", values, "btName");
            return (Criteria) this;
        }

        public Criteria andBtNameNotIn(List<String> values) {
            addCriterion("bt_name not in", values, "btName");
            return (Criteria) this;
        }

        public Criteria andBtNameBetween(String value1, String value2) {
            addCriterion("bt_name between", value1, value2, "btName");
            return (Criteria) this;
        }

        public Criteria andBtNameNotBetween(String value1, String value2) {
            addCriterion("bt_name not between", value1, value2, "btName");
            return (Criteria) this;
        }

        public Criteria andBtTypeIsNull() {
            addCriterion("bt_type is null");
            return (Criteria) this;
        }

        public Criteria andBtTypeIsNotNull() {
            addCriterion("bt_type is not null");
            return (Criteria) this;
        }

        public Criteria andBtTypeEqualTo(String value) {
            addCriterion("bt_type =", value, "btType");
            return (Criteria) this;
        }

        public Criteria andBtTypeNotEqualTo(String value) {
            addCriterion("bt_type <>", value, "btType");
            return (Criteria) this;
        }

        public Criteria andBtTypeGreaterThan(String value) {
            addCriterion("bt_type >", value, "btType");
            return (Criteria) this;
        }

        public Criteria andBtTypeGreaterThanOrEqualTo(String value) {
            addCriterion("bt_type >=", value, "btType");
            return (Criteria) this;
        }

        public Criteria andBtTypeLessThan(String value) {
            addCriterion("bt_type <", value, "btType");
            return (Criteria) this;
        }

        public Criteria andBtTypeLessThanOrEqualTo(String value) {
            addCriterion("bt_type <=", value, "btType");
            return (Criteria) this;
        }

        public Criteria andBtTypeLike(String value) {
            addCriterion("bt_type like", value, "btType");
            return (Criteria) this;
        }

        public Criteria andBtTypeNotLike(String value) {
            addCriterion("bt_type not like", value, "btType");
            return (Criteria) this;
        }

        public Criteria andBtTypeIn(List<String> values) {
            addCriterion("bt_type in", values, "btType");
            return (Criteria) this;
        }

        public Criteria andBtTypeNotIn(List<String> values) {
            addCriterion("bt_type not in", values, "btType");
            return (Criteria) this;
        }

        public Criteria andBtTypeBetween(String value1, String value2) {
            addCriterion("bt_type between", value1, value2, "btType");
            return (Criteria) this;
        }

        public Criteria andBtTypeNotBetween(String value1, String value2) {
            addCriterion("bt_type not between", value1, value2, "btType");
            return (Criteria) this;
        }

        public Criteria andBtHtmlUrlIsNull() {
            addCriterion("bt_html_url is null");
            return (Criteria) this;
        }

        public Criteria andBtHtmlUrlIsNotNull() {
            addCriterion("bt_html_url is not null");
            return (Criteria) this;
        }

        public Criteria andBtHtmlUrlEqualTo(String value) {
            addCriterion("bt_html_url =", value, "btHtmlUrl");
            return (Criteria) this;
        }

        public Criteria andBtHtmlUrlNotEqualTo(String value) {
            addCriterion("bt_html_url <>", value, "btHtmlUrl");
            return (Criteria) this;
        }

        public Criteria andBtHtmlUrlGreaterThan(String value) {
            addCriterion("bt_html_url >", value, "btHtmlUrl");
            return (Criteria) this;
        }

        public Criteria andBtHtmlUrlGreaterThanOrEqualTo(String value) {
            addCriterion("bt_html_url >=", value, "btHtmlUrl");
            return (Criteria) this;
        }

        public Criteria andBtHtmlUrlLessThan(String value) {
            addCriterion("bt_html_url <", value, "btHtmlUrl");
            return (Criteria) this;
        }

        public Criteria andBtHtmlUrlLessThanOrEqualTo(String value) {
            addCriterion("bt_html_url <=", value, "btHtmlUrl");
            return (Criteria) this;
        }

        public Criteria andBtHtmlUrlLike(String value) {
            addCriterion("bt_html_url like", value, "btHtmlUrl");
            return (Criteria) this;
        }

        public Criteria andBtHtmlUrlNotLike(String value) {
            addCriterion("bt_html_url not like", value, "btHtmlUrl");
            return (Criteria) this;
        }

        public Criteria andBtHtmlUrlIn(List<String> values) {
            addCriterion("bt_html_url in", values, "btHtmlUrl");
            return (Criteria) this;
        }

        public Criteria andBtHtmlUrlNotIn(List<String> values) {
            addCriterion("bt_html_url not in", values, "btHtmlUrl");
            return (Criteria) this;
        }

        public Criteria andBtHtmlUrlBetween(String value1, String value2) {
            addCriterion("bt_html_url between", value1, value2, "btHtmlUrl");
            return (Criteria) this;
        }

        public Criteria andBtHtmlUrlNotBetween(String value1, String value2) {
            addCriterion("bt_html_url not between", value1, value2, "btHtmlUrl");
            return (Criteria) this;
        }

        public Criteria andBtNowIndexIsNull() {
            addCriterion("bt_now_index is null");
            return (Criteria) this;
        }

        public Criteria andBtNowIndexIsNotNull() {
            addCriterion("bt_now_index is not null");
            return (Criteria) this;
        }

        public Criteria andBtNowIndexEqualTo(Integer value) {
            addCriterion("bt_now_index =", value, "btNowIndex");
            return (Criteria) this;
        }

        public Criteria andBtNowIndexNotEqualTo(Integer value) {
            addCriterion("bt_now_index <>", value, "btNowIndex");
            return (Criteria) this;
        }

        public Criteria andBtNowIndexGreaterThan(Integer value) {
            addCriterion("bt_now_index >", value, "btNowIndex");
            return (Criteria) this;
        }

        public Criteria andBtNowIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("bt_now_index >=", value, "btNowIndex");
            return (Criteria) this;
        }

        public Criteria andBtNowIndexLessThan(Integer value) {
            addCriterion("bt_now_index <", value, "btNowIndex");
            return (Criteria) this;
        }

        public Criteria andBtNowIndexLessThanOrEqualTo(Integer value) {
            addCriterion("bt_now_index <=", value, "btNowIndex");
            return (Criteria) this;
        }

        public Criteria andBtNowIndexIn(List<Integer> values) {
            addCriterion("bt_now_index in", values, "btNowIndex");
            return (Criteria) this;
        }

        public Criteria andBtNowIndexNotIn(List<Integer> values) {
            addCriterion("bt_now_index not in", values, "btNowIndex");
            return (Criteria) this;
        }

        public Criteria andBtNowIndexBetween(Integer value1, Integer value2) {
            addCriterion("bt_now_index between", value1, value2, "btNowIndex");
            return (Criteria) this;
        }

        public Criteria andBtNowIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("bt_now_index not between", value1, value2, "btNowIndex");
            return (Criteria) this;
        }

        public Criteria andBtCreateTimeIsNull() {
            addCriterion("bt_create_time is null");
            return (Criteria) this;
        }

        public Criteria andBtCreateTimeIsNotNull() {
            addCriterion("bt_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andBtCreateTimeEqualTo(Date value) {
            addCriterion("bt_create_time =", value, "btCreateTime");
            return (Criteria) this;
        }

        public Criteria andBtCreateTimeNotEqualTo(Date value) {
            addCriterion("bt_create_time <>", value, "btCreateTime");
            return (Criteria) this;
        }

        public Criteria andBtCreateTimeGreaterThan(Date value) {
            addCriterion("bt_create_time >", value, "btCreateTime");
            return (Criteria) this;
        }

        public Criteria andBtCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bt_create_time >=", value, "btCreateTime");
            return (Criteria) this;
        }

        public Criteria andBtCreateTimeLessThan(Date value) {
            addCriterion("bt_create_time <", value, "btCreateTime");
            return (Criteria) this;
        }

        public Criteria andBtCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("bt_create_time <=", value, "btCreateTime");
            return (Criteria) this;
        }

        public Criteria andBtCreateTimeIn(List<Date> values) {
            addCriterion("bt_create_time in", values, "btCreateTime");
            return (Criteria) this;
        }

        public Criteria andBtCreateTimeNotIn(List<Date> values) {
            addCriterion("bt_create_time not in", values, "btCreateTime");
            return (Criteria) this;
        }

        public Criteria andBtCreateTimeBetween(Date value1, Date value2) {
            addCriterion("bt_create_time between", value1, value2, "btCreateTime");
            return (Criteria) this;
        }

        public Criteria andBtCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("bt_create_time not between", value1, value2, "btCreateTime");
            return (Criteria) this;
        }

        public Criteria andBtUpdateTimeIsNull() {
            addCriterion("bt_update_time is null");
            return (Criteria) this;
        }

        public Criteria andBtUpdateTimeIsNotNull() {
            addCriterion("bt_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andBtUpdateTimeEqualTo(Date value) {
            addCriterion("bt_update_time =", value, "btUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBtUpdateTimeNotEqualTo(Date value) {
            addCriterion("bt_update_time <>", value, "btUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBtUpdateTimeGreaterThan(Date value) {
            addCriterion("bt_update_time >", value, "btUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBtUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bt_update_time >=", value, "btUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBtUpdateTimeLessThan(Date value) {
            addCriterion("bt_update_time <", value, "btUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBtUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("bt_update_time <=", value, "btUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBtUpdateTimeIn(List<Date> values) {
            addCriterion("bt_update_time in", values, "btUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBtUpdateTimeNotIn(List<Date> values) {
            addCriterion("bt_update_time not in", values, "btUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBtUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("bt_update_time between", value1, value2, "btUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBtUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("bt_update_time not between", value1, value2, "btUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBtCheckTimeIsNull() {
            addCriterion("bt_check_time is null");
            return (Criteria) this;
        }

        public Criteria andBtCheckTimeIsNotNull() {
            addCriterion("bt_check_time is not null");
            return (Criteria) this;
        }

        public Criteria andBtCheckTimeEqualTo(Date value) {
            addCriterion("bt_check_time =", value, "btCheckTime");
            return (Criteria) this;
        }

        public Criteria andBtCheckTimeNotEqualTo(Date value) {
            addCriterion("bt_check_time <>", value, "btCheckTime");
            return (Criteria) this;
        }

        public Criteria andBtCheckTimeGreaterThan(Date value) {
            addCriterion("bt_check_time >", value, "btCheckTime");
            return (Criteria) this;
        }

        public Criteria andBtCheckTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bt_check_time >=", value, "btCheckTime");
            return (Criteria) this;
        }

        public Criteria andBtCheckTimeLessThan(Date value) {
            addCriterion("bt_check_time <", value, "btCheckTime");
            return (Criteria) this;
        }

        public Criteria andBtCheckTimeLessThanOrEqualTo(Date value) {
            addCriterion("bt_check_time <=", value, "btCheckTime");
            return (Criteria) this;
        }

        public Criteria andBtCheckTimeIn(List<Date> values) {
            addCriterion("bt_check_time in", values, "btCheckTime");
            return (Criteria) this;
        }

        public Criteria andBtCheckTimeNotIn(List<Date> values) {
            addCriterion("bt_check_time not in", values, "btCheckTime");
            return (Criteria) this;
        }

        public Criteria andBtCheckTimeBetween(Date value1, Date value2) {
            addCriterion("bt_check_time between", value1, value2, "btCheckTime");
            return (Criteria) this;
        }

        public Criteria andBtCheckTimeNotBetween(Date value1, Date value2) {
            addCriterion("bt_check_time not between", value1, value2, "btCheckTime");
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