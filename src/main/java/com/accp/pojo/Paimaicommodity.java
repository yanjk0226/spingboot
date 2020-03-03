package com.accp.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * paimaicommodity
 * @author 
 */
public class Paimaicommodity implements Serializable {
    private Integer pcid;

    private String pcname;

    private Integer pcfloorprice;

    private Integer pcstartingprice;

    private Date startdate;

    private Date stopdate;

    private String describe;

    private String pcimg;

    private static final long serialVersionUID = 1L;

    public Integer getPcid() {
        return pcid;
    }

    public void setPcid(Integer pcid) {
        this.pcid = pcid;
    }

    public String getPcname() {
        return pcname;
    }

    public void setPcname(String pcname) {
        this.pcname = pcname;
    }

    public Integer getPcfloorprice() {
        return pcfloorprice;
    }

    public void setPcfloorprice(Integer pcfloorprice) {
        this.pcfloorprice = pcfloorprice;
    }

    public Integer getPcstartingprice() {
        return pcstartingprice;
    }

    public void setPcstartingprice(Integer pcstartingprice) {
        this.pcstartingprice = pcstartingprice;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getStopdate() {
        return stopdate;
    }

    public void setStopdate(Date stopdate) {
        this.stopdate = stopdate;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPcimg() {
        return pcimg;
    }

    public void setPcimg(String pcimg) {
        this.pcimg = pcimg;
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
        Paimaicommodity other = (Paimaicommodity) that;
        return (this.getPcid() == null ? other.getPcid() == null : this.getPcid().equals(other.getPcid()))
            && (this.getPcname() == null ? other.getPcname() == null : this.getPcname().equals(other.getPcname()))
            && (this.getPcfloorprice() == null ? other.getPcfloorprice() == null : this.getPcfloorprice().equals(other.getPcfloorprice()))
            && (this.getPcstartingprice() == null ? other.getPcstartingprice() == null : this.getPcstartingprice().equals(other.getPcstartingprice()))
            && (this.getStartdate() == null ? other.getStartdate() == null : this.getStartdate().equals(other.getStartdate()))
            && (this.getStopdate() == null ? other.getStopdate() == null : this.getStopdate().equals(other.getStopdate()))
            && (this.getDescribe() == null ? other.getDescribe() == null : this.getDescribe().equals(other.getDescribe()))
            && (this.getPcimg() == null ? other.getPcimg() == null : this.getPcimg().equals(other.getPcimg()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPcid() == null) ? 0 : getPcid().hashCode());
        result = prime * result + ((getPcname() == null) ? 0 : getPcname().hashCode());
        result = prime * result + ((getPcfloorprice() == null) ? 0 : getPcfloorprice().hashCode());
        result = prime * result + ((getPcstartingprice() == null) ? 0 : getPcstartingprice().hashCode());
        result = prime * result + ((getStartdate() == null) ? 0 : getStartdate().hashCode());
        result = prime * result + ((getStopdate() == null) ? 0 : getStopdate().hashCode());
        result = prime * result + ((getDescribe() == null) ? 0 : getDescribe().hashCode());
        result = prime * result + ((getPcimg() == null) ? 0 : getPcimg().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pcid=").append(pcid);
        sb.append(", pcname=").append(pcname);
        sb.append(", pcfloorprice=").append(pcfloorprice);
        sb.append(", pcstartingprice=").append(pcstartingprice);
        sb.append(", startdate=").append(startdate);
        sb.append(", stopdate=").append(stopdate);
        sb.append(", describe=").append(describe);
        sb.append(", pcimg=").append(pcimg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}