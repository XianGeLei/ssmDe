package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Dangan;
import com.mapper.DanganMapper;
@Service
public class DanganService{
	@Autowired
	DanganMapper danganMapper;
	
	public List<Dangan> list(String where){
		return danganMapper.list(where);
	}
	public List<Dangan> sealist(String where) {
		// TODO Auto-generated method stub
		return danganMapper.sealist(where);
	}
	public int total(String where) {
		return danganMapper.total(where);
	}

	public void insert(Dangan c) {
		danganMapper.insert(c);
		
	}
	public void update(Dangan c) {
		danganMapper.update(c);
	}


	public void delete(Dangan c) {
		danganMapper.delete(c.getId());
	}


	public Dangan get(int id) {
		// TODO Auto-generated method stub
		return danganMapper.get(id);
	}
public Dangan getsql(String where) {
		return danganMapper.getsql(where);
	}
   public void updatesql(String value) {
		danganMapper.updatesql(value);
	}
	public void deletesql(String value) {
		danganMapper.deletesql(value);
	}
}