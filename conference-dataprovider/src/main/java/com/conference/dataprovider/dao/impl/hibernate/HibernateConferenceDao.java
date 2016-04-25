package com.conference.dataprovider.dao.impl.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.conference.core.domain.Conference;
import com.conference.core.domain.Stakeholder;
import com.conference.dataprovider.dao.IConferenceDao;

@Repository
public class HibernateConferenceDao extends BaseHibernateDao implements IConferenceDao {

	@Override
	public void createConference(Conference conference) {
		getSession().save(conference);
	}

	@Override
	public Conference readConference(String id) {
		return getSession().get(Conference.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Conference> readConferences() {
		return getSession().createCriteria(Conference.class)
				 .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				 .list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Conference> readConferences(int page, int pageSize) {
		return getSession()
				.createCriteria(Conference.class)
				.setFirstResult((page - 1) * pageSize )
				.setMaxResults(pageSize)
				.list();
	}

	@Override
	public void updateConference(Conference conference) {
		getSession().update(conference);
	}

	@Override
	public void deleteConference(Conference conference) {
		getSession().delete(conference);
	}

	@Override
	public void deleteConferenceById(String id) {
		Conference conference = readConference(id);
		for(Stakeholder stakeholder: conference.getStakeholders()) {
			getSession().delete(stakeholder);
		}
		deleteConference(conference);
	}

}
