package info.penguincat.inject.repository;

import info.penguincat.inject.domain.Domain;

import java.util.List;

/**
 * Created by @penguin_410 on 2016/03/14.
 */
public interface DomainRepository {
    Domain find(int id);

    List<Domain> findAll();

    Domain save(Domain domain);

    Domain delete(int id);
}
