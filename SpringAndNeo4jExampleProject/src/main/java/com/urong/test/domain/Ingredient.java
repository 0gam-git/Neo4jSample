package com.urong.test.domain;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Ingredient {

	private Long id;
	private String name;

	@Relationship(type = "HAS_CATEGORY", direction = "OUTGOING")
	private Category category;

	@Relationship(type = "PAIRS_WITH", direction = "UNDIRECTED")
	private Set<Pairing> pairings = new HashSet<Pairing>();

	public Ingredient() {
	}

	public Ingredient(Long id, String name, Category category, Set<Pairing> pairings) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.pairings = pairings;
	}

	public Ingredient(String name) {
		this.name = name;
	}

	public void addPairing(Pairing pairing) {
		pairing.getFirst().getPairings().add(pairing);
		pairing.getSecond().getPairings().add(pairing);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Pairing> getPairings() {
		return pairings;
	}

	public void setPairings(Set<Pairing> pairings) {
		this.pairings = pairings;
	}

}
