package com.masai.Services;

import java.util.List;

import com.masai.Entities.Csr;

public interface GetCSRCreds {

	public List<Csr> getCSRUserPass();
	public Csr getCSRDetails(String userName , String passWord);

}
