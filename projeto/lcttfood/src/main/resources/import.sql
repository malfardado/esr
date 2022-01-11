insert into cozinha(id, nome) values (1, 'Tailandesa');
insert into cozinha(id, nome) values (2, 'Indiana');
insert into restaurante(nome, taxa_frete, cozinha_id) values ('Tik Tok', 22.5, 1);

insert into forma_pagamento(descricao) values ('Dinheiro');
insert into forma_pagamento(descricao) values ('Cartao de Crédito');

insert into permissao(nome, descricao) value ('cadastrar_usuario','permite realizar cadastro de usuários');

insert into estado(id, nome) values (1, 'Minas Gerais');

insert into cidade(nome, estado_id) values ('Belo Horizonte', 1);