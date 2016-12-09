package es.crimarde.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.crimarde.dao.ImageRepository;
import es.crimarde.helpers.impl.ImageTransformerHelper;
import es.crimarde.model.Imagen;
import es.crimarde.negocio.ImageDTO;
import es.crimarde.service.ImageService;

@Component
@Transactional
public class ImageServiceImpl implements ImageService {

	@Autowired ImageRepository repository;
	@Autowired ImageTransformerHelper transformer;
	
	@Override
	public Long saveImage(ImageDTO imagenDto) {
		Imagen imagen = transformer.dtoToEntity(imagenDto);
		imagen = repository.save(imagen);
		return imagen.getIdImagen();
	}

	@Override
	public byte[] loadImage(Long id) {
		ImageDTO imagenDTO = transformer.entityToDto(repository.findOne(id));
		return imagenDTO.getImagen();
	}


}
