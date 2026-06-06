CREATE DATABASE sistema_pedidos
character set utf8mb4
collate utf8mb4_general_ci;

USE sistema_pedidos;

create table cliente(
id_cliente int auto_increment primary key,
nome varchar(100) NOT NULL,
email varchar(100) NOT NULL
);

create table produto(
id_produto int auto_increment primary key,
nome varchar(100) NOT NULL,
preco decimal(10,2) NOT NULL,
estoque int NOT NULL,
categoria varchar(30) NOT NULL
);

create table pedido(
id_pedido int auto_increment primary key,
cliente_id int not null,
status varchar(20) not null,
data_criacao datetime not null,

CONSTRAINT fk_pedido_cliente
	FOREIGN KEY (cliente_id)
    REFERENCES cliente(id_cliente)
);

create table item_pedido(
id_item int auto_increment primary key,
pedido_id int not null,
produto_id int not null,
quantidade int not null,
preco_unitario decimal(10,2) not null,

CONSTRAINT fk_item_pedido
	foreign key (pedido_id)
    REFERENCES pedido(id_pedido),
    
CONSTRAINT fk_item_produto
	foreign key (produto_id)
    REFERENCES produto(id_produto)
);
