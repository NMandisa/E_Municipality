package za.co.emunicipality.dto;

/**
 * Created by NMandisa Mkhungo on 8/4/2016.
 */
public class FaultDTO {

    private long faultId;
    private long faultCategoryId;
    private long userId;
    private String faultDesc;
    private String faultStatus;
    private String location;
    private String faultTime;
    private String comment;

    public long getFaultId() {
        return faultId;
    }

    public void setFaultId(long faultId) {
        this.faultId = faultId;
    }

    public long getFaultCategoryId() {
        return faultCategoryId;
    }

    public void setFaultCategoryId(long faultCategoryId) {
        this.faultCategoryId = faultCategoryId;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFaultTime() {
        return faultTime;
    }

    public void setFaultTime(String faultTime) {
        this.faultTime = faultTime;
    }
}
