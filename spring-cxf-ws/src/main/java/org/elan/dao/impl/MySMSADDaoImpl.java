package org.elan.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.elan.dao.MySMSADDao;
import org.elan.entity.MySMSAD;
import org.elan.ws.exception.SMSADNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class MySMSADDaoImpl implements MySMSADDao {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public MySMSAD deleteAd(String adCode) throws SMSADNotFoundException {

		MySMSAD result = ViewByAdCode(adCode);
		if (result != null) {

			manager.remove(result);
			return result;
		} else {
			throw new SMSADNotFoundException("adCode Not Found");
		}
	}

	@Override
	public MySMSAD updateAd(MySMSAD mySmsAD) throws SMSADNotFoundException {

		MySMSAD results = ViewByAdCode(mySmsAD.getAdCode());

		if (results != null) {
			results.setAdDetails(mySmsAD.getAdDetails());
			manager.merge(results);
			return results;
		} else {
			throw new SMSADNotFoundException("adCode Not Found");
		}

	}

	@Override
	public MySMSAD ViewByAdCode(String adCode) throws SMSADNotFoundException {
		/*CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery cq = cb.createQuery();
		Root e = cq.from(MySMSAD.class);
		ParameterExpression<String> p = cb.parameter(String.class);
		cq.select(e).where(cb.gt(c.get("population"), p));
		
		cq.where(cb.equal(e.get("adCode"), adCode));
		Query query = manager.createQuery(cq);
		List<MySMSAD> result = query.getResultList();*/

		/* CriteriaQuery<Country> q = cb.createQuery(Country.class);  
		 Root<Country> c = q.from(Country.class);  
		 q.select(c);  
		 ParameterExpression<Integer> p = cb.parameter(Integer.class); 
		 q.where(cb.gt(c.get("population"), p));
		*/
		 CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<MySMSAD> cq = cb.createQuery(MySMSAD.class);
			Root<MySMSAD> c = cq.from(MySMSAD.class);
			ParameterExpression<String> p = cb.parameter(String.class);
			cq.select(c).where(cb.equal(c.get("adCode"), p));
			
			TypedQuery<MySMSAD> query = manager.createQuery(cq); 
			query.setParameter(p, adCode);  
			List<MySMSAD> result = query.getResultList();
		
		
		if (result != null && !(result.isEmpty())) {

			MySMSAD mySmsAd = result.get(0);
			System.out.println("View By ADCode"+mySmsAd.getId());
			return mySmsAd;
		} else {
			throw new SMSADNotFoundException("adCode Not Found");
		}
	}

	@Override
	public List<MySMSAD> ViewAll() {
		List<MySMSAD> mySmsAdList = manager.createQuery("Select a From MySMSAD a", MySMSAD.class).getResultList();
		return mySmsAdList;
	}

	@Override
	public MySMSAD createAd(MySMSAD mySmsAD) {
		manager.persist(mySmsAD);

		return mySmsAD;
	}

}

/*
 * @Autowired private SessionFactory sessionFactory;
 * 
 * public SessionFactory getSessionFactory() { return sessionFactory; }
 * 
 * public void setSessionFactory(SessionFactory sessionFactory) {
 * 
 * this.sessionFactory = sessionFactory; }
 * 
 * @Transactional
 * 
 * @Override public MySMSAD createAd(MySMSAD mySmsAD) {
 * 
 * sessionFactory.getCurrentSession().save(mySmsAD);
 * 
 * return mySmsAD;
 * 
 * }
 * 
 * @Transactional
 * 
 * @Override public MySMSAD deleteAd(String adCode) throws
 * SMSADNotFoundException { Session session =
 * sessionFactory.getCurrentSession(); Criteria cr =
 * session.createCriteria(MySMSAD.class);
 * cr.add(Restrictions.eq("adCode",adCode)); List<MySMSAD> results = cr.list();
 * System.out.println("View By adcode"+adCode); if (results != null &&
 * !(results.isEmpty())) {
 * 
 * MySMSAD mySmsAD = results.get(0); System.out.println("View By adcode"
 * +adCode); sessionFactory.getCurrentSession().delete(mySmsAD); return mySmsAD;
 * } else { throw new SMSADNotFoundException("adCode Not Found"); } }
 * 
 * @Transactional
 * 
 * @Override public MySMSAD ViewByAdCode(String adCode) throws
 * SMSADNotFoundException {
 * 
 * System.out.println("View By adcode"+adCode); Criteria cr =
 * sessionFactory.getCurrentSession().createCriteria(MySMSAD.class);
 * System.out.println("View By adcode"+adCode); cr.add(Restrictions.eq("adCode",
 * adCode)); List<MySMSAD> results = cr.list(); System.out.println(
 * "View By adcode"+adCode);
 * 
 * if (results != null && !(results.isEmpty())) {
 * 
 * MySMSAD mySmsAd = results.get(0); return mySmsAd; } else { throw new
 * SMSADNotFoundException("ADCode Not Found"); } }
 * 
 * @Transactional
 * 
 * @Override public MySMSAD updateAd(MySMSAD mySmsAD) throws
 * SMSADNotFoundException { System.out.println("View By adcode1"); Session
 * session = sessionFactory.getCurrentSession(); System.out.println(
 * "View By adcode2"); Criteria cr = session.createCriteria(MySMSAD.class);
 * System.out.println("View By adcode3"); cr.add(Restrictions.eq("adCode",
 * mySmsAD.getAdCode())); System.out.println("View By adcode4"); List<MySMSAD>
 * results = cr.list(); if (results != null && !(results.isEmpty())) { MySMSAD
 * mySmsADReturn = results.get(0); System.out.println("View By adcode5");
 * mySmsADReturn.setAdDetails(mySmsAD.getAdDetails()); System.out.println(
 * "View By adcode"); session.update(mySmsADReturn); return mySmsADReturn; }
 * else { throw new SMSADNotFoundException("adCode Not Found"); }
 * 
 * }
 * 
 * 
 * @Transactional
 * 
 * @SuppressWarnings("unchecked")
 * 
 * @Override public List<MySMSAD> ViewAll() {
 * 
 * List<MySMSAD> mySmsAdList =
 * sessionFactory.getCurrentSession().createCriteria(MySMSAD.class).list();
 * 
 * return mySmsAdList;
 * 
 * }
 * 
 * }
 */