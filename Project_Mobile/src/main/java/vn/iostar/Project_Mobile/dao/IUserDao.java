package vn.iostar.Project_Mobile.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iostar.Project_Mobile.entity.User;

@Repository
public interface IUserDao extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
	Optional<User> findByOtpCode(String otpCode);
}
