package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Health;
import com.mapper.HealthMapper;
@Service
public class HealthService{
	@Autowired
	HealthMapper healthMapper;
	
	public List<Health> list(String where){
		return healthMapper.list(where);
	}
	public List<Health> sealist(String where) {
		// TODO Auto-generated method stub
		return healthMapper.sealist(where);
	}

	public int total() {
		return healthMapper.total();
	}

	
	public void insert(Health c) {
		healthMapper.insert(c);
		
	}


	public void update(Health c) {
		healthMapper.update(c);
	}


	public void delete(Health c) {
		healthMapper.delete(c.getId());
	}


	public Health get(int id) {
		// TODO Auto-generated method stub
		return healthMapper.get(id);
	}

   public void updatesql(String value) {
		healthMapper.updatesql(value);
	}
	public void deletesql(String value) {
		healthMapper.deletesql(value);
	}
}