package info.penguincat.inject.repository;

import com.google.inject.Singleton;
import info.penguincat.inject.domain.Domain;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by @penguin_410 on 2016/03/14.
 */
@Singleton
public class SimpleListDomainRepository implements DomainRepository {
    private final List<Domain> domains = new CopyOnWriteArrayList<>();

    @Override
    public Domain find(int id) {
        return domains.stream().filter(domain -> domain.getId() == id).findFirst().get();
    }

    @Override
    public List<Domain> findAll() {
        return Collections.unmodifiableList(this.domains);
    }

    @Override
    public Domain save(Domain domain) {
        this.domains.add(domain);
        return domain;
    }

    @Override
    public Domain delete(int id) {
        Domain domain = this.domains.stream().filter(d -> d.getId() == id).findFirst().get();
        if (domain != null) {
            this.domains.remove(domain);
            return domain;
        } else {
            return null;
        }
    }
}
