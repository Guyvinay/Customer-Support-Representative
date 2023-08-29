package com.masai.DaoSer;

import java.util.List;

import com.masai.Entities.Csr;

public interface GetCSRCredsdDao {

	public List<Csr> getCSRUserPass();
	public Csr getCSRDetails(String userName , String passWord);
}
