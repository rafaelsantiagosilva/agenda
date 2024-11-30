package daos;

import java.util.List;

public interface DaoInterface<Model> {
  public void create(Model object);
  public List<Model> readAll();
  public Model readById(int id);
  public void update(Model object);
  public void delete(int id);
}
