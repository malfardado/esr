create table cozinha (
  id serial not null,
  nome varchar(60) not null,

  primary key (id)
);
create table cidade (
	id serial not null,
	nome varchar(80) not null,
	nome_estado varchar(80) not null,

	primary key (id)
);
create table estado (
	id serial not null,
	nome varchar(80) not null,

	primary key (id)
);
insert into estado (nome) select distinct nome_estado from cidade;

alter table cidade add column estado_id bigint not null;

-- update cidade c set c.estado_id = (select e.id from estado e where e.nome = c.nome_estado);

alter table cidade add constraint fk_cidade_estado
foreign key (estado_id) references estado (id);

alter table cidade drop column nome_estado;

-- alter table cidade change nome_cidade nome varchar(80) not null;

create table forma_pagamento (
	id serial not null,
	descricao varchar(60) not null,
	primary key (id)
);
create table grupo (
	id serial not null,
	nome varchar(60) not null,

	primary key (id)
);
create table grupo_permissao (
	grupo_id bigint not null,
	permissao_id bigint not null,

	primary key (grupo_id, permissao_id)
);
create table permissao (
	id serial not null,
	descricao varchar(60) not null,
	nome varchar(100) not null,

	primary key (id)
);
create table produto (
	id serial not null,
	restaurante_id bigint not null,
	nome varchar(80) not null,
	descricao text not null,
	preco decimal(10,2) not null,
	ativo integer not null,

	primary key (id)
);
create table restaurante (
	id serial not null,
	cozinha_id bigint not null,
	nome varchar(80) not null,
	taxa_frete decimal(10,2) not null,
	data_atualizacao timestamp  not null,
	data_cadastro timestamp  not null,

	endereco_cidade_id bigint,
	endereco_cep varchar(9),
	endereco_logradouro varchar(100),
	endereco_numero varchar(20),
	endereco_complemento varchar(60),
	endereco_bairro varchar(60),

	primary key (id)
);
create table restaurante_forma_pagamento (
	restaurante_id bigint not null,
	forma_pagamento_id bigint not null,

	primary key (restaurante_id, forma_pagamento_id)
);
create table usuario (
	id serial not null,
	nome varchar(80) not null,
	email varchar(255) not null,
	senha varchar(255) not null,
	data_cadastro timestamp  not null,

	primary key (id)
);
create table usuario_grupo (
	usuario_id bigint not null,
	grupo_id bigint not null,

	primary key (usuario_id, grupo_id)
);


alter table grupo_permissao add constraint fk_grupo_permissao_permissao
foreign key (permissao_id) references permissao (id);

alter table grupo_permissao add constraint fk_grupo_permissao_grupo
foreign key (grupo_id) references grupo (id);

alter table produto add constraint fk_produto_restaurante
foreign key (restaurante_id) references restaurante (id);

alter table restaurante add constraint fk_restaurante_cozinha
foreign key (cozinha_id) references cozinha (id);

alter table restaurante add constraint fk_restaurante_cidade
foreign key (endereco_cidade_id) references cidade (id);

alter table restaurante_forma_pagamento add constraint fk_rest_forma_pagto_forma_pagto
foreign key (forma_pagamento_id) references forma_pagamento (id);

alter table restaurante_forma_pagamento add constraint fk_rest_forma_pagto_restaurante
foreign key (restaurante_id) references restaurante (id);

alter table usuario_grupo add constraint fk_usuario_grupo_grupo
foreign key (grupo_id) references grupo (id);

alter table usuario_grupo add constraint fk_usuario_grupo_usuario
foreign key (usuario_id) references usuario (id);