package br.com.erichiroshi.desafio_backend_br_points_of_interest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erichiroshi.desafio_backend_br_points_of_interest.entity.Point;

public interface PointRepository extends JpaRepository<Point, Long> {

}
