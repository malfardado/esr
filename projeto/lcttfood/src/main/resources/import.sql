--SOMENTE EXECUTADO QUANDO O GENERETE DDL ESTA ATIVADO
--application.properies
--#spring.jpa.generate-ddl=true
--#spring.jpa.hibernate.ddl-auto=create

insert into cozinha(id, nome) values (1, 'Tailandesa');
insert into cozinha(id, nome) values (2, 'Indiana');

insert into estado (id, nome) values (1, 'Minas Gerais');
insert into estado (id, nome) values (2, 'São Paulo');
insert into estado (id, nome) values (3, 'Ceará');

insert into cidade (id, nome, estado_id) values (1, 'Uberlândia', 1);
insert into cidade (id, nome, estado_id) values (2, 'Belo Horizonte', 1);
insert into cidade (id, nome, estado_id) values (3, 'São Paulo', 2);
insert into cidade (id, nome, estado_id) values (4, 'Campinas', 2);
insert into cidade (id, nome, estado_id) values (5, 'Fortaleza', 3);

insert into restaurante(nome, taxa_frete, cozinha_id, endereco_cidade_id, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, data_cadastro, data_atualizacao) values ('Thai Gourmet', 10, 1, 1,'Chapadão', '35650-000', 'n/a', 'Rua Siderpita', '580', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into restaurante(nome, taxa_frete, cozinha_id, endereco_cidade_id, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, data_cadastro, data_atualizacao) values ('Thai Delivery', 9.5, 1, 1,'Chapadão', '35650-000', 'n/a', 'Rua Siderpita', '580', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into restaurante(nome, taxa_frete, cozinha_id, endereco_cidade_id, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, data_cadastro, data_atualizacao) values ('Tuk Tuk Comida Indiana', 15, 2, 1,'Chapadão', '35650-000', 'n/a', 'Rua Siderpita', '580', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into forma_pagamento(descricao) values ('Cartao de Crédito');
insert into forma_pagamento(descricao) values ('Cartao de Débito');
insert into forma_pagamento(descricao) values ('Dinheiro');


insert into permissao(nome, descricao) values ('cadastrar_usuario','permite realizar cadastro de usuários');

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3);

INSERT INTO produto(ativo, descricao, nome, preco, resturante_id) VALUES(true, 'Hamburguer', 'Humburguer de Boi', 20.50, 1);
INSERT INTO produto(ativo, descricao, nome, preco, resturante_id) VALUES(true, 'X-Tudo', 'X-Tudo completão', 30, 1);
INSERT INTO produto(ativo, descricao, nome, preco, resturante_id) VALUES(true, 'Bata Frita', 'Bata frita na air fraier', 9.99, 1);
INSERT INTO produto(ativo, descricao, nome, preco, resturante_id) VALUES(true, 'Refrigerante', 'Refrigerante Lata', 6, 1);
