package com.henriquefrezza.geekburger.ui;

import java.util.ArrayList;
import java.util.Stack;
import java.util.UUID;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;

import com.henriquefrezza.geekburger.entities.Order;
import com.henriquefrezza.geekburger.entities.Product;

public class UI extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;

	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public boolean isAddRestriction() {
		return addRestriction;
	}

	public void setAddRestriction(boolean addRestriction) {
		this.addRestriction = addRestriction;
	}

	public boolean isCanceledOrder() {
		return canceledOrder;
	}

	public void setCanceledOrder(boolean canceledOrder) {
		this.canceledOrder = canceledOrder;
	}

	public boolean isEndedOrder() {
        return endedOrder;
    }

    public void setEndedOrder(boolean confirmedOrder) {
        this.endedOrder = confirmedOrder;
    }
    
    public ArrayList<Product> getFilteredList() {
        return filteredList;
    }

    public void setFilteredList(ArrayList<Product> filteredList) {
        this.filteredList = filteredList;
    }
    
    public JList<String> getOrderPanel() {
        return orderPanel;
    }

    public void setOrderPanel(JList<String> orderPanel) {
        this.orderPanel = orderPanel;
    }

    public JTable getProductsTable() {
        return productsTable;
    }

    public void setProductsTable(JTable productsTable) {
        this.productsTable = productsTable;
    }
         
    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(ArrayList<Product> productsList) {
        this.productsList = productsList;
    }

    public ArrayList<Product> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Product> orderList) {
        this.orderList = orderList;
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

    public int getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(int ordersCount) {
        this.ordersCount = ordersCount;
    }
    
    public UI() {
        initComponents();
    } 
    
    private void toOrder(int index){
        if (index != -1){
            orderList.add(filteredList.get(index));
            orderModel.addElement(filteredList.get(index).getName());
            orderPanel.setModel(orderModel);
        }        
    }
    
    private void clearOrder() {
        orderList.clear();
        orderModel.clear();
    }
    
    private void cancelOrder() {
        canceledOrder = true;
    	clearOrder();
    }
    
    private void removeProduct(int index) {
        if(index != -1){
            orderList.remove(index);
            orderModel.remove(index);
        }        
    }
    
    private void confirmOrder(){
        if(!orderList.isEmpty()){
        	orderList.forEach((f) -> {
        		orderPrice += f.getPrice();});
            Order order = new Order("" + UUID.randomUUID(), "Pedido " + ordersCount, orderPrice, orderList);
            ordersStack.push(order);
            ordersCount++;
            endedOrder = true;
            clearOrder();
        }       
    }   
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        addToOrder = new javax.swing.JButton();
        newRestriction = new javax.swing.JButton();
        confirmOrder = new javax.swing.JButton();
        cancelOrder = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderPanel = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        removeFromOrder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        productsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(productsTable);

        addToOrder.setText("Adicionar ao Pedido");
        addToOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToOrderActionPerformed(evt);
            }
        });

        newRestriction.setText("Nova Restrição");
        newRestriction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRestrictionActionPerformed(evt);
            }
        });

        confirmOrder.setText("Confirmar Pedido");
        confirmOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmOrderActionPerformed(evt);
            }
        });

        cancelOrder.setText("Cancelar Pedido");
        cancelOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelOrderActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        jLabel1.setText("GEEK BURGER");

        orderPanel.setModel(new javax.swing.AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			String[] strings = { "Sem Produtos" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        orderPanel.setToolTipText("");
        jScrollPane2.setViewportView(orderPanel);

        jLabel2.setText("Produtos");

        jLabel3.setText("Pedido");

        removeFromOrder.setText("Remover do Pedido");
        removeFromOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFromOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(newRestriction, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addToOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(removeFromOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cancelOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(confirmOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addToOrder)
                            .addComponent(newRestriction)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeFromOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmOrder)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void addToOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToOrderActionPerformed
        toOrder(productsTable.getSelectedRow());
    }//GEN-LAST:event_addToOrderActionPerformed

    private void cancelOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelOrderActionPerformed
        cancelOrder();       
    }//GEN-LAST:event_cancelOrderActionPerformed

    private void removeFromOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFromOrderActionPerformed
        removeProduct(orderPanel.getSelectedIndex());
    }//GEN-LAST:event_removeFromOrderActionPerformed

    private void confirmOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmOrderActionPerformed
        confirmOrder(); 
    }//GEN-LAST:event_confirmOrderActionPerformed

    private void newRestrictionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newRestrictionActionPerformed
        addRestriction = true;
    }//GEN-LAST:event_newRestrictionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToOrder;
    private javax.swing.JButton cancelOrder;
    private javax.swing.JButton confirmOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton newRestriction;
    private javax.swing.JList<String> orderPanel;
    private javax.swing.JTable productsTable;
    private javax.swing.JButton removeFromOrder;
    private ArrayList<Product> productsList = new ArrayList<Product>();
    private ArrayList<Product> filteredList = new ArrayList<Product>();
    private ArrayList<Product> orderList = new ArrayList<Product>();
    private DefaultListModel<String> orderModel = new DefaultListModel<String>();
    private boolean endedOrder = false;
    private boolean canceledOrder = false;
    private boolean addRestriction = false;
    private Stack<Order> ordersStack = new Stack<Order>();
    private int ordersCount = 0;
    private Double orderPrice = 0.0;
}
