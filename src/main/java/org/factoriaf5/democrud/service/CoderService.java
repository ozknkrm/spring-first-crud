package org.factoriaf5.democrud.service;

import org.factoriaf5.democrud.model.Coder;
import org.factoriaf5.democrud.payload.request.CoderRequest;
import org.factoriaf5.democrud.payload.response.CoderResponse;
import org.factoriaf5.democrud.repository.CoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CoderService {
    private final CoderRepository coderRepository;

    @Autowired
    public CoderService(CoderRepository coderRepository) {
        this.coderRepository = coderRepository;
    }

    public List<Coder> findAll() {
        return coderRepository.findAll();
    }

    public Coder findById(Long id) {
        return coderRepository.findById(id).get();
    }

    public Long delete(Long id) {
        if (coderRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Coder not found");
        }
        coderRepository.deleteById(id);
        return id;
    }

    public Coder update(Coder coder) {
        if (coderRepository.findById(coder.getId()).isEmpty()) {
            throw new RuntimeException("Coder not found");
        }
        return coderRepository.save(coder);
    }
    public CoderResponse create(CoderRequest coderRequest){
        if(coderRequest.getAge() >= 18 ) {
            Coder mewCoder = Coder
                    .builder()
                    .name(coderRequest.getName())
                    .email(coderRequest.getEmail())
                    .age(coderRequest.getAge())
                    .role("admin")
                    .build();
        Coder coder = coderRepository.save(mewCoder);
            Set<String> courses = new HashSet<>();
            courses.add("js");
            courses.add("java");
            courses.add("Springboot");
            return CoderResponse.builder().coder(coder).courses(courses).build();
        }
        return null;
    }
}
