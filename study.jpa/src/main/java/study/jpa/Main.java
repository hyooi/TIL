package study.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import study.jpa.entity.Member;
import study.jpa.entity.Team;
import study.jpa.enums.MemberType;

/**
 *
 *
 * @author hyoin
 * @history
 *          2020. 12. 25. initial creation
 */
public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			Team team = new Team();
			team.setName("teamA");
			em.persist(team);

			Member member = new Member();
			member.setName("hello");
			member.setMemberType(MemberType.USER);
			em.persist(member);

			team.getMembers().add(member);
			member.setTeam(team); // 연관관계 주인에 값 설정

			em.flush(); // 영속성 컨텍스트의 변경 내용을 DB에 동기화
			em.clear(); // 영속성 컨텍스트를 비움

			Member findMember = em.find(Member.class, member.getId());
			findMember.setName("t아카데미");

//			em.clear(); 지연로딩은 영속 상태에서만 사용 가능하므로, 지연로딩으로 걸고 clear하게되면 LazyInitializationException발생하게 됨
			Team findTeam = findMember.getTeam();
			System.out.println("findTeam = " + findTeam.getName());

			String jpql = "Select m From Member m join fetch m.team where m.name Like '%hello%'";
			em.createQuery(jpql, Member.class)
			        .setFirstResult(10)
			        .setMaxResults(20)
			        .getResultList();

//			em.createQuery("Member.findByUsername", Member.class)
//			        .setParameter("name", "a")
//			        .getResultList();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}

		emf.close();
	}
}
