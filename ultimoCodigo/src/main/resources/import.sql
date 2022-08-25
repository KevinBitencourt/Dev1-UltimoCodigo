insert into produto (id, nome) values (1, 'Tailandesa');
insert into produto (id, nome) values (2, 'Indiana');

insert into cliente (id, nome, produto_id) values (1, 'Thai Gourmet', 1);
insert into cliente (id, nome, produto_id) values (2, 'Thai Delivery', 1);
insert into cliente (id, nome, produto_id) values (3, 'Tuk Tuk Comida Indiana', 2);

insert into venda (id, descricao) values (1, 'Cartão de crédito');
insert into venda (id, descricao) values (2, 'Cartão de débito');
insert into venda (id, descricao) values (3, 'Dinheiro');
insert into Cliente_Venda (cliente_id, venda_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3);
