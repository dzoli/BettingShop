package kladionica.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCategory;

	private String name;

	//bi-directional many-to-one association to League
	@OneToMany(mappedBy="category")
	private List<League> leagues;

	public Category() {
	}

	public int getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<League> getLeagues() {
		return this.leagues;
	}

	public void setLeagues(List<League> leagues) {
		this.leagues = leagues;
	}

	public League addLeague(League league) {
		getLeagues().add(league);
		league.setCategory(this);

		return league;
	}

	public League removeLeague(League league) {
		getLeagues().remove(league);
		league.setCategory(null);

		return league;
	}

}