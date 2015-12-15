/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ClubManager.beans;

/**
 *
 * @author hp
 */
public class InvoiceScreenbean {
     private int Number,Date,MembershipId;
      private String Fees;

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int Date) {
        this.Date = Date;
    }

    public int getMembershipId() {
        return MembershipId;
    }

    public void setMembershipId(int MembershipId) {
        this.MembershipId = MembershipId;
    }

    public String getFees() {
        return Fees;
    }

    public void setFees(String Fees) {
        this.Fees = Fees;
    }
      
    
}
