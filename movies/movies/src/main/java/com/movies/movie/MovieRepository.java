package com.movies.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
interface MovieRepository extends JpaRepository<MovieEntity, UUID> {
    Optional<MovieEntity> findByTitle(String title);
}
