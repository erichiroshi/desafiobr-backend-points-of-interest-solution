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
}
