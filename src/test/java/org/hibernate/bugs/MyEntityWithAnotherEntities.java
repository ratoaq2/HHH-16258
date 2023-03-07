package org.hibernate.bugs;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("1")
public class MyEntityWithAnotherEntities extends ParentEntity {
	@OneToMany(mappedBy = "myEntity")
	@Fetch(FetchMode.SUBSELECT)
	List<AnotherEntity> anotherEntities = new ArrayList<>();
}