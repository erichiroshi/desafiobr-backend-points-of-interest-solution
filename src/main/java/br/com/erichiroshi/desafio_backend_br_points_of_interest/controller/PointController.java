package br.com.erichiroshi.desafio_backend_br_points_of_interest.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.erichiroshi.desafio_backend_br_points_of_interest.dto.PointDTO;
import br.com.erichiroshi.desafio_backend_br_points_of_interest.dto.PointName;
import br.com.erichiroshi.desafio_backend_br_points_of_interest.entity.Point;
import br.com.erichiroshi.desafio_backend_br_points_of_interest.service.PointService;

@RestController
@RequestMapping("/points")
public class PointController {

	private PointService service;

	public PointController(PointService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<PointDTO> insert(@RequestBody PointDTO dto) {
		Point point = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(point.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@GetMapping
	public ResponseEntity<List<PointDTO>> findAll() {
		List<Point> list = service.findAll();
		List<PointDTO> listDTO = list.stream().map(x -> new PointDTO(x.getX(), x.getY(), x.getName())).toList();
		return ResponseEntity.ok(listDTO);
	}

	@GetMapping("/near-me")
	public ResponseEntity<List<PointName>> findByRef(@RequestParam("x") int x,
													@RequestParam("y") int y,
													@RequestParam("dmax") int dmax) {
		
		List<Point> list = service.findAllProximo(x, y, dmax);
		List<PointName> listDTO = list.stream().map(point -> new PointName(point.getName())).toList();
		return ResponseEntity.ok(listDTO);
	}
}
