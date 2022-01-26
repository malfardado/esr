insert into cozinha(id, nome) values (1, 'Tailandesa');
insert into cozinha(id, nome) values (2, 'Indiana');
insert into restaurante(nome, taxa_frete, cozinha_id) values ('Thai Gourmet', 10, 1);
insert into restaurante(nome, taxa_frete, cozinha_id) values ('Thai Delivery', 9.5, 1);
insert into restaurante(nome, taxa_frete, cozinha_id) values ('Tuk Tuk Comida Indiana', 15, 2);

insert into forma_pagamento(descricao) values ('Cartao de Crédito');
insert into forma_pagamento(descricao) values ('Cartao de Débito');
insert into forma_pagamento(descricao) values ('Dinheiro');


insert into permissao(nome, descricao) values ('cadastrar_usuario','permite realizar cadastro de usuários');

insert into estado(id, nome) values (1, 'Minas Gerais');

insert into cidade(nome, estado_id) values ('Belo Horizonte', 1);

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3);