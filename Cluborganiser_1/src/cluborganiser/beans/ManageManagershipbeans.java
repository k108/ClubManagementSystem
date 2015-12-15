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
public class ManageManagershipbeans {
     private int MembershipId,MemberId,MembershipTypeId,SportTypeId ;
     private String MembershipStatus;

    public int getMembershipId() {
        return MembershipId;
    }

    public void setMembershipId(int MembershipId) {
        this.MembershipId = MembershipId;
    }

    public int getMemberId() {
        return MemberId;
    }

    public void setMemberId(int MemberId) {
        this.MemberId = MemberId;
    }

    public int getMembershipTypeId() {
        return MembershipTypeId;
    }

    public void setMembershipTypeId(int MembershipTypeId) {
        this.MembershipTypeId = MembershipTypeId;
    }

    public int getSportTypeId() {
        return SportTypeId;
    }

    public void setSportTypeId(int SportTypeId) {
        this.SportTypeId = SportTypeId;
    }

    public String getMembershipStatus() {
        return MembershipStatus;
    }

    public void setMembershipStatus(String MembershipStatus) {
        this.MembershipStatus = MembershipStatus;
    }
     
    
}
