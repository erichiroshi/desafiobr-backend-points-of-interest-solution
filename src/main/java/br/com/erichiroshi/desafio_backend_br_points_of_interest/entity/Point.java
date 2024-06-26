package br.com.erichiroshi.desafio_backend_br_points_of_interest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_point")
public class Point {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int x;
	private int y;
	private String name;

	public Point(int x, int y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
	}

}
