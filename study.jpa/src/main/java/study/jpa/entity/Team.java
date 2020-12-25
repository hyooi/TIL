package study.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 *
 *
 * @author hyoin
 * @history
 *          2020. 12. 25. initial creation
 */
@Entity
@Data
public class Team {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	// member가 주인이라는 뜻. 외래키가 있는 곳을 주인으로 정할 것!
	// 복잡하므로 양방향보단 단방향을 먼저 사용하되, 필요할 때만 양방향 사용 권장
	@OneToMany(mappedBy = "team")
	private List<Member> members = new ArrayList<>();
}
