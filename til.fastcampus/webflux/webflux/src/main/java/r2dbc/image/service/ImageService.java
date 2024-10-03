package r2dbc.image.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import springreactive.springwebflux.image.common.Image;
import springreactive.springwebflux.image.repository.ImageReactorRepository;

@Service
public class ImageService {
    private ImageReactorRepository imageReactorRepository = new ImageReactorRepository();

    public Mono<Image> getImageById(String id) {
        return imageReactorRepository.findById(id)
                .map(imageEntity -> new Image(imageEntity.getId(), imageEntity.getName(), imageEntity.getUrl()));
    }
}
