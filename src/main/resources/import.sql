INSERT INTO categorias (nome, imagem) VALUES ('Carrinhos', 'carrinhos.jpg');
INSERT INTO categorias (nome, imagem) VALUES ('Bonecas', 'bonecas.jpg');
INSERT INTO categorias (nome, imagem) VALUES ('Educativos', 'educativos.jpg');
INSERT INTO categorias (nome, imagem) VALUES ('Jogos de Tabuleiro', 'jogos-tabuleiro.jpg');
INSERT INTO categorias (nome, imagem) VALUES ('Pelucias', 'pelucias.jpg');
INSERT INTO categorias (nome, imagem) VALUES ('Blocos de Montar', 'blocos-montar.jpg');
INSERT INTO categorias (nome, imagem) VALUES ('Brinquedos para Bebe', 'bebe.jpg');
INSERT INTO categorias (nome, imagem) VALUES ('Brinquedos Eletronicos', 'eletronicos.jpg');
INSERT INTO categorias (nome, imagem) VALUES ('Quebra-Cabecas', 'quebra-cabecas.jpg');
INSERT INTO categorias (nome, imagem) VALUES ('Brinquedos de Construção', 'construcao.jpg');
INSERT INTO categorias (nome, imagem) VALUES ('Figuras de Ação', 'figuras-acao.jpg');
INSERT INTO categorias (nome, imagem) VALUES ('Carrinhos de Controle Remoto', 'controle-remoto.jpg');
INSERT INTO categorias (nome, imagem) VALUES ('Instrumentos Musicais Infantis', 'instrumentos.jpg');
INSERT INTO categorias (nome, imagem) VALUES ('Brinquedos de Praia', 'praia.jpg');
INSERT INTO categorias (nome, imagem) VALUES ('Massinha e Artes', 'massinha.jpg');
INSERT INTO categorias (nome, imagem) VALUES ('Brinquedos Educativos STEM', 'stem.jpg');
INSERT INTO categorias (nome, imagem) VALUES ('Casinhas e Cozinhas', 'casinhas.jpg');
INSERT INTO categorias (nome, imagem) VALUES ('Trens e Pistas', 'trens.jpg');
INSERT INTO categorias (nome, imagem) VALUES ('Dinossauros', 'dinossauros.jpg');
INSERT INTO categorias (nome, imagem) VALUES ('Super-Herois', 'super-herois.jpg');

INSERT INTO marca (nome, imagem) VALUES ('Candide', 'candide.jpg');
INSERT INTO marca (nome, imagem) VALUES ('Disney', 'disney.jpg');
INSERT INTO marca (nome, imagem) VALUES ('Fisher Price', 'fisher_price.jpg');
INSERT INTO marca (nome, imagem) VALUES ('Hasbro', 'hasbro.jpg');
INSERT INTO marca (nome, imagem) VALUES ('Hotwheels', 'hotwheels.jpg');
INSERT INTO marca (nome, imagem) VALUES ('Lego', 'lego.jpg');
INSERT INTO marca (nome, imagem) VALUES ('Mattel', 'mattel.jpg');
INSERT INTO marca (nome, imagem) VALUES ('Pop', 'pop.jpg');

INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Carrinho Hot Wheels', 'Carrinho de metal em miniatura da linha Hot Wheels', 'hotwheels.jpg', 19.90, 1, 5);

INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Boneca Barbie', 'Boneca Barbie classica com acessorios', 'barbie.jpg', 89.90, 2, 7);

INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Lego City Policia', 'Conjunto Lego City com viatura policial', 'lego-police.jpg', 159.90, 6, 6);

INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Dinossauro T-Rex', 'Dinossauro de brinquedo articulado', 'trex.jpg', 49.90, 19, 1);

INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Quebra cabeca 500 pecas', 'Quebra cabeca infantil de 500 pecas', 'puzzle500.jpg', 39.90, 9, 4);

INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Caminhao de Bombeiro', 'Caminhao de bombeiro com escada movel', 'bombeiro.jpg', 74.90, 1, 3);

INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Urso de Pelucia', 'Urso de pelucia macio tamanho medio', 'urso.jpg', 59.90, 5, 8);

INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Pista Hot Wheels', 'Pista de corrida Hot Wheels com loop', 'pista.jpg', 129.90, 1, 5);

INSERT INTO usuarios (imagem, nome, email, senha, tipo) VALUES ('ana.jpg', 'Ana Souza', 'ana.souza@email.com', '123456', 'CLIENTE');

INSERT INTO usuarios (imagem, nome, email, senha, tipo) VALUES ('carlos.jpg', 'Carlos Mendes', 'carlos.mendes@email.com', '123456', 'CLIENTE');

INSERT INTO usuarios (imagem, nome, email, senha, tipo) VALUES ('mariana.jpg', 'Mariana Lima', 'mariana.lima@email.com', '123456', 'CLIENTE');

INSERT INTO usuarios (imagem, nome, email, senha, tipo) VALUES ('joao.jpg', 'João Pereira', 'joao.pereira@email.com', '123456', 'CLIENTE');

INSERT INTO usuarios (imagem, nome, email, senha, tipo) VALUES ('lucas.jpg', 'Lucas Martins', 'lucas.martins@email.com', '123456', 'CLIENTE');

INSERT INTO usuarios (imagem, nome, email, senha, tipo) VALUES ('fernanda.jpg', 'Fernanda Alves', 'fernanda.alves@email.com', '123456', 'CLIENTE');

INSERT INTO usuarios (imagem, nome, email, senha, tipo) VALUES ('roberto.jpg', 'Roberto Silva', 'roberto.silva@email.com', '123456', 'ADMIN');

INSERT INTO usuarios (imagem, nome, email, senha, tipo) VALUES ('patricia.jpg', 'Patricia Gomes', 'patricia.gomes@email.com', '123456', 'CLIENTE');

INSERT INTO usuarios (imagem, nome, email, senha, tipo) VALUES ('rafael.jpg', 'Rafael Costa', 'rafael.costa@email.com', '123456', 'ADMIN');

INSERT INTO usuarios (imagem, nome, email, senha, tipo) VALUES ('juliana.jpg', 'Juliana Rocha', 'juliana.rocha@email.com', '123456', 'CLIENTE');
