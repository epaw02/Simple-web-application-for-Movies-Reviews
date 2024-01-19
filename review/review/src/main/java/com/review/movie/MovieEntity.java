package com.review.movie;

import com.review.review.ReviewEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="movies")
public class MovieEntity implements Comparable<MovieEntity>, Serializable {

    @Id
    @Column(name = "id")
    private UUID id;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<ReviewEntity> reviews = new HashSet<>();

    @Override
    public String toString() {
        return "MovieEntity{" +
                "id=" + id +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieEntity that = (MovieEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public int compareTo(MovieEntity o) {
        return this.id.compareTo(o.id);
    }

    public void addReview(ReviewEntity review) {
        reviews.add(review);
    }
}
