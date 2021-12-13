/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.AdministrativeRole;

import Business.Enterprise.Enterprise;
import Business.Enterprise.Hospital;
import Business.Enterprise.OrganBank;
import Business.Enterprise.Government;
import Business.Enterprise.Therapy;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Organization.OrganizationDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bhavana
 */
public class OrganizationManagementJPanel extends javax.swing.JPanel {

    private OrganizationDirectory organizationDirectory;
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public OrganizationManagementJPanel(JPanel userProcessContainer,OrganizationDirectory directory,Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organizationDirectory = directory;
        this.enterprise= enterprise;
        
        initTable();
        initComboBox();
    }
    
    
    
    private void initComboBox(){
        cmbxOrganizationType.removeAllItems();
        cmbxOrganizationType.addItem("--Choose--");
        for (Type type : Organization.Type.values()){
            
             if(enterprise instanceof Hospital){
                 if(type.toString().equals("Medical") || type.toString().equals("Diagnostics")){
                 cmbxOrganizationType.addItem(type);}
             }
             if(enterprise instanceof OrganBank){
                 if(type.toString().equals("Facilities")){
                 cmbxOrganizationType.addItem(type);}
                 
             }
             if(enterprise instanceof Government){
                 if(type.toString().equals("PoliciesFinance")|| type.toString().equals("AwarnessCampaign")){
                 cmbxOrganizationType.addItem(type);}
                 
             }
             if(enterprise instanceof Therapy){
                 if(type.toString().equals("Therapist")){
                 cmbxOrganizationType.addItem(type);}
                 
             }
                
            
        }
    }

    private void initTable(){
        DefaultTableModel model = (DefaultTableModel) tblCurrentOrganizations.getModel();
        model.setRowCount(0);
        for (Organization organization : organizationDirectory.getOrganizationList()){
            Object[] row = new Object[2];
            row[0] = organization.getName();
            row[1]= organization.getType().getValue();
            
            model.addRow(row);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCurrentOrganizations = new javax.swing.JTable();
        btnAddOrganization = new javax.swing.JButton();
        cmbxOrganizationType = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblCreateOrganization = new javax.swing.JLabel();
        txtCurrentOrganizations = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtOrganizationName = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 800));

        tblCurrentOrganizations.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblCurrentOrganizations.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        tblCurrentOrganizations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Organisation Name", "Organisation Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCurrentOrganizations);
        if (tblCurrentOrganizations.getColumnModel().getColumnCount() > 0) {
            tblCurrentOrganizations.getColumnModel().getColumn(0).setResizable(false);
            tblCurrentOrganizations.getColumnModel().getColumn(1).setResizable(false);
        }

        btnAddOrganization.setBackground(new java.awt.Color(204, 204, 204));
        btnAddOrganization.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddOrganization.setForeground(new java.awt.Color(255, 0, 51));
        btnAddOrganization.setText("Add");
        btnAddOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrganizationActionPerformed(evt);
            }
        });

        cmbxOrganizationType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbxOrganizationType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Organization Type :");

        btnBack.setBackground(new java.awt.Color(204, 204, 204));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 51, 51));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblCreateOrganization.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblCreateOrganization.setForeground(new java.awt.Color(255, 51, 51));
        lblCreateOrganization.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCreateOrganization.setText("CREATE ORGANIZATION");

        txtCurrentOrganizations.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCurrentOrganizations.setForeground(new java.awt.Color(255, 0, 51));
        txtCurrentOrganizations.setText("Organizations List");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Organization Name :");

        txtOrganizationName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblCreateOrganization, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(395, 395, 395))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbxOrganizationType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtOrganizationName, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(btnAddOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCurrentOrganizations)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCreateOrganization)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbxOrganizationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOrganizationName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addComponent(btnAddOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(txtCurrentOrganizations)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 300, 300))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrganizationActionPerformed

        boolean check;
        check=cmbxOrganizationType.getSelectedIndex()>0;
        if(!check){
            JOptionPane.showMessageDialog(null, "Select an Organisation");
        }
        
        Type type = (Type) cmbxOrganizationType.getSelectedItem();
        organizationDirectory.createOrganization(type,txtOrganizationName.getText());
        txtOrganizationName.setText("");
        initTable();
    }//GEN-LAST:event_btnAddOrganizationActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddOrganization;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox cmbxOrganizationType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCreateOrganization;
    private javax.swing.JTable tblCurrentOrganizations;
    private javax.swing.JLabel txtCurrentOrganizations;
    private javax.swing.JTextField txtOrganizationName;
    // End of variables declaration//GEN-END:variables
}
