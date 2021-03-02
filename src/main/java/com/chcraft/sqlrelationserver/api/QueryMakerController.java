package com.chcraft.sqlrelationserver.api;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chcraft.sqlrelation.EntityRelationshipModel;
import com.chcraft.sqlrelation.entity.Entity;
import com.chcraft.sqlrelation.query.QueryMaker;
import com.chcraft.sqlrelation.relation.Relation;

@RestController
@RequestMapping("querymaker")
public class QueryMakerController {

	@PostMapping("model")
	public String createQuery(@RequestBody EntityRelationshipModel erm) {
		String query = QueryMaker.createQuery(erm);

		return query;
	}

	@PostMapping("entities")
	public String createEntityQuery(@RequestBody List<Entity> entities) {
		StringBuilder query = new StringBuilder();

		for(Entity entity : entities) {
			query.append(QueryMaker.createQuery(entity));
			query.append("\n");
		}

		return query.toString();
	}

	@PostMapping("relations")
	public String createRelationQuery(@RequestBody List<Relation> relations) {
		StringBuilder query = new StringBuilder();

		for(Relation relation : relations) {
			query.append(QueryMaker.createQuery(relation));
			query.append("\n");
		}
		return query.toString();
	}

}
