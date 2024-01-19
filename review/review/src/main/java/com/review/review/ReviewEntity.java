package com.review.review;
import com.review.movie.MovieEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="reviews")
public class ReviewEntity implements Comparable<ReviewEntity>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id")
    private UUID id;

    @Column(name="username")
    private String username;

    @Column(name="publication_date")
    private LocalDateTime publicationDate;

    @ManyToOne(optional = false)
    @JoinColumn(name="movie_id")
    private MovieEntity movie;

    @Column(name = "comment")
    private String comment;

    @Enumerated(EnumType.STRING)
    @Column(name="rating")
    private Rating rating;

    @Override
    public String toString() {
        return "ReviewEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", publicationDate=" + publicationDate +
                ", movie=" + movie.getId() +
                ", comment='" + comment + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewEntity that = (ReviewEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }

    @Override
    public int compareTo(ReviewEntity o) {
        return this.username.compareTo(o.username);
    }
}