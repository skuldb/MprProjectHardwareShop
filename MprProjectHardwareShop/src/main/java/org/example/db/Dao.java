package org.example.db;

import java.util.List;

public interface Dao<E extends EntityBase> {

	public void save(E ent);
	public void delete(E ent);
	public List<E> getAll();
	public E get(int id);
}
