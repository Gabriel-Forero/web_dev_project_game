package com.javeriana.Game.repository;
import com.javeriana.Game.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user where user_document = ?1 ", nativeQuery = true)
    User findByDocument(String document);
   
}
