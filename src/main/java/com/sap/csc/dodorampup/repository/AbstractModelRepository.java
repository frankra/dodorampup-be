package com.sap.csc.dodorampup.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import com.sap.csc.dodorampup.model.AbstractModel;

@NoRepositoryBean
public interface AbstractModelRepository<ID extends Serializable, T extends AbstractModel<ID>> extends
		BaseRepository<T, ID> {

		public List<T> findAll();
}
