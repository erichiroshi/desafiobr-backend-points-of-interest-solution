package br.com.erichiroshi.desafio_backend_br_points_of_interest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.erichiroshi.desafio_backend_br_points_of_interest.dto.PointDTO;
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

	public List<Point> findAllProximo(int x, int y, int dmax) {

		List<Point> allBySquare = repository.findAllBySquare(x - dmax, x + dmax, y - dmax, y + dmax);

		return allBySquare.stream().filter(point -> distAB(point.getX(), point.getY(), x, y) <= dmax).toList();
	}

	private double distAB(int xA, int yA, int xB, int yB) {
		return Math.sqrt(Math.pow((double) xA - xB, 2) + Math.pow((double) yA - yB, 2));
	}

}
