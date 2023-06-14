package com.masai.Services;

import com.masai.DaoSer.CSRDao;
import com.masai.DaoSer.CSRDaoImple;
import com.masai.Entities.Csr;

public class CSRServicesImple implements CSRServices{

	@Override
	public void addNewCSR(Csr csr) {
		
		CSRDao csrDao = new CSRDaoImple();
		
		csrDao.addNewCSR(csr);
		
	}

}
