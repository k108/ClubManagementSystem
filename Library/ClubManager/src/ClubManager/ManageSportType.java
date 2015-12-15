/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClubManager;

import ClubManager.beans.Loginbean;
import ClubManager.beans.SportBean;
import ClubManager.reports.JasperReportGenerator;
import ClubManager.services.DBOperations;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class ManageSportType extends javax.swing.JPanel {

    /**
     * Creates new form ManageSportType
     */
    List<SportBean> lst = null;
    SportBean objBean = null;
    int count = 0;
    DBOperations objDB = null;
    String addUpdateFlag = "";

    public ManageSportType() {
        initComponents();
        objDB = new DBOperations();
        lst = objDB.getAllSports();
        if (lst.size() > 0) {
            objBean = lst.get(0);
            showRecord(objBean);

        }
        disable(false);
        disableButton(true);
        txtSportId.setEditable(false);

    }

    public void disable(boolean value) {
        txtSportName.setEditable(value);
        txtFees.setEditable(value);
        txtSportDuration.setEditable(value);

        ddlSportStatus.setEnabled(value);

    }

    public void disableButton(boolean b) {
        btnFirst.setEnabled(b);
        btnPrev.setEnabled(b);
        btnNxt.setEnabled(b);
        btnLast.setEnabled(b);
        btnAdd.setEnabled(b);
        btnUpdate.setEnabled(b);
        btnSave.setEnabled(!b);

//To change body of generated methods, choose Tools | Templates.
    }

    public void Clear() {
        txtSportName.setText("");
        txtFees.setText("");
        txtSportDuration.setText("");

        ddlSportStatus.setSelectedIndex(0);

    }

    public void showRecord(SportBean objBean) {
        txtSportId.setText(String.valueOf(objBean.getSportId()));
        txtSportName.setText(objBean.getSportName());
        txtFees.setText(String.valueOf(objBean.getFees()));
        txtSportDuration.setText(String.valueOf(objBean.getDuration()));
        ddlSportStatus.setSelectedItem(objBean.getStatus());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSportName = new javax.swing.JTextField();
        txtFees = new javax.swing.JTextField();
        txtSportDuration = new javax.swing.JTextField();
        ddlSportStatus = new javax.swing.JComboBox();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNxt = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtSportId = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Manage Sport Type");

        jLabel2.setText("Sport Id");

        jLabel3.setText("Sport Name");

        jLabel4.setText("Fees");

        jLabel5.setText("Sport Duration");

        jLabel6.setText("Sport Status");

        txtFees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFeesActionPerformed(evt);
            }
        });

        ddlSportStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Available", "Not Available" }));

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setText("Previous");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNxt.setText("Next");
        btnNxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNxtActionPerformed(evt);
            }
        });

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jButton1.setText("View All");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFirst)
                            .addComponent(btnAdd))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPrev)
                            .addComponent(btnUpdate))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNxt)
                                .addGap(18, 18, 18)
                                .addComponent(btnLast))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancel))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSportName)
                            .addComponent(txtFees)
                            .addComponent(txtSportDuration)
                            .addComponent(ddlSportStatus, 0, 186, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSportId, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSportId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtSportName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtFees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtSportDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(ddlSportStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnPrev)
                    .addComponent(btnNxt)
                    .addComponent(btnLast))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtFeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFeesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFeesActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:

        if (txtSportName.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "UserName is required");
            txtSportName.grabFocus();

        } else if (txtFees.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Name is required");
            txtFees.grabFocus();
        } else if (txtSportDuration.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Contact is required");
            txtSportDuration.grabFocus();
        } else {
            String result = "";
            objBean = new SportBean();
            objBean.setSportId(Integer.parseInt(txtSportId.getText()));
            objBean.setSportName(txtSportName.getText());

            objBean.setDuration(Integer.parseInt(txtSportDuration.getText()));
            objBean.setFees(Double.parseDouble(txtFees.getText()));

            objBean.setStatus(ddlSportStatus.getSelectedItem().toString());

            if (addUpdateFlag.equalsIgnoreCase("add")) {
                result = objDB.addSport(objBean);
            } else if (addUpdateFlag.equalsIgnoreCase("Update")) {
                result = objDB.updateSport(objBean);
            }
            if (result.equalsIgnoreCase("added")) {
                JOptionPane.showMessageDialog(this, "Record added successfuly");
                lst = objDB.getAllSports();
                count = lst.size() - 1;
                showRecord(lst.get(count));
                disable(false);
                disableButton(true);

            } else if (result.equalsIgnoreCase("updated")) {
                JOptionPane.showMessageDialog(this, "Record updated successfuly");
                lst = objDB.getAllSports();
                count = lst.size() - 1;
                showRecord(lst.get(count));
                disable(false);
                disableButton(true);
            } else if (result.equalsIgnoreCase("exists")) {
                JOptionPane.showMessageDialog(this, "Record already exists");

            } else {
                JOptionPane.showMessageDialog(this, "Operation failed");
            }

        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        if (lst.size() > 0) {
            count = 0;
            showRecord(lst.get(count));
        }
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        if (count > 0) {
            count--;
            showRecord(lst.get(count));
        }
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNxtActionPerformed
        // TODO add your handling code here:
        if (count < lst.size() - 1) {
            count++;
            showRecord(lst.get(count));
        }
    }//GEN-LAST:event_btnNxtActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        Clear();
        addUpdateFlag = "add";
        disable(true);
        disableButton(false);
        int maxId = objDB.getMaxSportId();
        txtSportId.setText(String.valueOf(maxId + 1));

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        addUpdateFlag = "update";
        disable(true);
        disableButton(false);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        MainFrame.root.setVisible(false);
        MainFrame.root.removeAll();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        if (count < lst.size() - 1) {
            count = lst.size() - 1;
            showRecord(lst.get(count));
        }
    }//GEN-LAST:event_btnLastActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new JasperReportGenerator("SportReport.jrxml");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNxt;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox ddlSportStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtFees;
    private javax.swing.JTextField txtSportDuration;
    private javax.swing.JTextField txtSportId;
    private javax.swing.JTextField txtSportName;
    // End of variables declaration//GEN-END:variables
}
