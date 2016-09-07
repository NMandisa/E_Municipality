package za.co.emunicipality.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by N Mandisa Mkhungo on 8/1/2016.
 */
@Entity
public class FaultCategory implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long FaultCategoryID;
    private String Category;
    private String Description;

    public long getFaultCategoryID() {
        return FaultCategoryID;
    }

    public void setFaultCategoryID(long faultCategoryID) {
        FaultCategoryID = faultCategoryID;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
