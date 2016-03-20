package info.penguincat.inject.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import info.penguincat.inject.domain.Domain;
import info.penguincat.inject.repository.DomainRepository;

/**
 * Created by @penguin_410 on 2016/03/14.
 */
@Singleton
public class DomainSearchServiceImpl implements DomainSearchService {
    private final DomainRepository repository;

    @Inject
    private DomainSearchServiceImpl(DomainRepository repository) {
        this.repository = repository;
    }

    @Override
    public Domain search(int id) {
        return this.repository.find(id);
    }
}
