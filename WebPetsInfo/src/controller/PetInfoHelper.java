package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.PetInfo;

public class PetInfoHelper 
{
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebPetsInfo");
	
	public void cleanUp(){
		emfactory.close();
	}
	
	public void insertItem(PetInfo pe)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(pe);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public void deleteItem(PetInfo toDelete) 
	{
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetInfo> typedQuery = em.createQuery("select pe from PetInfo pe where pe.type = :selectedType and pe.name = :selectedName and pe.owner = :selectedOwner", PetInfo.class);
		typedQuery.setParameter("selectedType", toDelete.getType());
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedOwner", toDelete.getOwner());
		typedQuery.setMaxResults(1);
		PetInfo result = typedQuery.getSingleResult();
		em.remove(result);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<PetInfo> searchForPetByName(String name) 
	{
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetInfo> typedQuery = em.createQuery("select pe from PetInfo pe where pe.name = :selectedName", PetInfo.class);
		typedQuery.setParameter("selectedName", name);

		List<PetInfo> foundPets = typedQuery.getResultList();
		em.close();
		return foundPets;
	}

	public List<PetInfo> searchForPetByType(String type) 
	{
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetInfo> typedQuery = em.createQuery("select pe from PetInfo pe where pe.type = :selectedType", PetInfo.class);
		typedQuery.setParameter("selectedType", type);

		List<PetInfo> foundPets = typedQuery.getResultList();
		em.close();
		return foundPets;
	}
	
	public List<PetInfo> searchForPetByOwner(String owner) 
	{
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetInfo> typedQuery = em.createQuery("select pe from PetInfo pe where pe.owner = :selectedOwner", PetInfo.class);
		typedQuery.setParameter("selectedOwner", owner);

		List<PetInfo> foundPets = typedQuery.getResultList();
		em.close();
		return foundPets;
	}
	
	public PetInfo searchForItemById(int id)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		PetInfo found = em.find(PetInfo.class, id);
		em.close();
		return found;
	}

	public List<PetInfo> showAllItems()
	{
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<PetInfo> typedQuery = em.createQuery("select pe from PetInfo pe", PetInfo.class);
		List<PetInfo> allPets = typedQuery.getResultList();
		em.close();
		return allPets;
	}

	public void updateItem(PetInfo toEdit) 
	{
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}