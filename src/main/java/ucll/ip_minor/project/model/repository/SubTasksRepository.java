package ucll.ip_minor.project.model.repository;

import org.springframework.stereotype.Repository;
import ucll.ip_minor.project.model.entity.SubTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SubTasksRepository {
    private Map<Integer,ArrayList<SubTask>> map = new HashMap<>();

    public void addSubTask(SubTask subTask){
        map.putIfAbsent(subTask.getParent().getId(),new ArrayList<>());
        map.get(subTask.getParent().getId()).add(subTask);
    }

    public List<SubTask> getSubTasksOfParent(int parentId){
        return map.get(parentId);
    }
}
