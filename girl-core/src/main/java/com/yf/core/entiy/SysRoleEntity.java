package com.yf.core.entiy;


public class SysRoleEntity {

  private String roleId;
  private String orgId;
  private String roleName;
  private String roleSign;
  private String remark;
  private long userIdCreate;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModified;


  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }


  public String getOrgId() {
    return orgId;
  }

  public void setOrgId(String orgId) {
    this.orgId = orgId;
  }


  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }


  public String getRoleSign() {
    return roleSign;
  }

  public void setRoleSign(String roleSign) {
    this.roleSign = roleSign;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public long getUserIdCreate() {
    return userIdCreate;
  }

  public void setUserIdCreate(long userIdCreate) {
    this.userIdCreate = userIdCreate;
  }


  public java.sql.Timestamp getGmtCreate() {
    return gmtCreate;
  }

  public void setGmtCreate(java.sql.Timestamp gmtCreate) {
    this.gmtCreate = gmtCreate;
  }


  public java.sql.Timestamp getGmtModified() {
    return gmtModified;
  }

  public void setGmtModified(java.sql.Timestamp gmtModified) {
    this.gmtModified = gmtModified;
  }

}
