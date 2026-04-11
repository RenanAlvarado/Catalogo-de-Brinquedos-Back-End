package br.edu.fatecgru.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagemService {

	private final String PASTA = System.getProperty("user.dir") + "/uploads/toys/";

	// salvar imagem
	public String salvarImagem(MultipartFile imagem) throws Exception {
		if (imagem == null || imagem.isEmpty())
			return null;

		File diretorio = new File(PASTA);
		if (!diretorio.exists()) {
			diretorio.mkdirs();
		}

		String nomeArquivo = System.currentTimeMillis() + "_" + imagem.getOriginalFilename();
		Path caminho = Paths.get(PASTA + nomeArquivo);

		Files.write(caminho, imagem.getBytes());

		return nomeArquivo;
	}

	// deletar imagem
	public void deletarImagem(String nomeImagem) {
		if (nomeImagem == null || nomeImagem.isEmpty())
			return;

		try {
			Files.deleteIfExists(Paths.get(PASTA + nomeImagem));
		} catch (Exception e) {
			System.out.println("Erro ao deletar imagem: " + e.getMessage());
		}
	}

	// substituir imagem
	public String substituirImagem(String antiga, MultipartFile nova) throws Exception {
		if (nova == null || nova.isEmpty())
			return antiga;

		String novaImagem = salvarImagem(nova);

		deletarImagem(antiga);

		return novaImagem;
	}
}