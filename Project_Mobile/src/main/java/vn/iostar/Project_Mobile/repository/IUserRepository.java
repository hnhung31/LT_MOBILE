package vn.iostar.Project_Mobile.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iostar.Project_Mobile.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
	Optional<User> findByOtpCode(String otpCode);
	boolean existsByEmail(String email);
	Optional<User> findByUsername(String username);
	boolean existsByUsername(String username);
	boolean existsByPhone(String phone);
	
}
