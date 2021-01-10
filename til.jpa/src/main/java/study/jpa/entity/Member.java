package study.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Data;
import study.jpa.enums.MemberType;

/**
 *
 *
 * @author hyoin
 * @history
 *          2020. 12. 25. initial creation
 */
@Entity
@Data
@NamedQuery(name = "Member.findByUsername",
        query = "select m from Member m where m.name = :name")
public class Member {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "USERNAME", length = 20)
	private String name;
	private int age;

	@ManyToOne(fetch = FetchType.LAZY) // LAZY이용 시 실제로 team객체 사용할 때 select함(지연로딩)
	@JoinColumn(name = "TEAM_ID")
	private Team team;

	@Enumerated(EnumType.STRING)
	private MemberType memberType;

	@Lob
	private String data;

	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;

	@Transient
	private String temp;

}
