package br.com.erichiroshi.desafio_backend_br_points_of_interest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.erichiroshi.desafio_backend_br_points_of_interest.dto.PointDTO;
import br.com.erichiroshi.desafio_backend_br_points_of_interest.dto.PointRef;
import br.com.erichiroshi.desafio_backend_br_points_of_interest.entity.Point;
import br.com.erichiroshi.desafio_backend_br_points_of_interest.repository.PointRepository;

@Service
public class PointService {

	private PointRepository repository;

	public PointService(PointRepository repository) {
		this.repository = repository;
	}

	public Point insert(PointDTO dto) {
		return repository.save(dto.toPoint());
	}

	public List<Point> findAll() {
		return repository.findAll();
	}

	public List<Point> findAllProximo(PointRef pointRef) {
		List<Point> all = findAll();
		List<Point> listAllProximo = new ArrayList<>();

		for (Point point : all) {
			int andaX = point.getX() - pointRef.x();
			int andaY = point.getY() - pointRef.y();
			if (andaX < 0)
				andaX *= -1;
			if (andaY < 0)
				andaY *= -1;

			if (pointRef.dist() >= (andaX + andaY))
				listAllProximo.add(point);
		}

		return listAllProximo;
	}
}
