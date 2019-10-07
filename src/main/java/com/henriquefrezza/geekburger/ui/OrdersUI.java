package com.henriquefrezza.geekburger.ui;

import java.util.Stack;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import com.henriquefrezza.geekburger.entities.Order;

public class OrdersUI extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	
	public OrdersUI() {
        super("Pedidos");
        initComponents();
    }
	
	public DefaultListModel<String> getOrderModel() {
		return orderModel;
	}

	public void setOrderModel(DefaultListModel<String> orderModel) {
		this.orderModel = orderModel;
	}

	public Stack<Order> getOrdersStack() {
		return ordersStack;
	}

	public void setOrdersStack(Stack<Order> ordersStack) {
		this.ordersStack = ordersStack;
	}

	public JList<String> getjList1() {
        return ordersPanel;
    }

    public void setjList1(JList<String> jList1) {
        this.ordersPanel = jList1;
    }
    
    public void refresh(){
        if (orderModel.getSize() != ordersStack.size()) orderModel.clear();
    	ordersStack.forEach((f) -> {
            if(!orderModel.contains(f.getOrderName())) orderModel.addElement(f.getOrderName());});
    	ordersPanel.setModel(orderModel);
    }
    
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ordersPanel = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ordersPanel.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        ordersPanel.setModel(new javax.swing.AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			String[] strings = { };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ordersPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(ordersPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> ordersPanel;
    private DefaultListModel<String> orderModel = new DefaultListModel<String>();
    private Stack<Order> ordersStack = new Stack<Order>();
}