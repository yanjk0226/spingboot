package com.accp.pojo;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * paimaijp
 * @author 
 */
@TableName("paimaijp")
public class Paimaijp implements Serializable {
	@TableId(value = "jpid",type = IdType.AUTO)
    private Integer jpid;

    private Integer userid;

    private Integer pcid;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date jpdate;

    private Integer jpprice;

    private static final long serialVersionUID = 1L;

    public Integer getJpid() {
        return jpid;
    }

    public void setJpid(Integer jpid) {
        this.jpid = jpid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPcid() {
        return pcid;
    }

    public void setPcid(Integer pcid) {
        this.pcid = pcid;
    }

    public Date getJpdate() {
        return jpdate;
    }

    public void setJpdate(Date jpdate) {
        this.jpdate = jpdate;
    }

    public Integer getJpprice() {
        return jpprice;
    }

    public void setJpprice(Integer jpprice) {
        this.jpprice = jpprice;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Paimaijp other = (Paimaijp) that;
        return (this.getJpid() == null ? other.getJpid() == null : this.getJpid().equals(other.getJpid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getPcid() == null ? other.getPcid() == null : this.getPcid().equals(other.getPcid()))
            && (this.getJpdate() == null ? other.getJpdate() == null : this.getJpdate().equals(other.getJpdate()))
            && (this.getJpprice() == null ? other.getJpprice() == null : this.getJpprice().equals(other.getJpprice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getJpid() == null) ? 0 : getJpid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getPcid() == null) ? 0 : getPcid().hashCode());
        result = prime * result + ((getJpdate() == null) ? 0 : getJpdate().hashCode());
        result = prime * result + ((getJpprice() == null) ? 0 : getJpprice().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", jpid=").append(jpid);
        sb.append(", userid=").append(userid);
        sb.append(", pcid=").append(pcid);
        sb.append(", jpdate=").append(jpdate);
        sb.append(", jpprice=").append(jpprice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	public Paimaijp(Integer jpid, Integer userid, Integer pcid, Date jpdate, Integer jpprice) {
		super();
		this.jpid = jpid;
		this.userid = userid;
		this.pcid = pcid;
		this.jpdate = jpdate;
		this.jpprice = jpprice;
	}

	public Paimaijp(Integer userid, Integer pcid, Date jpdate, Integer jpprice) {
		super();
		this.userid = userid;
		this.pcid = pcid;
		this.jpdate = jpdate;
		this.jpprice = jpprice;
	}

	public Paimaijp() {
		super();
	}
    
}