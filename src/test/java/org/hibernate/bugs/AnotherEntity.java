package org.hibernate.bugs;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ANOTHER_ENTITY")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AnotherEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	Integer id;

	@JoinColumn(name = "MY_ENTITY_COL", foreignKey = @ForeignKey(name = "FK_AE_ME"), nullable = false)
	@ManyToOne
	@Fetch(FetchMode.JOIN)
	ParentEntity myEntity;
}