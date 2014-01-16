package org.example.db;

public abstract class EntityBase {
	
	protected int id;

	protected EntityOperation operation = EntityOperation.none;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EntityOperation getOperation() {
		return operation;
	}

	public void setOperation(EntityOperation operation) {
		this.operation = operation;
	}
	
}
