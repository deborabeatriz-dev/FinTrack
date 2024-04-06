package br.fintrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fintrack.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Short> {
}