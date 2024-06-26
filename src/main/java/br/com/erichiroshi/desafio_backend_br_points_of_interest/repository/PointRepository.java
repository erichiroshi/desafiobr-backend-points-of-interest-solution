package br.com.erichiroshi.desafio_backend_br_points_of_interest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.erichiroshi.desafio_backend_br_points_of_interest.entity.Point;

public interface PointRepository extends JpaRepository<Point, Long> {

	@Query("""
			SELECT p FROM Point p
			WHERE (p.x >= :minX and p.x <= :maxX and p.y >= :minY and p.y <= :maxY)
			""")
	List<Point> findAllBySquare(@Param("minX") int minX,
								@Param("maxX") int maxX,
								@Param("minY") int minY, 
								@Param("maxY") int maxY);

}
