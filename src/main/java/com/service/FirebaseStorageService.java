
package com.service;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author STIF
 */
public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

  
    final String BucketName = "ssssssss.appspot.com";

    
    final String rutaSuperiorStorage = "Prueba_01";

    
    final String rutaJsonFile = "firebase";
    
   
    final String archivoJsonFile = "ssssssss-firebase-adminsdk-xrekh-43d35247d0.json";
}