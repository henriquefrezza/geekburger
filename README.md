# geekburger

- Ao iniciar a aplicação são apresentadas três telas: 

- Pedidos: que apresentará os pedidos realizados, simulando a tela que fica visível aos clientes
- Produção: que simula a tela visível na área de produção, tem portanto um botão para retirar da lista os produtos já entregues
- E outra tela que apenas auxilia na simulação do reconhecimento facial(que foi abstraido na aplicação), ou seja, na aplicação funcional esta tela seria descartada

- Para seguir a processo, o usuário deve inserir uma das restrições apresentadas na tela, ou deixar o campo em branco e prosseguir
- Caso insira uma restrição a aplicação apresenta uma mensagem de reconhecimento facial e prossegue para a tela principal com os produtos já fltrados de acordo com aquela restrição
- Caso deixe o campo em branco, outra tela será aberta para cadastro de restrições. Após o cadastro pelo usuário a aplicação segue para a mesma tela principal com os produtos filtrados

- Na tela principal estão os botões:
- Nova restrição: que leva a tela de cadastro de restrições novamente, caso o usuario queira cadastrar uma nova restrição
- Adicionar ao pedido: o usuário deve selecionar um produto no painel "Produtos" e apertar este botão que inserirá o produto no pedido
- Remover do pedido: o usuário deve selecionar um produto no painel "Pedido" e apertar este botão para retirar um produto do pedido
- Cancelar Pedido: que cancela o pedido e retorn ao inicio do ciclo
- Confirmar pedido: que leva a tela de pagamento caso existam produtos na lista do pedido

- Na tela  tela de pagamento o usuario deve inserir a senha. (para simular pagamento realizado com sucesso a senha deve ser "pago")
- Caso não tenha sucesso no pagamento a ordem é retirada da lista, e permanece na tela de seleção dos produtos
- Caso tenha sucesso o pedido é enviado para o painel de pedidos, sendo retirado apenas pela produção, e retorna ao inicio do ciclo
