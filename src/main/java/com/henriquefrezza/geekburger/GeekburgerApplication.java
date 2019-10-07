package com.henriquefrezza.geekburger;

import java.util.ArrayList;
import java.util.Stack;
import java.util.UUID;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.henriquefrezza.geekburger.entities.Client;
import com.henriquefrezza.geekburger.entities.Order;
import com.henriquefrezza.geekburger.entities.Product;
import com.henriquefrezza.geekburger.entities.Production;
import com.henriquefrezza.geekburger.entities.Restriction;
import com.henriquefrezza.geekburger.ui.OrdersUI;
import com.henriquefrezza.geekburger.ui.ProductionUI;
import com.henriquefrezza.geekburger.ui.RestrictionRegisterUI;
import com.henriquefrezza.geekburger.ui.UI;


@SpringBootApplication
public class GeekburgerApplication {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException {
		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(GeekburgerApplication.class);
		builder.headless(false);
		ConfigurableApplicationContext context = builder.run(args);
        
      //receive products list
        ArrayList<Product> productsList = (ArrayList<Product>) context.getBean("getProducts");
        
      //get production areas status
        Production production = (Production) context.getBean("getProduction");
        
      //open orders panel
        OrdersUI ordersUI = new OrdersUI();
        ordersUI.setVisible(true);
        
      //get production UI
        ProductionUI productionUI = new ProductionUI();//(ProductionUI) context.getBean("getProductionUI");
        productionUI.setVisible(true);
        productionUI.setLocation(0, 330);
        
        Stack<Order> ordersStack = new Stack<Order>();
        
        ArrayList<String> columns = new ArrayList<>();

        columns.add("Nome");
        columns.add("Preço");
        columns.add("Imagem");
        
		RestrictionRegisterUI register = new RestrictionRegisterUI();
        Client client = new Client();        
        UI ui = new UI();
        
        String option = "begin";
        String clientID = "";
        
        while (true) {
        	
        	if (!ordersStack.isEmpty()) {
        		if (productionUI.getOrderModel().size() != productionUI.getOrdersStack().size()) {
        			ordersStack = productionUI.getOrdersStack();
        			productionUI.refresh();
        			ui.setOrdersStack(ordersStack);
        			ordersUI.setOrdersStack(ordersStack);
        			ordersUI.refresh();
        		}
        	}
        			
        	switch(option) {
        	
        	case "begin":
        		clientID = JOptionPane.showInputDialog(
        				null, "Insira uma das chaves para simular um usuário com cadastro:\n\n"
        		+ "-soy\n-beef\n-lettuce\n-pickle\n-dairy\n-gluten\n-sugar\n-spinach\n\n"
        		+ "Ou deixe o campo em branco para simular um novo usuário\n\n");
        		if (clientID == null) {
        			clientID = "";}
                else{
                    clientID = clientID.toUpperCase();
                }
        		if (clientID.isEmpty()) option = "visibleRegister";
        		else option = "getClient";
        		
            	JOptionPane.showMessageDialog(null, "Reconhecimento Facial...");
        	break;
        		case "visibleRegister":
                		register.setVisible(true);
                		register.setLocationRelativeTo(null);
                		option = "register";
                break;
        		case "register":
                	if (register.isRestrictionsCreated()) {
                		Restriction restrictions = new Restriction();
                		restrictions.setIdRestriction("" + UUID.randomUUID());
                		restrictions.setRestrictionItems(register.getClientRestrictions());
                		client.setClientId("" + UUID.randomUUID());
                		client.setRestrictions(restrictions);
                		register.setVisible(false);
                   		register.setRestrictionsCreated(false);
                		option = "createUI";
                		}                	
                break;
        		case "getClient":
        			client.setRestrictions((Restriction) context.getBean("getClientRestrictions", clientID));
        			option = "createUI";
        		break;
                case "createUI":
                	ui.setVisible(true);
                	ui.setLocationRelativeTo(null);

                	ui.setFilteredList(client.getRestrictions().filter(productsList, production));
                	ui.setFilteredList(production.filter(ui.getFilteredList()));

                	ArrayList<String[]> values = new ArrayList<>();

                	ui.getFilteredList().forEach((f) -> {
                		values.add(new String[]{f.getName(), f.getPrice().toString(), f.getImage()});
                	});

                	TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][]{}), columns.toArray());

                	ui.getProductsTable().setModel(tableModel);
                	
                	option = "order";
                break;
                case "order":
                	if (ui.isEndedOrder()) {
                		ui.setEndedOrder(false);
                		option = "payment";
                	}
                	if (ui.isAddRestriction()) {
                		ui.setVisible(false);
                		ui.setAddRestriction(false);
                		option = "visibleRegister";
                		register.getClientRestrictions().clear();
                	}
                	if (ui.isCanceledOrder()) {
                		ui.setVisible(false);
                		register.clear();
                		ui.setCanceledOrder(false);
                		option = "begin";
                	}
                break;
                case "payment":
                	String password = "";
                	password = JOptionPane.showInputDialog(
                			null, "Valor = " + ui.getOrderPrice()
                			+ "\n\nInsira a senha:\n\n (Insira \"pago\" para simular pagamento efetuado com sucesso)");
               	
                if (password == null) password = "cancelado";
               	else password = password.toUpperCase();
               	
               		boolean paidout = (boolean) context.getBean("getPayment", password);
               		if (paidout) {
               			JOptionPane.showMessageDialog(null, "Pagamento efetuado com sucesso!");
               			register.clear();
               			ui.setVisible(false);
               			ui.setOrderPrice(0.0);
               			ordersStack = ui.getOrdersStack();
               			ordersUI.setOrdersStack(ordersStack);
               			ordersUI.refresh();
               			productionUI.setOrdersStack(ordersStack);
                		productionUI.refresh();
               			option = "begin";
               		}
               		else {
               			JOptionPane.showMessageDialog(null, "Pagamento negado");
               			ui.setOrderPrice(0.0);
               			ui.getOrdersStack().pop();
               			ui.setOrdersCount(ui.getOrdersCount()-1);
               			ordersStack = ui.getOrdersStack();
               			ordersUI.setOrdersStack(ordersStack);
               			ordersUI.refresh();
               			productionUI.setOrdersStack(ordersStack);
                		productionUI.refresh();
               			option = "order";
                	}
                break;
                default: option = "begin";  
        	} 
        }
	}
}
