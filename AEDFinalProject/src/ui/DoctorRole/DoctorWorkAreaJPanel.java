/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.*;
import Business.Network.Network;
import Business.Organization.Medical;
import Business.Organization.OrganManagement;
import Business.Organization.Organization;
import Business.Person.Patient;
import Business.UserAccount.UserAccount;
import Business.Waitlist.Wait;
import Business.WorkQueue.DiagnosticsWorkRequest;
import Business.WorkQueue.OrganMatchWorkRequest;
import Business.WorkQueue.OrganProcureWorkRequest;
import Business.WorkQueue.TherapistWorkRequest;
import Business.WorkQueue.WaitlistWorkRequest;
import Business.WorkQueue.WorkRequest;
import com.db4o.User;
import java.awt.CardLayout;
import java.awt.Desktop;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bhavana
 */
public class DoctorWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Medical organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EnterpriseDirectory enterpriseDirectory;
    private EcoSystem ecosystem;
    private Network network;

    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public DoctorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Medical organization, Enterprise enterprise, EcoSystem ecosystem, Network network) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.ecosystem = ecosystem;
        this.userAccount = account;
        this.enterpriseDirectory = new EnterpriseDirectory();
        this.network = network;
        txtAge.setVisible(false);
        lblAge.setVisible(false);
        lblName1.setVisible(false);
        txtName.setVisible(false);
		        requestTestJButton.setVisible(false);
        
        
        cb_patients();
        populateRequestTable();
        initwaitTable();

    }


    public void cb_patients(){
        cb_patients.addItem("--Select");
        for(int i=0;i<organization.getPatientDirectory().getPatientList().size();i++){
            if((organization.getPatientDirectory().getPatientList().get(i).getDoctor().equalsIgnoreCase(userAccount.getEmployee().getName()))&&organization.getPatientDirectory().getPatientList().get(i).isAlive()){
                //System.out.println(organization.getPatientDirectory().getPatientList().get(i).getDoctor());
                //System.out.println(organization.getPatientDirectory().getPatientList().get(i).getName());
                cb_patients.addItem(organization.getPatientDirectory().getPatientList().get(i).getId()+" : "+organization.getPatientDirectory().getPatientList().get(i).getName());
            }
        }
    }
   
    public void initwaitTable(){
        DefaultTableModel model = (DefaultTableModel) organRequestJTable.getModel();
        
        model.setRowCount(0);
        for(int i=0;i<ecosystem.getWaitList().size();i++){
            if(ecosystem.getWaitList().get(i).getPatient().getDoctor().equalsIgnoreCase(userAccount.getEmployee().getName())){
                Object[] row = new Object[5];
                row[0] = ecosystem.getWaitList().get(i).getPatient().getId();
                row[1] = ecosystem.getWaitList().get(i).getPatient().getName();
                row[2] = ecosystem.getWaitList().get(i).getOrgan();
                row[3] = ecosystem.getWaitList().get(i).getUrgency();
                row[4] = ecosystem.getWaitList().get(i).getWaitlist();   
                model.addRow(row);
            }
        }
    
    }
    

    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        model.setRowCount(0);
 
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            if (request instanceof DiagnosticsWorkRequest){
                Object[] row = new Object[6];
                
                
                
                row[0] = ((DiagnosticsWorkRequest) request).getPatient().getId();
                row[1] = ((DiagnosticsWorkRequest) request).getPatient().getName();
                row[2] = request;
                row[3] = request.getReceiver();
                row[4] = request.getStatus();
    
            int counter=0;
            for(Network n: ecosystem.getNetworkList()){
                for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
                    if(e instanceof TherapyEnterprise){
                        for(Organization o:e.getOrganizationDirectory().getOrganizationList()){
                            for(WorkRequest w:o.getWorkQueue().getWorkRequestList()){
                                if(((TherapistWorkRequest)w).getPatient().getId()==((DiagnosticsWorkRequest) request).getPatient().getId()){
                                    counter=counter+1;
                                    if(((TherapistWorkRequest)w).getReceiver()==null){
                                       row[5] = "Not Assigned"; 
                                    }else{
                                        row[5]=((TherapistWorkRequest)w).getReceiver();
                                    }
                                }
                            }    
                        }
                    }
                }    
            }
            if(counter==0){
                row[5] = "Not requested"; 
            }   
                model.addRow(row);
            }
        }
    }

    public void initwaitlistTable(){
        DefaultTableModel model = (DefaultTableModel) organRequestJTable.getModel();

        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            if (request instanceof DiagnosticsWorkRequest){
                Object[] row = new Object[5];
                row[0] = request;
                row[1] = ((DiagnosticsWorkRequest) request).getPatient().getName();
                row[2] = request.getReceiver();
                row[3] = request.getStatus();
                String result = ((DiagnosticsWorkRequest) request).getTestResult();
                row[4] = result == null ? "Waiting" : result;
                model.addRow(row);
            }
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

        jPopupMenu2 = new javax.swing.JPopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        requestTestJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        organRequestJTable = new javax.swing.JTable();
        requestOrganJButton = new javax.swing.JButton();
        lblPatient = new javax.swing.JLabel();
        cb_patients = new javax.swing.JComboBox();
        lblAge = new javax.swing.JLabel();
        lblName1 = new javax.swing.JLabel();
        viewbtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btn_viewPat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        chk_heart = new javax.swing.JCheckBox();
        chk_kidney = new javax.swing.JCheckBox();
        chk_liver = new javax.swing.JCheckBox();
        chk_pancreas = new javax.swing.JCheckBox();
        btn_therapist = new javax.swing.JButton();
        chk_lungs = new javax.swing.JCheckBox();
        chk_intestines = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(java.awt.Color.white);

        workRequestJTable.setBackground(new java.awt.Color(255, 204, 204));
        workRequestJTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        workRequestJTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        workRequestJTable.setForeground(new java.awt.Color(255, 0, 51));
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient Id", "Patient Name", "Message by Doctor", "Lab Assistant", "Status", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        requestTestJButton.setBackground(new java.awt.Color(204, 204, 204));
        requestTestJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        requestTestJButton.setForeground(new java.awt.Color(255, 0, 0));
        requestTestJButton.setText("Request test");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(255, 204, 204));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setForeground(new java.awt.Color(255, 0, 51));

        organRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Name", "Organ Required", "Urgency", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(organRequestJTable);
        if (organRequestJTable.getColumnModel().getColumnCount() > 0) {
            organRequestJTable.getColumnModel().getColumn(0).setResizable(false);
            organRequestJTable.getColumnModel().getColumn(1).setResizable(false);
            organRequestJTable.getColumnModel().getColumn(2).setResizable(false);
            organRequestJTable.getColumnModel().getColumn(3).setResizable(false);
            organRequestJTable.getColumnModel().getColumn(4).setResizable(false);
        }

        requestOrganJButton.setBackground(new java.awt.Color(204, 204, 204));
        requestOrganJButton.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        requestOrganJButton.setForeground(new java.awt.Color(255, 0, 51));
        requestOrganJButton.setText("Request Organ");
        requestOrganJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestOrganJButtonActionPerformed(evt);
            }
        });

        lblPatient.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPatient.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPatient.setText("Select Patient:");

        cb_patients.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_patients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_patientsActionPerformed(evt);
            }
        });

        lblAge.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAge.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAge.setText("Age:");

        lblName1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblName1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblName1.setText("Name:");

        viewbtn.setBackground(new java.awt.Color(204, 204, 204));
        viewbtn.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        viewbtn.setForeground(new java.awt.Color(255, 0, 51));
        viewbtn.setText("View Test Report");
        viewbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewbtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DOCTOR DASHBOARD");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Request test for the patient :");

        txtAge.setEditable(false);
        txtAge.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });

        txtName.setEditable(false);
        txtName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        btn_viewPat.setBackground(new java.awt.Color(204, 204, 204));
        btn_viewPat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_viewPat.setForeground(new java.awt.Color(255, 0, 51));
        btn_viewPat.setText("View");
        btn_viewPat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewPatActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Patient and Lab test History : ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Organ Waitlist : ");

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 51));
        jButton2.setText("Notify  organ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        chk_heart.setBackground(new java.awt.Color(255, 204, 204));
        chk_heart.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chk_heart.setForeground(new java.awt.Color(255, 0, 51));
        chk_heart.setText("Heart");

        chk_kidney.setBackground(new java.awt.Color(255, 204, 204));
        chk_kidney.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chk_kidney.setForeground(new java.awt.Color(255, 0, 51));
        chk_kidney.setText("Kidneys");

        chk_liver.setBackground(new java.awt.Color(255, 204, 204));
        chk_liver.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chk_liver.setForeground(new java.awt.Color(255, 0, 51));
        chk_liver.setText("Liver");

        chk_pancreas.setBackground(new java.awt.Color(255, 204, 204));
        chk_pancreas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chk_pancreas.setForeground(new java.awt.Color(255, 0, 51));
        chk_pancreas.setText("Pancreas");

        btn_therapist.setBackground(new java.awt.Color(204, 204, 204));
        btn_therapist.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btn_therapist.setForeground(new java.awt.Color(255, 0, 51));
        btn_therapist.setText("Therapist");
        btn_therapist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_therapistActionPerformed(evt);
            }
        });

        chk_lungs.setBackground(new java.awt.Color(255, 204, 204));
        chk_lungs.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chk_lungs.setForeground(new java.awt.Color(255, 0, 51));
        chk_lungs.setText("Lungs");
        chk_lungs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_lungsActionPerformed(evt);
            }
        });

        chk_intestines.setBackground(new java.awt.Color(255, 204, 204));
        chk_intestines.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chk_intestines.setForeground(new java.awt.Color(255, 0, 51));
        chk_intestines.setText("Intestines");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Select the organ : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblPatient)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cb_patients, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addComponent(btn_viewPat, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtName)
                                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(96, 96, 96))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(requestTestJButton)
                                    .addGap(109, 109, 109))))
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(chk_heart, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chk_kidney, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chk_liver, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chk_pancreas, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chk_lungs, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chk_intestines))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(viewbtn)
                                .addGap(37, 37, 37)
                                .addComponent(requestOrganJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btn_therapist)
                                .addGap(33, 33, 33)
                                .addComponent(jButton2))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 71, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_therapist, jButton2, requestOrganJButton, viewbtn});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lblPatient))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cb_patients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_viewPat, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblName1)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAge))
                        .addGap(18, 18, 18)
                        .addComponent(requestTestJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(chk_heart)
                    .addComponent(chk_kidney)
                    .addComponent(chk_liver)
                    .addComponent(chk_pancreas)
                    .addComponent(chk_lungs)
                    .addComponent(chk_intestines))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewbtn)
                    .addComponent(requestOrganJButton)
                    .addComponent(jButton2)
                    .addComponent(btn_therapist))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_therapist, jButton2, requestOrganJButton, viewbtn});

    }// </editor-fold>//GEN-END:initComponents

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed
  
        
        String string = cb_patients.getSelectedItem().toString();
        String[] parts = string.split(":");
        String id = parts[0].trim();

        RequestLabTestJPanel rlt=new RequestLabTestJPanel(userProcessContainer, userAccount,patAccount(id),enterprise,organization, ecosystem,network);
        userProcessContainer.add("Lab test",rlt);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_requestTestJButtonActionPerformed
    public Patient patAccount(String id){
        for(Patient p: organization.getPatientDirectory().getPatientList()){
            if((""+id).equalsIgnoreCase(""+p.getId())){
                System.out.println(p);
                return p;
            }
        }
        return null;
    }
    private void requestOrganJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestOrganJButtonActionPerformed
        // TODO add your handling code here:
        boolean check;
        check=workRequestJTable.getSelectedRow()>-1;
        if(!check){
            JOptionPane.showMessageDialog(null, "Select a patient");
            return;
        }
        
        
        
        
        
        
        
        Patient p=patAccount(workRequestJTable.getValueAt(workRequestJTable.getSelectedRow(), 0).toString());
       
        
        RequestOrganJpanel tdj=new RequestOrganJpanel(userProcessContainer,organization, userAccount,p,ecosystem,enterprise,network);
        userProcessContainer.add("Lab test",tdj);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
        
    }//GEN-LAST:event_requestOrganJButtonActionPerformed

    private void cb_patientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_patientsActionPerformed
        // TODO add your handling code here:
       
        
        
    }//GEN-LAST:event_cb_patientsActionPerformed

    private void viewbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewbtnActionPerformed
        boolean check;
        check=workRequestJTable.getSelectedRow()>-1;
        if(!check){
            JOptionPane.showMessageDialog(null, "Select a patient");
            return;
        }
        
        Patient p=patAccount(workRequestJTable.getValueAt(workRequestJTable.getSelectedRow(), 0).toString());
        
        String id=workRequestJTable.getValueAt(workRequestJTable.getSelectedRow(), 0).toString();
        
        check=!(workRequestJTable.getValueAt(workRequestJTable.getSelectedRow(), 3)==null);
        if(!check){
            JOptionPane.showMessageDialog(null, "Resulted not generated");
            return;
        }
        
        String labassist=workRequestJTable.getValueAt(workRequestJTable.getSelectedRow(), 3).toString();
        
        TestDataJPanel tdj=new TestDataJPanel(userProcessContainer, userAccount,id,p,labassist,enterprise,organization, ecosystem,network);
        userProcessContainer.add("Lab test",tdj);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
        
        
        
    }//GEN-LAST:event_viewbtnActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btn_viewPatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewPatActionPerformed
        // TODO add your handling code here:
        boolean check;
        check=cb_patients.getSelectedIndex()>0;
        if(!check){
            JOptionPane.showMessageDialog(null, "Select a patient");
        }
        String string = cb_patients.getSelectedItem().toString();
        String[] parts = string.split(":");
        String id = parts[0].trim();
        for(Patient p: organization.getPatientDirectory().getPatientList()){
            if(id.equalsIgnoreCase(""+p.getId())){
                
                lblAge.setVisible(true);
                lblName1.setVisible(true);
                txtName.setVisible(true);
                txtAge.setVisible(true);
                txtAge.setText(p.getAge());
                txtName.setText(p.getName());
                txtAge.setEnabled(false);
                txtName.setEnabled(false);
                requestTestJButton.setVisible(true);
            
            }
        }
    }//GEN-LAST:event_btn_viewPatActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        boolean check;
        check=workRequestJTable.getSelectedRow()>-1;
        if(!check){
            JOptionPane.showMessageDialog(null, "Select a patient");
            return;
        }
        check=(chk_heart.isSelected()||chk_kidney.isSelected()||chk_liver.isSelected()||chk_pancreas.isSelected()||chk_lungs.isSelected()||chk_intestines.isSelected());
        if(!check){
            JOptionPane.showMessageDialog(null, "Select atleast one checkbox");
            return;
        }
        
        
        OrganProcureWorkRequest request = new OrganProcureWorkRequest();
        request.setPatientAccount(patAccount(workRequestJTable.getValueAt(workRequestJTable.getSelectedRow(), 0).toString()));
        
        OrganMatchWorkRequest mr=new OrganMatchWorkRequest();
        mr.setDonpatient(patAccount(workRequestJTable.getValueAt(workRequestJTable.getSelectedRow(), 0).toString()));
        
        
        ArrayList<String> orList=new ArrayList<>();
        if(chk_heart.isSelected()){
            orList.add("Heart");
        }
        if(chk_kidney.isSelected()){
            orList.add("Kidney");
        }
        if(chk_liver.isSelected()){
            orList.add("Liver");
        }
        if(chk_pancreas.isSelected()){
            orList.add("Pancreas");
        }
        if(chk_pancreas.isSelected()){
            orList.add("Lungs");
        }
        if(chk_pancreas.isSelected()){
            orList.add("Intestines");
        }
        request.setOrganList(orList);
        
        Patient chkpat=patAccount(workRequestJTable.getValueAt(workRequestJTable.getSelectedRow(), 0).toString());
        int dup=0;
        for(Network n:ecosystem.getNetworkList()){
            for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
                if(e instanceof OrganBankEnterprise){
                    for(WorkRequest w: e.getWorkQueue().getWorkRequestList()){
                        if(w instanceof OrganProcureWorkRequest){
                            if(((OrganProcureWorkRequest) w).getPatient().getId()==chkpat.getId()){
                                dup=dup+1;
                            }
                        }
                    }
                
                }
            
            }
        }
        
        check=(dup==0);
        if(!check){
            JOptionPane.showMessageDialog(null, "The procurement for this patient is already requested");
            return;
        }
        
        
        
        
        
        
        request.setSender(userAccount);
        request.setStatus("Procurement Requested");
        
        mr.setStatus("Procurement Requested");
        mr.setSender(userAccount);
        
        int size=ecosystem.getWaitList().size();
        int loopcounter=0;
        for(int i=size-1;i>-1;i--){
            for(String s: orList){
                if(s.equalsIgnoreCase(ecosystem.getWaitList().get(i).getOrgan())){
                    loopcounter++;
                    mr.setRecpatient(ecosystem.getWaitList().get(i).getPatient());
                    mr.setOrgan(ecosystem.getWaitList().get(i).getOrgan());
                    break;
                }
            } 
            if(loopcounter>0)break;
        }
        
        
        Enterprise ent = null;
        for(Network n: ecosystem.getNetworkList()){
            if(n.getName().equalsIgnoreCase(network.getName())){
                for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
                    if(e instanceof OrganBankEnterprise){
                        ent=e;
                        if(loopcounter>0){
                            ent.getWorkQueue().getWorkRequestList().add(mr);
                            userAccount.getWorkQueue().getWorkRequestList().add(mr);
                        }else{
                            ent.getWorkQueue().getWorkRequestList().add(request);
                            userAccount.getWorkQueue().getWorkRequestList().add(request);
                        }
                        
                    }
                }
            
            }
            
        }
        
        
        JOptionPane.showMessageDialog(null, "Organ Procurement Requested");
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_therapistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_therapistActionPerformed
        // TODO add your handling code here:
        boolean check;
        check=workRequestJTable.getSelectedRow()>-1;
        if(!check){
            JOptionPane.showMessageDialog(null, "Select a patient");
            return;
        }
        Patient p=patAccount(workRequestJTable.getValueAt(workRequestJTable.getSelectedRow(), 0).toString());
        RequestTherapyJPanel tdj=new RequestTherapyJPanel(userProcessContainer,organization, userAccount,p,ecosystem,enterprise,network);
        userProcessContainer.add("Lab test",tdj);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btn_therapistActionPerformed

    private void chk_lungsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_lungsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_lungsActionPerformed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_therapist;
    private javax.swing.JButton btn_viewPat;
    private javax.swing.JComboBox cb_patients;
    private javax.swing.JCheckBox chk_heart;
    private javax.swing.JCheckBox chk_intestines;
    private javax.swing.JCheckBox chk_kidney;
    private javax.swing.JCheckBox chk_liver;
    private javax.swing.JCheckBox chk_lungs;
    private javax.swing.JCheckBox chk_pancreas;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblPatient;
    private javax.swing.JTable organRequestJTable;
    private javax.swing.JButton requestOrganJButton;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtName;
    private javax.swing.JButton viewbtn;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
