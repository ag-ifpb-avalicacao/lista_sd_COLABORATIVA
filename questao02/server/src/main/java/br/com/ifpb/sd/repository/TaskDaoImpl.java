package br.com.ifpb.sd.repository;

import br.com.ifpb.sd.shared.TaskEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodrigobento
 */
public class TaskDaoImpl implements TaskDao {

    private Connection con;

    public TaskDaoImpl() {
        this.con = ConFactory.getConnection();
    }

    @Override
    public void insert(TaskEvent task) {
        String sql = "INSERT INTO task (groupName, eventName, createdIn) "
                + "VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, task.getGroupName());
            stmt.setString(2, task.getEventName());
            stmt.setLong(3, task.getCreatedIn());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public List<TaskEvent> listAll() {
        String sql = "SELECT * FROM task";
        List<TaskEvent> tasks = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                TaskEvent task = new TaskEvent();
                task.setGroupName(rs.getString("groupName"));
                task.setEventName(rs.getString("eventName"));
                task.setCreatedIn(rs.getLong("createdIn"));
                tasks.add(task);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tasks;
    }
    
    @Override
    public List<TaskEvent> listEvent(String eventName) {
        String sql = "SELECT * FROM task WHERE eventName = ?";
        List<TaskEvent> tasks = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, eventName);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                TaskEvent task = new TaskEvent();
                task.setGroupName(rs.getString("groupName"));
                task.setEventName(rs.getString("eventName"));
                task.setCreatedIn(rs.getLong("createdIn"));
                tasks.add(task);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tasks;
    }

    @Override
    public List<TaskEvent> listGroup(String groupName) {
        String sql = "SELECT * FROM task WHERE groupName = ?";
        List<TaskEvent> tasks = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, groupName);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                TaskEvent task = new TaskEvent();
                task.setGroupName(rs.getString("groupName"));
                task.setEventName(rs.getString("eventName"));
                task.setCreatedIn(rs.getLong("createdIn"));
                tasks.add(task);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tasks;
    }
    
}
