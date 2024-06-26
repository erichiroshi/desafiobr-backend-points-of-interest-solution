package br.com.erichiroshi.desafio_backend_br_points_of_interest.dto;

import br.com.erichiroshi.desafio_backend_br_points_of_interest.entity.Point;

public record PointDTO(

		int x, int y, String name) {

	public Point toPoint() {
		return new Point(x, y, name);
	}

}
