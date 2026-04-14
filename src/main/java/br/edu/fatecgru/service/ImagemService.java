package br.edu.fatecgru.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagemService {

	// salvar imagem
	public String salvarImagem(MultipartFile imagem, String pasta) throws Exception {
		if (imagem == null || imagem.isEmpty())
			return null;

		String caminhoPasta = System.getProperty("user.dir") + "/uploads/" + pasta;

		File diretorio = new File(caminhoPasta);
		if (!diretorio.exists()) {
			diretorio.mkdirs();
		}

		String nomeArquivo = System.currentTimeMillis() + "_" + imagem.getOriginalFilename();
		Path caminho = Paths.get(caminhoPasta + nomeArquivo);

		Files.write(caminho, imagem.getBytes());

		return nomeArquivo;
	}

	// deletar imagem
	public void deletarImagem(String nomeImagem, String pasta) {
		if (nomeImagem == null || nomeImagem.isEmpty())
			return;

		try {
			String caminhoPasta = System.getProperty("user.dir") + "/uploads/" + pasta;

			Path caminho = Paths.get(caminhoPasta + nomeImagem);

			Files.deleteIfExists(caminho);
		} catch (Exception e) {
			System.out.println("Erro ao deletar imagem: " + e.getMessage());
		}
	}

	// substituir imagem
	public String substituirImagem(String antiga, MultipartFile nova, String pasta) throws Exception {
		if (nova == null || nova.isEmpty())
			return antiga;

		String novaImagem = salvarImagem(nova, pasta);

		try {
			deletarImagem(antiga, pasta);
		} catch (Exception e) {
			System.out.println("Erro ao deletar imagem antiga: " + e.getMessage());
		}

		return novaImagem;
	}
}