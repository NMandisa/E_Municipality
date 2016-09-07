package za.co.emunicipality.repository;

import org.springframework.data.repository.CrudRepository;
import za.co.emunicipality.domain.User;

import java.util.List;

/**
 * Created by NMandisa Mkhungo on 7/28/2016.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    List<User> findAll();

    @Override
    User findOne(Long userId);

    User findByEmailAddress(String emailAddress);



}
