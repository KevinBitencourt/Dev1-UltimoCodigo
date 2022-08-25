insert into produto (id, nome) values (1, 'Bola');
insert into produto (id, nome) values (2, 'Chinelo');

insert into cliente (id, nome, produto_id) values (1, 'João', 1);
insert into cliente (id, nome, produto_id) values (2, 'Maria', 1);
insert into cliente (id, nome, produto_id) values (3, 'Pedrinho', 2);

insert into venda (id, nome) values (1, 'Compra 1');
insert into venda (id, nome) values (2, 'Compra 2');
insert into venda (id, nome) values (3, 'Compra 3');
insert into Cliente_Venda (cliente_id, venda_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3);
