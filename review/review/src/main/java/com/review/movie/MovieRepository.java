package com.review.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface MovieRepository extends JpaRepository<MovieEntity, UUID> {

}
