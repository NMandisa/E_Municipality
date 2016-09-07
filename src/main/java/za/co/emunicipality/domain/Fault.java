package za.co.emunicipality.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.text.DateFormat;

/**
 * Created by NMandisa Mkhungo on 8/1/2016.
 */
@Entity
public class Fault implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long faultId;
        private long faultCategoryId;
        private long userId;
        private String faultDesc;
        private String faultStatus;
        private String location;
        private String faultTime;
        private String comment;

    public long getFaultCategoryId() {
        return faultCategoryId;
    }

    public void setFaultCategoryId(long faultCategoryId) {
        this.faultCategoryId = faultCategoryId;
    }

    public long getFaultId() {
        return faultId;
    }

    public void setFaultId(long faultId) {
        this.faultId = faultId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFaultStatus() {
        return faultStatus;
    }

    public void setFaultStatus(String faultStatus) {
        this.faultStatus = faultStatus;
    }

    public String getFaultDesc() {
        return faultDesc;
    }

    public void setFaultDesc(String faultDesc) {
        this.faultDesc = faultDesc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFaulttime() {
        return faultTime;
    }

    public void setFaulttime(String faultTime) {
        this.faultTime = faultTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
