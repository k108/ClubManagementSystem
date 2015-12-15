/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluborganiser.services;

import cluborganiser.beans.Loginbean;
import cluborganiser.beans.ManageManagershipbeans;
import cluborganiser.beans.ManageMembershipBean;
import cluborganiser.beans.MemberPersonalInformationBean;
import cluborganiser.beans.SportBean;
import cluborganiser.email.SendSMTP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sony
 */
public class DBOperations {

    public Loginbean authUser(String un, String pass) {
        Loginbean objBean = null;
        ResultSet rs = null;
        try (Connection conn = ConnectDB.connect();) {
            PreparedStatement pstmt = conn.prepareStatement("select * from UserMaster where UserName=? and Password=binary(?)");
            pstmt.setString(1, un);
            pstmt.setString(2, pass);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                objBean = new Loginbean();
                objBean.setUserID(rs.getInt("User_Id"));
                objBean.setUserName(rs.getString("UserName"));
                objBean.setPassword(rs.getString("Password"));
                objBean.setUserType(rs.getString("User_Type"));
                objBean.setUserStatus(rs.getString("User_Status"));
                objBean.setName(rs.getString("Name"));
                objBean.setContact(rs.getString("Contact_number"));
                objBean.setEmail(rs.getString("Email"));
            }
        } catch (Exception ex) {
            System.out.println("In authUser():" + ex);

        }
        return objBean;
    }

    public String forgotPassword(String un) {
        Loginbean objBean = null;
        Connection conn = null;
        PreparedStatement psdmt = null;
        ResultSet rs = null;
        String result = "Failed to send Email";
        try {
            conn = ConnectDB.connect();
            psdmt = conn.prepareStatement("select * from usermaster where username = ?");
            psdmt.setString(1, un);
            rs = psdmt.executeQuery();
            if (rs.next()) {
                result = new SendSMTP().sendMail(rs.getString("email"), rs.getString("password"), "Your password is ");
            }
        } catch (Exception e) {
            System.out.println("In authUser()" + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (psdmt != null) {
                    psdmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                System.out.println("In forgotPassword()" + ex);
            }
        }
        return result;
    }

    public List<Loginbean> getAllUsers() {
        List<Loginbean> lst = new ArrayList<>();
        Loginbean objBean = null;
        ResultSet rs = null;

        try (Connection conn = ConnectDB.connect();) {
            PreparedStatement pstmt = conn.prepareStatement("select * from UserMaster");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                objBean = new Loginbean();
                objBean.setUserID(rs.getInt("User_Id"));
                objBean.setUserName(rs.getString("UserName"));
                objBean.setPassword(rs.getString("Password"));
                objBean.setUserType(rs.getString("User_Type"));
                objBean.setUserStatus(rs.getString("User_Status"));
                objBean.setName(rs.getString("Name"));
                objBean.setContact(rs.getString("Contact_number"));
                objBean.setEmail(rs.getString("Email"));
                lst.add(objBean);
            }
        } catch (Exception ex) {
            System.out.println("In getAllUsers():" + ex);

        }
        return lst;
    }

    public Loginbean getUserInfoByUserId(int id) {
        List<Loginbean> lst = new ArrayList<>();
        Loginbean objBean = null;
        ResultSet rs = null;

        try (Connection conn = ConnectDB.connect();) {
            PreparedStatement pstmt = conn.prepareStatement("select * from UserMaster where user_id=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                objBean = new Loginbean();
                objBean.setUserID(rs.getInt("User_Id"));
                objBean.setUserName(rs.getString("UserName"));
                objBean.setPassword(rs.getString("Password"));
                objBean.setUserType(rs.getString("User_Type"));
                objBean.setUserStatus(rs.getString("User_Status"));
                objBean.setName(rs.getString("Name"));
                objBean.setContact(rs.getString("Contact_number"));
                objBean.setEmail(rs.getString("Email"));
                lst.add(objBean);
            }
        } catch (Exception ex) {
            System.out.println("In authUser():" + ex);

        }
        return objBean;
    }

    public int getMaxUserId() {
        int maxId = 0;
        ResultSet rs = null;

        try (Connection conn = ConnectDB.connect();) {
            PreparedStatement pstmt = conn.prepareStatement("select max(user_id) from UserMaster ");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                maxId = rs.getInt(1);
            }
        } catch (Exception ex) {
            System.out.println("In getMaxUserID():" + ex);

        }
        return maxId;
    }

    public String addUser(Loginbean objBean) {
        String result = "Failed to add Record";
        ResultSet rs = null;

        try (Connection conn = ConnectDB.connect();) {
            PreparedStatement pstmt1 = conn.prepareStatement("select * from usermaster where username=?");
            PreparedStatement pstmt2 = conn.prepareStatement(" insert into Usermaster(UserName,password,User_Type,User_status,Name,Contact_number,Email)Values(?,?,?,?,?,?,?)");
            pstmt1.setString(1, objBean.getUserName());
            rs = pstmt1.executeQuery();
            if (rs.next()) {
                result = "Exists";
            } else {
                pstmt2.setString(1, objBean.getUserName());
                pstmt2.setString(2, objBean.getPassword());
                pstmt2.setString(3, objBean.getUserType());
                pstmt2.setString(4, objBean.getUserStatus());
                pstmt2.setString(5, objBean.getName());
                pstmt2.setString(6, objBean.getContact());
                pstmt2.setString(7, objBean.getEmail());
                int i = pstmt2.executeUpdate();
                if (i > 0) {
                    result = "Added";
                }
            }
        } catch (Exception ex) {
            System.out.println("AddUser():" + ex);

        }
        return result;
    }

    public String updateUser(Loginbean objBean) {
        String result = "Failed to update Record";
        ResultSet rs = null;

        try (Connection conn = ConnectDB.connect();) {
            PreparedStatement pstmt1 = conn.prepareStatement("select * from usermaster where username=? and User_Id!=?");
            PreparedStatement pstmt2 = conn.prepareStatement(" update Usermaster set UserName=?,password=?,User_Type=?,User_status=?,Name=?,Contact_number=?,Email=? where User_Id=?");
            pstmt1.setString(1, objBean.getUserName());
            pstmt1.setInt(2, objBean.getUserID());
            rs = pstmt1.executeQuery();
            if (rs.next()) {
                result = "Exists";
            } else {
                pstmt2.setString(1, objBean.getUserName());
                pstmt2.setString(2, objBean.getPassword());
                pstmt2.setString(3, objBean.getUserType());
                pstmt2.setString(4, objBean.getUserStatus());
                pstmt2.setString(5, objBean.getName());
                pstmt2.setString(6, objBean.getContact());
                pstmt2.setString(7, objBean.getEmail());
                pstmt2.setInt(8, objBean.getUserID());
                int i = pstmt2.executeUpdate();
                if (i > 0) {
                    result = "Updated";
                }
            }
        } catch (Exception ex) {
            System.out.println("UpdateUser():" + ex);

        }
        return result;

    }

    public String updateUserProfile(Loginbean objBean) {
        String result = "Failed to update Record";
        ResultSet rs = null;

        try (Connection conn = ConnectDB.connect();) {
            PreparedStatement pstmt1 = conn.prepareStatement("select * from usermaster where username=? and User_Id!=?");
            PreparedStatement pstmt2 = conn.prepareStatement(" update Usermaster set UserName=?,password=?,Name=?,Contact_number=?,Email=? where User_Id=?");
            pstmt1.setString(1, objBean.getUserName());
            pstmt1.setInt(2, objBean.getUserID());
            rs = pstmt1.executeQuery();
            if (rs.next()) {
                result = "Exists";
            } else {
                pstmt2.setString(1, objBean.getUserName());
                pstmt2.setString(2, objBean.getPassword());

                pstmt2.setString(3, objBean.getName());
                pstmt2.setString(4, objBean.getContact());
                pstmt2.setString(5, objBean.getEmail());
                pstmt2.setInt(6, objBean.getUserID());
                int i = pstmt2.executeUpdate();
                if (i > 0) {
                    result = "Updated";
                }
            }
        } catch (Exception ex) {
            System.out.println("UpdateUser():" + ex);

        }
        return result;

    }

    /////////Manage Sport
    public List<SportBean> getAllSports() {
        List<SportBean> lst = new ArrayList<>();
        SportBean objBean = null;
        ResultSet rs = null;

        try (Connection conn = ConnectDB.connect();) {
            PreparedStatement pstmt = conn.prepareStatement("select * from sportType");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                objBean = new SportBean();
                objBean.setSportId(rs.getInt("sport_type_id"));
                objBean.setSportName(rs.getString("sport_name"));
                objBean.setFees(rs.getDouble("fees"));
                objBean.setStatus(rs.getString("status"));
                objBean.setDuration(rs.getInt("duration"));

                lst.add(objBean);
            }
        } catch (Exception ex) {
            System.out.println("In getAllSports():" + ex);

        }
        return lst;
    }

    public int getMaxSportId() {
        int maxId = 0;
        ResultSet rs = null;

        try (Connection conn = ConnectDB.connect();) {
            PreparedStatement pstmt = conn.prepareStatement("select max(sport_type_id) from sporttype ");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                maxId = rs.getInt(1);
            }
        } catch (Exception ex) {
            System.out.println("In getMaxSportID():" + ex);

        }
        return maxId;
    }

    public String addSport(SportBean objBean) {
        String result = "Failed to add Record";
        ResultSet rs = null;

        try (Connection conn = ConnectDB.connect();) {

            PreparedStatement pstmt2 = conn.prepareStatement(" insert into sporttype(sport_name,fees,duration,status)Values(?,?,?,?)");

            pstmt2.setString(1, objBean.getSportName());
            pstmt2.setDouble(2, objBean.getFees());
            pstmt2.setInt(3, objBean.getDuration());
            pstmt2.setString(4, objBean.getStatus());

            int i = pstmt2.executeUpdate();
            if (i > 0) {
                result = "Added";
            }

        } catch (Exception ex) {
            System.out.println("addSport():" + ex);

        }
        return result;
    }

    public String updateSport(SportBean objBean) {
        String result = "Failed to update Record";
        ResultSet rs = null;

        try (Connection conn = ConnectDB.connect();) {

            PreparedStatement pstmt2 = conn.prepareStatement(" update sporttype set sport_name=?,fees=?,duration=?,status=? where sport_type_Id=?");

            pstmt2.setString(1, objBean.getSportName());
            pstmt2.setDouble(2, objBean.getFees());
            pstmt2.setInt(3, objBean.getDuration());
            pstmt2.setString(4, objBean.getStatus());
            pstmt2.setInt(5, objBean.getSportId());

            int i = pstmt2.executeUpdate();
            if (i > 0) {
                result = "Updated";
            }

        } catch (Exception ex) {
            System.out.println("UpdateSport():" + ex);

        }
        return result;

    }

    //////////////////Manage Membership
    public List<ManageMembershipBean> getAllMemberships() {
        List<ManageMembershipBean> lst = new ArrayList<>();
        ManageMembershipBean objBean = null;
        ResultSet rs = null;

        try (Connection conn = ConnectDB.connect();) {
            PreparedStatement pstmt = conn.prepareStatement("select * from membershipTypes");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                objBean = new ManageMembershipBean();
                objBean.setMembershipId(rs.getInt("membership_type_id"));
                objBean.setTypeName(rs.getString("type_name"));
                objBean.setFactor(rs.getInt("Factor"));
                objBean.setDescription(rs.getString("type_description"));
                objBean.setStatus(rs.getString("status"));

                lst.add(objBean);
            }
        } catch (Exception ex) {
            System.out.println("In getAllMemberships():" + ex);

        }
        return lst;
    }

    public int getMaxMembershipId() {
        int maxId = 0;
        ResultSet rs = null;

        try (Connection conn = ConnectDB.connect();) {
            PreparedStatement pstmt = conn.prepareStatement("select max(Membership_type_id) from membershiptype ");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                maxId = rs.getInt(1);
            }
        } catch (Exception ex) {
            System.out.println("In getMaxMembershipID():" + ex);

        }
        return maxId;
    }

    public String addMemberships(ManageMembershipBean objBean) {
        String result = "Failed to add Record";
        ResultSet rs = null;

        try (Connection conn = ConnectDB.connect();) {

            PreparedStatement pstmt2 = conn.prepareStatement(" insert into membershiptypes(type_name,factor,type_description,status)Values(?,?,?,?)");

            pstmt2.setString(1, objBean.getTypeName());
            pstmt2.setInt(2, objBean.getFactor());
            pstmt2.setString(3, objBean.getDescription());
            pstmt2.setString(4, objBean.getStatus());

            int i = pstmt2.executeUpdate();
            if (i > 0) {
                result = "Added";
            }

        } catch (Exception ex) {
            System.out.println("AddMembership():" + ex);

        }
        return result;
    }

    public String updateMembership(ManageMembershipBean objBean) {
        String result = "Failed to update Record";
        ResultSet rs = null;

        try (Connection conn = ConnectDB.connect();) {

            PreparedStatement pstmt2 = conn.prepareStatement(" update membershiptypes set type_name=?,factor=?,type_description=?,status=? where membership_type_Id=?");

            pstmt2.setString(1, objBean.getTypeName());
            pstmt2.setDouble(2, objBean.getFactor());
            pstmt2.setString(3, objBean.getDescription());
            pstmt2.setString(4, objBean.getStatus());
            pstmt2.setInt(5, objBean.getMembershipId());

            int i = pstmt2.executeUpdate();
            if (i > 0) {
                result = "Updated";
            }

        } catch (Exception ex) {
            System.out.println("UpdateMembership():" + ex);

        }
        return result;

    }
///////////////Member Personal Information

    public List<MemberPersonalInformationBean> getAllMemberPersonalInformation() {
        List<MemberPersonalInformationBean> lst = new ArrayList<>();
        MemberPersonalInformationBean objBean = null;
        ResultSet rs = null;

        try (Connection conn = ConnectDB.connect();) {
            PreparedStatement pstmt = conn.prepareStatement("select * from memberdetails");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                objBean = new MemberPersonalInformationBean();
                objBean.setAddress(rs.getString("address"));
                objBean.setDOB(rs.getString("date_of_birth"));
                objBean.setEmail(rs.getString("email"));
                objBean.setGender(rs.getString("gender"));
                objBean.setMemberID(rs.getInt("member_id"));
                objBean.setMobile(rs.getString("mobile"));
                objBean.setName(rs.getString("Name"));
                objBean.setOccupation(rs.getString("Occupation"));
                objBean.setPhone(rs.getString("Phone"));
                objBean.setStatus(rs.getString("status"));
                lst.add(objBean);
            }
        } catch (Exception ex) {
            System.out.println("In getAllMemberPersonalInformation():" + ex);

        }
        return lst;
    }

    public int getMaxMemberId() {
        int maxId = 0;
        ResultSet rs = null;

        try (Connection conn = ConnectDB.connect();) {
            PreparedStatement pstmt = conn.prepareStatement("select max(Member_id) from memberdetails");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                maxId = rs.getInt(1);
            }
        } catch (Exception ex) {
            System.out.println("In getMaxMemberId():" + ex);

        }
        return maxId;
    }

    public String addMemberDetails(MemberPersonalInformationBean objBean) {
        String result = "Failed to add Record";
        ResultSet rs = null;

        try (Connection conn = ConnectDB.connect();) {

            PreparedStatement pstmt2 = conn.prepareStatement(" insert into memberdetails(name,date_of_birth,occupation,gender,address,phone,mobile,email,status)Values(?,?,?,?,?,?,?,?,?)");

            pstmt2.setString(1, objBean.getName());
            pstmt2.setString(2, objBean.getDOB());
            pstmt2.setString(3, objBean.getOccupation());
            pstmt2.setString(4, objBean.getGender());
            pstmt2.setString(5, objBean.getAddress());
            pstmt2.setString(6, objBean.getPhone());
            pstmt2.setString(7, objBean.getMobile());
            pstmt2.setString(8, objBean.getEmail());
            pstmt2.setString(9, objBean.getStatus());

            int i = pstmt2.executeUpdate();
            if (i > 0) {
                result = "Added";
            }

        } catch (Exception ex) {
            System.out.println("addMemberDetail():" + ex);

        }
        return result;
    }

    public String updateMemberDetails(MemberPersonalInformationBean objBean) {
        String result = "Failed to update Record";
        ResultSet rs = null;

        try (Connection conn = ConnectDB.connect();) {

            PreparedStatement pstmt2 = conn.prepareStatement(" update memberdetails set name=?,date_of_birth=?,occupation=?,gender=?,address=?,phone=?,mobile=?,email=?,status=? where member_id=?");

            pstmt2.setString(1, objBean.getName());
            pstmt2.setString(2, objBean.getDOB());
            pstmt2.setString(3, objBean.getOccupation());
            pstmt2.setString(4, objBean.getGender());
            pstmt2.setString(5, objBean.getAddress());
            pstmt2.setString(6, objBean.getPhone());
            pstmt2.setString(7, objBean.getMobile());
            pstmt2.setString(8, objBean.getEmail());
            pstmt2.setString(9, objBean.getStatus());
            pstmt2.setInt(10, objBean.getMemberID());

            int i = pstmt2.executeUpdate();
            if (i > 0) {
                result = "Updated";
            }

        } catch (Exception ex) {
            System.out.println("In updateMemberdetail():" + ex);

        }
        return result;
    }

//////Manage Managership
    public List<ManageManagershipbeans> getManageManagership() {
        List<ManageManagershipbeans> lst = new ArrayList<>();
        ManageManagershipbeans objBean = null;
        ResultSet rs = null;

        try (Connection conn = ConnectDB.connect();) {
            PreparedStatement pstmt = conn.prepareStatement("select * from memberships");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                objBean = new ManageManagershipbeans();

                objBean.setMembershipId(rs.getInt("membership_id"));
                objBean.setMemberId(rs.getInt("member_id"));
                objBean.setMembershipTypeId(rs.getInt("membership_type_id"));
                objBean.setMembershipStatus(rs.getString("membership_status"));
                objBean.setSportTypeId(rs.getInt("sport_type_id"));

                lst.add(objBean);
            }
        } catch (Exception ex) {
            System.out.println("In getAllMemberPersonalInformation():" + ex);

        }
        return lst;
    }

    public int getMaximumMembershipId() {
        int maxId = 0;
        ResultSet rs = null;

        try (Connection conn = ConnectDB.connect();) {
            PreparedStatement pstmt = conn.prepareStatement("select max(Membership_id) from memberships");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                maxId = rs.getInt(1);
            }
        } catch (Exception ex) {
            System.out.println("In getMaximumMembershipId():" + ex);

        }
        return maxId;
    }

    public String addMemberships(ManageManagershipbeans objBean) {
        String result = "Failed to add Record";

        try (Connection conn = ConnectDB.connect();) {

            PreparedStatement pstmt2 = conn.prepareStatement(" insert into memberships(member_id,membership_type_id,membership_status,sport_type_id)Values(?,?,?,?)");

            pstmt2.setInt(1, objBean.getMemberId());
            pstmt2.setInt(2, objBean.getMembershipTypeId());
            pstmt2.setString(3, objBean.getMembershipStatus());
            pstmt2.setInt(4, objBean.getSportTypeId());

            int i = pstmt2.executeUpdate();
            if (i > 0) {
                result = "Added";
            }

        } catch (Exception ex) {
            System.out.println("addMembership():" + ex);

        }
        return result;
    }

    public String updateMembership(ManageManagershipbeans objBean) {
        String result = "Failed to update Record";

        try (Connection conn = ConnectDB.connect();) {

            PreparedStatement pstmt2 = conn.prepareStatement(" update memberships set member_id=?,membership_type_id=?,membership_status=?,sport_type_id=? where membership_id=?");

            pstmt2.setInt(1, objBean.getMemberId());
            pstmt2.setInt(2, objBean.getMembershipTypeId());
            pstmt2.setString(3, objBean.getMembershipStatus());
            pstmt2.setInt(4, objBean.getSportTypeId());
            pstmt2.setInt(5, objBean.getMembershipId());

            int i = pstmt2.executeUpdate();
            if (i > 0) {
                result = "Updated";
            }

        } catch (Exception ex) {
            System.out.println(ex);

        }
        return result;
    }
}
