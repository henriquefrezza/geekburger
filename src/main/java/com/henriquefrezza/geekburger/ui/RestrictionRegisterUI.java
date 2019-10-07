package com.henriquefrezza.geekburger.ui;

import java.util.ArrayList;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import com.henriquefrezza.geekburger.entities.Ingredient;

public class RestrictionRegisterUI extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	
	public boolean isRestrictionsCreated() {
        return restrictionsCreated;
    }

    public void setRestrictionsCreated(boolean restrictionsCreated) {
        this.restrictionsCreated = restrictionsCreated;
    }

    public RestrictionRegisterUI() {
        initComponents();
    }

    public ArrayList<Ingredient> getClientRestrictions() {
        return clientRestrictions;
    }

    public void setClientRestrictions(ArrayList<Ingredient> clientRestrictions) {
        this.clientRestrictions = clientRestrictions;
    }
         
    public JButton getOK() {
        return OK;
    }

    public void setOK(JButton OK) {
        this.OK = OK;
    }

    public JRadioButton getBeef() {
        return beef;
    }

    public void setBeef(JRadioButton Beef) {
        this.beef = Beef;
    }

    public JRadioButton getDairy() {
        return dairy;
    }

    public void setDairy(JRadioButton Dairy) {
        this.dairy = Dairy;
    }

    public JRadioButton getGluten() {
        return gluten;
    }

    public void setGluten(JRadioButton Gluten) {
        this.gluten = Gluten;
    }

    public JRadioButton getLettuce() {
        return lettuce;
    }

    public void setLettuce(JRadioButton Lettuce) {
        this.lettuce = Lettuce;
    }

    public JRadioButton getPickle() {
        return pickle;
    }

    public void setPickle(JRadioButton Pickle) {
        this.pickle = Pickle;
    }

    public JRadioButton getSoy() {
        return soy;
    }

    public void setSoy(JRadioButton Soy) {
        this.soy = Soy;
    }

    public JRadioButton getSpinach() {
        return spinach;
    }

    public void setSpinach(JRadioButton Spinach) {
        this.spinach = Spinach;
    }

    public JRadioButton getSugar() {
        return sugar;
    }

    public void setSugar(JRadioButton Sugar) {
        this.sugar = Sugar;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }
    
    public void clear() {
    	buttons.forEach((f) -> {f.setSelected(false);});
    	clientRestrictions.clear();
    }
    
    public void generateRestrictions() {
        if(buttons.isEmpty() == true){
            buttons.add(beef);
            buttons.add(dairy);
            buttons.add(gluten);
            buttons.add(lettuce);
            buttons.add(pickle);
            buttons.add(soy);
            buttons.add(spinach);
            buttons.add(sugar);
        }
        buttons.forEach((f) -> {
            if(f.isSelected()) {
                Ingredient ingredient = new Ingredient("" + UUID.randomUUID(), f.getText());
                clientRestrictions.add(ingredient);
            }
        });
        restrictionsCreated = true;
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        soy = new javax.swing.JRadioButton();
        lettuce = new javax.swing.JRadioButton();
        pickle = new javax.swing.JRadioButton();
        gluten = new javax.swing.JRadioButton();
        sugar = new javax.swing.JRadioButton();
        spinach = new javax.swing.JRadioButton();
        dairy = new javax.swing.JRadioButton();
        beef = new javax.swing.JRadioButton();
        OK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel1.setText("Selecione os ingredientes que possui restrição e confirme");

        soy.setText("Soy");

        lettuce.setText("Lettuce");

        pickle.setText("Pickle");

        gluten.setText("Gluten");

        sugar.setText("Sugar");

        spinach.setText("Spinach");

        dairy.setText("Dairy");

        beef.setText("Beef");

        OK.setText("Confirmar");
        OK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                OKMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(soy)
                    .addComponent(lettuce)
                    .addComponent(pickle)
                    .addComponent(beef))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sugar)
                    .addComponent(spinach)
                    .addComponent(gluten)
                    .addComponent(dairy))
                .addGap(66, 66, 66))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(OK)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dairy)
                        .addGap(18, 18, 18)
                        .addComponent(gluten)
                        .addGap(18, 18, 18)
                        .addComponent(sugar)
                        .addGap(18, 18, 18)
                        .addComponent(spinach))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(soy)
                        .addGap(18, 18, 18)
                        .addComponent(beef)
                        .addGap(18, 18, 18)
                        .addComponent(lettuce)
                        .addGap(18, 18, 18)
                        .addComponent(pickle)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(OK)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OKMouseReleased
        generateRestrictions();
    }//GEN-LAST:event_OKMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OK;
    private javax.swing.JRadioButton beef;
    private javax.swing.JRadioButton dairy;
    private javax.swing.JRadioButton gluten;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton lettuce;
    private javax.swing.JRadioButton pickle;
    private javax.swing.JRadioButton soy;
    private javax.swing.JRadioButton spinach;
    private javax.swing.JRadioButton sugar;
    private ArrayList<Ingredient> clientRestrictions = new ArrayList<>();
    private ArrayList<JRadioButton> buttons = new ArrayList<>();
    private boolean restrictionsCreated = false;
}
