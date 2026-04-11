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

INSERT INTO marcas (nome, imagem) VALUES ('Candide', 'candide.jpg');
INSERT INTO marcas (nome, imagem) VALUES ('Disney', 'disney.jpg');
INSERT INTO marcas (nome, imagem) VALUES ('Fisher Price', 'fisher_price.jpg');
INSERT INTO marcas (nome, imagem) VALUES ('Hasbro', 'hasbro.jpg');
INSERT INTO marcas (nome, imagem) VALUES ('Hotwheels', 'hotwheels.jpg');
INSERT INTO marcas (nome, imagem) VALUES ('Lego', 'lego.jpg');
INSERT INTO marcas (nome, imagem) VALUES ('Mattel', 'mattel.jpg');
INSERT INTO marcas (nome, imagem) VALUES ('Pop', 'pop.jpg');

INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Carrinho Hot Wheels', 'Carrinho de metal em miniatura da linha Hot Wheels', 'hotwheels.jpg', 19.90, 1, 5);

INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Boneca Barbie', 'Boneca Barbie classica com acessorios', 'barbie.jpg', 89.90, 2, 7);

INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Lego City Policia', 'Conjunto Lego City com viatura policial', 'lego-police.jpg', 159.90, 6, 6);

INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Dinossauro T-Rex', 'Dinossauro de brinquedo articulado', 'trex.jpg', 49.90, 19, 1);

INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Quebra cabeca 500 pecas', 'Quebra cabeca infantil de 500 pecas', 'puzzle500.jpg', 39.90, 9, 2);

INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Caminhao de Bombeiro', 'Caminhao de bombeiro com escada movel', 'bombeiro.jpg', 74.90, 1, 3);

INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Urso de Pelucia', 'Urso de pelucia macio tamanho medio', 'urso.jpg', 59.90, 5, 7);

INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Pista Hot Wheels', 'Pista de corrida Hot Wheels com loop', 'pista.jpg', 129.90, 1, 5);

/* BONECAS E BEBÊS */
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Bebê Reborn Realista', 'Boneca com traços realistas, acompanha roupinha e mamadeira.', 'bebe-reborn.jpg', 250.00, 2, 7);
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Tapete de Atividades', 'Tapete musical colorido com piano e móbiles para estimulação.', 'tapete-atividades.jpg', 189.90, 7, 1);
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Cubo Didático Encaixe', 'Cubo com peças geométricas para desenvolvimento motor do bebê.', 'cubo-didatico.jpg', 45.00, 7, 1);

/* JOGOS DE TABULEIRO E QUEBRA-CABEÇAS */
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Jogo Banco Imobiliário', 'O clássico jogo de compra e venda de propriedades.', 'banco-imobiliario.jpg', 120.00, 4, 4);
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Jogo Cara a Cara', 'Descubra o personagem do adversário fazendo perguntas divertidas.', 'cara-a-cara.jpg', 85.90, 4, 4);
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Quebra-Cabeça 3D', 'Monte o castelo de Hogwarts em 3 dimensões.', 'puzzle-3d.jpg', 195.00, 9, 4);

/* PELÚCIAS */
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Cachorrinho de Pelúcia', 'Pelúcia macia e antialérgica em formato de cachorro.', 'cachorrinho.jpg', 65.50, 5, 8);
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Polvo do Humor', 'Pelúcia reversível que muda de cor e expressão.', 'polvo-reversivel.jpg', 29.90, 5, 8);

/* BLOCOS E CONSTRUÇÃO */
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Lego Creator Dinossauro', 'Conjunto 3 em 1 para montar dinossauros diferentes.', 'lego-dinossauro.jpg', 145.90, 6, 6);
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Blocos Magnéticos', 'Peças translúcidas com imãs para montar castelos e torres.', 'blocos-magneticos.jpg', 110.00, 10, 6);

/* ELETRÔNICOS E CONTROLE REMOTO */
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Robô Dançarino', 'Robô interativo que toca música, dança e acende luzes.', 'robo-dancarino.jpg', 135.00, 8, 3);
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Drone Infantil', 'Mini drone com estabilizador de voo para iniciantes.', 'drone-infantil.jpg', 299.90, 8, 3);
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Carro Off-Road RC', 'Veículo de controle remoto 2.4GHz com suspensão.', 'carro-offroad.jpg', 189.00, 12, 3);

/* ARTES, EDUCATIVOS E MÚSICA */
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Teclado Musical Infantil', 'Teclado com sons de animais, ritmos e microfone acoplado.', 'teclado-musical.jpg', 95.00, 13, 1);
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Bateria Infantil', 'Mini bateria completa com bumbo, caixas, prato e baquetas.', 'bateria-infantil.jpg', 175.00, 13, 1);
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Fábrica de Sorvetes', 'Máquina de fazer sorvetes com massinhas de modelar coloridas.', 'fabrica-sorvetes.jpg', 125.90, 15, 4);
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Lousa Mágica Digital', 'Tablet infantil para desenhar e apagar com um clique.', 'lousa-magica.jpg', 55.00, 15, 1);
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Kit Química Infantil', 'Conjunto com experiências seguras para introdução à ciência.', 'kit-quimica.jpg', 150.00, 16, 4);

/* FAZ DE CONTA (Roleplay) */
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Kit Baldinho de Praia', 'Acompanha balde, peneira, pazinha e forminhas.', 'baldinho-praia.jpg', 35.90, 14, 1);
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Cozinha Master', 'Cozinha completa com fogãozinho, pia e panelinhas.', 'cozinha-infantil.jpg', 210.00, 17, 7);
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Ferrorama Clássico', 'Pista de trem com locomotiva elétrica e vagões.', 'ferrorama.jpg', 280.00, 18, 5);

/* AÇÃO, HERÓIS E DINOSSAUROS */
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Triceratops com Som', 'Dinossauro emborrachado que emite rugidos realistas.', 'triceratops.jpg', 75.00, 19, 1);
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Boneco Batman', 'Figura de ação do Batman com capa de tecido e articulações.', 'boneco-batman.jpg', 99.90, 20, 1);
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Luva Lança Teias', 'Luva interativa do Homem-Aranha que dispara discos.', 'luva-aranha.jpg', 68.90, 20, 1);

/* FIGURAS DE AÇÃO (Funko Pops) - Categoria 11 */
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Funko Pop Homem de Ferro', 'Figura colecionável Funko Pop do Homem de Ferro da Marvel, com aproximadamente 10cm de altura em vinil.', 'funko-ironman.jpg', 129.90, 11, 1);
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Funko Pop Darth Vader', 'Figura colecionável Funko Pop do Darth Vader (Star Wars), edição especial com base.', 'funko-darthvader.jpg', 149.90, 11, 1);

/* EDUCATIVOS - Categoria 3 */
INSERT INTO brinquedos (nome, descricao, imagem, preco, categoria_id, marca_id) VALUES ('Ábaco de Madeira Clássico', 'Ábaco tradicional de madeira com 10 fileiras de contas coloridas para aprender matemática básica de forma visual e divertida.', 'abaco-madeira.jpg', 59.90, 3, 2);


INSERT INTO usuarios (imagem, nome, email, senha, tipo) VALUES ('ana.jpg', 'Ana Souza', 'ana.souza@email.com', '123456', 'CLIENTE');

INSERT INTO usuarios (imagem, nome, email, senha, tipo) VALUES ('carlos.jpg', 'Carlos Mendes', 'carlos.mendes@email.com', '123456', 'CLIENTE');

INSERT INTO usuarios (imagem, nome, email, senha, tipo) VALUES ('mariana.jpg', 'Mariana Lima', 'mariana.lima@email.com', '123456', 'CLIENTE');

INSERT INTO usuarios (imagem, nome, email, senha, tipo) VALUES ('joao.jpg', 'João Pereira', 'joao.pereira@email.com', '123456', 'CLIENTE');

INSERT INTO usuarios (imagem, nome, email, senha, tipo) VALUES ('lucas.jpg', 'Lucas Martins', 'lucas.martins@email.com', '123456', 'CLIENTE');

INSERT INTO usuarios (imagem, nome, email, senha, tipo) VALUES ('fernanda.jpg', 'Fernanda Alves', 'fernanda.alves@email.com', '123456', 'CLIENTE');

INSERT INTO usuarios (imagem, nome, email, senha, tipo) VALUES ('admin.jpg', 'admin', 'admin@marah.com', 'admin', 'ADMIN');

INSERT INTO usuarios (imagem, nome, email, senha, tipo) VALUES ('patricia.jpg', 'Patricia Gomes', 'patricia.gomes@email.com', '123456', 'CLIENTE');

INSERT INTO usuarios (imagem, nome, email, senha, tipo) VALUES ('juliana.jpg', 'Juliana Rocha', 'juliana.rocha@email.com', '123456', 'CLIENTE');
