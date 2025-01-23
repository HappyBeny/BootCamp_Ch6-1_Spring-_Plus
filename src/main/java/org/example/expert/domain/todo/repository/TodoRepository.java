package org.example.expert.domain.todo.repository;

import java.time.LocalDateTime;
import org.example.expert.domain.todo.dto.request.GetTodoRequest;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoRepositoryCustom {

    @Query("""
        SELECT t FROM Todo t
        LEFT JOIN FETCH t.user u
        WHERE (:weather IS NULL OR t.weather = :weather)
        AND (:updatedAtStart IS NULL OR t.modifiedAt >= :updatedAtStart)
        AND (:updatedAtEnd IS NULL OR t.modifiedAt <= :updatedAtEnd)
        ORDER BY t.modifiedAt DESC
        """)
    Page<Todo> findAllByOrderByModifiedAtDesc(
        Pageable pageable,
        @Param("weather") String weather,
        @Param("updatedAtStart")LocalDateTime updatedAtStart,
        @Param("updatedAtEnd") LocalDateTime updatedAtEnd
    );

    @Query("""
            SELECT t FROM Todo t
            LEFT JOIN t.user
            WHERE t.id = :todoId
            """)
    Optional<Todo> findByIdWithUser(@Param("todoId") Long todoId);
}
