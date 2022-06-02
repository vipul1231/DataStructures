package ratelimiter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@Setter
public class EmployeeDataStore {

	int id;

	int importanceValue;

	List<Integer> connectedEmployees = new ArrayList<>();


	private boolean isVisited;
}
