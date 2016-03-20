package info.penguincat.inject.service;

import com.google.inject.ImplementedBy;
import info.penguincat.inject.domain.Domain;

/**
 * Created by @penguin_410 on 2016/03/14.
 */
public interface DomainCreateService {
    Domain create(int id, String name);
}
