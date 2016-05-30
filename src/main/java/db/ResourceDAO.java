package db;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import model.LeaveRequest;
import model.Resource;

public class ResourceDAO extends SalesforceDAO<Resource> {

	private static final int WEEK_SPAN = 6;
	public static final Class<Resource> DAOTABLE = Resource.class;
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd");

	public Resource retrieveResource(String id) {
		connect();

		List<Resource> result = retrieve(
				String.format("SELECT id,Name,IDNumber__c,FirstName__c,"
						+ "LastName__c,MiddleName__c,SickLeaveEntitlement__c,"
						+ "SickLeavesUsed__c,VacationLeavesUsed__c,VacationLeaveEntitlement__c,"
						+ "ImmediateManagerName__c, ImmediateManagerEmail__c,"
						+ "(SELECT Name, LeaveType__c,StartDate__c,EndDate__c,DaysOnLeave__c,Reason__c,Halfday__c,LeaveStatus__c,"
						+ "CreatedDate FROM LeaveRequest__r ORDER BY CreatedDate DESC)"
						+ " FROM Resource__c WHERE Id = '%s'", id),
				DAOTABLE);

		if (!result.isEmpty()) {
			return result.get(0);
		}

		return null;
	}

	public Resource retrieveResourceApprovalDetails(String id,
			LeaveRequest leave) {
		connect();

		Calendar calendar = GregorianCalendar.getInstance();
		try {

			calendar.setTime(DATE_FORMAT.parse(leave.getStartDate()));
			calendar.add(Calendar.WEEK_OF_YEAR, -WEEK_SPAN / 2);
			String startDate = DATE_FORMAT.format(calendar.getTime());

			calendar.setTime(DATE_FORMAT.parse(leave.getEndDate()));
			calendar.add(Calendar.WEEK_OF_YEAR, WEEK_SPAN / 2);

			String endDate = DATE_FORMAT.format(calendar.getTime());

			List<Resource> result = retrieve(String.format(
					"SELECT id,Name,IDNumber__c,FirstName__c,"
							+ "LastName__c,MiddleName__c,SickLeaveEntitlement__c,"
							+ "SickLeavesUsed__c,VacationLeavesUsed__c,VacationLeaveEntitlement__c,"
							+ "ImmediateManagerName__c, ImmediateManagerEmail__c,"
							+ "(SELECT Name, LeaveType__c,StartDate__c,EndDate__c,DaysOnLeave__c,Reason__c,Halfday__c,LeaveStatus__c,"
							+ "CreatedDate FROM LeaveRequest__r WHERE StartDate__c >= %s"
							+ " AND EndDate__c <= %s AND id != '%s'"
							+ " ORDER BY CreatedDate DESC)"
							+ " FROM Resource__c WHERE Id = '%s'",
					startDate, endDate, leave.getId(), id), DAOTABLE);

			if (!result.isEmpty()) {
				return result.get(0);
			}
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

}
