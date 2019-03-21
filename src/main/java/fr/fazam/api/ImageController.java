package fr.fazam.api;



import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


import javax.xml.bind.DatatypeConverter;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import fr.fazam.dto.FileDto;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/upload")
public class ImageController {

	@PostMapping()
	public void pictureupload(@RequestBody FileDto data) {
		System.out.println(data);
		String[] strings = data.toString().split(",");
	        String extension;
	        switch (strings[0]) {//check image's extension
	            case "data:image/jpeg;base64":
	                extension = "jpeg";
	                break;
	            case "data:image/png;base64":
	                extension = "png";
	                break;
	            default://should write cases for more images types
	                extension = "jpg";
	                break;
	        }
	        //convert base64 string to binary data
	        byte[] data1 = DatatypeConverter.parseBase64Binary(strings[1]);
	        String path = "C:\\Users\\Dell\\Desktop\\test_image." + extension;
	        File file = new File(path);
	        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
	            outputStream.write(data1);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
}