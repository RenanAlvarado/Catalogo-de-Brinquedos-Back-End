package br.edu.fatecgru.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class ImagemService {

	@Autowired
	private Cloudinary cloudinary;

	public String salvarImagem(MultipartFile imagem) throws Exception {
		if (imagem == null || imagem.isEmpty())
			return null;

		Map upload = cloudinary.uploader().upload(imagem.getBytes(), ObjectUtils.emptyMap());

		return upload.get("secure_url").toString();
	}

	public void deletarImagem(String url) {
		try {
			String publicId = extrairPublicId(url);
			cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
		} catch (Exception e) {
			System.out.println("Erro ao deletar imagem: " + e.getMessage());
		}
	}

	public String substituirImagem(String antiga, MultipartFile nova) throws Exception {
		if (nova == null || nova.isEmpty())
			return antiga;

		String novaUrl = salvarImagem(nova);
		deletarImagem(antiga);

		return novaUrl;
	}

	private String extrairPublicId(String url) {
		String[] partes = url.split("/");
		String nomeArquivo = partes[partes.length - 1];
		return nomeArquivo.split("\\.")[0];
	}
}