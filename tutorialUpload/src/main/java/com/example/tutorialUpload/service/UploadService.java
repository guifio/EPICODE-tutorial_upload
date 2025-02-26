package com.example.tutorialUpload.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.tutorialUpload.model.entities.Utente;
import com.example.tutorialUpload.model.payload.UtenteDTO;
import com.example.tutorialUpload.repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@Transactional
public class UploadService {

    @Autowired
    private Cloudinary cloudinary;  // oggetto di configurazione con tutti i dati di servizio cloud

    @Autowired
    UtenteRepository repo;

    public String upload(MultipartFile file , UtenteDTO userDto) throws IOException {

        Map result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());

        // Recuperare la stringa URL che ritorna Cloudinary
        String urlFile = (String) result.get("url");

        // Setto l'url recuperata nell'oggetto che invierò al database
        Utente user = new Utente();
        user.setAvatarProfilo(urlFile);
        user.setNome(userDto.getNome());
        user.setCognome(userDto.getCognome());

        // Invio l'oggetto entity Utente verso il database
        repo.save(user);

        return "Upload completato : " +urlFile;
    }



}
