import org.junit.Before;
import org.junit.Test;
import ratelimiter.EmployeeDataStore;
import ratelimiter.EmployeeSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeSearchTest {

	private EmployeeSearch employeeSearch;

	@Before
	public void before() {
		employeeSearch = new EmployeeSearch();

	}


	@Test
	public void testEmployeeForRecord() {
		List<EmployeeDataStore> employeeDataStoreList = new ArrayList<>();
		employeeDataStoreList.add(EmployeeDataStore.builder().id(1).importanceValue(5).connectedEmployees(Arrays.asList(2, 3)).build());
		employeeDataStoreList.add(EmployeeDataStore.builder().id(2).importanceValue(3).connectedEmployees(Arrays.asList()).build());
		employeeDataStoreList.add(EmployeeDataStore.builder().id(3).importanceValue(3).connectedEmployees(Arrays.asList()).build());

		employeeSearch.populateEmployeeDS(employeeDataStoreList);


		int result = employeeSearch.performSearch(1);
		System.out.println(result);
		assert result == 11;
	}

	@Test
	public void testEmployeeForRecord1() {
		List<EmployeeDataStore> employeeDataStoreList = new ArrayList<>();
		employeeDataStoreList.add(EmployeeDataStore.builder().id(1).importanceValue(5).connectedEmployees(Arrays.asList(2)).build());
		employeeDataStoreList.add(EmployeeDataStore.builder().id(2).importanceValue(3).connectedEmployees(Arrays.asList(3)).build());
		employeeDataStoreList.add(EmployeeDataStore.builder().id(3).importanceValue(3).connectedEmployees(Arrays.asList()).build());

		employeeSearch.populateEmployeeDS(employeeDataStoreList);


		int result = employeeSearch.performSearch(1);
		System.out.println(result);
		assert result == 11;
	}


	@Test
	public void testEmployeeForRecord3() {
		List<EmployeeDataStore> employeeDataStoreList = new ArrayList<>();
		employeeDataStoreList.add(EmployeeDataStore.builder().id(1).importanceValue(5).connectedEmployees(Arrays.asList(2)).build());
		employeeDataStoreList.add(EmployeeDataStore.builder().id(2).importanceValue(3).connectedEmployees(Arrays.asList(3)).build());
		employeeDataStoreList.add(EmployeeDataStore.builder().id(3).importanceValue(3).connectedEmployees(Arrays.asList()).build());

		employeeSearch.populateEmployeeDS(employeeDataStoreList);


		int result = employeeSearch.performSearch(1);
		System.out.println(result);
		assert result == 11;
	}

	@Test
	public void testEmployeeForRecord4() {
		List<EmployeeDataStore> employeeDataStoreList = new ArrayList<>();
		employeeDataStoreList.add(EmployeeDataStore.builder().id(1).importanceValue(5).connectedEmployees(Arrays.asList(2, 3)).build());
		employeeDataStoreList.add(EmployeeDataStore.builder().id(2).importanceValue(3).connectedEmployees(Arrays.asList(4)).build());
		employeeDataStoreList.add(EmployeeDataStore.builder().id(3).importanceValue(3).connectedEmployees(Arrays.asList(4)).build());
		employeeDataStoreList.add(EmployeeDataStore.builder().id(4).importanceValue(4).connectedEmployees(Arrays.asList(4)).build());

		employeeSearch.populateEmployeeDS(employeeDataStoreList);


		int result = employeeSearch.performSearch(1);
		System.out.println(result);
		assert result == 15;
	}


}
