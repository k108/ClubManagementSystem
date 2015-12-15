/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cluborganiser.beans;

/**
 *
 * @author hp
 */
public class ManageMembershipBean {
     private int MembershipId,Factor;
     private String Description,Status,TypeName;

    public int getMembershipId() {
        return MembershipId;
    }

    public void setMembershipId(int MembershipId) {
        this.MembershipId = MembershipId;
    }

    public int getFactor() {
        return Factor;
    }

    public void setFactor(int Factor) {
        this.Factor = Factor;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String TypeName) {
        this.TypeName = TypeName;
    }
     
     

     
}
