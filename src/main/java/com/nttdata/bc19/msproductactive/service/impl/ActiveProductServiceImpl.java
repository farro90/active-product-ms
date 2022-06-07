package com.nttdata.bc19.msproductactive.service.impl;

import com.nttdata.bc19.msproductactive.model.ActiveProduct;
import com.nttdata.bc19.msproductactive.repository.IActiveProductRepository;
import com.nttdata.bc19.msproductactive.service.IActiveProductService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class ActiveProductServiceImpl implements IActiveProductService {
    @Autowired
    IActiveProductRepository activeProductRepository;

    @Override
    public Mono<ActiveProduct> create(ActiveProduct activeProduct) {

        activeProduct.setId(new ObjectId().toString());
        activeProduct.setCreatedAt(LocalDateTime.now());
        return activeProductRepository.save(activeProduct);
    }

    @Override
    public Mono<ActiveProduct> update(ActiveProduct activeProduct) {

        activeProduct.setUpdatedAt(LocalDateTime.now());
        return activeProductRepository.save(activeProduct);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return activeProductRepository.deleteById(id);
    }

    @Override
    public Mono<ActiveProduct> findById(String id) {
        return activeProductRepository.findById(id);
    }

    @Override
    public Flux<ActiveProduct> findAll() {
        return activeProductRepository.findAll();
    }
}
